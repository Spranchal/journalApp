package com.edigest.journalApp.Services;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.edigest.journalApp.repository.UserEntryRepo;
import com.edigest.journalApp.Entity.User;
import com.mongodb.assertions.Assertions;

@SpringBootTest
public class UserDetailsServiceImplTest {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @MockitoBean
    private UserEntryRepo userRepo;

    @Test
    void loadUserByUsernameTest() {
        when(userRepo.findByUserName(ArgumentMatchers.anyString())).thenReturn(User.builder().userName("Ram").password("sidfv").roles(new ArrayList<>()).build());
        UserDetails user = userDetailsService.loadUserByUsername("Ram");
        Assertions.assertNotNull(user);
    }
}
