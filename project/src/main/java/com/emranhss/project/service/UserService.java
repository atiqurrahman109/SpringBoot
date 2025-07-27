package com.emranhss.project.service;

import com.emranhss.project.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private IUserRepo userRepo;
    @Autowired
    private EmailService emailService;

}
