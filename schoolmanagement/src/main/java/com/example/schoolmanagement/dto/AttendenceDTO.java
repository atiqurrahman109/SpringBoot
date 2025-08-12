package com.example.schoolmanagement.dto;

public class AttendenceDTO {
    private Integer studentId;
    private String studentName;
    private String  className;
    private String  section;
    private String  attendanceDate;
    private String  status;

    public AttendenceDTO() {
    }

    public AttendenceDTO(Integer studentId, String studentName, String className, String section, String attendanceDate, String status) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.className = className;
        this.section = section;
        this.attendanceDate = attendanceDate;
        this.status = status;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(String attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
