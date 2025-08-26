package com.example.schoolmanagement.service;

import com.example.schoolmanagement.dto.ExamDTO;
import com.example.schoolmanagement.dto.MarksDTO;
import com.example.schoolmanagement.dto.StudentDTO;
import com.example.schoolmanagement.entity.Exam;
import com.example.schoolmanagement.entity.Marks;
import com.example.schoolmanagement.entity.Student;
import com.example.schoolmanagement.repository.ExamRepo;

import com.example.schoolmanagement.repository.MarksRepo;

import com.example.schoolmanagement.repository.StudentRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MarksService {

    @Autowired
    private MarksRepo marksRepo;

    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private ExamRepo examrepo;



    // Save or Update

    public Marks saveOrUpdate(Marks marks) {
        Student student = studentRepo.findById(marks.getStudent().getId())
                .orElseThrow(() -> new RuntimeException("Marks not found with id: " + marks.getStudent().getId()));

        Exam exam = examrepo.findById(marks.getExam().getId())
                .orElseThrow(() -> new RuntimeException("Exam not found with id: " + marks.getExam().getId()));

        marks.setStudent(student);
        marks.setExam(exam);

        return marksRepo.save(marks);
    }


    public void deleteById(Integer id) {
        marksRepo.deleteById(id);
    }
   


//    // ✅ New Service Method: Get BOMs by Style Code
//    public List<BOM> getBOMsByStyleCode(String styleCode) {
//        return bomRepo.findAllByStyleCode(styleCode);
//    }


    // ✅ Get BOMs by Style Code and return as DTOs
    public List<MarksDTO> getAllMarksDTOS() {
        return marksRepo.findAll().stream().map(mark -> {
            MarksDTO dto = new MarksDTO();
            dto.setId(mark.getId());
            dto.setMarksObtainedBangla(mark.getMarksObtainedBangla());
            dto.setMarksObtainedEnglish(mark.getMarksObtainedEnglish());
            dto.setMarksObtainedMath(mark.getMarksObtainedMath());
            dto.setTotalMarks(mark.getTotalMarks());
            dto.setGrade(mark.getGrade());
            dto.setStatus(mark.getStatus());

            Student student = mark.getStudent();
            if (student != null) {
                StudentDTO studentDTO = new StudentDTO();
                studentDTO.setId(student.getId());
                studentDTO.setFirstName(student.getFirstName());

                dto.setStudentDTO(studentDTO);




            }

            Exam exam = mark.getExam();
            if (exam != null) {
                ExamDTO examDTO = new ExamDTO();
                examDTO.setId(exam.getId());
                examDTO.setExamName(exam.getExamName());

                dto.setExamDTO(examDTO);

            }


            return dto;
        }).toList();
    }
}
jhggfdsasff