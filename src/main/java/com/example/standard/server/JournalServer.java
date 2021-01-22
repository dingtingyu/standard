package com.example.standard.server;

import com.example.standard.model.Journal;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface JournalServer {

    public void addJournal(Journal journal);

    public List<Journal> getAllJournal();

}
