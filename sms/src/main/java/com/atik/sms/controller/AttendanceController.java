package com.atik.sms.controller;

import com.atik.sms.entity.Attendance;

import com.atik.sms.service.AttendanceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class AttendanceController {
    private final AttendanceService service;

    public AttendanceController(AttendanceService service) {
        this.service = service;
    }
    @GetMapping
    public List<Attendance> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Attendance add(@RequestBody Attendance attendance) {
        return service.save(attendance);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
