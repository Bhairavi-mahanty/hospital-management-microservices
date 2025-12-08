package com.doctor.DTO;

public class DoctorUpdateRequest {

    private String email;
    private long phone;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "DoctorUpdateRequest{" +
                "email='" + email + '\'' +
                ", phone=" + phone +
                '}';
    }
}
