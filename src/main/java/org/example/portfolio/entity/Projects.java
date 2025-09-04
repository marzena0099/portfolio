package org.example.portfolio.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="Projects")

public class Projects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String link;
    private String technologies;

    @Column(length = 8000)
    private String description;

    private String githubLink;

}
