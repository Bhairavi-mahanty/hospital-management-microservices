package com.patient.Controller;

import com.patient.DTO.PatientRequestDTO;
import com.patient.DTO.PatientResponseDTO;
import com.patient.DTO.PatientUpdateRequest;
import com.patient.Exception.PatientException;
import com.patient.Service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

    @Autowired
    PatientService patientService;

    @PostMapping("/register")
    public ResponseEntity<String> createPatient(@Valid @RequestBody PatientRequestDTO patDTO) throws PatientException {
        String response = patientService.createPatient(patDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/status")
    public ResponseEntity<String> statusCheck(){
        return new ResponseEntity<>("patientService is up and running" , HttpStatus.OK);
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<PatientResponseDTO> getPatientById(@PathVariable Integer patientId) throws IllegalArgumentException {
        PatientResponseDTO patientResponseDTO = patientService.getPatientById(patientId);
        return new ResponseEntity<>(patientResponseDTO, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PatientResponseDTO>> getAllPatients() throws NullPointerException {
        List<PatientResponseDTO> response = patientService.getAllPatients();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

//    @GetMapping("/condition/")
//    public ResponseEntity<List<PatientResponseDTO>> getPatientByMedicalCondition(@RequestParam String medicalCondition) throws NullPointerException {
//        List<PatientResponseDTO> response = patientService.getPatientByMedicalCondition(medicalCondition);
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
//
//    @GetMapping("/email/")
//    public ResponseEntity<PatientResponseDTO> getPatientByEmail(@RequestParam String email) throws NullPointerException {
//        PatientResponseDTO response = patientService.getByEmail(email);
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }

    @PutMapping("/update")
    public ResponseEntity<String> updatePatient(
            @RequestParam long id,
            @RequestBody PatientUpdateRequest request) {

        String response = patientService.updateDetails(id, request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getBynum")
    public ResponseEntity<PatientResponseDTO> getByNumber(@RequestParam long number){
        PatientResponseDTO responseDTO = patientService.getByPhoneNumber(number);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
}