
package BL.Configuracion;

import BL.clsConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class clsModulos {
    
    Connection conn = null;
    
    public clsModulos (){
        
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();
    }
    
    public List<Modelos.Configuracion.clsModulo> getModulo(){
        List<Modelos.Configuracion.clsModulo> lstclsModulo = new ArrayList<Modelos.Configuracion.clsModulo>();
        try {
            ResultSet rs= null;
            PreparedStatement ps = conn.prepareStatement("{call spConsultarModulos}");
            rs = ps.executeQuery();
            
            while(rs.next()){
                Modelos.Configuracion.clsModulo obclsModulo = new Modelos.Configuracion.clsModulo();
                obclsModulo.setId_modulo(rs.getInt("Id_modulo"));
                obclsModulo.setNombre_modulo(rs.getString("Nombre_modulo"));
                
                lstclsModulo.add(obclsModulo);
            }
        } catch (Exception ex) {
        }
        return lstclsModulo;
    }
    
}