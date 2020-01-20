
package BL.Configuracion;

import BL.clsConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class clsConfiguracion {
    
    Connection conn = null;
    
    public clsConfiguracion(){
        
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();
    }
    
    public List<Modelos.Configuracion.clsConfiguracion> getConfiguracion(){
        List<Modelos.Configuracion.clsConfiguracion> lstclsConfiguracion = new ArrayList<Modelos.Configuracion.clsConfiguracion>();
        try {
            ResultSet rs = null;
            PreparedStatement ps = conn.prepareStatement("{call spConsultarConfiguracion}");
            rs = ps.executeQuery();
            
            while(rs.next()){
                Modelos.Configuracion.clsConfiguracion obclsConfiguracion = new Modelos.Configuracion.clsConfiguracion();
                obclsConfiguracion.setId_configuracion(rs.getInt("Id_configuracion"));
                obclsConfiguracion.setNombre_configuracion(rs.getString("Desconfiguracion"));
                obclsConfiguracion.setDescripcion_configuracion(rs.getString("Desconfiguracion_d"));
                obclsConfiguracion.setNombre_variable(rs.getString("Nombre_variable"));
                obclsConfiguracion.setValor(rs.getInt("Valor"));
                
                Modelos.Configuracion.clsModulo obclsModulo = new Modelos.Configuracion.clsModulo();
                obclsModulo.setId_modulo(rs.getInt("Id_modulo"));
                obclsModulo.setNombre_modulo(rs.getString("Nombre_modulo"));
                obclsConfiguracion.setObclsModulo(obclsModulo);
                
                lstclsConfiguracion.add(obclsConfiguracion);
            }
        } catch (Exception ex) {
        }
        return lstclsConfiguracion;
    }
    
    public String createConfiguracion (Modelos.Configuracion.clsConfiguracion obclsConfiguracion){
        try {
            PreparedStatement ps = conn.prepareStatement("{call spInsertarConfiguracion (?,?,?,?,?)}");
            
            ps.setString(1, obclsConfiguracion.getNombre_configuracion());
            ps.setString(2, obclsConfiguracion.getDescripcion_configuracion());
            ps.setString(3, obclsConfiguracion.getNombre_variable());
            ps.setInt(4, obclsConfiguracion.getValor());
            ps.setInt(5, obclsConfiguracion.getObclsModulo().getId_modulo());
            ps.execute();
            
            return "Se realizó el proceso con éxito";
            
        } catch (Exception ex) {
            return "Hubo un error, revisa la información ingresada";
        }
   
    }
    
    public String updateConfiguracion (Modelos.Configuracion.clsConfiguracion obclsConfiguracion){
        try {
            PreparedStatement ps = conn.prepareStatement("{call spEditarConfiguracion(?,?,?)}");
            
            ps.setInt(1, obclsConfiguracion.getId_configuracion());
            ps.setInt(2, obclsConfiguracion.getValor());
            ps.setInt(3, obclsConfiguracion.getObclsModulo().getId_modulo());
            
            ps.execute();
            
            return "Se realizó el proceso con éxito";
        } catch (Exception ex) {
            
            return "Hubo un error, revisa la información ingresada";
        }
    }
    
    public String deleteConfiguracion (Modelos.Configuracion.clsConfiguracion obclsConfiguracion){
        try {
            PreparedStatement ps = conn.prepareStatement("{call spEliminarConfiguracion (?)}");
            ps.setInt(1, obclsConfiguracion.getId_configuracion());
            ps.execute();
            
            return "Se realizó el proceso con éxito";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
}
