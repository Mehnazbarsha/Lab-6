package com.example.lab6.service;

import com.example.lab6.model.PasswordQualityResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PasswordServiceTest {

    private PasswordService passwordService;

    @BeforeEach
    void setUp() {
        passwordService = new PasswordService();
    }

    @Test
    void testStrongPassword() {
        String password = "StrongP@ssw0rd!";
        PasswordQualityResponse response = passwordService.evaluatePassword(password);
        assertEquals("STRONG", response.getQuality());
        assertTrue(response.getScore() >= 80);
    }

    @Test
    void testWeakPassword() {
        String password = "pass";
        PasswordQualityResponse response = passwordService.evaluatePassword(password);
        assertEquals("VERY_WEAK", response.getQuality());
    }

    @Test
    void testEmptyPassword() {
        String password = "";
        PasswordQualityResponse response = passwordService.evaluatePassword(password);
        assertEquals("INVALID", response.getQuality());
        assertEquals(0, response.getScore());
    }
}