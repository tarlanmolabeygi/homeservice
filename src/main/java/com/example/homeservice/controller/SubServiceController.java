package com.example.homeservice.controller;

import com.example.homeservice.Dto.SubServiceDto;
import com.example.homeservice.Request.SubServiceRequest;
import com.example.homeservice.Response.SubServiceResponse;
import com.example.homeservice.service.SubServiceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subservice")
public class SubServiceController {
    @Autowired
    private SubServiceService subServiceService;
    ModelMapper modelMapper=new ModelMapper();

//    @Autowired
//    public SubServiceController(SubServiceService subServiceService) {
//        this.subServiceService = subServiceService;
//    }

    @PostMapping( "/add")
    public SubServiceResponse add( @RequestBody SubServiceRequest subServiceRequest){
        SubServiceDto subServiceDto=modelMapper.map(subServiceRequest,SubServiceDto.class);
        SubServiceDto subServiceStored = subServiceService.addSubService(subServiceRequest.getServicetitle(), subServiceDto);
        SubServiceResponse returnValue = modelMapper.map(subServiceStored, SubServiceResponse.class);
        return returnValue;
    }

    @GetMapping("/{servicetitle}")
    public SubServiceResponse get(@PathVariable("servicetitle") String servicetitle){
        SubServiceDto subServiceDto = subServiceService.getSubService(servicetitle);
        SubServiceResponse returnvalue = modelMapper.map(subServiceDto, SubServiceResponse.class);
        return returnvalue;
    }

    @DeleteMapping("/{title}")
    public boolean delete(@PathVariable("title")String title){
        subServiceService.deleteSubService(title);
        return true;
    }

//    @PutMapping("/{title}")
//    public boolean put(@PathVariable("title") String title, SubServiceRequest subServiceRequest){
//       SubServiceDto subServiceDto = modelMapper.map(subServiceRequest, SubServiceDto.class);
//        subServiceService.update(title,subServiceDto);
//        return true;
//
//    }


}
