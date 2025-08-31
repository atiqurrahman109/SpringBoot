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

    // ✅ Save or Update Marks (Bangladesh National Grading System)
    public MarksDTO saveOrUpdate(Marks marks) {
        // Ensure student exists
        Student student = studentRepo.findById(marks.getStudent().getId())
                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + marks.getStudent().getId()));

        marks.setStudent(student);

        // 1️⃣ Calculate total
        double total = marks.getMarksObtainedBangla()
                + marks.getMarksObtainedEnglish()
                + marks.getMarksObtainedMath()
                + marks.getMarksObtainedScience()
                + marks.getMarksObtainedIslam()
                + marks.getMarksObtainedSports();
        marks.setTotalMarks(total);

        // 2️⃣ Apply grading per subject
        double[] subjectMarks = {
                marks.getMarksObtainedBangla(),
                marks.getMarksObtainedEnglish(),
                marks.getMarksObtainedMath(),
                marks.getMarksObtainedScience(),
                marks.getMarksObtainedIslam(),
                marks.getMarksObtainedSports()
        };

        double totalGpa = 0.0;
        boolean hasFail = false;

        for (double subjectMark : subjectMarks) {
            double point = getGradePoint(subjectMark);
            if (point == 0.0) {
                hasFail = true;
            }
            totalGpa += point;
        }

        // 3️⃣ Final GPA & Grade
        if (hasFail) {
            marks.setGpa(0.00);
            marks.setGrade("F");
            marks.setStatus("Fail");
        } else {
            double gpa = totalGpa / subjectMarks.length;
            marks.setGpa(roundTwoDecimals(gpa));
            marks.setGrade(getFinalGrade(gpa));
            marks.setStatus("Pass");
        }

        Marks saved = marksRepo.save(marks);
        return convertToDTO(saved);
    }

    // ✅ Helper: Convert marks → grade point
    private double getGradePoint(double mark) {
        if (mark >= 80) return 5.00;
        else if (mark >= 70) return 4.00;
        else if (mark >= 60) return 3.50;
        else if (mark >= 50) return 3.00;
        else if (mark >= 40) return 2.00;
        else if (mark >= 33) return 1.00;
        else return 0.00; // Fail
    }

    // ✅ Helper: GPA → Final Grade
    private String getFinalGrade(double gpa) {
        if (gpa == 5.00) return "A+";
        else if (gpa >= 4.00) return "A";
        else if (gpa >= 3.50) return "A-";
        else if (gpa >= 3.00) return "B";
        else if (gpa >= 2.00) return "C";
        else if (gpa >= 1.00) return "D";
        else return "F";
    }

    // ✅ Helper: Round to 2 decimals
    private double roundTwoDecimals(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    // ✅ Delete by ID
    public void deleteById(Integer id) {
        if (!marksRepo.existsById(id)) {
            throw new RuntimeException("Marks not found with ID: " + id);
        }
        marksRepo.deleteById(id);
    }

    // ✅ Get all Marks as DTOs
    public List<MarksDTO> getAllMarksDTOS() {
        return marksRepo.findAll().stream()
                .map(this::convertToDTO)
                .toList();
    }

    // ✅ Convert Entity → DTO
    private MarksDTO convertToDTO(Marks mark) {
        MarksDTO dto = new MarksDTO();
        dto.setId(mark.getId());
        dto.setMarksObtainedBangla(mark.getMarksObtainedBangla());
        dto.setMarksObtainedEnglish(mark.getMarksObtainedEnglish());
        dto.setMarksObtainedMath(mark.getMarksObtainedMath());
        dto.setMarksObtainedScience(mark.getMarksObtainedScience());
        dto.setMarksObtainedIslam(mark.getMarksObtainedIslam());
        dto.setMarksObtainedSports(mark.getMarksObtainedSports());
        dto.setTotalMarks(mark.getTotalMarks());
        dto.setGpa(mark.getGpa());
        dto.setGrade(mark.getGrade());
        dto.setStatus(mark.getStatus());

        Student student = mark.getStudent();
        if (student != null) {
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setId(student.getId());
            studentDTO.setFirstName(student.getFirstName());
            studentDTO.setLastName(student.getLastName());
            dto.setStudentDTO(studentDTO);
        }
        return dto;
    }


}
