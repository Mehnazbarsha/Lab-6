package com.example.lab6.service;

import com.example.lab6.model.PasswordQualityResponse;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {

    public PasswordQualityResponse evaluatePassword(String password) {
        if (password == null || password.isEmpty()) {
            return new PasswordQualityResponse("INVALID", 0, "Password cannot be empty");
        }

        int score = 0;
        StringBuilder feedback = new StringBuilder();

        if (password.length() >= 8) {
            score += 25;
        } else {
            feedback.append("Password should be at least 8 characters. ");
        }

        if (password.length() >= 12) {
            score += 10;
        }

        if (password.matches(".*[A-Z].*")) {
            score += 20;
        } else {
            feedback.append("Add uppercase letters. ");
        }

        if (password.matches(".*[a-z].*")) {
            score += 20;
        } else {
            feedback.append("Add lowercase letters. ");
        }

        if (password.matches(".*\\d.*")) {
            score += 15;
        } else {
            feedback.append("Add numbers. ");
        }

        if (password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*")) {
            score += 10;
        } else {
            feedback.append("Add special characters. ");
        }

        String quality;
        if (score >= 80) {
            quality = "STRONG";
            feedback.setLength(0);
            feedback.append("Excellent password!");
        } else if (score >= 60) {
            quality = "MODERATE";
        } else if (score >= 40) {
            quality = "WEAK";
        } else {
            quality = "VERY_WEAK";
        }

        return new PasswordQualityResponse(quality, score, feedback.toString().trim());
    }
}