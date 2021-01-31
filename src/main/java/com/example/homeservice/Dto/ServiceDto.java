package com.example.homeservice.Dto;

import com.example.homeservice.entity.SubServiceEntity;

import java.util.List;

public class ServiceDto {
    private Integer id;
    private String title;
    private List<SubServiceEntity> subServiceEntityList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<SubServiceEntity> getSubServiceEntityList() {
        return subServiceEntityList;
    }

    public void setSubServiceEntityList(List<SubServiceEntity> subServiceEntityList) {
        this.subServiceEntityList = subServiceEntityList;
    }

    @Override
    public String toString() {
        return "ServiceDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", subServiceEntityList=" + subServiceEntityList +
                '}';
    }
}
