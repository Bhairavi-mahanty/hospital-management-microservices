package com.doctor.Service;

import com.doctor.DTO.DoctorAvailabilityResponse;
import com.doctor.DTO.DoctorRequestDTO;
import com.doctor.DTO.DoctorResponseDTO;
import com.doctor.DTO.DoctorUpdateRequest;
import com.doctor.Exception.DoctorException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface DoctorService {
    public String createDoctor(DoctorRequestDTO docDTO) throws DoctorException;

    public DoctorResponseDTO getDoctorById(Integer doctorId) throws IllegalArgumentException;

    public List<DoctorResponseDTO> getAllDoctors() throws NullPointerException;

    public List<DoctorResponseDTO> getDoctorBySpecialization(String specialization) throws NullPointerException;

    public DoctorResponseDTO getByEmail (String email) throws NullPointerException;

    //public Map<String , List<DoctorResponseDTO>> getDoctorsGrpBySpecialization () ;

    public String updateDetails (long Id, DoctorUpdateRequest payload) throws RuntimeException;

    public DoctorAvailabilityResponse getDoctorAvailability(Integer doctorId) throws IllegalArgumentException;
}
