package com.emranhss.project.service;

import com.emranhss.project.entity.Experience;
import com.emranhss.project.repository.ExperienceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceService {
    @Autowired
    private ExperienceRepo experienceRepo;

    public List<Experience> getByJobSeekerId(long jobSeekerId){
        return experienceRepo.findByJobSeekerId(jobSeekerId);
    }
    public Experience Save(Experience experience)
    {
        return experienceRepo.save(experience);
    }

    public void delete(Long id)
    {
        experienceRepo.deleteById(id);
    }
}
