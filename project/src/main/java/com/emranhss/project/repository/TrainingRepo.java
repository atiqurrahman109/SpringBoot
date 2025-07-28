package com.emranhss.project.repository;

import com.emranhss.project.entity.JobSeeker;
import com.emranhss.project.entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainingRepo extends JpaRepository<Training,Long> {
    List<Training> findByJobSeekerId(Long jobSeekerId);
}
