package com.emranhss.project.restcontroller;

import com.emranhss.project.entity.JobSeeker;
import com.emranhss.project.entity.User;
import com.emranhss.project.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/jobseeker/")
public class JobSeekerRestController {

    @Autowired
    private UserService userService;
    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("")
    public ResponseEntity<Map<String,String>> registerJobSeeker(
            @RequestPart(value = "user") String userJson,
            @RequestPart(value = "jobseeker") String jobSeekerJson,
            @RequestPart(value = "photo")MultipartFile file

    )
        throws JsonProcessingException{
        objectMapper objectMapper = new objectMapper();
        User user=objectMapper.readValue(jobSeekerJson,jobSeeker.class);

        try {
            userService.registerJobSeeker(user, file, jobSeeker);
            Map<String, String> response = new HashMap<>();
            response.put("Message", "User Added Successfully ");

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {

            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("Message", "User Add Faild " + e);
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
