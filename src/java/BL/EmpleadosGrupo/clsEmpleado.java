package BL.EmpleadosGrupo;

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
    
    public List<Modelos.EmpleadosGrupo.clsEmpleado> getEmpleado(){
        List<Modelos.EmpleadosGrupo.clsEmpleado> lstclsEmpleado = new ArrayList<Modelos.EmpleadosGrupo.clsEmpleado>();
        
        try {
            ResultSet rs = null;
            PreparedStatement ps = conn.prepareStatement("{call spConsultarEmpleadoEmpleadosGrupo}");
            rs = ps.executeQuery();
            
            while(rs.next()){
                Modelos.EmpleadosGrupo.clsEmpleado obclsEmpleado = new Modelos.EmpleadosGrupo.clsEmpleado();
                obclsEmpleado.setEmplId(rs.getInt("emplId"));
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
