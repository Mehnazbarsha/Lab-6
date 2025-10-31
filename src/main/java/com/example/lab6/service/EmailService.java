package com.example.lab6.service;

import com.example.lab6.model.EmailValidationResponse;
import org.springframework.stereotype.Service;
import java.util.regex.Pattern;

@Service
public class EmailService {

    private static final String EMAIL_REGEX = 
        "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    public EmailValidationResponse validateEmail(String email) {
        if (email == null || email.isEmpty()) {
            return new EmailValidationResponse(false, "Email cannot be empty");
        }

        email = email.trim();
        StringBuilder feedback = new StringBuilder();

        if (!EMAIL_PATTERN.matcher(email).matches()) {
            feedback.append("Invalid email format. ");
        }

        if (email.contains(" ")) {
            feedback.append("Email cannot contain spaces. ");
        }

        long atCount = email.chars().filter(ch -> ch == '@').count();
        if (atCount != 1) {
            feedback.append("Email must contain exactly one @ symbol. ");
        }

        if (email.contains("@")) {
            String[] parts = email.split("@");
            if (parts.length == 2) {
                if (parts[0].isEmpty()) {
                    feedback.append("Username part cannot be empty. ");
                }
                if (parts[1].isEmpty() || !parts[1].contains(".")) {
                    feedback.append("Domain must contain a dot. ");
                }
            }
        }

        boolean isValid = feedback.length() == 0;
        String message = isValid ? "Valid email address" : feedback.toString().trim();

        return new EmailValidationResponse(isValid, message);
    }
}