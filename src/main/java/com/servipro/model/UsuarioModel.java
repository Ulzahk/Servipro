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
public class UsuarioModel {
    
    private long id;    
    private String idusuario;    
    private String contrasena;    
    private long idperfil;
    private boolean estado;

    public UsuarioModel(long id, String idusuario,String contrasena,long idperfil,boolean estado) {
        this.id = id;
        this.idusuario = idusuario;
        this.contrasena = contrasena;
        this.idperfil = idperfil;
        this.estado = estado;
    }
    
    public UsuarioModel(){
    
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + getId() + ", idusuario=" + getIdusuario() + ", contraseña=" +getContrasena()+ ", IdPerfil="+ getIdperfil() +'}';
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
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
    public long getIdperfil() {
        return idperfil;
    }

    /**
     * @param idperfil the idperfil to set
     */
    public void setIdperfil(long idperfil) {
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
