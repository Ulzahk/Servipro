
package BL.Estadisticas;

import BL.clsConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class clsDia16 {
    
    Connection conn = null;
    
    public clsDia16(){
        
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();        
    }
    
    public List<Modelos.Estadisticas.clsId_dia16> getDia16(){
        List<Modelos.Estadisticas.clsId_dia16> lstclsDia16 = new ArrayList<Modelos.Estadisticas.clsId_dia16>();
        try {
            ResultSet rs = null;
            PreparedStatement ps = conn.prepareStatement("{call spConsultarDiaEsta}");
            rs = ps.executeQuery();
            
            while(rs.next()){
                Modelos.Estadisticas.clsId_dia16 obclsDia16 = new Modelos.Estadisticas.clsId_dia16();
                obclsDia16.setId_dia16(rs.getInt("Id_novedad"));
                obclsDia16.setDescripcionDia16(rs.getString("Descripcion"));
                obclsDia16.setAliasDia16(rs.getString("Alias"));
                
                lstclsDia16.add(obclsDia16);
            }
        } catch (Exception e) {
            
        }
        return lstclsDia16;
    }
}
