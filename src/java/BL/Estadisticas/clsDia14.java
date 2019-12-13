
package BL.Estadisticas;

import BL.clsConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class clsDia14 {
    
    Connection conn = null;
    
    public clsDia14(){
        
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();        
    }
    
    public List<Modelos.Estadisticas.clsId_dia14> getDia14(){
        List<Modelos.Estadisticas.clsId_dia14> lstclsDia14 = new ArrayList<Modelos.Estadisticas.clsId_dia14>();
        try {
            ResultSet rs = null;
            PreparedStatement ps = conn.prepareStatement("{call spConsultarDiaEsta}");
            rs = ps.executeQuery();
            
            while(rs.next()){
                Modelos.Estadisticas.clsId_dia14 obclsDia14 = new Modelos.Estadisticas.clsId_dia14();
                obclsDia14.setId_dia14(rs.getInt("Id_novedad"));
                obclsDia14.setDescripcionDia14(rs.getString("Descripcion"));
                obclsDia14.setAliasDia14(rs.getString("Alias"));
                
                lstclsDia14.add(obclsDia14);
            }
        } catch (Exception e) {
            
        }
        return lstclsDia14;
    }
}
