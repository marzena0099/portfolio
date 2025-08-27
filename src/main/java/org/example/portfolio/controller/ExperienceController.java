package org.example.portfolio.controller;

import lombok.AllArgsConstructor;
import org.example.portfolio.entity.Experience;
import org.example.portfolio.repository.ExperienceRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/experience")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class ExperienceController {
private final ExperienceRepository experienceRepository;

@GetMapping
    public List<Experience> getAll() {
    return experienceRepository.findAll();
}
}
