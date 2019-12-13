
package BL.Estadisticas;

import BL.clsConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class clsDia27 {
    
    Connection conn = null;
    
    public clsDia27(){
        
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();        
    }
    
    public List<Modelos.Estadisticas.clsId_dia27> getDia27(){
        List<Modelos.Estadisticas.clsId_dia27> lstclsDia27 = new ArrayList<Modelos.Estadisticas.clsId_dia27>();
        try {
            ResultSet rs = null;
            PreparedStatement ps = conn.prepareStatement("{call spConsultarDiaEsta}");
            rs = ps.executeQuery();
            
            while(rs.next()){
                Modelos.Estadisticas.clsId_dia27 obclsDia27 = new Modelos.Estadisticas.clsId_dia27();
                obclsDia27.setId_dia27(rs.getInt("Id_novedad"));
                obclsDia27.setDescripcionDia27(rs.getString("Descripcion"));
                obclsDia27.setAliasDia27(rs.getString("Alias"));
                
                lstclsDia27.add(obclsDia27);
            }
        } catch (Exception e) {
            
        }
        return lstclsDia27;
    }
    
}
    

