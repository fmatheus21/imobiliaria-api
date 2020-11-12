package com.firecode.app.model.repository;

import com.firecode.app.model.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {

    PessoaEntity findByCpfCnpj(String value);

}
