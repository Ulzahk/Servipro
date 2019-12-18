/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL.ModelosPerfil;

import BL.clsConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PRACTICANTE
 */
public class clsModulos {
    
    Connection conn = null;
    
    public clsModulos(){
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();
    }
    
    public List<Modelos.ModulosPerfil.clsModulo> getModulos(){
        
        List<Modelos.ModulosPerfil.clsModulo> lstclsModulos = new ArrayList<Modelos.ModulosPerfil.clsModulo>();
        
        try {
            PreparedStatement ps = conn.prepareStatement("{call spConsultarModulos}");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Modelos.ModulosPerfil.clsModulo obclsModulo = new Modelos.ModulosPerfil.clsModulo();
                obclsModulo.setId_modulo(rs.getInt("Id_modulo"));
                obclsModulo.setStNombre_modulo(rs.getString("Nombre_modulo"));
                
                lstclsModulos.add(obclsModulo);
            }
        } catch (Exception e) {
            
        }
        return lstclsModulos;
    }
}
