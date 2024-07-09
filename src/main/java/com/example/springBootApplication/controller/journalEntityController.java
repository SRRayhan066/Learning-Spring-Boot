package com.example.springBootApplication.controller;

import com.example.springBootApplication.entity.JournalEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class journalEntityController {
    private Map<Integer, JournalEntity> journalEntries = new HashMap<>();

    @GetMapping
    public List<JournalEntity> getAllJournal(){
        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping
    public String addEntry(@RequestBody JournalEntity entry){
        journalEntries.put(entry.getId(),entry);
        return "Successfull";
    }
}
