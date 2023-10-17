package org.vinrays.corporate.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vinrays.corporate.application.model.TeamsEntity;

@Repository
public interface TeamsRepository extends JpaRepository<TeamsEntity,Long> {
}
