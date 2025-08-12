package entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name ="Students" )
public class Student {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
   private Integer id;          // Optional - for update cases
  private String firstName;
  private  String lastName;
  private String  dob;           // ISO date string, e.g. '2005-08-20'
  private String  gender;
  private String  email;
  private String  phone;
  private String  address;
private String clas;
private String section;

@OneToOne
    @JoinColumn(name = "student_id",nullable = false)
    private Student student;

@OneToMany(mappedBy = "student",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
@JsonBackReference
    private List<Teacher> teachers;

    public Student() {
    }

    public Student(Integer id, String firstName, String lastName, String dob, String gender, String email, String phone, String address, String clas, String section, Student student, List<Teacher> teachers) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.clas = clas;
        this.section = section;
        this.student = student;
        this.teachers = teachers;
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

    public String getClas() {
        return clas;
    }

    public void setClas(String clas) {
        this.clas = clas;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }
}
