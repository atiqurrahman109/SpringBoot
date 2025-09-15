package com.atik.sms.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@Builder
public class Timetable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dayOfWeek;   // e.g. MONDAY
    private Integer periodNumber; // 1, 2, 3

    @ManyToOne
    @JoinColumn(name = "class_id")
    private SchoolClass schoolClass;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    private String subject;

    public Timetable() {
    }

    public Timetable(Long id, String dayOfWeek, Integer periodNumber, SchoolClass schoolClass, Teacher teacher, String subject) {
        this.id = id;
        this.dayOfWeek = dayOfWeek;
        this.periodNumber = periodNumber;
        this.schoolClass = schoolClass;
        this.teacher = teacher;
        this.subject = subject;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Integer getPeriodNumber() {
        return periodNumber;
    }

    public void setPeriodNumber(Integer periodNumber) {
        this.periodNumber = periodNumber;
    }

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
