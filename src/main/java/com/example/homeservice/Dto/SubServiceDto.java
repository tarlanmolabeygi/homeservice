package com.example.homeservice.Dto;

import com.example.homeservice.entity.ServiceEntity;

public class SubServiceDto {

    private Integer id;
    private Double price;
    private String title;
    private String description;
    private ServiceEntity serviceEntity;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ServiceEntity getServiceEntity() {
        return serviceEntity;
    }

    public void setServiceEntity(ServiceEntity serviceEntity) {
        this.serviceEntity = serviceEntity;
    }


    @Override
    public String toString() {
        return "SubServiceDto{" +
                "Id=" + id +
                ", price=" + price +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", serviceEntity=" + serviceEntity +
                '}';
    }
}
