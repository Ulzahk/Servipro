/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL.Estadisticas;

import BL.clsConexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PRACTICANTE
 */
public class clsDia31 {
    
    Connection conn = null;
    
    public clsDia31(){
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();
    }
    
    public List<Modelos.Estadisticas.clsId_dia31> getDia31(){
        List<Modelos.Estadisticas.clsId_dia31> lstclsDia31 = new ArrayList<Modelos.Estadisticas.clsId_dia31>();
        try {
            ResultSet rs = null;
            PreparedStatement ps = conn.prepareStatement("{call spConsultarDiaEsta}");
            rs = ps.executeQuery();
            
            while(rs.next()){
                Modelos.Estadisticas.clsId_dia31 obclsDia31 = new Modelos.Estadisticas.clsId_dia31();
                obclsDia31.setId_dia31(rs.getInt("Id_novedad"));
                obclsDia31.setDescripcionDia31(rs.getString("Descripcion"));
                obclsDia31.setAliasDia31(rs.getString("Alias"));
                
                lstclsDia31.add(obclsDia31);
            }
        } catch (Exception e) {
        }
        return lstclsDia31;
    }
}
