package org.vinrays.corporate.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.vinrays.corporate.application.model.TeamsEntity;
import org.vinrays.corporate.application.repository.TeamsRepository;

import java.util.Optional;

@Service
public class TeamsService implements Teams {
    @Autowired
    private TeamsRepository teamsRepository;

    @Override
    public ResponseEntity<String> saveTeamMemberInfo(TeamsEntity teamsEntity) {
        teamsRepository.save(teamsEntity);
        return ResponseEntity.ok("Team data and image uploaded successfully");
    }

    @Override
    public TeamsEntity getTeamMemberById(Long id) {
        Optional<TeamsEntity> teamsEntity = teamsRepository.findById(id);
        System.out.println(teamsEntity);
        TeamsEntity teamsEntity1 =  teamsEntity.get();
        return teamsEntity1;
    }
}
