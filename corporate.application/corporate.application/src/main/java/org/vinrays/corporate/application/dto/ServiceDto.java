package org.vinrays.corporate.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDto {
    private Long id;
    private String icon;
    private String title;
    private String description;
}
