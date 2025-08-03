package com.emranhss.project.restcontroller;

<<<<<<< HEAD
import com.emranhss.project.entity.User;

import com.emranhss.project.service.UserService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
=======

import com.emranhss.project.entity.User;
import com.emranhss.project.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
>>>>>>> 7547c969975225260de50a971e7521854135bf4b
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user/")
<<<<<<< HEAD




    public class UserRestController {


=======
@CrossOrigin("*")

public class UserRestController {

>>>>>>> 7547c969975225260de50a971e7521854135bf4b
    @Autowired
    private UserService userService;


    @PostMapping
    public ResponseEntity<Map<String, String>> saveUser(
            @RequestPart(value = "user") String userJson,
<<<<<<< HEAD
            @RequestParam(value = "photo") MultipartFile file
    ) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = objectMapper.readValue(userJson, User.class);

        try {
            userService.saveOrUpdate(user, file);
            Map<String, String> response = new HashMap<>();
            response.put("Message", "User Added Successfully ");

=======
            @RequestParam(value = "photo")MultipartFile file
            )
            throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = objectMapper.readValue(userJson, User.class);


        try {
            userService.saveOrUpdate(user, file);
            Map<String, String> response = new HashMap<>();
            response.put("message", "User has been saved successfully");
>>>>>>> 7547c969975225260de50a971e7521854135bf4b
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {

            Map<String, String> errorResponse = new HashMap<>();
<<<<<<< HEAD
            errorResponse.put("Message", "User Add Faild " + e);
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
=======
            errorResponse.put("message", e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);

>>>>>>> 7547c969975225260de50a971e7521854135bf4b
        }


    }

<<<<<<< HEAD

    @GetMapping("")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.findAll();
        return ResponseEntity.ok(users);

    }


    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse>  login(@RequestBody User request){
        return ResponseEntity.ok(userService.authencate(request));

    }


    @GetMapping("/active/{id}")
    public ResponseEntity<String> activeUser(@PathVariable("id") int id){

        String response= userService.activeUser(id);
        return  ResponseEntity.ok(response);
    }

}
=======
        @GetMapping("")
        public ResponseEntity<List<User>> getAllUser () {
            List<User> users = userService.findAll();
            return ResponseEntity.ok(users);

        }

    }

>>>>>>> 7547c969975225260de50a971e7521854135bf4b
