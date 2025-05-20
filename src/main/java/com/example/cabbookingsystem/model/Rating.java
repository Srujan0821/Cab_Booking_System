package com.example.cabbookingsystem.model;

import jakarta.persistence.*;

@Entity
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ratingID;

    @ManyToOne
    @JoinColumn(name = "ride_id", nullable = false)
    private Ride ride; // Assuming there is a Ride entity

    @ManyToOne
    @JoinColumn(name = "from_user_id", nullable = false)
    private User fromUser; // Assuming there is a User entity

    private Long toUserID;
    private int score; // e.g., 1 to 5
    private String comments;

    // Getters and Setters

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Long getToUserID() {
        return toUserID;
    }

    public void setToUserID(Long toUserID) {
        this.toUserID = toUserID;
    }

    public Ride getRide() {
        return ride;
    }

    public void setRide(Ride ride) {
        this.ride = ride;
    }

    public User getFromUser() {
        return fromUser;
    }

    public void setFromUser(User fromUser) {
        this.fromUser = fromUser;
    }

    public Long getRatingID() {
        return ratingID;
    }

    public void setRatingID(Long ratingID) {
        this.ratingID = ratingID;
    }
}
