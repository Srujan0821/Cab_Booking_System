package com.example.cabbookingsystem.controller;

import com.example.cabbookingsystem.model.Ride;
import com.example.cabbookingsystem.service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rides")
public class RideController {

    @Autowired
    private RideService rideService;

    @PostMapping("/book")
    public Ride bookRide(@RequestBody Ride ride) {
        return rideService.bookRide(ride);
    }

    @PutMapping("/status/{id}")
    public Ride updateRideStatus(@PathVariable Long id, @RequestParam String status) {
        return rideService.updateRideStatus(id, status);
    }

    @GetMapping("/user/{userId}")
    public List<Ride> getUserRides(@PathVariable Long userId) {
        return rideService.getUserRides(userId);
    }
}
