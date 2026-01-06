package com.edigest.journalApp.Service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.edigest.journalApp.Entity.User;
import com.edigest.journalApp.repository.UserEntryRepo;

@Component
public class UserService {

    @Autowired
    private UserEntryRepo userEntryRepo;

    public void saveEntry(User user) {userEntryRepo.save(user);}

    public List<User> getAll() {return userEntryRepo.findAll();}

    public Optional<User> findById(ObjectId id) {return userEntryRepo.findById(id);}

    public void deleteById(ObjectId id) {userEntryRepo.deleteById(id);}

    public User findByUserName(String userName) {return userEntryRepo.findByUserName(userName);}
}


// controller ----> service ---> repository