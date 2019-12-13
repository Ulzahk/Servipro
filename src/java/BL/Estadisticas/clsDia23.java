
package BL.Estadisticas;

import BL.clsConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class clsDia23 {

    Connection conn = null;
    
    public clsDia23(){
        
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();        
    }
    
    public List<Modelos.Estadisticas.clsId_dia23> getDia23(){
        List<Modelos.Estadisticas.clsId_dia23> lstclsDia23 = new ArrayList<Modelos.Estadisticas.clsId_dia23>();
        try {
            ResultSet rs = null;
            PreparedStatement ps = conn.prepareStatement("{call spConsultarDiaEsta}");
            rs = ps.executeQuery();
            
            while(rs.next()){
                Modelos.Estadisticas.clsId_dia23 obclsDia23 = new Modelos.Estadisticas.clsId_dia23();
                obclsDia23.setId_dia23(rs.getInt("Id_novedad"));
                obclsDia23.setDescripcionDia23(rs.getString("Descripcion"));
                obclsDia23.setAliasDia23(rs.getString("Alias"));
                
                lstclsDia23.add(obclsDia23);
            }
        } catch (Exception e) {
            
        }
        return lstclsDia23;
    }
    
}
    

