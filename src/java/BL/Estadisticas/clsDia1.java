
package BL.Estadisticas;

import BL.clsConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class clsDia1 {
    
    Connection conn = null;
    
    public clsDia1(){
        
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();        
    }
    
    public List<Modelos.Estadisticas.clsId_dia1> getDia1(){
        List<Modelos.Estadisticas.clsId_dia1> lstclsDia1 = new ArrayList<Modelos.Estadisticas.clsId_dia1>();
        try {
            ResultSet rs = null;
            PreparedStatement ps = conn.prepareStatement("{call spConsultarDiaEsta()}");
            rs = ps.executeQuery();
            
            while(rs.next()){
                Modelos.Estadisticas.clsId_dia1 obclsDia1 = new Modelos.Estadisticas.clsId_dia1();
                obclsDia1.setId_dia1(rs.getInt("Id_novedad"));
                obclsDia1.setDescripcionDia1(rs.getString("Descripcion"));
                obclsDia1.setAliasDia1(rs.getString("Alias"));
                
                lstclsDia1.add(obclsDia1);
            }
        } catch (Exception e) {
            
        }
        return lstclsDia1;
    }
}
