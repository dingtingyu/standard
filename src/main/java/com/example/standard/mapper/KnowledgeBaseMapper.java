package com.example.standard.mapper;

import com.example.standard.model.KnowledgeBase;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface KnowledgeBaseMapper {
    @Select("select * from tb.knowledge_base")
    public List<KnowledgeBase> getAllKnowledgeBase();
   // devicename:devicename,location:location,device_id:device_id,problem_types:problem_types,problem_description:problem_description,suggestion:suggestion,picture:picture

    @Insert("insert into tb.knowledge_base values(#{devicename},#{location},#{device_id},#{problem_types},#{problem_description},#{suggestion},#{remark},#{kid})")
    public void addKnowledgeBase(KnowledgeBase knowledgeBase);

    @Select("select * from tb.knowledge_base where devicename=#{devicename}")
    public List<KnowledgeBase> getKnowledgeBaseByName(String devicename);

    @Delete("delete from tb.knowledge_base where device_id=#{deviceId}")
    public void deleteKnowledge(String deviceId);

    @Update("update tb.knowledge_base set devicename=#{devicename},location=#{location},device_id=#{device_id},problem_types=#{problem_types},problem_description=#{problem_description},suggestion=#{suggestion},remark=#{remark} where kid=#{kid}")
    public void updateknowledgebase(String devicename,String location,String device_id,String problem_types,String problem_description,String suggestion,String remark,Integer kid);
}
