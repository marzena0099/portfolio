package org.example.portfolio.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/api/cv")
@RequiredArgsConstructor
public class CvController {

    @GetMapping
    public ResponseEntity<Resource> getCv() {
        Resource resource = new ClassPathResource("cvs/Marzena_Białończyk_CV_PL_16.07.2025.pdf");

        String encodedFileName = URLEncoder.encode("Marzena_Białończyk_CV_PL_16.07.2025.pdf", StandardCharsets.UTF_8);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename*=UTF-8''" + encodedFileName)
                .contentType(MediaType.APPLICATION_PDF)
                .body(resource);
    }
}
