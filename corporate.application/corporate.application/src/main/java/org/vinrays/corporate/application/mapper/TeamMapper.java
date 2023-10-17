package org.vinrays.corporate.application.mapper;

import org.springframework.web.multipart.MultipartFile;
import org.vinrays.corporate.application.dto.TeamDto;
import org.vinrays.corporate.application.model.TeamsEntity;
import org.vinrays.corporate.application.util.ByteArrayMultipartFile;

import java.io.IOException;

public class TeamMapper {

    public static TeamDto mapToTeamDto(TeamsEntity teamsEntity)
    {
        byte[] imageData = teamsEntity.getImage(); // Your byte array
        String name = "imageField"; // Field name
        String originalFilename = "image.jpg"; // Original filename
        String contentType = "image/jpeg"; // Content type

        MultipartFile multipartFile = new ByteArrayMultipartFile(name, originalFilename, contentType, imageData);

        TeamDto teamDto = new TeamDto(
                teamsEntity.getId(),
                multipartFile,
                teamsEntity.getFbLink(),
                teamsEntity.getTwitterLink(),
                teamsEntity.getLinkedinLink(),
                teamsEntity.getName(),
                teamsEntity.getDesignation(),
                teamsEntity.getDescription()
        );
        return teamDto;
    }

    public static TeamsEntity mapToTeamEntity(TeamDto teamDto) throws IOException {
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
        return teamsEntity;
    }
}
