package com.example.apica.service;

import com.example.apica.model.Journal;
import com.example.apica.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JournalServiceImpl implements JournalService {

    @Autowired
    private JournalRepository journalRepository;

    @Override
    public Journal saveJournal(Journal journal) {
        return journalRepository.save(journal);
    }

    @Override
    public List<Journal> getAllJournals() {
        return journalRepository.findAll();
    }

    @KafkaListener(topics = "user-events", groupId = "group_id")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
        Journal journal = new Journal();
        journal.setEvent(message);
        saveJournal(journal);
    }
}