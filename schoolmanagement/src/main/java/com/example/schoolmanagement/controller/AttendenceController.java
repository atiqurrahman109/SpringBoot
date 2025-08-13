package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.entity.Attendence;
import com.example.schoolmanagement.service.AttendenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/attendence")
@CrossOrigin("*")
public class AttendenceController {

   @Autowired
   private AttendenceService attendenceService;

    @PostMapping
    public Attendence add(@RequestBody Attendence attendence) {
        return attendenceService.save(attendence);
    }

    @GetMapping
    public List<Attendence> getAll() {
        return attendenceService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Attendence> getById(@PathVariable Integer id) {
        return attendenceService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        attendenceService.delete(id);
    }
}
