package com.patient.Service;

import com.patient.DTO.PatientRequestDTO;
import com.patient.DTO.PatientResponseDTO;
import com.patient.DTO.PatientUpdateRequest;
import com.patient.Exception.PatientException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PatientService {
    public String createPatient(PatientRequestDTO patDTO) throws IllegalArgumentException;

    public PatientResponseDTO getPatientById(Integer patientId) throws IllegalArgumentException;

    public List<PatientResponseDTO> getAllPatients() throws NullPointerException;

    //public List<PatientResponseDTO> getPatientByMedicalCondition(String medicalCondition) throws NullPointerException;

   // public PatientResponseDTO getByEmail(String email) throws NullPointerException;

    public String updateDetails(long Id, PatientUpdateRequest payload) throws NullPointerException;

    public PatientResponseDTO getByPhoneNumber (long phone) throws NullPointerException;
}