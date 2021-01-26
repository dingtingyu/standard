package com.example.standard.server;

import com.example.standard.model.Standard;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface StandardServer {

    public List<Standard>getAllStandard();

    public void deleteStandard(String id);

    public void updateStandard(String gbID,Integer gbD,Integer gbC,Integer gbV,String gbsymbol,String gbinformation,String gbnum);

    public void getStandardByid(String gbId);
}
