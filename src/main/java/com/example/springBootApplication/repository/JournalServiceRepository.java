package com.example.springBootApplication.repository;

import com.example.springBootApplication.entity.JournalEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

public interface JournalServiceRepository extends MongoRepository<JournalEntity,String> {

}
