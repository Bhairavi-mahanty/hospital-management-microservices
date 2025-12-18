package com.appointment.Service;

import com.appointment.DTO.AppointmentRequestDTO;
import com.appointment.DTO.AppointmentResponseDTO;
import com.appointment.DTO.DoctorAvailabilityResponse;
import com.appointment.Entity.AppointmentEntity;
import com.appointment.Exception.AppointmentException;
import com.appointment.FeignClients.DoctorCilent;
import com.appointment.FeignClients.PatientClient;
import com.appointment.Repository.AppointmentRepo;
import com.appointment.Utility.AppointmentStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService{

    @Autowired
    AppointmentRepo appointmentRepo;
    @Autowired
    DoctorCilent doctorCilent;
    @Autowired
    PatientClient patientClient;



    @Override
    public String createAppointment(AppointmentRequestDTO request) throws AppointmentException {

        AppointmentEntity appointmentEntity = new AppointmentEntity();

        if(request.getAppointmentDate().isBefore(java.time.LocalDate.now())){
            throw new AppointmentException("Appointment date cannot be in the past");
        }

        DoctorAvailabilityResponse availability = doctorCilent.getDoctorAvailability(request.getDoctorId());

        if(request.getAppointmentTime().isBefore(availability.getAvailableFrom()) || request.getAppointmentTime().isAfter(availability.getAvailableTo())){
            throw new AppointmentException("Doctor is available only from "
                    + availability.getAvailableFrom()
                    + " to "
                    + availability.getAvailableTo());
        }
        long requestedDuration = Duration.between( request.getAppointmentTime(),request.getAppointmentEndTime()).toMinutes();
         if(requestedDuration> availability.getSlotDuration()){
            throw new AppointmentException("Appointment Duration should not exceed the doctor slot duration ");
        }
        if(appointmentRepo.existsOverlappingAppointment(request.getDoctorId(), request.getAppointmentDate(), request.getAppointmentTime(), request.getAppointmentEndTime())){
            throw new AppointmentException("doctor is in another appointment");
        }

        appointmentEntity.setAppointmentDate(request.getAppointmentDate());
        appointmentEntity.setDoctorId(request.getDoctorId());
        appointmentEntity.setAppointmentTime(request.getAppointmentTime());
        appointmentEntity.setPatientId(request.getPatientId());
        appointmentEntity.setAppointmentEndTime(request.getAppointmentEndTime());
        appointmentEntity.setStatus(AppointmentStatus.BOOKED);
        appointmentRepo.save(appointmentEntity);

        return "Appointment booked successfully";
    }

    @Override
    public String CancelAppointment(Integer appointmentId) throws AppointmentException {
        AppointmentEntity appointmentEntity = appointmentRepo.findById(appointmentId)
                .orElseThrow(() -> new AppointmentException("No appointments found with this Id"));
        appointmentEntity.setStatus(AppointmentStatus.CANCELLED);
        appointmentRepo.save(appointmentEntity);
        return "appointment cancelled with the Id"+ appointmentEntity.getId();
    }

    @Override
    public List<AppointmentResponseDTO> getByDoctor(Integer doctorId) throws AppointmentException {
        List<AppointmentEntity> appointmentEntities =  appointmentRepo.findByDoctorId(doctorId);

        if(doctorCilent.getDoctorById(doctorId)==null){
            throw new AppointmentException("Doctor details are invalid");
        }
        if(appointmentEntities.isEmpty()){
            throw new AppointmentException("No appointments found with this doctorId");
        }

        List<AppointmentResponseDTO> responseDTO = new ArrayList<>();
        for(AppointmentEntity appointmentEntity : appointmentEntities){
            AppointmentResponseDTO appointmentResponseDTO = new AppointmentResponseDTO();
            appointmentResponseDTO.setId(appointmentEntity.getId());
            appointmentResponseDTO.setAppointmentDate(appointmentEntity.getAppointmentDate());
            appointmentResponseDTO.setAppointmentTime(appointmentEntity.getAppointmentTime());
            appointmentResponseDTO.setDoctorId(appointmentEntity.getDoctorId());
            appointmentResponseDTO.setPatientId(appointmentEntity.getPatientId());
            appointmentResponseDTO.setStatus(appointmentEntity.getStatus());
            appointmentResponseDTO.setAppointmentEndTime(appointmentEntity.getAppointmentEndTime());
            responseDTO.add(appointmentResponseDTO);
        }

        return responseDTO;
    }
}
