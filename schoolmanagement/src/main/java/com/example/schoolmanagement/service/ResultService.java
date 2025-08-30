package com.example.schoolmanagement.service;


import com.example.schoolmanagement.entity.Result;
import com.example.schoolmanagement.entity.Student;
import com.example.schoolmanagement.repository.ExamRepo;
import com.example.schoolmanagement.repository.ResultRepo;
import com.example.schoolmanagement.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultService {

    @Autowired
    private ResultRepo resultRepo;
    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private ExamRepo examRepo;


}
