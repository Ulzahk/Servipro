/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos.Usuarios;

/**
 *
 * @author PRACTICANTE
 */
public class clsUsuarios {
    
    public String Id_Usuarios;
    public clsEmpleados obclsEmpleado;
    public String Contraseña;
    public clsPerfil obclsPerfil;
    public int Nro_usuario;

    public String getId_Usuarios() {
        return Id_Usuarios;
    }

    public void setId_Usuarios(String Id_Usuarios) {
        this.Id_Usuarios = Id_Usuarios;
    }

    public clsEmpleados getObclsEmpleado() {
        return obclsEmpleado;
    }

    public void setObclsEmpleado(clsEmpleados obclsEmpleado) {
        this.obclsEmpleado = obclsEmpleado;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public clsPerfil getObclsPerfil() {
        return obclsPerfil;
    }

    public void setObclsPerfil(clsPerfil obclsPerfil) {
        this.obclsPerfil = obclsPerfil;
    }

    public int getNro_usuario() {
        return Nro_usuario;
    }

    public void setNro_usuario(int Nro_usuario) {
        this.Nro_usuario = Nro_usuario;
    }
    
    
}
