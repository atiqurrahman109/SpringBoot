package com.example.schoolmanagement.controller;

import com.example.schoolmanagement.dto.ExamDTO;
import com.example.schoolmanagement.entity.Exam;
import com.example.schoolmanagement.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exams")
@CrossOrigin("*")
public class ExamController {

    @Autowired
    private ExamService examService;

    @PostMapping("/save")
    public Exam saveExam(@RequestBody Exam exam) {
        return examService.saveOrUpdate(exam);
    }

    @GetMapping("/all")
    public List<ExamDTO> getAllExams() {
        return examService.getAllExams();
    }

    @GetMapping("/{id}")
    public ExamDTO getExam(@PathVariable Integer id) {
        return examService.getExamById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteExam(@PathVariable int id) {
        examService.deleteExam(id);
        return "Exam deleted successfully";
    }

}
