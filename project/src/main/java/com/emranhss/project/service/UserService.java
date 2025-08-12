package com.emranhss.project.service;

<<<<<<< HEAD



import com.emranhss.project.dto.AuthenticationResponseDTO;
import com.emranhss.project.entity.JobSeeker;
import com.emranhss.project.entity.Role;
import com.emranhss.project.entity.Token;
=======
>>>>>>> 0e3f204ff0631cca9428023e610dc5f1a7106550
import com.emranhss.project.entity.User;

import com.emranhss.project.repository.IUserRepo;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
=======

>>>>>>> 0e3f204ff0631cca9428023e610dc5f1a7106550
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

<<<<<<< HEAD
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
=======
import org.springframework.stereotype.Service;



>>>>>>> 0e3f204ff0631cca9428023e610dc5f1a7106550
import java.util.Collections;
import java.util.List;



@Service
public class UserService implements UserDetailsService {



    @Autowired
    private IUserRepo userRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        User user = userRepo.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found"));

        List<GrantedAuthority> authorities = Collections.singletonList(
                new SimpleGrantedAuthority("ROLE_" + user.getRole().name())
        );

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                authorities
        );


    }


<<<<<<< HEAD
=======


>>>>>>> 0e3f204ff0631cca9428023e610dc5f1a7106550





}
