
package BL.Estadisticas;

import BL.clsConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class clsDia6 {
    
    Connection conn = null;
    
    public clsDia6(){
        
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();        
    }
    
    public List<Modelos.Estadisticas.clsId_dia6> getDia6(){
        List<Modelos.Estadisticas.clsId_dia6> lstclsDia6 = new ArrayList<Modelos.Estadisticas.clsId_dia6>();
        try {
            ResultSet rs = null;
            PreparedStatement ps = conn.prepareStatement("{call spConsultarDiaEsta}");
            rs = ps.executeQuery();
            
            while(rs.next()){
                Modelos.Estadisticas.clsId_dia6 obclsDia6 = new Modelos.Estadisticas.clsId_dia6();
                obclsDia6.setId_dia6(rs.getInt("Id_novedad"));
                obclsDia6.setDescripcionDia6(rs.getString("Descripcion"));
                obclsDia6.setAliasDia6(rs.getString("Alias"));
                
                lstclsDia6.add(obclsDia6);
            }
        } catch (Exception e) {
            
        }
        return lstclsDia6;
    }
    
}
