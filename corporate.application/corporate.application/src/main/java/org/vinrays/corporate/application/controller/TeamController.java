package org.vinrays.corporate.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.vinrays.corporate.application.model.TeamEntity;
import org.vinrays.corporate.application.model.TeamsEntity;
import org.vinrays.corporate.application.service.TeamService;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class TeamController {
    public static String uploadDirectory = System.getProperty("user.dir") + "/corporate.application/corporate.application/src/main/webapp/images";
    @Autowired
    private TeamService teamService;

    @PostMapping("/teams")
    public TeamEntity createTeamMember(@ModelAttribute TeamEntity teamEntity, @RequestParam("image") MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        Path fileNameAndPath = Paths.get(uploadDirectory,originalFilename);
        System.out.println(file.getBytes().length);
        Files.write(fileNameAndPath,file.getBytes());
        teamEntity.setProfilePic(originalFilename);
        TeamEntity savedTeamEntiry = teamService.saveTeamMemberInfo(teamEntity);
        return savedTeamEntiry;

    }

    @GetMapping("/teams/getProfilePic/{id}")
    public ResponseEntity<Resource> getProfilePicOfTeamMember(@PathVariable Long id) throws IOException {
        TeamEntity teamEntity = teamService.getTeamMemberById(id).get();
        Path imagePath = Paths.get(uploadDirectory, teamEntity.getProfilePic());
        Resource resource = new FileSystemResource(imagePath.toFile());
        String contentType = Files.probeContentType(imagePath);
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType)).body(resource);

    }

    @GetMapping("/teams")
    public List<TeamEntity> getAllTeamMemberInfo()
    {
        return teamService.getAllTeamData();
    }
}
