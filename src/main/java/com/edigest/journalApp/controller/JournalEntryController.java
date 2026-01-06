// package com.edigest.journalApp.controller;

// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;

// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.edigest.journalApp.Entity.JournalEntry;

// @RestController
// @RequestMapping("/journal")
// public class JournalEntryController {
//     private Map<Long, JournalEntry> journalEntries = new HashMap<>();
    
//     @GetMapping
//     public List<JournalEntry> getAll() { // get all data
//         return new ArrayList<>(journalEntries.values()); // Postman GET
//     }

//     //adding data
//     @PostMapping // Agar (isme kuch likha) to path wo hoga like: journal/abc 
//     public boolean createEntry(@RequestBody JournalEntry myEntry) { // Postman POST
//         journalEntries.put(myEntry.getId(), myEntry);
//         return true;
//     }
    
//     @GetMapping("id/{myId}")
//     public JournalEntry getJournalEntryById(@PathVariable Long myId) { //get single data
//         return journalEntries.get(myId);
//     }

//     @DeleteMapping("id/{myId}")
//     public JournalEntry deleteJournalEntryById(@PathVariable Long myId) { //delete a data
//         return journalEntries.remove(myId);
//     }

//     @PutMapping("id/{id} ")
//     public JournalEntry updateJournalEntryById(@PathVariable Long id, @RequestBody JournalEntry myEntry) {
//         return journalEntries.put(id, myEntry);
//     }
// }
