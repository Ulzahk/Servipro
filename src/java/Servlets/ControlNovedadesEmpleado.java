package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControlNovedadesEmpleado extends HttpServlet {

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
            if (request.getParameter("btnNoveEmplGuardar") != null) {
                btnNoveEmplGuardar(request, response);
            } else if (request.getParameter("btnNoveEmplEditar") != null) {
                btnNoveEmplEditar(request, response);
            } else if (request.getParameter("btnNoveEmplEliminar") != null) {
                btnNoveEmplEliminar(request, response);
            } else if (request.getParameter("codigoSeleccionado") != null) {
                if (request.getParameter("stOpcion").equals("M")) {
                    cargarNoveEmplEditar(request, response);
                } else if (request.getParameter("stOpcion").equals("E")) {
                    cargarNoveEmplEliminar(request, response);
                }
            } else if (request.getParameter("btnNoveEmplConsultar") != null) {
                //Lista de novedades empleado
                BL.NovedadesEmpleado.clsNovedadesEmpleado bl_clsNovedadesEmpleado = new BL.NovedadesEmpleado.clsNovedadesEmpleado();
                request.setAttribute("lstclsNovedadesEmpleado", bl_clsNovedadesEmpleado.getNovedadesEmpleado());

                request.getRequestDispatcher("NovedadesEmpleado/novedadesempleado.jsp").forward(request, response);
            } else if (request.getParameter("btnNoveEmplAgregar") != null) {

                //Listas desplegables
                BL.NovedadesEmpleado.clsEmpleado bl_clsEmpleado = new BL.NovedadesEmpleado.clsEmpleado();
                BL.NovedadesEmpleado.clsTipoNovedad bl_clsTipoNovedad = new BL.NovedadesEmpleado.clsTipoNovedad();

                request.setAttribute("lstclsEmpleado", bl_clsEmpleado.getEmpleado());
                request.setAttribute("lstclsTipoNovedad", bl_clsTipoNovedad.getTipoNovedad());

                request.getRequestDispatcher("NovedadesEmpleado/agregarnovedadesempleado.jsp").forward(request, response);
            } else if (request.getParameter("btnNoveEmplBuscar") != null) {
                btnNoveEmplBuscar(request, response);
            }
        }
    }

    public void btnNoveEmplGuardar(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.NovedadesEmpleado.clsNovedadesEmpleado bl_clsNovedadesEmpleados = new BL.NovedadesEmpleado.clsNovedadesEmpleado();

            //Definición de modelos
            Modelos.NovedadesEmpleado.clsNovedadesEmpleado obclsNovedadesEmpleado = new Modelos.NovedadesEmpleado.clsNovedadesEmpleado();

            Modelos.NovedadesEmpleado.clsEmpleado obclsEmpleado = new Modelos.NovedadesEmpleado.clsEmpleado();
            Modelos.NovedadesEmpleado.clsTipoNovedad obclsTipoNovedad = new Modelos.NovedadesEmpleado.clsTipoNovedad();

            if (request.getParameter("ddlEmpleado") != null) {
                //Modelo externo
                obclsEmpleado.setId_empleado(Integer.parseInt(request.getParameter("ddlEmpleado")));
                //Modelo padre
                obclsNovedadesEmpleado.setObclsEmpleado(obclsEmpleado);
            }

            if (request.getParameter("ddlTipoNovedad") != null) {
                obclsTipoNovedad.setId_novedad(Integer.parseInt(request.getParameter("ddlTipoNovedad")));

                obclsNovedadesEmpleado.setObclsTipoNovedad(obclsTipoNovedad);
            }
            if (request.getParameter("txtDetalle") != null) {
                obclsNovedadesEmpleado.setDetalle(request.getParameter("txtDetalle"));
            }
            if (request.getParameter("txtFecha") != null) {
                obclsNovedadesEmpleado.setFecha(request.getParameter("txtFecha"));
            }
            if (request.getParameter("txtDia") != null) {
                obclsNovedadesEmpleado.setDia(Integer.parseInt(request.getParameter("txtDia")));
            }

            //Definición de parametros desde el controlador
            request.setAttribute("stMensaje", bl_clsNovedadesEmpleados.createNovedadesEmpleado(obclsNovedadesEmpleado));
            if (request.getAttribute("stMensaje").equals("Se realizo el proceso con exito")) {
                request.setAttribute("stTipo", "success");
            }
                        
            if(request.getAttribute("stMensaje") != ("Se realizó el proceso con éxito")){
                request.setAttribute("stTipo", "error");
            }                   
            request.setAttribute("lstclsNovedadesEmpleado", bl_clsNovedadesEmpleados.getNovedadesEmpleado());

            //Redirección y envio de valores
            request.getRequestDispatcher("NovedadesEmpleado/novedadesempleado.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            //Listas desplegables
            BL.NovedadesEmpleado.clsEmpleado bl_clsEmpleado = new BL.NovedadesEmpleado.clsEmpleado();
            BL.NovedadesEmpleado.clsTipoNovedad bl_clsTipoNovedad = new BL.NovedadesEmpleado.clsTipoNovedad();

            request.setAttribute("lstclsEmpleado", bl_clsEmpleado.getEmpleado());
            request.setAttribute("lstclsTipoNovedad", bl_clsTipoNovedad.getTipoNovedad());

            request.getRequestDispatcher("NovedadesEmpleado/agregarnovedadesempleado.jsp").forward(request, response);
        }

    }

    public void cargarNoveEmplEditar(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.NovedadesEmpleado.clsNovedadesEmpleado bl_clsNovedadesEmpleado = new BL.NovedadesEmpleado.clsNovedadesEmpleado();
            //Lista de objetos donde esta la información guardada
            List<Modelos.NovedadesEmpleado.clsNovedadesEmpleado> lstclsNovedadesEmpleado = new ArrayList<Modelos.NovedadesEmpleado.clsNovedadesEmpleado>();
            //Modelo que se esta trabajando
            Modelos.NovedadesEmpleado.clsNovedadesEmpleado obclsNovedadesEmpleado = new Modelos.NovedadesEmpleado.clsNovedadesEmpleado();

            lstclsNovedadesEmpleado = bl_clsNovedadesEmpleado.getNovedadesEmpleado();

            for (Modelos.NovedadesEmpleado.clsNovedadesEmpleado elem : lstclsNovedadesEmpleado) {
                if (elem.getId_novedad_empleado() == Integer.parseInt(request.getParameter("codigoSeleccionado"))) {
                    obclsNovedadesEmpleado = elem;
                    break;
                }
            }

            //Listas desplegables
            BL.NovedadesEmpleado.clsEmpleado bl_clsEmpleado = new BL.NovedadesEmpleado.clsEmpleado();
            BL.NovedadesEmpleado.clsTipoNovedad bl_clsTipoNovedad = new BL.NovedadesEmpleado.clsTipoNovedad();

            request.setAttribute("lstclsEmpleado", bl_clsEmpleado.getEmpleado());
            request.setAttribute("lstclsTipoNovedad", bl_clsTipoNovedad.getTipoNovedad());

            request.setAttribute("obclsNovedadesEmpleado", obclsNovedadesEmpleado);
            request.setAttribute("lstclsNovedadesEmpleado", lstclsNovedadesEmpleado);
            request.getRequestDispatcher("NovedadesEmpleado/editarnovedadesempleado.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            request.getRequestDispatcher("NovedadesEmpleado/novedadesempleado.jsp").forward(request, response);
        }

    }

    public void cargarNoveEmplEliminar(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.NovedadesEmpleado.clsNovedadesEmpleado bl_clsNovedadesEmpleado = new BL.NovedadesEmpleado.clsNovedadesEmpleado();

            List<Modelos.NovedadesEmpleado.clsNovedadesEmpleado> lstclsNovedadesEmpleado = new ArrayList<Modelos.NovedadesEmpleado.clsNovedadesEmpleado>();

            Modelos.NovedadesEmpleado.clsNovedadesEmpleado obclsNovedadesEmpleado = new Modelos.NovedadesEmpleado.clsNovedadesEmpleado();

            lstclsNovedadesEmpleado = bl_clsNovedadesEmpleado.getNovedadesEmpleado();

            for (Modelos.NovedadesEmpleado.clsNovedadesEmpleado elem : lstclsNovedadesEmpleado) {
                if (elem.getId_novedad_empleado() == Integer.parseInt(request.getParameter("codigoSeleccionado"))) {
                    obclsNovedadesEmpleado = elem;
                    break;
                }
            }

            //Listas desplegables
            BL.NovedadesEmpleado.clsEmpleado bl_clsEmpleado = new BL.NovedadesEmpleado.clsEmpleado();
            BL.NovedadesEmpleado.clsTipoNovedad bl_clsTipoNovedad = new BL.NovedadesEmpleado.clsTipoNovedad();

            request.setAttribute("lstclsEmpleado", bl_clsEmpleado.getEmpleado());
            request.setAttribute("lstclsTipoNovedad", bl_clsTipoNovedad.getTipoNovedad());

            request.setAttribute("obclsNovedadesEmpleado", obclsNovedadesEmpleado);
            request.setAttribute("lstclsNovedadesEmpleado", lstclsNovedadesEmpleado);
            request.getRequestDispatcher("NovedadesEmpleado/eliminarnovedadesempleado.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "erro");

            request.getRequestDispatcher("NovedadesEmpleado/novedadesempleado.jsp").forward(request, response);
        }
    }
    

    public void btnNoveEmplEditar(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        try {
            BL.NovedadesEmpleado.clsNovedadesEmpleado bl_clsNovedadesEmpleados = new BL.NovedadesEmpleado.clsNovedadesEmpleado();

            //Definición de modelos
            Modelos.NovedadesEmpleado.clsNovedadesEmpleado obclsNovedadesEmpleado = new Modelos.NovedadesEmpleado.clsNovedadesEmpleado();

            Modelos.NovedadesEmpleado.clsEmpleado obclsEmpleado = new Modelos.NovedadesEmpleado.clsEmpleado();
            Modelos.NovedadesEmpleado.clsTipoNovedad obclsTipoNovedad = new Modelos.NovedadesEmpleado.clsTipoNovedad();

            if (request.getParameter("IdModificar") != null) {
                obclsNovedadesEmpleado.setId_novedad_empleado(Integer.valueOf(request.getParameter("IdModificar")));
            }

            if (request.getParameter("ddlTipoNovedad") != null) {
                obclsTipoNovedad.setId_novedad(Integer.parseInt(request.getParameter("ddlTipoNovedad")));

                obclsNovedadesEmpleado.setObclsTipoNovedad(obclsTipoNovedad);
            }
            if (request.getParameter("txtDetalle") != null) {
                obclsNovedadesEmpleado.setDetalle(request.getParameter("txtDetalle"));
            }
            if (request.getParameter("txtFecha") != null) {
                obclsNovedadesEmpleado.setFecha(request.getParameter("txtFecha"));
            }
            if (request.getParameter("txtDia") != null) {
                obclsNovedadesEmpleado.setDia(Integer.parseInt(request.getParameter("txtDia")));
            }

            //Definición de parametros desde el controlador
            request.setAttribute("stMensaje", bl_clsNovedadesEmpleados.updateNovedadesEmpleado(obclsNovedadesEmpleado));
            if (request.getAttribute("stMensaje").equals("Se realizo el proceso con exito")) {
                request.setAttribute("stTipo", "success");
            }
                        
            if(request.getAttribute("stMensaje") != ("Se realizó el proceso con éxito")){
                request.setAttribute("stTipo", "error");
            }                   
            request.setAttribute("lstclsNovedadesEmpleado", bl_clsNovedadesEmpleados.getNovedadesEmpleado());

            //Redirección y envio de valores
            request.getRequestDispatcher("NovedadesEmpleado/novedadesempleado.jsp").forward(request, response);

        } catch (Exception ex) {
            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            //Lista de novedades empleado
            BL.NovedadesEmpleado.clsNovedadesEmpleado bl_clsNovedadesEmpleado = new BL.NovedadesEmpleado.clsNovedadesEmpleado();
            request.setAttribute("lstclsNovedadesEmpleado", bl_clsNovedadesEmpleado.getNovedadesEmpleado());

            //Listas desplegables
            BL.NovedadesEmpleado.clsEmpleado bl_clsEmpleado = new BL.NovedadesEmpleado.clsEmpleado();
            BL.NovedadesEmpleado.clsTipoNovedad bl_clsTipoNovedad = new BL.NovedadesEmpleado.clsTipoNovedad();

            request.setAttribute("lstclsEmpleado", bl_clsEmpleado.getEmpleado());
            request.setAttribute("lstclsTipoNovedad", bl_clsTipoNovedad.getTipoNovedad());

            request.getRequestDispatcher("NovedadesEmpleado/editarnovedadesempleado.jsp").forward(request, response);
        }
    }

    public void btnNoveEmplEliminar(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.NovedadesEmpleado.clsNovedadesEmpleado bl_clsNovedadesEmpleado = new BL.NovedadesEmpleado.clsNovedadesEmpleado();

            Modelos.NovedadesEmpleado.clsNovedadesEmpleado obclsNovedadesEmpleado = new Modelos.NovedadesEmpleado.clsNovedadesEmpleado();

            if (request.getParameter("IdModificar") != null) {
                obclsNovedadesEmpleado.setId_novedad_empleado(Integer.valueOf(request.getParameter("IdModificar")));
            }

            request.setAttribute("stMensaje", bl_clsNovedadesEmpleado.deleteNovedadesEmpleado(obclsNovedadesEmpleado));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsNovedadesEmpleado", bl_clsNovedadesEmpleado.getNovedadesEmpleado());

            request.getRequestDispatcher("NovedadesEmpleado/novedadesempleado.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            
            request.getRequestDispatcher("NovedadesEmpleado/eliminarnovedadesempleado.jsp").forward(request, response);
        }

    }

    public void btnNoveEmplBuscar(HttpServletRequest request,
            HttpServletResponse response)throws IOException, ServletException {
        try {
            BL.NovedadesEmpleado.clsNovedadesEmpleado bl_clsNovedadesEmpleados = new BL.NovedadesEmpleado.clsNovedadesEmpleado();
            
            Modelos.clsBuscar obclsBuscar = new Modelos.clsBuscar();
            
            if(request.getParameter("txtNoveEmplBuscar")!=null){
                obclsBuscar.setStBuscar(request.getParameter("txtNoveEmplBuscar"));
            }
            
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsNovedadesEmpleado", bl_clsNovedadesEmpleados.getBuscarNovedadesEmpleado(obclsBuscar));
            
            request.getRequestDispatcher("NovedadesEmpleado/novedadesempleado.jsp").forward(request, response);
            
        } catch (Exception ex) {
            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            
            request.getRequestDispatcher("NovedadesEmpleado/novedadesempleado.jsp").forward(request, response);
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
