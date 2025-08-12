package controller;


import entity.Student;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import service.StudentService;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/student")
@CrossOrigin("*")
public class StudentRestController {

@Autowired
   private StudentService studentService;
    //create
    @PostMapping("add")
    public Student add(@RequestBody Student student) {
        return studentService.save(student);
    }
    //read all
    @GetMapping("")
    public List<Student> findAll(){
        return studentService.findAll();
    }

    //read one
    @GetMapping("/{id}")
    public Optional<Student> findById(@PathVariable Integer id){
        return studentService.findById(id);
    }


}
