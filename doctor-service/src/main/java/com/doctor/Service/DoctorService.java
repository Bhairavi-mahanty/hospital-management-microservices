package com.doctor.Service;

import com.doctor.DTO.DoctorDTO;
import com.doctor.Entity.DoctorEntity;
import org.springframework.stereotype.Service;

@Service
public interface DoctorService {
    public String createDoctor(DoctorDTO doctorDTO);
}
