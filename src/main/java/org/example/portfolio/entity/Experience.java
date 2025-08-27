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
    private String title;
    @Column(length = 2000)
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
}
