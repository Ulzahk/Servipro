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
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDEmpleado")
    private long idempleado;
    @Column(name = "IDUsuario")
    @NotBlank(message = "id de usuario es obligatorio")
    private String idusuario;
    @Column(name = "Contraseña")
    @NotBlank(message = "La constraseña es obligatoria")
    private String contrasena;
    @Column(name = "IDPerfil")
    @NotBlank(message = "El id del perfil es obligatorio")
    private long idperfil;
   

    public Usuario() {}

    public Usuario(long idempleado, String idusuario,String contrasena,long idperfil) {
        this.idempleado = idempleado;
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
        this.idempleado = idempleado;
    }
    
    public long getIdempleado() {
        return idempleado;
    }
    
    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }    
   

    public String getIdusuario() {
        return idusuario;
    }

    

    @Override
    public String toString() {
        return "User{" + "id=" + idempleado + ", idusuario=" + idusuario + ", contraseña=" +contrasena+ ", Id Perfil="+ idperfil +'}';
    }
}
