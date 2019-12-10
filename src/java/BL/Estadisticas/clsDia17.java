
package BL.Estadisticas;

import BL.clsConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class clsDia17 {
    
    Connection conn = null;
    
    public clsDia17(){
        
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();        
    }
    
    public List<Modelos.Estadisticas.clsId_dia17> getDia17(){
        List<Modelos.Estadisticas.clsId_dia17> lstclsDia17 = new ArrayList<Modelos.Estadisticas.clsId_dia17>();
        try {
            ResultSet rs = null;
            PreparedStatement ps = conn.prepareStatement("{call spConsultarDiaEsta}");
            rs = ps.executeQuery();
            
            while(rs.next()){
                Modelos.Estadisticas.clsId_dia17 obclsDia17 = new Modelos.Estadisticas.clsId_dia17();
                obclsDia17.setId_dia17(rs.getInt("Id_novedad"));
                obclsDia17.setDescripcionDia17(rs.getString("Descripcion"));
                obclsDia17.setAliasDia17(rs.getString("Alias"));
                
                lstclsDia17.add(obclsDia17);
            }
        } catch (Exception e) {
            
        }
        return lstclsDia17;
    }
    
}
