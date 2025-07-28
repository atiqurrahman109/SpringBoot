package com.emranhss.project.repository;

import com.emranhss.project.entity.Hobby;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HobbyRepo extends JpaRepository<Hobby, Long> {
    List<Hobby> findByJobSeekerId(Long jobSeekerId);

    Long id(Long id);
}
