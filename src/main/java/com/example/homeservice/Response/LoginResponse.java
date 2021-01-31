package com.example.homeservice.Response;

public class LoginResponse {
    private String loginsToken;

    public LoginResponse(String usersToken) {
        this.loginsToken = usersToken;
    }

    public String getUsersToken() {
        return loginsToken;
    }

    public void setUsersToken(String usersToken) {
        this.loginsToken = usersToken;
    }
}
