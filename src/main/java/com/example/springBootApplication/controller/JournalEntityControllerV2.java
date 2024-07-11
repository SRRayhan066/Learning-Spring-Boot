package com.example.springBootApplication.controller;

import com.example.springBootApplication.entity.JournalEntity;
import com.example.springBootApplication.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public List<JournalEntity> getAllJournal(){
        return journalService.getAll();
    }

    @GetMapping("/id")
    public JournalEntity getAJournal(@RequestParam("id") String id){
        return journalService.getAJournal(id).orElse(null);
    }

    @PutMapping("/update")
    public JournalEntity updateAJournal(@RequestParam("id") String id,@RequestBody JournalEntity journal){
        return journalService.updateOne(id,journal);
    }

    @DeleteMapping("/delete")
    public String deleteOne(@RequestParam("id") String id){
        return journalService.deleteOne(id);
    }
}
