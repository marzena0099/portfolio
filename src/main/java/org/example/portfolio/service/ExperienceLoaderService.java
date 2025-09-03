package org.example.portfolio.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.example.portfolio.entity.Experience;
import org.example.portfolio.repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ExperienceLoaderService {
    private final ExperienceService experienceService;
    @Value("${CV_FILE_PATH}")
    private String cvFilePath;

    @PostConstruct
    public void init() {
        try {
            File file = new File(cvFilePath);

            if (!file.exists()) {
                System.err.println("Plik CV nie istnieje: " + cvFilePath);
                return;
            }

            if (file.length() == 0) {
                System.err.println("Plik CV jest pusty: " + cvFilePath);
                return;
            }

            System.out.println("Ładuję doświadczenia z CV: " + file.getName());
            experienceService.reloadFromCV(file);  // <--- tutaj wywołanie

        } catch (Exception e) {
            System.err.println("Błąd podczas parsowania CV: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
