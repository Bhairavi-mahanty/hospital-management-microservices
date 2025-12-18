package com.doctor.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;

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
    @NotNull (message = "Available from is required")
    private LocalTime availableFrom;  // e.g. 10:00
    @NotNull (message = "Available to is required")
    private LocalTime availableTo;    // e.g. 18:00
    @Min(value = 15, message = "Slot duration cannot be negative")
    private Integer slotDuration;      // in minutes (e.g. 15)

    public LocalTime getAvailableFrom() {
        return availableFrom;
    }

    public void setAvailableFrom(LocalTime availableFrom) {
        this.availableFrom = availableFrom;
    }

    public LocalTime getAvailableTo() {
        return availableTo;
    }

    public void setAvailableTo(LocalTime availableTo) {
        this.availableTo = availableTo;
    }

    public Integer getSlotDuration() {
        return slotDuration;
    }

    public void setSlotDuration(Integer slotDuration) {
        this.slotDuration = slotDuration;
    }

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
                ", availableFrom=" + availableFrom +
                ", availableTo=" + availableTo +
                ", slotDuration=" + slotDuration +
                '}';
    }
}
