package com.example.standard.mapper;


import com.example.standard.model.IdTable;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface LoginMapper {

    @Select("select * from tb.idtable where name = #{userName}")
    public IdTable selectUserByname(String userName);

    @Select("select * from tb.idtable where id = #{userId}")
    public IdTable selectUserById(Integer userId);

    @Update("update tb.idtable set password = #{pswnew} where id = #{userId}")
    public void updatePassword(String pswnew,int userId);


}
