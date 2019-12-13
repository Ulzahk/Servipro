
package BL.Estadisticas;

import BL.clsConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class clsDia22{
    
    Connection conn = null;
    
    public clsDia22(){
        
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();        
    }
    
    public List<Modelos.Estadisticas.clsId_dia22> getDia22(){
        List<Modelos.Estadisticas.clsId_dia22> lstclsDia22 = new ArrayList<Modelos.Estadisticas.clsId_dia22>();
        try {
            ResultSet rs = null;
            PreparedStatement ps = conn.prepareStatement("{call spConsultarDiaEsta}");
            rs = ps.executeQuery();
            
            while(rs.next()){
                Modelos.Estadisticas.clsId_dia22 obclsDia22 = new Modelos.Estadisticas.clsId_dia22();
                obclsDia22.setId_dia22(rs.getInt("Id_novedad"));
                obclsDia22.setDescripcionDia22(rs.getString("Descripcion"));
                obclsDia22.setAliasDia22(rs.getString("Alias"));
                
                lstclsDia22.add(obclsDia22);
            }
        } catch (Exception e) {
            
        }
        return lstclsDia22;
    }
    
}
    

