package com.example.schoolmanagement.dto;

import java.time.LocalDate;

public class FeeDTO {

    private Integer id;// only store id
    private String feeCategory;
    private String feeMonth;
    private Double feeAmount;
    private LocalDate paymentDate;




    // getters & setters


    public FeeDTO() {
    }

    public FeeDTO(Integer id, String feeCategory, String feeMonth, Double feeAmount, LocalDate paymentDate) {
        this.id = id;
        this.feeCategory = feeCategory;
        this.feeMonth = feeMonth;
        this.feeAmount = feeAmount;
        this.paymentDate = paymentDate;
    }

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
}
