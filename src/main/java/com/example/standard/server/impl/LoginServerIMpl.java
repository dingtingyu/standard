package com.example.standard.server.impl;


import com.example.standard.mapper.LoginMapper;
import com.example.standard.model.IdTable;
import com.example.standard.server.LoginServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginServerIMpl implements LoginServer {

    @Autowired
    LoginMapper loginMapper;

    @Override
    public IdTable selectUserByName(String userName) {
        return loginMapper.selectUserByname(userName);
    }

    @Override
    public IdTable selectUserById(Integer userId) {
        return loginMapper.selectUserById(userId);
    }

    @Transactional
    @Override
    public void updatePassword(String pswnew,int id) {
       this.loginMapper.updatePassword(pswnew,id);
    }
}
