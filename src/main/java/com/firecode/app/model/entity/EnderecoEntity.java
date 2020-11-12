/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firecode.app.model.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Fernando Matheus
 */
@Entity
@Table(name = "endereco", catalog = "imobiliaria", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_pessoa"}),
    @UniqueConstraint(columnNames = {"id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EnderecoEntity.findAll", query = "SELECT e FROM EnderecoEntity e"),
    @NamedQuery(name = "EnderecoEntity.findById", query = "SELECT e FROM EnderecoEntity e WHERE e.id = :id"),
    @NamedQuery(name = "EnderecoEntity.findByNumero", query = "SELECT e FROM EnderecoEntity e WHERE e.numero = :numero"),
    @NamedQuery(name = "EnderecoEntity.findByComplemento", query = "SELECT e FROM EnderecoEntity e WHERE e.complemento = :complemento")})
public class EnderecoEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "numero", nullable = false, length = 20)
    private String numero;
    @Column(name = "complemento", length = 50)
    private String complemento;
    @JoinColumn(name = "id_logradouro", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private LogradouroEntity idLogradouro;
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id", nullable = false)
    @OneToOne(optional = false)
    private PessoaEntity idPessoa;

    public EnderecoEntity() {
    }

    public EnderecoEntity(Integer id) {
        this.id = id;
    }

    public EnderecoEntity(Integer id, String numero) {
        this.id = id;
        this.numero = numero;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public LogradouroEntity getIdLogradouro() {
        return idLogradouro;
    }

    public void setIdLogradouro(LogradouroEntity idLogradouro) {
        this.idLogradouro = idLogradouro;
    }

    public PessoaEntity getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(PessoaEntity idPessoa) {
        this.idPessoa = idPessoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnderecoEntity)) {
            return false;
        }
        EnderecoEntity other = (EnderecoEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.EnderecoEntity[ id=" + id + " ]";
    }
    
}
