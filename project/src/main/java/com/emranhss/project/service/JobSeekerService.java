package com.emranhss.project.service;

import com.emranhss.project.entity.JobSeeker;
import com.emranhss.project.entity.User;
import com.emranhss.project.repository.JobSeekerRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class JobSeekerService {
    @Autowired
    private JobSeekerRepo jobSeekerRepo;

    public List<JobSeeker> getAll() {
        return jobSeekerRepo.findAll();
    }

    public Optional<JobSeeker> getById(Long id) {
        return jobSeekerRepo.findById(id);
    }

    public JobSeeker save(JobSeeker jobSeeker) {
        return jobSeekerRepo.save(jobSeeker);
    }

    public void delete(Long id) {
        jobSeekerRepo.deleteById(id);
    }

    public JobSeeker getProfileByUserId(int userId) {
        return jobSeekerRepo.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Job Seeker not found"));
    }
}
