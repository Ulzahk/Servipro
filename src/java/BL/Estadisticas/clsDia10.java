
package BL.Estadisticas;

import BL.clsConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class clsDia10 {
    
    
    Connection conn = null;
    
    public clsDia10(){
        
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();        
    }
    
    public List<Modelos.Estadisticas.clsId_dia10> getDia10(){
        List<Modelos.Estadisticas.clsId_dia10> lstclsDia10 = new ArrayList<Modelos.Estadisticas.clsId_dia10>();
        try {
            ResultSet rs = null;
            PreparedStatement ps = conn.prepareStatement("{call spConsultarDiaEsta}");
            rs = ps.executeQuery();
            
            while(rs.next()){
                Modelos.Estadisticas.clsId_dia10 obclsDia10 = new Modelos.Estadisticas.clsId_dia10();
                obclsDia10.setId_dia10(rs.getInt("Id_novedad"));
                obclsDia10.setDescripcionDia10(rs.getString("Descripcion"));
                obclsDia10.setAliasDia10(rs.getString("Alias"));
                
                lstclsDia10.add(obclsDia10);
            }
        } catch (Exception e) {
            
        }
        return lstclsDia10;
    }
    
}
