package com.appointment.Service;


import com.appointment.DTO.AppointmentRequestDTO;
import com.appointment.DTO.AppointmentResponseDTO;
import com.appointment.Exception.AppointmentException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AppointmentService {

    public String createAppointment(AppointmentRequestDTO request) throws AppointmentException;

    public String CancelAppointment(Integer appointmentId) throws AppointmentException;

    public List<AppointmentResponseDTO> getByDoctor(Integer doctorId) throws AppointmentException;



}
