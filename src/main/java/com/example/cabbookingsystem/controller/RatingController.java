package com.example.cabbookingsystem.controller;

import com.example.cabbookingsystem.model.Rating;
import com.example.cabbookingsystem.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping
    public Rating submitRating(@RequestBody Rating rating) {
        return ratingService.submitRating(rating);
    }

    @GetMapping("/user/{userId}")
    public List<Rating> getUserRatings(@PathVariable Long userId) {
        return ratingService.getUserRatings(userId);
    }
}
