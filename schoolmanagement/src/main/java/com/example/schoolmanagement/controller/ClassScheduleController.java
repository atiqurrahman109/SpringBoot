package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.dto.ClassScheduleDTO;
import com.example.schoolmanagement.entity.ClassSchedule;
import com.example.schoolmanagement.service.ClassScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/schedule")
@CrossOrigin("*")
public class ClassScheduleController {

    @Autowired
    private ClassScheduleService classScheduleService;

    // Create a new schedule
    @PostMapping
    public ResponseEntity<ClassSchedule> createSchedule(@RequestBody ClassSchedule schedule) {
        ClassSchedule created = classScheduleService.saveOrUpdate(schedule);
        return ResponseEntity.ok(created);
    }

    // Get all schedules
    @GetMapping("all")
    public ResponseEntity<List<ClassSchedule>> getAllSchedules() {
        List<ClassSchedule> schedules = classScheduleService.getAllSchedules();
        return ResponseEntity.ok(schedules);
    }


    @GetMapping("")
    public List<ClassScheduleDTO>  getSchedules() {
       return classScheduleService.getAllClassScheduleDTOS();
    }

    @DeleteMapping("/{id}")
    public void deleteSchedule(@PathVariable Integer id) {
        classScheduleService.deleteClassScheduleById(id);
    }


}
