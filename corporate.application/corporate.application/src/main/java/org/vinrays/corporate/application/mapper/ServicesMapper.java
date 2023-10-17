package org.vinrays.corporate.application.mapper;

import org.vinrays.corporate.application.dto.ServiceDto;
import org.vinrays.corporate.application.model.ServiceEntity;

public class ServicesMapper {
    public static ServiceEntity mapToService(ServiceDto serviceDto)
    {
        return new ServiceEntity(serviceDto.getId(),
        serviceDto.getIcon(),
        serviceDto.getTitle(),
        serviceDto.getDescription());
    }

    public static ServiceDto mapToServiceDto(ServiceEntity serviceEntity)
    {
        return new ServiceDto(
                serviceEntity.getId(),
                serviceEntity.getIcon(),
                serviceEntity.getTitle(),
                serviceEntity.getDescription()
        );
    }
}
