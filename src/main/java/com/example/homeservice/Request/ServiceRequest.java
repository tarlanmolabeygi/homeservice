package com.example.homeservice.Request;

public class ServiceRequest {

    private String title;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "ServiceRequest{" +
                "title='" + title + '\'' +
                '}';
    }
}
