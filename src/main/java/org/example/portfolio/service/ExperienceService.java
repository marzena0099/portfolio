package org.example.portfolio.service;

import lombok.RequiredArgsConstructor;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.example.portfolio.entity.Experience;
import org.example.portfolio.repository.ExperienceRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class ExperienceService {

    private final ExperienceRepository experienceRepository;

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("MM/yyyy");

    /**
     * Główna metoda – czyści tabelę i wczytuje doświadczenia z CV.
     */
    @Transactional
    public void reloadFromCV(File cvFile) throws IOException {
        List<Experience> experiences = parseExperience(cvFile);

        experienceRepository.deleteAll();

        for (Experience exp : experiences) {
            System.out.println("💾 Zapisuję doświadczenie: " + exp.getTitle());

            experienceRepository.save(exp);
        }
    }

    /**
     * Parsowanie doświadczeń z PDF.
     */
    public List<Experience> parseExperience(File cvFile) throws IOException {


        List<Experience> experiences = new ArrayList<>();

        try (PDDocument document = PDDocument.load(cvFile)) {
            PDFTextStripper stripper = new PDFTextStripper();
            String text = stripper.getText(document);


            text = findExperienceEnd(text);
            String[] entries = text.split("(?=\\d{2}/\\d{4} – \\d{2}/\\d{4}|\\d{2}/\\d{4} – present)");

            for (String entry : entries) {
                try {
                    // Pomijamy nagłówki sekcji
                    if (entry.matches("(?i).*Wykształcenie.*|.*Pasje.*")) {
                        continue;
                    }

                    Pattern headerPattern = Pattern.compile(
                            "(?<start>\\d{2}/\\d{4}) – (?<end>\\d{2}/\\d{4}|present) \\| (?<title>[^|]+) \\| (?<company>.+)"
                    );
                    Matcher headerMatcher = headerPattern.matcher(entry);

                    if (headerMatcher.find()) {
                        Experience exp = new Experience();
                        exp.setTitle(headerMatcher.group("title").trim());
                        exp.setCompany(headerMatcher.group("company").trim());

                        exp.setStartDate(YearMonth.parse(headerMatcher.group("start"), FORMATTER));

                        String endStr = headerMatcher.group("end").trim();
                        if (endStr.equalsIgnoreCase("present")) {
                            exp.setEndDate(null);
                        } else {
                            exp.setEndDate(YearMonth.parse(endStr, FORMATTER));
                        }
                        // Pobieramy opis i dzielimy na podpunkty
                        String description = entry.substring(headerMatcher.end()).trim();
                        String[] subpoints = description.split("(?<=\\)|\\.|;|\\n)"); // kończy na ), ., ; lub nowa linia
                        StringBuilder cleaned = new StringBuilder();
                        for (String sp : subpoints) {
                            sp = sp.trim();
                            if (!sp.isEmpty()) {
                                cleaned.append(cleanDescription(sp)).append("\n"); // każdy podpunkt od nowej linii
                            }
                        }

                        exp.setDescription(cleaned.toString().trim()); // ustawiamy tylko raz
                        experiences.add(exp);
                    }

                } catch (Exception e) {
                    System.out.println("Pominięto wpis: " + e.getMessage());
                }
            }

            return experiences;
        }

    }

    private static String findExperienceEnd(String text) {
        String lowerText = text.toLowerCase();
        int cutIndex = lowerText.indexOf("wykształcenie");
        if (cutIndex == -1) {
            cutIndex = lowerText.indexOf("pasje");
        }
        if (cutIndex != -1) {
            text = text.substring(0, cutIndex);
        }
        return text;
    }

    private String cleanDescription(String rawDesc) {
    if (rawDesc == null || rawDesc.isEmpty()) {
        return "";
    }

    // Zamień "  •" na nową linię
    String result = rawDesc.replaceAll("•", "\n");

    return result.trim();
}



}

