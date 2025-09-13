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
        Resource resource = new ClassPathResource("static/Marzena_Białończyk_CV_PL_16.07.2025.pdf");

        String encodedFileName = URLEncoder.encode("Marzena_Białończyk_CV_PL_16.07.2025.pdf", StandardCharsets.UTF_8);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename*=UTF-8''" + encodedFileName)
                .contentType(MediaType.APPLICATION_PDF)
                .body(resource);
    }
}


//    @Transactional(readOnly = true)
//    public ResponseEntity<byte[]> downloadCv() {
//        CvFile cv = cvRepository.findTopByOrderByIdDesc();
//
//        if(cv == null || cv.getData() == null || cv.getFileName() == null) {
//            System.err.println("Brak danych CV w bazie!");
//            return ResponseEntity.notFound().build();
//        }
//
//        System.out.println("Pobieram CV: " + cv.getFileName() + ", rozmiar: " + cv.getData().length + " bajtów");
//
//
//        String encodedFileName = URLEncoder.encode(cv.getFileName(), StandardCharsets.UTF_8).replaceAll("\\+", "%20");
//
//        return ResponseEntity.ok()
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename*=UTF-8''" + encodedFileName)
//                .header("Access-Control-Expose-Headers", "Content-Disposition")
//                .contentType(MediaType.APPLICATION_PDF)
//                .body(cv.getData());
//    }
//
//}
