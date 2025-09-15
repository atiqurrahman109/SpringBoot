package com.atik.sms.repository;

import com.atik.sms.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TransportAssignmentRepository extends JpaRepository<TransportAssignment, Long> {
    List<TransportAssignment> findByStudentId(Long studentId);
}
