package org.vinrays.corporate.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vinrays.corporate.application.model.ServiceEntity;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceEntity,Long> {
}
