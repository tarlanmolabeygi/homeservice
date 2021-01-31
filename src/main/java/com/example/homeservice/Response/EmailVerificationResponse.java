package com.example.homeservice.Response;

public class EmailVerificationResponse {

    private String registered;

    public EmailVerificationResponse(String registered) {
        this.registered = registered;
    }

    public String getRegistered() {
        return registered;
    }

    public void setRegistered(String registered) {
        this.registered = registered;
    }
}
