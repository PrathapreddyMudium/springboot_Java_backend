package org.vinrays.corporate.application.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "teams")
@AllArgsConstructor
@NoArgsConstructor
public class TeamsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    private byte[] image;
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
