package BL.Empleados;

import BL.clsConexion;
import java.sql.*;
import java.util.*;

public class clsCentroCosto {
    
    Connection conn = null;
    
    public clsCentroCosto(){
        
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();
    }
    
    public List<Modelos.Empleados.clsCentroCosto> getCentroCosto(){
        
        List<Modelos.Empleados.clsCentroCosto> lstclsCentroCosto = new ArrayList<Modelos.Empleados.clsCentroCosto>();
        
        try {
            
            PreparedStatement ps = conn.prepareStatement("{call spConsultarCentroCosto()}");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Modelos.Empleados.clsCentroCosto obclsCentroCosto = new Modelos.Empleados.clsCentroCosto();
                obclsCentroCosto.setInId(rs.getInt("Id_ccostos"));
                obclsCentroCosto.setStDescripcion(rs.getString("Nombre_ccostos"));
                
                lstclsCentroCosto.add(obclsCentroCosto);
            }

        } 
        catch (Exception e) 
        {
            
        }
        return lstclsCentroCosto;
    }
}
