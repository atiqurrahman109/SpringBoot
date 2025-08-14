package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.dto.ClassRoutineDTO;
import com.example.schoolmanagement.service.ClassRoutineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/routine")
@CrossOrigin("*")
public class ClassRoutineController {

    @Autowired
    private ClassRoutineService classRoutineService;

    // Handle both "all" and "by className" in the same endpoint
    @GetMapping
    public List<ClassRoutineDTO> getRoutines(@RequestParam(required = false) String className) {
        if (className != null && !className.isEmpty()) {
            return classRoutineService.getRoutinesByClassName(className);
        }
        return classRoutineService.getAllRoutines();
    }

    @GetMapping("/{id}")
    public ClassRoutineDTO getRoutineById(@PathVariable Integer id) {
        return classRoutineService.getRoutineById(id);
    }

    @PostMapping
    public ClassRoutineDTO createRoutine(@RequestBody ClassRoutineDTO dto) {
        return classRoutineService.createRoutine(dto);
    }

    @PutMapping("/{id}")
    public ClassRoutineDTO updateRoutine(@PathVariable Integer id, @RequestBody ClassRoutineDTO dto) {
        return classRoutineService.updateRoutine(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteRoutine(@PathVariable Integer id) {
        classRoutineService.deleteRoutine(id);
    }
}
