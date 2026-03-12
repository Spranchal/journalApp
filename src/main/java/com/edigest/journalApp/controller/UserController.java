package com.edigest.journalApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edigest.journalApp.Entity.User;
import com.edigest.journalApp.repository.UserEntryRepo;
import com.edigest.journalApp.Services.UserService;
import com.edigest.journalApp.Services.WeatherService;
import com.edigest.journalApp.api.response.WeatherResponse;


@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    @Autowired
    private UserEntryRepo userEntryRepo;

    @Autowired
    private WeatherService weatherService;

    // UPDATING USER (AUTHENTICATED)
    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User userInDb = userService.findByUserName(userName);
        if(userInDb != null) {
            userInDb.setUserName(user.getUserName());
            userInDb.setPassword(user.getPassword());
            userService.saveNewUser(userInDb);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    // DELETING USER BY ID (AUTHENTICATED)
    @DeleteMapping
    public ResponseEntity<?> deleteByUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userEntryRepo.deleteByUserName(authentication.getName());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @GetMapping
    public ResponseEntity<?> greeting() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        WeatherResponse weatherResponse =  weatherService.getWeather("Mumbai");
        String greeting = "";
        if(weatherResponse != null) {
            greeting = " , Weather fells like: " + weatherResponse.getCurrent().getTempC();
        }
        return new ResponseEntity<>("Hi " + authentication.getName() + greeting, HttpStatus.OK);
    }

}
