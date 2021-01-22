package com.example.standard.controller;

import com.example.standard.model.Journal;
import com.example.standard.server.JournalServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class JournalController {

    @Autowired
    JournalServer journalServer;

    @ResponseBody
    @RequestMapping("/getallJournal")
    public List<Journal> getAllJournal(){

        System.out.println(journalServer.getAllJournal());
        return journalServer.getAllJournal();
    }

}
