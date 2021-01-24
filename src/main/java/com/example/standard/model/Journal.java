package com.example.standard.model;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
@AllArgsConstructor
@Data
public class Journal {

    int id;
    String username;
    String ipAddress;
    Date date;
    String operation;


}
