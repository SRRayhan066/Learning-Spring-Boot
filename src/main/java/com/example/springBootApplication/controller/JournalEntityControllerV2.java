package com.example.springBootApplication.controller;

import com.example.springBootApplication.entity.JournalEntity;
import com.example.springBootApplication.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/journalV2")
public class JournalEntityControllerV2 {

    @Autowired
    private JournalService journalService;
    @PostMapping
    public String createAJournal(@RequestBody JournalEntity journalEntity){
        journalService.save(journalEntity);
        return "Successful";
    }
}
