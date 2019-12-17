
package BL.NovedadesEmpleado;

import BL.clsConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class clsTipoNovedad {
    
    Connection conn =null;
    
    public clsTipoNovedad(){
    
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();
        
    }
    
    public List<Modelos.NovedadesEmpleado.clsTipoNovedad> getTipoNovedad(){
        List<Modelos.NovedadesEmpleado.clsTipoNovedad> lstclsTipoNovedad = new ArrayList<Modelos.NovedadesEmpleado.clsTipoNovedad>();
        
        try {
            ResultSet rs = null;
            PreparedStatement ps = conn.prepareStatement("{call spConsultarTipoNovedadNoveEmpl}");
            rs = ps.executeQuery();
            
            while(rs.next()){
                Modelos.NovedadesEmpleado.clsTipoNovedad obclsTipoNovedad = new Modelos.NovedadesEmpleado.clsTipoNovedad();
                obclsTipoNovedad.setId_novedad(rs.getInt("Id_novedad"));
                obclsTipoNovedad.setDescripcion_novedad(rs.getString("Descripcion"));
                obclsTipoNovedad.setAlias_novedad(rs.getString("Alias"));
                
                lstclsTipoNovedad.add(obclsTipoNovedad);
            }
            
        } catch (Exception e) {
        }
        return lstclsTipoNovedad;
    }
    
}
