
package BL.EmpleadosGrupo;

import BL.clsConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class clsEmpleadosGrupo {
    
    Connection conn = null;
    
    public clsEmpleadosGrupo(){
        
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();
    }
    
    public List<Modelos.EmpleadosGrupo.clsEmpleadosGrupo> getEmpleadosGrupo(){
        List<Modelos.EmpleadosGrupo.clsEmpleadosGrupo> lstclsEmpleadoGrupo = new ArrayList<Modelos.EmpleadosGrupo.clsEmpleadosGrupo>();
        
        try {
            ResultSet rs = null;
            PreparedStatement ps = conn.prepareStatement("{call spConsultarEmpleadosGrupo}");
            rs=ps.executeQuery();
            
            while(rs.next()){
                Modelos.EmpleadosGrupo.clsEmpleadosGrupo obclsEmpleadosGrupo = new Modelos.EmpleadosGrupo.clsEmpleadosGrupo();
                obclsEmpleadosGrupo.setId_empleados_grupo(rs.getInt("Id_empleados_grupo"));
                
                Modelos.EmpleadosGrupo.clsGrupo obclsGrupo = new Modelos.EmpleadosGrupo.clsGrupo();
                obclsGrupo.setId_grupo(rs.getInt("Id_grupo"));
                obclsGrupo.setNombre_grupo(rs.getString("nombre_grupo"));
                obclsEmpleadosGrupo.setObclsGrupo(obclsGrupo);
                
                Modelos.EmpleadosGrupo.clsEmpleado obclsEmpleado = new Modelos.EmpleadosGrupo.clsEmpleado();
                obclsEmpleado.setEmplId(rs.getInt("emplId"));
                obclsEmpleado.setEmplPrimerNombre(rs.getString("emplPrimerNombre"));
                obclsEmpleado.setEmplSegundoNombre(rs.getString("emplSegundoNombre"));
                obclsEmpleado.setEmplPrimerApellido(rs.getString("emplPrimerApellido"));
                obclsEmpleado.setEmplSegundoApellido(rs.getString("emplSegundoApellido"));
                obclsEmpleadosGrupo.setObclsEmpleado(obclsEmpleado);
                
                lstclsEmpleadoGrupo.add(obclsEmpleadosGrupo);
            }
        } catch (Exception e) {
            
        }
        return lstclsEmpleadoGrupo;
    }
    
    public String createEmpleadosGrupo(Modelos.EmpleadosGrupo.clsEmpleadosGrupo obclsEmpleadosGrupo){
        try {
            PreparedStatement ps = conn.prepareStatement("{call spInsertarEmpleadosGrupo(?,?)}");
            ps.setInt(1, obclsEmpleadosGrupo.getObclsGrupo().getId_grupo());
            ps.setInt(2, obclsEmpleadosGrupo.getObclsEmpleado().getEmplId());
            
            ps.execute();
            
            return "Se realizó el proceso con éxito";
        } catch (Exception ex) {
            return "Hubo un error, revisa la información ingresada";
        }
    }
    
    public List<Modelos.EmpleadosGrupo.clsEmpleadosGrupo> getBuscarEmpleadosGrupo(Modelos.clsBuscar obclsBuscar){
        List<Modelos.EmpleadosGrupo.clsEmpleadosGrupo>lstclsEmpleadosGrupo = new ArrayList<Modelos.EmpleadosGrupo.clsEmpleadosGrupo>();
        
        try {
            ResultSet rs = null;
            PreparedStatement ps = conn.prepareStatement("{call spBuscarEmpleadosGrupo(?)}");
            ps.setString(1, obclsBuscar.getStBuscar());
            
            rs= ps.executeQuery();
            
            while(rs.next()){
                Modelos.EmpleadosGrupo.clsEmpleadosGrupo obclsEmpleadosGrupo = new Modelos.EmpleadosGrupo.clsEmpleadosGrupo();
                obclsEmpleadosGrupo.setId_empleados_grupo(rs.getInt("Id_empleados_grupo"));
                
                Modelos.EmpleadosGrupo.clsGrupo obclsGrupo = new Modelos.EmpleadosGrupo.clsGrupo();
                obclsGrupo.setId_grupo(rs.getInt("Id_grupo"));
                obclsGrupo.setNombre_grupo(rs.getString("nombre_grupo"));
                obclsEmpleadosGrupo.setObclsGrupo(obclsGrupo);
                
                Modelos.EmpleadosGrupo.clsEmpleado obclsEmpleado = new Modelos.EmpleadosGrupo.clsEmpleado();
                obclsEmpleado.setEmplId(rs.getInt("emplId"));
                obclsEmpleado.setEmplPrimerNombre(rs.getString("emplPrimerNombre"));
                obclsEmpleado.setEmplSegundoNombre(rs.getString("emplSegundoNombre"));
                obclsEmpleado.setEmplPrimerApellido(rs.getString("emplPrimerApellido"));
                obclsEmpleado.setEmplSegundoApellido(rs.getString("emplSegundoApellido"));
                obclsEmpleadosGrupo.setObclsEmpleado(obclsEmpleado);
                
                lstclsEmpleadosGrupo.add(obclsEmpleadosGrupo);
            }
        } catch (Exception e) {
        }
        return lstclsEmpleadosGrupo;
    } 
    
    public String updateEmpleadosGrupo(Modelos.EmpleadosGrupo.clsEmpleadosGrupo obclsEmpleadosGrupo){
        
        try {
            PreparedStatement ps = conn.prepareStatement("{call spEditarEmpleadosGrupo(?,?,?)}");
            ps.setInt(1, obclsEmpleadosGrupo.getId_empleados_grupo());
            ps.setInt(2, obclsEmpleadosGrupo.getObclsGrupo().getId_grupo());
            ps.setInt(3, obclsEmpleadosGrupo.getObclsEmpleado().getEmplId());
            
            ps.execute();
            
            return "Se realizó el proceso con éxito";
            
        } catch (Exception ex) {
            return "Hubo un error, revisa la información ingresada";
        }
    }
    
    public String deleteEmpleadosGrupo(Modelos.EmpleadosGrupo.clsEmpleadosGrupo obclsEmpleadosGrupo){
        
        try {
            PreparedStatement ps = conn.prepareStatement("{call spEliminarEmpleadosGrupo(?)}");
            ps.setInt(1, obclsEmpleadosGrupo.getId_empleados_grupo());
            ps.execute();
            return "Se realizó el proceso con éxito";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
}
