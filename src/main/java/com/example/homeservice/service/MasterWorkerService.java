package com.example.homeservice.service;

import com.example.homeservice.Dto.MasterWorkerDto;
import com.example.homeservice.Dto.UserDto;
import com.example.homeservice.entity.MasterWorkerEntity;
import com.example.homeservice.entity.ServiceEntity;
import com.example.homeservice.entity.UserEntity;
import com.example.homeservice.enums.StatusEnum;
import com.example.homeservice.repository.MasterWorkerRepository;
import com.example.homeservice.repository.UserRepository;
import com.example.homeservice.util.UserUtil;
import com.example.homeservice.validation.PasswordValidation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class MasterWorkerService {
    private final MasterWorkerRepository masterWorkerRepository;
    private final UserRepository userRepository;
    ModelMapper modelMapper=new ModelMapper();


    @Autowired
    public MasterWorkerService(MasterWorkerRepository masterWorkerRepository, UserRepository userRepository) {
        this.masterWorkerRepository = masterWorkerRepository;
        this.userRepository = userRepository;
    }

    public MasterWorkerDto registerMasterWorker(MasterWorkerDto masterWorkerDto){
        MasterWorkerEntity masterWorkerEntity = modelMapper.map(masterWorkerDto, MasterWorkerEntity.class);
        UserEntity userEntity=modelMapper.map(masterWorkerDto.getUserDto(),UserEntity.class);
        masterWorkerEntity.setUserEntity(userEntity);


        if (userRepository.findByEmail(userEntity.getEmail())== null)
        {
            masterWorkerEntity.getUserEntity().setStatus(StatusEnum.register);
//            userEntity.setStatus(StatusEnum.register);
            masterWorkerEntity.getUserEntity().setUsersToken(UserUtil.generatedUserToken());
//            userEntity.setUsersToken(UserUtil.generatedUserToken());

//            PasswordValidation.checkPasswordPattern(userEntity.getPassword());

            MasterWorkerEntity masterWorkerStored=masterWorkerRepository.save(masterWorkerEntity);
//            UserEntity userStored = userRepository.save(userEntity);

            System.out.println("============================");
            System.out.println(masterWorkerStored);
            MasterWorkerDto masterWorkerResult = modelMapper.map(masterWorkerStored, MasterWorkerDto.class);
            UserDto userDto=modelMapper.map(userEntity, UserDto.class);
            masterWorkerResult.setUserDto(userDto);
            return masterWorkerResult;
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"email is duplicate");
    }


    public boolean masterWorkersemailverification(String masterWorkersToken) {

        UserEntity userEntity = userRepository.findByUsersToken(masterWorkersToken);
//        MasterWorkerEntity masterWorkerStored = masterWorkerRepository.findByUsersToken(usersToken);
        if (userEntity != null) {
            userEntity.setStatus(StatusEnum.active);
            userEntity.setUsersToken(null);
            return true;
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "there isn't this Token");

    }



    public boolean deletemasterworker(String email){
        UserEntity userEntity = userRepository.findByEmail(email);
       // System.out.println("============================"+title+"=============================");
        //System.out.println("============================="+userEntity+"================================");
//        ServiceEntity serviceEntity = serviceRepository.findByTitle(title);
        if(userEntity!=null){
            userRepository.delete(userEntity);
           // System.out.println("=========================user is deleted=======================");
            return true;
        }
        return false;

    }
}
