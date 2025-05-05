package com.ecom.demosecurity.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


// import com.ecom.demosecurity.model.Users;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class HomeController {

     // Assuming this is a placeholder for some string

    // private UserPrincipal user; // Assuming UserPrincipal is a class that holds user details

    @GetMapping("/")
    public String home(HttpServletRequest request) {
        return "Welcome to the home page!" + request.getSession().getId();
    }

    @GetMapping("/admin")
    public String admin() {
        return "Welcome to the admin page!";
    }

    @GetMapping("/user")
    public String user() {
        return "Welcome to the user page!";
    }
}
