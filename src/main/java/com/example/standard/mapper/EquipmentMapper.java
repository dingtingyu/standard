package com.example.standard.mapper;


import com.example.standard.model.Equipment;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface EquipmentMapper {

    @Select("select * from tb.jbc")
    public List<Equipment> allEquipment();

    @Select("select * from tb.jbc where testcol = #{id}")
    public List<Equipment> getEquipmentByMenuId(String id);


    @Select("select * from tb.jbc where testcol1 = #{id}")
    public List<Equipment> selectEquipmentByid(int id);

    @Select("select * from tb.jbc where testcol4 = #{name}")
    public List<Equipment> selectEquipmentByLeader(String name);

}
