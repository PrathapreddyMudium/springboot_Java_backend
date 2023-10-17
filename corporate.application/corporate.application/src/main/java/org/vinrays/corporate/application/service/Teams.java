package org.vinrays.corporate.application.service;

import org.springframework.http.ResponseEntity;
import org.vinrays.corporate.application.model.TeamsEntity;

import java.util.Optional;

public interface Teams {
public ResponseEntity<String> saveTeamMemberInfo(TeamsEntity teamsEntity);
public TeamsEntity getTeamMemberById(Long id);
}
