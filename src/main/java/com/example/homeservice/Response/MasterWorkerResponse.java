package com.example.homeservice.Response;

import com.example.homeservice.Dto.UserDto;

public class MasterWorkerResponse {
    private String expert;
    private UserResponse userResponse;

    public String getExpert() {
        return expert;
    }

    public void setExpert(String expert) {
        this.expert = expert;
    }

    public UserResponse getUserResponse() {
        return userResponse;
    }

    public void setUserResponse(UserResponse userResponse) {
        this.userResponse = userResponse;
    }

    @Override
    public String toString() {
        return "MasterWorkerResponse{" +
                "expert='" + expert + '\'' +
                ", userResponse=" + userResponse +
                '}';
    }
}
