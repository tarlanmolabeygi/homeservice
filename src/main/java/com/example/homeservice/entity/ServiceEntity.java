package com.example.homeservice.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class ServiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;

    @OneToMany(mappedBy="serviceEntity",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
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
        return "ServiceEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", subServiceEntityList=" + subServiceEntityList +
                '}';
    }
}
