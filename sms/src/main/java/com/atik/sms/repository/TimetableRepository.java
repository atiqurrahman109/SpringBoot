package com.atik.sms.repository;

import com.atik.sms.entity.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TimetableRepository extends JpaRepository<Timetable, Long> {
    List<Timetable> findBySchoolClass_Id(Long classId);
    List<Timetable> findByTeacher_Id(Long teacherId);
    List<Timetable> findByDayOfWeek(String dayOfWeek);
}
