package com.atik.sms.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FeeDTO {
    private Long id;
    private String category;
    private Double amount;
    private String paymentDate;
    private Long studentId;
}
