package com.example.cabbookingsystem.service;

import com.example.cabbookingsystem.exception.CustomException;
import com.example.cabbookingsystem.model.Driver;
import com.example.cabbookingsystem.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    public Driver registerDriver(Driver driver) {
        driver.setStatus("available");
        return driverRepository.save(driver);
    }

    public List<Driver> getAvailableDrivers() {
        return driverRepository.findByStatus("available");
    }

    public Driver updateDriverStatus(Long driverID, String status) {
        Driver driver = driverRepository.findById(driverID)
                .orElseThrow(() -> new CustomException("Driver not found with ID: " + driverID));
        driver.setStatus(status);
        return driverRepository.save(driver);
    }

    public Driver getDriverById(Long driverID) {
        return driverRepository.findById(driverID).orElseThrow(() -> new CustomException("Driver not found with ID: " + driverID));
    }

    public void deleteDriver(Long driverID) {
        Driver driver = driverRepository.findById(driverID).orElseThrow(() -> new CustomException("Driver not found with ID: " + driverID));
        driverRepository.delete(driver);
    }
}