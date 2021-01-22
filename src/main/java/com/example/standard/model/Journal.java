package com.example.standard.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data

public class Journal {

    int id;
    String username;
    String ipAddress;
    Date date;
    String operation;

    public Journal(int id, String username, String ipAddress, Date date, String operation) {
        this.id = id;
        this.username = username;
        this.ipAddress = ipAddress;
        this.date = date;
        this.operation = operation;
    }
}
