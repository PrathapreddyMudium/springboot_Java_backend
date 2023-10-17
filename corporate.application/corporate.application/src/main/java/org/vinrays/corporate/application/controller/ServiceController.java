package org.vinrays.corporate.application.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.vinrays.corporate.application.dto.ServiceDto;
import org.vinrays.corporate.application.mapper.ServicesMapper;
import org.vinrays.corporate.application.model.ServiceEntity;
import org.vinrays.corporate.application.service.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@CrossOrigin(origins = "http://localhost:3000/")
public class ServiceController {
    @Autowired
    private ServiceImpl serviceImpl;

    @PostMapping("/service")
    public ServiceDto createService(@RequestBody ServiceEntity serviceEntity){
        ServiceEntity serviceEntity1 = serviceImpl.createService(serviceEntity);
        return ServicesMapper.mapToServiceDto(serviceEntity1);
    }

    @GetMapping("/service/{id}")
    public ServiceDto getServiceById(@PathVariable Long id){
        return ServicesMapper.mapToServiceDto(serviceImpl.getServiceByID(id).get());
    }

    @GetMapping("/service")
    public List<ServiceDto> getAllServices()
    {
        List<ServiceEntity> services = serviceImpl.getAllServices();
        List<ServiceDto> serviceDtos = new ArrayList<>();

        for (ServiceEntity service:services) {
            serviceDtos.add(ServicesMapper.mapToServiceDto(service));
        }
        return serviceDtos;
    }

    @PutMapping("/service/{id}")
    public ServiceDto updateService(@RequestBody ServiceEntity serviceEntity, @PathVariable Long id)
    {
        return ServicesMapper.mapToServiceDto(serviceImpl.updateService(id, serviceEntity));
    }
}
