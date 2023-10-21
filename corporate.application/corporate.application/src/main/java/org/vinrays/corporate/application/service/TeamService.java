package org.vinrays.corporate.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vinrays.corporate.application.model.TeamEntity;
import org.vinrays.corporate.application.repository.TeamRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;
    public TeamEntity saveTeamMemberInfo(TeamEntity teamEntity)
    {
        return teamRepository.save(teamEntity);
    }

    public Optional<TeamEntity> getTeamMemberById(Long id){
        return teamRepository.findById(id);
    }

    public List<TeamEntity> getAllTeamData()
    {
        return teamRepository.findAll();
    }
}
