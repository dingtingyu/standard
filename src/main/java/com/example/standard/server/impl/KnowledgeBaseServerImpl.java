package com.example.standard.server.impl;

import com.example.standard.mapper.KnowledgeBaseMapper;
import com.example.standard.model.KnowledgeBase;
import com.example.standard.server.KnowledegeBaseServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KnowledgeBaseServerImpl implements KnowledegeBaseServer {

    @Autowired
    KnowledgeBaseMapper knowledgeBaseMapper;

    @Override
    public List<KnowledgeBase> getAllKnowledgeBase() {
        return knowledgeBaseMapper.getAllKnowledgeBase();
    }

    @Override
    public void addKnowledgeBase(KnowledgeBase knowledgeBase){ knowledgeBaseMapper.addKnowledgeBase(knowledgeBase); }

    @Override
    public List<KnowledgeBase> getKnowledgeBaseByName(String devicename){return knowledgeBaseMapper.getKnowledgeBaseByName(devicename);}

    @Override
    public void deleteKnowledge(String deviceId) {
        knowledgeBaseMapper.deleteKnowledge(deviceId);
    }

    @Override
    public void updateknowledgebase(String devicename,String location,String device_id,String problem_types,String problem_description,String suggestion,String remark,Integer kid){
        knowledgeBaseMapper.updateknowledgebase(devicename,location,device_id,problem_types,problem_description,suggestion,remark,kid);
    }
}
