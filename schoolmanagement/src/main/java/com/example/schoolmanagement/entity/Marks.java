package com.example.schoolmanagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "marks")
public class Marks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private float marksObtainedBangla;
    private float marksObtainedEnglish;
    private float marksObtainedMath;
    private float marksObtainedIslam;
    private float marksObtainedScience;
    private float marksObtainedSports;

    private Double gpa;
    private Double totalMarks;
    private String grade;
    private String status;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "exam_id", nullable = false)
    private Exam exam;



    public Marks() {
    }

    public Marks(int id, float marksObtainedBangla, float marksObtainedEnglish, float marksObtainedMath, float marksObtainedIslam, float marksObtainedScience, float marksObtainedSports, Double gpa, Double totalMarks, String grade, String status, Student student, Exam exam) {
        this.id = id;
        this.marksObtainedBangla = marksObtainedBangla;
        this.marksObtainedEnglish = marksObtainedEnglish;
        this.marksObtainedMath = marksObtainedMath;
        this.marksObtainedIslam = marksObtainedIslam;
        this.marksObtainedScience = marksObtainedScience;
        this.marksObtainedSports = marksObtainedSports;
        this.gpa = gpa;
        this.totalMarks = totalMarks;
        this.grade = grade;
        this.status = status;
        this.student = student;
        this.exam = exam;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
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

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public float getMarksObtainedIslam() {
        return marksObtainedIslam;
    }

    public void setMarksObtainedIslam(float marksObtainedIslam) {
        this.marksObtainedIslam = marksObtainedIslam;
    }

    public float getMarksObtainedScience() {
        return marksObtainedScience;
    }

    public void setMarksObtainedScience(float marksObtainedScience) {
        this.marksObtainedScience = marksObtainedScience;
    }

    public float getMarksObtainedSports() {
        return marksObtainedSports;
    }

    public void setMarksObtainedSports(float marksObtainedSports) {
        this.marksObtainedSports = marksObtainedSports;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }
}
