package com.atik.sms.service;

import com.atik.sms.entity.TeacherAssignment;
import com.atik.sms.repository.TeacherAssignmentRepository;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class TeacherAssignmentService {
    private final TeacherAssignmentRepository repo;


    public TeacherAssignmentService(TeacherAssignmentRepository repo) {
        this.repo = repo;
    }


    public List<TeacherAssignment> getAll() { return repo.findAll(); }

    public TeacherAssignment getById(Long id) { return repo.findById(id).orElseThrow(); }

    public TeacherAssignment save(TeacherAssignment t) { return repo.save(t); }

    public void delete(Long id) { repo.deleteById(id); }

    public List<TeacherAssignment> findByTeacher(Long teacherId) { return repo.findByTeacherId(teacherId); }

    public List<TeacherAssignment> findByClass(Long classId) { return repo.findBySchoolClassId(classId); }
}
