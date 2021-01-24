package com.example.standard.server;


import com.example.standard.model.IdTable;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface LoginServer {

    public IdTable selectUserByName(String userName);
    public IdTable selectUserById(Integer userId);

    public void updatePassword(String pswnew,int id);

}
