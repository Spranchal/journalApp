package com.edigest.journalApp.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.edigest.journalApp.Entity.ConfigJournalAppEntity;
import com.edigest.journalApp.repository.ConfigJournalAppRepo;

import jakarta.annotation.PostConstruct;

@Component
public class AppCache {

    public enum keys {
        weather_api;
    }

    @Autowired
    private ConfigJournalAppRepo configJournalAppRepo;

    public Map<String, String> appCache = new HashMap<>();

    @PostConstruct
    public void init() {
        List<ConfigJournalAppEntity> all = configJournalAppRepo.findAll();
        for(ConfigJournalAppEntity configJournalAppEntity : all) {
            appCache.put(configJournalAppEntity.getKey(), configJournalAppEntity.getValue());
        }
    }
}
