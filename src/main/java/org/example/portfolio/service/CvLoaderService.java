//package org.example.portfolio.service;
//
//import jakarta.annotation.PostConstruct;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.example.portfolio.entity.CvFile;
//import org.example.portfolio.repository.CvRepository;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//@Slf4j
//@Component
//@RequiredArgsConstructor
//public class CvLoaderService {
//
//    private final CvRepository cvRepository;
//
//    @Value("${CV_FILE_PATH}")
//    private String cvFilePath;
//
//    @PostConstruct
//    public void init() throws IOException {
//        File file = new File(cvFilePath);
//
//        if(!file.exists()) {
//            log.error("CV file does not exist{}", cvFilePath);
//            return;
//        }
//
//        if(cvRepository.count() > 0) {
//            return;
//        }
//
//        CvFile cv = new CvFile();
//        cv.setFileName(file.getName());
//        cv.setData(Files.readAllBytes(file.toPath()));
//        cvRepository.save(cv);
//
//    }
//}
//
