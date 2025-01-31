package com.example.springBootApplication.controller;

import com.example.springBootApplication.entity.JournalEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntityController {
    private Map<String, JournalEntity> journalEntries = new HashMap<>();

    @GetMapping
    public List<JournalEntity> getAllJournal(){
        return new ArrayList<>(journalEntries.values());
    }

    @GetMapping("/id/{id}") //using path variable
    public JournalEntity getAJournal(@PathVariable Integer id){
        return journalEntries.get(id);
    }

    @GetMapping("/id") //using request param
    public JournalEntity getSpecificJournal(@RequestParam("id") Integer id){
        return journalEntries.get(id);
    }

    @PostMapping
    public String addJournal(@RequestBody JournalEntity entry){
        journalEntries.put(entry.getId(),entry);
        return "Successfull";
    }

    @PutMapping("/id")
    public String updateJournal(@RequestParam("id") String id,@RequestBody JournalEntity entry){
        journalEntries.put(id,entry);
        return "Successfully Updated";
    }

    @DeleteMapping("/id")
    public String deleteJournal(@RequestParam("id") Integer id){
        journalEntries.remove(id);
        return "Successfully deleted journal";
    }
}
