package com.atik.sms.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;  // e.g. "A", "B", "C"

    // 🔹 Many sections belong to one class
    @ManyToOne
    @JoinColumn(name = "class_id")
    private SchoolClass schoolClass;

    // 🔹 One section can have many students
    @OneToMany(mappedBy = "section", cascade = CascadeType.ALL)
    private List<Student> students;
}
