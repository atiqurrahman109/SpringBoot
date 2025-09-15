package com.atik.sms.service;

import com.atik.sms.entity.Result;
import com.atik.sms.entity.SchoolClass;
import com.atik.sms.repository.SchoolClassRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolClassService {
    private final SchoolClassRepository repo;

    public SchoolClassService(SchoolClassRepository repository) {
        this.repo = repository;
    }

    public List<SchoolClass> getAll() {
        return repo.findAll();
    }

    public SchoolClass save(SchoolClass schoolClass) {
        return repo.save(schoolClass);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
