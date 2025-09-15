package com.atik.sms.service;

import com.atik.sms.entity.Parent;
import com.atik.sms.repository.ParentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentService {

    private final ParentRepository parentRepo;

    public ParentService(ParentRepository parentRepo) {
        this.parentRepo = parentRepo;
    }

    public List<Parent> getAllParents() {
        return parentRepo.findAll();
    }

    public Parent getParentById(Long id) {
        return parentRepo.findById(id).orElse(null);
    }

    public Parent saveParent(Parent parent) {
        return parentRepo.save(parent);
    }

    public void deleteParent(Long id) {
        parentRepo.deleteById(id);
    }
}
