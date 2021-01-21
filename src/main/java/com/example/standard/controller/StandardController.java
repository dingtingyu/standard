package com.example.standard.controller;

import com.example.standard.model.Standard;
import com.example.standard.server.StandardServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StandardController {

    @Autowired
    StandardServer standardServer;

    @ResponseBody
    @CrossOrigin
    @RequestMapping("/allstandard")
    public List<Standard>getAllStandard(){
        return standardServer.getAllStandard();
    }

    @RequestMapping("/deletestandard")
    public void deleteStandard(String id){
        standardServer.deleteStandard(id);
    }

}
