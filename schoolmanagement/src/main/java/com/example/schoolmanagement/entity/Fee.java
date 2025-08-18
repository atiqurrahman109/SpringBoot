package com.example.schoolmanagement.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "student_fees")
public class Fee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // link to Student



    @Column(nullable = false)
    private String feeCategory;

    @Column(nullable = false)
    private String feeMonth;

    @Column(nullable = false)
    private Double feeAmount;

    private LocalDate paymentDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;// optional

    public Fee() {
    }

    public Fee(Integer id, String feeCategory, String feeMonth, Double feeAmount, LocalDate paymentDate, Student student) {
        this.id = id;
        this.feeCategory = feeCategory;
        this.feeMonth = feeMonth;
        this.feeAmount = feeAmount;
        this.paymentDate = paymentDate;
        this.student = student;
    }

    // getters & setters


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFeeCategory() {
        return feeCategory;
    }

    public void setFeeCategory(String feeCategory) {
        this.feeCategory = feeCategory;
    }

    public String getFeeMonth() {
        return feeMonth;
    }

    public void setFeeMonth(String feeMonth) {
        this.feeMonth = feeMonth;
    }

    public Double getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(Double feeAmount) {
        this.feeAmount = feeAmount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
