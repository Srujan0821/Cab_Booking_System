package com.example.cabbookingsystem.service;

import com.example.cabbookingsystem.model.Ride;
import com.example.cabbookingsystem.repository.RideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RideService {

    @Autowired
    private RideRepository rideRepository;

    public Ride bookRide(Ride ride) {
        ride.setStatus("booked");
        return rideRepository.save(ride);
    }

    public Ride updateRideStatus(Long rideID, String status) {
        Ride ride = rideRepository.findById(rideID).orElse(null);
        if (ride != null) {
            ride.setStatus(status);
            return rideRepository.save(ride);
        }
        return null;
    }

    public List<Ride> getUserRides(Long userID) {
        return rideRepository.findByUserID(userID);
    }
}
