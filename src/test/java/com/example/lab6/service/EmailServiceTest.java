package com.example.lab6.service;

import com.example.lab6.model.EmailValidationResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmailServiceTest {

    private EmailService emailService;

    @BeforeEach
    void setUp() {
        emailService = new EmailService();
    }

    @Test
    void testValidEmail() {
        String email = "test@example.com";
        EmailValidationResponse response = emailService.validateEmail(email);
        assertTrue(response.isValid());
    }

    @Test
    void testInvalidEmail() {
        String email = "invalidemail.com";
        EmailValidationResponse response = emailService.validateEmail(email);
        assertFalse(response.isValid());
    }
}