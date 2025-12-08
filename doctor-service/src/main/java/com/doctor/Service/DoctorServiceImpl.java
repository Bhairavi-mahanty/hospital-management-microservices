package com.doctor.Service;

import com.doctor.DTO.DoctorRequestDTO;
import com.doctor.DTO.DoctorResponseDTO;
import com.doctor.Entity.DoctorEntity;
import com.doctor.Exception.DoctorException;
import com.doctor.Repository.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    DoctorRepo doctorRepo;

    @Override
    public String createDoctor(DoctorRequestDTO docDTO) throws IllegalArgumentException {


        if(doctorRepo.findByPhoneNumber(docDTO.getPhoneNumber()) != null){
            throw new IllegalArgumentException("Phone number already exists");
        }
         if(doctorRepo.findByEmail(docDTO.getEmail()) != null){
            throw new IllegalArgumentException("Email already exists");
        }
        DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setDoctorName(docDTO.getDoctorName());
        doctorEntity.setSpecialization(docDTO.getSpecialization());
        doctorEntity.setEmail(docDTO.getEmail());
        doctorEntity.setExperience(docDTO.getExperience());
        doctorEntity.setPhoneNumber(docDTO.getPhoneNumber());
        doctorRepo.save(doctorEntity);

        return doctorEntity.getDoctorName()+ " Registered successfully with the ID: "+doctorEntity.getDoctorId();
    }

    @Override
    public DoctorResponseDTO getDoctorById(Integer doctorId) throws IllegalArgumentException {
        DoctorEntity doctorEntity = doctorRepo.findById(doctorId).orElseThrow(() -> new IllegalArgumentException("Doctor not found with the Given ID"));
        DoctorResponseDTO doctorResponseDTO = new DoctorResponseDTO();
        doctorResponseDTO.setDoctorId(doctorEntity.getDoctorId());
        doctorResponseDTO.setDoctorName(doctorEntity.getDoctorName());
        doctorResponseDTO.setSpecialization(doctorEntity.getSpecialization());
        doctorResponseDTO.setExperience(doctorEntity.getExperience());
        doctorResponseDTO.setEmail(doctorEntity.getEmail());
        doctorResponseDTO.setPhoneNumber(doctorEntity.getPhoneNumber());
        return doctorResponseDTO;
    }

    @Override
    public List<DoctorResponseDTO> getAllDoctors() throws NullPointerException {
        List<DoctorEntity> doctorEntities = doctorRepo.findAll();
              if(doctorEntities.isEmpty()){
                throw new NullPointerException("No doctors found");
            }
            return doctorEntities.stream().map(this::convertToDTO).toList();
    }
          public DoctorResponseDTO convertToDTO(DoctorEntity doctorEntity) {
            DoctorResponseDTO doctorResponseDTO = new DoctorResponseDTO();
            doctorResponseDTO.setDoctorId(doctorEntity.getDoctorId());
            doctorResponseDTO.setDoctorName(doctorEntity.getDoctorName());
            doctorResponseDTO.setSpecialization(doctorEntity.getSpecialization());
            doctorResponseDTO.setExperience(doctorEntity.getExperience());
            doctorResponseDTO.setEmail(doctorEntity.getEmail());
            doctorResponseDTO.setPhoneNumber(doctorEntity.getPhoneNumber());
            return doctorResponseDTO;
        }

        @Override
        public List<DoctorResponseDTO> getDoctorBySpecialization(String specialization) throws NullPointerException {

        List<DoctorEntity> doctorEntities = doctorRepo.findBySpecialization(specialization);
        if(doctorEntities.isEmpty()){
            throw new NullPointerException("No doctors found with the given specialization");
        }
        return doctorEntities.stream().map(this::convertToDTO).toList();
    }

    @Override
    public DoctorResponseDTO getByEmail(String email) throws NullPointerException{
        DoctorEntity doctorEntity = doctorRepo.findByEmail(email);
            if(doctorEntity== null) {
                throw new NullPointerException("No doctor found with the given email");
            }
            return convertToDTO(doctorEntity);
    }

    @Override
    public String updateDetails(long Id, String email, long phone) throws NullPointerException {
        DoctorEntity doctorEntity = doctorRepo.findById((int) Id).orElseThrow(()-> new NullPointerException("No doctor found with this id"));
        doctorEntity.setEmail(email);
        doctorEntity.setPhoneNumber(phone);
        doctorRepo.save(doctorEntity);
        return "Doctor details updated successfully" + doctorEntity;
    }

//    @Override
//    public Map<String, List<DoctorResponseDTO>> getDoctorsGrpBySpecialization() {
//        List<DoctorEntity> doctorEntities = doctorRepo.findAll();
//        doctorEntities.stream().collect(Collectors.groupingBy(DoctorEntity::getSpecialization,Collectors.mapping
//                                              (this::convertToDTO,Collectors.toList())));
//        Map <String , List<DoctorResponseDTO>> stringListMap = new HashMap<>();
//
//
//        return Map.of();
//    }


}
