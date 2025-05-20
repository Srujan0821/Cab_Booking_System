package com.example.cabbookingsystem.repository;

import com.example.cabbookingsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmailAndPasswordHash(String email, String passwordHash);
}
