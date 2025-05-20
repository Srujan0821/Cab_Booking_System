package com.example.cabbookingsystem.controller;

import com.example.cabbookingsystem.exception.CustomException;
import com.example.cabbookingsystem.model.Ride;
import com.example.cabbookingsystem.service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rides")
public class RideController {

    @Autowired
    private RideService rideService;

    @PostMapping("/book")
    public ResponseEntity<?> bookRide(@RequestBody Ride ride, Authentication authentication) {
        // Get the authenticated user's email from the token
        String userEmail = authentication.getName();
        Ride bookedRide = rideService.bookRide(ride, userEmail);
        return ResponseEntity.ok(bookedRide);
    }

    @PutMapping("/status/{id}")
    public ResponseEntity<?> updateRideStatus(@PathVariable Long id, @RequestParam String status) {
        Ride updatedRide = rideService.updateRideStatus(id, status);
        return ResponseEntity.ok(updatedRide);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Ride>> getUserRides(@PathVariable Long userId) {
        List<Ride> userRides = rideService.getUserRides(userId);
        return ResponseEntity.ok(userRides);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRideById(@PathVariable Long id) {
        Ride ride = rideService.getRideById(id);
        return ResponseEntity.ok(ride);
    }
}