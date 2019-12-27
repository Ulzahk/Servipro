package BL.ResponsableGrupo;

import BL.clsConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class clsResponsableGrupo {

    Connection conn = null;

    public clsResponsableGrupo() {

        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();

    }

    public List<Modelos.ResponsableGrupo.clsResponsableGrupo> getResponsableGrupo() {

        List<Modelos.ResponsableGrupo.clsResponsableGrupo>lstclsResponsableGrupo= new ArrayList<Modelos.ResponsableGrupo.clsResponsableGrupo>();

        try {
            ResultSet rs = null;
            PreparedStatement ps = conn.prepareStatement("{call spConsultarReGru}");
            rs = ps.executeQuery();

            while (rs.next()) {
                Modelos.ResponsableGrupo.clsResponsableGrupo obclsResponsableGrupo = new Modelos.ResponsableGrupo.clsResponsableGrupo();
                obclsResponsableGrupo.setId_responsable(rs.getInt("Id_responsable"));

                Modelos.ResponsableGrupo.clsGrupo obclsGrupo = new Modelos.ResponsableGrupo.clsGrupo();
                obclsGrupo.setId_grupo(rs.getInt("Id_grupo"));
                obclsGrupo.setNombre(rs.getString("nombre_grupo"));
                obclsResponsableGrupo.setObclsGrupo(obclsGrupo);

                Modelos.ResponsableGrupo.clsUsuario obclsUsuario = new Modelos.ResponsableGrupo.clsUsuario();
                obclsUsuario.setEmplPrimerNombre(rs.getString("emplPrimerNombre"));
                obclsUsuario.setEmplSegundoNombre(rs.getString("emplSegundoNombre"));
                obclsUsuario.setEmplPrimerApellido(rs.getString("emplPrimerApellido"));
                obclsUsuario.setEmplSegundoApellido(rs.getString("emplSegundoApellido"));
                obclsUsuario.setNro_usuario(rs.getInt("Nro_usuario"));
                obclsUsuario.setId_usuario(rs.getString("Id_usuario"));
                obclsResponsableGrupo.setObclsUsuario(obclsUsuario);

                lstclsResponsableGrupo.add(obclsResponsableGrupo);

            }

        } catch (Exception e) {
        }

        return lstclsResponsableGrupo;
    }

    public List<Modelos.ResponsableGrupo.clsResponsableGrupo> getBuscarResponsableGrupo(Modelos.clsBuscar obclsBuscar) {

        List<Modelos.ResponsableGrupo.clsResponsableGrupo> lstclsResponsableGrupo = new ArrayList<Modelos.ResponsableGrupo.clsResponsableGrupo>();

        try {
            PreparedStatement ps = conn.prepareStatement("{call spBuscarResponsableGrupo(?)}");
            ps.setString(1, obclsBuscar.getStBuscar());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Modelos.ResponsableGrupo.clsResponsableGrupo obclsResponsableGrupo = new Modelos.ResponsableGrupo.clsResponsableGrupo();
                obclsResponsableGrupo.setId_responsable(rs.getInt("Id_responsable"));

                Modelos.ResponsableGrupo.clsGrupo obclsGrupo = new Modelos.ResponsableGrupo.clsGrupo();
                obclsGrupo.setId_grupo(rs.getInt("Id_grupo"));
                obclsGrupo.setNombre(rs.getString("nombre_grupo"));
                obclsResponsableGrupo.setObclsGrupo(obclsGrupo);

                Modelos.ResponsableGrupo.clsUsuario obclsUsuario = new Modelos.ResponsableGrupo.clsUsuario();
                obclsUsuario.setEmplPrimerNombre(rs.getString("emplPrimerNombre"));
                obclsUsuario.setEmplSegundoNombre(rs.getString("emplSegundoNombre"));
                obclsUsuario.setEmplPrimerApellido(rs.getString("emplPrimerApellido"));
                obclsUsuario.setEmplSegundoApellido(rs.getString("emplSegundoApellido"));
                obclsUsuario.setNro_usuario(rs.getInt("Nro_usuario"));
                obclsUsuario.setId_usuario(rs.getString("Id_usuario"));
                obclsResponsableGrupo.setObclsUsuario(obclsUsuario);

                lstclsResponsableGrupo.add(obclsResponsableGrupo);

            }

        } catch (Exception e) {
        }

        return lstclsResponsableGrupo;

    }
    
    public String createResponsableGrupo(Modelos.ResponsableGrupo.clsResponsableGrupo obclsResponsableGrupo){
        try {
            PreparedStatement ps=conn.prepareStatement("{call spInsertarResponsableGrupo(?,?)}");
            ps.setInt(1, obclsResponsableGrupo.getObclsGrupo().getId_grupo());
            ps.setInt(2, obclsResponsableGrupo.getObclsUsuario().getNro_usuario());
            ps.execute();
            return "Se realizó el proceso con éxito";
            
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
    
    public String updateResponsableGrupo(Modelos.ResponsableGrupo.clsResponsableGrupo obclsResponsableGrupo){
        try {
            PreparedStatement ps=conn.prepareStatement("{call spEditarResponsableGrupo(?,?,?)}");
            ps.setInt(1, obclsResponsableGrupo.getId_responsable());
            ps.setInt(2, obclsResponsableGrupo.getObclsGrupo().getId_grupo());
            ps.setInt(3, obclsResponsableGrupo.getObclsUsuario().getNro_usuario());
            ps.execute();
            return "Se realizó el proceso con éxito";
            
        } catch (Exception ex) {
             return ex.getMessage();
        }
    }
    
    public String deleteResponsableGrupo(Modelos.ResponsableGrupo.clsResponsableGrupo obclsResponsableGrupo){
        try {
            PreparedStatement ps=conn.prepareStatement("{call spEliminarResponsableGrupo(?)}");
            ps.setInt(1, obclsResponsableGrupo.getId_responsable());
            ps.execute();
            return "Se realizó el proceso con éxito";
                    
                    
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

}
