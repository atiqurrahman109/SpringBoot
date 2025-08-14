package com.example.schoolmanagement.service;

import com.example.schoolmanagement.dto.ClassRoutineDTO;
import com.example.schoolmanagement.entity.ClassRoutine;
import com.example.schoolmanagement.repository.ClassRoutineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClassRoutineService {

    @Autowired
    private ClassRoutineRepo classRoutineRepo;

    // ✅ Get all class routines
    public List<ClassRoutineDTO> getAllRoutines() {
        return classRoutineRepo.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // ✅ Get one routine by ID
    public ClassRoutineDTO getRoutineById(Integer id) {
        Optional<ClassRoutine> routine = classRoutineRepo.findById(id);
        return routine.map(this::convertToDTO).orElse(null);
    }

    // ✅ Create new routine
    public ClassRoutineDTO createRoutine(ClassRoutineDTO dto) {
        ClassRoutine routine = convertToEntity(dto);
        return convertToDTO(classRoutineRepo.save(routine));
    }

    // ✅ Update existing routine
    public ClassRoutineDTO updateRoutine(Integer id, ClassRoutineDTO dto) {
        Optional<ClassRoutine> optional = classRoutineRepo.findById(id);
        if (optional.isPresent()) {
            ClassRoutine routine = optional.get();
            routine.setClassName(dto.getClassName());
            routine.setSubject(dto.getSubject());
            routine.setTeacherId(dto.getTeacherId());
            routine.setTeacherName(dto.getTeacherName());
            routine.setDayOfWeek(dto.getDayOfWeek());
            routine.setStartTime(dto.getStartTime());
            routine.setEndTime(dto.getEndTime());
            return convertToDTO(classRoutineRepo.save(routine));
        }
        return null;
    }

    // ✅ Delete routine
    public void deleteRoutine(Integer id) {
        classRoutineRepo.deleteById(id);
    }

    // ✅ Convert Entity to DTO
    private ClassRoutineDTO convertToDTO(ClassRoutine entity) {
        return new ClassRoutineDTO(
                entity.getId(),
                entity.getClassName(),
                entity.getSubject(),
                entity.getTeacherId(),
                entity.getTeacherName(),
                entity.getDayOfWeek(),
                entity.getStartTime(),
                entity.getEndTime()
        );
    }

    // ✅ Convert DTO to Entity
    private ClassRoutine convertToEntity(ClassRoutineDTO dto) {
        return new ClassRoutine(
                dto.getId(),
                dto.getClassName(),
                dto.getSubject(),
                dto.getTeacherId(),
                dto.getTeacherName(),
                dto.getDayOfWeek(),
                dto.getStartTime(),
                dto.getEndTime()
        );
    }

    public List<ClassRoutineDTO> getRoutinesByClassName(String className) {
        return classRoutineRepo.findByClassName(className).stream().map(this::convertToDTO).collect(Collectors.toList());
    }

}
