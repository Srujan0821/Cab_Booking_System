package com.example.cabbookingsystem.repository;

import com.example.cabbookingsystem.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    // Changed from findByRideRideID to findByRide_RideId
    Payment findByRide_RideID(Long rideId);
    
    // Alternative method using @Query
    /*
    @Query("SELECT p FROM Payment p WHERE p.ride.rideID = :rideId")
    Payment findPaymentByRideId(@Param("rideId") Long rideId);
    */
}