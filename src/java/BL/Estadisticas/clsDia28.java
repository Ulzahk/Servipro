
package BL.Estadisticas;

import BL.clsConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class clsDia28 {
    
    Connection conn = null;
    
    public clsDia28(){
        
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();        
    }
    
    public List<Modelos.Estadisticas.clsId_dia28> getDia28(){
        List<Modelos.Estadisticas.clsId_dia28> lstclsDia28 = new ArrayList<Modelos.Estadisticas.clsId_dia28>();
        try {
            ResultSet rs = null;
            PreparedStatement ps = conn.prepareStatement("{call spConsultarDiaEsta}");
            rs = ps.executeQuery();
            
            while(rs.next()){
                Modelos.Estadisticas.clsId_dia28 obclsDia28 = new Modelos.Estadisticas.clsId_dia28();
                obclsDia28.setId_dia28(rs.getInt("Id_novedad"));
                obclsDia28.setDescripcionDia28(rs.getString("Descripcion"));
                obclsDia28.setAliasDia28(rs.getString("Alias"));
                
                lstclsDia28.add(obclsDia28);
            }
        } catch (Exception e) {
            
        }
        return lstclsDia28;
    }
    
}
    

