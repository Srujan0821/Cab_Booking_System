package com.example.cabbookingsystem.service;

import com.example.cabbookingsystem.model.Payment;
import com.example.cabbookingsystem.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment processPayment(Payment payment) {
        payment.setTimestamp(LocalDateTime.now());
        payment.setStatus("paid");
        return paymentRepository.save(payment);
    }

    public Payment getPaymentReceipt(Long rideID) {
        return paymentRepository.findByRide_RideID(rideID);  // Updated method name
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }
}