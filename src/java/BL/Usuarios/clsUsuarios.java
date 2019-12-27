/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL.Usuarios;

import BL.clsConexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PRACTICANTE
 */
public class clsUsuarios {

    Connection conn = null;

    public clsUsuarios() {
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();
    }

    public List<Modelos.Usuarios.clsUsuarios> getUsuarios() {
        List<Modelos.Usuarios.clsUsuarios> lstclsUsuarios = new ArrayList<Modelos.Usuarios.clsUsuarios>();

        try {
            ResultSet rs = null;
            PreparedStatement ps = conn.prepareStatement("{call spConsultarUsuario}");
            rs = ps.executeQuery();
            while (rs.next()) {
                Modelos.Usuarios.clsUsuarios obclsUsuario = new Modelos.Usuarios.clsUsuarios();
                obclsUsuario.setId_Usuarios(rs.getString("Id_usuario"));

                Modelos.Usuarios.clsEmpleados obclsEmpleados = new Modelos.Usuarios.clsEmpleados();
                obclsEmpleados.setId_empleado(rs.getInt("Id_empleado"));
                obclsEmpleados.setStPrimerNombre(rs.getString("emplPrimerNombre"));
                obclsEmpleados.setStSegundoNombre(rs.getString("emplSegundoNombre"));
                obclsEmpleados.setStPrimerApellido(rs.getString("emplPrimerApellido"));
                obclsEmpleados.setStSegundoApellido(rs.getString("emplSegundoApellido"));
                obclsUsuario.setObclsEmpleado(obclsEmpleados);

                Modelos.Usuarios.clsPerfil obclsPerfil = new Modelos.Usuarios.clsPerfil();
                obclsPerfil.setId_perfil(rs.getInt("Id_perfil"));
                obclsPerfil.setStDescripcion_Perfil(rs.getString("Descripcion_perfil"));
                obclsUsuario.setObclsPerfil(obclsPerfil);

                obclsUsuario.setContraseña(rs.getString("Contraseña"));

                obclsUsuario.setNro_usuario(rs.getInt("Nro_usuario"));

                lstclsUsuarios.add(obclsUsuario);
            }
        } catch (Exception ex) {
            ex.getMessage();
        }
        return lstclsUsuarios;
    }

    public List<Modelos.Usuarios.clsUsuarios> getBuscarUsuarios(Modelos.clsBuscar obclsBuscar) {
        List<Modelos.Usuarios.clsUsuarios> lstclsUsuarios = new ArrayList<Modelos.Usuarios.clsUsuarios>();

        try {
            ResultSet rs = null;
            PreparedStatement ps = conn.prepareStatement("{call spBuscarUsuarios (?)}");
            ps.setString(1, obclsBuscar.getStBuscar());
            rs = ps.executeQuery();

            while (rs.next()) {
                Modelos.Usuarios.clsUsuarios obclsUsuario = new Modelos.Usuarios.clsUsuarios();
                obclsUsuario.setId_Usuarios(rs.getString("Id_usuario"));

                Modelos.Usuarios.clsEmpleados obclsEmpleados = new Modelos.Usuarios.clsEmpleados();
                obclsEmpleados.setId_empleado(rs.getInt("Id_empleado"));
                obclsEmpleados.setStPrimerNombre(rs.getString("emplPrimerNombre"));
                obclsEmpleados.setStSegundoNombre(rs.getString("emplSegundoNombre"));
                obclsEmpleados.setStPrimerApellido(rs.getString("emplPrimerApellido"));
                obclsEmpleados.setStSegundoApellido(rs.getString("emplSegundoApellido"));
                obclsUsuario.setObclsEmpleado(obclsEmpleados);

                Modelos.Usuarios.clsPerfil obclsPerfil = new Modelos.Usuarios.clsPerfil();
                obclsPerfil.setId_perfil(rs.getInt("Id_perfil"));
                obclsPerfil.setStDescripcion_Perfil(rs.getString("Descripcion_perfil"));
                obclsUsuario.setObclsPerfil(obclsPerfil);

                obclsUsuario.setContraseña(rs.getString("Contraseña"));

                obclsUsuario.setNro_usuario(rs.getInt("Nro_usuario"));

                lstclsUsuarios.add(obclsUsuario);
            }
        } catch (Exception ex) {
            ex.getMessage();
        }
        return lstclsUsuarios;
    }

    public String createUsuario(Modelos.Usuarios.clsUsuarios obclsUsuarios) {
        try {
            PreparedStatement ps = conn.prepareStatement("{call spInsertarUsuarios (?,?,?,?)}");
            ps.setString(1, obclsUsuarios.getId_Usuarios());
            ps.setInt(2, obclsUsuarios.getObclsEmpleado().getId_empleado());
            ps.setString(3, obclsUsuarios.getContraseña());
            ps.setInt(4, obclsUsuarios.getObclsPerfil().getId_perfil());
            ps.execute();
            return "Se realizo el proceso con exito";

        } catch (Exception ex) {
            return "El proceso presento un error";
        }
    }
    
    public String updateUsuarios(Modelos.Usuarios.clsUsuarios obclsUsuarios){
        
        try {
            PreparedStatement ps = conn.prepareStatement("{call spEditarUsuario (?,?,?,?,?)}");
            ps.setString(1, obclsUsuarios.getId_Usuarios());
            ps.setInt(2, obclsUsuarios.getObclsEmpleado().getId_empleado());
            ps.setString(3, obclsUsuarios.getContraseña());
            ps.setInt(4, obclsUsuarios.getObclsPerfil().getId_perfil());
            ps.setInt(5, obclsUsuarios.getNro_usuario());
            ps.execute();
            
            return "Se realizo el proceso con exito";
             
        } catch (Exception ex) {
            return "El proceso presento un error";
        }
    }
    
    public String deleteUsuarios(Modelos.Usuarios.clsUsuarios obclsUsuarios){
        
        try {
            PreparedStatement ps = conn.prepareStatement("{call spEliminarUsuario(?)}");
            ps.setInt(1, obclsUsuarios.getNro_usuario());
            ps.execute();
            
            return "Se ralizo el proceso con exito";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
}
