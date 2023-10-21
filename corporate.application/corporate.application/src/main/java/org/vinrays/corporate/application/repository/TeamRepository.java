package org.vinrays.corporate.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vinrays.corporate.application.model.TeamEntity;

@Repository
public interface TeamRepository extends JpaRepository<TeamEntity,Long> {
}
