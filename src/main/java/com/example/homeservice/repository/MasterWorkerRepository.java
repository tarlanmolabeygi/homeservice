package com.example.homeservice.repository;

import com.example.homeservice.entity.MasterWorkerEntity;
import com.example.homeservice.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterWorkerRepository  extends JpaRepository<MasterWorkerEntity,Integer> {
    //MasterWorkerEntity findByEmail(String email);
//    MasterWorkerEntity findByUsersToken(String usersToken);
    MasterWorkerEntity findByUserEntity(UserEntity userEntity);
//    UserEntity findByUserEntity(UserEntity userEntity);
}
