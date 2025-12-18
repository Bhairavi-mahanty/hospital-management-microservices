package com.doctor.DTO;

import java.time.LocalTime;

public class DoctorAvailabilityResponse {

    private Integer doctorId;
    private String doctorName;
    private LocalTime availableFrom;
    private LocalTime availableTo;
    private Integer slotDuration;

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

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    @Override
    public String toString() {
        return "DoctorAvailabilityResponse{" +
                "doctorId=" + doctorId +
                ", doctorName='" + doctorName + '\'' +
                ", availableFrom=" + availableFrom +
                ", availableTo=" + availableTo +
                ", slotDuration=" + slotDuration +
                '}';
    }


}
