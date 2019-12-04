
package Controles;

import static Controles.Conexion.conectar;
import java.sql.*;
import Utils.Encriptar;



public class AccesoDatos extends Conexion {
    Connection conn=conectar();
    public int buscar(String Descripcion_perfil,String Id_usuario,String Contraseña){
        int r=0;
        Encriptar enc = new Encriptar();
        try {
            PreparedStatement ps=null;
            ResultSet rs=null;
            ps=conn.prepareStatement("Select * from nm_usuarios join nm_perfil "
                    + " on nm_usuarios.id_perfil=nm_perfil.id_perfil "
                    + " where Descripcion_perfil=? and Id_usuario=? and Contraseña=?");
            ps.setString(1, Descripcion_perfil);
            ps.setString(2, Id_usuario);           
            ps.setString(3, Contraseña);
            rs=ps.executeQuery();

            if(rs.next()==true){
                r=1;
                conn.close();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return r; 
    }
    
    public static void main(String[] args) {
        AccesoDatos a=new AccesoDatos();
        System.out.println(a.buscar("COORDINADOR","CMARTINEZ","123456"));
    }
}