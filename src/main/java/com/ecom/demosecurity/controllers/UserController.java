package com.ecom.demosecurity.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.demosecurity.model.Users;
import com.ecom.demosecurity.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
public class UserController {

    @Autowired
    public UserService service;
    
    @PostMapping("/register")
    public Users register(@RequestBody Users user) {
        // Logic to save the user to the database
        // For example, using a UserService to handle the registration logic
        return service.register(user);
    }

}
