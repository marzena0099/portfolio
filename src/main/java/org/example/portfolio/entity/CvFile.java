package org.example.portfolio.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="cv")
public class CvFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "file_name", nullable = false)
    private String fileName;

@Lob
@Column(name="data", columnDefinition="bytea", nullable=false)
private byte[] data;


}
