package com.atik.sms.repository;
import com.atik.sms.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TeacherAssignmentRepository extends JpaRepository<TeacherAssignment, Long> {
    List<TeacherAssignment> findByTeacherId(Long teacherId);
    List<TeacherAssignment> findBySchoolClassId(Long classId);
}
