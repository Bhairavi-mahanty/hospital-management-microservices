package com.appointment.FeignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "patient-service" )
public interface PatientClient {

    @GetMapping("/api/patient/{patientId}")
    Object getPatientById (@PathVariable Integer patientId);
}
