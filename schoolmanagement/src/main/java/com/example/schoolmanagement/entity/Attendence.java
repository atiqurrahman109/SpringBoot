package com.example.schoolmanagement.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "attendences")
public class Attendence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String studentName;
    private String className;
    private String section;
    private String attendanceDate;
    private String status;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studentId")
    private Student student;

    public Attendence() {
    }

    public Attendence(Integer id, String studentName, String className, String section, String attendanceDate, String status, Student student) {
        this.id = id;
        this.studentName = studentName;
        this.className = className;
        this.section = section;
        this.attendanceDate = attendanceDate;
        this.status = status;
        this.student = student;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(String attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
