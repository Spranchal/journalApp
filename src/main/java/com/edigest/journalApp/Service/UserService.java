package com.edigest.journalApp.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
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

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void saveNewUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER"));
        userEntryRepo.save(user);
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