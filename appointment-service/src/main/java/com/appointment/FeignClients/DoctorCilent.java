package com.appointment.FeignClients;


import com.appointment.DTO.DoctorAvailabilityResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient (name = "doctor-service")
public interface DoctorCilent {

    @GetMapping("/api/doctor/{doctorId}")
    Object getDoctorById (@PathVariable Integer doctorId );

    @GetMapping("/api/doctor/{doctorId}/availability")
    DoctorAvailabilityResponse getDoctorAvailability(@PathVariable Integer doctorId);
}
