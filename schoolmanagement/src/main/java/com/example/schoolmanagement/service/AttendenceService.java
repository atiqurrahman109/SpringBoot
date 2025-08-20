package com.example.schoolmanagement.service;

import com.example.schoolmanagement.entity.Attendence;

import com.example.schoolmanagement.entity.Student;
import com.example.schoolmanagement.repository.AttendenceRepo;
import com.example.schoolmanagement.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttendenceService {

    @Autowired
    private AttendenceRepo attendenceRepo;

    @Autowired
    private StudentRepo studentRepo;


//    public Attendence save(Attendence attendence) {
//        return attendenceRepo.save(attendence);
//    }

    public Attendence saveAttendence(Attendence attendence, int studentId) {
        Student student=studentRepo.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"+studentId));

        attendence.setStudent(student);



        return attendenceRepo.save(attendence);


    }


    public List<Attendence> getAll() {
        return attendenceRepo.findAll();
    }


    public Optional<Attendence> getById(Integer id) {
        return attendenceRepo.findById(id);
    }


    public void delete(Integer id) {
        attendenceRepo.deleteById(id);
    }

}
