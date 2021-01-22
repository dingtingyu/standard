package com.example.standard.mapper;

import com.example.standard.model.KnowledgeBase;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface KnowledgeBaseMapper {
    @Select("select * from device.knowledge_base")
    public List<KnowledgeBase> getAllKnowledgeBase();
   // devicename:devicename,location:location,device_id:device_id,problem_types:problem_types,problem_description:problem_description,suggestion:suggestion,picture:picture
    @Insert("insert into device.knowledge_base values(#{devicename},#{location},#{device_id},#{problem_types},#{problem_description},#{suggestion}")
    public void addKnowledgeBase(KnowledgeBase knowledgeBase);

    @Select("select * from device.knowledge_base where devicename=#{devicename}")
    public List<KnowledgeBase> getKnowledgeBaseByName(String devicename);
//    @Update("insert from tb.standard where gbID =#{id}")
//    public void deleteStandard(String id);
}
