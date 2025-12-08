package com.doctor.Repository;

import com.doctor.Entity.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface DoctorRepo extends JpaRepository<DoctorEntity, Integer> {

    public DoctorEntity findByEmail(String email);
    public DoctorEntity findByPhoneNumber(long phoneNumber);
    public List<DoctorEntity> findBySpecialization(String specialization);

}
