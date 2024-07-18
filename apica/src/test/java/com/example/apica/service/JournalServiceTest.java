package com.example.apica.service;

import com.example.apica.model.Journal;
import com.example.apica.repository.JournalRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JournalServiceTest {

    @Mock
    private JournalRepository journalRepository;

    @InjectMocks
    private JournalServiceImpl journalService;

    @Test
    public void testSaveJournal() {
        Journal journal = new Journal();
        journal.setEvent("User created");
        when(journalRepository.save(any(Journal.class))).thenReturn(journal);
        Journal savedJournal = journalService.saveJournal(journal);
        assertEquals("User created", savedJournal.getEvent());
    }

    @Test
    public void testGetAllJournals() {
        Journal journal = new Journal();
        journal.setEvent("User created");
        when(journalRepository.findAll()).thenReturn(List.of(journal));
        List<Journal> journals = journalService.getAllJournals();
        assertEquals(1, journals.size());
        assertEquals("User created", journals.get(0).getEvent());
    }
}
