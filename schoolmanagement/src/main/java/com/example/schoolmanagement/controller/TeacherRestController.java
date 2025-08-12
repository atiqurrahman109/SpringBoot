package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.entity.Student;
import com.example.schoolmanagement.entity.Teacher;
import com.example.schoolmanagement.service.StudentService;
import com.example.schoolmanagement.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/teacher")
@CrossOrigin("*")
public class TeacherRestController {

    @Autowired
    private TeacherService teacherService;
    //create
    @PostMapping("")
    public Teacher add(@RequestBody Teacher teacher) {
        return teacherService.save(teacher);
    }
    //read all
    @GetMapping("")
    public List<Teacher> findAll(){
        return teacherService.findAll();
    }

    //read one
    @GetMapping("/{id}")
    public Optional<Teacher> findById(@PathVariable Integer id){
        return teacherService.findById(id);
    }
}
