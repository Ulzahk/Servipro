package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControlResponsableGrupo extends HttpServlet {

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
            if (request.getParameter("btnReGruGuardar") != null) {
                btnReGruGuardar(response, request);
                
            } else if (request.getParameter("btnReGruEditar") != null) {
                btnReGruEditar(response, request);

            } else if (request.getParameter("btnReGruEliminar") != null) {
                btnReGruEliminar(response, request);

            } else if (request.getParameter("btnReGruBuscar") != null) {
                btnReGruBuscar(response, request);

            } else if (request.getParameter("btnReGruConsultar") != null) {
                //Lista Responsables Grupo
                BL.ResponsableGrupo.clsResponsableGrupo bl_clsResponsableGrupo = new BL.ResponsableGrupo.clsResponsableGrupo();
                request.setAttribute("lstclsResponsableGrupo", bl_clsResponsableGrupo.getResponsableGrupo());

                request.getRequestDispatcher("responsablegrupo.jsp").forward(request, response);
            } else if (request.getParameter("codigoSeleccionado") != null) {
                if (request.getParameter("stOpcion").equals("M")) {
                    cargarReGruEditar(response, request);

                } else if (request.getParameter("stOpcion").equals("E")) {
                     cargarReGruEliminar(response, request);

                }
            } else if (request.getParameter("btnReGruAgregar") != null) {
                //Lista Usuario y Grupo
                BL.ResponsableGrupo.clsGrupo bl_clsGrupo = new BL.ResponsableGrupo.clsGrupo();
                BL.ResponsableGrupo.clsUsuario bl_clsUsuario = new BL.ResponsableGrupo.clsUsuario();

                request.setAttribute("lstclsGrupo", bl_clsGrupo.getGrupo());
                request.setAttribute("lstclsUsuario", bl_clsUsuario.getUsuario());

                request.getRequestDispatcher("agregarresponsablegrupo.jsp").forward(request, response);

            }
        }
    }

    public void btnReGruGuardar(HttpServletResponse response,
            HttpServletRequest request) throws IOException, ServletException {

        try {
            BL.ResponsableGrupo.clsResponsableGrupo bl_clsResponsableGrupo = new BL.ResponsableGrupo.clsResponsableGrupo();

            Modelos.ResponsableGrupo.clsResponsableGrupo obclsResponsableGrupo = new Modelos.ResponsableGrupo.clsResponsableGrupo();
            Modelos.ResponsableGrupo.clsGrupo obclsGrupo = new Modelos.ResponsableGrupo.clsGrupo();
            Modelos.ResponsableGrupo.clsUsuario obclsUsuario = new Modelos.ResponsableGrupo.clsUsuario();

            if (request.getParameter("ddlGrupo") != null) {
                obclsGrupo.setId_grupo(Integer.parseInt(request.getParameter("ddlGrupo")));
                obclsResponsableGrupo.setObclsGrupo(obclsGrupo);
            }

            if (request.getParameter("ddlUsuario") != null) {
                obclsUsuario.setNro_usuario(Integer.parseInt(request.getParameter("ddlUsuario")));
                obclsResponsableGrupo.setObclsUsuario(obclsUsuario);
            }

            request.setAttribute("stMensaje", bl_clsResponsableGrupo.createResponsableGrupo(obclsResponsableGrupo));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsResponsableGrupo", bl_clsResponsableGrupo.getResponsableGrupo());

            request.getRequestDispatcher("responsablegrupo.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            //Lista Usuario y Grupo
            BL.ResponsableGrupo.clsGrupo bl_clsGrupo = new BL.ResponsableGrupo.clsGrupo();
            BL.ResponsableGrupo.clsUsuario bl_clsUsuario = new BL.ResponsableGrupo.clsUsuario();

            request.setAttribute("lstclsGrupo", bl_clsGrupo.getGrupo());
            request.setAttribute("lstclsUsuario", bl_clsUsuario.getUsuario());

            request.getRequestDispatcher("agregarresponsablegrupo.jsp").forward(request, response);

        }
    }

    public void btnReGruEditar(HttpServletResponse response, HttpServletRequest request)
            throws IOException, ServletException {

        try {
            BL.ResponsableGrupo.clsResponsableGrupo bl_clsResponsableGrupo = new BL.ResponsableGrupo.clsResponsableGrupo();
            Modelos.ResponsableGrupo.clsResponsableGrupo obclsResponsableGrupo = new Modelos.ResponsableGrupo.clsResponsableGrupo();

            Modelos.ResponsableGrupo.clsGrupo obclsGrupo = new Modelos.ResponsableGrupo.clsGrupo();
            Modelos.ResponsableGrupo.clsUsuario obclsUsuario = new Modelos.ResponsableGrupo.clsUsuario();

            if (request.getParameter("IdModificar") != null) {
                obclsResponsableGrupo.setId_responsable(Integer.valueOf(request.getParameter("IdModificar")));
            }

            if (request.getParameter("ddlGrupo") != null) {
                obclsGrupo.setId_grupo(Integer.parseInt(request.getParameter("ddlGrupo")));
                obclsResponsableGrupo.setObclsGrupo(obclsGrupo);
            }

            if (request.getParameter("ddlUsuario") != null) {
                obclsUsuario.setNro_usuario(Integer.parseInt(request.getParameter("ddlUsuario")));
                obclsResponsableGrupo.setObclsUsuario(obclsUsuario);
            }

            request.setAttribute("stMensaje", bl_clsResponsableGrupo.updateResponsableGrupo(obclsResponsableGrupo));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsResponsableGrupo", bl_clsResponsableGrupo.getResponsableGrupo());

            request.getRequestDispatcher("responsablegrupo.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            //Lista Responsables Grupo
            BL.ResponsableGrupo.clsResponsableGrupo bl_clsResponsableGrupo = new BL.ResponsableGrupo.clsResponsableGrupo();
            request.setAttribute("lstclsResponsableGrupo", bl_clsResponsableGrupo.getResponsableGrupo());

            //Lista Usuario y Grupo
            BL.ResponsableGrupo.clsGrupo bl_clsGrupo = new BL.ResponsableGrupo.clsGrupo();
            BL.ResponsableGrupo.clsUsuario bl_clsUsuario = new BL.ResponsableGrupo.clsUsuario();

            request.setAttribute("lstclsGrupo", bl_clsGrupo.getGrupo());
            request.setAttribute("lstclsUsuario", bl_clsUsuario.getUsuario());

            request.getRequestDispatcher("agregarresponsablegrupo.jsp").forward(request, response);

        }

    }

    public void btnReGruEliminar(HttpServletResponse response, HttpServletRequest request)
            throws IOException, ServletException {
        try {
            BL.ResponsableGrupo.clsResponsableGrupo bl_clsResponsableGrupo = new BL.ResponsableGrupo.clsResponsableGrupo();
            Modelos.ResponsableGrupo.clsResponsableGrupo obclsResponsableGrupo = new Modelos.ResponsableGrupo.clsResponsableGrupo();

            if (request.getParameter("IdModificar") != null) {
                obclsResponsableGrupo.setId_responsable(Integer.valueOf(request.getParameter("IdModificar")));
            }

            request.setAttribute("stMensaje", bl_clsResponsableGrupo.deleteResponsableGrupo(obclsResponsableGrupo));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsResponsableGrupo", bl_clsResponsableGrupo.getResponsableGrupo());

            request.getRequestDispatcher("responsablegrupo.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            request.getRequestDispatcher("responsablegrupo.jsp").forward(request, response);

        }

    }

    public void btnReGruBuscar(HttpServletResponse response, HttpServletRequest request)
            throws IOException, ServletException {

        try {
            BL.ResponsableGrupo.clsResponsableGrupo bl_clsResponsableGrupo = new BL.ResponsableGrupo.clsResponsableGrupo();
            Modelos.clsBuscar obclsBuscar = new Modelos.clsBuscar();

            if (request.getParameter("txtReGruBuscar") != null) {

                obclsBuscar.setStBuscar(request.getParameter("txtReGruBuscar"));
            }

            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsResponsableGrupo", bl_clsResponsableGrupo.getBuscarResponsableGrupo(obclsBuscar));

            request.getRequestDispatcher("responsablegrupo.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            request.getRequestDispatcher("responsablegrupo.jsp").forward(request, response);
        }

    }

    public void cargarReGruEditar(HttpServletResponse response, HttpServletRequest request)
            throws IOException, ServletException {

        try {

            BL.ResponsableGrupo.clsResponsableGrupo bl_clsResponsableGrupo = new BL.ResponsableGrupo.clsResponsableGrupo();
            
            List<Modelos.ResponsableGrupo.clsResponsableGrupo> lstclsResponsableGrupo = new ArrayList<Modelos.ResponsableGrupo.clsResponsableGrupo>();
            
            Modelos.ResponsableGrupo.clsResponsableGrupo obclsResponsableGrupo = new Modelos.ResponsableGrupo.clsResponsableGrupo();
            
            lstclsResponsableGrupo = bl_clsResponsableGrupo.getResponsableGrupo();

            for (Modelos.ResponsableGrupo.clsResponsableGrupo elem : lstclsResponsableGrupo) {

                if (elem.getId_responsable() == Integer.parseInt(request.getParameter("codigoSeleccionado"))) {
                    obclsResponsableGrupo = elem;
                    break;

                }
            }
            //Lista Usuario y Grupo
            BL.ResponsableGrupo.clsGrupo bl_clsGrupo = new BL.ResponsableGrupo.clsGrupo();
            BL.ResponsableGrupo.clsUsuario bl_clsUsuario = new BL.ResponsableGrupo.clsUsuario();

            request.setAttribute("lstclsGrupo", bl_clsGrupo.getGrupo());
            request.setAttribute("lstclsUsuario", bl_clsUsuario.getUsuario());

            request.setAttribute("obclsResponsableGrupo", obclsResponsableGrupo);
            request.setAttribute("lstclsResponsableGrupo", lstclsResponsableGrupo);

            request.getRequestDispatcher("editarresponsablegrupo.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            request.getRequestDispatcher("responsablegrupo.jsp").forward(request, response);
        }

    }

    public void cargarReGruEliminar(HttpServletResponse response, HttpServletRequest request)
            throws IOException, ServletException {

        try {
            BL.ResponsableGrupo.clsResponsableGrupo bl_clsResponsableGrupo = new BL.ResponsableGrupo.clsResponsableGrupo();
            List<Modelos.ResponsableGrupo.clsResponsableGrupo> lstclsResponsableGrupo = new ArrayList<Modelos.ResponsableGrupo.clsResponsableGrupo>();
            Modelos.ResponsableGrupo.clsResponsableGrupo obclsResponsableGrupo = new Modelos.ResponsableGrupo.clsResponsableGrupo();
            lstclsResponsableGrupo = bl_clsResponsableGrupo.getResponsableGrupo();

            for (Modelos.ResponsableGrupo.clsResponsableGrupo elem : lstclsResponsableGrupo) {

                if (elem.getId_responsable() == Integer.parseInt(request.getParameter("codigoSeleccionado"))) {
                    obclsResponsableGrupo = elem;
                    break;

                }
            }
            //Lista Usuario y Grupo
            BL.ResponsableGrupo.clsGrupo bl_clsGrupo = new BL.ResponsableGrupo.clsGrupo();
            BL.ResponsableGrupo.clsUsuario bl_clsUsuario = new BL.ResponsableGrupo.clsUsuario();

            request.setAttribute("lstclsGrupo", bl_clsGrupo.getGrupo());
            request.setAttribute("lstclsUsuario", bl_clsUsuario.getUsuario());

            request.setAttribute("obclsResponsableGrupo", obclsResponsableGrupo);
            request.setAttribute("lstclsResponsableGrupo", lstclsResponsableGrupo);

            request.getRequestDispatcher("eliminarresponsablegrupo.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            request.getRequestDispatcher("responsablegrupo.jsp").forward(request, response);
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
