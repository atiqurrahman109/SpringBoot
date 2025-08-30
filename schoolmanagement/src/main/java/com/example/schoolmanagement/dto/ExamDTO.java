package com.example.schoolmanagement.dto;

public class ExamDTO {
    private int id;
    private String examName;
    private String examMonth;



    public ExamDTO() {
    }

    public ExamDTO(int id, String examName, String examMonth) {
        this.id = id;
        this.examName = examName;
        this.examMonth = examMonth;
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

    public String getExamMonth() {
        return examMonth;
    }

    public void setExamMonth(String examMonth) {
        this.examMonth = examMonth;
    }
}
