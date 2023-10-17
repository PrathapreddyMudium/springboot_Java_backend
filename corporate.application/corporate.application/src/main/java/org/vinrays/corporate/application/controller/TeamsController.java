package org.vinrays.corporate.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.vinrays.corporate.application.dto.TeamDto;
import org.vinrays.corporate.application.mapper.TeamMapper;
import org.vinrays.corporate.application.model.TeamsEntity;
import org.vinrays.corporate.application.service.TeamsService;
import java.io.IOException;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class TeamsController {
    @Autowired
    private TeamsService teamsService;

    @PostMapping("/team")
    public ResponseEntity<String> saveTeamMember(@ModelAttribute TeamDto teamDto) throws IOException {
        TeamsEntity teamsEntity = new TeamsEntity(
                teamDto.getId(),
                teamDto.getImage().getBytes(),
                teamDto.getFbLink(),
                teamDto.getTwitterLink(),
                teamDto.getLinkedinLink(),
                teamDto.getName(),
                teamDto.getDesignation(),
                teamDto.getDescription()
        );
        return teamsService.saveTeamMemberInfo(teamsEntity);

    }

    @GetMapping("/team/{id}")
    public TeamDto getTeamMemberInfo(@PathVariable Long id)
    {
        TeamsEntity teamsEntity = teamsService.getTeamMemberById(id);
        return TeamMapper.mapToTeamDto(teamsEntity);
    }
}
