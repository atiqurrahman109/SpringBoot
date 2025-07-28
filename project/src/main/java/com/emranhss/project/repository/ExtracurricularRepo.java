package com.emranhss.project.repository;

import com.emranhss.project.entity.Extracurricular;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExtracurricularRepo extends JpaRepository<Extracurricular, Long> {
    List<Extracurricular> findByJobSeekerId(Long jobSeekerId);
}
