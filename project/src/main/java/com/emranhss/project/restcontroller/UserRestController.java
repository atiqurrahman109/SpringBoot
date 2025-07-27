package com.emranhss.project.restcontroller;

<<<<<<< HEAD

import com.emranhss.project.entity.User;
=======
import com.emranhss.project.entity.User;
import com.emranhss.project.service.UserService;
>>>>>>> 8d70c07f5a7c06441d18095e23a545ae07b577e2
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user/")
<<<<<<< HEAD

public class UserRestController {
=======
public class UserRestController {

>>>>>>> 8d70c07f5a7c06441d18095e23a545ae07b577e2
    @Autowired
    private UserService userService;

    @PostMapping
<<<<<<< HEAD
    public ResponseEntity<String> saveOrUpdate(@RequestBody User user){
    try {
        userService.saveOrUpdate(user);
        return  ResponseEntity.ok("data saved");

    } catch (EntityNotFoundException e){

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    }





=======
    public ResponseEntity<String> saveOrUpdate(@RequestBody User user) {
        try {
            userService.saveOrUpdate(user);
            return ResponseEntity.ok("Data Saved");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
>>>>>>> 8d70c07f5a7c06441d18095e23a545ae07b577e2
}
