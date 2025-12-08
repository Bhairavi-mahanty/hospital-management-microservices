package com.doctor.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class DoctorRequestDTO {

    @NotBlank ( message = "Name is required")
    private String doctorName;
    @NotBlank (message = "Specialization is required")
    private String specialization;
    @Min(value = 0, message = "Experience cannot be in negative years")
    private float  experience;
    @Email(message = "Email is not valid")
    private String email;
    @Min(value = 1000000000, message = "Phone number must be 10 digits")
    private long   phoneNumber;

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public float getExperience() {
        return experience;
    }

    public void setExperience(float experience) {
        this.experience = experience;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "DoctorRequestDTO{" +
                "doctorName='" + doctorName + '\'' +
                ", specialization='" + specialization + '\'' +
                ", experience=" + experience +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
