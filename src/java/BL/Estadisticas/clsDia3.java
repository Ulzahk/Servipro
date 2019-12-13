
package BL.Estadisticas;

import BL.clsConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class clsDia3 {
    
        Connection conn = null;
    
    public clsDia3(){
        
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();        
    }
    
    public List<Modelos.Estadisticas.clsId_dia3> getDia3(){
        List<Modelos.Estadisticas.clsId_dia3> lstclsDia3 = new ArrayList<Modelos.Estadisticas.clsId_dia3>();
        try {
            ResultSet rs = null;
            PreparedStatement ps = conn.prepareStatement("{call spConsultarDiaEsta}");
            rs = ps.executeQuery();
            
            while(rs.next()){
                Modelos.Estadisticas.clsId_dia3 obclsDia3 = new Modelos.Estadisticas.clsId_dia3();
                obclsDia3.setId_dia3(rs.getInt("Id_novedad"));
                obclsDia3.setDescripcionDia3(rs.getString("Descripcion"));
                obclsDia3.setAliasDia3(rs.getString("Alias"));
                
                lstclsDia3.add(obclsDia3);
            }
        } catch (Exception e) {
            
        }
        return lstclsDia3;
    }
}
