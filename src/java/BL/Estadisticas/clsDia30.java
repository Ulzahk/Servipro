
package BL.Estadisticas;

import BL.clsConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class clsDia30 {
    
    Connection conn = null;
    
    public clsDia30(){
        
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();        
    }
    
    public List<Modelos.Estadisticas.clsId_dia30> getDia30(){
        List<Modelos.Estadisticas.clsId_dia30> lstclsDia30 = new ArrayList<Modelos.Estadisticas.clsId_dia30>();
        try {
            ResultSet rs = null;
            PreparedStatement ps = conn.prepareStatement("{call spConsultarDiaEsta}");
            rs = ps.executeQuery();
            
            while(rs.next()){
                Modelos.Estadisticas.clsId_dia30 obclsDia30 = new Modelos.Estadisticas.clsId_dia30();
                obclsDia30.setId_dia30(rs.getInt("Id_novedad"));
                obclsDia30.setDescripcionDia30(rs.getString("Descripcion"));
                obclsDia30.setAliasDia30(rs.getString("Alias"));
                
                lstclsDia30.add(obclsDia30);
            }
        } catch (Exception e) {
            
        }
        return lstclsDia30;
    }
    
}
    

