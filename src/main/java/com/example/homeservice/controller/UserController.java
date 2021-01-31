package com.example.homeservice.controller;

import com.example.homeservice.Dto.UserDto;
import com.example.homeservice.Request.LoginRequest;
import com.example.homeservice.Request.UserRequest;
import com.example.homeservice.Response.EmailVerificationResponse;
import com.example.homeservice.Response.LoginResponse;
import com.example.homeservice.Response.UserResponse;
import com.example.homeservice.enums.StatusEnum;
import com.example.homeservice.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/users")

public class UserController {
    private UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    private ModelMapper modelMapper = new ModelMapper();

    @CrossOrigin
    @PostMapping("/register")
    public UserResponse register(@RequestBody UserRequest userRequest) {
        UserDto userDto = modelMapper.map(userRequest, UserDto.class);
        UserDto userStored = userService.register(userDto);

        if (userStored != null) {
            return modelMapper.map(userStored, UserResponse.class);
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "username is duplicate");

    }


    @CrossOrigin
    @GetMapping("/emailverification/{usersToken}")
    public EmailVerificationResponse emailverification(@PathVariable("usersToken") String usersToken) {
        EmailVerificationResponse userStored = userService.emailverification(usersToken);

//            return modelMapper.map(userStored,UserResponse.class);
        return userStored;

    }

    @DeleteMapping("/{email}")
    public boolean deleteUser(@PathVariable("email") String email) {
        userService.deleteUser(email);
        return true;

    }

    @CrossOrigin
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest){

        LoginResponse loginResponse = userService.login(loginRequest.getEmail(), loginRequest.getPassword());
        return loginResponse;
    }
}
