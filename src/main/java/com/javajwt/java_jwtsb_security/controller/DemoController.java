package com.javajwt.java_jwtsb_security.controller;

import com.javajwt.java_jwtsb_security.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/welcome")
    public String hello() {
        return "Welcome to home";

    }

    @RequestMapping("/getUser")
    public ResponseEntity getUser() {

        List user = this.userRepository.findAll();
        return new ResponseEntity<>(user, HttpStatus.OK);

    }

}
