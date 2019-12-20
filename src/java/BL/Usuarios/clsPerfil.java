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
public class clsPerfil {
    
    Connection conn = null;
    
    public clsPerfil(){
        
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();  
    }
    
    public List<Modelos.Usuarios.clsPerfil> getPerfil(){
        List<Modelos.Usuarios.clsPerfil> lstclsPerfil = new ArrayList<Modelos.Usuarios.clsPerfil>();
        
        try {
            ResultSet rs = null;
            PreparedStatement ps = conn.prepareStatement("{call spConsultarPerfil}");
            rs = ps.executeQuery();
            
            while(rs.next()){
                Modelos.Usuarios.clsPerfil obclsPerfil = new Modelos.Usuarios.clsPerfil();
                obclsPerfil.setId_perfil(rs.getInt("Id_perfil"));
                obclsPerfil.setStDescripcion_Perfil(rs.getString("Descripcion_perfil"));
                
                lstclsPerfil.add(obclsPerfil);
            }
        } catch (Exception e) {
            
        }
        return lstclsPerfil;
    } 
}
