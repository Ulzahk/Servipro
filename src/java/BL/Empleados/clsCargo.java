package BL.Empleados;

import BL.clsConexion;
import java.sql.*;
import java.util.*;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

public class clsCargo {
    
    Connection conn = null;
    
    public clsCargo(){
        
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();
        
    }
    
    public List<Modelos.Empleados.clsCargo> getCargo(){
        
        List<Modelos.Empleados.clsCargo> lstclsCargo = new ArrayList<Modelos.Empleados.clsCargo>();
        
        try {
            
            PreparedStatement ps = conn.prepareStatement("{call spConsultarCargo()}");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Modelos.Empleados.clsCargo obclsCargo = new Modelos.Empleados.clsCargo();
                obclsCargo.setInId(rs.getInt("Id_cargo"));
                obclsCargo.setStDescripcion(rs.getString("Descripcion_cargo"));
                
                lstclsCargo.add(obclsCargo);
            }
        } 
        catch (Exception e) {
        }
        return lstclsCargo;
        
    }
   
}
