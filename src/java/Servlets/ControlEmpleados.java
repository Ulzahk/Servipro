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
        if(request.getParameter("btnEmplGuardar")!=null){
            btnEmplGuardar(request, response);
        } else if(request.getParameter("btnEmplModificar")!=null){
            btnEmplModificar(request, response);
        } else if (request.getParameter("codigoSeleccionado")!=null){
            if(request.getParameter("stOpcion").equals("M")){
                cargarModificarEmpl(request, response);
            }else if (request.getParameter("stOpcion").equals("E")){
                btnEmplEliminar(request, response);
            }
        } else if(request.getParameter("btnEmplConsultar")!=null){
            BL.clsEmpleado bl_clsEmpleado = new BL.clsEmpleado();
            request.setAttribute("lstclsEmpleado", bl_clsEmpleado.getEmpleado());
            
            request.getRequestDispatcher("empleados.jsp").forward(request, response); 
        } else if(request.getParameter("btnEmplAgregar")!=null){
            
            //Listas desplegables
            BL.clsTipoDocumento bl_clsTipoDocumento = new BL.clsTipoDocumento();
            BL.clsCentroCosto bl_clsCentroCosto = new BL.clsCentroCosto();
            BL.clsCargo bl_clsCargo = new BL.clsCargo();
            
            request.setAttribute("lstclsTipoDocumento", bl_clsTipoDocumento.getTipoDocumento());
            request.setAttribute("lstclsCentroCosto", bl_clsCentroCosto.getCentroCosto());
            request.setAttribute("lstclsCargo", bl_clsCargo.getCargo());
            
            request.getRequestDispatcher("agregarempleados.jsp").forward(request, response);
        } else if (request.getParameter("btnEmplBuscar")!=null){
            btnEmplBuscar(request, response);
        }
    }
    
    public void btnEmplGuardar(HttpServletRequest request,
            HttpServletResponse response)throws ServletException, IOException{
        
        try {
            BL.clsEmpleado bl_clsEmpleado = new BL.clsEmpleado();
            
            //Definición de Modelos
            
            Modelos.clsEmpleado obclsEmpleado = new Modelos.clsEmpleado();
            
            Modelos.clsTipoDocumento obclsTipoDocumento = new Modelos.clsTipoDocumento();
            Modelos.clsCentroCosto obclsCentroCosto = new Modelos.clsCentroCosto();
            Modelos.clsCargo obclsCargo = new Modelos.clsCargo();
            
            if (request.getParameter("ddlTipoDocumento")!=null){
                //Modelo Externo
                obclsTipoDocumento.setInId(Integer.parseInt(request.getParameter("ddlTipoDocumento")));
                //Asignación al modelo padre
                obclsEmpleado.setObclsTipoDocumento(obclsTipoDocumento); 
            }
            
            if(request.getParameter("txtDocumento")!=null){
                obclsEmpleado.setStDocumento(request.getParameter("txtDocumento"));
            }
            if(request.getParameter("txtNombre")!=null){
                obclsEmpleado.setStNombre(request.getParameter("txtNombre"));
            }
            if(request.getParameter("txtTelefono")!=null){
                obclsEmpleado.setStTelefono(request.getParameter("txtTelefono"));
            }
            
            if(request.getParameter("ddlCentroCosto")!=null){
                obclsCentroCosto.setInId(Integer.parseInt(request.getParameter("ddlCentroCosto")));
                
                obclsEmpleado.setObclsCentroCosto(obclsCentroCosto);
            }
            
            if(request.getParameter("ddlCargo")!=null){
                obclsCargo.setInId(Integer.parseInt(request.getParameter("ddlCargo")));
                
                obclsEmpleado.setObclsCargo(obclsCargo);
            }
            
            //Definición de parametros desde el controlador
            request.setAttribute("stMensaje", bl_clsEmpleado.createEmpleado(obclsEmpleado));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsEmpleado", bl_clsEmpleado.getEmpleado());
            
            //Redireccion y envio de valores
            request.getRequestDispatcher("empleados.jsp").forward(request, response);
        } 
        catch (Exception ex) 
        {
            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            
            //Listas desplegables
            
            BL.clsTipoDocumento bl_clsTipoDocumento = new BL.clsTipoDocumento();
            BL.clsCentroCosto bl_clsCentroCosto = new BL.clsCentroCosto();
            BL.clsCargo bl_clsCargo = new BL.clsCargo();
            
            request.setAttribute("lstclsTipoDocumento", bl_clsTipoDocumento.getTipoDocumento());
            request.setAttribute("lstclsCentroCosto", bl_clsCentroCosto.getCentroCosto());
            request.setAttribute("lstclsCargo", bl_clsCargo.getCargo());
            
            request.getRequestDispatcher("agregarempleados.jsp").forward(request, response);
        }
    }
    
    public void cargarModificarEmpl(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException{
        try {
            BL.clsEmpleado bl_clsEmpleado = new BL.clsEmpleado();
            //Lista de objetos donde esta la información guardada
            List<Modelos.clsEmpleado> lstclsEmpleado = new ArrayList<Modelos.clsEmpleado>();
            //Modelo que se esta trabajando
            Modelos.clsEmpleado obclsEmpleado = new Modelos.clsEmpleado();
            
            lstclsEmpleado = bl_clsEmpleado.getEmpleado();
            
            for (Modelos.clsEmpleado elem: lstclsEmpleado){
                if(elem.getInId()== Integer.parseInt(request.getParameter("codigoSeleccionado"))){
                    obclsEmpleado = elem;
                    break;
                }
            }
            
             //Listas desplegables
            
            BL.clsTipoDocumento bl_clsTipoDocumento = new BL.clsTipoDocumento();
            BL.clsCentroCosto bl_clsCentroCosto = new BL.clsCentroCosto();
            BL.clsCargo bl_clsCargo = new BL.clsCargo();
            
            request.setAttribute("lstclsTipoDocumento", bl_clsTipoDocumento.getTipoDocumento());
            request.setAttribute("lstclsCentroCosto", bl_clsCentroCosto.getCentroCosto());
            request.setAttribute("lstclsCargo", bl_clsCargo.getCargo());
            
            request.setAttribute("obclsEmpleado", obclsEmpleado);
            request.setAttribute("lstclsEmpleado",lstclsEmpleado);
            request.getRequestDispatcher("editarempleados.jsp").forward(request, response);
            
        } catch (Exception ex) {
            
            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            request.getRequestDispatcher("empleados.jsp").forward(request, response);
            
        }
            
    }
    
    public void btnEmplModificar(HttpServletRequest request, 
            HttpServletResponse response)throws IOException, ServletException{
        try {
            
            BL.clsEmpleado bl_clsEmpleado = new BL.clsEmpleado();
            
            //Definición de Modelos
            
            Modelos.clsEmpleado obclsEmpleado = new Modelos.clsEmpleado();
            
            Modelos.clsTipoDocumento obclsTipoDocumento = new Modelos.clsTipoDocumento();
            Modelos.clsCentroCosto obclsCentroCosto = new Modelos.clsCentroCosto();
            Modelos.clsCargo obclsCargo = new Modelos.clsCargo();
            
            //Asignación de atributos o propiedades
            //Asignación de atributos o propiedades
            if(request.getParameter("IdModificar")!=null){
                obclsEmpleado.setInId(Integer.valueOf(request.getParameter("IdModificar")));
            }
            if (request.getParameter("ddlTipoDocumento")!=null){
                //Modelo Externo
                obclsTipoDocumento.setInId(Integer.parseInt(request.getParameter("ddlTipoDocumento")));
                //Asignación al modelo padre
                obclsEmpleado.setObclsTipoDocumento(obclsTipoDocumento); 
            }
            
            if(request.getParameter("txtDocumento")!=null){
                obclsEmpleado.setStDocumento(request.getParameter("txtDocumento"));
            }
            if(request.getParameter("txtNombre")!=null){
                obclsEmpleado.setStNombre(request.getParameter("txtNombre"));
            }
            if(request.getParameter("txtTelefono")!=null){
                obclsEmpleado.setStTelefono(request.getParameter("txtTelefono"));
            }
            
            if(request.getParameter("ddlCentroCosto")!=null){
                obclsCentroCosto.setInId(Integer.parseInt(request.getParameter("ddlCentroCosto")));
                
                obclsEmpleado.setObclsCentroCosto(obclsCentroCosto);
            }
            
            if(request.getParameter("ddlCargo")!=null){
                obclsCargo.setInId(Integer.parseInt(request.getParameter("ddlCargo")));
                
                obclsEmpleado.setObclsCargo(obclsCargo);
            }
            
            //Definición de parametros desde el controlador
            request.setAttribute("stMensaje", bl_clsEmpleado.updateEmpleado(obclsEmpleado));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsEmpleado", bl_clsEmpleado.getEmpleado());
            
            //Redireccion y envio de valores
            request.getRequestDispatcher("empleados.jsp").forward(request, response);
            
            
        } catch (Exception ex) {
            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo","error");
            
            //Lista de Empleados
            BL.clsEmpleado bl_clsEmpleado = new BL.clsEmpleado();
            request.setAttribute("lstclsEmpleado", bl_clsEmpleado.getEmpleado());
            
            //Listas desplegables
            BL.clsTipoDocumento bl_clsTipoDocumento = new BL.clsTipoDocumento();
            BL.clsCentroCosto bl_clsCentroCosto = new BL.clsCentroCosto();
            BL.clsCargo bl_clsCargo = new BL.clsCargo();
            
            request.setAttribute("lstclsTipoDocumento", bl_clsTipoDocumento.getTipoDocumento());
            request.setAttribute("lstclsCentroCosto", bl_clsCentroCosto.getCentroCosto());
            request.setAttribute("lstclsCargo", bl_clsCargo.getCargo());
            
            request.getRequestDispatcher("editarempleados.jsp").forward(request, response);
        }
    }
    
    public void btnEmplEliminar(HttpServletRequest request, 
            HttpServletResponse response)throws IOException, ServletException {
        
        try {
            
            BL.clsEmpleado bl_clsEmpleado = new BL.clsEmpleado();
            
            Modelos.clsEmpleado obclsEmpleado = new Modelos.clsEmpleado();
            
            if(request.getParameter("codigoSeleccionado")!=null){
                obclsEmpleado.setInId(Integer.valueOf(request.getParameter("codigoSeleccionado")));
            }
            
            request.setAttribute("stMensaje", bl_clsEmpleado.deleteEmpleado(obclsEmpleado));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsEmpleado", bl_clsEmpleado.getEmpleado());
            
            request.getRequestDispatcher("empleados.jsp").forward(request, response);
            
        } 
        catch (Exception ex) {
            
            request.setAttribute("stTipo", "error");
            request.setAttribute("stMensaje", ex.getMessage());
            
            request.getRequestDispatcher("empleados.jsp").forward(request, response);
        }
    }
    
    public void btnEmplBuscar (HttpServletRequest request,
            HttpServletResponse response)throws IOException, ServletException{
        
        try {
                BL.clsEmpleado bl_clsEmpleado = new BL.clsEmpleado();
                
                Modelos.clsBuscar obclsBuscar = new Modelos.clsBuscar();
                
                if(request.getParameter("txtEmplBuscar")!=null){
                    obclsBuscar.setStBuscar(request.getParameter("txtEmplBuscar"));
                }
                
                request.setAttribute("stTipo", "success");
                request.setAttribute("lstclsEmpleado", bl_clsEmpleado.getBuscarEmpleado(obclsBuscar));
                
                request.getRequestDispatcher("empleados.jsp").forward(request, response);
                
        } catch (Exception ex) {
            
            request.setAttribute("stTipo", "error");
            request.setAttribute("stMensaje", ex.getMessage());
            
            request.getRequestDispatcher("empleados.jsp").forward(request, response);
            
            
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
