package com.firecode.app.model.service;

import com.firecode.app.model.entity.ClienteEntity;
import com.firecode.app.model.repository.dao.ClienteDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteDao dao;

    public List<ClienteEntity> findAll(String orderBy) {
        return dao.findAll(orderBy);
    }

    public ClienteEntity findById(int id) {
        return dao.findById(id);
    }

}
