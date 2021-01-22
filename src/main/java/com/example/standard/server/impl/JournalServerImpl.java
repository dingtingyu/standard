package com.example.standard.server.impl;

import com.example.standard.mapper.JournalMapper;
import com.example.standard.model.Journal;
import com.example.standard.server.JournalServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JournalServerImpl implements JournalServer {


    @Autowired
    JournalMapper journalMapper;

    @Override
    public void addJournal(Journal journal) {
        journalMapper.addJournal(journal);
    }

    @Override
    public List<Journal> getAllJournal() {
        return journalMapper.getAllJournal();
    }
}
