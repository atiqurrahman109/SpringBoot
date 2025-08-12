package com.example.schoolmanagement.service;

import com.example.schoolmanagement.entity.Attendence;

import com.example.schoolmanagement.repository.AttendenceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttendenceService {

    @Autowired
    private AttendenceRepo attendenceRepo;


    public Attendence save(Attendence attendence) {
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
