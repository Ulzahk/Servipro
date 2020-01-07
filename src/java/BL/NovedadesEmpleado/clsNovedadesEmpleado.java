package BL.NovedadesEmpleado;

import BL.clsConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class clsNovedadesEmpleado {

    Connection conn = null;

    public clsNovedadesEmpleado() {

        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();

    }

    public List<Modelos.NovedadesEmpleado.clsNovedadesEmpleado> getNovedadesEmpleado() {
        List<Modelos.NovedadesEmpleado.clsNovedadesEmpleado> lstclsNovedadesEmpleado = new ArrayList<Modelos.NovedadesEmpleado.clsNovedadesEmpleado>();

        try {
            ResultSet rs = null;
            PreparedStatement ps = conn.prepareStatement("{call spConsultarNovedadesEmpleado}");
            rs = ps.executeQuery();

            while (rs.next()) {
                Modelos.NovedadesEmpleado.clsNovedadesEmpleado obclsNovedadesEmpleado = new Modelos.NovedadesEmpleado.clsNovedadesEmpleado();
                obclsNovedadesEmpleado.setId_novedad_empleado(rs.getInt("Id_novedad_empleado"));

                Modelos.NovedadesEmpleado.clsEmpleado obclsEmpleado = new Modelos.NovedadesEmpleado.clsEmpleado();
                obclsEmpleado.setId_empleado(rs.getInt("Id_empleado"));
                obclsEmpleado.setEmplPrimerNombre(rs.getString("emplPrimerNombre"));
                obclsEmpleado.setEmplSegundoNombre(rs.getString("emplSegundoNombre"));
                obclsEmpleado.setEmplPrimerApellido(rs.getString("emplPrimerApellido"));
                obclsEmpleado.setEmplSegundoApellido(rs.getString("emplSegundoApellido"));
                obclsNovedadesEmpleado.setObclsEmpleado(obclsEmpleado);

                Modelos.NovedadesEmpleado.clsTipoNovedad obclsTipoNovedad = new Modelos.NovedadesEmpleado.clsTipoNovedad();
                obclsTipoNovedad.setId_novedad(rs.getInt("Id_novedad"));
                obclsTipoNovedad.setDescripcion_novedad(rs.getString("Descripcion"));
                obclsTipoNovedad.setAlias_novedad(rs.getString("Alias"));
                obclsNovedadesEmpleado.setObclsTipoNovedad(obclsTipoNovedad);

                obclsNovedadesEmpleado.setDetalle(rs.getString("Detalle"));
                obclsNovedadesEmpleado.setFecha(rs.getString("Fecha"));
                obclsNovedadesEmpleado.setDia(rs.getInt("Dia"));

                lstclsNovedadesEmpleado.add(obclsNovedadesEmpleado);

            }

        } catch (Exception e) {
        }
        return lstclsNovedadesEmpleado;
    }

    public List<Modelos.NovedadesEmpleado.clsNovedadesEmpleado> getBuscarNovedadesEmpleado(Modelos.clsBuscar obclsBuscar) {

        List<Modelos.NovedadesEmpleado.clsNovedadesEmpleado> lstclsNovedadesEmpleado = new ArrayList<Modelos.NovedadesEmpleado.clsNovedadesEmpleado>();

        try {

            ResultSet rs = null;
            PreparedStatement ps = conn.prepareStatement("{ call spBuscarNovedadesEmpleado(?)}");
            ps.setString(1, obclsBuscar.getStBuscar());
            rs = ps.executeQuery();

            while (rs.next()) {
                Modelos.NovedadesEmpleado.clsNovedadesEmpleado obclsNovedadesEmpleado = new Modelos.NovedadesEmpleado.clsNovedadesEmpleado();
                obclsNovedadesEmpleado.setId_novedad_empleado(rs.getInt("Id_novedad_empleado"));

                Modelos.NovedadesEmpleado.clsEmpleado obclsEmpleado = new Modelos.NovedadesEmpleado.clsEmpleado();
                obclsEmpleado.setId_empleado(rs.getInt("Id_empleado"));
                obclsEmpleado.setEmplPrimerNombre(rs.getString("emplPrimerNombre"));
                obclsEmpleado.setEmplSegundoNombre(rs.getString("emplSegundoNombre"));
                obclsEmpleado.setEmplPrimerApellido(rs.getString("emplPrimerApellido"));
                obclsEmpleado.setEmplSegundoApellido(rs.getString("emplSegundoApellido"));
                obclsNovedadesEmpleado.setObclsEmpleado(obclsEmpleado);

                Modelos.NovedadesEmpleado.clsTipoNovedad obclsTipoNovedad = new Modelos.NovedadesEmpleado.clsTipoNovedad();
                obclsTipoNovedad.setId_novedad(rs.getInt("Id_novedad"));
                obclsTipoNovedad.setDescripcion_novedad(rs.getString("Descripcion"));
                obclsTipoNovedad.setAlias_novedad(rs.getString("Alias"));
                obclsNovedadesEmpleado.setObclsTipoNovedad(obclsTipoNovedad);

                obclsNovedadesEmpleado.setDetalle(rs.getString("Detalle"));
                obclsNovedadesEmpleado.setFecha(rs.getString("Fecha"));
                obclsNovedadesEmpleado.setDia(rs.getInt("Dia"));

                lstclsNovedadesEmpleado.add(obclsNovedadesEmpleado);
            }

        } catch (Exception e) {
        }
        return lstclsNovedadesEmpleado;
    }

    public String createNovedadesEmpleado(Modelos.NovedadesEmpleado.clsNovedadesEmpleado obclsNovedadesEmpleado) {

        try {

            PreparedStatement ps = conn.prepareStatement("{call spInsertarNovedadesEmpleado (?,?,?,?,?)}");

            ps.setInt(1, obclsNovedadesEmpleado.getObclsEmpleado().getId_empleado());
            ps.setInt(2, obclsNovedadesEmpleado.getObclsTipoNovedad().getId_novedad());
            ps.setString(3, obclsNovedadesEmpleado.getDetalle());
            ps.setString(4, obclsNovedadesEmpleado.getFecha());
            ps.setInt(5, obclsNovedadesEmpleado.getDia());

            ps.execute();

            return "Se realizó el proceso con éxito";

        } catch (Exception ex) {
            return "Hubo un error, revisa la información ingresada";
        }
    }

    public String updateNovedadesEmpleado(Modelos.NovedadesEmpleado.clsNovedadesEmpleado obclsNovedadesEmpleado) {

        try {
            PreparedStatement ps = conn.prepareStatement("{call spEditarNovedadesEmpleado(?,?,?,?,?)}");

            ps.setInt(1, obclsNovedadesEmpleado.getId_novedad_empleado());
            ps.setInt(2, obclsNovedadesEmpleado.getObclsTipoNovedad().getId_novedad());
            ps.setString(3, obclsNovedadesEmpleado.getDetalle());
            ps.setString(4, obclsNovedadesEmpleado.getFecha());
            ps.setInt(5, obclsNovedadesEmpleado.getDia());

            ps.execute();

            return "Se realizó el proceso con éxito";

        } catch (Exception ex) {
            return "Hubo un error, revisa la información ingresada";}
    }

    public String deleteNovedadesEmpleado(Modelos.NovedadesEmpleado.clsNovedadesEmpleado obclsNovedadesEmpleado) {

        try {
            PreparedStatement ps = conn.prepareStatement("{ call spEliminarNovedadesEmpleado(?)}");
            ps.setInt(1, obclsNovedadesEmpleado.getId_novedad_empleado());
            ps.execute();

            return "Se realizó el proceso con éxito";

        } catch (Exception ex) {

            return ex.getMessage();

        }
    }

}
