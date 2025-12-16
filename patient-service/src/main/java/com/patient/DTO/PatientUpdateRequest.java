package com.patient.DTO;

public class PatientUpdateRequest {

    private int age;
    private long phone;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "PatientUpdateRequest{" +
                "age=" + age +
                ", phone=" + phone +
                '}';
    }
}