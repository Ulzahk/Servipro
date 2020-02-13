package BL.PraEmpleados;

import BL.clsConexion;
import java.sql.*;

public class clsPraEmpleados {
    
    Connection conn = null;
    
    public clsPraEmpleados(){
        
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();
    }
    
    public String createPraEmpleado(Modelos.PraEmpleados.clsPraEmpleados obclsPraEmpleados){
        try {
            PreparedStatement ps = conn.prepareStatement("{ call spInsertarPraEmpleado (?,?,?)}");
            ps.setInt(1,obclsPraEmpleados.getId_praempleado());
            ps.setString(2, obclsPraEmpleados.getNombre());
            ps.setString (3, obclsPraEmpleados.getContraseña());
            
            ps.execute();
            return "Se realizó el proceso con éxito";
        } catch (Exception e) {
            return "Hubo un error, revisa la información ingresada"; 
        }
    }
}
