package com.example.schoolmanagement.dto;

public class ClassScheduleDTO {
    private Integer   id;                // Schedule ID
    private String  className;         // Class name (e.g., Grade 5, Class A)
    private String   section;           // Section (e.g., A, B)
    private String   subject;           // Subject name (e.g., Math, English)
    private String   teacherName;       // Assigned teacher
    private String   dayOfWeek;         // Day of the week (e.g., Monday)
    private String   startTime;         // Start time (HH:mm format)
    private String   endTime;

    public ClassScheduleDTO() {
    }

    public ClassScheduleDTO(Integer id, String className, String section, String subject, String teacherName, String dayOfWeek, String startTime, String endTime) {
        this.id = id;
        this.className = className;
        this.section = section;
        this.subject = subject;
        this.teacherName = teacherName;
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
