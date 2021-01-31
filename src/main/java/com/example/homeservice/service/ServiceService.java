package com.example.homeservice.service;

import com.example.homeservice.Dto.ServiceDto;
import com.example.homeservice.entity.ServiceEntity;
import com.example.homeservice.repository.ServiceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;

    ModelMapper modelMapper = new ModelMapper();

//    @Autowired
//    public ServiceService(ServiceRepository serviceRepository) {
//        this.serviceRepository = serviceRepository;
//    }


    public ServiceDto addService(ServiceDto serviceDto) {
        ServiceEntity serviceEntity = modelMapper.map(serviceDto, ServiceEntity.class);
        ServiceEntity add = serviceRepository.save(serviceEntity);
        ServiceDto result = modelMapper.map(add, ServiceDto.class);

        return result;

    }

    public ServiceDto getService(String title){
//        serviceRepository.findAll().size();
        ServiceEntity serviceEntity = serviceRepository.findByTitle(title);
        if(serviceEntity!=null) {
            ServiceDto returnValue = modelMapper.map(serviceEntity, ServiceDto.class);
            return returnValue;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "there isn't this title");
    }

    public boolean deleteService(String title){
        ServiceEntity serviceEntity = serviceRepository.findByTitle(title);
       if(serviceEntity!=null){
           serviceRepository.delete(serviceEntity);
           return true;
       }
       return false;

    }

//    public ServiceDto update(String title,ServiceDto serviceDto){
//        ServiceEntity  serviceEntity= serviceRepository.findByTitle(title);
//        if(serviceEntity==null)
//        {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "there isn't this title");
//
//
//        }
//        serviceEntity.setTitle(serviceDto.getTitle());
//        serviceRepository.save(serviceEntity);
//        ServiceDto serviceStored = modelMapper.map(serviceEntity, ServiceDto.class);
//
//
//        return serviceStored;
//    }

}
