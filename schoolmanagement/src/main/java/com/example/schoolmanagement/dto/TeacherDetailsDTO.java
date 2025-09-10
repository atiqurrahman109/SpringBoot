package com.example.schoolmanagement.dto;

public class TeacherDetailsDTO {

    private Integer   id;          // Optional - for updates
    private String  firstName;
    private String   lastName;
    private String   dob;         // ISO date string e.g. "1985-07-15"
    private String   gender;
    private String   email;
    private String   phone;
    private String   address;
    private String   qualification; // e.g. "B.Sc in Mathematics"
    private String  experience;     // in years
    private String  subject;        // e.g. "Mathematics"
    private String   joiningDate;

    private TeacherRoutineDTO teacher;

    public TeacherDetailsDTO() {
    }

    public TeacherDetailsDTO(Integer id, String firstName, String lastName, String dob, String gender, String email, String phone, String address, String qualification, String experience, String subject, String joiningDate, TeacherRoutineDTO teacher) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.qualification = qualification;
        this.experience = experience;
        this.subject = subject;
        this.joiningDate = joiningDate;
        this.teacher = teacher;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    public TeacherRoutineDTO getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherRoutineDTO teacher) {
        this.teacher = teacher;
    }
}
