package com.example.schoolmanagement.entity;

import jakarta.persistence.*;
import org.yaml.snakeyaml.error.Mark;

import java.util.List;

@Entity
@Table(name = "exam")
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String examName;
    private String examMonth;

    @OneToMany(mappedBy = "exam", cascade = CascadeType.ALL)
    private List<Marks> marks;

    public Exam() {
    }

    public Exam(int id, String examName, String examMonth) {
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
