
package BL.NovedadesEmpleado;

import BL.clsConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class clsEmpleado {
    
    Connection conn=null;
    
    public clsEmpleado(){
        
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();
        
    }
    
    public List<Modelos.NovedadesEmpleado.clsEmpleado> getEmpleado(){
        List<Modelos.NovedadesEmpleado.clsEmpleado> lstclsEmpleado = new ArrayList<Modelos.NovedadesEmpleado.clsEmpleado>();
        
        try {
            ResultSet rs = null;
            PreparedStatement ps = conn.prepareStatement("{call spConsultarEmpleadoEsta}");
            rs= ps.executeQuery();
            
            while(rs.next()){
                Modelos.NovedadesEmpleado.clsEmpleado obclsEmpleado = new Modelos.NovedadesEmpleado.clsEmpleado();
                obclsEmpleado.setId_empleado(rs.getInt("emplId"));
                obclsEmpleado.setEmplPrimerNombre(rs.getString("emplPrimerNombre"));
                obclsEmpleado.setEmplSegundoNombre(rs.getString("emplSegundoNombre"));
                obclsEmpleado.setEmplPrimerApellido(rs.getString("emplPrimerApellido"));
                obclsEmpleado.setEmplSegundoApellido(rs.getString("emplSegundoApellido"));
                lstclsEmpleado.add(obclsEmpleado);
            }
            
        } catch (Exception e) {
        }
        return lstclsEmpleado;
    }
}
