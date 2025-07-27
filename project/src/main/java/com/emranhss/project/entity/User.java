package com.emranhss.project.entity;

import jakarta.persistence.*;

@Entity
<<<<<<< HEAD
@Table(name = "users")

public class User {

=======
@Table(name= "users")

public class User {
>>>>>>> 8d70c07f5a7c06441d18095e23a545ae07b577e2
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
<<<<<<< HEAD
=======

>>>>>>> 8d70c07f5a7c06441d18095e23a545ae07b577e2
    @Column(unique = true)
    private String email;
    private String phone;
    private String password;
    private String photo;

    public User() {
    }

<<<<<<< HEAD
    public User(int id, String name, String email, String phone, String password, String photo) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.photo = photo;
=======
    public User(int id, String photo, String password, String phone, String email, String name) {
        this.id = id;
        this.photo = photo;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.name = name;
>>>>>>> 8d70c07f5a7c06441d18095e23a545ae07b577e2
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

<<<<<<< HEAD
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
=======
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
>>>>>>> 8d70c07f5a7c06441d18095e23a545ae07b577e2
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

<<<<<<< HEAD
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
=======
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
>>>>>>> 8d70c07f5a7c06441d18095e23a545ae07b577e2
    }
}
