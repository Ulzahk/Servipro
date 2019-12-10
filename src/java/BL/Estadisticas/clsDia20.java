
package BL.Estadisticas;

import BL.clsConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class clsDia20 {
    
    Connection conn = null;
    
    public clsDia20(){
        
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();        
    }
    
    public List<Modelos.Estadisticas.clsId_dia20> getDia20(){
        List<Modelos.Estadisticas.clsId_dia20> lstclsDia20 = new ArrayList<Modelos.Estadisticas.clsId_dia20>();
        try {
            ResultSet rs = null;
            PreparedStatement ps = conn.prepareStatement("{call spConsultarDiaEsta}");
            rs = ps.executeQuery();
            
            while(rs.next()){
                Modelos.Estadisticas.clsId_dia20 obclsDia20 = new Modelos.Estadisticas.clsId_dia20();
                obclsDia20.setId_dia20(rs.getInt("Id_novedad"));
                obclsDia20.setDescripcionDia20(rs.getString("Descripcion"));
                obclsDia20.setAliasDia20(rs.getString("Alias"));
                
                lstclsDia20.add(obclsDia20);
            }
        } catch (Exception e) {
            
        }
        return lstclsDia20;
    }
    
}
