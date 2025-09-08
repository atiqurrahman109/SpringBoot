package com.example.schoolmanagement.service;

import com.example.schoolmanagement.dto.ClassRoutineDTO;
import com.example.schoolmanagement.dto.TeacherDTO;
import com.example.schoolmanagement.entity.ClassRoutine;
import com.example.schoolmanagement.entity.Teacher;
import com.example.schoolmanagement.repository.ClassRoutineRepo;
import com.example.schoolmanagement.repository.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClassRoutineService {

    @Autowired
    private ClassRoutineRepo classRoutineRepo;

    @Autowired
    private TeacherRepo teacherRepo;





    public List<ClassRoutine> getAllClassRoutines() {
        return classRoutineRepo.findAll();
    }

    public ClassRoutine saveOrUpdate(ClassRoutine classRoutine) {
        Teacher teacher = teacherRepo.findById(classRoutine.getTeacher().getId())
                .orElseThrow(() -> new RuntimeException("Production Order not found with id: " + classRoutine.getTeacher().getId()));



        classRoutine.setTeacher(teacher);


        return classRoutineRepo.save(classRoutine);
    }

    public void deleteById(Integer id) {
        classRoutineRepo.deleteById(id);
    }


    public List<ClassRoutineDTO> getAllClassRoutineDTOS() {
        return classRoutineRepo.findAll().stream().map(classRoutine -> {
            ClassRoutineDTO dto = new ClassRoutineDTO();
            dto.setId(classRoutine.getId());
            dto.setClassName(classRoutine.getClassName());
            dto.setSubject(classRoutine.getSubject());
            dto.setEndTime(classRoutine.getEndTime());
            dto.setStartTime(classRoutine.getStartTime());
            dto.setDayOfWeek(classRoutine.getDayOfWeek());




            Teacher teacher = classRoutine.getTeacher();
            if (teacher != null) {
                TeacherDTO teacherDTO = new TeacherDTO();
                teacherDTO.setId(teacher.getId());
                teacherDTO.setFirstName(teacher.getFirstName());

                dto.setTeacherDTO(teacherDTO);


            }
            return dto;
        }).toList();
    }

    // ✅ Get Cutting Plan  By Production Order Id  Code and return as DTOs

    public List<ClassRoutineDTO> getClassRoutineByTeachersId(int id) {
        List<ClassRoutine> classRoutines = classRoutineRepo.findAllRoutineByTeacherId(id);

        return classRoutines.stream().map(cut -> {
            // Map Production Order
            Teacher tea = cut.getTeacher();
            TeacherDTO teacherDTO = null;
            if (tea != null) {
                teacherDTO = new TeacherDTO();
                teacherDTO.setId(tea.getId());
                teacherDTO.setFirstName(tea.getFirstName());

            }



            // Map Class Routine by teacher
            ClassRoutineDTO classRoutineDTO = new ClassRoutineDTO();
            classRoutineDTO.setId(cut.getId());
            classRoutineDTO.setClassName(cut.getClassName());
            classRoutineDTO.setSubject(cut.getSubject());
            classRoutineDTO.setEndTime(cut.getEndTime());
            classRoutineDTO.setStartTime(cut.getStartTime());
            classRoutineDTO.setDayOfWeek(cut.getDayOfWeek());
            classRoutineDTO.setTeacherDTO(teacherDTO);





            return classRoutineDTO;
        }).collect(Collectors.toList());
    }


    public List<ClassRoutineDTO> getClassRoutineByTeacherIdAndDay(int id, String dayOfWeek) {
        List<ClassRoutine> classRoutines = classRoutineRepo.findAllRoutineByTeacherIdAndDay(id, dayOfWeek);

        return classRoutines.stream().map(routine -> {
            Teacher teacher = routine.getTeacher();
            TeacherDTO teacherDTO = null;
            if (teacher != null) {
                teacherDTO = new TeacherDTO();
                teacherDTO.setId(teacher.getId());
                teacherDTO.setFirstName(teacher.getFirstName());
            }

            ClassRoutineDTO dto = new ClassRoutineDTO();
            dto.setId(routine.getId());
            dto.setClassName(routine.getClassName());
            dto.setSubject(routine.getSubject());
            dto.setEndTime(routine.getEndTime());
            dto.setStartTime(routine.getStartTime());
            dto.setDayOfWeek(routine.getDayOfWeek());
            dto.setTeacherDTO(teacherDTO);

            return dto;
        }).collect(Collectors.toList());
    }


}
