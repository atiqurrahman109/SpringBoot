package com.atik.sms.controller;

import com.atik.sms.entity.SchoolClass;

import com.atik.sms.service.SchoolClassService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/schoolClass")
@CrossOrigin(origins = "http://localhost:4200")
public class SchoolClassController {

    private final SchoolClassService service;

    public SchoolClassController(SchoolClassService service) {
        this.service = service;
    }
    @GetMapping
    public List<SchoolClass> getAll() {
        return service.getAll();
    }

    @PostMapping
    public SchoolClass add(@RequestBody SchoolClass schoolClass) {
        return service.save(schoolClass);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
