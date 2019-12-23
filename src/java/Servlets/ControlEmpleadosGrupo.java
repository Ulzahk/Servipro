package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControlEmpleadosGrupo extends HttpServlet {

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
        if (request.getParameter("btnEmplGruConsultar") != null) {
            //Lista Empleados por Grupo
            BL.EmpleadosGrupo.clsEmpleadosGrupo bl_clsEmpleadosGrupo = new BL.EmpleadosGrupo.clsEmpleadosGrupo();
            request.setAttribute("lstclsEmpleadosGrupo", bl_clsEmpleadosGrupo.getEmpleadosGrupo());

            request.getRequestDispatcher("empleadosgrupo.jsp").forward(request, response);
        } else if (request.getParameter("btnEmplGruAgregar") != null) {
            //Lista desplegables
            BL.EmpleadosGrupo.clsGrupo bl_clsGrupo = new BL.EmpleadosGrupo.clsGrupo();
            BL.EmpleadosGrupo.clsEmpleado bl_clsEmpleado = new BL.EmpleadosGrupo.clsEmpleado();

            request.setAttribute("lstclsGrupo", bl_clsGrupo.getGrupo());
            request.setAttribute("lstclsEmpleado", bl_clsEmpleado.getEmpleado());

            request.getRequestDispatcher("agregarempleadosgrupo.jsp").forward(request, response);
        } else if (request.getParameter("btnEmplGruGuardar") != null) {
            btnEmplGruGuardar(request, response);
        } else if (request.getParameter("btnEmplGruBuscar") != null) {
            btnEmplGruBuscar(request, response);
        } else if (request.getParameter("codigoSeleccionado") != null) {
            if (request.getParameter("stOpcion").equals("M")) {
                cargarEmplGruEditar(request, response);
            } else if (request.getParameter("stOpcion").equals("E")) {
                cargarEmplGruEliminar(request, response);
            }
        } else if (request.getParameter("btnEmplGruEditar")!=null){
            btnEmplGruEditar(request, response);
        } else if (request.getParameter("btnEmplGruEliminar")!=null){
            btnEmplGruEliminar(request, response);
        }
    }

    public void btnEmplGruGuardar(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.EmpleadosGrupo.clsEmpleadosGrupo bl_clsEmpleadosGrupo = new BL.EmpleadosGrupo.clsEmpleadosGrupo();

            //Definición de Modelos
            Modelos.EmpleadosGrupo.clsEmpleadosGrupo obclsEmpleadosGrupo = new Modelos.EmpleadosGrupo.clsEmpleadosGrupo();

            Modelos.EmpleadosGrupo.clsGrupo obclsGrupo = new Modelos.EmpleadosGrupo.clsGrupo();
            Modelos.EmpleadosGrupo.clsEmpleado obclsEmpleado = new Modelos.EmpleadosGrupo.clsEmpleado();

            if (request.getParameter("ddlGrupo") != null) {
                obclsGrupo.setId_grupo(Integer.parseInt(request.getParameter("ddlGrupo")));
                obclsEmpleadosGrupo.setObclsGrupo(obclsGrupo);
            }

            if (request.getParameter("ddlEmpleado") != null) {
                obclsEmpleado.setEmplId(Integer.parseInt(request.getParameter("ddlEmpleado")));
                obclsEmpleadosGrupo.setObclsEmpleado(obclsEmpleado);
            }

            //Definición de Parametros del Controlador
            request.setAttribute("stMensaje", bl_clsEmpleadosGrupo.createEmpleadosGrupo(obclsEmpleadosGrupo));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsEmpleadosGrupo", bl_clsEmpleadosGrupo.getEmpleadosGrupo());

            //Redirección y envio de valores
            request.getRequestDispatcher("empleadosgrupo.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            //Lista desplegables
            BL.EmpleadosGrupo.clsGrupo bl_clsGrupo = new BL.EmpleadosGrupo.clsGrupo();
            BL.EmpleadosGrupo.clsEmpleado bl_clsEmpleado = new BL.EmpleadosGrupo.clsEmpleado();

            request.setAttribute("lstclsGrupo", bl_clsGrupo.getGrupo());
            request.setAttribute("lstclsEmpleado", bl_clsEmpleado.getEmpleado());

            request.getRequestDispatcher("agregarempleadosgrupo.jsp").forward(request, response);
        }
    }

    public void btnEmplGruBuscar(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        try {
            BL.EmpleadosGrupo.clsEmpleadosGrupo bl_clsEmpleadosGrupo = new BL.EmpleadosGrupo.clsEmpleadosGrupo();

            Modelos.clsBuscar obclsBuscar = new Modelos.clsBuscar();

            if (request.getParameter("txtEmplGruBuscar") != null) {
                obclsBuscar.setStBuscar(request.getParameter("txtEmplGruBuscar"));
            }

            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsEmpleadosGrupo", bl_clsEmpleadosGrupo.getBuscarEmpleadosGrupo(obclsBuscar));

            request.getRequestDispatcher("empleadosgrupo.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            request.getRequestDispatcher("empleadosgrupo.jsp").forward(request, response);
        }
    }

    public void cargarEmplGruEditar(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        try {
            BL.EmpleadosGrupo.clsEmpleadosGrupo bl_clsEmpleadosGrupo = new BL.EmpleadosGrupo.clsEmpleadosGrupo();

            List<Modelos.EmpleadosGrupo.clsEmpleadosGrupo> lstclsEmpleadosGrupo = new ArrayList<Modelos.EmpleadosGrupo.clsEmpleadosGrupo>();

            Modelos.EmpleadosGrupo.clsEmpleadosGrupo obclsEmpleadosGrupo = new Modelos.EmpleadosGrupo.clsEmpleadosGrupo();

            lstclsEmpleadosGrupo = bl_clsEmpleadosGrupo.getEmpleadosGrupo();

            for (Modelos.EmpleadosGrupo.clsEmpleadosGrupo elem : lstclsEmpleadosGrupo) {
                if (elem.getId_empleados_grupo() == Integer.parseInt(request.getParameter("codigoSeleccionado"))) {
                    obclsEmpleadosGrupo = elem;
                    break;
                }
            }

            //Lista desplegables
            BL.EmpleadosGrupo.clsGrupo bl_clsGrupo = new BL.EmpleadosGrupo.clsGrupo();
            BL.EmpleadosGrupo.clsEmpleado bl_clsEmpleado = new BL.EmpleadosGrupo.clsEmpleado();

            request.setAttribute("lstclsGrupo", bl_clsGrupo.getGrupo());
            request.setAttribute("lstclsEmpleado", bl_clsEmpleado.getEmpleado());

            request.setAttribute("obclsEmpleadosGrupo", obclsEmpleadosGrupo);
            request.setAttribute("lstclsEmpleadosGrupo", lstclsEmpleadosGrupo);
            request.getRequestDispatcher("editarempleadosgrupo.jsp").forward(request, response);

        } catch (Exception ex) {
            
            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            request.getRequestDispatcher("empleadosgrupo.jsp").forward(request, response);
        }

    }
    
    public void cargarEmplGruEliminar(HttpServletRequest request,
            HttpServletResponse response)throws IOException, ServletException{
        try {
            BL.EmpleadosGrupo.clsEmpleadosGrupo bl_clsEmpleadosGrupo = new BL.EmpleadosGrupo.clsEmpleadosGrupo();

            List<Modelos.EmpleadosGrupo.clsEmpleadosGrupo> lstclsEmpleadosGrupo = new ArrayList<Modelos.EmpleadosGrupo.clsEmpleadosGrupo>();

            Modelos.EmpleadosGrupo.clsEmpleadosGrupo obclsEmpleadosGrupo = new Modelos.EmpleadosGrupo.clsEmpleadosGrupo();

            lstclsEmpleadosGrupo = bl_clsEmpleadosGrupo.getEmpleadosGrupo();

            for (Modelos.EmpleadosGrupo.clsEmpleadosGrupo elem : lstclsEmpleadosGrupo) {
                if (elem.getId_empleados_grupo() == Integer.parseInt(request.getParameter("codigoSeleccionado"))) {
                    obclsEmpleadosGrupo = elem;
                    break;
                }
            }
            
            request.setAttribute("obclsEmpleadosGrupo", obclsEmpleadosGrupo);
            request.setAttribute("lstclsEmpleadosGrupo", lstclsEmpleadosGrupo);
            request.getRequestDispatcher("eliminarempleadosgrupo.jsp").forward(request, response);
            
        } catch (Exception ex) {
            
            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            request.getRequestDispatcher("empleadosgrupo.jsp").forward(request, response);
        }
    }
    
    public void btnEmplGruEditar(HttpServletRequest request,
            HttpServletResponse response)throws IOException, ServletException{
        try {
            BL.EmpleadosGrupo.clsEmpleadosGrupo bl_clsEmpleadosGrupo = new BL.EmpleadosGrupo.clsEmpleadosGrupo();
            
            Modelos.EmpleadosGrupo.clsEmpleadosGrupo obclsEmpleadosGrupo = new Modelos.EmpleadosGrupo.clsEmpleadosGrupo();
            
            Modelos.EmpleadosGrupo.clsGrupo obclsGrupo = new Modelos.EmpleadosGrupo.clsGrupo();
            Modelos.EmpleadosGrupo.clsEmpleado obclsEmpleado = new Modelos.EmpleadosGrupo.clsEmpleado();
            
            if(request.getParameter("IdModificar")!=null){
                obclsEmpleadosGrupo.setId_empleados_grupo(Integer.valueOf(request.getParameter("IdModificar")));
            }
            
            if (request.getParameter("ddlGrupo") != null) {
                obclsGrupo.setId_grupo(Integer.parseInt(request.getParameter("ddlGrupo")));
                obclsEmpleadosGrupo.setObclsGrupo(obclsGrupo);
            }

            if (request.getParameter("ddlEmpleado") != null) {
                obclsEmpleado.setEmplId(Integer.parseInt(request.getParameter("ddlEmpleado")));
                obclsEmpleadosGrupo.setObclsEmpleado(obclsEmpleado);
            }
            
            //Definición de Parametros del Controlador
            request.setAttribute("stMensaje", bl_clsEmpleadosGrupo.updateEmpleadosGrupo(obclsEmpleadosGrupo));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsEmpleadosGrupo", bl_clsEmpleadosGrupo.getEmpleadosGrupo());

            //Redirección y envio de valores
            request.getRequestDispatcher("empleadosgrupo.jsp").forward(request, response);
        } catch (Exception ex) {
            
            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            
             //Lista Empleados por Grupo
            BL.EmpleadosGrupo.clsEmpleadosGrupo bl_clsEmpleadosGrupo = new BL.EmpleadosGrupo.clsEmpleadosGrupo();
            request.setAttribute("lstclsEmpleadosGrupo", bl_clsEmpleadosGrupo.getEmpleadosGrupo());

            //Lista desplegables
            BL.EmpleadosGrupo.clsGrupo bl_clsGrupo = new BL.EmpleadosGrupo.clsGrupo();
            BL.EmpleadosGrupo.clsEmpleado bl_clsEmpleado = new BL.EmpleadosGrupo.clsEmpleado();

            request.setAttribute("lstclsGrupo", bl_clsGrupo.getGrupo());
            request.setAttribute("lstclsEmpleado", bl_clsEmpleado.getEmpleado());

            request.getRequestDispatcher("editarempleadosgrupo.jsp").forward(request, response);
        }
        
    }
    
    public void btnEmplGruEliminar(HttpServletRequest request,
            HttpServletResponse response)throws IOException, ServletException{
        
        try {
            BL.EmpleadosGrupo.clsEmpleadosGrupo bl_clsEmpleadosGrupo = new BL.EmpleadosGrupo.clsEmpleadosGrupo();
            
            Modelos.EmpleadosGrupo.clsEmpleadosGrupo obclsEmpleadosGrupo = new Modelos.EmpleadosGrupo.clsEmpleadosGrupo();

            if(request.getParameter("IdModificar")!=null){
                obclsEmpleadosGrupo.setId_empleados_grupo(Integer.valueOf(request.getParameter("IdModificar")));
            }

            //Definición de Parametros del Controlador
            request.setAttribute("stMensaje", bl_clsEmpleadosGrupo.deleteEmpleadosGrupo(obclsEmpleadosGrupo));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsEmpleadosGrupo", bl_clsEmpleadosGrupo.getEmpleadosGrupo());

            //Redirección y envio de valores
            request.getRequestDispatcher("empleadosgrupo.jsp").forward(request, response);
            
        } catch (Exception ex) {
            
            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            
            request.getRequestDispatcher("eliminarempleadosgrupo.jsp").forward(request, response);
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
