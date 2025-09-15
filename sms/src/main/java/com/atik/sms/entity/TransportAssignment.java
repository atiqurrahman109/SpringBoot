package com.atik.sms.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Builder
public class TransportAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;


    @ManyToOne
    @JoinColumn(name = "bus_id")
    private Bus bus;


    private String pickupPoint;
    private String dropPoint;

    public TransportAssignment() {
    }

    public TransportAssignment(Long id, Student student, Bus bus, String pickupPoint, String dropPoint) {
        this.id = id;
        this.student = student;
        this.bus = bus;
        this.pickupPoint = pickupPoint;
        this.dropPoint = dropPoint;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public String getPickupPoint() {
        return pickupPoint;
    }

    public void setPickupPoint(String pickupPoint) {
        this.pickupPoint = pickupPoint;
    }

    public String getDropPoint() {
        return dropPoint;
    }

    public void setDropPoint(String dropPoint) {
        this.dropPoint = dropPoint;
    }
}