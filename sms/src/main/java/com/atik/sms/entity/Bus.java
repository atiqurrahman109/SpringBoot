package com.atik.sms.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Builder
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String busNumber;
    private String driverName;
    private String route;

    public Bus() {
    }

    public Bus(Long id, String busNumber, String driverName, String route) {
        this.id = id;
        this.busNumber = busNumber;
        this.driverName = driverName;
        this.route = route;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }
}

