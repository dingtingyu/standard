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

}
