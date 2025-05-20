package com.example.cabbookingsystem.service;

import com.example.cabbookingsystem.model.User;
import com.example.cabbookingsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        user.setCreatedAt(java.time.LocalDateTime.now());
        return userRepository.save(user);
    }

    public User loginUser(String email, String passwordHash) {
        return userRepository.findByEmailAndPasswordHash(email, passwordHash);
    }

    public User getUserProfile(Long userID) {
        return userRepository.findById(userID).orElse(null);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
