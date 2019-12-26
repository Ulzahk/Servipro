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
public class ControlModulosPerfil extends HttpServlet {

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
        
        if (request.getParameter ("btnModPerfilGuardar")!= null){
            btnModPerfilGuardar(request, response);
        }else if (request.getParameter("btnModPerfilEditar")!= null){
            btnModPerfilEditar(request, response);
        }else if (request.getParameter("btnModPerfilEliminar")!= null){
            btnModPerfilEliminar(request, response);
        }else if (request.getParameter("codigoSeleccionado")!= null){
            if(request.getParameter("stOpcion").equals("M")){
                cargarModPerfilEditar(request, response);
            }else if (request.getParameter("stOpcion").equals("E")){
                cargarModPerfilEliminar(request, response);
            }
        }else if (request.getParameter("btnModPerfilConsultar")!= null){
            BL.ModelosPerfil.clsModulosPerfil bl_clsModulosPerfil = new BL.ModelosPerfil.clsModulosPerfil();
            request.setAttribute("lstclsModulosPerfil", bl_clsModulosPerfil.getModulosPerfil());
            
            request.getRequestDispatcher("ModulosPerfil/modulosperfil.jsp").forward(request, response);
        }else if (request.getParameter("btnModPerfilAgregar")!= null){
            
            //Listas desplegables
            BL.ModelosPerfil.clsModulos bl_clsModulos = new BL.ModelosPerfil.clsModulos();
            BL.ModelosPerfil.clsPerfil bl_clsPerfil = new BL.ModelosPerfil.clsPerfil();
            
            request.setAttribute("lstclsModulos", bl_clsModulos.getModulos());
            request.setAttribute("lstclsPerfil", bl_clsPerfil.getPerfil());
            
            request.getRequestDispatcher("ModulosPerfil/agregarmodulosperfil.jsp").forward(request, response);
        }else if (request.getParameter("btnModPerfilBuscar")!= null){
            btnModPerfilBuscar(request, response);
        }      
    }
    
    public void btnModPerfilGuardar (HttpServletRequest request,
            HttpServletResponse response) throws IOException , ServletException{
        
        try {
            BL.ModelosPerfil.clsModulosPerfil bl_clsModulosPerfil = new BL.ModelosPerfil.clsModulosPerfil();
            
            //Definición de Modelos
            Modelos.ModulosPerfil.clsModulosPerfil obclsModulosPerfil = new Modelos.ModulosPerfil.clsModulosPerfil();
            Modelos.ModulosPerfil.clsModulo obclsModulos = new Modelos.ModulosPerfil.clsModulo();
            Modelos.ModulosPerfil.clsPerfil obclsPerfil = new Modelos.ModulosPerfil.clsPerfil();
            
            if(request.getParameter("ddlModulo") != null){
                //Modelo Externo
                obclsModulos.setId_modulo(Integer.parseInt(request.getParameter("ddlModulo")));
                //Asignación al modelo padre
                obclsModulosPerfil.setObclsModulo(obclsModulos);
            }

            if (request.getParameter("ddlPerfil")!= null){
                //Modelo Externo
                obclsPerfil.setId_perfil(Integer.parseInt(request.getParameter("ddlPerfil")));
                //Asignación al modelo padre
                obclsModulosPerfil.setObclsPerfil(obclsPerfil);
            }
            
            //Definición de parametros desde el controlador 
            request.setAttribute("stMensaje", bl_clsModulosPerfil.createModuloPerfil(obclsModulosPerfil));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsModulosPerfil", bl_clsModulosPerfil.getModulosPerfil());
            
            //Redirección y envio de valores
            request.getRequestDispatcher("ModulosPerfil/modulosperfil.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            
            //Listas desplegables
            BL.ModelosPerfil.clsModulos bl_clsModulos = new BL.ModelosPerfil.clsModulos();
            BL.ModelosPerfil.clsPerfil bl_clsPerfil = new BL.ModelosPerfil.clsPerfil();
            
            request.setAttribute("lstclsModulos", bl_clsModulos.getModulos());
            request.setAttribute("lstclsPerfil", bl_clsPerfil.getPerfil());
            request.getRequestDispatcher("ModulosPerfil/agregarmodulosperfil.jsp").forward(request, response);
        }
    }
    
    public void cargarModPerfilEditar (HttpServletRequest request,
            HttpServletResponse response)throws IOException, ServletException {
        try {
            BL.ModelosPerfil.clsModulosPerfil bl_clsModulosPerfil = new BL.ModelosPerfil.clsModulosPerfil();
            //Lista de objetos donde esta la información guardada
            List<Modelos.ModulosPerfil.clsModulosPerfil> lstclsModulosPerfil = new ArrayList<Modelos.ModulosPerfil.clsModulosPerfil>();
            //Modelo que se esta trabajando
            Modelos.ModulosPerfil.clsModulosPerfil obclsModulosPerfil = new Modelos.ModulosPerfil.clsModulosPerfil();
            
            lstclsModulosPerfil = bl_clsModulosPerfil.getModulosPerfil();
            
            for (Modelos.ModulosPerfil.clsModulosPerfil elem : lstclsModulosPerfil){
                if(elem.getId_modulos_perfil() == Integer.parseInt(request.getParameter("codigoSeleccionado"))){
                    obclsModulosPerfil = elem;
                    break;
                }
            }
            
            //Listas desplegables
            BL.ModelosPerfil.clsModulos bl_clsModulos = new BL.ModelosPerfil.clsModulos();
            BL.ModelosPerfil.clsPerfil bl_clsPerfil = new BL.ModelosPerfil.clsPerfil();
            
            request.setAttribute("lstclsModulos", bl_clsModulos.getModulos());
            request.setAttribute("lstclsPerfil", bl_clsPerfil.getPerfil());
            
            request.setAttribute("obclsModulosPerfil", obclsModulosPerfil);
            request.setAttribute("lstclsModulosPerfil", lstclsModulosPerfil);
            request.getRequestDispatcher("ModulosPerfil/editarmodulosperfil.jsp").forward(request, response);
            
        } catch (Exception ex) {
            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            request.getRequestDispatcher("ModulosPerfil/modulosperfil.jsp").forward(request, response);
        }
    }
    
    public void cargarModPerfilEliminar(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException{
        try {
            BL.ModelosPerfil.clsModulosPerfil bl_clsModulosPerfil = new BL.ModelosPerfil.clsModulosPerfil();
            List<Modelos.ModulosPerfil.clsModulosPerfil> lstclsModulosPerfil = new ArrayList<Modelos.ModulosPerfil.clsModulosPerfil>();
            Modelos.ModulosPerfil.clsModulosPerfil obclsModulosPerfil = new Modelos.ModulosPerfil.clsModulosPerfil();
            lstclsModulosPerfil = bl_clsModulosPerfil.getModulosPerfil();
            
            for(Modelos.ModulosPerfil.clsModulosPerfil elem: lstclsModulosPerfil){
                if(elem.getId_modulos_perfil() == Integer.parseInt(request.getParameter("codigoSeleccionado"))){
                    obclsModulosPerfil = elem;
                    break;
                }
            }
            
            request.setAttribute("obclsModulosPerfil", obclsModulosPerfil);
            request.setAttribute("lstclsModulosPerfil", lstclsModulosPerfil);
            request.getRequestDispatcher("ModulosPerfil/eliminarmodulosperfil.jsp").forward(request, response);
            
        } catch (Exception ex) {
            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            request.getRequestDispatcher("ModulosPerfil/modulosperfil.jsp").forward(request, response);
        }
    }
    
    public void btnModPerfilEditar (HttpServletRequest request,
            HttpServletResponse response)throws IOException, ServletException{
        try {
            BL.ModelosPerfil.clsModulosPerfil bl_clsModulosPerfil = new BL.ModelosPerfil.clsModulosPerfil();
            //Definición de Modelos
            Modelos.ModulosPerfil.clsModulosPerfil obclsModulosPerfil = new Modelos.ModulosPerfil.clsModulosPerfil();
            Modelos.ModulosPerfil.clsModulo obclsModulo = new Modelos.ModulosPerfil.clsModulo();
            Modelos.ModulosPerfil.clsPerfil obclsPerfil = new Modelos.ModulosPerfil.clsPerfil();
            
            //Asignación de Atributos o Propiedades
            if(request.getParameter("IdModificar")!= null){
                obclsModulosPerfil.setId_modulos_perfil(Integer.valueOf(request.getParameter("IdModificar")));
            }
            if(request.getParameter("ddlModulo")!= null){
                //Modelo Externo
                obclsModulo.setId_modulo(Integer.parseInt(request.getParameter("ddlModulo")));
                //Asignación al modelo padre
                obclsModulosPerfil.setObclsModulo(obclsModulo);
            }
            if(request.getParameter("ddlPerfil")!= null){
                //Modelo Externo
                obclsPerfil.setId_perfil(Integer.parseInt(request.getParameter("ddlPerfil")));
                //Asignacion al modelo padre
                obclsModulosPerfil.setObclsPerfil(obclsPerfil);
            }
            
            //Definición de parametros desde el controlador 
            request.setAttribute("stMensaje", bl_clsModulosPerfil.UpdateModulosPerfil(obclsModulosPerfil));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsModulosPerfil", bl_clsModulosPerfil.getModulosPerfil());
            
            //Redirección y envio de valores
            request.getRequestDispatcher("ModulosPerfil/modulosperfil.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            
            //Lista de Empleados
            BL.ModelosPerfil.clsModulosPerfil bl_clsModulosPerfil = new BL.ModelosPerfil.clsModulosPerfil();
            request.setAttribute("lstclsModulosPerfil", bl_clsModulosPerfil.getModulosPerfil());
            
            //Listas desplegables
            BL.ModelosPerfil.clsModulos bl_clsModulos = new BL.ModelosPerfil.clsModulos();
            BL.ModelosPerfil.clsPerfil bl_clsPerfil = new BL.ModelosPerfil.clsPerfil();
            
            request.setAttribute("lstclsModulos", bl_clsModulos.getModulos());
            request.setAttribute("lstclsPerfil", bl_clsPerfil.getPerfil());
            
            request.getRequestDispatcher("ModulosPerfil/editarmodulosperfil.jsp").forward(request, response);
        }
    }
    
    public void btnModPerfilEliminar (HttpServletRequest request,
            HttpServletResponse response)throws IOException, ServletException{
        try {
            BL.ModelosPerfil.clsModulosPerfil bl_clsModulosPerfil = new BL.ModelosPerfil.clsModulosPerfil();
            Modelos.ModulosPerfil.clsModulosPerfil obclsModulosPerfil = new Modelos.ModulosPerfil.clsModulosPerfil();
            
            if(request.getParameter("IdModificar")!= null){
                obclsModulosPerfil.setId_modulos_perfil(Integer.valueOf(request.getParameter("IdModificar")));
            }
            
            request.setAttribute("stMensaje", bl_clsModulosPerfil.deleteModulosPerfil(obclsModulosPerfil));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsModulosPerfil", bl_clsModulosPerfil.getModulosPerfil());
            
            request.getRequestDispatcher("ModulosPerfil/modulosperfil.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("stTipo", "error");
            request.setAttribute("stMensaje", ex.getMessage());
            
            request.getRequestDispatcher("ModulosPerfil/eliminarmodulosperfil.jsp").forward(request, response);
        }
    }
    
    public void btnModPerfilBuscar (HttpServletRequest request,
            HttpServletResponse response)throws IOException,ServletException{
        try {
            BL.ModelosPerfil.clsModulosPerfil bl_clsModulosPerfil = new BL.ModelosPerfil.clsModulosPerfil();
            Modelos.Empleados.clsBuscar obclsBuscar = new Modelos.Empleados.clsBuscar();
            
            if(request.getParameter("txtModPerfilBuscar") != null){
                obclsBuscar.setStBuscar(request.getParameter("txtModPerfilBuscar"));
            }
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsModulosPerfil", bl_clsModulosPerfil.getBuscarModulosPerfil(obclsBuscar));
            
            request.getRequestDispatcher("ModulosPerfil/modulosperfil.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("stTipo", "error");
            request.setAttribute("stMensaje", ex.getMessage());
            
            request.getRequestDispatcher("ModulosPerfil/modulosperfil.jsp").forward(request, response);
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
