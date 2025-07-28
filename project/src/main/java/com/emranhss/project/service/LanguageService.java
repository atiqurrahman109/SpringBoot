package com.emranhss.project.service;

import com.emranhss.project.entity.Language;
import com.emranhss.project.repository.LanguageRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageService {
    private LanguageRepo languageRepo;

    public List<Language> getByJobSeekerId(Long jobSeekerId){
        return languageRepo.findByJobSeekerId(jobSeekerId);
    }
    public Language save(Language language){
        return languageRepo.save(language);
    }
    public void delete(Long id){
        languageRepo.deleteById(id);
    }
}
