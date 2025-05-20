package com.example.cabbookingsystem.repository;

import com.example.cabbookingsystem.model.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RideRepository extends JpaRepository<Ride, Long> {
    List<Ride> findByUserID(Long userID);
}