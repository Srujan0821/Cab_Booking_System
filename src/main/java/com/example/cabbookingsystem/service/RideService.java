package com.example.cabbookingsystem.service;

import com.example.cabbookingsystem.exception.CustomException;
import com.example.cabbookingsystem.model.Driver;
import com.example.cabbookingsystem.model.Ride;
import com.example.cabbookingsystem.model.User;
import com.example.cabbookingsystem.repository.DriverRepository;
import com.example.cabbookingsystem.repository.RideRepository;
import com.example.cabbookingsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RideService {

    @Autowired
    private RideRepository rideRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DriverRepository driverRepository;

    public Ride bookRide(Ride ride, String userEmail) {
        // Fetch the user by email
        User user = userRepository.findByEmail(userEmail);
        if (user == null) {
            throw new CustomException("User not found with email: " + userEmail);
        }

        // Assign the user ID to the ride
        ride.setUserID(user.getUserID());

        // Find an available driver
        Driver availableDriver = driverRepository.findByStatus("available").stream().findFirst()
                .orElseThrow(() -> new CustomException("No available drivers at the moment"));

        // Assign the driver to the ride
        ride.setDriverID(availableDriver.getDriverID());
        ride.setStatus("booked");

        // Update the driver's status to "unavailable"
        availableDriver.setStatus("unavailable");
        driverRepository.save(availableDriver);

        // Save the ride
        return rideRepository.save(ride);
    }

    public Ride updateRideStatus(Long rideID, String status) {
        Ride ride = rideRepository.findById(rideID)
                .orElseThrow(() -> new CustomException("Ride not found with ID: " + rideID));
        ride.setStatus(status);

        // If the ride is completed, make the driver available again
        if ("completed".equalsIgnoreCase(status)) {
            Driver driver = driverRepository.findById(ride.getDriverID())
                    .orElseThrow(() -> new CustomException("Driver not found with ID: " + ride.getDriverID()));
            driver.setStatus("available");
            driverRepository.save(driver);
        }

        return rideRepository.save(ride);
    }

    public List<Ride> getUserRides(Long userID) {
        return rideRepository.findByUserID(userID);
    }

    public Ride getRideById(Long rideID) {
        return rideRepository.findById(rideID)
                .orElseThrow(() -> new CustomException("Ride not found with ID: " + rideID));
    }
}