package com.example.schoolmanagement.service;

import com.example.schoolmanagement.dto.MarksDTO;
import com.example.schoolmanagement.dto.StudentDTO;
import com.example.schoolmanagement.entity.Marks;
import com.example.schoolmanagement.entity.Student;
import com.example.schoolmanagement.repository.MarksRepo;
import com.example.schoolmanagement.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarksService {

    @Autowired
    private MarksRepo marksRepo;

    @Autowired
    private StudentRepo studentRepo;

    // ✅ Save or Update Marks
    public Marks saveOrUpdate(Marks marks) {
        // Ensure student exists
        Student student = studentRepo.findById(marks.getStudent().getId())
                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + marks.getStudent().getId()));

        marks.setStudent(student);

        // Auto-calculate total marks
        double total = marks.getMarksObtainedBangla()
                + marks.getMarksObtainedEnglish()
                + marks.getMarksObtainedMath();
        marks.setTotalMarks(total);

        // Auto-grade
        if (total >= 240) marks.setGrade("A+");
        else if (total >= 210) marks.setGrade("A");
        else if (total >= 180) marks.setGrade("B");
        else if (total >= 150) marks.setGrade("C");
        else if (total >= 120) marks.setGrade("D");
        else marks.setGrade("F");

        marks.setStatus(total >= 150 ? "Pass" : "Fail");

        return marksRepo.save(marks);
    }

    // ✅ Delete by ID
    public void deleteById(Integer id) {
        marksRepo.deleteById(id);
    }

    // ✅ Get all Marks as DTOs
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

            return dto;
        }).toList();
    }
}
