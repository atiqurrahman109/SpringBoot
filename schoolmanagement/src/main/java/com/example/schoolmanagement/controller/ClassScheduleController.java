package com.example.schoolmanagement.controller;

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
        ClassSchedule created = classScheduleService.saveSchedule(schedule);
        return ResponseEntity.ok(created);
    }

    // Get all schedules
    @GetMapping
    public ResponseEntity<List<ClassSchedule>> getAllSchedules() {
        List<ClassSchedule> schedules = classScheduleService.getAllSchedules();
        return ResponseEntity.ok(schedules);
    }

    // Get schedule by ID
    @GetMapping("/{id}")
    public ResponseEntity<ClassSchedule> getScheduleById(@PathVariable Integer id) {
        Optional<ClassSchedule> schedule = classScheduleService.getScheduleById(id);
        return schedule.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update schedule
    @PutMapping("/{id}")
    public ResponseEntity<ClassSchedule> updateSchedule(@PathVariable Integer id, @RequestBody ClassSchedule updatedSchedule) {
        Optional<ClassSchedule> existing = classScheduleService.getScheduleById(id);

        if (existing.isPresent()) {
            ClassSchedule schedule = existing.get();
            schedule.setClassName(updatedSchedule.getClassName());
            schedule.setSection(updatedSchedule.getSection());
            schedule.setSubject(updatedSchedule.getSubject());
            schedule.setTeacherName(updatedSchedule.getTeacherName());
            schedule.setDayOfWeek(updatedSchedule.getDayOfWeek());
            schedule.setStartTime(updatedSchedule.getStartTime());
            schedule.setEndTime(updatedSchedule.getEndTime());

            ClassSchedule saved = classScheduleService.saveSchedule(schedule);
            return ResponseEntity.ok(saved);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete schedule
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Integer id) {
        Optional<ClassSchedule> existing = classScheduleService.getScheduleById(id);

        if (existing.isPresent()) {
            classScheduleService.deleteSchedule(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
