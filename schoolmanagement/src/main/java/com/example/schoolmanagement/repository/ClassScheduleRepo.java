package com.example.schoolmanagement.repository;

import com.example.schoolmanagement.entity.ClassSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassScheduleRepo extends JpaRepository<ClassSchedule,Integer> {
}
