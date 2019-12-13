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
public class clsDia25 {
    
    Connection conn = null;
    
    public clsDia25(){
        
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();        
    }
    
    public List<Modelos.Estadisticas.clsId_dia25> getDia25(){
        List<Modelos.Estadisticas.clsId_dia25> lstclsDia25 = new ArrayList<Modelos.Estadisticas.clsId_dia25>();
        try {
            ResultSet rs = null;
            PreparedStatement ps = conn.prepareStatement("{call spConsultarDiaEsta}");
            rs = ps.executeQuery();
            
            while(rs.next()){
                Modelos.Estadisticas.clsId_dia25 obclsDia25 = new Modelos.Estadisticas.clsId_dia25();
                obclsDia25.setId_dia25(rs.getInt("Id_novedad"));
                obclsDia25.setDescripcionDia25(rs.getString("Descripcion"));
                obclsDia25.setAliasDia25(rs.getString("Alias"));
                
                lstclsDia25.add(obclsDia25);
            }
        } catch (Exception e) {
            
        }
        return lstclsDia25;
    }
    
}

