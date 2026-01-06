package com.edigest.journalApp.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.edigest.journalApp.Entity.User;


public interface UserEntryRepo extends MongoRepository<User, ObjectId>{
    
    User findByUserName(String userName);
}
