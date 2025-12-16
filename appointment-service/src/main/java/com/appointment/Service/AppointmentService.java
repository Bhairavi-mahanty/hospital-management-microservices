package com.appointment.Service;


import com.appointment.DTO.AppointmentRequestDTO;
import com.appointment.DTO.AppointmentResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface AppointmentService {

    public String createAppointment(AppointmentRequestDTO request);

}
