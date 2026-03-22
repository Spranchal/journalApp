package com.edigest.journalApp.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.edigest.journalApp.Entity.ConfigJournalAppEntity;
import com.edigest.journalApp.Entity.User;


public interface ConfigJournalAppRepo extends MongoRepository<ConfigJournalAppEntity, ObjectId>{
    
}
