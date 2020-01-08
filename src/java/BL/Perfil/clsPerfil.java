package BL.Perfil;

import BL.clsConexion;
import java.sql.*;
import java.util.*;

public class clsPerfil {

    Connection conn = null;

    public clsPerfil() {

        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();
    }

    public List<Modelos.Perfil.clsPerfil> getPerfil() {
        List<Modelos.Perfil.clsPerfil> lstclsPerfil = new ArrayList<Modelos.Perfil.clsPerfil>();
        try {
            ResultSet rs = null;
            PreparedStatement ps = conn.prepareStatement("{call spConsultarPerfilCompleto}");
            rs = ps.executeQuery();

            while (rs.next()) {
                Modelos.Perfil.clsPerfil obclsPerfil = new Modelos.Perfil.clsPerfil();

                obclsPerfil.setId_perfil(rs.getInt("Id_perfil"));
                obclsPerfil.setDescripcion_perfil(rs.getString("Descripcion_perfil"));
                obclsPerfil.setVista_usuarios(rs.getString("Vista_usuarios").charAt(0));
                obclsPerfil.setVista_perfil(rs.getString("Vista_perfil").charAt(0));
                obclsPerfil.setVista_tiponovedades(rs.getString("Vista_tiponovedades").charAt(0));
                obclsPerfil.setVista_facturacion(rs.getString("Vista_facturacion").charAt(0));
                obclsPerfil.setVista_novedadesempleado(rs.getString("Vista_novedadesempleado").charAt(0));
                obclsPerfil.setVista_centrocostos(rs.getString("Vista_centrocostos").charAt(0));
                obclsPerfil.setVista_empleados(rs.getString("Vista_empleados").charAt(0));
                obclsPerfil.setVista_cargoempleado(rs.getString("Vista_cargoempleado").charAt(0));
                obclsPerfil.setVista_modulos(rs.getString("Vista_modulos").charAt(0));
                obclsPerfil.setVista_modulosperfil(rs.getString("Vista_modulosperfil").charAt(0));
                obclsPerfil.setVista_grupos(rs.getString("Vista_grupos").charAt(0));
                obclsPerfil.setVista_empleadosgrupo(rs.getString("Vista_empleadosgrupo").charAt(0));
                obclsPerfil.setVista_responsablegrupo(rs.getString("Vista_responsablegrupo").charAt(0));
                obclsPerfil.setVista_configuracion(rs.getString("Vista_configuracion").charAt(0));
                obclsPerfil.setVista_estadisticas(rs.getString("Vista_estadisticas").charAt(0));

                lstclsPerfil.add(obclsPerfil);
            }

        } catch (Exception ex) {

        }
        return lstclsPerfil;
    }

    public List<Modelos.Perfil.clsPerfil> getBuscarPerfil(Modelos.clsBuscar obclsBuscar) {
        List<Modelos.Perfil.clsPerfil> lstclsPerfil = new ArrayList<Modelos.Perfil.clsPerfil>();

        try {

            ResultSet rs = null;
            PreparedStatement ps = conn.prepareStatement("{call spBuscarPerfil(?)}");
            ps.setString(1, obclsBuscar.getStBuscar());
            rs = ps.executeQuery();

            while (rs.next()) {
                Modelos.Perfil.clsPerfil obclsPerfil = new Modelos.Perfil.clsPerfil();

                obclsPerfil.setId_perfil(rs.getInt("Id_perfil"));
                obclsPerfil.setDescripcion_perfil(rs.getString("Descripcion_perfil"));
                obclsPerfil.setVista_usuarios(rs.getString("Vista_usuarios").charAt(0));
                obclsPerfil.setVista_perfil(rs.getString("Vista_perfil").charAt(0));
                obclsPerfil.setVista_tiponovedades(rs.getString("Vista_tiponovedades").charAt(0));
                obclsPerfil.setVista_facturacion(rs.getString("Vista_facturacion").charAt(0));
                obclsPerfil.setVista_novedadesempleado(rs.getString("Vista_novedadesempleado").charAt(0));
                obclsPerfil.setVista_centrocostos(rs.getString("Vista_centrocostos").charAt(0));
                obclsPerfil.setVista_empleados(rs.getString("Vista_empleados").charAt(0));
                obclsPerfil.setVista_cargoempleado(rs.getString("Vista_cargoempleado").charAt(0));
                obclsPerfil.setVista_modulos(rs.getString("Vista_modulos").charAt(0));
                obclsPerfil.setVista_modulosperfil(rs.getString("Vista_modulosperfil").charAt(0));
                obclsPerfil.setVista_grupos(rs.getString("Vista_grupos").charAt(0));
                obclsPerfil.setVista_empleadosgrupo(rs.getString("Vista_empleadosgrupo").charAt(0));
                obclsPerfil.setVista_responsablegrupo(rs.getString("Vista_responsablegrupo").charAt(0));
                obclsPerfil.setVista_configuracion(rs.getString("Vista_configuracion").charAt(0));
                obclsPerfil.setVista_estadisticas(rs.getString("Vista_estadisticas").charAt(0));

                lstclsPerfil.add(obclsPerfil);
            }

        } catch (Exception ex) {

        }
        return lstclsPerfil;
    }

