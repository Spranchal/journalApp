package com.edigest.journalApp.scheduler;

import static org.junit.jupiter.api.DynamicTest.stream;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.edigest.journalApp.Entity.JournalEntry;
import com.edigest.journalApp.Entity.User;
import com.edigest.journalApp.Services.EmailService;
import com.edigest.journalApp.Services.SentimentAnalysisService;
import com.edigest.journalApp.repository.UserRepoImp;


@Component
public class UserScheduler {

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserRepoImp userRepoImp;

    @Autowired
    private SentimentAnalysisService sentimentAnalysisService;

    // @Scheduled(cron = "0 0 9 * * SUN")
    @Scheduled(cron = "0 * * ? * *")
    public void fetUsersAndSendSaMail() {
        List<User> users = userRepoImp.getUserForSA();
        for(User user : users) {
            List<JournalEntry> journalEntries = user.getJournalEntries();
            List<String> filteredEntries = journalEntries.stream().filter(x -> x.getDate().isAfter(LocalDateTime.now().minus(7, ChronoUnit.DAYS))).map(x -> x.getContent()).collect(Collectors.toList()); 
            String entry = String.join(" ", filteredEntries);
            String sentiment = sentimentAnalysisService.getSentiment(entry);
            // emailService.sendEmail(user.getEmail(), "Sentiment for last 7 days", sentiment);
        }

    }
}
