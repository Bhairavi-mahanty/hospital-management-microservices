package com.appointment.Repository;

import com.appointment.Entity.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepo extends JpaRepository<AppointmentEntity,Integer> {
    List<AppointmentEntity> findByDoctorId(Integer doctorId);
}
