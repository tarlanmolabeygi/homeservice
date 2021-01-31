package com.example.homeservice.controller;

import com.example.homeservice.entity.UserEntity;
import com.example.homeservice.enums.RoleEnum;
import com.example.homeservice.enums.StatusEnum;
import com.example.homeservice.repository.MasterWorkerRepository;
import com.example.homeservice.repository.UserRepository;
import com.example.homeservice.service.MasterWorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/admincontroller")
public class adminController {
    private final MasterWorkerService masterWorkerService;
    private final MasterWorkerRepository masterWorkerRepository;
    private final UserRepository userRepository;

    @Autowired
    public adminController(MasterWorkerService masterWorkerService, MasterWorkerRepository masterWorkerRepository, UserRepository userRepository) {
        this.masterWorkerService = masterWorkerService;
        this.masterWorkerRepository = masterWorkerRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/{email}")
    public Boolean confirmMasterWorkerwithAdmin(@PathVariable("email") String email){


        UserEntity userEntity = userRepository.findByEmail(email);
        if(userEntity!=null && userEntity.getRole()== RoleEnum.admin){
            userEntity.setStatus(StatusEnum.register);
            return true;
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "users with this email not registered!");


    }
}
