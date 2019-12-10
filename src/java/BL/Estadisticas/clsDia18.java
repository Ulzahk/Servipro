
package BL.Estadisticas;

import BL.clsConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class clsDia18 {
    
    Connection conn = null;
    
    public clsDia18(){
        
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();        
    }
    
    public List<Modelos.Estadisticas.clsId_dia18> getDia18(){
        List<Modelos.Estadisticas.clsId_dia18> lstclsDia18 = new ArrayList<Modelos.Estadisticas.clsId_dia18>();
        try {
            ResultSet rs = null;
            PreparedStatement ps = conn.prepareStatement("{call spConsultarDiaEsta}");
            rs = ps.executeQuery();
            
            while(rs.next()){
                Modelos.Estadisticas.clsId_dia18 obclsDia18 = new Modelos.Estadisticas.clsId_dia18();
                obclsDia18.setId_dia18(rs.getInt("Id_novedad"));
                obclsDia18.setDescripcionDia18(rs.getString("Descripcion"));
                obclsDia18.setAliasDia18(rs.getString("Alias"));
                
                lstclsDia18.add(obclsDia18);
            }
        } catch (Exception e) {
            
        }
        return lstclsDia18;
    }
    
}
