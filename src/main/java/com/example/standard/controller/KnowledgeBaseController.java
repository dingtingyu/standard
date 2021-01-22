package com.example.standard.controller;

import com.example.standard.model.KnowledgeBase;

import com.example.standard.server.KnowledegeBaseServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.util.List;

@Controller
public class KnowledgeBaseController {
    @Autowired
    KnowledegeBaseServer knowledegeBaseServer;

    @ResponseBody
    @CrossOrigin
    @RequestMapping("/allknowledegeBase")
    public List<KnowledgeBase> getAllKnowledegeBase(){

        return knowledegeBaseServer.getAllKnowledgeBase();
    }

    /**
     * 添加评价知识库
     * @throws ParseException
     */
    @ResponseBody
    @PostMapping("/addknowledegeBase")
    public void knowledegeBase(String devicename,
            String location,
            String device_id,
            String problem_types,
            String problem_description,
            String suggestion,
            String remark) throws ParseException {
        System.out.println(devicename+location+device_id+problem_types+problem_description+suggestion+remark);
        KnowledgeBase knowledgeBase;
        knowledgeBase = new KnowledgeBase(devicename, location, device_id, problem_types, problem_description, suggestion, remark);

        knowledegeBaseServer.addKnowledgeBase(knowledgeBase);
    }

/*查询*/
    @ResponseBody
    @CrossOrigin
    @RequestMapping("/knowledegeBasebyname")
    public List<KnowledgeBase> getKnowledgeBaseByName(String devicename){
        System.out.println(devicename);
        //return knowledegeBaseServer.getKnowledgeBaseByName("防爆接线箱");
        return knowledegeBaseServer.getKnowledgeBaseByName(devicename);
    }
}
