package com.appointment.Service;

import com.appointment.DTO.AppointmentRequestDTO;
import com.appointment.DTO.AppointmentResponseDTO;
import com.appointment.Entity.AppointmentEntity;
import com.appointment.FeignClients.DoctorCilent;
import com.appointment.FeignClients.PatientClient;
import com.appointment.Repository.AppointmentRepo;
import com.appointment.Utility.AppointmentStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public String createAppointment(AppointmentRequestDTO request) {

        AppointmentEntity appointmentEntity = new AppointmentEntity();
        if(patientClient.getPatientById(request.getPatientId())==null){
            throw new RuntimeException("Patient details are invalid");
        }
        if(doctorCilent.getDoctorById(request.getDoctorId())==null){
            throw new RuntimeException("Doctor details are invalid");
        }
        if(request.getAppointmentDate().isBefore(java.time.LocalDate.now())){
            throw new RuntimeException("Appointment date cannot be in the past");
        }
        appointmentEntity.setAppointmentDate(request.getAppointmentDate());
        appointmentEntity.setDoctorId(request.getDoctorId());
        appointmentEntity.setAppointmentTime(request.getAppointmentTime());
        appointmentEntity.setPatientId(request.getPatientId());
        appointmentEntity.setStatus(AppointmentStatus.BOOKED);
        appointmentRepo.save(appointmentEntity);

        return "Appointment booked successfully";
    }

    @Override
    public String CancelAppointment(Integer appointmentId) {
        AppointmentEntity appointmentEntity = appointmentRepo.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("No appointments found with this Id"));
        appointmentEntity.setStatus(AppointmentStatus.CANCELLED);
        appointmentRepo.save(appointmentEntity);
        return "appointment cancelled with the Id"+ appointmentEntity.getId();
    }

    @Override
    public List<AppointmentResponseDTO> getByDoctor(Integer doctorId) {
        List<AppointmentEntity> appointmentEntities =  appointmentRepo.findByDoctorId(doctorId);

        if(doctorCilent.getDoctorById(doctorId)==null){
            throw new RuntimeException("Doctor details are invalid");
        }
        if(appointmentEntities.isEmpty()){
            throw new RuntimeException("No appointments found with this doctorId");
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
            responseDTO.add(appointmentResponseDTO);
        }

        return responseDTO;
    }
}
