package com.example.schoolmanagement.service;

import com.example.schoolmanagement.entity.ClassSchedule;
import com.example.schoolmanagement.repository.ClassScheduleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassScheduleService {



        @Autowired
        private ClassScheduleRepo classScheduleRepo;

        // Create or Update
        public ClassSchedule saveSchedule(ClassSchedule schedule) {
            return classScheduleRepo.save(schedule);
        }

        // Read all
        public List<ClassSchedule> getAllSchedules() {
            return classScheduleRepo.findAll();
        }

        // Read by ID
        public Optional<ClassSchedule> getScheduleById(Integer id) {
            return classScheduleRepo.findById(id);
        }

        // Delete
        public void deleteSchedule(Integer id) {
            classScheduleRepo.deleteById(id);
        }
    }


