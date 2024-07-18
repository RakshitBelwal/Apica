package com.example.apica.service;

import com.example.apica.model.Journal;

import java.util.List;

public interface JournalService {
    Journal saveJournal(Journal journal);
    List<Journal> getAllJournals();
}