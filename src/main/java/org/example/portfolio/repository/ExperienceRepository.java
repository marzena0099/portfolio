package org.example.portfolio.repository;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.example.portfolio.entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long> {
}
