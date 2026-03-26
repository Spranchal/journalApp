package com.edigest.journalApp.Services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServiceTest {

    @Autowired
    private EmailService emailService;

    @Test
    void testSendMail() {
        emailService.sendEmail("xifosi2394@smkanba.com", 
        "testing Java mail sender", 
        "Hi, app kaise hain?");
    } 
}
