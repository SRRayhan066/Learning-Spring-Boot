package com.example.springBootApplication.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;

@Data
@Document(collection = "journal_entries")
public class JournalEntity {
    @Id
    String id;
    String title;
    String content;
}
