package com.example.standard.controller;


import com.example.standard.model.Equipment;
import com.example.standard.server.EquipmentServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.regex.Pattern;

@Controller
public class EquipmentController {

    @Autowired
    EquipmentServer equipmentServer;

    @RequestMapping("/equipmentindex")
    @ResponseBody
    public List<Equipment> getAllEquipment() {
        return equipmentServer.allEquipment();
    }

    @RequestMapping("/getEquipmentByMenuId")
    @ResponseBody
    public List<Equipment> getEquipmentByMenuId(String id) {

        String equipmentId = "";

        switch (id) {
            //防爆电机
            case "dianji":
                equipmentId = "防爆电机";
                break;
            //防爆照明灯具：
            case "dengju":
                equipmentId = "防爆照明灯具";
                break;
            //防爆控制箱
            case "kongzhi":
                equipmentId = "防爆控制箱";
                break;
            //防爆接线箱
            case "jiexian":
                equipmentId = "防爆接线箱";
                break;
            //防爆仪表
            case "yibiao":
                equipmentId = "防爆仪表";
                break;
            default:
                break;
        }

        return equipmentServer.getEquipmentByMenuId(equipmentId);
    }

    @GetMapping("/searchEquipmentByName")
    @ResponseBody
    public List<Equipment>searchEquipmentByName(String name){
        if(isInteger(name)){
            int id = Integer.valueOf(name);
            return equipmentServer.selectEquipmentByid(id);
        }else{
            return equipmentServer.selectEquipmentByLeader(name);
        }
    }

    @GetMapping("/testString")
    @ResponseBody
    public boolean testString(String name){
        return isInteger(name);
    }

    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

}
