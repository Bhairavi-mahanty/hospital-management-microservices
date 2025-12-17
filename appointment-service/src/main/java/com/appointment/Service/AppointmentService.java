package com.appointment.Service;


import com.appointment.DTO.AppointmentRequestDTO;
import com.appointment.DTO.AppointmentResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AppointmentService {

    public String createAppointment(AppointmentRequestDTO request);

    public String CancelAppointment(Integer appointmentId);

    public List<AppointmentResponseDTO> getByDoctor(Integer doctorId);



}
