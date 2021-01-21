package com.example.standard.server;


import com.example.standard.model.IdTable;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface LoginServer {

    public IdTable selectUserById(int userId);

}
