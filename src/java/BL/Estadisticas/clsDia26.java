
package BL.Estadisticas;

import BL.clsConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class clsDia26 {
    
    Connection conn = null;
    
    public clsDia26(){
        
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();        
    }
    
    public List<Modelos.Estadisticas.clsId_dia26> getDia26(){
        List<Modelos.Estadisticas.clsId_dia26> lstclsDia26 = new ArrayList<Modelos.Estadisticas.clsId_dia26>();
        try {
            ResultSet rs = null;
            PreparedStatement ps = conn.prepareStatement("{call spConsultarDiaEsta}");
            rs = ps.executeQuery();
            
            while(rs.next()){
                Modelos.Estadisticas.clsId_dia26 obclsDia26 = new Modelos.Estadisticas.clsId_dia26();
                obclsDia26.setId_dia26(rs.getInt("Id_novedad"));
                obclsDia26.setDescripcionDia26(rs.getString("Descripcion"));
                obclsDia26.setAliasDia26(rs.getString("Alias"));
                
                lstclsDia26.add(obclsDia26);
            }
        } catch (Exception e) {
            
        }
        return lstclsDia26;
    }
    
}
    

