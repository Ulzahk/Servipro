/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL.ModelosPerfil;

import BL.clsConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PRACTICANTE
 */
public class clsModulosPerfil {
    
    Connection conn = null;
    
    public clsModulosPerfil(){
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();
    }
    
    public String createModuloPerfil (Modelos.ModulosPerfil.clsModulosPerfil obclsModulosPerfil){
        try 
        {
            PreparedStatement ps = conn.prepareStatement("{call spInsertarModulosPerfil (?,?)}");
            ps.setInt(1, obclsModulosPerfil.getObclsModulo().getId_modulo());            
            ps.setInt(2, obclsModulosPerfil.getObclsPerfil().getId_perfil());
            ps.execute();
            return "Se realizó el proceso con éxito";
        } 
        catch (Exception ex) {
            return "Hubo un error, revisa la información ingresada";        }
    }
    
    public List<Modelos.ModulosPerfil.clsModulosPerfil> getModulosPerfil(){
        List<Modelos.ModulosPerfil.clsModulosPerfil> lstclsModulosPerfil = new ArrayList<Modelos.ModulosPerfil.clsModulosPerfil>();
        
        try {
            ResultSet rs = null;
            PreparedStatement ps = conn.prepareStatement("{call spConsultarModulosPerfil}");
            rs = ps.executeQuery();
            
            while(rs.next()){
                Modelos.ModulosPerfil.clsModulosPerfil obclsModulosPerfil = new Modelos.ModulosPerfil.clsModulosPerfil();
                obclsModulosPerfil.setId_modulos_perfil(rs.getInt("Id_modulo_perfil"));
                
                Modelos.ModulosPerfil.clsModulo obclsModulo = new Modelos.ModulosPerfil.clsModulo();
                obclsModulo.setId_modulo(rs.getInt("Id_modulo"));
                obclsModulo.setStNombre_modulo(rs.getString("Nombre_modulo"));
                obclsModulosPerfil.setObclsModulo(obclsModulo);
                
                Modelos.ModulosPerfil.clsPerfil obclsPerfil = new Modelos.ModulosPerfil.clsPerfil();
                obclsPerfil.setId_perfil(rs.getInt("Id_perfil"));
                obclsPerfil.setStDescripcion_perfil(rs.getString("Descripcion_perfil"));
                obclsModulosPerfil.setObclsPerfil(obclsPerfil);
                
                lstclsModulosPerfil.add(obclsModulosPerfil);
            }
        } catch (Exception ex) {
            ex.getMessage();
        }
        return lstclsModulosPerfil;
    }
    
    public String UpdateModulosPerfil (Modelos.ModulosPerfil.clsModulosPerfil obclsModulosPerfil){
        
        try {
            PreparedStatement ps = conn.prepareStatement("{call spEditarModuloPerfil (?,?,?)}");
            
            ps.setInt(1, obclsModulosPerfil.getId_modulos_perfil());
            ps.setInt(2, obclsModulosPerfil.getObclsModulo().getId_modulo());
            ps.setInt(3, obclsModulosPerfil.getObclsPerfil().getId_perfil());
            
            ps.execute();
            
            return "Se realizó el proceso con éxito";
            
        } catch (Exception ex) {
            return "Hubo un error, revisa la información ingresada";        }
    }
    
    public String deleteModulosPerfil (Modelos.ModulosPerfil.clsModulosPerfil obclsModulosperfil){
        
        try {
            PreparedStatement ps = conn.prepareStatement("{call spEliminarModuloPerfil (?)}");
            ps.setInt(1, obclsModulosperfil.getId_modulos_perfil());
            ps.execute();
            
            return "Se realizó el proceso con éxito";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
    
    public List<Modelos.ModulosPerfil.clsModulosPerfil> getBuscarModulosPerfil(Modelos.Empleados.clsBuscar obclsBuscarMod){
       
        List<Modelos.ModulosPerfil.clsModulosPerfil> lstclsModulosPerfil = new ArrayList<Modelos.ModulosPerfil.clsModulosPerfil>();
        
        try{
            ResultSet rs = null;
            PreparedStatement ps = conn.prepareStatement("{call spBuscarModuloPerfil (?)}");
            ps.setString(1, obclsBuscarMod.getStBuscar());
            rs = ps.executeQuery();
            
            while(rs.next()){
                Modelos.ModulosPerfil.clsModulosPerfil obclsModulosPerfil = new Modelos.ModulosPerfil.clsModulosPerfil();
                obclsModulosPerfil.setId_modulos_perfil(rs.getInt("Id_modulo_perfil"));
                
                Modelos.ModulosPerfil.clsModulo obclsModulo = new Modelos.ModulosPerfil.clsModulo();
                obclsModulo.setId_modulo(rs.getInt("Id_modulo"));
                obclsModulo.setStNombre_modulo(rs.getString("Nombre_modulo"));
                obclsModulosPerfil.setObclsModulo(obclsModulo);
                
                Modelos.ModulosPerfil.clsPerfil obclsPerfil = new Modelos.ModulosPerfil.clsPerfil();
                obclsPerfil.setId_perfil(rs.getInt("Id_perfil"));
                obclsPerfil.setStDescripcion_perfil(rs.getString("Descripcion_perfil"));
                obclsModulosPerfil.setObclsPerfil(obclsPerfil);
                
                lstclsModulosPerfil.add(obclsModulosPerfil);
                
            }
        }
        catch(Exception ex){
            
        }
        return lstclsModulosPerfil;
    }
}
