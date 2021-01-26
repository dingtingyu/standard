package com.example.standard.mapper;

import com.example.standard.model.Standard;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface StandardMapper {

    @Select("select * from tb.standard")
    public List<Standard>getAllStandard();


    @Delete("delete from tb.standard where gbID =#{id}")
    public void deleteStandard(String id);

    @Update("update tb.standard set gbD=#{gbD},gbC=#{gbC},gbV=#{gbV},gbsymbol=#{gbsymbol},gbinformation=#{gbinformation},gbnum=#{gbnum} where gbID=#{gbID}")
    public void updateStandard(String gbID,Integer gbD,Integer gbC,Integer gbV,String gbsymbol,String gbinformation,String gbnum);

    @Select("select * from tb.standard where gbId=#{gbId}")
    public void getStandardById(String gbId);
}
