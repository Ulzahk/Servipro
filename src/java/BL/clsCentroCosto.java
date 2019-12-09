package BL;

import java.sql.*;
import java.util.*;

public class clsCentroCosto {
    
    Connection conn = null;
    
    public clsCentroCosto(){
        
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();
    }
    
    public List<Modelos.clsCentroCosto> getCentroCosto(){
        
        List<Modelos.clsCentroCosto> lstclsCentroCosto = new ArrayList<Modelos.clsCentroCosto>();
        
        try {
            
            PreparedStatement ps = conn.prepareStatement("{call spConsultarCentroCosto()}");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Modelos.clsCentroCosto obclsCentroCosto = new Modelos.clsCentroCosto();
                obclsCentroCosto.setInId(rs.getInt("cecoId"));
                obclsCentroCosto.setStDescripcion(rs.getString("cecoDescripcion"));
                
                lstclsCentroCosto.add(obclsCentroCosto);
            }
            
        } 
        catch (Exception e) 
        {
            
        }
        return lstclsCentroCosto;
    }
}
