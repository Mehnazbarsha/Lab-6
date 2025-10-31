package com.example.lab6.model;

public class EmailValidationRequest {
    private String email;

    public EmailValidationRequest() {}

    public EmailValidationRequest(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}