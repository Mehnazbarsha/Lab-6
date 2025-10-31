package com.example.lab6.model;

public class PasswordQualityRequest {
    private String password;

    public PasswordQualityRequest() {}

    public PasswordQualityRequest(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}