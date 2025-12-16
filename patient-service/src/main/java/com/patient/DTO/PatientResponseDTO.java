package com.patient.DTO;

public class PatientResponseDTO {

    private Integer patientId;
    private String patientName;
    private String gender;
    private int age;
    private String bloodGroup;
    private long phoneNumber;

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "PatientEntity{" +
                "patientId='" + patientId + '\'' +
                ", patientName='" + patientName + '\'' +
                ", medicalCondition='" + gender + '\'' +
                ", age=" + age +
                ", email='" + bloodGroup + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}