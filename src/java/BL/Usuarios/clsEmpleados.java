/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL.Usuarios;

import BL.clsConexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PRACTICANTE
 */
public class clsEmpleados {
    Connection conn = null;
    
    public clsEmpleados(){
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();
    }
    
    public List<Modelos.Usuarios.clsEmpleados> getEmpleados (){
        List<Modelos.Usuarios.clsEmpleados> lstclsEmpleados = new ArrayList<Modelos.Usuarios.clsEmpleados>();
        
        try {
            ResultSet rs = null;
            PreparedStatement ps = conn.prepareStatement("{call spConsultarEmpleadoEsta}");
            rs = ps.executeQuery();
            
            while(rs.next()){
                Modelos.Usuarios.clsEmpleados obclsEmpleados = new Modelos.Usuarios.clsEmpleados();
                obclsEmpleados.setId_empleado(rs.getInt("emplId"));
                obclsEmpleados.setStPrimerNombre(rs.getString("emplPrimerNombre"));
                obclsEmpleados.setStSegundoNombre(rs.getString("emplSegundoNombre"));
                obclsEmpleados.setStPrimerApellido(rs.getString("emplPrimerApellido"));
                obclsEmpleados.setStSegundoApellido(rs.getString("emplSegundoApellido"));
                lstclsEmpleados.add(obclsEmpleados);
            }
        } catch (Exception e) {
            
        }
        return lstclsEmpleados;
    }
}
