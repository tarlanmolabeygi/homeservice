package com.example.homeservice.entity;


import com.example.homeservice.enums.RoleEnum;
import com.example.homeservice.enums.StatusEnum;

import javax.persistence.*;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
     private String firstName;
     private String lastName;
     private String email;
     private String password;
     private String usersToken;
     private String img;


//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name="masterWorker_id")
//    private MasterWorkerEntity masterWorkerEntity;
    @OneToOne(mappedBy = "userEntity")
    private MasterWorkerEntity masterWorkerEntity;



    @Enumerated(EnumType.STRING)
   private RoleEnum role;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;


    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getUsersToken() {
        return usersToken;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public void setUsersToken(String usersToken) {
        this.usersToken = usersToken;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }


    public MasterWorkerEntity getMasterWorkerEntity() {
        return masterWorkerEntity;
    }




    public void setMasterWorkerEntity(MasterWorkerEntity masterWorkerEntity) {
        this.masterWorkerEntity = masterWorkerEntity;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", usersToken='" + usersToken + '\'' +
                ", img='" + img + '\'' +
                ", masterWorkerEntity=" + masterWorkerEntity +
                ", role=" + role +
                ", status=" + status +
                '}';
    }
}
