package org.example.portfolio.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "Experience")
public class Experience
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String company;
    private String title;
    private LocalDate startDate;

    @Column(length = 6000)
    private String description;
    private LocalDate endDate;
}
