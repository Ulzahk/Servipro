/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PRACTICANTE
 */
public class ControlUsuarios extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            if (request.getParameter("btnUsuConsultar") != null) {
                BL.Usuarios.clsUsuarios bl_clsUsuarios = new BL.Usuarios.clsUsuarios();
                request.setAttribute("lstclsUsuarios", bl_clsUsuarios.getUsuarios());

                request.getRequestDispatcher("usuarios.jsp").forward(request, response);
            } else if (request.getParameter("btnUsuAgregar") != null) {
                //Listas Desplegables
                BL.Usuarios.clsEmpleados bl_clsEmpleados = new BL.Usuarios.clsEmpleados();
                BL.Usuarios.clsPerfil bl_clsPerfil = new BL.Usuarios.clsPerfil();

                request.setAttribute("lstclsEmpleados", bl_clsEmpleados.getEmpleados());
                request.setAttribute("lstclsPerfil", bl_clsPerfil.getPerfil());

                request.getRequestDispatcher("agregarusuarios.jsp").forward(request, response);

            } else if (request.getParameter("btnUsuGuardar") != null) {
                btnUsuGuardar(request, response);
            } else if (request.getParameter("btnUsuBuscar") != null) {
                btnUsuBuscar(request, response);
            } else if (request.getParameter("codigoSeleccionado") != null) {
                if (request.getParameter("stOpcion").equals("M")) {
                    cargarEditarUsu(request, response);
                } else if (request.getParameter("stOpcion").equals("E")) {
                    cargarEliminarUsu(request, response);
                }
            } else if (request.getParameter("btnUsuEditar") != null) {
                btnUsuEditar(request, response);
            } else if (request.getParameter("btnUsuEliminar") != null) {
                btnUsuEliminar(request, response);
            }
        }
    }

    public void btnUsuGuardar(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Usuarios.clsUsuarios bl_clsUsuarios = new BL.Usuarios.clsUsuarios();

            //Definición de Modelos
            Modelos.Usuarios.clsUsuarios obclsUsuarios = new Modelos.Usuarios.clsUsuarios();

            Modelos.Usuarios.clsEmpleados obclsEmpleados = new Modelos.Usuarios.clsEmpleados();
            Modelos.Usuarios.clsPerfil obclsPerfil = new Modelos.Usuarios.clsPerfil();

            if (request.getParameter("txtUsuario") != null) {
                obclsUsuarios.setId_Usuarios(request.getParameter("txtUsuario"));
            }

            if (request.getParameter("ddlEmpleado") != null) {
                obclsEmpleados.setId_empleado(Integer.parseInt(request.getParameter("ddlEmpleado")));

                obclsUsuarios.setObclsEmpleado(obclsEmpleados);
            }

            if (request.getParameter("txtContraseña") != null) {
                obclsUsuarios.setContraseña(request.getParameter("txtContraseña"));
            }

            if (request.getParameter("ddlPerfil") != null) {
                obclsPerfil.setId_perfil(Integer.parseInt(request.getParameter("ddlPerfil")));

                obclsUsuarios.setObclsPerfil(obclsPerfil);
            }

            //Definición de parametros desde el controlador
            request.setAttribute("stMensaje", bl_clsUsuarios.createUsuario(obclsUsuarios));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsUsuarios", bl_clsUsuarios.getUsuarios());

            //Redireccion y envio de valores
            request.getRequestDispatcher("usuarios.jsp").forward(request, response);
        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            //Listas Desplegables
            BL.Usuarios.clsEmpleados bl_clsEmpleados = new BL.Usuarios.clsEmpleados();
            BL.Usuarios.clsPerfil bl_clsPerfil = new BL.Usuarios.clsPerfil();

            request.setAttribute("lstclsEmpleados", bl_clsEmpleados.getEmpleados());
            request.setAttribute("lstclsPerfil", bl_clsPerfil.getPerfil());

            request.getRequestDispatcher("agregarusuarios.jsp").forward(request, response);
        }
    }

    public void btnUsuBuscar(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Usuarios.clsUsuarios bl_clsUsuarios = new BL.Usuarios.clsUsuarios();

            Modelos.clsBuscar obclsBuscar = new Modelos.clsBuscar();

            if (request.getParameter("txtUsuBuscar") != null) {
                obclsBuscar.setStBuscar(request.getParameter("txtUsuBuscar"));
            }

            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsUsuarios", bl_clsUsuarios.getBuscarUsuarios(obclsBuscar));

            request.getRequestDispatcher("usuarios.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("stTipo", "error");
            request.setAttribute("stMensaje", ex.getMessage());

            request.getRequestDispatcher("usuarios.jsp").forward(request, response);
        }
    }

    public void cargarEditarUsu(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {

            BL.Usuarios.clsUsuarios bl_clsUsuarios = new BL.Usuarios.clsUsuarios();

            List<Modelos.Usuarios.clsUsuarios> lstclsUsuarios = new ArrayList<Modelos.Usuarios.clsUsuarios>();

            //Definición de Modelos
            Modelos.Usuarios.clsUsuarios obclsUsuarios = new Modelos.Usuarios.clsUsuarios();

            lstclsUsuarios = bl_clsUsuarios.getUsuarios();

            for (Modelos.Usuarios.clsUsuarios elem : lstclsUsuarios) {
                if (elem.getNro_usuario() == Integer.parseInt(request.getParameter("codigoSeleccionado"))) {
                    obclsUsuarios = elem;
                    break;
                }
            }

            //Listas Desplegables
            BL.Usuarios.clsEmpleados bl_clsEmpleados = new BL.Usuarios.clsEmpleados();
            BL.Usuarios.clsPerfil bl_clsPerfil = new BL.Usuarios.clsPerfil();

            request.setAttribute("lstclsEmpleados", bl_clsEmpleados.getEmpleados());
            request.setAttribute("lstclsPerfil", bl_clsPerfil.getPerfil());

            request.setAttribute("obclsUsuarios", obclsUsuarios);
            request.setAttribute("lstclsUsuarios", lstclsUsuarios);
            request.getRequestDispatcher("editarusuarios.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            request.getRequestDispatcher("usuarios.jsp").forward(request, response);
        }
    }

    public void cargarEliminarUsu(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Usuarios.clsUsuarios bl_clsUsuarios = new BL.Usuarios.clsUsuarios();

            List<Modelos.Usuarios.clsUsuarios> lstclsUsuarios = new ArrayList<Modelos.Usuarios.clsUsuarios>();

            //Definición de Modelos
            Modelos.Usuarios.clsUsuarios obclsUsuarios = new Modelos.Usuarios.clsUsuarios();

            lstclsUsuarios = bl_clsUsuarios.getUsuarios();

            for (Modelos.Usuarios.clsUsuarios elem : lstclsUsuarios) {
                if (elem.getNro_usuario() == Integer.parseInt(request.getParameter("codigoSeleccionado"))) {
                    obclsUsuarios = elem;
                    break;
                }
            }

            request.setAttribute("obclsUsuarios", obclsUsuarios);
            request.setAttribute("lstclsUsuarios", lstclsUsuarios);
            request.getRequestDispatcher("eliminarusuarios.jsp").forward(request, response);

        } catch (Exception ex) {
            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            request.getRequestDispatcher("usuarios.jsp").forward(request, response);
        }
    }

    public void btnUsuEditar(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Usuarios.clsUsuarios bl_clsUsuarios = new BL.Usuarios.clsUsuarios();

            //Definición de Modelos
            Modelos.Usuarios.clsUsuarios obclsUsuarios = new Modelos.Usuarios.clsUsuarios();

            Modelos.Usuarios.clsEmpleados obclsEmpleados = new Modelos.Usuarios.clsEmpleados();
            Modelos.Usuarios.clsPerfil obclsPerfil = new Modelos.Usuarios.clsPerfil();

            if (request.getParameter("txtUsuario") != null) {
                obclsUsuarios.setId_Usuarios(request.getParameter("txtUsuario"));
            }

            if (request.getParameter("ddlEmpleado") != null) {
                obclsEmpleados.setId_empleado(Integer.parseInt(request.getParameter("ddlEmpleado")));

                obclsUsuarios.setObclsEmpleado(obclsEmpleados);
            }

            if (request.getParameter("txtContraseña") != null) {
                obclsUsuarios.setContraseña(request.getParameter("txtContraseña"));
            }

            if (request.getParameter("ddlPerfil") != null) {
                obclsPerfil.setId_perfil(Integer.parseInt(request.getParameter("ddlPerfil")));

                obclsUsuarios.setObclsPerfil(obclsPerfil);
            }

            if (request.getParameter("IdModificar") != null) {
                obclsUsuarios.setNro_usuario(Integer.valueOf(request.getParameter("IdModificar")));
            }

            //Definición de parametros desde el controlador
            request.setAttribute("stMensaje", bl_clsUsuarios.updateUsuarios(obclsUsuarios));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsUsuarios", bl_clsUsuarios.getUsuarios());

            //Redireccion y envio de valores
            request.getRequestDispatcher("usuarios.jsp").forward(request, response);
        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            //Lista de Usuarios
            BL.Usuarios.clsUsuarios bl_clsUsuarios = new BL.Usuarios.clsUsuarios();
            request.setAttribute("lstclsUsuarios", bl_clsUsuarios.getUsuarios());

            //Listas Desplegables
            BL.Usuarios.clsEmpleados bl_clsEmpleados = new BL.Usuarios.clsEmpleados();
            BL.Usuarios.clsPerfil bl_clsPerfil = new BL.Usuarios.clsPerfil();

            request.setAttribute("lstclsEmpleados", bl_clsEmpleados.getEmpleados());
            request.setAttribute("lstclsPerfil", bl_clsPerfil.getPerfil());

            request.getRequestDispatcher("editarusuarios.jsp").forward(request, response);
        }
    }

    public void btnUsuEliminar(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Usuarios.clsUsuarios bl_clsUsuarios = new BL.Usuarios.clsUsuarios();

            //Definición de Modelos
            Modelos.Usuarios.clsUsuarios obclsUsuarios = new Modelos.Usuarios.clsUsuarios();

            if (request.getParameter("IdModificar") != null) {
                obclsUsuarios.setNro_usuario(Integer.valueOf(request.getParameter("IdModificar")));
            }

            //Definición de parametros desde el controlador
            request.setAttribute("stMensaje", bl_clsUsuarios.deleteUsuarios(obclsUsuarios));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsUsuarios", bl_clsUsuarios.getUsuarios());

            //Redireccion y envio de valores
            request.getRequestDispatcher("usuarios.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            request.getRequestDispatcher("eliminarusuarios.jsp").forward(request, response);
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
