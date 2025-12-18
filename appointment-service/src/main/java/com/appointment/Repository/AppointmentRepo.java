package com.appointment.Repository;

import com.appointment.Entity.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface AppointmentRepo extends JpaRepository<AppointmentEntity,Integer> {
    List<AppointmentEntity> findByDoctorId(Integer doctorId);

    @Query("""
    SELECT COUNT(a) > 0
    FROM AppointmentEntity a
    WHERE a.doctorId = :doctorId
      AND a.appointmentDate = :date
      AND (
            (:start < a.appointmentEndTime AND :end > a.appointmentTime)
          )
""")
    boolean existsOverlappingAppointment(
            @Param("doctorId") Integer doctorId,
            @Param("date") LocalDate date,
            @Param("start") LocalTime start,
            @Param("end") LocalTime end
    );


}
