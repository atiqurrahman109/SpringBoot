package com.example.schoolmanagement.repository;

import com.example.schoolmanagement.entity.ClassRoutine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassRoutineRepo extends JpaRepository<ClassRoutine, Integer> {
    List<ClassRoutine> findByClassName(String className);

}
