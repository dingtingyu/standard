package com.example.standard.server.impl;


import com.example.standard.mapper.EquipmentMapper;
import com.example.standard.model.Equipment;
import com.example.standard.server.EquipmentServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentServerImpl implements EquipmentServer {

    @Autowired
    EquipmentMapper equipmentMapper;

    @Override
    public List<Equipment> allEquipment() {
        return equipmentMapper.allEquipment();
    }

    @Override
    public List<Equipment> getEquipmentByMenuId(String id) {
        return equipmentMapper.getEquipmentByMenuId(id);
    }

    @Override
    public List<Equipment> selectEquipmentByid(int id) {
        return equipmentMapper.selectEquipmentByid(id);
    }

    @Override
    public List<Equipment> selectEquipmentByLeader(String name) {
        return equipmentMapper.selectEquipmentByLeader(name);
    }
}
