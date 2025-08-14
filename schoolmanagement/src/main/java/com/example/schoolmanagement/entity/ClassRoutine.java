package com.example.schoolmanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ClassRoutine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer  id;          // optional unique id
    private String  className;    // e.g. "Grade 8"
    private String  subject;      // e.g. "Math"
    private String teacherId;    // link to teacher
    private String  teacherName; // optional, populated when joining with teacher data
    private String dayOfWeek;    // e.g. "Monday"
    private String startTime;    // e.g. "09:00"
    private String endTime;

    public ClassRoutine() {
    }

    public ClassRoutine(Integer id, String className, String subject, String teacherId, String teacherName, String dayOfWeek, String startTime, String endTime) {
        this.id = id;
        this.className = className;
        this.subject = subject;
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
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

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
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
}
