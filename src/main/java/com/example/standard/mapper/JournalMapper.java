package com.example.standard.mapper;

import com.example.standard.model.Journal;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface JournalMapper {

    @Insert("insert into tb.journal (username,ipaddress,date,operation) values (#{username},#{ipAddress},#{date},#{operation})")
    public void addJournal(Journal journal);

    @Select("select * from tb.journal")
    public List<Journal> getAllJournal();

}
