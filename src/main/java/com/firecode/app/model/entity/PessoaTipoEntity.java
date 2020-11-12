/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firecode.app.model.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Fernando Matheus
 */
@Entity
@Table(name = "pessoa_tipo", catalog = "imobiliaria", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id"}),
    @UniqueConstraint(columnNames = {"nome"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PessoaTipoEntity.findAll", query = "SELECT p FROM PessoaTipoEntity p"),
    @NamedQuery(name = "PessoaTipoEntity.findById", query = "SELECT p FROM PessoaTipoEntity p WHERE p.id = :id"),
    @NamedQuery(name = "PessoaTipoEntity.findByNome", query = "SELECT p FROM PessoaTipoEntity p WHERE p.nome = :nome")})
public class PessoaTipoEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nome", nullable = false, length = 15)
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipo")
    private Collection<PessoaEntity> pessoaEntityCollection;

    public PessoaTipoEntity() {
    }

    public PessoaTipoEntity(Integer id) {
        this.id = id;
    }

    public PessoaTipoEntity(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public Collection<PessoaEntity> getPessoaEntityCollection() {
        return pessoaEntityCollection;
    }

    public void setPessoaEntityCollection(Collection<PessoaEntity> pessoaEntityCollection) {
        this.pessoaEntityCollection = pessoaEntityCollection;
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
        if (!(object instanceof PessoaTipoEntity)) {
            return false;
        }
        PessoaTipoEntity other = (PessoaTipoEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.PessoaTipoEntity[ id=" + id + " ]";
    }
    
}
