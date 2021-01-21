package com.example.standard.server.impl;


import com.example.standard.mapper.LoginMapper;
import com.example.standard.model.IdTable;
import com.example.standard.server.LoginServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServerIMpl implements LoginServer {

    @Autowired
    LoginMapper loginMapper;

    @Override
    public IdTable selectUserById(int userId) {
        return loginMapper.selectUser(userId);
    }
}
