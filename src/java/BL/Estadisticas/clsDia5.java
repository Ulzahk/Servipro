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

public class clsDia5 {
    
    Connection conn = null;
    
    public clsDia5(){
        
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();        
    }
    
    public List<Modelos.Estadisticas.clsId_dia5> getDia5(){
        List<Modelos.Estadisticas.clsId_dia5> lstclsDia5 = new ArrayList<Modelos.Estadisticas.clsId_dia5>();
        try {
            ResultSet rs = null;
            PreparedStatement ps = conn.prepareStatement("{call spConsultarDiaEsta}");
            rs = ps.executeQuery();
            
            while(rs.next()){
                Modelos.Estadisticas.clsId_dia5 obclsDia5 = new Modelos.Estadisticas.clsId_dia5();
                obclsDia5.setId_dia5(rs.getInt("Id_novedad"));
                obclsDia5.setDescripcionDia5(rs.getString("Descripcion"));
                obclsDia5.setAliasDia5(rs.getString("Alias"));
                
                lstclsDia5.add(obclsDia5);
            }
        } catch (Exception e) {
            
        }
        return lstclsDia5;
    }
}
