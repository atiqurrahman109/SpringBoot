package com.atik.sms.service;

import com.atik.sms.entity.Exam;
import com.atik.sms.repository.ExamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamService {
   private final ExamRepository repo;

    public ExamService(ExamRepository repo) {
        this.repo = repo;
    }

    public List<Exam> getAll() {
        return repo.findAll();
    }

    public Exam save(Exam exam) {
        return repo.save(exam);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}

