package com.edigest.journalApp.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.edigest.journalApp.Entity.User;
import com.edigest.journalApp.repository.UserEntryRepo;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserEntryRepo userEntryRepo;

    @Test
    public void testFindByUserName() {
        User user = userEntryRepo.findByUserName("Ram");
        assertTrue(!user.getJournalEntries().isEmpty());
        assertTrue(5 > 3);
    }
}
