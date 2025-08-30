package com.example.schoolmanagement.service;

import com.example.schoolmanagement.dto.ExamDTO;
import com.example.schoolmanagement.entity.Exam;
import com.example.schoolmanagement.repository.ExamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExamService {

    @Autowired
    private ExamRepo examRepo;

    //save or update
    public Exam saveOrUpdate(Exam exam) {
        return examRepo.save(exam);
    }

    //get all exam
    public List<ExamDTO> getAllExams() {
        return examRepo.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    // Get exam by ID
    public ExamDTO getExamById(int id) {
        return examRepo.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new RuntimeException("exam not found"));
    }
    // Delete exam
    public void deleteExam(int id) {
        examRepo.deleteById(id);
    }
    // Convert entity to DTO
    private ExamDTO convertToDTO(Exam exam) {
        return new ExamDTO(exam.getId(), exam.getExamName(), exam.getExamMonth());
    }

    }

