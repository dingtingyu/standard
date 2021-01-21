package com.example.standard.controller;

import org.apache.catalina.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class GradeController {

    @ResponseBody
    @RequestMapping("/getgrade")
    public int getGrade(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        int grade = (int) session.getAttribute("grade");
        System.out.println(grade);
        return grade;
    }

}
