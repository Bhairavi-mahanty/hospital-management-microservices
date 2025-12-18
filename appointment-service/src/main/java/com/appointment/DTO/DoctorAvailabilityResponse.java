package com.appointment.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DoctorAvailabilityResponse {

    @JsonProperty("availableFrom")
    private LocalTime availableFrom;
    @JsonProperty("availableTo")
    private LocalTime availableTo;
    @JsonProperty("slotDuration")
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

    @Override
    public String toString() {
        return "DoctorAvailabilityResponse{" +
                "availableFrom=" + availableFrom +
                ", availableTo=" + availableTo +
                ", slotDuration=" + slotDuration +
                '}';
    }
}
