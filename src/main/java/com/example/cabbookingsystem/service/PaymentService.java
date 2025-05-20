package com.example.cabbookingsystem.service;

import com.example.cabbookingsystem.exception.CustomException;
import com.example.cabbookingsystem.model.Payment;
import com.example.cabbookingsystem.model.Ride;
import com.example.cabbookingsystem.model.User;
import com.example.cabbookingsystem.repository.PaymentRepository;
import com.example.cabbookingsystem.repository.RideRepository;
import com.example.cabbookingsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private RideRepository rideRepository;

    @Autowired
    private UserRepository userRepository;

    public Payment processPayment(Payment payment) {
        // Check if a payment already exists for the ride
        List<Payment> existingPayments = paymentRepository.findByRide_RideID(payment.getRide().getRideID());
        if (!existingPayments.isEmpty()) {
            throw new CustomException("A payment already exists for ride ID: " + payment.getRide().getRideID());
        }

        // Fetch the ride details
        Ride ride = rideRepository.findById(payment.getRide().getRideID())
                .orElseThrow(() -> new CustomException("Ride not found with ID: " + payment.getRide().getRideID()));

        // Fetch the user details
        User user = userRepository.findById(payment.getUser().getUserID())
                .orElseThrow(() -> new CustomException("User not found with ID: " + payment.getUser().getUserID()));

        // Set the fetched ride and user objects
        payment.setRide(ride);
        payment.setUser(user);

        // Validate the payment amount
        if (payment.getAmount() == null || payment.getAmount().compareTo(new java.math.BigDecimal("0")) <= 0) {
            throw new CustomException("Invalid payment amount");
        }

        payment.setTimestamp(LocalDateTime.now());
        payment.setStatus("paid");
        return paymentRepository.save(payment);
    }

    public List<Payment> getPaymentReceipt(Long rideID) {
        List<Payment> payments = paymentRepository.findByRide_RideID(rideID);
        if (payments.isEmpty()) {
            throw new CustomException("No payments found for ride ID: " + rideID);
        }
        return payments;
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }
}