package com.example.homeservice.entity;

import javax.persistence.*;

@Entity
public class MasterWorkerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String expert;


//    @OneToOne(mappedBy = "userEntity", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    private UserEntity userEntity;

//    @OneToOne(mappedBy="masterWorkerEntity",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    private UserEntity userEntity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id",referencedColumnName = "id")
    private UserEntity userEntity;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExpert() {
        return expert;
    }

    public void setExpert(String expert) {
        this.expert = expert;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }


    @Override
    public String toString() {
        return "MasterWorkerEntity{" +
                "id=" + id +
                ", expert='" + expert + '\'' +
                ", userEntity=" + userEntity +
                '}';
    }
}
