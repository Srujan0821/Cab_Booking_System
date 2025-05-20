package com.example.cabbookingsystem.controller;

import com.example.cabbookingsystem.model.Payment;
import com.example.cabbookingsystem.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/process")
    public Payment processPayment(@RequestBody Payment payment) {
        return paymentService.processPayment(payment);
    }

    @GetMapping("/receipt/{rideId}")
    public Payment getPaymentReceipt(@PathVariable Long rideId) {
        return paymentService.getPaymentReceipt(rideId);
    }

    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }
}
