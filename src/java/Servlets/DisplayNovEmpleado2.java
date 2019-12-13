/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Controles.Conexion;

/**
 *
 * @author PRACTICANTE
 */
@WebServlet(name = "NovedadEmpleadoDelete", urlPatterns = {"/NovedadEmpleadoDelete"})
public class DisplayNovEmpleado2 extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NovedadEmpleadoDelete</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NovedadEmpleadoDelete at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
    public DisplayNovEmpleado2() {
        super();
        // TODO Auto-generated constructor stub
    }

//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doPost(request, response);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        Connection conn = null;
//
//        Statement st;
//        try {
////        Class.forName("com.mysql.jdbc.Driver");
////        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","pass");
//            conn = Conexion.conectar();
//
//            ArrayList al = null;
//            ArrayList userList = new ArrayList();
//            String query = "SELECT * FROM dbo.nm_novedades_empleado2";
//
//            st = conn.createStatement();
//            ResultSet rs = st.executeQuery(query);
//
//            while (rs.next()) {
//                al = new ArrayList();
//                al.add(rs.getInt(1));
//                al.add(rs.getInt(2));
//                al.add(rs.getInt(3));
//                al.add(rs.getString(4));
//                al.add(rs.getInt(5));
//                al.add(rs.getInt(6));
//                userList.add(al);
//            }
//
//            request.setAttribute("userList", userList);
//
//            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("novedadesempleado2.jsp");
//            dispatcher.forward(request, response);
//            conn.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>

