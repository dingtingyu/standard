package com.example.standard.controller;

import com.example.standard.model.Standard;
import com.example.standard.server.StandardServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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

    @ResponseBody
    @GetMapping("/deleteStandard")
    public String  deleteStandard(String id){
        standardServer.deleteStandard(id);
        return "redirect:index";
    }

    @PostMapping("/updateStandard")
    public String  updateStandard(HttpServletRequest request ,String gbID, Integer gbD, Integer gbC, Integer gbV, String gbsymbol, String gbinformation, String gbnum){
        System.out.println("gbID"+gbID);
        this.standardServer.updateStandard(gbID,gbD,gbC,gbV,gbsymbol,gbinformation,gbnum);
        return "redirect:index";
    }

}
