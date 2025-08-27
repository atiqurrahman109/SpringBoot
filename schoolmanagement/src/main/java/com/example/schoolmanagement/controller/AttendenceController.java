package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.dto.AttendenceDTO;
import com.example.schoolmanagement.entity.Attendence;
import com.example.schoolmanagement.entity.Fee;
import com.example.schoolmanagement.service.AttendenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/attendence")
@CrossOrigin("*")
public class AttendenceController {

   @Autowired
   private AttendenceService attendenceService;

    @PostMapping("")
    public ResponseEntity<Attendence> createAttendence(
            @RequestBody Attendence attendence

    ) {

        Attendence saved = attendenceService.saveOrUpdate(attendence);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("all")
    public List<Attendence> getAll() {
        return attendenceService.getAll();
    }

    @GetMapping("")
    public List<AttendenceDTO> getAllAttendenceDTO() {
        return attendenceService.getAlAttendenceDTOS();
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
