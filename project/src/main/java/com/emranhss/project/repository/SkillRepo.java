package com.emranhss.project.repository;

import com.emranhss.project.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillRepo extends JpaRepository<Skill,Long> {
    List<Skill> findByJobSeekerId(Long jobSeekerId);
}
