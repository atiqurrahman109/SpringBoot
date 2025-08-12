package com.example.schoolmanagement.service;

import com.example.schoolmanagement.entity.Student;
import com.example.schoolmanagement.entity.Teacher;
import com.example.schoolmanagement.repository.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepo teacherRepo;
    public List<Teacher> getAll() {
        return teacherRepo.findAll();
    }

    public Optional<Teacher> getById(Integer id) {
        return teacherRepo.findById(id);
    }

    public Teacher save(Teacher teacher) {
        return teacherRepo.save(teacher);
    }

    public Teacher getProfileByUserId(Integer userid) {
        return teacherRepo.findById(userid)
                .orElseThrow(() -> new RuntimeException("User not found!!"));
    }


    public List<Teacher> findAll() {
        return teacherRepo.findAll();
    }


    public Optional<Teacher> findById(Integer id) {
        return teacherRepo.findById(id);
    }
}
