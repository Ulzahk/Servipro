
package Controles;

import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ConsultasLogin extends Conexion {
    
    public boolean autenticacion(String descripcion_perfil, String id_usuario, String contraseña){
        PreparedStatement pst=null;
        ResultSet rs = null;
        
        try {
            
            String consulta="select * from nm_usuarios join nm_perfil on nm_usuarios.id_perfil=nm_perfil.id_perfil "
                    + " where descripcion_perfil=? and id_usuario=? and contraseña=? ";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, descripcion_perfil);
            pst.setString(2, id_usuario);
            pst.setString(3, contraseña);
            rs = pst.executeQuery();
            
            if(rs.absolute(1)){
                return true;
            }
            
        } catch (Exception e) {
            System.err.println("Error"+e);
        }finally{
            try {
                
                if(getConexion()!=null)getConexion().close();
                if(pst !=null) pst.close();
                if(rs !=null) rs.close();
                
            } catch (Exception e) {
                System.err.println("Error"+e);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ConsultasLogin con=new ConsultasLogin();
        System.out.println(con.autenticacion("","CMARTINEZ", "123456"));
    }
}
