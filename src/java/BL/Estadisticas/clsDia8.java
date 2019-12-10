
package BL.Estadisticas;

import BL.clsConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class clsDia8 {
    
    Connection conn = null;
    
    public clsDia8(){
        
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();        
    }
    
    public List<Modelos.Estadisticas.clsId_dia8> getDia8(){
        List<Modelos.Estadisticas.clsId_dia8> lstclsDia8 = new ArrayList<Modelos.Estadisticas.clsId_dia8>();
        try {
            ResultSet rs = null;
            PreparedStatement ps = conn.prepareStatement("{call spConsultarDiaEsta}");
            rs = ps.executeQuery();
            
            while(rs.next()){
                Modelos.Estadisticas.clsId_dia8 obclsDia8 = new Modelos.Estadisticas.clsId_dia8();
                obclsDia8.setId_dia8(rs.getInt("Id_novedad"));
                obclsDia8.setDescripcionDia8(rs.getString("Descripcion"));
                obclsDia8.setAliasDia8(rs.getString("Alias"));
                
                lstclsDia8.add(obclsDia8);
            }
        } catch (Exception e) {
            
        }
        return lstclsDia8;
    }
    
}
