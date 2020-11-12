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
@Table(name = "cidade", catalog = "imobiliaria", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CidadeEntity.findAll", query = "SELECT c FROM CidadeEntity c"),
    @NamedQuery(name = "CidadeEntity.findById", query = "SELECT c FROM CidadeEntity c WHERE c.id = :id"),
    @NamedQuery(name = "CidadeEntity.findByDescricao", query = "SELECT c FROM CidadeEntity c WHERE c.descricao = :descricao"),
    @NamedQuery(name = "CidadeEntity.findByUf", query = "SELECT c FROM CidadeEntity c WHERE c.uf = :uf"),
    @NamedQuery(name = "CidadeEntity.findByCodigoIbge", query = "SELECT c FROM CidadeEntity c WHERE c.codigoIbge = :codigoIbge"),
    @NamedQuery(name = "CidadeEntity.findByDdd", query = "SELECT c FROM CidadeEntity c WHERE c.ddd = :ddd")})
public class CidadeEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "descricao", length = 100)
    private String descricao;
    @Column(name = "uf", length = 2)
    private String uf;
    @Column(name = "codigo_ibge")
    private Integer codigoIbge;
    @Column(name = "ddd", length = 2)
    private String ddd;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCidade")
    private Collection<LogradouroEntity> logradouroEntityCollection;

    public CidadeEntity() {
    }

    public CidadeEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Integer getCodigoIbge() {
        return codigoIbge;
    }

    public void setCodigoIbge(Integer codigoIbge) {
        this.codigoIbge = codigoIbge;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    @XmlTransient
    public Collection<LogradouroEntity> getLogradouroEntityCollection() {
        return logradouroEntityCollection;
    }

    public void setLogradouroEntityCollection(Collection<LogradouroEntity> logradouroEntityCollection) {
        this.logradouroEntityCollection = logradouroEntityCollection;
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
        if (!(object instanceof CidadeEntity)) {
            return false;
        }
        CidadeEntity other = (CidadeEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.CidadeEntity[ id=" + id + " ]";
    }
    
}
