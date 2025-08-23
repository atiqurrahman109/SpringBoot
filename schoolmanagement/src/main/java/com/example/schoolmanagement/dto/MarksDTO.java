package com.example.schoolmanagement.dto;

import java.time.LocalDate;

public class MarksDTO {
    private int id;

    private double marksObtained;
    private double totalMarks;
    private  String grade;
    private String status;

    private ExamDTO examDTO;
    private StudentDTO studentDTO;

    public MarksDTO() {
    }

    public MarksDTO(int id, double marksObtained, double totalMarks, String grade, String status, ExamDTO examDTO, StudentDTO studentDTO) {
        this.id = id;
        this.marksObtained = marksObtained;
        this.totalMarks = totalMarks;
        this.grade = grade;
        this.status = status;
        this.examDTO = examDTO;
        this.studentDTO = studentDTO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMarksObtained() {
        return marksObtained;
    }

    public void setMarksObtained(double marksObtained) {
        this.marksObtained = marksObtained;
    }

    public double getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(double totalMarks) {
        this.totalMarks = totalMarks;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ExamDTO getExamDTO() {
        return examDTO;
    }

    public void setExamDTO(ExamDTO examDTO) {
        this.examDTO = examDTO;
    }

    public StudentDTO getStudentDTO() {
        return studentDTO;
    }

    public void setStudentDTO(StudentDTO studentDTO) {
        this.studentDTO = studentDTO;
    }
}
