
package BL.ResponsableGrupo;

import BL.clsConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class clsGrupo {

    Connection conn = null;
     
    public clsGrupo(){
    
        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();
       }
    
     public List<Modelos.ResponsableGrupo.clsGrupo> getGrupo(){
         List<Modelos.ResponsableGrupo.clsGrupo> lstclsGrupo = new ArrayList<Modelos.ResponsableGrupo.clsGrupo>();
         
         try {
             
             PreparedStatement ps = conn.prepareStatement("{call spConsultarGrupoReGru}");
             ResultSet rs = ps.executeQuery();
             
             while(rs.next()){
                 Modelos.ResponsableGrupo.clsGrupo obclsGrupo = new Modelos.ResponsableGrupo.clsGrupo();
                 obclsGrupo.setId_grupo(rs.getInt("Id_grupo"));
                 obclsGrupo.setNombre(rs.getString("nombre_grupo"));
                 
                 lstclsGrupo.add(obclsGrupo);
             
             }
             
         } catch (Exception e) {
         }
         
         return lstclsGrupo;
     
         
     } 
}
