package com.doctor.Controller;

import com.doctor.DTO.DoctorDTO;
import com.doctor.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {


    @Autowired
    DoctorService doctorService;


    @PostMapping("/register")
    public ResponseEntity<String> createDoctor(@RequestBody DoctorDTO doctorDTO){
        String response = doctorService.createDoctor(doctorDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/status")
    public ResponseEntity<String> statusCheck(){
        return new ResponseEntity<>("doctorService is up and running" , HttpStatus.OK);
    }


}
