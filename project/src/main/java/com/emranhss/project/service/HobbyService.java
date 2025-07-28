package com.emranhss.project.service;

import com.emranhss.project.entity.Hobby;
import com.emranhss.project.repository.HobbyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HobbyService {
    @Autowired
    private HobbyRepo hobbyRepo;

    public List<Hobby> getByJobSeeker(long jobSeekerId){
        return hobbyRepo.findByJobSeekerId(jobSeekerId);
    }

    public Hobby save(Hobby hobby){
        return hobbyRepo.save(hobby);
    }
    public void delete(Long id){
        hobbyRepo.deleteById(id);
    }
}
