package com.emranhss.project.repository;

import com.emranhss.project.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LanguageRepo extends JpaRepository<Language,Long> {
    List<Language> findByJobSeekerId(Long jobSeekerId);
}
