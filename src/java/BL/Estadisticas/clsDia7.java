
package BL.Estadisticas;

import BL.clsConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class clsDia7 {
    
    Connection conn = null;
    
    public clsDia7(){
        
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();        
    }
    
    public List<Modelos.Estadisticas.clsId_dia7> getDia7(){
        List<Modelos.Estadisticas.clsId_dia7> lstclsDia7 = new ArrayList<Modelos.Estadisticas.clsId_dia7>();
        try {
            ResultSet rs = null;
            PreparedStatement ps = conn.prepareStatement("{call spConsultarDiaEsta}");
            rs = ps.executeQuery();
            
            while(rs.next()){
                Modelos.Estadisticas.clsId_dia7 obclsDia7 = new Modelos.Estadisticas.clsId_dia7();
                obclsDia7.setId_dia7(rs.getInt("Id_novedad"));
                obclsDia7.setDescripcionDia7(rs.getString("Descripcion"));
                obclsDia7.setAliasDia7(rs.getString("Alias"));
                
                lstclsDia7.add(obclsDia7);
            }
        } catch (Exception e) {
            
        }
        return lstclsDia7;
    }
    
}
