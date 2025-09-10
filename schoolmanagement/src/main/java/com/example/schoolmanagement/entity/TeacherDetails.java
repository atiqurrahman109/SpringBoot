package com.example.schoolmanagement.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tea_details")
public class TeacherDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "routine_id")
    private TeacherRoutine teacherRoutine;

    public TeacherDetails() {
    }

    public TeacherDetails(Long id, Teacher teacher, TeacherRoutine teacherRoutine) {
        this.id = id;
        this.teacher = teacher;
        this.teacherRoutine = teacherRoutine;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public TeacherRoutine getTeacherRoutine() {
        return teacherRoutine;
    }

    public void setTeacherRoutine(TeacherRoutine teacherRoutine) {
        this.teacherRoutine = teacherRoutine;
    }
}
