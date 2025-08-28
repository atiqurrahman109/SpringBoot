package com.example.schoolmanagement.service;

import com.example.schoolmanagement.dto.AttendenceDTO;
import com.example.schoolmanagement.dto.StudentDTO;
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

//    public Attendence saveAttendence(Attendence attendence, int studentId) {
//        Student student=studentRepo.findById(studentId)
//                .orElseThrow(() -> new RuntimeException("Student not found"+studentId));
//
//        attendence.setStudent(student);
//
//
//
//        return attendenceRepo.save(attendence);
//
//
//    }


    public Attendence saveOrUpdate(Attendence attendence) {
        Student student = studentRepo.findById(attendence.getStudent().getId())
                .orElseThrow(() -> new RuntimeException("Student  not found with id: " + attendence.getStudent().getId()));



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



    public List<AttendenceDTO> getAlAttendenceDTOS() {
        return attendenceRepo.findAll().stream().map(atten -> {
            AttendenceDTO dto = new AttendenceDTO();
            dto.setId(atten.getId());
            dto.setAttendanceDate(atten.getAttendanceDate());
            dto.setStatus(atten.getStatus());





            Student student = atten.getStudent();
            if (student != null) {
                StudentDTO studentDTO = new StudentDTO();
                studentDTO.setId(student.getId());
                studentDTO.setFirstName(student.getFirstName());
                studentDTO.setClas(student.getClas());
                studentDTO.setSection(student.getSection());


                dto.setStudent(studentDTO);


            }




            return dto;
        }).toList();
    }

}
