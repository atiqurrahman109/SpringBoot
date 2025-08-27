package com.example.schoolmanagement.dto;

import java.util.Date;

public class AttendenceDTO {
    private int id;
    private String  status;
    private Date attendanceDate;

    private StudentDTO student;

    public AttendenceDTO() {
    }

    public AttendenceDTO(int id, String status, Date attendanceDate, StudentDTO student) {
        this.id = id;
        this.status = status;
        this.attendanceDate = attendanceDate;
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }
}
