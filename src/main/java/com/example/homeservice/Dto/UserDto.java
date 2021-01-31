package com.example.homeservice.Dto;


import com.example.homeservice.enums.RoleEnum;
import com.example.homeservice.enums.StatusEnum;

public class UserDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
      private RoleEnum role;
    private String usersToken;
    private StatusEnum status;

    private String img;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public String getUsersToken() {
        return usersToken;
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

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", usersToken='" + usersToken + '\'' +
                ", status=" + status +
                ", img='" + img + '\'' +
                '}';
    }
}
