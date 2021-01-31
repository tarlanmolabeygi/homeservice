package com.example.homeservice.controller;

import com.example.homeservice.Dto.ServiceDto;
import com.example.homeservice.Request.ServiceRequest;
import com.example.homeservice.Response.ServiceResponse;
import com.example.homeservice.service.ServiceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    private ServiceService service;


//    @Autowired
//    public ServiceController(ServiceService service) {
//        this.service = service;
//    }

    ModelMapper modelMapper=new ModelMapper();


    @PostMapping("/add")
    public ServiceResponse add(@RequestBody ServiceRequest serviceRequest){
        ServiceDto  serviceDto=modelMapper.map(serviceRequest,ServiceDto.class);
        ServiceDto add = service.addService(serviceDto);
        ServiceResponse result = modelMapper.map(add, ServiceResponse.class);
        return result;
    }

    @GetMapping("/{title}")
    public ServiceResponse get(@PathVariable("title") String title){
        ServiceDto serviceDto = service.getService(title);
        ServiceResponse returnValue = modelMapper.map(serviceDto, ServiceResponse.class);
        return returnValue;

    }

    @DeleteMapping("/{title}")
    public boolean delete(@PathVariable("title")String title){
        service.deleteService(title);
        return true;
    }

//    @PutMapping("/{title}")
//    public ServiceResponse put(@PathVariable("title") String title, ServiceRequest serviceRequest){
//        ServiceDto serviceDto = modelMapper.map(serviceRequest, ServiceDto.class);
//       ServiceDto updatetitle =service.update(title,serviceDto);
//       return modelMapper.map(updatetitle,ServiceResponse.class);
//
//
//    }

}
