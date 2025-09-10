package com.example.schoolmanagement.repository;

import com.example.schoolmanagement.entity.TeacherRoutine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TeacherRoutineRepo extends JpaRepository<TeacherRoutine, Integer> {
    List<TeacherRoutine> findByClassName(String className);

    @Query("SELECT b FROM TeacherRoutine b WHERE b.teacher.id = :id")
    List<TeacherRoutine> findAllRoutineByTeacherId(@Param("id") int id);


    @Query("SELECT c FROM TeacherRoutine c WHERE c.teacher.id = :id AND c.dayOfWeek = :dayOfWeek")
    List<TeacherRoutine> findAllRoutineByTeacherIdAndDay(
            @Param("id") int id,
            @Param("dayOfWeek") String dayOfWeek
    );


}
