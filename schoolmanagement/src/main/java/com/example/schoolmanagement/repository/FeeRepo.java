package com.example.schoolmanagement.repository;

import com.example.schoolmanagement.entity.Fee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeeRepo extends JpaRepository<Fee,Integer> {
    List<Fee> findByStudentId(Integer id);
    List<Fee> findByFeeMonth(String feeMonth);
}
