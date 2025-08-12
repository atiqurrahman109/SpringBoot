package com.emranhss.project.restcontroller;


<<<<<<< HEAD
import com.emranhss.project.dto.AuthenticationResponseDTO;
import com.emranhss.project.entity.User;
import com.emranhss.project.repository.ITokenRepo;
import com.emranhss.project.service.AuthService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
=======
import com.emranhss.project.dto.AuthenticationResponse;
import com.emranhss.project.entity.User;

import com.emranhss.project.repository.ITokenRepo;
import com.emranhss.project.service.AuthService;
import com.emranhss.project.service.UserService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


>>>>>>> 0e3f204ff0631cca9428023e610dc5f1a7106550
import jakarta.servlet.http.HttpServletRequest;
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

    @Autowired
    private AuthService authService;

    @Autowired
    ITokenRepo  tokenRepository;
=======

    public class UserRestController {


    @Autowired
    private AuthService AuthService;

    @Autowired
    ITokenRepo tokenRepo;
>>>>>>> 0e3f204ff0631cca9428023e610dc5f1a7106550


    @PostMapping
    public ResponseEntity<Map<String, String>> saveUser(
            @RequestPart(value = "user") String userJson,
            @RequestParam(value = "photo") MultipartFile file
    ) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = objectMapper.readValue(userJson, User.class);

        try {
<<<<<<< HEAD
            authService.saveOrUpdate(user, file);
=======
            AuthService.saveOrUpdate(user, file);
>>>>>>> 0e3f204ff0631cca9428023e610dc5f1a7106550
            Map<String, String> response = new HashMap<>();
            response.put("Message", "User Added Successfully ");

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {

            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("Message", "User Add Faild " + e);
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }


    @GetMapping("all")
    public ResponseEntity<List<User>> getAllUsers() {
<<<<<<< HEAD
        List<User> users = authService.findAll();
=======
        List<User> users = AuthService.findAll();
>>>>>>> 0e3f204ff0631cca9428023e610dc5f1a7106550
        return ResponseEntity.ok(users);

    }


    @PostMapping("login")
<<<<<<< HEAD
    public ResponseEntity<AuthenticationResponseDTO>  login(@RequestBody User request){
        return ResponseEntity.ok(authService.authenticate(request));
=======
    public ResponseEntity<AuthenticationResponse>  login(@RequestBody User request){
        return ResponseEntity.ok(AuthService.authenticate(request));
>>>>>>> 0e3f204ff0631cca9428023e610dc5f1a7106550

    }


    @GetMapping("/active/{id}")
    public ResponseEntity<String> activeUser(@PathVariable("id") int id){

<<<<<<< HEAD
        String response= authService.activeUser(id);
=======
        String response= AuthService.activeUser(id);
>>>>>>> 0e3f204ff0631cca9428023e610dc5f1a7106550
        return  ResponseEntity.ok(response);
    }


    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request) {
        final String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.badRequest().body("Missing or invalid Authorization header.");
        }

        String token = authHeader.substring(7);  // Strip "Bearer "
<<<<<<< HEAD

        tokenRepository.findByToken(token).ifPresent(savedToken -> {
            savedToken.setLogout(true);  // Mark token as logged out
            tokenRepository.save(savedToken);
        });

        return ResponseEntity.ok("Logged out successfully.");
    }


}
=======

        tokenRepo.findByToken(token).ifPresent(savedToken -> {
            savedToken.setLogOut(true);  // Mark token as logged out
            tokenRepo.save(savedToken);
        });

        return ResponseEntity.ok("Logged out successfully.");
    }
}
>>>>>>> 0e3f204ff0631cca9428023e610dc5f1a7106550
