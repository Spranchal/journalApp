package com.edigest.journalApp.Services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.edigest.journalApp.repository.UserEntryRepo;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserEntryRepo userEntryRepo;


    @ParameterizedTest
    @CsvSource({ //CsvSource ka matlab ni banta
        "Ram",
        "Shyam",
        "Pranchal",
        "rdvhi",
        "eifhvb"
    })
    public void testFindByUserName(String name) {
        assertNotNull(userEntryRepo.findByUserName(name));
        
    }

    @Disabled
    @ParameterizedTest
    @CsvSource({
        "1, 1, 2",
        "2, 10, 12",
        "1, 3, 5"
    })
    public void test(int a, int b, int expected) {
        assertEquals(expected, a + b);
    }
}
