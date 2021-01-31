package com.example.homeservice.Request;

import com.example.homeservice.Dto.UserDto;
import com.example.homeservice.enums.StatusEnum;

public class MasterWorkerRequest {
    private String expert;
    private UserRequest userRequest;


    public String getExpert() {
        return expert;
    }

    public void setExpert(String expert) {
        this.expert = expert;
    }


    public UserRequest getUserRequest() {
        return userRequest;
    }

    public void setUserRequest(UserRequest userRequest) {
        this.userRequest = userRequest;
    }

    @Override
    public String toString() {
        return "MasterWorkerRequest{" +
                "expert='" + expert + '\'' +
                ", userRequest=" + userRequest +
                '}';
    }
}
