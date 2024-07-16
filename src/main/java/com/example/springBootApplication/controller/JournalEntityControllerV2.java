package com.example.springBootApplication.controller;

import com.example.springBootApplication.entity.JournalEntity;
import com.example.springBootApplication.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/journalV2")
public class JournalEntityControllerV2 {

    @Autowired
    private JournalService journalService;
    @PostMapping
    public ResponseEntity<JournalEntity> createAJournal(@RequestBody JournalEntity journalEntity){
        try{
            journalService.save(journalEntity);
            return new ResponseEntity<>(journalEntity, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<JournalEntity>> getAllJournal(){
        List<JournalEntity> entities =  journalService.getAll();
        if(!entities.isEmpty()){
            return new ResponseEntity<List<JournalEntity>>(entities,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/id")
    public ResponseEntity<JournalEntity> getAJournal(@RequestParam("id") String id){
        Optional<JournalEntity> journalEntity = journalService.getAJournal(id);
        if(journalEntity.isPresent()){
            return new ResponseEntity<JournalEntity>(journalEntity.get(),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<JournalEntity> updateAJournal(@RequestParam("id") String id,@RequestBody JournalEntity journal){
        try{
            JournalEntity entity = journalService.updateOne(id,journal);
            return new ResponseEntity<>(entity,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteOne(@RequestParam("id") String id){
        try{
            journalService.deleteOne(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