    public String createPerfil(Modelos.Perfil.clsPerfil obclsPerfil) {
        try {

            PreparedStatement ps = conn.prepareStatement("{call spInsertarPerfil(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

            ps.setString(1, obclsPerfil.getDescripcion_perfil());
            ps.setString(2, String.valueOf(obclsPerfil.getVista_usuarios()));
            ps.setString(3, String.valueOf(obclsPerfil.getVista_perfil()));
            ps.setString(4, String.valueOf(obclsPerfil.getVista_tiponovedades()));
            ps.setString(5, String.valueOf(obclsPerfil.getVista_facturacion()));
            ps.setString(6, String.valueOf(obclsPerfil.getVista_novedadesempleado()));
            ps.setString(7, String.valueOf(obclsPerfil.getVista_centrocostos()));
            ps.setString(8, String.valueOf(obclsPerfil.getVista_empleados()));
            ps.setString(9, String.valueOf(obclsPerfil.getVista_cargoempleado()));
            ps.setString(10, String.valueOf(obclsPerfil.getVista_modulos()));
            ps.setString(11, String.valueOf(obclsPerfil.getVista_modulosperfil()));
            ps.setString(12, String.valueOf(obclsPerfil.getVista_grupos()));
            ps.setString(13, String.valueOf(obclsPerfil.getVista_empleadosgrupo()));
            ps.setString(14, String.valueOf(obclsPerfil.getVista_responsablegrupo()));
            ps.setString(15, String.valueOf(obclsPerfil.getVista_configuracion()));
            ps.setString(16, String.valueOf(obclsPerfil.getVista_estadisticas()));

            ps.execute();

            return "Se realizó el proceso con éxito";

        } catch (Exception ex) {

            return "Hubo un error, revisa la información ingresada";

        }
    }

    public String updatePerfil(Modelos.Perfil.clsPerfil obclsPerfil) {

        try {
            PreparedStatement ps = conn.prepareStatement("{call spEditarPerfil(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

            ps.setInt(1, obclsPerfil.getId_perfil());
            ps.setString(2, obclsPerfil.getDescripcion_perfil());
            ps.setString(3, String.valueOf(obclsPerfil.getVista_usuarios()));
            ps.setString(4, String.valueOf(obclsPerfil.getVista_perfil()));
            ps.setString(5, String.valueOf(obclsPerfil.getVista_tiponovedades()));
            ps.setString(6, String.valueOf(obclsPerfil.getVista_facturacion()));
            ps.setString(7, String.valueOf(obclsPerfil.getVista_novedadesempleado()));
            ps.setString(8, String.valueOf(obclsPerfil.getVista_centrocostos()));
            ps.setString(9, String.valueOf(obclsPerfil.getVista_empleados()));
            ps.setString(10, String.valueOf(obclsPerfil.getVista_cargoempleado()));
            ps.setString(11, String.valueOf(obclsPerfil.getVista_modulos()));
            ps.setString(12, String.valueOf(obclsPerfil.getVista_modulosperfil()));
            ps.setString(13, String.valueOf(obclsPerfil.getVista_grupos()));
            ps.setString(14, String.valueOf(obclsPerfil.getVista_empleadosgrupo()));
            ps.setString(15, String.valueOf(obclsPerfil.getVista_responsablegrupo()));
            ps.setString(16, String.valueOf(obclsPerfil.getVista_configuracion()));
            ps.setString(17, String.valueOf(obclsPerfil.getVista_estadisticas()));

            ps.execute();

            return "Se realizó el proceso con éxito";

        } catch (Exception e) {
            return "Hubo un error, revisa la información ingresada";
        }
    }

    public String deletePerfil(Modelos.Perfil.clsPerfil obclsPerfil) {

        try {
            PreparedStatement ps = conn.prepareStatement("{call spEliminarPerfil(?)}");
            ps.setInt(1, obclsPerfil.getId_perfil());

            ps.execute();

            return "Se realizó el proceso con éxito";
        } catch (Exception ex) {

            return ex.getMessage();
        }
    }
}
