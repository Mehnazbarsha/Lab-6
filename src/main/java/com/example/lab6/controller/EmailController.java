package com.example.lab6.controller;

import com.example.lab6.model.*;
import com.example.lab6.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/email-address-valid")
    public ResponseEntity<EmailValidationResponse> validateEmail(
            @RequestBody EmailValidationRequest request) {
        
        String email = request.getEmail();
        EmailValidationResponse response = emailService.validateEmail(email);
        return ResponseEntity.ok(response);
    }
}