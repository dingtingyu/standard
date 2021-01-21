package com.example.standard.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.standard.model.IdTable;
import com.example.standard.server.LoginServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class LoginController {

    @Autowired
    LoginServer loginServer;

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @ResponseBody
    @RequestMapping(value = "/loginSubmit",method = RequestMethod.POST)
    public JSONObject loginSubmit(HttpServletRequest request, HttpServletResponse response, String userId, String userPass) throws IOException {
        System.out.println("登录:"+userId+userPass);
        JSONObject map = new JSONObject();
        IdTable user = loginServer.selectUserById(Integer.valueOf(userId));
        if(userPass.equals(user.getPassword())){
            request.getSession().setAttribute("userName",user.getName());
            map.put("name",user.getName());
            map.put("result","success");
            map.put("grade",String.valueOf(user.getGrade()));
            HttpSession session = request.getSession();
            session.setAttribute("userName",user.getName());
            session.setAttribute("grade",user.getGrade());
            session.setMaxInactiveInterval(600);
            System.out.println("登录成功："+user);
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
