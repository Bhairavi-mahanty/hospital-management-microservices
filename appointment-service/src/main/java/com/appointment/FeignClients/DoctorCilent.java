package com.appointment.FeignClients;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient (name = "doctor-service", url = "http://localhost:7071")
public interface DoctorCilent {

    @GetMapping("/api/doctor/{doctorId}")
    Object getDoctorById (@PathVariable Integer doctorId );
}
