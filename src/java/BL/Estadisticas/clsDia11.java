
package BL.Estadisticas;

import BL.clsConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class clsDia11 {
    
    Connection conn = null;
    
    public clsDia11(){
        
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();        
    }
    
    public List<Modelos.Estadisticas.clsId_dia11> getDia11(){
        List<Modelos.Estadisticas.clsId_dia11> lstclsDia11 = new ArrayList<Modelos.Estadisticas.clsId_dia11>();
        try {
            ResultSet rs = null;
            PreparedStatement ps = conn.prepareStatement("{call spConsultarDiaEsta}");
            rs = ps.executeQuery();
            
            while(rs.next()){
                Modelos.Estadisticas.clsId_dia11 obclsDia11 = new Modelos.Estadisticas.clsId_dia11();
                obclsDia11.setId_dia11(rs.getInt("Id_novedad"));
                obclsDia11.setDescripcionDia11(rs.getString("Descripcion"));
                obclsDia11.setAliasDia11(rs.getString("Alias"));
                
                lstclsDia11.add(obclsDia11);
            }
        } catch (Exception e) {
            
        }
        return lstclsDia11;
    }
}
