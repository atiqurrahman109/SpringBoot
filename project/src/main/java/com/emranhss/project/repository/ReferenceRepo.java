package com.emranhss.project.repository;

import com.emranhss.project.entity.Reference;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReferenceRepo extends JpaRepository<Reference, Long> {
    List<Reference> findByJobSeekerId(Long jobSeekerId);
}
