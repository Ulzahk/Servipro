
package BL.Estadisticas;

import BL.clsConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class clsDia4 {
    
    Connection conn = null;
    
    public clsDia4(){
        
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();        
    }
    
    public List<Modelos.Estadisticas.clsId_dia4> getDia4(){
        List<Modelos.Estadisticas.clsId_dia4> lstclsDia4 = new ArrayList<Modelos.Estadisticas.clsId_dia4>();
        try {
            ResultSet rs = null;
            PreparedStatement ps = conn.prepareStatement("{call spConsultarDiaEsta}");
            rs = ps.executeQuery();
            
            while(rs.next()){
                Modelos.Estadisticas.clsId_dia4 obclsDia4 = new Modelos.Estadisticas.clsId_dia4();
                obclsDia4.setId_dia4(rs.getInt("Id_novedad"));
                obclsDia4.setDescripcionDia4(rs.getString("Descripcion"));
                obclsDia4.setAliasDia4(rs.getString("Alias"));
                
                lstclsDia4.add(obclsDia4);
            }
        } catch (Exception e) {
            
        }
        return lstclsDia4;
    }
}
