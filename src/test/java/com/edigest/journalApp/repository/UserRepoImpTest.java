package com.edigest.journalApp.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class UserRepoImpTest {

    @Autowired
    private UserRepoImp userRepoImp;

    @Test
    public void testSaveNewUser() {
        Assertions.assertNotNull(userRepoImp.getUserForSA());
    }
}
