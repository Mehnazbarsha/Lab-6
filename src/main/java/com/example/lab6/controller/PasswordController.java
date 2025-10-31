package com.example.lab6.controller;

import com.example.lab6.model.*;
import com.example.lab6.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PasswordController {

    @Autowired
    private PasswordService passwordService;

    @PostMapping("/password-quality")
    public ResponseEntity<PasswordQualityResponse> checkPasswordQuality(
            @RequestBody PasswordQualityRequest request) {
        
        String password = request.getPassword();
        PasswordQualityResponse response = passwordService.evaluatePassword(password);
        return ResponseEntity.ok(response);
    }
}