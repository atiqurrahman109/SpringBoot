package com.atik.sms.controller;
import com.atik.sms.entity.Timetable;
import com.atik.sms.service.TimetableService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/timetables")
@CrossOrigin(origins = "http://localhost:4200")
public class TimetableController {

    private final TimetableService timetableService;

    public TimetableController(TimetableService timetableService) {
        this.timetableService = timetableService;
    }

    @GetMapping
    public List<Timetable> getAll() {
        return timetableService.getAllTimetables();
    }

    @GetMapping("/{id}")
    public Timetable getById(@PathVariable Long id) {
        return timetableService.getTimetableById(id);
    }

    @PostMapping
    public Timetable save(@RequestBody Timetable timetable) {
        return timetableService.saveTimetable(timetable);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        timetableService.deleteTimetable(id);
        return ResponseEntity.noContent().build();
    }

    // Extra filters
    @GetMapping("/class/{classId}")
    public List<Timetable> getByClass(@PathVariable Long classId) {
        return timetableService.getByClass(classId);
    }

    @GetMapping("/teacher/{teacherId}")
    public List<Timetable> getByTeacher(@PathVariable Long teacherId) {
        return timetableService.getByTeacher(teacherId);
    }

    @GetMapping("/day/{day}")
    public List<Timetable> getByDay(@PathVariable String day) {
        return timetableService.getByDay(day);
    }
}
