package com.example.standard.server;

import com.example.standard.model.KnowledgeBase;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface KnowledegeBaseServer {

    public List<KnowledgeBase>getAllKnowledgeBase();
    public void addKnowledgeBase(KnowledgeBase knowledgeBase);
    public List<KnowledgeBase> getKnowledgeBaseByName(String devicename);
    //public KnowledgeBase addKnowledgeBase(KnowledgeBase knowledgeBase);
    public void deleteKnowledge(String deviceId);
    public void updateknowledgebase(String devicename,String location,String device_id,String problem_types,String problem_description,String suggestion,String remark);
}
