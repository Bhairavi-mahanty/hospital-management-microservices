package com.appointment.Repository;

import com.appointment.Entity.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepo extends JpaRepository<AppointmentEntity,Integer> {
}
