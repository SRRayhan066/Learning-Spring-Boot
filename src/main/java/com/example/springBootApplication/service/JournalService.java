package com.example.springBootApplication.service;

import com.example.springBootApplication.entity.JournalEntity;
import com.example.springBootApplication.repository.JournalServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JournalService {
    @Autowired
    private JournalServiceRepository journalServiceRepository;

    public void save(JournalEntity journalEntity){
        journalServiceRepository.save(journalEntity);
    }
}
