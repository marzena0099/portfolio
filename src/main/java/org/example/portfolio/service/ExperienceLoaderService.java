package org.example.portfolio.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;

@Slf4j
@Component
@RequiredArgsConstructor
public class ExperienceLoaderService {
    private final ExperienceService experienceService;

    @PostConstruct
    public void init() {
            try {
                //    @Value("${CV_FILE_PATH}")
                String cvFilePath = "C:\\Users\\marzenusia\\IdeaProjects\\pliki\\portfolio\\src\\main\\resources\\static\\Marzena_Białończyk_CV_PL_16.07.2025.pdf";
                File file = new File(cvFilePath);

                if (!file.exists()) {
                    log.error("CV file does not exist {}", cvFilePath);
                    return;
                }

                if (file.length() == 0) {
                    return;
                }
                experienceService.reloadFromCV(file);

            } catch (Exception e) {
                log.error("Błąd podczas wczytywania doświadczenia z CV", e);
            }
        }

    }
