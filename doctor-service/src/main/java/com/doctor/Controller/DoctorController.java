package com.doctor.Controller;

import com.doctor.DTO.DoctorAvailabilityResponse;
import com.doctor.DTO.DoctorRequestDTO;
import com.doctor.DTO.DoctorResponseDTO;
import com.doctor.DTO.DoctorUpdateRequest;
import com.doctor.Exception.DoctorException;
import com.doctor.Service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {


    @Autowired
    DoctorService doctorService;


    @PostMapping("/register")
    public ResponseEntity<String> createDoctor(@Valid @RequestBody DoctorRequestDTO docDTO) throws DoctorException {
        String response = doctorService.createDoctor(docDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/status")
    public ResponseEntity<String> statusCheck(){
        return new ResponseEntity<>("doctorService is up and running" , HttpStatus.OK);
    }

    @GetMapping("/{doctorId}")
    public ResponseEntity<DoctorResponseDTO> getDoctorById(@PathVariable Integer doctorId) throws IllegalArgumentException {
        DoctorResponseDTO doctorResponseDTO = doctorService.getDoctorById(doctorId);
        return new ResponseEntity<>(doctorResponseDTO, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<DoctorResponseDTO>> getAllDoctors() throws NullPointerException {
        List<DoctorResponseDTO> response = doctorService.getAllDoctors();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/specialization/")
    public ResponseEntity<List<DoctorResponseDTO>> getDoctorBySpecialization(@RequestParam String specialization) throws NullPointerException {
        List<DoctorResponseDTO> response = doctorService.getDoctorBySpecialization(specialization);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/email/")
    public ResponseEntity<DoctorResponseDTO> getDoctorByEmail(@RequestParam String email) throws NullPointerException {
        DoctorResponseDTO response = doctorService.getByEmail(email);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateDoctor(
            @RequestParam long id,
            @RequestBody DoctorUpdateRequest request) {

//        String email = body.get("email").toString();
//        long phone = Long.parseLong(body.get("phone").toString());

        String response = doctorService.updateDetails(id, request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{doctorId}/availability")
    public ResponseEntity<DoctorAvailabilityResponse> getDoctorAvailability(@PathVariable Integer doctorId) throws IllegalArgumentException {
        return new ResponseEntity<>(doctorService.getDoctorAvailability(doctorId), HttpStatus.OK);
    }

}
