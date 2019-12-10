
package BL.Estadisticas;

import BL.clsConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class clsDia21 {
    
    Connection conn = null;
    
    public clsDia21(){
        
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();        
    }
    
    public List<Modelos.Estadisticas.clsId_dia21> getDia21(){
        List<Modelos.Estadisticas.clsId_dia21> lstclsDia21 = new ArrayList<Modelos.Estadisticas.clsId_dia21>();
        try {
            ResultSet rs = null;
            PreparedStatement ps = conn.prepareStatement("{call spConsultarDiaEsta}");
            rs = ps.executeQuery();
            
            while(rs.next()){
                Modelos.Estadisticas.clsId_dia21 obclsDia21 = new Modelos.Estadisticas.clsId_dia21();
                obclsDia21.setId_dia21(rs.getInt("Id_novedad"));
                obclsDia21.setDescripcionDia21(rs.getString("Descripcion"));
                obclsDia21.setAliasDia21(rs.getString("Alias"));
                
                lstclsDia21.add(obclsDia21);
            }
        } catch (Exception e) {
            
        }
        return lstclsDia21;
    }
    
}
    

