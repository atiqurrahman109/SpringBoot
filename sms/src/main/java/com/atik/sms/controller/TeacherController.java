package com.atik.sms.controller;

import com.atik.sms.entity.Fee;
import com.atik.sms.entity.Teacher;
import com.atik.sms.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/teacher")
@CrossOrigin(origins = "http://localhost:4200")
public class TeacherController {

    private final TeacherService service;

    public TeacherController(TeacherService service) {
        this.service = service;
    }
    @GetMapping
    public List<Teacher> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Teacher add(@RequestBody Teacher teacher) {
        return service.save(teacher);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
