package com.example.standard.mapper;

import com.example.standard.model.IdTable;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    @Select("select * from tb.idtable")
    public List<IdTable> getAllLoginUser();

    @Insert("insert into tb.idtable(name,password,grade) values(#{name},#{password},#{grade})")
    public void addLoginUser(IdTable idTable);

    @Delete("delete from tb.IdTable where id=#{id}")
    public void deleteUser(int id);
}
