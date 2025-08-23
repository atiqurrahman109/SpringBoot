package com.example.schoolmanagement.repository;

import com.example.schoolmanagement.entity.Marks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarksRepo extends JpaRepository<Marks, Integer> {
}
