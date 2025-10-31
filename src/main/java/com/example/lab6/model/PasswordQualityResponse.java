package com.example.lab6.model;

public class PasswordQualityResponse {
    private String quality;
    private int score;
    private String feedback;

    public PasswordQualityResponse() {}

    public PasswordQualityResponse(String quality, int score, String feedback) {
        this.quality = quality;
        this.score = score;
        this.feedback = feedback;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}