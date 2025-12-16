package com.patient.Repository;

import com.patient.Entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepo extends JpaRepository<PatientEntity, Integer> {

//    public PatientEntity findByEmail(String email);
    public PatientEntity findByPhoneNumber(long phoneNumber);

    //public List<PatientEntity> findByMedicalCondition(String medicalCondition);
}