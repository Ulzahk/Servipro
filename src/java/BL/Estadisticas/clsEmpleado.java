package BL.Estadisticas;

import BL.clsConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class clsEmpleado {
    
    Connection conn = null;
    
    public clsEmpleado(){
        
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();        
    }
    public List<Modelos.Estadisticas.clsEmpleado> getEmpleado(){
        List<Modelos.Estadisticas.clsEmpleado> lstclsEmpleado = new ArrayList<Modelos.Estadisticas.clsEmpleado>();
        try {
            ResultSet rs = null;
            PreparedStatement ps = conn.prepareStatement("{call spConsultarEmpleadoEsta}");
            rs = ps.executeQuery();
            
            while(rs.next()){
                Modelos.Estadisticas.clsEmpleado obclsEmpleado = new Modelos.Estadisticas.clsEmpleado();
                obclsEmpleado.setId_empleado(rs.getInt("emplId"));
                obclsEmpleado.setNombreEmp(rs.getString("emplNombre"));
                
                lstclsEmpleado.add(obclsEmpleado);
            }
        } catch (Exception e) {
            
        }
        return lstclsEmpleado;
    }
}
