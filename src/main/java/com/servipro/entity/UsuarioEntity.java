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
@Table(name="usuarios")
//implements Serializable
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDEmpleado",nullable = false)
    private Long id;
    @Column(name = "IDUsuario",nullable = false)
    @NotBlank(message = "id de usuario es obligatorio")
    private String idusuario;
    @Column(name = "Contrasena",nullable = false)
    @NotBlank(message = "La constraseña es obligatoria")
    private String contrasena;
    @Column(name = "IDPerfil")
    @NotBlank(message = "El id del perfil es obligatorio")
    private Long idperfil;
   

    public UsuarioEntity() {}

    public UsuarioEntity(Long idempleado, String idusuario,String contrasena,Long idperfil) {
        this.id = idempleado;
        this.idusuario = idusuario;
        this.contrasena = contrasena;
        this.idperfil = idperfil;
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
    public long getIdperfil() {
        return idperfil;
    }

    /**
     * @param idperfil the idperfil to set
     */
    public void setIdperfil(long idperfil) {
        this.idperfil = idperfil;
    }

    public void setIdempleado(long idempleado) {
        this.id = idempleado;
    }
    
    public long getIdempleado() {
        return id;
    }
    
    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }    
   

    public String getIdusuario() {
        return idusuario;
    }

    

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", idusuario=" + idusuario + ", contraseña=" +contrasena+ ", Id Perfil="+ idperfil +'}';
    }
}
