package com.example.homeservice.repository;

import com.example.homeservice.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    UserEntity findByEmail(String email);
    UserEntity findByUsersToken(String usersToken);

    UserEntity findByEmailAndPassword(String email,String password);

}
