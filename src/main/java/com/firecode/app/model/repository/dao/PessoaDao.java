package com.firecode.app.model.repository.dao;

import com.firecode.app.model.entity.PessoaEntity;
import com.firecode.app.model.repository.PessoaRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class PessoaDao implements GenericDao<PessoaEntity> {

    @Autowired
    private PessoaRepository repository;

    @Override
    public PessoaEntity findById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<PessoaEntity> findAll(String orderBy) {
        return repository.findAll(Sort.by(Sort.Order.asc(orderBy)));
    }

    @Override
    public PessoaEntity create(PessoaEntity t) {
        return repository.save(t);
    }

    @Override
    public PessoaEntity update(PessoaEntity t) {
        return repository.save(t);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public PessoaEntity findByCpfCnpj(String value) {
        return repository.findByCpfCnpj(value);
    }

}
