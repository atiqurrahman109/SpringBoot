package com.example.schoolmanagement.dto;

public class ExamDTO {
    private int id;
    private String examName;
    private String examType;

    public ExamDTO() {
    }

    public ExamDTO(int id, String examName, String examType) {
        this.id = id;
        this.examName = examName;
        this.examType = examType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getExamType() {
        return examType;
    }

    public void setExamType(String examType) {
        this.examType = examType;
    }
}
