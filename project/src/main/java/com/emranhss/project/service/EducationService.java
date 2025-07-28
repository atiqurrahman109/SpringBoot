package com.emranhss.project.service;

import com.emranhss.project.entity.Education;
import com.emranhss.project.repository.EducationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationService {
    @Autowired
    private EducationRepo educationRepo;

    public List<Education>getByJobSeekerId(long jobSeekerId){
        return educationRepo.findByJobSeekerId(jobSeekerId);
    }

    public Education save(Education education){
        return educationRepo.save(education);
    }
    public void delete(long id){
        educationRepo.deleteById(id);
    }
}
