package com.atik.sms.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Entity
@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Builder
public class SchoolClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String className;
    private String section;

    @OneToMany(mappedBy = "schoolClass", cascade = CascadeType.ALL)
    private List<Student> students = new ArrayList<>();

    public SchoolClass() {
    }

    public SchoolClass(Long id, String className, String section, List<Student> students) {
        this.id = id;
        this.className = className;
        this.section = section;
        this.students = students;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}


