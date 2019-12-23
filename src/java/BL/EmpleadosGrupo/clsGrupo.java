package BL.EmpleadosGrupo;

import BL.clsConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class clsGrupo {
    
    Connection conn = null;
    
    public clsGrupo(){
        
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();
    }
    
    public List<Modelos.EmpleadosGrupo.clsGrupo> getGrupo(){
        List<Modelos.EmpleadosGrupo.clsGrupo> lstclsGrupo = new ArrayList<Modelos.EmpleadosGrupo.clsGrupo>();
        
        try {
            ResultSet rs = null;
            PreparedStatement ps = conn.prepareStatement("{call spConsultarGrupoEmpleadosGrupo}");
            rs = ps.executeQuery();
            
            while(rs.next()){
                Modelos.EmpleadosGrupo.clsGrupo obclsGrupo = new Modelos.EmpleadosGrupo.clsGrupo();
                obclsGrupo.setId_grupo(rs.getInt("Id_grupo"));
                obclsGrupo.setNombre_grupo(rs.getString("nombre_grupo"));
                
                lstclsGrupo.add(obclsGrupo);
            }            
        } catch (Exception e) {
        }
        return lstclsGrupo;
    }
}
