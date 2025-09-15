package com.atik.sms.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String dob;
    private String gender;
    private String address;
    private String className;
    private String section;
}
