/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL.ResponsableGrupo;

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
public class clsUsuario {

    Connection conn = null;

    public clsUsuario() {

        clsConexion obclsConexion = new clsConexion();
        conn = obclsConexion.getConexion();

    }

    public List<Modelos.ResponsableGrupo.clsUsuario> getUsuario() {

        List<Modelos.ResponsableGrupo.clsUsuario> lstclsUsuario = new ArrayList<Modelos.ResponsableGrupo.clsUsuario>();

        try {

            PreparedStatement ps = conn.prepareStatement("{call spConsultarUsuarioReGru}");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Modelos.ResponsableGrupo.clsUsuario obclsUsuario = new Modelos.ResponsableGrupo.clsUsuario();
                obclsUsuario.setNro_usuario(rs.getInt("Nro_usuario"));
                obclsUsuario.setEmpleado(rs.getString("emplNombre"));
                obclsUsuario.setId_usuario(rs.getString("Id_usuario"));

                lstclsUsuario.add(obclsUsuario);

            }

        } catch (Exception e) {
        }

        return lstclsUsuario;
    }

}
