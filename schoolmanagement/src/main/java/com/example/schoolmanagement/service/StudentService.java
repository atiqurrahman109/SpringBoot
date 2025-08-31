package com.example.schoolmanagement.service;

import com.example.schoolmanagement.dto.FeeDTO;
import com.example.schoolmanagement.dto.StudentDTO;
import com.example.schoolmanagement.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.schoolmanagement.repository.StudentRepo;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public List<Student> getAll(){
        return studentRepo.findAll();
    }

    public Optional<Student> getById(Integer id){
        return studentRepo.findById(id);
    }

    public Student save(Student student){
        return studentRepo.save(student);
    }

    public void deleteById(Integer id){
        studentRepo.deleteById(id);
    }

    public Student getProfileByUserId(int userid){
        return studentRepo.findById(userid)
                .orElseThrow(() -> new RuntimeException("User not found!!"));

    }


    public List<Student> findAll() {
        return studentRepo.findAll();
    }

    public Optional<Student> findById(Integer id)
    {return  studentRepo.findById(id);
    }


    public List<StudentDTO> getAllStuDTOS() {
        return studentRepo.findAll().stream().map(stu -> {
            StudentDTO dto = new StudentDTO();
            dto.setId(stu.getId());
            dto.setFirstName(stu.getFirstName());
            dto.setLastName(stu.getLastName());
            dto.setEmail(stu.getEmail());
            dto.setPhone(stu.getPhone());
            dto.setAddress(stu.getAddress());
            dto.setGender(stu.getGender());
            dto.setClas(stu.getClas());
            dto.setSection(stu.getSection());
            dto.setDob(stu.getDob());





            return dto;
        }).toList();
    }

    }

