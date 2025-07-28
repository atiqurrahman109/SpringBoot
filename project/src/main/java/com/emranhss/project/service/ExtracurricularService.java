package com.emranhss.project.service;

import com.emranhss.project.entity.Extracurricular;
import com.emranhss.project.repository.ExtracurricularRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExtracurricularService {
    @Autowired
    private ExtracurricularRepo extracurricularRepo;

    public List<Extracurricular> getByJobSeekerId(Long jobSeekerId){
       return extracurricularRepo.findByJobSeekerId(jobSeekerId);

    }
    public Extracurricular save(Extracurricular extracurricular){
        return extracurricularRepo.save(extracurricular);
    }
    public void delete(Long id){
        extracurricularRepo.deleteById(id);
    }
}
