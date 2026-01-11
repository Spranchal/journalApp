package com.edigest.journalApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edigest.journalApp.Entity.User;
import com.edigest.journalApp.Service.UserService;

@RestController
@RequestMapping("/public")
public class PublicController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/health-check")
    public String healthCheck() {
        return "OK";
    }

    @PostMapping
    public void createUser(@RequestBody User user) {
        userService.saveEntry(user);
    }
}
