package com.edigest.journalApp.Entity;

import java.time.LocalDateTime;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "config_journal_app")
@Data

// @Getter
// @Setter
public class ConfigJournalAppEntity {

    private String key;
    private String value;

}
