package com.example.cabbookingsystem.repository;

import com.example.cabbookingsystem.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> findByToUserID(Long toUserID);
}
