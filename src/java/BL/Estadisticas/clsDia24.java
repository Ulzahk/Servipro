/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL.Estadisticas;

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
public class clsDia24 {
    
    Connection conn = null;
    
    public clsDia24(){
        
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();        
    }
    
    public List<Modelos.Estadisticas.clsId_dia24> getDia24(){
        List<Modelos.Estadisticas.clsId_dia24> lstclsDia24 = new ArrayList<Modelos.Estadisticas.clsId_dia24>();
        try {
            ResultSet rs = null;
            PreparedStatement ps = conn.prepareStatement("{call spConsultarDiaEsta}");
            rs = ps.executeQuery();
            
            while(rs.next()){
                Modelos.Estadisticas.clsId_dia24 obclsDia24 = new Modelos.Estadisticas.clsId_dia24();
                obclsDia24.setId_dia24(rs.getInt("Id_novedad"));
                obclsDia24.setDescripcionDia24(rs.getString("Descripcion"));
                obclsDia24.setAliasDia24(rs.getString("Alias"));
                
                lstclsDia24.add(obclsDia24);
            }
        } catch (Exception e) {
            
        }
        return lstclsDia24;
    }
    
}

