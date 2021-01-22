package com.example.standard.mapper;


import com.example.standard.model.IdTable;
import org.apache.ibatis.annotations.Select;

public interface LoginMapper {

    @Select("select * from tb.idtable where name = #{userName}")
    public IdTable selectUser(String userName);

}
