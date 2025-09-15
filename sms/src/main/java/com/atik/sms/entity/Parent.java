package com.atik.sms.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Builder
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fatherName;
    private String motherName;
    private String email;
    private String phone;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public Parent() {
    }

    public Parent(Long id, String fatherName, String motherName, String email, String phone, Student student) {
        this.id = id;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.email = email;
        this.phone = phone;
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
