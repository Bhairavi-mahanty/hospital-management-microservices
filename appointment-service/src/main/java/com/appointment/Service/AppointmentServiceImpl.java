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

        appointmentEntity.setAppointmentDate(request.getAppointmentDate());
        appointmentEntity.setDoctorId(request.getDoctorId());
        appointmentEntity.setAppointmentTime(request.getAppointmentTime());
        appointmentEntity.setPatientId(request.getPatientId());
        appointmentEntity.setStatus(AppointmentStatus.BOOKED);
        appointmentRepo.save(appointmentEntity);

        return "Appointment booked successfully";
    }
}
