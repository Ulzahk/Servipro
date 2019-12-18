/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos.ModulosPerfil;

/**
 *
 * @author PRACTICANTE
 */
public class clsModulosPerfil {
    
    public int Id_modulos_perfil;
    public clsModulo obclsModulo;
    public clsPerfil obclsPerfil;

    public int getId_modulos_perfil() {
        return Id_modulos_perfil;
    }

    public void setId_modulos_perfil(int Id_modulos_perfil) {
        this.Id_modulos_perfil = Id_modulos_perfil;
    }

    public clsModulo getObclsModulo() {
        return obclsModulo;
    }

    public void setObclsModulo(clsModulo obclsModulo) {
        this.obclsModulo = obclsModulo;
    }

    public clsPerfil getObclsPerfil() {
        return obclsPerfil;
    }

    public void setObclsPerfil(clsPerfil obclsPerfil) {
        this.obclsPerfil = obclsPerfil;
    }

   
}
