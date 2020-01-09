/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PRACTICANTE
 */
public class ControlPerfil extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        if (request.getParameter("btnPerfGuardar") != null) {
            btnPerfGuardar(request, response);
        } else if (request.getParameter("btnPerfEditar") != null) {
            btnPerfEditar(request, response);
        } else if (request.getParameter("btnPerfEliminar") != null) {
            btnPerfEliminar(request, response);
        } else if (request.getParameter("codigoSeleccionado") != null) {
            if (request.getParameter("stOpcion").equals("M")) {
                cargarPerfEditar(request, response);
            } else if (request.getParameter("stOpcion").equals("E")) {
                cargarPerfEliminar(request, response);
            }
        } else if (request.getParameter("btnPerfConsultar") != null) {
            //Lista de perfil
            BL.Perfil.clsPerfil bl_clsPerfil = new BL.Perfil.clsPerfil();
            request.setAttribute("lstclsPerfil", bl_clsPerfil.getPerfil());

            request.getRequestDispatcher("Perfil/perfil.jsp").forward(request, response);
        } else if (request.getParameter("btnPerfAgregar") != null) {
            request.getRequestDispatcher("Perfil/agregarperfil.jsp").forward(request, response);
        } else if (request.getParameter("btnPerfBuscar") != null) {

        }
    }

    public void btnPerfGuardar(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {

            BL.Perfil.clsPerfil bl_clsPerfil = new BL.Perfil.clsPerfil();

            Modelos.Perfil.clsPerfil obclsPerfil = new Modelos.Perfil.clsPerfil();

            if (request.getParameter("txtPerfil") != null) {
                obclsPerfil.setDescripcion_perfil(request.getParameter("txtPerfil"));
            }

            if (request.getParameter("chVistaUsuarios") != null) {
                char chSeleccion = request.getParameter("chVistaUsuarios").equals("on")
                        ? 'S' : 'N';
                obclsPerfil.setVista_usuarios(chSeleccion);
            } else {
                obclsPerfil.setVista_usuarios('N');
            }

            if (request.getParameter("chVistaPerfil") != null) {
                char chSeleccion = request.getParameter("chVistaPerfil").equals("on")
                        ? 'S' : 'N';
                obclsPerfil.setVista_perfil(chSeleccion);
            } else {
                obclsPerfil.setVista_perfil('N');
            }

            if (request.getParameter("chVistaTipoNovedades") != null) {
                char chSeleccion = request.getParameter("chVistaTipoNovedades").equals("on")
                        ? 'S' : 'N';
                obclsPerfil.setVista_tiponovedades(chSeleccion);
            } else {
                obclsPerfil.setVista_tiponovedades('N');
            }

            if (request.getParameter("chVistaFacturacion") != null) {
                char chSeleccion = request.getParameter("chVistaFacturacion").equals("on")
                        ? 'S' : 'N';
                obclsPerfil.setVista_facturacion(chSeleccion);
            } else {
                obclsPerfil.setVista_facturacion('N');
            }

            if (request.getParameter("chVistaNovedadesEmpleado") != null) {
                char chSeleccion = request.getParameter("chVistaNovedadesEmpleado").equals("on")
                        ? 'S' : 'N';
                obclsPerfil.setVista_novedadesempleado(chSeleccion);
            } else {
                obclsPerfil.setVista_novedadesempleado('N');
            }

            if (request.getParameter("chVistaCentroCostos") != null) {
                char chSeleccion = request.getParameter("chVistaCentroCostos").equals("on")
                        ? 'S' : 'N';
                obclsPerfil.setVista_centrocostos(chSeleccion);
            } else {
                obclsPerfil.setVista_centrocostos('N');
            }

            if (request.getParameter("chVistaEmpleados") != null) {
                char chSeleccion = request.getParameter("chVistaEmpleados").equals("on")
                        ? 'S' : 'N';
                obclsPerfil.setVista_empleados(chSeleccion);
            } else {
                obclsPerfil.setVista_empleados('N');
            }

            if (request.getParameter("chVistaCargoEmpleado") != null) {
                char chSeleccion = request.getParameter("chVistaCargoEmpleado").equals("on")
                        ? 'S' : 'N';
                obclsPerfil.setVista_cargoempleado(chSeleccion);
            } else {
                obclsPerfil.setVista_cargoempleado('N');
            }

            if (request.getParameter("chVistaModulos") != null) {
                char chSeleccion = request.getParameter("chVistaModulos").equals("on")
                        ? 'S' : 'N';
                obclsPerfil.setVista_modulos(chSeleccion);
            } else {
                obclsPerfil.setVista_modulos('N');
            }

            if (request.getParameter("chVistaModulosPerfil") != null) {
                char chSeleccion = request.getParameter("chVistaModulosPerfil").equals("on")
                        ? 'S' : 'N';
                obclsPerfil.setVista_modulosperfil(chSeleccion);
            } else {
                obclsPerfil.setVista_modulosperfil('N');
            }

            if (request.getParameter("chVistaGrupos") != null) {
                char chSeleccion = request.getParameter("chVistaGrupos").equals("on")
                        ? 'S' : 'N';
                obclsPerfil.setVista_grupos(chSeleccion);
            } else {
                obclsPerfil.setVista_grupos('N');
            }

            if (request.getParameter("chVistaEmpleadosGrupo") != null) {
                char chSeleccion = request.getParameter("chVistaEmpleadosGrupo").equals("on")
                        ? 'S' : 'N';
                obclsPerfil.setVista_empleadosgrupo(chSeleccion);
            } else {
                obclsPerfil.setVista_empleadosgrupo('N');
            }

            if (request.getParameter("chVistaResponsableGrupo") != null) {
                char chSeleccion = request.getParameter("chVistaResponsableGrupo").equals("on")
                        ? 'S' : 'N';
                obclsPerfil.setVista_responsablegrupo(chSeleccion);
            } else {
                obclsPerfil.setVista_responsablegrupo('N');
            }

            if (request.getParameter("chVistaConfiguracion") != null) {
                char chSeleccion = request.getParameter("chVistaConfiguracion").equals("on")
                        ? 'S' : 'N';
                obclsPerfil.setVista_configuracion(chSeleccion);
            } else {
                obclsPerfil.setVista_configuracion('N');
            }

            if (request.getParameter("chVistaEstadisticas") != null) {
                char chSeleccion = request.getParameter("chVistaEstadisticas").equals("on")
                        ? 'S' : 'N';
                obclsPerfil.setVista_estadisticas(chSeleccion);
            } else {
                obclsPerfil.setVista_estadisticas('N');
            }

            //Definición de parametros desde el controlador
            request.setAttribute("stMensaje", bl_clsPerfil.createPerfil(obclsPerfil));
            if (request.getAttribute("stMensaje").equals("Se realizó el proceso con éxito")) {
                request.setAttribute("stTipo", "success");
            }

            if (request.getAttribute("stMensaje") != ("Se realizó el proceso con éxito")) {
                request.setAttribute("stTipo", "error");
            }
            request.setAttribute("lstclsPerfil", bl_clsPerfil.getPerfil());

            //Redirección y envio de valores
            request.getRequestDispatcher("Perfil/perfil.jsp").forward(request, response);

        } catch (Exception ex) {
            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            request.getRequestDispatcher("Perfil/agregarperfil.jsp").forward(request, response);
        }
    }

    public void cargarPerfEditar(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Perfil.clsPerfil bl_clsPerfil = new BL.Perfil.clsPerfil();

            List<Modelos.Perfil.clsPerfil> lstclsPerfil = new ArrayList<Modelos.Perfil.clsPerfil>();

            Modelos.Perfil.clsPerfil obclsPerfil = new Modelos.Perfil.clsPerfil();

            lstclsPerfil = bl_clsPerfil.getPerfil();

            for (Modelos.Perfil.clsPerfil elem : lstclsPerfil) {
                if (elem.getId_perfil() == Integer.parseInt(request.getParameter("codigoSeleccionado"))) {
                    obclsPerfil = elem;
                    break;
                }
            }

            request.setAttribute("obclsPerfil", obclsPerfil);
            request.setAttribute("lstclsPerfil", lstclsPerfil);

            request.getRequestDispatcher("Perfil/editarperfil.jsp").forward(request, response);
        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            request.getRequestDispatcher("Perfil/perfil.jsp").forward(request, response);
        }
    }

    public void cargarPerfEliminar(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {

            BL.Perfil.clsPerfil bl_clsPerfil = new BL.Perfil.clsPerfil();

            List<Modelos.Perfil.clsPerfil> lstclsPerfil = new ArrayList<Modelos.Perfil.clsPerfil>();

            Modelos.Perfil.clsPerfil obclsPerfil = new Modelos.Perfil.clsPerfil();

            lstclsPerfil = bl_clsPerfil.getPerfil();

            for (Modelos.Perfil.clsPerfil elem : lstclsPerfil) {
                if (elem.getId_perfil() == Integer.parseInt(request.getParameter("codigoSeleccionado"))) {
                    obclsPerfil = elem;
                    break;
                }
            }

            request.setAttribute("obclsPerfil", obclsPerfil);
            request.setAttribute("lstclsPerfil", lstclsPerfil);

            request.getRequestDispatcher("Perfil/eliminarperfil.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            request.getRequestDispatcher("Perfil/perfil.jsp").forward(request, response);
        }
    }

    public void btnPerfEditar(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        try {
            BL.Perfil.clsPerfil bl_clsPerfil = new BL.Perfil.clsPerfil();

            Modelos.Perfil.clsPerfil obclsPerfil = new Modelos.Perfil.clsPerfil();

            if (request.getParameter("IdModificar") != null) {
                obclsPerfil.setId_perfil(Integer.valueOf(request.getParameter("IdModificar")));
            }

            if (request.getParameter("txtPerfil") != null) {
                obclsPerfil.setDescripcion_perfil(request.getParameter("txtPerfil"));
            }

            if (request.getParameter("chVistaUsuarios") != null) {
                char chSeleccion = request.getParameter("chVistaUsuarios").equals("on")
                        ? 'S' : 'N';
                obclsPerfil.setVista_usuarios(chSeleccion);
            } else {
                obclsPerfil.setVista_usuarios('N');
            }

            if (request.getParameter("chVistaPerfil") != null) {
                char chSeleccion = request.getParameter("chVistaPerfil").equals("on")
                        ? 'S' : 'N';
                obclsPerfil.setVista_perfil(chSeleccion);
            } else {
                obclsPerfil.setVista_perfil('N');
            }

            if (request.getParameter("chVistaTipoNovedades") != null) {
                char chSeleccion = request.getParameter("chVistaTipoNovedades").equals("on")
                        ? 'S' : 'N';
                obclsPerfil.setVista_tiponovedades(chSeleccion);
            } else {
                obclsPerfil.setVista_tiponovedades('N');
            }

            if (request.getParameter("chVistaFacturacion") != null) {
                char chSeleccion = request.getParameter("chVistaFacturacion").equals("on")
                        ? 'S' : 'N';
                obclsPerfil.setVista_facturacion(chSeleccion);
            } else {
                obclsPerfil.setVista_facturacion('N');
            }

            if (request.getParameter("chVistaNovedadesEmpleado") != null) {
                char chSeleccion = request.getParameter("chVistaNovedadesEmpleado").equals("on")
                        ? 'S' : 'N';
                obclsPerfil.setVista_novedadesempleado(chSeleccion);
            } else {
                obclsPerfil.setVista_novedadesempleado('N');
            }

            if (request.getParameter("chVistaCentroCostos") != null) {
                char chSeleccion = request.getParameter("chVistaCentroCostos").equals("on")
                        ? 'S' : 'N';
                obclsPerfil.setVista_centrocostos(chSeleccion);
            } else {
                obclsPerfil.setVista_centrocostos('N');
            }

            if (request.getParameter("chVistaEmpleados") != null) {
                char chSeleccion = request.getParameter("chVistaEmpleados").equals("on")
                        ? 'S' : 'N';
                obclsPerfil.setVista_empleados(chSeleccion);
            } else {
                obclsPerfil.setVista_empleados('N');
            }

            if (request.getParameter("chVistaCargoEmpleado") != null) {
                char chSeleccion = request.getParameter("chVistaCargoEmpleado").equals("on")
                        ? 'S' : 'N';
                obclsPerfil.setVista_cargoempleado(chSeleccion);
            } else {
                obclsPerfil.setVista_cargoempleado('N');
            }

            if (request.getParameter("chVistaModulos") != null) {
                char chSeleccion = request.getParameter("chVistaModulos").equals("on")
                        ? 'S' : 'N';
                obclsPerfil.setVista_modulos(chSeleccion);
            } else {
                obclsPerfil.setVista_modulos('N');
            }

            if (request.getParameter("chVistaModulosPerfil") != null) {
                char chSeleccion = request.getParameter("chVistaModulosPerfil").equals("on")
                        ? 'S' : 'N';
                obclsPerfil.setVista_modulosperfil(chSeleccion);
            } else {
                obclsPerfil.setVista_modulosperfil('N');
            }

            if (request.getParameter("chVistaGrupos") != null) {
                char chSeleccion = request.getParameter("chVistaGrupos").equals("on")
                        ? 'S' : 'N';
                obclsPerfil.setVista_grupos(chSeleccion);
            } else {
                obclsPerfil.setVista_grupos('N');
            }

            if (request.getParameter("chVistaEmpleadosGrupo") != null) {
                char chSeleccion = request.getParameter("chVistaEmpleadosGrupo").equals("on")
                        ? 'S' : 'N';
                obclsPerfil.setVista_empleadosgrupo(chSeleccion);
            } else {
                obclsPerfil.setVista_empleadosgrupo('N');
            }

            if (request.getParameter("chVistaResponsableGrupo") != null) {
                char chSeleccion = request.getParameter("chVistaResponsableGrupo").equals("on")
                        ? 'S' : 'N';
                obclsPerfil.setVista_responsablegrupo(chSeleccion);
            } else {
                obclsPerfil.setVista_responsablegrupo('N');
            }

            if (request.getParameter("chVistaConfiguracion") != null) {
                char chSeleccion = request.getParameter("chVistaConfiguracion").equals("on")
                        ? 'S' : 'N';
                obclsPerfil.setVista_configuracion(chSeleccion);
            } else {
                obclsPerfil.setVista_configuracion('N');
            }

            if (request.getParameter("chVistaEstadisticas") != null) {
                char chSeleccion = request.getParameter("chVistaEstadisticas").equals("on")
                        ? 'S' : 'N';
                obclsPerfil.setVista_estadisticas(chSeleccion);
            } else {
                obclsPerfil.setVista_estadisticas('N');
            }

            request.setAttribute("stMensaje", bl_clsPerfil.updatePerfil(obclsPerfil));
            if (request.getAttribute("stMensaje").equals("Se realizó el proceso con éxito")) {
                request.setAttribute("stTipo", "success");
            }

            if (request.getAttribute("stMensaje") != ("Se realizó el proceso con éxito")) {
                request.setAttribute("stTipo", "error");
            }
            request.setAttribute("lstclsPerfil", bl_clsPerfil.getPerfil());

            request.getRequestDispatcher("Perfil/perfil.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            BL.Perfil.clsPerfil bl_clsPerfil = new BL.Perfil.clsPerfil();
            request.setAttribute("lstclsPerfil", bl_clsPerfil.getPerfil());

            request.getRequestDispatcher("Perfil/editarperfil.jsp").forward(request, response);
        }
    }

    public void btnPerfEliminar(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        try {
            BL.Perfil.clsPerfil bl_clsPerfil = new BL.Perfil.clsPerfil();

            Modelos.Perfil.clsPerfil obclsPerfil = new Modelos.Perfil.clsPerfil();

            if (request.getParameter("IdModificar") != null) {
                obclsPerfil.setId_perfil(Integer.valueOf(request.getParameter("IdModificar")));
            }

            request.setAttribute("stMensaje", bl_clsPerfil.deletePerfil(obclsPerfil));
            if (request.getAttribute("stMensaje").equals("Se realizó el proceso con éxito")) {
                request.setAttribute("stTipo", "success");
            }

            if (request.getAttribute("stMensaje") != ("Se realizó el proceso con éxito")) {
                request.setAttribute("stTipo", "error");
            }
            request.setAttribute("lstclsPerfil", bl_clsPerfil.getPerfil());

            request.getRequestDispatcher("Perfil/perfil.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            BL.Perfil.clsPerfil bl_clsPerfil = new BL.Perfil.clsPerfil();
            request.setAttribute("lstclsPerfil", bl_clsPerfil.getPerfil());

            request.getRequestDispatcher("Perfil/eliminarperfil.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
