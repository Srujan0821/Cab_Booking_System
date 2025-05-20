package com.example.cabbookingsystem.model;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Ride {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rideID;

    private Long userID;
    private Long driverID;

    private String pickupLocation;
    private String dropoffLocation;
    private BigDecimal fare;
    private String status; // e.g., booked, ongoing, completed

    // Getters and Setters

    public Long getRideID() {
        return rideID;
    }

    public void setRideID(Long rideID) {
        this.rideID = rideID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getFare() {
        return fare;
    }

    public void setFare(BigDecimal fare) {
        this.fare = fare;
    }

    public String getDropoffLocation() {
        return dropoffLocation;
    }

    public void setDropoffLocation(String dropoffLocation) {
        this.dropoffLocation = dropoffLocation;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public Long getDriverID() {
        return driverID;
    }

    public void setDriverID(Long driverID) {
        this.driverID = driverID;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }
}
