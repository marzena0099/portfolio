package org.example.portfolio.controller;

import lombok.AllArgsConstructor;
import org.example.portfolio.entity.Projects;
import org.example.portfolio.repository.ProjectsRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class ProjectsController {
private final ProjectsRepository projectsRepository;
@GetMapping
    public List<Projects> getAllProjects() {
    return projectsRepository.findAll();
}
}
