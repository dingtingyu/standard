package com.example.standard.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JumpController {

    @GetMapping("/jumpto")
    public String jumpTo(String name) {
        return name;
    }

    @RequestMapping("/imageget")
    public String imageget(){
        return "imageget";
    }

}
