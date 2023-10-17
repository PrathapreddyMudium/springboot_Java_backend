package org.vinrays.corporate.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeamDto {
    private Long id;
    private MultipartFile image;
    private String fbLink;
    private String twitterLink;
    private String linkedinLink;
    private String name;
    private String designation;
    private String description;
}
