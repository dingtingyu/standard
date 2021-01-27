package com.example.standard.controller;

import com.example.standard.model.IdTable;
import com.example.standard.server.LoginServer;
import com.example.standard.server.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserServer userServer;

    @Autowired
    LoginServer loginServer;

    @ResponseBody
    @RequestMapping("/getAllLoginUser")
    public List<IdTable> getAllLoginUser(){
        return userServer.getAllLoginUser();
    }

    @ResponseBody
    @GetMapping("/isExitUser")
    public boolean isExitUser(String name){
        System.out.println(name);
        IdTable idTable = loginServer.selectUserByName(name);
        System.out.println(idTable);
        return idTable != null;
    }

    @ResponseBody
    @GetMapping("/addLoginUser")
    public void addLoginUser(String name,String password,int grade,String realname,int age,String phone){
        System.out.println("addUser"+name+password+grade);
        IdTable idTable = new IdTable(0,password,grade,name,realname,age,phone);
        userServer.addLoginUser(idTable);
    }

    @ResponseBody
    @GetMapping("/deleteUser")
    public String  deleteUser(int id){
        userServer.deleteUser(id);
        return "redirect:index";
    }

}
