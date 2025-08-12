package com.example.schoolmanagement.repository;

import com.example.schoolmanagement.entity.Attendence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendenceRepo extends JpaRepository<Attendence,Integer> {
}
