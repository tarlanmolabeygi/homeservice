package com.example.homeservice.repository;

import com.example.homeservice.entity.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface ServiceRepository  extends JpaRepository<ServiceEntity,Integer> {
    ServiceEntity findByTitle(String title);

}
