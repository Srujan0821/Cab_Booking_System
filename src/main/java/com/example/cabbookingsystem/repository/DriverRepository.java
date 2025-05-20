package com.example.cabbookingsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cabbookingsystem.model.Driver;

public interface DriverRepository extends JpaRepository<Driver, Long> {
    List<Driver> findByStatus(String status);
}