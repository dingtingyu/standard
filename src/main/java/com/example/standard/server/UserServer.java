package com.example.standard.server;

import com.example.standard.model.IdTable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface UserServer {

    public List<IdTable>getAllLoginUser();

    public void addLoginUser(IdTable idTable);

    public void deleteUser(int id);

}
