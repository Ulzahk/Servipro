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

/**
 *
 * @author practicante
 */
@Entity
@Table(name="usuariosmodulo")
//implements Serializable
public class UsuarioEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;
    @Column(name = "idusuario")
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
   

    public UsuarioEntity() {}

    public UsuarioEntity(Long id, String idusuario,String contrasena,Long idperfil) {
        this.id = id;
        this.idusuario = idusuario;
        this.contrasena = contrasena;
        this.idperfil = idperfil;
    }

    

    @Override
    public String toString() {
        return "User{" + "id=" + getId() + ", idusuario=" + getIdusuario() + ", contrasena=" +getContrasena()+ ", Id Perfil="+ getIdperfil() +'}';
    }

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
}
