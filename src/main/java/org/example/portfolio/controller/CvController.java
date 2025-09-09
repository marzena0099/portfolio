//package org.example.portfolio.controller;
//
//import jakarta.annotation.PostConstruct;
//import lombok.AllArgsConstructor;
//import lombok.RequiredArgsConstructor;
//import org.example.portfolio.entity.CvFile;
//import org.example.portfolio.repository.CvRepository;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//
//@RestController
//@RequestMapping("/api/cv")
//@RequiredArgsConstructor
//public class CvController {
//
//    @Value("${CV_FILE_PATH}") // zmienna środowiskowa ustawiona w IntelliJ lub systemie
//    private String cvFilePath;
//private final CvRepository cvRepository;
//
//    // Wczytanie pliku do bazy przy starcie (tylko jeśli chcesz)
//    @PostConstruct
//    public void init() throws IOException {
//        if (cvRepository.count() == 0) { // żeby nie wstawiać wielokrotnie
//            File file = new File(cvFilePath);
//            CvFile cv = new CvFile();
//            cv.setFileName(file.getName());
//            cv.setData(Files.readAllBytes(file.toPath()));
//            cvRepository.save(cv);
//        }
//    }
//    @GetMapping
//    public ResponseEntity<byte[]> downloadCv() {
//        CvFile cv = cvRepository.findTopByOrderByIdDesc();
//        return ResponseEntity.ok()
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + cv.getFileName())
//                .contentType(MediaType.APPLICATION_PDF)
//                .body(cv.getData());
//    }
//}
//
package org.example.portfolio.controller;

import lombok.RequiredArgsConstructor;
import org.example.portfolio.entity.CvFile;
import org.example.portfolio.repository.CvRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/api/cv")
@RequiredArgsConstructor
public class CvController {

    private final CvRepository cvRepository;

    @GetMapping
    @Transactional(readOnly = true)
    public ResponseEntity<byte[]> downloadCv() {
        CvFile cv = cvRepository.findTopByOrderByIdDesc();

        if(cv == null || cv.getData() == null || cv.getFileName() == null) {
            System.err.println("Brak danych CV w bazie!");
            return ResponseEntity.notFound().build();
        }

        System.out.println("Pobieram CV: " + cv.getFileName() + ", rozmiar: " + cv.getData().length + " bajtów");

        // zakodowanie nazwy pliku w UTF-8
        String encodedFileName = URLEncoder.encode(cv.getFileName(), StandardCharsets.UTF_8).replaceAll("\\+", "%20");

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename*=UTF-8''" + encodedFileName)
                .header("Access-Control-Expose-Headers", "Content-Disposition")
                .contentType(MediaType.APPLICATION_PDF)
                .body(cv.getData());
    }

}
