package com.patient.Service;

import com.patient.DTO.PatientRequestDTO;
import com.patient.DTO.PatientResponseDTO;
import com.patient.DTO.PatientUpdateRequest;
import com.patient.Entity.PatientEntity;
import com.patient.Exception.PatientException;
import com.patient.Repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepo patientRepo;

    @Override
    public String createPatient(PatientRequestDTO patDTO) throws IllegalArgumentException {

        if(patientRepo.findByPhoneNumber(patDTO.getPhoneNumber()) != null){
            throw new IllegalArgumentException("Phone number already exists");
        }

        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setPatientName(patDTO.getPatientName());
        patientEntity.setGender(patDTO.getGender());
        patientEntity.setBloodGroup(patDTO.getBloodGroup());
        patientEntity.setAge(patDTO.getAge());
        patientEntity.setPhoneNumber(patDTO.getPhoneNumber());
        patientRepo.save(patientEntity);

        return patientEntity.getPatientName()+ " Registered successfully with the ID: "+patientEntity.getPatientId();
    }

    @Override
    public PatientResponseDTO getPatientById(Integer patientId) throws IllegalArgumentException {
        PatientEntity patientEntity = patientRepo.findById(patientId).orElseThrow(() -> new IllegalArgumentException("Patient not found with the Given ID"));
        PatientResponseDTO patientResponseDTO = new PatientResponseDTO();
        patientResponseDTO.setPatientId(patientEntity.getPatientId());
        patientResponseDTO.setPatientName(patientEntity.getPatientName());
        patientResponseDTO.setGender(patientEntity.getGender());
        patientResponseDTO.setAge(patientEntity.getAge());
        patientResponseDTO.setBloodGroup(patientEntity.getBloodGroup());
        patientResponseDTO.setPhoneNumber(patientEntity.getPhoneNumber());
        return patientResponseDTO;
    }

    @Override
    public List<PatientResponseDTO> getAllPatients() throws NullPointerException {
        List<PatientEntity> patientEntities = patientRepo.findAll();
        if(patientEntities.isEmpty()){
            throw new NullPointerException("No patients found");
        }
        return patientEntities.stream().map(this::convertToDTO).toList();
    }

    public PatientResponseDTO convertToDTO(PatientEntity patientEntity) {
        PatientResponseDTO patientResponseDTO = new PatientResponseDTO();
        patientResponseDTO.setPatientId(patientEntity.getPatientId());
        patientResponseDTO.setPatientName(patientEntity.getPatientName());
        patientResponseDTO.setBloodGroup(patientEntity.getBloodGroup());
        patientResponseDTO.setAge(patientEntity.getAge());
        patientResponseDTO.setGender(patientEntity.getGender());
        patientResponseDTO.setPhoneNumber(patientEntity.getPhoneNumber());
        return patientResponseDTO;
    }


//    public List<PatientResponseDTO> getPatientByMedicalCondition(String medicalCondition) throws NullPointerException {
//        List<PatientEntity> patientEntities = patientRepo.findByMedicalCondition(medicalCondition);
//        if(patientEntities.isEmpty()){
//            throw new NullPointerException("No patients found with the given medical condition");
//        }
//        return patientEntities.stream().map(this::convertToDTO).toList();
//    }

//    @Override
//    public PatientResponseDTO getByEmail(String email) throws NullPointerException{
//        PatientEntity patientEntity = patientRepo.findByEmail(email);
//        if(patientEntity== null) {
//            throw new NullPointerException("No patient found with the given email");
//        }
//        return convertToDTO(patientEntity);
//    }
    @Override
    public String updateDetails(long Id, PatientUpdateRequest payload) throws NullPointerException {
        PatientEntity patientEntity = patientRepo.findById((int) Id).orElseThrow(()-> new NullPointerException("No patient found with this id"));
        patientEntity.setPhoneNumber(payload.getPhone());
        patientRepo.save(patientEntity);
        return "Patient details updated successfully" + patientEntity;
    }

    @Override
    public PatientResponseDTO getByPhoneNumber(long phone) throws NullPointerException {
        PatientEntity patientEntity = patientRepo.findByPhoneNumber(phone);
        if(patientEntity==null){
            throw new NullPointerException("No patient found with this phoneNUmber");
        }
        return convertToDTO(patientEntity) ;
    }


}