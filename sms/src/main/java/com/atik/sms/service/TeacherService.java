package com.atik.sms.service;

import com.atik.sms.entity.Teacher;
import com.atik.sms.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    private TeacherRepository repo;

    public TeacherService(TeacherRepository repo) {
        this.repo = repo;
    }

    public List<Teacher> getAll() {
        return repo.findAll();
    }

    public Teacher save(Teacher fee) {
        return repo.save(fee);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }


}
