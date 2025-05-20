package com.example.cabbookingsystem.controller;

import com.example.cabbookingsystem.exception.CustomException;
import com.example.cabbookingsystem.model.User;
import com.example.cabbookingsystem.security.JwtUtil;
import com.example.cabbookingsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));
        User registeredUser = userService.registerUser(user);
        return ResponseEntity.ok(Collections.singletonMap("message", "User registered successfully"));
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestParam String email, @RequestParam String password) {
        User user = userService.getUserByEmail(email);
        if (user != null && passwordEncoder.matches(password, user.getPasswordHash())) {
            String token = jwtUtil.generateToken(user.getEmail());
            return ResponseEntity.ok(Collections.singletonMap("token", token));
        } else {
            throw new CustomException("Invalid credentials");
        }
    }

    @GetMapping("/profile")
    public ResponseEntity<?> getUserProfile(@RequestHeader("Authorization") String token) {
        try {
            String email = jwtUtil.extractUsername(token.substring(7));
            User user = userService.getUserByEmail(email);
            if (user != null) {
                // Create a new object to avoid exposing sensitive fields
                User responseUser = new User();
                responseUser.setUserID(user.getUserID());
                responseUser.setName(user.getName());
                responseUser.setEmail(user.getEmail());
                responseUser.setPhone(user.getPhone());
                responseUser.setCreatedAt(user.getCreatedAt());
                return ResponseEntity.ok(responseUser);
            } else {
                throw new CustomException("User not found");
            }
        } catch (Exception e) {
            throw new CustomException("Unauthorized: Invalid token");
        }
    }

    @PutMapping("/profile")
    public ResponseEntity<?> updateUserProfile(@RequestHeader("Authorization") String token, @RequestBody User updatedUser) {
        try {
            String email = jwtUtil.extractUsername(token.substring(7));
            User user = userService.getUserByEmail(email);
            if (user != null) {
                user.setName(updatedUser.getName());
                user.setPhone(updatedUser.getPhone());
                userService.updateUser(user);
                return ResponseEntity.ok(Collections.singletonMap("message", "Profile updated successfully"));
            } else {
                throw new CustomException("User not found");
            }
        } catch (Exception e) {
            throw new CustomException("Unauthorized: Invalid token");
        }
    }
}