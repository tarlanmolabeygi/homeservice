package com.example.homeservice.Response;


public class ServiceResponse {
    private String title;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public String toString() {
        return "ServiceResponse{" +
                "title='" + title + '\'' +
                '}';
    }
}
