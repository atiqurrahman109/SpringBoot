package com.atik.sms.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Builder
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String examName;
    private String subject;
    private String date;

    public Exam() {
    }

    public Exam(Long id, String examName, String subject, String date) {
        this.id = id;
        this.examName = examName;
        this.subject = subject;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
