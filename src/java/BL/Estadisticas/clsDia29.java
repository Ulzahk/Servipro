
package BL.Estadisticas;

import BL.clsConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class clsDia29 {
    
    Connection conn = null;
    
    public clsDia29(){
        
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();        
    }
    
    public List<Modelos.Estadisticas.clsId_dia29> getDia29(){
        List<Modelos.Estadisticas.clsId_dia29> lstclsDia29 = new ArrayList<Modelos.Estadisticas.clsId_dia29>();
        try {
            ResultSet rs = null;
            PreparedStatement ps = conn.prepareStatement("{call spConsultarDiaEsta}");
            rs = ps.executeQuery();
            
            while(rs.next()){
                Modelos.Estadisticas.clsId_dia29 obclsDia29 = new Modelos.Estadisticas.clsId_dia29();
                obclsDia29.setId_dia29(rs.getInt("Id_novedad"));
                obclsDia29.setDescripcionDia29(rs.getString("Descripcion"));
                obclsDia29.setAliasDia29(rs.getString("Alias"));
                
                lstclsDia29.add(obclsDia29);
            }
        } catch (Exception e) {
            
        }
        return lstclsDia29;
    }
    
}
    

