/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PRACTICANTE
 */
public class ControlConfiguracion extends HttpServlet {

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
        if (request.getParameter("btnConfConsultar") != null) {
            //Lista de Configuaciones
            BL.Configuracion.clsConfiguracion bl_clsConfiguracion = new BL.Configuracion.clsConfiguracion();
            request.setAttribute("lstclsConfiguracion", bl_clsConfiguracion.getConfiguracion());

            request.getRequestDispatcher("Configuracion/configuracion.jsp").forward(request, response);
        } else if (request.getParameter("btnConfAgregar") != null) {
            //Lista desplegable
            BL.Configuracion.clsModulos bl_clsModulos = new BL.Configuracion.clsModulos();
            request.setAttribute("lstclsModulo", bl_clsModulos.getModulo());

            request.getRequestDispatcher("Configuracion/agregarconfiguracion.jsp").forward(request, response);
        } else if (request.getParameter("btnConfGuardar") != null) {
            btnConfGuardar(request, response);
        } else if (request.getParameter("btnConfEditar") != null) {

        } else if (request.getParameter("btnConfEliminar") != null) {

        } else if (request.getParameter("codigoSeleccionar") != null) {
            if (request.getParameter("stOpcion").equals("M")) {

            } else if (request.getParameter("stOpcion").equals("E")) {

            }
        }
    }

    public void btnConfGuardar(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Configuracion.clsConfiguracion bl_clsConfiguracion = new BL.Configuracion.clsConfiguracion();
            //Definición de Modelos
            Modelos.Configuracion.clsConfiguracion obclsConfiguracion = new Modelos.Configuracion.clsConfiguracion();
            Modelos.Configuracion.clsModulo obclsModulo = new Modelos.Configuracion.clsModulo();

            if (request.getParameter("txtNombreConfiguracion") != null) {
                obclsConfiguracion.setNombre_configuracion(request.getParameter("txtNombreConfiguracion"));
            }

            if (request.getParameter("txtDescripcionConfiguracion") != null) {
                obclsConfiguracion.setDescripcion_configuracion(request.getParameter("txtDescripcionConfiguracion"));
            }

            if (request.getParameter("txtNombreVariable") != null) {
                obclsConfiguracion.setNombre_variable(request.getParameter("txtNombreVariable"));
            }

            if (request.getParameter("txtValor") != null) {
                obclsConfiguracion.setValor(Integer.parseInt(request.getParameter("txtValor")));
            }

            if (request.getParameter("ddlModulo") != null) {
                obclsModulo.setId_modulo(Integer.parseInt(request.getParameter("ddlModulo")));

                obclsConfiguracion.setObclsModulo(obclsModulo);
            }

            //Definición de parametros desde el controlador
            request.setAttribute("stMensaje", bl_clsConfiguracion.createConfiguracion(obclsConfiguracion));
            if (request.getAttribute("stMensaje").equals("Se realizo el proceso con exito")) {
                request.setAttribute("stTipo", "success");
            }

            if (request.getAttribute("stMensaje") != ("Se realizó el proceso con éxito")) {
                request.setAttribute("stTipo", "error");
            }
            
            request.setAttribute("lstclsConfiguracion", bl_clsConfiguracion.getConfiguracion());
            
            //Redirección y envio de valores
            request.getRequestDispatcher("NovedadesEmpleado/novedadesempleado.jsp").forward(request, response);  
        } catch (Exception ex) {
            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            
            //Lista desplegable
            BL.Configuracion.clsModulos bl_clsModulos = new BL.Configuracion.clsModulos();
            request.setAttribute("lstclsModulos", bl_clsModulos.getModulo());

            request.getRequestDispatcher("Configuracion/agregarconfiguracion.jsp").forward(request, response);
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
