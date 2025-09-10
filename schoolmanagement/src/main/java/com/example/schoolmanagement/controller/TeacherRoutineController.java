package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.dto.TeacherRoutineDTO;
import com.example.schoolmanagement.entity.TeacherRoutine;
import com.example.schoolmanagement.service.TeacherRoutineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/routine")
@CrossOrigin("*")
public class TeacherRoutineController {

    @Autowired
    private TeacherRoutineService teacherRoutineService;




    @GetMapping("all")
    public List<TeacherRoutine> getAllClassRoutine() {
        return teacherRoutineService.getAllClassRoutines();
    }
    @GetMapping("")
    public List<TeacherRoutineDTO> getAllClassRoutineDTO() {
        return teacherRoutineService.getAllClassRoutineDTOS();
    }


    @PostMapping("")
    public ResponseEntity<TeacherRoutine> createClassRoutine(
            @RequestBody TeacherRoutine teacherRoutine

    ) {

        TeacherRoutine saved = teacherRoutineService.saveOrUpdate(teacherRoutine);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/teacher_id/{id}")
    public List<TeacherRoutineDTO> getClassRoutineByTeacherId(@PathVariable int id) {
        return teacherRoutineService.getClassRoutineByTeachersId(id);
    }


    @GetMapping("/teacher_id/{id}/day/{dayOfWeek}")
    public List<TeacherRoutineDTO> getClassRoutineByTeacherIdAndDay(
            @PathVariable int id,
            @PathVariable String dayOfWeek
    ) {
        return teacherRoutineService.getClassRoutineByTeacherIdAndDay(id, dayOfWeek);
    }

}


