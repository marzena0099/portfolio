package org.example.portfolio.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.example.portfolio.entity.CvFile;
import org.example.portfolio.repository.CvRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Component
@RequiredArgsConstructor
public class CvLoaderService {

    private final CvRepository cvRepository;

    @Value("${CV_FILE_PATH}")
    private String cvFilePath;

    @PostConstruct
    public void init() throws IOException {
        File file = new File(cvFilePath);

        if(!file.exists()) {
            System.err.println("Plik CV nie istnieje: " + cvFilePath);
            return;
        }

        if(cvRepository.count() > 0) {
            System.out.println("CV już istnieje w bazie, nie wczytuję ponownie.");
            return;
        }

        CvFile cv = new CvFile();
        cv.setFileName(file.getName());
        cv.setData(Files.readAllBytes(file.toPath()));
        cvRepository.save(cv);

        System.out.println("CV wczytane do bazy: " + file.getName() + ", rozmiar: " + cv.getData().length + " bajtów");
    }
}

