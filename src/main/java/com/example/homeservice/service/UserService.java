package com.example.homeservice.service;

import com.example.homeservice.Dto.UserDto;
import com.example.homeservice.Response.EmailVerificationResponse;
import com.example.homeservice.Response.LoginResponse;
import com.example.homeservice.entity.UserEntity;
import com.example.homeservice.enums.StatusEnum;
import com.example.homeservice.repository.UserRepository;
import com.example.homeservice.util.UserUtil;
import com.example.homeservice.validation.PasswordValidation;
import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {
    private UserRepository userRepository;
    ModelMapper modelMapper = new ModelMapper();


    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto register(UserDto userDto) {
        UserEntity userEntity = modelMapper.map(userDto, UserEntity.class);
        if (userRepository.findByEmail(userEntity.getEmail()) == null) {
//            if(PasswordValidation.checkPasswordPattern(userEntity.getPassword()));
            PasswordValidation.checkPasswordPattern(userEntity.getPassword());
            userEntity.setStatus(StatusEnum.register);
            userEntity.setUsersToken(UserUtil.generatedUserToken());

            UserEntity userStored = userRepository.save(userEntity);

            return modelMapper.map(userStored, UserDto.class);
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "email is duplicate");
    }

    public LoginResponse login(String email, String password) {
        UserEntity userEntity = userRepository.findByEmailAndPassword(email, password);
        if (userEntity != null) {
            UserDto userDto = modelMapper.map(userEntity, UserDto.class);
            return new LoginResponse(userDto.getUsersToken());
        }
        return null;

    }


//    public boolean emailverification(String usersToken) {
//        UserEntity userStored = userRepository.findByUsersToken(usersToken);
//        if (userStored != null) {
//            userStored.setStatus(StatusEnum.active);
//            userStored.setUsersToken(null);
//           return true;
//        }
//        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "there isn't this Token");
//
//    }


    public EmailVerificationResponse emailverification(String usersToken) {
        UserEntity userStored = userRepository.findByUsersToken(usersToken);
        if (userStored != null) {
            userStored.setStatus(StatusEnum.active);
            userStored.setUsersToken(null);
            UserEntity userEntity = new UserEntity();
//            return StatusEnum.register;
//            return new EmailVerificationResponse(userEntity.getStatus().toString());
            return new EmailVerificationResponse(StatusEnum.register.toString());
        }
//        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "there isn't this Token");
        return new EmailVerificationResponse(StatusEnum.active.toString());

    }

    public boolean deleteUser(String email) {
        UserEntity userEntity = userRepository.findByEmail(email);
        if (userEntity != null) {
            userRepository.delete(userEntity);
            return true;
        }
        return false;
    }
}
