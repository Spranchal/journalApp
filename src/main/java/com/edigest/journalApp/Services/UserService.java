package com.edigest.journalApp.Services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.edigest.journalApp.Entity.User;
import com.edigest.journalApp.repository.UserEntryRepo;

@Component
public class UserService {

    @Autowired
    private UserEntryRepo userEntryRepo;

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public boolean saveNewUser(User user) {
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(Arrays.asList("USER"));
            userEntryRepo.save(user);
            return true;
        } catch (Exception e) {
            logger.error("Error occured for {} :", user.getUserName());
            // logger.info("HAHAHAHAHA");
            // logger.warn("HAHAHAHAHA");
            // logger.debug("HAHAHAHAHA");
            // logger.trace("HAHAHAHAHA");
            return false;
        }
        
    }

    public void saveAdmin(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER", "ADMIN"));
        userEntryRepo.save(user);
    }

    public void saveUser(User user) {userEntryRepo.save(user);}

    public List<User> getAll() {return userEntryRepo.findAll();}

    public Optional<User> findById(ObjectId id) {return userEntryRepo.findById(id);}

    public void deleteById(ObjectId id) {userEntryRepo.deleteById(id);}

    public User findByUserName(String userName) {return userEntryRepo.findByUserName(userName);}
}


// controller ----> service ---> repository