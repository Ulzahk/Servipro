package BL.Empleados;

import BL.clsConexion;
import java.sql.*;
import java.util.*;

public class clsTipoDocumento {
    
    Connection conn = null;
    
    public clsTipoDocumento(){
        
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();
    }
    
    public List<Modelos.Empleados.clsTipoDocumento> getTipoDocumento(){
        
        List<Modelos.Empleados.clsTipoDocumento> lstclsTipoDocumento = new ArrayList<Modelos.Empleados.clsTipoDocumento>();
        
        try {
            PreparedStatement ps = conn.prepareStatement("{call spConsultarTipoDocumento()}");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Modelos.Empleados.clsTipoDocumento obclsTipoDocumento = new Modelos.Empleados.clsTipoDocumento();
                obclsTipoDocumento.setInId(rs.getInt("tidoId"));
                obclsTipoDocumento.setStDescripcion(rs.getString("tidoDescripcion"));
                
                lstclsTipoDocumento.add(obclsTipoDocumento);
            }
        } 
        catch (Exception e) 
        {
            
        }
        return lstclsTipoDocumento;
    }
}
