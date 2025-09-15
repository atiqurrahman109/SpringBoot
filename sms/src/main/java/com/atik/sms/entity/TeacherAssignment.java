package com.atik.sms.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Builder
public class TeacherAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;


    @ManyToOne
    @JoinColumn(name = "class_id")
    private SchoolClass schoolClass;


    private String subject;

    public TeacherAssignment() {
    }

    public TeacherAssignment(Long id, Teacher teacher, SchoolClass schoolClass, String subject) {
        this.id = id;
        this.teacher = teacher;
        this.schoolClass = schoolClass;
        this.subject = subject;
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

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
