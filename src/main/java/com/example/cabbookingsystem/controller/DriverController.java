package com.example.cabbookingsystem.controller;

import com.example.cabbookingsystem.model.Driver;
import com.example.cabbookingsystem.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @PostMapping("/register")
    public Driver registerDriver(@RequestBody Driver driver) {
        return driverService.registerDriver(driver);
    }

    @GetMapping("/available")
    public List<Driver> getAvailableDrivers() {
        return driverService.getAvailableDrivers();
    }

    @PutMapping("/status/{id}")
    public Driver updateDriverStatus(@PathVariable Long id, @RequestParam String status) {
        return driverService.updateDriverStatus(id, status);
    }
}
