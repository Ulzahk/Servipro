
package BL.Estadisticas;

import BL.clsConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class clsDia19 {
    
    Connection conn = null;
    
    public clsDia19(){
        
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();        
    }
    
    public List<Modelos.Estadisticas.clsId_dia19> getDia19(){
        List<Modelos.Estadisticas.clsId_dia19> lstclsDia19 = new ArrayList<Modelos.Estadisticas.clsId_dia19>();
        try {
            ResultSet rs = null;
            PreparedStatement ps = conn.prepareStatement("{call spConsultarDiaEsta}");
            rs = ps.executeQuery();
            
            while(rs.next()){
                Modelos.Estadisticas.clsId_dia19 obclsDia19 = new Modelos.Estadisticas.clsId_dia19();
                obclsDia19.setId_dia19(rs.getInt("Id_novedad"));
                obclsDia19.setDescripcionDia19(rs.getString("Descripcion"));
                obclsDia19.setAliasDia19(rs.getString("Alias"));
                
                lstclsDia19.add(obclsDia19);
            }
        } catch (Exception e) {
            
        }
        return lstclsDia19;
    }
    
}
