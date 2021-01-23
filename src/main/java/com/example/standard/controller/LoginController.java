package com.example.standard.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.standard.model.IdTable;
import com.example.standard.model.Journal;
import com.example.standard.server.JournalServer;
import com.example.standard.server.LoginServer;
import com.example.standard.util.IpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class LoginController {

    @Autowired
    LoginServer loginServer;

    @Autowired
    JournalServer journalServer;

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @ResponseBody
    @RequestMapping(value = "/loginSubmit",method = RequestMethod.POST)
    public JSONObject loginSubmit(HttpServletRequest request, HttpServletResponse response, String userName, String userPass) throws IOException {
        //登录
        System.out.println("登录:"+userName+userPass);
        JSONObject map = new JSONObject();
        IdTable user = loginServer.selectUserByName(userName);
        if(userPass.equals(user.getPassword())){
            request.getSession().setAttribute("userName",user.getName());
            map.put("name",user.getName());
            map.put("result","success");
            map.put("grade",String.valueOf(user.getGrade()));
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            session.setAttribute("userName",user.getName());
            session.setAttribute("grade",user.getGrade());

            session.setMaxInactiveInterval(600);
            System.out.println("登录成功："+user);

            //添加日志内容（登录）
            Date day=new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(df.format(day));
            String ipAddress = IpUtil.getIpAddr(request);
            Journal journal;
            journal  = new Journal(0,user.getName(),ipAddress, day,"登录");
            journalServer.addJournal(journal);
            return map;
        }else{
            map.put("result","wrong");
            return map;
        }
    }

    @ResponseBody
    @RequestMapping("/exit")
    public void exitCount(HttpServletResponse response,HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("userName");
        session.removeAttribute("grade");
    }

}
