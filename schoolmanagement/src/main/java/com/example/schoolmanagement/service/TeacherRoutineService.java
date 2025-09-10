package com.example.schoolmanagement.service;

import com.example.schoolmanagement.dto.TeacherRoutineDTO;
import com.example.schoolmanagement.dto.TeacherDTO;
import com.example.schoolmanagement.entity.TeacherRoutine;
import com.example.schoolmanagement.entity.Teacher;
import com.example.schoolmanagement.repository.TeacherRoutineRepo;
import com.example.schoolmanagement.repository.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherRoutineService {

    @Autowired
    private TeacherRoutineRepo teacherRoutineRepo;

    @Autowired
    private TeacherRepo teacherRepo;





    public List<TeacherRoutine> getAllClassRoutines() {
        return teacherRoutineRepo.findAll();
    }

    public TeacherRoutine saveOrUpdate(TeacherRoutine teacherRoutine) {
        Teacher teacher = teacherRepo.findById(teacherRoutine.getTeacher().getId())
                .orElseThrow(() -> new RuntimeException("Production Order not found with id: " + teacherRoutine.getTeacher().getId()));



        teacherRoutine.setTeacher(teacher);


        return teacherRoutineRepo.save(teacherRoutine);
    }

    public void deleteById(Integer id) {
        teacherRoutineRepo.deleteById(id);
    }


    public List<TeacherRoutineDTO> getAllClassRoutineDTOS() {
        return teacherRoutineRepo.findAll().stream().map(teacherRoutine -> {
            TeacherRoutineDTO dto = new TeacherRoutineDTO();
            dto.setId(teacherRoutine.getId());
            dto.setClassName(teacherRoutine.getClassName());
            dto.setSubject(teacherRoutine.getSubject());
            dto.setEndTime(teacherRoutine.getEndTime());
            dto.setStartTime(teacherRoutine.getStartTime());
            dto.setDayOfWeek(teacherRoutine.getDayOfWeek());




            Teacher teacher = teacherRoutine.getTeacher();
            if (teacher != null) {
                TeacherDTO teacherDTO = new TeacherDTO();
                teacherDTO.setId(teacher.getId());
                teacherDTO.setFirstName(teacher.getFirstName());

                dto.setTeacher(teacherDTO);


            }
            return dto;
        }).toList();
    }

    // ✅ Get Cutting Plan  By Production Order Id  Code and return as DTOs

    public List<TeacherRoutineDTO> getClassRoutineByTeachersId(int id) {
        List<TeacherRoutine> teacherRoutines = teacherRoutineRepo.findAllRoutineByTeacherId(id);

        return teacherRoutines.stream().map(cut -> {
            // Map Production Order
            Teacher tea = cut.getTeacher();
            TeacherDTO teacherDTO = null;
            if (tea != null) {
                teacherDTO = new TeacherDTO();
                teacherDTO.setId(tea.getId());
                teacherDTO.setFirstName(tea.getFirstName());

            }



            // Map Class Routine by teacher
            TeacherRoutineDTO teacherRoutineDTO = new TeacherRoutineDTO();
            teacherRoutineDTO.setId(cut.getId());
            teacherRoutineDTO.setClassName(cut.getClassName());
            teacherRoutineDTO.setSubject(cut.getSubject());
            teacherRoutineDTO.setEndTime(cut.getEndTime());
            teacherRoutineDTO.setStartTime(cut.getStartTime());
            teacherRoutineDTO.setDayOfWeek(cut.getDayOfWeek());
            teacherRoutineDTO.setTeacher(teacherDTO);





            return teacherRoutineDTO;
        }).collect(Collectors.toList());
    }


    public List<TeacherRoutineDTO> getClassRoutineByTeacherIdAndDay(int id, String dayOfWeek) {
        List<TeacherRoutine> teacherRoutines = teacherRoutineRepo.findAllRoutineByTeacherIdAndDay(id, dayOfWeek);

        return teacherRoutines.stream().map(routine -> {
            Teacher teacher = routine.getTeacher();
            TeacherDTO teacherDTO = null;
            if (teacher != null) {
                teacherDTO = new TeacherDTO();
                teacherDTO.setId(teacher.getId());
                teacherDTO.setFirstName(teacher.getFirstName());
            }

            TeacherRoutineDTO dto = new TeacherRoutineDTO();
            dto.setId(routine.getId());
            dto.setClassName(routine.getClassName());
            dto.setSubject(routine.getSubject());
            dto.setEndTime(routine.getEndTime());
            dto.setStartTime(routine.getStartTime());
            dto.setDayOfWeek(routine.getDayOfWeek());
            dto.setTeacher(teacherDTO);

            return dto;
        }).collect(Collectors.toList());
    }


}
