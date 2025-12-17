package com.appointment.Controller;

import com.appointment.DTO.AppointmentRequestDTO;
import com.appointment.Service.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @PostMapping("/newAppointment")
    public ResponseEntity<String> newAppoint(@Valid @RequestBody AppointmentRequestDTO requestDTO){
        String response = appointmentService.createAppointment(requestDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @PostMapping("/cancel")
    public ResponseEntity<String> cancelAppointment(@RequestParam Integer appointmentId){
        String response = appointmentService.CancelAppointment(appointmentId);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @GetMapping("/getByDoctor")
    public ResponseEntity<?> getByDoctor(@RequestParam Integer doctorId){
        return new ResponseEntity<>(appointmentService.getByDoctor(doctorId), HttpStatus.OK);
    }
}
