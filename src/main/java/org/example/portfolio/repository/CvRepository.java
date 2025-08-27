package org.example.portfolio.repository;

import org.example.portfolio.entity.CvFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CvRepository extends JpaRepository<CvFile, Long> {

    CvFile findTopByOrderByIdDesc();
}
