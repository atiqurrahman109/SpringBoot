package com.atik.sms.repository;

import com.atik.sms.entity.Fee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeeRepository extends JpaRepository<Fee, Long> {
    List<Fee> findByFeeMonth(String feeMonth);
}
