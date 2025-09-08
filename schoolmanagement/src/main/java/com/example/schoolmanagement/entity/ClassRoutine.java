package com.example.schoolmanagement.entity;

import jakarta.persistence.*;

@Entity
public class ClassRoutine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer  id;          // optional unique id
    private String  className;    // e.g. "Grade 8"
    private String  subject;      // e.g. "Math"
    private String dayOfWeek;    // e.g. "Monday"
    private String startTime;    // e.g. "09:00"
    private String endTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name =" teacher_id")
    private Teacher  teacher;

    public ClassRoutine() {
    }

    public ClassRoutine(Integer id, String className, String subject, String dayOfWeek, String startTime, String endTime, Teacher teacher) {
        this.id = id;
        this.className = className;
        this.subject = subject;
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
        this.teacher = teacher;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
