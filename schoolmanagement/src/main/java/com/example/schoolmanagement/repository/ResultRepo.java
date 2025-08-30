package com.example.schoolmanagement.repository;

import com.example.schoolmanagement.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepo extends JpaRepository<Result,Integer> {
}
