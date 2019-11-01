/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servipro.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.servipro.entity.AuthorityEntity;
import java.util.Set;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author practicante
 */
@Entity
@Table(name="usuariosm")
//implements Serializable
public class UsuarioEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;
    @Column(name = "idusuario",unique = true)
    //@NotBlank(message = "id de usuario es obligatorio")
    private String idusuario;
    @Column(name = "contrasena")
    //@NotBlank(message = "La constraseña es obligatoria")
    private String contrasena;
    @Column(name = "idperfil")
    //@NotBlank(message = "El id del perfil es obligatorio")
    private Long idperfil;
    @Column(name = "estado")    
    private boolean estado;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="authorities_usuario",
    joinColumns=@JoinColumn(name="idusuario"),
    inverseJoinColumns=@JoinColumn(name="authorityid"))
    private Set<AuthorityEntity> authority;
   

    public UsuarioEntity() {}

    public UsuarioEntity(Long id, String idusuario,String contrasena,Long idperfil) {
        this.id = id;
        this.idusuario = idusuario;
        this.contrasena = contrasena;
        this.idperfil = idperfil;
    }

    

    /*@Override
    public String toString() {
        return "User{" + "id=" + getId() + ", idusuario=" + getIdusuario() + ", contrasena=" +getContrasena()+ ", Id Perfil="+ getIdperfil() +'}';
    }*/

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the idusuario
     */
    public String getIdusuario() {
        return idusuario;
    }

    /**
     * @param idusuario the idusuario to set
     */
    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    /**
     * @return the contrasena
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * @param contrasena the contrasena to set
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * @return the idperfil
     */
    public Long getIdperfil() {
        return idperfil;
    }

    /**
     * @param idperfil the idperfil to set
     */
    public void setIdperfil(Long idperfil) {
        this.idperfil = idperfil;
    }

    /**
     * @return the estado
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
    @Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 :id.hashCode());
    return result;
}

@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    UsuarioEntity other = (UsuarioEntity) obj;
    if (id == null) {
        if (other.id != null)
            return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
}

@Override
public String toString() {
    return "UsuarioEntity [id=" + id + ", idusuario=" + idusuario + ", contrasena=" + contrasena + "]";
}

    /**
     * @return the authority
     */
    public Set<AuthorityEntity> getAuthority() {
        return authority;
    }

    /**
     * @param authority the authority to set
     */
    public void setAuthority(Set<AuthorityEntity> authority) {
        this.authority = authority;
    }
    
}
