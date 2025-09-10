package com.example.schoolmanagement.service;

import com.example.schoolmanagement.dto.ClassScheduleDTO;
import com.example.schoolmanagement.dto.TeacherDTO;
import com.example.schoolmanagement.entity.ClassSchedule;
import com.example.schoolmanagement.entity.Teacher;
import com.example.schoolmanagement.repository.ClassScheduleRepo;
import com.example.schoolmanagement.repository.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassScheduleService {


    @Autowired
    private ClassScheduleRepo classScheduleRepo;
    @Autowired
    private TeacherRepo teacherRepo;

//        // Create or Update
//        public ClassSchedule saveSchedule(ClassSchedule schedule) {
//            return classScheduleRepo.save(schedule);
//        }
//
//        // Read all
//        public List<ClassSchedule> getAllSchedules() {
//            return classScheduleRepo.findAll();
//        }
//
//        // Read by ID
//        public Optional<ClassSchedule> getScheduleById(Integer id) {
//            return classScheduleRepo.findById(id);
//        }
//
//        // Delete
//        public void deleteSchedule(Integer id) {
//            classScheduleRepo.deleteById(id);
//        }


//    test


    public List<ClassSchedule> getAllSchedules() {
        return classScheduleRepo.findAll();
    }

    public ClassSchedule saveOrUpdate(ClassSchedule classSchedule) {
        return classScheduleRepo.save(classSchedule);
    }


    public List<ClassScheduleDTO> getAllClassScheduleDTOS() {
        return classScheduleRepo.findAll().stream().map(clScheule -> {
            ClassScheduleDTO dto = new ClassScheduleDTO();

            dto.setId(clScheule.getId());
            dto.setClassName(clScheule.getClassName());
            dto.setSection(clScheule.getSection());
            dto.setDayOfWeek(clScheule.getDayOfWeek());
            dto.setStartTime(clScheule.getStartTime());
            dto.setEndTime(clScheule.getEndTime());
            dto.setSubject(clScheule.getSubject());

            return dto;
        }).toList();
    }

    public void deleteClassScheduleById(int id) {
        classScheduleRepo.deleteById(id);
    }


}


