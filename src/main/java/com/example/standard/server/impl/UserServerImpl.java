package com.example.standard.server.impl;

import com.example.standard.mapper.UserMapper;
import com.example.standard.model.IdTable;
import com.example.standard.server.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServerImpl implements UserServer {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<IdTable> getAllLoginUser() {
        return userMapper.getAllLoginUser();
    }

    @Override
    public void addLoginUser(IdTable idTable) {
        userMapper.addLoginUser(idTable);
    }
}
