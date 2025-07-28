package com.emranhss.project.service;

import com.emranhss.project.entity.Reference;
import com.emranhss.project.repository.LanguageRepo;
import com.emranhss.project.repository.ReferenceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReferenceService {
    @Autowired
    private ReferenceRepo referenceRepo;

    public List<Reference> getBYJobSeekerId(long jobSeekerId){
        return referenceRepo.findByJobSeekerId(jobSeekerId);
    }
    public  Reference save(Reference reference){
        return referenceRepo.save(reference);
    }
    public void delete(Long id){
        referenceRepo.deleteById(id);
    }
}
