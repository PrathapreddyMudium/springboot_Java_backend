package org.vinrays.corporate.application.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class TeamEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String profilePic;
    @Column(unique = true)
    private String fbLink;
    @Column(unique = true)
    private String twitterLink;
    @Column(unique = true)
    private String linkedinLink;
    private String name;
    private String designation;
    private String description;
}
