package org.vinrays.corporate.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.vinrays.corporate.application.dto.TeamDto;
import org.vinrays.corporate.application.mapper.TeamMapper;
import org.vinrays.corporate.application.model.TeamsEntity;
import org.vinrays.corporate.application.service.TeamsService;
import org.vinrays.corporate.application.util.FileService;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class TeamsController {
    @Autowired
    private TeamsService teamsService;

    FileService fileService = new FileService();

    @PostMapping("/team")
    public ResponseEntity<String> saveTeamMember(@ModelAttribute TeamDto teamDto) throws IOException {
        System.out.println(teamDto.getImage().getBytes().length);
        fileService.writeBytesToFile(teamDto.getImage().getBytes(),"C:\\Users\\pmudium\\Desktop\\SpringBoot\\test_postman.jpg");
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
    public TeamsEntity getTeamMemberInfo(@PathVariable Long id) throws IOException {
        TeamsEntity teamsEntity = teamsService.getTeamMemberById(id);
        System.out.println(teamsEntity.getImage().length);
        fileService.writeBytesToFile(teamsEntity.getImage(),"C:\\Users\\pmudium\\Desktop\\SpringBoot\\test_db.jpg");
        //return TeamMapper.mapToTeamDto(teamsEntity);
        return teamsEntity;
    }
}
