package com.example.cabbookingsystem.controller;

import com.example.cabbookingsystem.exception.CustomException;
import com.example.cabbookingsystem.model.Driver;
import com.example.cabbookingsystem.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @PostMapping("/register")
    public ResponseEntity<?> registerDriver(@RequestBody Driver driver) {
        Driver registeredDriver = driverService.registerDriver(driver);
        return ResponseEntity.ok(registeredDriver);
    }

    @GetMapping("/available")
    public ResponseEntity<List<Driver>> getAvailableDrivers() {
        List<Driver> availableDrivers = driverService.getAvailableDrivers();
        return ResponseEntity.ok(availableDrivers);
    }

    @PutMapping("/status/{id}")
    public ResponseEntity<?> updateDriverStatus(@PathVariable Long id, @RequestParam String status) {
        Driver updatedDriver = driverService.updateDriverStatus(id, status);
        return ResponseEntity.ok(updatedDriver);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDriverById(@PathVariable Long id) {
        Driver driver = driverService.getDriverById(id);
        if (driver == null) {
            throw new CustomException("Driver not found with ID: " + id);
        }
        return ResponseEntity.ok(driver);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDriver(@PathVariable Long id) {
        driverService.deleteDriver(id);
        return ResponseEntity.ok("Driver deleted successfully");
    }
}