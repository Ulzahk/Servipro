
package BL.Estadisticas;

import BL.clsConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class clsDia13 {
    
    Connection conn = null;
    
    public clsDia13(){
        
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();        
    }
    
    public List<Modelos.Estadisticas.clsId_dia13> getDia13(){
        List<Modelos.Estadisticas.clsId_dia13> lstclsDia13 = new ArrayList<Modelos.Estadisticas.clsId_dia13>();
        try {
            ResultSet rs = null;
            PreparedStatement ps = conn.prepareStatement("{call spConsultarDiaEsta}");
            rs = ps.executeQuery();
            
            while(rs.next()){
                Modelos.Estadisticas.clsId_dia13 obclsDia13 = new Modelos.Estadisticas.clsId_dia13();
                obclsDia13.setId_dia13(rs.getInt("Id_novedad"));
                obclsDia13.setDescripcionDia13(rs.getString("Descripcion"));
                obclsDia13.setAliasDia13(rs.getString("Alias"));
                
                lstclsDia13.add(obclsDia13);
            }
        } catch (Exception e) {
            
        }
        return lstclsDia13;
    }
}
