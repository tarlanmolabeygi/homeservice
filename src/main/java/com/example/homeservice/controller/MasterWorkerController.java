package com.example.homeservice.controller;

import com.example.homeservice.Dto.MasterWorkerDto;
import com.example.homeservice.Dto.UserDto;
import com.example.homeservice.Request.MasterWorkerRequest;
import com.example.homeservice.Response.MasterWorkerResponse;
import com.example.homeservice.Response.UserResponse;
import com.example.homeservice.entity.MasterWorkerEntity;
import com.example.homeservice.entity.UserEntity;
import com.example.homeservice.service.MasterWorkerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/masterworker")
public class MasterWorkerController {

    private final MasterWorkerService masterWorkerService;
    ModelMapper modelMapper=new ModelMapper();

    @Autowired
    public MasterWorkerController(MasterWorkerService masterWorkerService) {
        this.masterWorkerService = masterWorkerService;
    }

    @PostMapping("/register")
    public MasterWorkerResponse register(@RequestBody MasterWorkerRequest masterWorkerRequest) {
//        MasterWorkerDto masterWorkerDto = modelMapper.map(masterWorkerRequest, MasterWorkerDto.class);
//
//        UserDto userDto = modelMapper.map(masterWorkerRequest.getUserRequest(), UserDto.class);
//        System.out.println(userDto);
//        masterWorkerDto.setUserDto(userDto);

        MasterWorkerDto masterWorkerDto = modelMapper.map(masterWorkerRequest, MasterWorkerDto.class);
        UserDto userDto=modelMapper.map(masterWorkerRequest.getUserRequest(),UserDto.class);
        masterWorkerDto.setUserDto(userDto);

        MasterWorkerDto masterWorkerStored = masterWorkerService.registerMasterWorker(masterWorkerDto);
        MasterWorkerResponse result = modelMapper.map(masterWorkerStored, MasterWorkerResponse.class);
        UserResponse userResponse  =modelMapper.map(masterWorkerStored.getUserDto(), UserResponse.class);
        result.setUserResponse(userResponse);
        return result;
    }


    @GetMapping("/emailverification/{masterworkersToken}")
    public boolean emailverification(@PathVariable("masterworkersToken") String masterworkersToken) {
        boolean userStored = masterWorkerService.masterWorkersemailverification(masterworkersToken);


//            return modelMapper.map(userStored,UserResponse.class);
        return userStored;

    }


    @DeleteMapping("/{email}")
    public boolean delete(@PathVariable("email")String email){
        masterWorkerService.deletemasterworker(email);
        return true;
    }
}
