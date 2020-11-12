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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Fernando Matheus
 */
@Entity
@Table(name = "usuario", catalog = "imobiliaria", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"usuario"}),
    @UniqueConstraint(columnNames = {"id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioEntity.findAll", query = "SELECT u FROM UsuarioEntity u"),
    @NamedQuery(name = "UsuarioEntity.findById", query = "SELECT u FROM UsuarioEntity u WHERE u.id = :id"),
    @NamedQuery(name = "UsuarioEntity.findByUsuario", query = "SELECT u FROM UsuarioEntity u WHERE u.usuario = :usuario"),
    @NamedQuery(name = "UsuarioEntity.findBySenha", query = "SELECT u FROM UsuarioEntity u WHERE u.senha = :senha"),
    @NamedQuery(name = "UsuarioEntity.findByAvatar", query = "SELECT u FROM UsuarioEntity u WHERE u.avatar = :avatar")})
public class UsuarioEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "usuario", nullable = false, length = 45)
    private String usuario;
    @Basic(optional = false)
    @Column(name = "senha", nullable = false, length = 100)
    private String senha;
    @Basic(optional = false)
    @Column(name = "avatar", nullable = false, length = 30)
    private String avatar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuarioCadastro")
    private Collection<ClienteEntity> clienteEntityCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuarioAtualizacao")
    private Collection<ClienteEntity> clienteEntityCollection1;
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private PessoaEntity idPessoa;
    @JoinColumn(name = "id_status", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private UsuarioStatusEntity idStatus;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private UsuarioMapPermissaoEntity usuarioMapPermissaoEntity;

    public UsuarioEntity() {
    }

    public UsuarioEntity(Integer id) {
        this.id = id;
    }

    public UsuarioEntity(Integer id, String usuario, String senha, String avatar) {
        this.id = id;
        this.usuario = usuario;
        this.senha = senha;
        this.avatar = avatar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @XmlTransient
    public Collection<ClienteEntity> getClienteEntityCollection() {
        return clienteEntityCollection;
    }

    public void setClienteEntityCollection(Collection<ClienteEntity> clienteEntityCollection) {
        this.clienteEntityCollection = clienteEntityCollection;
    }

    @XmlTransient
    public Collection<ClienteEntity> getClienteEntityCollection1() {
        return clienteEntityCollection1;
    }

    public void setClienteEntityCollection1(Collection<ClienteEntity> clienteEntityCollection1) {
        this.clienteEntityCollection1 = clienteEntityCollection1;
    }

    public PessoaEntity getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(PessoaEntity idPessoa) {
        this.idPessoa = idPessoa;
    }

    public UsuarioStatusEntity getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(UsuarioStatusEntity idStatus) {
        this.idStatus = idStatus;
    }

    public UsuarioMapPermissaoEntity getUsuarioMapPermissaoEntity() {
        return usuarioMapPermissaoEntity;
    }

    public void setUsuarioMapPermissaoEntity(UsuarioMapPermissaoEntity usuarioMapPermissaoEntity) {
        this.usuarioMapPermissaoEntity = usuarioMapPermissaoEntity;
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
        if (!(object instanceof UsuarioEntity)) {
            return false;
        }
        UsuarioEntity other = (UsuarioEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.firecode.app.model.entity.UsuarioEntity[ id=" + id + " ]";
    }
    
}
