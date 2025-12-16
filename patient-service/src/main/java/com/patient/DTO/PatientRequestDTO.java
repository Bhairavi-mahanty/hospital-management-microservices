package com.patient.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class PatientRequestDTO {

    @NotBlank(message = "Name is required")
    private String patientName;
    @NotBlank(message = "gender is required")
    private String gender;
    @Min(value = 0, message = "Age cannot be negative")
    private int age;
    @NotBlank(message = "BloodGroup is required")
    private String bloodGroup;
    @Min(value = 1000000000, message = "Phone number must be 10 digits")
    private long phoneNumber;

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }



    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "PatientRequestDTO{" +
                "patientName='" + patientName + '\'' +
                ", medicalCondition='" + gender + '\'' +
                ", age=" + age +
                ", email='" + bloodGroup + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}