package com.example.cabbookingsystem.service;

import com.example.cabbookingsystem.model.Rating;
import com.example.cabbookingsystem.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    public Rating submitRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    public List<Rating> getUserRatings(Long userID) {
        return ratingRepository.findByToUserID(userID);
    }
}
