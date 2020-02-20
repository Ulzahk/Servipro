package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControlEmpleados extends HttpServlet {

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
        //Validación Botones
        if (request.getParameter("btnEmplGuardar") != null) {
            btnEmplGuardar(request, response);
        } else if (request.getParameter("btnEmplEditar") != null) {
            btnEmplEditar(request, response);
        } else if (request.getParameter("btnEmplEliminar") != null) {
            btnEmplEliminar(request, response);
        } else if (request.getParameter("codigoSeleccionado") != null) {
            if (request.getParameter("stOpcion").equals("M")) {
                cargarEmplEditar(request, response);
            } else if (request.getParameter("stOpcion").equals("E")) {
                cargarEmplEliminar(request, response);
            }
        } else if (request.getParameter("btnEmplConsultar") != null) {
            BL.Empleados.clsEmpleado bl_clsEmpleado = new BL.Empleados.clsEmpleado();
            request.setAttribute("lstclsEmpleado", bl_clsEmpleado.getEmpleado());

            request.getRequestDispatcher("Empleados/empleados.jsp").forward(request, response);
        } else if (request.getParameter("btnEmplAgregar") != null) {

            //Listas desplegables
            BL.Empleados.clsTipoDocumento bl_clsTipoDocumento = new BL.Empleados.clsTipoDocumento();
            BL.Empleados.clsCentroCosto bl_clsCentroCosto = new BL.Empleados.clsCentroCosto();
            BL.Empleados.clsCargo bl_clsCargo = new BL.Empleados.clsCargo();

            request.setAttribute("lstclsTipoDocumento", bl_clsTipoDocumento.getTipoDocumento());
            request.setAttribute("lstclsCentroCosto", bl_clsCentroCosto.getCentroCosto());
            request.setAttribute("lstclsCargo", bl_clsCargo.getCargo());

            request.getRequestDispatcher("Empleados/agregarempleados.jsp").forward(request, response);
        } else if (request.getParameter("btnEmplBuscar") != null) {
            btnEmplBuscar(request, response);
        } else if (request.getParameter("btnImportarDatos") != null) {
            btnImportarRedi(request, response);
        }
    }

    public void btnEmplGuardar(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        try {
            BL.Empleados.clsEmpleado bl_clsEmpleado = new BL.Empleados.clsEmpleado();

            //Definición de Modelos
            Modelos.Empleados.clsEmpleado obclsEmpleado = new Modelos.Empleados.clsEmpleado();

            Modelos.Empleados.clsTipoDocumento obclsTipoDocumento = new Modelos.Empleados.clsTipoDocumento();
            Modelos.Empleados.clsCentroCosto obclsCentroCosto = new Modelos.Empleados.clsCentroCosto();
            Modelos.Empleados.clsCargo obclsCargo = new Modelos.Empleados.clsCargo();

            if (request.getParameter("ddlTipoDocumento") != null) {
                //Modelo Externo
                obclsTipoDocumento.setInId(Integer.parseInt(request.getParameter("ddlTipoDocumento")));
                //Asignación al modelo padre
                obclsEmpleado.setObclsTipoDocumento(obclsTipoDocumento);
            }

            if (request.getParameter("txtDocumento") != null) {
                obclsEmpleado.setStDocumento(request.getParameter("txtDocumento"));
            }
            if (request.getParameter("txtPrimerNombre") != null) {
                obclsEmpleado.setStPrimerNombre(request.getParameter("txtPrimerNombre"));
            }
            if (request.getParameter("txtSegundoNombre") != null) {
                obclsEmpleado.setStSegundoNombre(request.getParameter("txtSegundoNombre"));
            }
            if (request.getParameter("txtPrimerApellido") != null) {
                obclsEmpleado.setStPrimerApellido(request.getParameter("txtPrimerApellido"));
            }
            if (request.getParameter("txtSegundoApellido") != null) {
                obclsEmpleado.setStSegundoApellido(request.getParameter("txtSegundoApellido"));
            }

            if (request.getParameter("txtTelefono") != null) {
                obclsEmpleado.setStTelefono(request.getParameter("txtTelefono"));
            }

            if (request.getParameter("ddlCentroCosto") != null) {
                obclsCentroCosto.setInId(Integer.parseInt(request.getParameter("ddlCentroCosto")));

                obclsEmpleado.setObclsCentroCosto(obclsCentroCosto);
            }

            if (request.getParameter("ddlCargo") != null) {
                obclsCargo.setInId(Integer.parseInt(request.getParameter("ddlCargo")));

                obclsEmpleado.setObclsCargo(obclsCargo);
            }

            //Definición de parametros desde el controlador
            request.setAttribute("stMensaje", bl_clsEmpleado.createEmpleado(obclsEmpleado));
            if (request.getAttribute("stMensaje").equals("Se realizo el proceso con exito")) {
                request.setAttribute("stTipo", "success");
            }

            if (request.getAttribute("stMensaje") != ("Se realizó el proceso con éxito")) {
                request.setAttribute("stTipo", "error");
            }
            request.setAttribute("lstclsEmpleado", bl_clsEmpleado.getEmpleado());

            //Redireccion y envio de valores
            request.getRequestDispatcher("Empleados/empleados.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            //Listas desplegables
            BL.Empleados.clsTipoDocumento bl_clsTipoDocumento = new BL.Empleados.clsTipoDocumento();
            BL.Empleados.clsCentroCosto bl_clsCentroCosto = new BL.Empleados.clsCentroCosto();
            BL.Empleados.clsCargo bl_clsCargo = new BL.Empleados.clsCargo();

            request.setAttribute("lstclsTipoDocumento", bl_clsTipoDocumento.getTipoDocumento());
            request.setAttribute("lstclsCentroCosto", bl_clsCentroCosto.getCentroCosto());
            request.setAttribute("lstclsCargo", bl_clsCargo.getCargo());

            request.getRequestDispatcher("Empleados/agregarempleados.jsp").forward(request, response);
        }
    }

    public void cargarEmplEditar(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        try {
            BL.Empleados.clsEmpleado bl_clsEmpleado = new BL.Empleados.clsEmpleado();
            //Lista de objetos donde esta la información guardada
            List<Modelos.Empleados.clsEmpleado> lstclsEmpleado = new ArrayList<Modelos.Empleados.clsEmpleado>();
            //Modelo que se esta trabajando
            Modelos.Empleados.clsEmpleado obclsEmpleado = new Modelos.Empleados.clsEmpleado();

            lstclsEmpleado = bl_clsEmpleado.getEmpleado();

            for (Modelos.Empleados.clsEmpleado elem : lstclsEmpleado) {
                if (elem.getInId() == Integer.parseInt(request.getParameter("codigoSeleccionado"))) {
                    obclsEmpleado = elem;
                    break;
                }
            }

            //Listas desplegables
            BL.Empleados.clsTipoDocumento bl_clsTipoDocumento = new BL.Empleados.clsTipoDocumento();
            BL.Empleados.clsCentroCosto bl_clsCentroCosto = new BL.Empleados.clsCentroCosto();
            BL.Empleados.clsCargo bl_clsCargo = new BL.Empleados.clsCargo();

            request.setAttribute("lstclsTipoDocumento", bl_clsTipoDocumento.getTipoDocumento());
            request.setAttribute("lstclsCentroCosto", bl_clsCentroCosto.getCentroCosto());
            request.setAttribute("lstclsCargo", bl_clsCargo.getCargo());

            request.setAttribute("obclsEmpleado", obclsEmpleado);
            request.setAttribute("lstclsEmpleado", lstclsEmpleado);
            request.getRequestDispatcher("Empleados/editarempleados.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            request.getRequestDispatcher("Empleados/empleados.jsp").forward(request, response);

        }

    }

    public void cargarEmplEliminar(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        try {
            BL.Empleados.clsEmpleado bl_clsEmpleado = new BL.Empleados.clsEmpleado();

            List<Modelos.Empleados.clsEmpleado> lstclsEmpleado = new ArrayList<Modelos.Empleados.clsEmpleado>();

            Modelos.Empleados.clsEmpleado obclsEmpleado = new Modelos.Empleados.clsEmpleado();

            lstclsEmpleado = bl_clsEmpleado.getEmpleado();

            for (Modelos.Empleados.clsEmpleado elem : lstclsEmpleado) {
                if (elem.getInId() == Integer.parseInt(request.getParameter("codigoSeleccionado"))) {
                    obclsEmpleado = elem;
                    break;
                }
            }

            request.setAttribute("obclsEmpleado", obclsEmpleado);
            request.setAttribute("lstclsEmpleado", lstclsEmpleado);
            request.getRequestDispatcher("Empleados/eliminarempleados.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            request.getRequestDispatcher("Empleados/empleados.jsp").forward(request, response);
        }

    }

    public void btnEmplEditar(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        try {

            BL.Empleados.clsEmpleado bl_clsEmpleado = new BL.Empleados.clsEmpleado();

            //Definición de Modelos
            Modelos.Empleados.clsEmpleado obclsEmpleado = new Modelos.Empleados.clsEmpleado();

            Modelos.Empleados.clsTipoDocumento obclsTipoDocumento = new Modelos.Empleados.clsTipoDocumento();
            Modelos.Empleados.clsCentroCosto obclsCentroCosto = new Modelos.Empleados.clsCentroCosto();
            Modelos.Empleados.clsCargo obclsCargo = new Modelos.Empleados.clsCargo();

            //Asignación de atributos o propiedades
            //Asignación de atributos o propiedades
            if (request.getParameter("IdModificar") != null) {
                obclsEmpleado.setInId(Integer.valueOf(request.getParameter("IdModificar")));
            }
            if (request.getParameter("ddlTipoDocumento") != null) {
                //Modelo Externo
                obclsTipoDocumento.setInId(Integer.parseInt(request.getParameter("ddlTipoDocumento")));
                //Asignación al modelo padre
                obclsEmpleado.setObclsTipoDocumento(obclsTipoDocumento);
            }

            if (request.getParameter("txtDocumento") != null) {
                obclsEmpleado.setStDocumento(request.getParameter("txtDocumento"));
            }
            if (request.getParameter("txtPrimerNombre") != null) {
                obclsEmpleado.setStPrimerNombre(request.getParameter("txtPrimerNombre"));
            }
            if (request.getParameter("txtSegundoNombre") != null) {
                obclsEmpleado.setStSegundoNombre(request.getParameter("txtSegundoNombre"));
            }
            if (request.getParameter("txtPrimerApellido") != null) {
                obclsEmpleado.setStPrimerApellido(request.getParameter("txtPrimerApellido"));
            }
            if (request.getParameter("txtSegundoApellido") != null) {
                obclsEmpleado.setStSegundoApellido(request.getParameter("txtSegundoApellido"));
            }
            if (request.getParameter("txtTelefono") != null) {
                obclsEmpleado.setStTelefono(request.getParameter("txtTelefono"));
            }

            if (request.getParameter("ddlCentroCosto") != null) {
                obclsCentroCosto.setInId(Integer.parseInt(request.getParameter("ddlCentroCosto")));

                obclsEmpleado.setObclsCentroCosto(obclsCentroCosto);
            }

            if (request.getParameter("ddlCargo") != null) {
                obclsCargo.setInId(Integer.parseInt(request.getParameter("ddlCargo")));

                obclsEmpleado.setObclsCargo(obclsCargo);
            }

            //Definición de parametros desde el controlador
            request.setAttribute("stMensaje", bl_clsEmpleado.updateEmpleado(obclsEmpleado));
            if (request.getAttribute("stMensaje").equals("Se realizo el proceso con exito")) {
                request.setAttribute("stTipo", "success");
            }

            if (request.getAttribute("stMensaje") != ("Se realizó el proceso con éxito")) {
                request.setAttribute("stTipo", "error");
            }
            request.setAttribute("lstclsEmpleado", bl_clsEmpleado.getEmpleado());

            //Redireccion y envio de valores
            request.getRequestDispatcher("Empleados/empleados.jsp").forward(request, response);

        } catch (Exception ex) {
            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            //Lista de Empleados
            BL.Empleados.clsEmpleado bl_clsEmpleado = new BL.Empleados.clsEmpleado();
            request.setAttribute("lstclsEmpleado", bl_clsEmpleado.getEmpleado());

            //Listas desplegables
            BL.Empleados.clsTipoDocumento bl_clsTipoDocumento = new BL.Empleados.clsTipoDocumento();
            BL.Empleados.clsCentroCosto bl_clsCentroCosto = new BL.Empleados.clsCentroCosto();
            BL.Empleados.clsCargo bl_clsCargo = new BL.Empleados.clsCargo();

            request.setAttribute("lstclsTipoDocumento", bl_clsTipoDocumento.getTipoDocumento());
            request.setAttribute("lstclsCentroCosto", bl_clsCentroCosto.getCentroCosto());
            request.setAttribute("lstclsCargo", bl_clsCargo.getCargo());

            request.getRequestDispatcher("Empleados/editarempleados.jsp").forward(request, response);
        }
    }

    public void btnEmplEliminar(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {

            BL.Empleados.clsEmpleado bl_clsEmpleado = new BL.Empleados.clsEmpleado();

            Modelos.Empleados.clsEmpleado obclsEmpleado = new Modelos.Empleados.clsEmpleado();

            if (request.getParameter("IdModificar") != null) {
                obclsEmpleado.setInId(Integer.valueOf(request.getParameter("IdModificar")));
            }

            request.setAttribute("stMensaje", bl_clsEmpleado.deleteEmpleado(obclsEmpleado));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsEmpleado", bl_clsEmpleado.getEmpleado());

            request.getRequestDispatcher("Empleados/empleados.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stTipo", "error");
            request.setAttribute("stMensaje", ex.getMessage());

            request.getRequestDispatcher("Empleados/empleados.jsp").forward(request, response);
        }
    }

    public void btnEmplBuscar(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Empleados.clsEmpleado bl_clsEmpleado = new BL.Empleados.clsEmpleado();

            Modelos.Empleados.clsBuscar obclsBuscar = new Modelos.Empleados.clsBuscar();

            if (request.getParameter("txtEmplBuscar") != null) {
                obclsBuscar.setStBuscar(request.getParameter("txtEmplBuscar"));
            }

            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsEmpleado", bl_clsEmpleado.getBuscarEmpleado(obclsBuscar));

            request.getRequestDispatcher("Empleados/empleados.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stTipo", "error");
            request.setAttribute("stMensaje", ex.getMessage());

            request.getRequestDispatcher("Empleados/empleados.jsp").forward(request, response);

        }
    }

    public void btnImportarRedi(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            request.getRequestDispatcher("Empleados/importararchivosexcel.jsp").forward(request, response);
        } catch (Exception e) {
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
