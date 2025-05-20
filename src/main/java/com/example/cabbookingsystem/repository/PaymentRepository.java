package com.example.cabbookingsystem.repository;

import com.example.cabbookingsystem.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByRide_RideID(Long rideId); // Return a list of payments for a ride
}