
package BL.Estadisticas;

import BL.clsConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class clsDia2 {
    
    Connection conn = null;
    
    public clsDia2(){
        
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();        
    }
    
    public List<Modelos.Estadisticas.clsId_dia2> getDia2(){
        List<Modelos.Estadisticas.clsId_dia2> lstclsDia2 = new ArrayList<Modelos.Estadisticas.clsId_dia2>();
        try {
            ResultSet rs = null;
            PreparedStatement ps = conn.prepareStatement("{call spConsultarDiaEsta}");
            rs = ps.executeQuery();
            
            while(rs.next()){
                Modelos.Estadisticas.clsId_dia2 obclsDia2 = new Modelos.Estadisticas.clsId_dia2();
                obclsDia2.setId_dia2(rs.getInt("Id_novedad"));
                obclsDia2.setDescripcionDia2(rs.getString("Descripcion"));
                obclsDia2.setAliasDia2(rs.getString("Alias"));
                
                lstclsDia2.add(obclsDia2);
            }
        } catch (Exception e) {
            
        }
        return lstclsDia2;
    }
}
