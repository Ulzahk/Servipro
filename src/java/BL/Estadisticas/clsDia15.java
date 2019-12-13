
package BL.Estadisticas;

import BL.clsConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class clsDia15 {
    
    Connection conn = null;
    
    public clsDia15(){
        
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();        
    }
    
    public List<Modelos.Estadisticas.clsId_dia15> getDia15(){
        List<Modelos.Estadisticas.clsId_dia15> lstclsDia15 = new ArrayList<Modelos.Estadisticas.clsId_dia15>();
        try {
            ResultSet rs = null;
            PreparedStatement ps = conn.prepareStatement("{call spConsultarDiaEsta}");
            rs = ps.executeQuery();
            
            while(rs.next()){
                Modelos.Estadisticas.clsId_dia15 obclsDia15 = new Modelos.Estadisticas.clsId_dia15();
                obclsDia15.setId_dia15(rs.getInt("Id_novedad"));
                obclsDia15.setDescripcionDia15(rs.getString("Descripcion"));
                obclsDia15.setAliasDia15(rs.getString("Alias"));
                
                lstclsDia15.add(obclsDia15);
            }
        } catch (Exception e) {
            
        }
        return lstclsDia15;
    }
}
