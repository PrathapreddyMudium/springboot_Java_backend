package org.vinrays.corporate.application.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.vinrays.corporate.application.model.ServiceEntity;
import org.vinrays.corporate.application.repository.ServiceRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class ServiceImpl implements org.vinrays.corporate.application.service.Services {
    @Autowired
    ServiceRepository serviceRepository;
    @Override
    public ServiceEntity createService(@RequestBody ServiceEntity serviceEntity) {
        return serviceRepository.save(serviceEntity);
    }

    @Override
    public List<ServiceEntity> getAllServices() {
        return serviceRepository.findAll();
    }

    @Override
    public Optional<ServiceEntity> getServiceByID(Long id) {
        return serviceRepository.findById(id);
    }

    @Override
    public ServiceEntity updateService(Long id, ServiceEntity serviceEntity) {
            Optional<ServiceEntity> service1 = serviceRepository.findById(id);
            ServiceEntity updatedServiceEntity =service1.get();
            updatedServiceEntity.setIcon(serviceEntity.getIcon());
            updatedServiceEntity.setTitle(serviceEntity.getTitle());
            updatedServiceEntity.setDescription(serviceEntity.getDescription());
            return serviceRepository.save(updatedServiceEntity);

    }
}
