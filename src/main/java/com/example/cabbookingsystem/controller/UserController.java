package com.example.cabbookingsystem.controller;

import com.example.cabbookingsystem.exception.CustomException;
import com.example.cabbookingsystem.model.User;
import com.example.cabbookingsystem.security.JwtUtil;
import com.example.cabbookingsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestParam String email, @RequestParam String passwordHash) {
        User user = userService.loginUser(email, passwordHash);
        if (user != null) {
            String token = jwtUtil.generateToken(user.getEmail());
            return ResponseEntity.ok(Collections.singletonMap("token", token));
        } else {
            throw new CustomException("Invalid credentials");
        }
    }


    @GetMapping("/{userID}")
    public User getUserProfile(@PathVariable Long userID) {
        return userService.getUserProfile(userID);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
