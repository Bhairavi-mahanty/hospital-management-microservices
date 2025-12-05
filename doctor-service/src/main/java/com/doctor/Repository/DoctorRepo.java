package com.doctor.Repository;

import com.doctor.Entity.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DoctorRepo extends JpaRepository<DoctorEntity, Integer> {
}
