package com.example.standard.server.impl;

import com.example.standard.mapper.StandardMapper;
import com.example.standard.model.Standard;
import com.example.standard.server.StandardServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StandardServerImpl implements StandardServer {

    @Autowired
    StandardMapper standardMapper;

    @Override
    public List<Standard> getAllStandard() {
        return standardMapper.getAllStandard();
    }


    @Override
    public void deleteStandard(String id) {
        standardMapper.deleteStandard(id);
    }

    @Override
    public void updateStandard(String gbID,Integer gbD,Integer gbC,Integer gbV,String gbsymbol,String gbinformation,String gbnum) {
        standardMapper.updateStandard(gbID,gbD,gbC,gbV,gbsymbol,gbinformation,gbnum);
    }

    @Override
    public void getStandardByid(String gbId) {
        standardMapper.getStandardById(gbId);
    }

}
