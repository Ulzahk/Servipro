
package BL.Estadisticas;

import BL.clsConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class clsMes {
    
    Connection conn = null;
    
    public clsMes(){
    
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();
    }
    
    public List<Modelos.Estadisticas.clsMes> getMes(){
        List<Modelos.Estadisticas.clsMes> lstclsMes = new ArrayList<Modelos.Estadisticas.clsMes>();
        try {
            ResultSet rs = null;
            PreparedStatement ps = conn.prepareStatement("{call spConsultarMes}");
            rs = ps.executeQuery();
            
            while(rs.next()){
                Modelos.Estadisticas.clsMes obclsMes = new Modelos.Estadisticas.clsMes();
                obclsMes.setId_mes(rs.getInt("Id_mes"));
                obclsMes.setMesNombre(rs.getString("mesNombre"));
                
                lstclsMes.add(obclsMes);
            }
        } catch (Exception e) {
        }
        return lstclsMes;
    }
}
