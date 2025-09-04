package org.example.portfolio.controller;

import org.springframework.core.io.Resource;
import lombok.AllArgsConstructor;
import org.example.portfolio.entity.Projects;
import org.example.portfolio.repository.ProjectsRepository;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.nio.file.Paths;
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



    @GetMapping("/download/{id}")
    public ResponseEntity<Resource> downloadProject(@PathVariable Long id) {
        Projects project = projectsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Projekt nie znaleziony"));

        Path file = Paths.get("downloads").resolve(project.getLink());
        FileSystemResource resource = new FileSystemResource(file);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + file.getFileName())
                .body(resource);
    }

}
