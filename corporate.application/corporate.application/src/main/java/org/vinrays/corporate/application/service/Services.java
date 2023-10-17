package org.vinrays.corporate.application.service;

import org.vinrays.corporate.application.model.ServiceEntity;

import java.util.List;
import java.util.Optional;

public interface Services {

    public ServiceEntity createService(ServiceEntity serviceEntity);
    public List<ServiceEntity> getAllServices();
    public Optional<ServiceEntity> getServiceByID(Long id);
    public ServiceEntity updateService(Long id, ServiceEntity serviceEntity);
}
