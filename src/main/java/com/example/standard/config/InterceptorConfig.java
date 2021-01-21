package com.example.standard.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class InterceptorConfig implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

//        System.out.println("进入拦截");
        HttpSession session = request.getSession();
        if(session.getAttribute("userName")!=null){
//            System.out.println("session"+session.getAttribute("userName"));
            return true;
        }else{
            System.out.println("没登陆，进入登录界面！");
            response.sendRedirect("/login");
        }
        return false;
    }
}
