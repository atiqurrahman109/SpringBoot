package com.example.schoolmanagement.service;

import com.example.schoolmanagement.dto.TeacherDTO;
import com.example.schoolmanagement.dto.TeacherDetailsDTO;
import com.example.schoolmanagement.dto.TeacherRoutineDTO;
import com.example.schoolmanagement.entity.Student;
import com.example.schoolmanagement.entity.Teacher;
import com.example.schoolmanagement.entity.TeacherRoutine;
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





    // view details

    public List<TeacherDetailsDTO> getTeacherDetailsDTOSDTOS() {
        return teacherRepo.findAll().stream().map(teacher -> {
            TeacherDetailsDTO dto = new TeacherDetailsDTO();

            dto.setId(teacher.getId());
            dto.setFirstName(teacher.getFirstName());
            dto.setLastName(teacher.getLastName());
            dto.setEmail(teacher.getEmail());
            dto.setAddress(teacher.getAddress());
            dto.setPhone(teacher.getPhone());
            dto.setDob(teacher.getDob());
            dto.setGender(teacher.getGender());
            dto.setExperience(teacher.getExperience());
            dto.setJoiningDate(teacher.getJoiningDate());
            dto.setPhone(teacher.getPhone());
            dto.setQualification(teacher.getQualification());


            return dto;
        }).toList();
    }

    public void deleteTeacher(Integer id) {
        teacherRepo.deleteById(id);
    }
}
