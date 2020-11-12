package com.firecode.app.model.service;

import com.firecode.app.model.entity.PessoaEntity;
import com.firecode.app.model.repository.dao.PessoaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaDao dao;

    public PessoaEntity create(PessoaEntity entity) {
        return dao.create(entity);
    }

    public PessoaEntity findBycpfCnpj(String value) {
        return dao.findByCpfCnpj(value);
    }

}
