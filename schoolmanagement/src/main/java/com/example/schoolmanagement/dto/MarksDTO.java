package com.example.schoolmanagement.dto;

import java.time.LocalDate;

public class MarksDTO {
    private int id;

    private float marksObtainedBangla;
    private float marksObtainedEnglish;
    private float marksObtainedMath;
    private Double totalMarks;
    private String grade;
    private String status;

    private ExamDTO examDTO;
    private StudentDTO studentDTO;

    public MarksDTO() {
    }

    public MarksDTO(int id, float marksObtainedBangla, float marksObtainedEnglish, float marksObtainedMath, Double totalMarks, String grade, String status, ExamDTO examDTO, StudentDTO studentDTO) {
        this.id = id;
        this.marksObtainedBangla = marksObtainedBangla;
        this.marksObtainedEnglish = marksObtainedEnglish;
        this.marksObtainedMath = marksObtainedMath;
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

    public float getMarksObtainedBangla() {
        return marksObtainedBangla;
    }

    public void setMarksObtainedBangla(float marksObtainedBangla) {
        this.marksObtainedBangla = marksObtainedBangla;
    }

    public float getMarksObtainedEnglish() {
        return marksObtainedEnglish;
    }

    public void setMarksObtainedEnglish(float marksObtainedEnglish) {
        this.marksObtainedEnglish = marksObtainedEnglish;
    }

    public float getMarksObtainedMath() {
        return marksObtainedMath;
    }

    public void setMarksObtainedMath(float marksObtainedMath) {
        this.marksObtainedMath = marksObtainedMath;
    }

    public Double getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(Double totalMarks) {
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
