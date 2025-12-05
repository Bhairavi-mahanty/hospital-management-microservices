package com.doctor.Service;

import com.doctor.DTO.DoctorDTO;
import com.doctor.Entity.DoctorEntity;
import com.doctor.Repository.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    DoctorRepo doctorRepo;

    @Override
    public String createDoctor(DoctorDTO doctorDTO) {

        DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setDoctorName(doctorDTO.getDoctorName());
        doctorEntity.setSpecialization(doctorDTO.getSpecialization());
        doctorEntity.setEmail(doctorDTO.getEmail());
        doctorEntity.setExperience(doctorDTO.getExperience());
        doctorEntity.setPhoneNumber(doctorDTO.getPhoneNumber());
        doctorRepo.save(doctorEntity);

        return doctorEntity.getDoctorName()+ " Registered successfully with the ID: "+doctorEntity.getDoctorId();
    }
}
