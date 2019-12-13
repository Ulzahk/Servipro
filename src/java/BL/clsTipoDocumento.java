package BL;

import java.sql.*;
import java.util.*;

public class clsTipoDocumento {
    
    Connection conn = null;
    
    public clsTipoDocumento(){
        
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();
    }
    
    public List<Modelos.clsTipoDocumento> getTipoDocumento(){
        
        List<Modelos.clsTipoDocumento> lstclsTipoDocumento = new ArrayList<Modelos.clsTipoDocumento>();
        
        try {
            PreparedStatement ps = conn.prepareStatement("{call spConsultarTipoDocumento()}");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Modelos.clsTipoDocumento obclsTipoDocumento = new Modelos.clsTipoDocumento();
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
