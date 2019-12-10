
package BL.Estadisticas;

import BL.clsConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class clsDia12 {
    
    Connection conn = null;
    
    public clsDia12(){
        
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();        
    }
    
    public List<Modelos.Estadisticas.clsId_dia12> getDia12(){
        List<Modelos.Estadisticas.clsId_dia12> lstclsDia12 = new ArrayList<Modelos.Estadisticas.clsId_dia12>();
        try {
            ResultSet rs = null;
            PreparedStatement ps = conn.prepareStatement("{call spConsultarDiaEsta}");
            rs = ps.executeQuery();
            
            while(rs.next()){
                Modelos.Estadisticas.clsId_dia12 obclsDia12 = new Modelos.Estadisticas.clsId_dia12();
                obclsDia12.setId_dia12(rs.getInt("Id_novedad"));
                obclsDia12.setDescripcionDia12(rs.getString("Descripcion"));
                obclsDia12.setAliasDia12(rs.getString("Alias"));
                
                lstclsDia12.add(obclsDia12);
            }
        } catch (Exception e) {
            
        }
        return lstclsDia12;
    }
}
