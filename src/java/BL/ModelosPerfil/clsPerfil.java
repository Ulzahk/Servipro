/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL.ModelosPerfil;

import BL.clsConexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PRACTICANTE
 */
public class clsPerfil {

    Connection conn = null;

    public clsPerfil() {
        
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();
    }
    public List<Modelos.ModulosPerfil.clsPerfil> getPerfil(){
        
        List<Modelos.ModulosPerfil.clsPerfil> lstclsPerfil = new ArrayList<Modelos.ModulosPerfil.clsPerfil>();
        
        try {
            PreparedStatement ps = conn.prepareStatement("{call spConsultarPerfil()}");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Modelos.ModulosPerfil.clsPerfil obclsPerfil = new Modelos.ModulosPerfil.clsPerfil();
                obclsPerfil.setId_perfil(rs.getInt("Id_perfil"));
                obclsPerfil.setStDescripcion_perfil(rs.getString("Descripcion_perfil"));
                
                lstclsPerfil.add(obclsPerfil);
            }   
        } catch (Exception e) {
            
        }
        return lstclsPerfil;
    }
}
