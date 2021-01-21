package com.example.standard.server;

import com.example.standard.model.Standard;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface StandardServer {

    public List<Standard>getAllStandard();

    public void deleteStandard(String id);

}
