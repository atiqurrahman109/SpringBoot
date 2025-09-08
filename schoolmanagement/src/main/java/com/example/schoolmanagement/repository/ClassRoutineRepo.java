package com.example.schoolmanagement.repository;

import com.example.schoolmanagement.entity.ClassRoutine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClassRoutineRepo extends JpaRepository<ClassRoutine, Integer> {
    List<ClassRoutine> findByClassName(String className);

    @Query("SELECT b FROM ClassRoutine b WHERE b.teacher.id = :id")
    List<ClassRoutine> findAllRoutineByTeacherId(@Param("id") int id);


    @Query("SELECT c FROM ClassRoutine c WHERE c.teacher.id = :id AND c.dayOfWeek = :dayOfWeek")
    List<ClassRoutine> findAllRoutineByTeacherIdAndDay(
            @Param("id") int id,
            @Param("dayOfWeek") String dayOfWeek
    );


}
