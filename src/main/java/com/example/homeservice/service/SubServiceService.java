package com.example.homeservice.service;

import com.example.homeservice.Dto.ServiceDto;
import com.example.homeservice.Dto.SubServiceDto;
import com.example.homeservice.entity.ServiceEntity;
import com.example.homeservice.entity.SubServiceEntity;
import com.example.homeservice.repository.ServiceRepository;
import com.example.homeservice.repository.SubServiceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class SubServiceService {
    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private SubServiceRepository subServiceRepository;
    @Autowired
    private ServiceRepository serviceRepository;

//    @Autowired
//    public SubServiceService(SubServiceRepository subServiceRepository, ServiceRepository serviceRepository) {
//        this.subServiceRepository = subServiceRepository;
//        this.serviceRepository = serviceRepository;
//    }


    public SubServiceDto addSubService(String servicetitle, SubServiceDto subServiceDto) {

        ServiceEntity serviceStored = serviceRepository.findByTitle(servicetitle);
        if (serviceStored == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "there isn't this servicetitle");

        }
        if (subServiceRepository.findByTitle(subServiceDto.getTitle()) != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "there is duplicate");

        }
        SubServiceEntity subServiceEntity = modelMapper.map(subServiceDto, SubServiceEntity.class);
        serviceStored.getSubServiceEntityList().add(subServiceEntity);
        serviceStored = serviceRepository.save(serviceStored);
        return modelMapper.map(subServiceEntity, SubServiceDto.class);


//        if (subServiceRepository.findByTitle(title) != null) {
//            SubServiceEntity subServiceEntity = modelMapper.map(subServiceDto, SubServiceEntity.class);
//           SubSer subServiceRepository.add(title, subServiceEntity);


    }

    public SubServiceDto getSubService(String servicetitle) {
        SubServiceEntity subServiceEntity = subServiceRepository.findByTitle(servicetitle);
        if (subServiceEntity != null) {
            SubServiceEntity subServiceStored = subServiceRepository.findByTitle(servicetitle);
            SubServiceDto serviceDto = modelMapper.map(subServiceStored, SubServiceDto.class);
            return serviceDto;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "there isn't this servicetitle");
    }


    public boolean deleteSubService(String title){
        SubServiceEntity subServiceEntity = subServiceRepository.findByTitle(title);
        if(subServiceEntity!=null){
            subServiceRepository.delete(subServiceEntity);
            return true;
        }
        return false;

    }


//    public SubServiceDto update(String title, SubServiceDto subServiceDto) {
//        SubServiceEntity subServiceEntity = subServiceRepository.findByTitle(title);
//        if (subServiceEntity == null) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "there isn't this title");
//
//        }
//        SubServiceEntity serviceEntity = modelMapper.map(subServiceDto, SubServiceEntity.class);
//        subServiceEntity.setTitle(subServiceDto.getTitle());
//        subServiceEntity.setPrice(subServiceDto.getPrice());
//        subServiceEntity.setDescription(subServiceDto.getDescription());
//        subServiceRepository.save(subServiceEntity);
//        SubServiceDto subServiceStored = modelMapper.map(serviceEntity, SubServiceDto.class);
//        return subServiceStored;
////            return true;
//
//    }
}


