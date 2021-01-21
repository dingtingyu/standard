package com.example.standard.mapper;


import com.example.standard.model.IdTable;
import org.apache.ibatis.annotations.Select;

public interface LoginMapper {

    @Select("select * from tb.idtable where id = #{userId}")
    public IdTable selectUser(int userId);

}
