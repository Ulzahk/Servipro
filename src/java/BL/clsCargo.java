package BL;

import java.sql.*;
import java.util.*;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

public class clsCargo {
    
    Connection conn = null;
    
    public clsCargo(){
        
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();
        
    }
    
    public List<Modelos.clsCargo> getCargo(){
        
        List<Modelos.clsCargo> lstclsCargo = new ArrayList<Modelos.clsCargo>();
        
        try {
            
            PreparedStatement ps = conn.prepareStatement("{call spConsultarCargo()}");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Modelos.clsCargo obclsCargo = new Modelos.clsCargo();
                obclsCargo.setInId(rs.getInt("cargId"));
                obclsCargo.setStDescripcion(rs.getString("cargDescripcion"));
                
                lstclsCargo.add(obclsCargo);
            }
        } 
        catch (Exception e) {
        }
        return lstclsCargo;
        
    }
    
    
    
}
