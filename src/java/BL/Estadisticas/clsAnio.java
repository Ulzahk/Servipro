package BL.Estadisticas;

import BL.clsConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class clsAnio {

    Connection conn = null;

    public clsAnio() {

        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();
    }

    public List<Modelos.Estadisticas.clsAnio> getAnio() {

        List<Modelos.Estadisticas.clsAnio> lstclsAnio = new ArrayList<Modelos.Estadisticas.clsAnio>();
        try {
            ResultSet rs = null;
            PreparedStatement ps = conn.prepareStatement("{call spConsultarAnio}");
            rs = ps.executeQuery();
            
            while(rs.next()){
                Modelos.Estadisticas.clsAnio obclsAnio = new Modelos.Estadisticas.clsAnio();
                obclsAnio.setId_anio(rs.getInt("Id_anio"));
                obclsAnio.setNombreAnio(rs.getString("nombreAnio"));
                
                lstclsAnio.add(obclsAnio);
            }
        } catch (Exception e) {
        }
        return lstclsAnio;
    }
}
