
package BL.Estadisticas;

import BL.clsConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class clsDia9 {
    
    
    Connection conn = null;
    
    public clsDia9(){
        
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();        
    }
    
    public List<Modelos.Estadisticas.clsId_dia9> getDia9(){
        List<Modelos.Estadisticas.clsId_dia9> lstclsDia9 = new ArrayList<Modelos.Estadisticas.clsId_dia9>();
        try {
            ResultSet rs = null;
            PreparedStatement ps = conn.prepareStatement("{call spConsultarDiaEsta}");
            rs = ps.executeQuery();
            
            while(rs.next()){
                Modelos.Estadisticas.clsId_dia9 obclsDia9 = new Modelos.Estadisticas.clsId_dia9();
                obclsDia9.setId_dia9(rs.getInt("Id_novedad"));
                obclsDia9.setDescripcionDia9(rs.getString("Descripcion"));
                obclsDia9.setAliasDia9(rs.getString("Alias"));
                
                lstclsDia9.add(obclsDia9);
            }
        } catch (Exception e) {
            
        }
        return lstclsDia9;
    }
    
}
