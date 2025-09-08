package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.dto.ClassRoutineDTO;
import com.example.schoolmanagement.entity.ClassRoutine;
import com.example.schoolmanagement.service.ClassRoutineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/routine")
@CrossOrigin("*")
public class ClassRoutineController {

    @Autowired
    private ClassRoutineService classRoutineService;




    @GetMapping("all")
    public List<ClassRoutine> getAllClassRoutine() {
        return classRoutineService.getAllClassRoutines();
    }
    @GetMapping("")
    public List<ClassRoutineDTO> getAllClassRoutineDTO() {
        return classRoutineService.getAllClassRoutineDTOS();
    }


    @PostMapping("")
    public ResponseEntity<ClassRoutine> createClassRoutine(
            @RequestBody ClassRoutine classRoutine

    ) {

        ClassRoutine saved = classRoutineService.saveOrUpdate(classRoutine);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/teacher_id/{id}")
    public List<ClassRoutineDTO> getClassRoutineByTeacherId(@PathVariable int id) {
        return classRoutineService.getClassRoutineByTeachersId(id);
    }


    @GetMapping("/teacher_id/{id}/day/{dayOfWeek}")
    public List<ClassRoutineDTO> getClassRoutineByTeacherIdAndDay(
            @PathVariable int id,
            @PathVariable String dayOfWeek
    ) {
        return classRoutineService.getClassRoutineByTeacherIdAndDay(id, dayOfWeek);
    }

}


