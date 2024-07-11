package com.example.springBootApplication.service;

import com.example.springBootApplication.entity.JournalEntity;
import com.example.springBootApplication.repository.JournalServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JournalService {
    @Autowired
    private JournalServiceRepository journalServiceRepository;

    public void save(JournalEntity journalEntity){
        journalServiceRepository.save(journalEntity);
    }

    public List<JournalEntity> getAll(){
        return journalServiceRepository.findAll();
    }

    public Optional<JournalEntity> getAJournal(String id){
        return journalServiceRepository.findById(id);
    }

    public JournalEntity updateOne(String id,JournalEntity journal){
        JournalEntity oldJournal = journalServiceRepository.findById(id).orElse(null);
        if(oldJournal!=null){
            oldJournal.setTitle(journal.getTitle()!=null && !journal.getTitle().equals("") ? journal.getTitle() : oldJournal.getTitle());
            oldJournal.setContent(journal.getContent()!=null && !journal.getContent().equals("") ? journal.getContent() : oldJournal.getContent());
        }
        journalServiceRepository.save(oldJournal);
        return oldJournal;
    }

    public String deleteOne(String id){
        journalServiceRepository.deleteById(id);
        return "Successful";
    }

}
