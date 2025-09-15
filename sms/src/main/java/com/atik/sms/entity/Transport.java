package com.atik.sms.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vehicleNumber;
    private String driverName;
    private String route;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student; // Optional: assigned student
}
