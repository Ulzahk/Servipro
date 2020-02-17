package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControlPraEmpleados extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        if (request.getParameter("btnGuardar") != null) {
            btnGuardar(request, response);
        } else if (request.getParameter("btnAgregar") != null) {
            request.getRequestDispatcher("PraEmpleados/praempleados.jsp").forward(request, response);
        }
    }

    public void btnGuardar(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        try {

            BL.PraEmpleados.clsPraEmpleados bl_clsPraEmpleados = new BL.PraEmpleados.clsPraEmpleados();

            Modelos.PraEmpleados.clsPraEmpleados obclsPraEmpleados = new Modelos.PraEmpleados.clsPraEmpleados();

            String[] number = new String[10];
            for (int i = 0; i < 10; i++) {
                number[i] = "number" + i;
            }

            String[] name = new String[10];
            for (int i = 0; i < 10; i++) {
                name[i] = "name" + i;
            }

            String[] password = new String[10];
            for (int i = 0; i < 10; i++) {
                password[i] = "password" + i;
            }

            for (int i = 0; i < 10; i++) {

                for (int j = 0; j < 10; j++) {
                    if(request.getParameter(number[i]) != null){
                        int control = Integer.parseInt(request.getParameter(number[i]));
                        if(control == 0){
                        i++;
                        break;
                        }
                    }
                }
                
                if (request.getParameter(number[i]) != null) {
                    obclsPraEmpleados.setId_praempleado(Integer.parseInt(request.getParameter(number[i])));
                }

                if (request.getParameter(name[i]) != null) {
                    obclsPraEmpleados.setNombre(request.getParameter(name[i]));
                }

                if (request.getParameter(password[i]) != null) {
                    obclsPraEmpleados.setContraseña(request.getParameter(password[i]));
                }

                request.setAttribute("stMensaje", bl_clsPraEmpleados.createPraEmpleado(obclsPraEmpleados));

            }
            if (request.getAttribute("stMensaje").equals("Se realizo el proceso con exito")) {
                request.setAttribute("stTipo", "success");
            }

            if (request.getAttribute("stMensaje") != ("Se realizó el proceso con éxito")) {
                request.setAttribute("stTipo", "error");
            }

            request.getRequestDispatcher("PraEmpleados/praempleados.jsp").forward(request, response);
        } catch (Exception ex) {
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
