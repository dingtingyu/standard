package com.example.standard.server;


import com.example.standard.model.Equipment;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface EquipmentServer {

    public List<Equipment> allEquipment();

    public List<Equipment> getEquipmentByMenuId(String id);

    public List<Equipment> selectEquipmentByid(int id);

    public List<Equipment> selectEquipmentByLeader(String name);


}
