package com.atik.sms.controller;

import com.atik.sms.entity.Exam;

import com.atik.sms.service.ExamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/exam")
@CrossOrigin(origins = "http://localhost:4200")
public class ExamController {
    private final ExamService service;

    public ExamController(ExamService service) {
        this.service = service;
    }

    @GetMapping
    public List<Exam> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Exam add(@RequestBody Exam exam) {
        return service.save(exam);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
