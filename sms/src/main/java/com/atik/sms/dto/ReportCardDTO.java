package com.atik.sms.dto;

import lombok.*;
import java.util.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReportCardDTO {
    private Long studentId;
    private String studentName;
    private String className;
    private String examName;
    private List<SubjectMarks> marks;


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SubjectMarks {
        private String subject;
        private Double marks;
        private String grade;
    }
}
