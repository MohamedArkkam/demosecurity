package com.ecom.demosecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.demosecurity.model.Users;
import com.ecom.demosecurity.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Users register(Users user) {
        // Logic to save the user to the database
        // For example, using a UserService to handle the registration logic
        return userRepository.save(user);
    }

}
