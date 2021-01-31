package com.example.homeservice.Dto;

public class MasterWorkerDto {
    private Integer id;
    private String expert;
  private UserDto userDto;


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

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }



    @Override
    public String toString() {
        return "MasterWorkerDto{" +
                "id=" + id +
                ", expert='" + expert + '\'' +
                ", userDto=" + userDto +
                '}';
    }
}
