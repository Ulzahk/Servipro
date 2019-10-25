/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servipro.model;

/**
 *
 * @author PRACTICANTE
 */
public class Usuario {
    
    private long idempleado;    
    private String idusuario;    
    private String contrasena;    
    private long idperfil;

    public Usuario(long idempleado, String idusuario,String contrasena,long idperfil) {
        this.idempleado = idempleado;
        this.idusuario = idusuario;
        this.contrasena = contrasena;
        this.idperfil = idperfil;
    }
    
    public Usuario(){}

    /**
     * @return the idempleado
     */
    public long getIdempleado() {
        return idempleado;
    }

    /**
     * @param idempleado the idempleado to set
     */
    public void setIdempleado(long idempleado) {
        this.idempleado = idempleado;
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
    public long getIdperfil() {
        return idperfil;
    }

    /**
     * @param idperfil the idperfil to set
     */
    public void setIdperfil(long idperfil) {
        this.idperfil = idperfil;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + idempleado + ", idusuario=" + idusuario + ", contraseña=" +contrasena+ ", Id Perfil="+ idperfil +'}';
    }
    
    
}
