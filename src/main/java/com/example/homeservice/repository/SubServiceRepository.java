package com.example.homeservice.repository;

import com.example.homeservice.entity.SubServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubServiceRepository extends JpaRepository<SubServiceEntity,Integer> {
    SubServiceEntity findByTitle(String title);

}
