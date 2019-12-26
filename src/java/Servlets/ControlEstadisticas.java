/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import BL.Estadisticas.clsEstadisticas;
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
public class ControlEstadisticas extends HttpServlet {

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
        if (request.getParameter("btnGuardarEsta") != null) {
            btnGuardarEsta(request, response);
        } else if (request.getParameter("btnEditarEsta") != null) {
            btnEditarEsta(request, response);
        } else if (request.getParameter("btnEliminarEsta") != null) {
            btnEliminarEsta(request, response);
        } else if (request.getParameter("btnComentarEsta") != null) {
            btnComentarEsta(request, response);
        } else if (request.getParameter("codigoSeleccionado") != null) {
            cargarEditarEsta(request, response);
        } else if (request.getParameter("codigoComentar") != null) {
            cargarComentarEsta(request, response);
        } else if (request.getParameter("btnConsultarEstaMensualidad") != null) {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);
        } else if (request.getParameter("btnConsultarEstaQuincena1") != null) {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            request.getRequestDispatcher("Estadisticas/estadisticasquincena1.jsp").forward(request, response);
        } else if (request.getParameter("btnConsultarEstaQuincena2") != null) {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            request.getRequestDispatcher("Estadisticas/estadisticasquincena2.jsp").forward(request, response);
        } else if (request.getParameter("btnAgregarEsta") != null) {

            //Listas desplegables
            BL.Estadisticas.clsEmpleado bl_clsEmpleado = new BL.Estadisticas.clsEmpleado();
            BL.Estadisticas.clsDia1 bl_clsDia1 = new BL.Estadisticas.clsDia1();
            BL.Estadisticas.clsDia2 bl_clsDia2 = new BL.Estadisticas.clsDia2();
            BL.Estadisticas.clsDia3 bl_clsDia3 = new BL.Estadisticas.clsDia3();
            BL.Estadisticas.clsDia4 bl_clsDia4 = new BL.Estadisticas.clsDia4();
            BL.Estadisticas.clsDia5 bl_clsDia5 = new BL.Estadisticas.clsDia5();
            BL.Estadisticas.clsDia6 bl_clsDia6 = new BL.Estadisticas.clsDia6();
            BL.Estadisticas.clsDia7 bl_clsDia7 = new BL.Estadisticas.clsDia7();
            BL.Estadisticas.clsDia8 bl_clsDia8 = new BL.Estadisticas.clsDia8();
            BL.Estadisticas.clsDia9 bl_clsDia9 = new BL.Estadisticas.clsDia9();
            BL.Estadisticas.clsDia10 bl_clsDia10 = new BL.Estadisticas.clsDia10();
            BL.Estadisticas.clsDia11 bl_clsDia11 = new BL.Estadisticas.clsDia11();
            BL.Estadisticas.clsDia12 bl_clsDia12 = new BL.Estadisticas.clsDia12();
            BL.Estadisticas.clsDia13 bl_clsDia13 = new BL.Estadisticas.clsDia13();
            BL.Estadisticas.clsDia14 bl_clsDia14 = new BL.Estadisticas.clsDia14();
            BL.Estadisticas.clsDia15 bl_clsDia15 = new BL.Estadisticas.clsDia15();
            BL.Estadisticas.clsDia16 bl_clsDia16 = new BL.Estadisticas.clsDia16();
            BL.Estadisticas.clsDia17 bl_clsDia17 = new BL.Estadisticas.clsDia17();
            BL.Estadisticas.clsDia18 bl_clsDia18 = new BL.Estadisticas.clsDia18();
            BL.Estadisticas.clsDia19 bl_clsDia19 = new BL.Estadisticas.clsDia19();
            BL.Estadisticas.clsDia20 bl_clsDia20 = new BL.Estadisticas.clsDia20();
            BL.Estadisticas.clsDia21 bl_clsDia21 = new BL.Estadisticas.clsDia21();
            BL.Estadisticas.clsDia22 bl_clsDia22 = new BL.Estadisticas.clsDia22();
            BL.Estadisticas.clsDia23 bl_clsDia23 = new BL.Estadisticas.clsDia23();
            BL.Estadisticas.clsDia24 bl_clsDia24 = new BL.Estadisticas.clsDia24();
            BL.Estadisticas.clsDia25 bl_clsDia25 = new BL.Estadisticas.clsDia25();
            BL.Estadisticas.clsDia26 bl_clsDia26 = new BL.Estadisticas.clsDia26();
            BL.Estadisticas.clsDia27 bl_clsDia27 = new BL.Estadisticas.clsDia27();
            BL.Estadisticas.clsDia28 bl_clsDia28 = new BL.Estadisticas.clsDia28();
            BL.Estadisticas.clsDia29 bl_clsDia29 = new BL.Estadisticas.clsDia29();
            BL.Estadisticas.clsDia30 bl_clsDia30 = new BL.Estadisticas.clsDia30();

            request.setAttribute("lstclsEmpleado", bl_clsEmpleado.getEmpleado());
            request.setAttribute("lstclsDia1", bl_clsDia1.getDia1());
            request.setAttribute("lstclsDia2", bl_clsDia2.getDia2());
            request.setAttribute("lstclsDia3", bl_clsDia3.getDia3());
            request.setAttribute("lstclsDia4", bl_clsDia4.getDia4());
            request.setAttribute("lstclsDia5", bl_clsDia5.getDia5());
            request.setAttribute("lstclsDia6", bl_clsDia6.getDia6());
            request.setAttribute("lstclsDia7", bl_clsDia7.getDia7());
            request.setAttribute("lstclsDia8", bl_clsDia8.getDia8());
            request.setAttribute("lstclsDia9", bl_clsDia9.getDia9());
            request.setAttribute("lstclsDia10", bl_clsDia10.getDia10());
            request.setAttribute("lstclsDia11", bl_clsDia11.getDia11());
            request.setAttribute("lstclsDia12", bl_clsDia12.getDia12());
            request.setAttribute("lstclsDia13", bl_clsDia13.getDia13());
            request.setAttribute("lstclsDia14", bl_clsDia14.getDia14());
            request.setAttribute("lstclsDia15", bl_clsDia15.getDia15());
            request.setAttribute("lstclsDia16", bl_clsDia16.getDia16());
            request.setAttribute("lstclsDia17", bl_clsDia17.getDia17());
            request.setAttribute("lstclsDia18", bl_clsDia18.getDia18());
            request.setAttribute("lstclsDia19", bl_clsDia19.getDia19());
            request.setAttribute("lstclsDia20", bl_clsDia20.getDia20());
            request.setAttribute("lstclsDia21", bl_clsDia21.getDia21());
            request.setAttribute("lstclsDia22", bl_clsDia22.getDia22());
            request.setAttribute("lstclsDia23", bl_clsDia23.getDia23());
            request.setAttribute("lstclsDia24", bl_clsDia24.getDia24());
            request.setAttribute("lstclsDia25", bl_clsDia25.getDia25());
            request.setAttribute("lstclsDia26", bl_clsDia26.getDia26());
            request.setAttribute("lstclsDia27", bl_clsDia27.getDia27());
            request.setAttribute("lstclsDia28", bl_clsDia28.getDia28());
            request.setAttribute("lstclsDia29", bl_clsDia29.getDia29());
            request.setAttribute("lstclsDia30", bl_clsDia30.getDia30());

            request.getRequestDispatcher("Estadisticas/agregarestadisticas.jsp").forward(request, response);

        } else if (request.getParameter("btnBuscarEstaMensualidad") != null) {
            btnBuscarEstaMensualidad(request, response);
        } else if (request.getParameter("btnBuscarEstaQuincena1") != null) {
            btnBuscarEstaQuincena1(request, response);
        } else if (request.getParameter("btnBuscarEstaQuincena2") != null) {
            btnBuscarEstaQuincena2(request, response);
        } else if (request.getParameter("codigoEliminar") != null) {
            cargarEliminarEsta(request, response);
        } else if (request.getParameter("codigoDia1") != null) {
            cargarEditarEstaDia1(request, response);
        } else if (request.getParameter("btnEditarEstaDia1") != null) {
            btnEditarEstaDia1(request, response);
        } else if (request.getParameter("codigoDia2") != null) {
            cargarEditarEstaDia2(request, response);
        } else if (request.getParameter("btnEditarEstaDia2") != null) {
            btnEditarEstaDia2(request, response);
        } else if (request.getParameter("codigoDia3") != null) {
            cargarEditarEstaDia3(request, response);
        } else if (request.getParameter("btnEditarEstaDia3") != null) {
            btnEditarEstaDia3(request, response);
        } else if (request.getParameter("codigoDia4") != null) {
            cargarEditarEstaDia4(request, response);
        } else if (request.getParameter("btnEditarEstaDia4") != null) {
            btnEditarEstaDia4(request, response);
        } else if (request.getParameter("codigoDia5") != null) {
            cargarEditarEstaDia5(request, response);
        } else if (request.getParameter("btnEditarEstaDia5") != null) {
            btnEditarEstaDia5(request, response);
        } else if (request.getParameter("codigoDia6") != null) {
            cargarEditarEstaDia6(request, response);
        } else if (request.getParameter("btnEditarEstaDia6") != null) {
            btnEditarEstaDia6(request, response);
        } else if (request.getParameter("codigoDia7") != null) {
            cargarEditarEstaDia7(request, response);
        } else if (request.getParameter("btnEditarEstaDia7") != null) {
            btnEditarEstaDia7(request, response);
        } else if (request.getParameter("codigoDia8") != null) {
            cargarEditarEstaDia8(request, response);
        } else if (request.getParameter("btnEditarEstaDia8") != null) {
            btnEditarEstaDia8(request, response);
        } else if (request.getParameter("codigoDia9") != null) {
            cargarEditarEstaDia9(request, response);
        } else if (request.getParameter("btnEditarEstaDia9") != null) {
            btnEditarEstaDia9(request, response);
        } else if (request.getParameter("codigoDia10") != null) {
            cargarEditarEstaDia10(request, response);
        } else if (request.getParameter("btnEditarEstaDia10") != null) {
            btnEditarEstaDia10(request, response);
        } else if (request.getParameter("codigoDia11") != null) {
            cargarEditarEstaDia11(request, response);
        } else if (request.getParameter("btnEditarEstaDia11") != null) {
            btnEditarEstaDia11(request, response);
        } else if (request.getParameter("codigoDia12") != null) {
            cargarEditarEstaDia12(request, response);
        } else if (request.getParameter("btnEditarEstaDia12") != null) {
            btnEditarEstaDia12(request, response);
        } else if (request.getParameter("codigoDia13") != null) {
            cargarEditarEstaDia13(request, response);
        } else if (request.getParameter("btnEditarEstaDia13") != null) {
            btnEditarEstaDia13(request, response);
        } else if (request.getParameter("codigoDia14") != null) {
            cargarEditarEstaDia14(request, response);
        } else if (request.getParameter("btnEditarEstaDia14") != null) {
            btnEditarEstaDia14(request, response);
        } else if (request.getParameter("codigoDia15") != null) {
            cargarEditarEstaDia15(request, response);
        } else if (request.getParameter("btnEditarEstaDia15") != null) {
            btnEditarEstaDia15(request, response);
        } else if (request.getParameter("codigoDia16") != null) {
            cargarEditarEstaDia16(request, response);
        } else if (request.getParameter("btnEditarEstaDia16") != null) {
            btnEditarEstaDia16(request, response);
        } else if (request.getParameter("codigoDia17") != null) {
            cargarEditarEstaDia17(request, response);
        } else if (request.getParameter("btnEditarEstaDia17") != null) {
            btnEditarEstaDia17(request, response);
        } else if (request.getParameter("codigoDia18") != null) {
            cargarEditarEstaDia18(request, response);
        } else if (request.getParameter("btnEditarEstaDia18") != null) {
            btnEditarEstaDia18(request, response);
        } else if (request.getParameter("codigoDia19") != null) {
            cargarEditarEstaDia19(request, response);
        } else if (request.getParameter("btnEditarEstaDia19") != null) {
            btnEditarEstaDia19(request, response);
        } else if (request.getParameter("codigoDia20") != null) {
            cargarEditarEstaDia20(request, response);
        } else if (request.getParameter("btnEditarEstaDia20") != null) {
            btnEditarEstaDia20(request, response);
        } else if (request.getParameter("codigoDia21") != null) {
            cargarEditarEstaDia21(request, response);
        } else if (request.getParameter("btnEditarEstaDia21") != null) {
            btnEditarEstaDia21(request, response);
        } else if (request.getParameter("codigoDia22") != null) {
            cargarEditarEstaDia22(request, response);
        } else if (request.getParameter("btnEditarEstaDia22") != null) {
            btnEditarEstaDia22(request, response);
        } else if (request.getParameter("codigoDia23") != null) {
            cargarEditarEstaDia23(request, response);
        } else if (request.getParameter("btnEditarEstaDia23") != null) {
            btnEditarEstaDia23(request, response);
        } else if (request.getParameter("codigoDia24") != null) {
            cargarEditarEstaDia24(request, response);
        } else if (request.getParameter("btnEditarEstaDia24") != null) {
            btnEditarEstaDia24(request, response);
        } else if (request.getParameter("codigoDia25") != null) {
            cargarEditarEstaDia25(request, response);
        } else if (request.getParameter("btnEditarEstaDia25") != null) {
            btnEditarEstaDia25(request, response);
        } else if (request.getParameter("codigoDia26") != null) {
            cargarEditarEstaDia26(request, response);
        } else if (request.getParameter("btnEditarEstaDia26") != null) {
            btnEditarEstaDia26(request, response);
        } else if (request.getParameter("codigoDia27") != null) {
            cargarEditarEstaDia27(request, response);
        } else if (request.getParameter("btnEditarEstaDia27") != null) {
            btnEditarEstaDia27(request, response);
        } else if (request.getParameter("codigoDia28") != null) {
            cargarEditarEstaDia28(request, response);
        } else if (request.getParameter("btnEditarEstaDia28") != null) {
            btnEditarEstaDia28(request, response);
        } else if (request.getParameter("codigoDia29") != null) {
            cargarEditarEstaDia29(request, response);
        } else if (request.getParameter("btnEditarEstaDia29") != null) {
            btnEditarEstaDia29(request, response);
        } else if (request.getParameter("codigoDia30") != null) {
            cargarEditarEstaDia30(request, response);
        } else if (request.getParameter("btnEditarEstaDia30") != null) {
            btnEditarEstaDia30(request, response);
        }

    }

    public void btnGuardarEsta(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();

            //Definición de Modelos
            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();

            Modelos.Estadisticas.clsEmpleado obclsEmpleado = new Modelos.Estadisticas.clsEmpleado();
            Modelos.Estadisticas.clsId_dia1 obclsDia1 = new Modelos.Estadisticas.clsId_dia1();
            Modelos.Estadisticas.clsId_dia2 obclsDia2 = new Modelos.Estadisticas.clsId_dia2();
            Modelos.Estadisticas.clsId_dia3 obclsDia3 = new Modelos.Estadisticas.clsId_dia3();
            Modelos.Estadisticas.clsId_dia4 obclsDia4 = new Modelos.Estadisticas.clsId_dia4();
            Modelos.Estadisticas.clsId_dia5 obclsDia5 = new Modelos.Estadisticas.clsId_dia5();
            Modelos.Estadisticas.clsId_dia6 obclsDia6 = new Modelos.Estadisticas.clsId_dia6();
            Modelos.Estadisticas.clsId_dia7 obclsDia7 = new Modelos.Estadisticas.clsId_dia7();
            Modelos.Estadisticas.clsId_dia8 obclsDia8 = new Modelos.Estadisticas.clsId_dia8();
            Modelos.Estadisticas.clsId_dia9 obclsDia9 = new Modelos.Estadisticas.clsId_dia9();
            Modelos.Estadisticas.clsId_dia10 obclsDia10 = new Modelos.Estadisticas.clsId_dia10();
            Modelos.Estadisticas.clsId_dia11 obclsDia11 = new Modelos.Estadisticas.clsId_dia11();
            Modelos.Estadisticas.clsId_dia12 obclsDia12 = new Modelos.Estadisticas.clsId_dia12();
            Modelos.Estadisticas.clsId_dia13 obclsDia13 = new Modelos.Estadisticas.clsId_dia13();
            Modelos.Estadisticas.clsId_dia14 obclsDia14 = new Modelos.Estadisticas.clsId_dia14();
            Modelos.Estadisticas.clsId_dia15 obclsDia15 = new Modelos.Estadisticas.clsId_dia15();
            Modelos.Estadisticas.clsId_dia16 obclsDia16 = new Modelos.Estadisticas.clsId_dia16();
            Modelos.Estadisticas.clsId_dia17 obclsDia17 = new Modelos.Estadisticas.clsId_dia17();
            Modelos.Estadisticas.clsId_dia18 obclsDia18 = new Modelos.Estadisticas.clsId_dia18();
            Modelos.Estadisticas.clsId_dia19 obclsDia19 = new Modelos.Estadisticas.clsId_dia19();
            Modelos.Estadisticas.clsId_dia20 obclsDia20 = new Modelos.Estadisticas.clsId_dia20();
            Modelos.Estadisticas.clsId_dia21 obclsDia21 = new Modelos.Estadisticas.clsId_dia21();
            Modelos.Estadisticas.clsId_dia22 obclsDia22 = new Modelos.Estadisticas.clsId_dia22();
            Modelos.Estadisticas.clsId_dia23 obclsDia23 = new Modelos.Estadisticas.clsId_dia23();
            Modelos.Estadisticas.clsId_dia24 obclsDia24 = new Modelos.Estadisticas.clsId_dia24();
            Modelos.Estadisticas.clsId_dia25 obclsDia25 = new Modelos.Estadisticas.clsId_dia25();
            Modelos.Estadisticas.clsId_dia26 obclsDia26 = new Modelos.Estadisticas.clsId_dia26();
            Modelos.Estadisticas.clsId_dia27 obclsDia27 = new Modelos.Estadisticas.clsId_dia27();
            Modelos.Estadisticas.clsId_dia28 obclsDia28 = new Modelos.Estadisticas.clsId_dia28();
            Modelos.Estadisticas.clsId_dia29 obclsDia29 = new Modelos.Estadisticas.clsId_dia29();
            Modelos.Estadisticas.clsId_dia30 obclsDia30 = new Modelos.Estadisticas.clsId_dia30();

            if (request.getParameter("ddlEmpleado") != null) {
                obclsEmpleado.setId_empleado(Integer.parseInt(request.getParameter("ddlEmpleado")));
                obclsEstadisticas.setObEmpleado(obclsEmpleado);
            }

            if (request.getParameter("ddlDia1") != null) {
                obclsDia1.setId_dia1(Integer.parseInt(request.getParameter("ddlDia1")));
                obclsEstadisticas.setObId_dia1(obclsDia1);
            }

            if (request.getParameter("ddlDia2") != null) {
                obclsDia2.setId_dia2(Integer.parseInt(request.getParameter("ddlDia2")));
                obclsEstadisticas.setObId_dia2(obclsDia2);
            }

            if (request.getParameter("ddlDia3") != null) {
                obclsDia3.setId_dia3(Integer.parseInt(request.getParameter("ddlDia3")));
                obclsEstadisticas.setObId_dia3(obclsDia3);
            }

            if (request.getParameter("ddlDia4") != null) {
                obclsDia4.setId_dia4(Integer.parseInt(request.getParameter("ddlDia4")));
                obclsEstadisticas.setObId_dia4(obclsDia4);
            }

            if (request.getParameter("ddlDia5") != null) {
                obclsDia5.setId_dia5(Integer.parseInt(request.getParameter("ddlDia5")));
                obclsEstadisticas.setObId_dia5(obclsDia5);
            }

            if (request.getParameter("ddlDia6") != null) {
                obclsDia6.setId_dia6(Integer.parseInt(request.getParameter("ddlDia6")));
                obclsEstadisticas.setObId_dia6(obclsDia6);
            }

            if (request.getParameter("ddlDia7") != null) {
                obclsDia7.setId_dia7(Integer.parseInt(request.getParameter("ddlDia7")));
                obclsEstadisticas.setObId_dia7(obclsDia7);
            }

            if (request.getParameter("ddlDia8") != null) {
                obclsDia8.setId_dia8(Integer.parseInt(request.getParameter("ddlDia8")));
                obclsEstadisticas.setObId_dia8(obclsDia8);
            }

            if (request.getParameter("ddlDia9") != null) {
                obclsDia9.setId_dia9(Integer.parseInt(request.getParameter("ddlDia9")));
                obclsEstadisticas.setObId_dia9(obclsDia9);
            }

            if (request.getParameter("ddlDia10") != null) {
                obclsDia10.setId_dia10(Integer.parseInt(request.getParameter("ddlDia10")));
                obclsEstadisticas.setObId_dia10(obclsDia10);
            }

            if (request.getParameter("ddlDia11") != null) {
                obclsDia11.setId_dia11(Integer.parseInt(request.getParameter("ddlDia11")));
                obclsEstadisticas.setObId_dia11(obclsDia11);
            }

            if (request.getParameter("ddlDia12") != null) {
                obclsDia12.setId_dia12(Integer.parseInt(request.getParameter("ddlDia12")));
                obclsEstadisticas.setObId_dia12(obclsDia12);
            }

            if (request.getParameter("ddlDia13") != null) {
                obclsDia13.setId_dia13(Integer.parseInt(request.getParameter("ddlDia13")));
                obclsEstadisticas.setObId_dia13(obclsDia13);
            }

            if (request.getParameter("ddlDia14") != null) {
                obclsDia14.setId_dia14(Integer.parseInt(request.getParameter("ddlDia14")));
                obclsEstadisticas.setObId_dia14(obclsDia14);
            }

            if (request.getParameter("ddlDia15") != null) {
                obclsDia15.setId_dia15(Integer.parseInt(request.getParameter("ddlDia15")));
                obclsEstadisticas.setObId_dia15(obclsDia15);
            }

            if (request.getParameter("ddlDia16") != null) {
                obclsDia16.setId_dia16(Integer.parseInt(request.getParameter("ddlDia16")));
                obclsEstadisticas.setObId_dia16(obclsDia16);
            }

            if (request.getParameter("ddlDia17") != null) {
                obclsDia17.setId_dia17(Integer.parseInt(request.getParameter("ddlDia17")));
                obclsEstadisticas.setObId_dia17(obclsDia17);
            }

            if (request.getParameter("ddlDia18") != null) {
                obclsDia18.setId_dia18(Integer.parseInt(request.getParameter("ddlDia18")));
                obclsEstadisticas.setObId_dia18(obclsDia18);
            }

            if (request.getParameter("ddlDia19") != null) {
                obclsDia19.setId_dia19(Integer.parseInt(request.getParameter("ddlDia19")));
                obclsEstadisticas.setObId_dia19(obclsDia19);
            }

            if (request.getParameter("ddlDia20") != null) {
                obclsDia20.setId_dia20(Integer.parseInt(request.getParameter("ddlDia20")));
                obclsEstadisticas.setObId_dia20(obclsDia20);
            }

            if (request.getParameter("ddlDia21") != null) {
                obclsDia21.setId_dia21(Integer.parseInt(request.getParameter("ddlDia21")));
                obclsEstadisticas.setObId_dia21(obclsDia21);
            }

            if (request.getParameter("ddlDia22") != null) {
                obclsDia22.setId_dia22(Integer.parseInt(request.getParameter("ddlDia22")));
                obclsEstadisticas.setObId_dia22(obclsDia22);
            }

            if (request.getParameter("ddlDia23") != null) {
                obclsDia23.setId_dia23(Integer.parseInt(request.getParameter("ddlDia23")));
                obclsEstadisticas.setObId_dia23(obclsDia23);
            }

            if (request.getParameter("ddlDia24") != null) {
                obclsDia24.setId_dia24(Integer.parseInt(request.getParameter("ddlDia24")));
                obclsEstadisticas.setObId_dia24(obclsDia24);
            }

            if (request.getParameter("ddlDia25") != null) {
                obclsDia25.setId_dia25(Integer.parseInt(request.getParameter("ddlDia25")));
                obclsEstadisticas.setObId_dia25(obclsDia25);
            }

            if (request.getParameter("ddlDia26") != null) {
                obclsDia26.setId_dia26(Integer.parseInt(request.getParameter("ddlDia26")));
                obclsEstadisticas.setObId_dia26(obclsDia26);
            }

            if (request.getParameter("ddlDia27") != null) {
                obclsDia27.setId_dia27(Integer.parseInt(request.getParameter("ddlDia27")));
                obclsEstadisticas.setObId_dia27(obclsDia27);
            }

            if (request.getParameter("ddlDia28") != null) {
                obclsDia28.setId_dia28(Integer.parseInt(request.getParameter("ddlDia28")));
                obclsEstadisticas.setObId_dia28(obclsDia28);
            }

            if (request.getParameter("ddlDia29") != null) {
                obclsDia29.setId_dia29(Integer.parseInt(request.getParameter("ddlDia29")));
                obclsEstadisticas.setObId_dia29(obclsDia29);
            }

            if (request.getParameter("ddlDia30") != null) {
                obclsDia30.setId_dia30(Integer.parseInt(request.getParameter("ddlDia30")));
                obclsEstadisticas.setObId_dia30(obclsDia30);
            }

            //Definición de parametros desde el controlador
            request.setAttribute("stMensaje", bl_clsEstadisticas.createEstadistica(obclsEstadisticas));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            //Redireccion y envio de valores            
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            //Listas desplegables
            BL.Estadisticas.clsEmpleado bl_clsEmpleado = new BL.Estadisticas.clsEmpleado();
            BL.Estadisticas.clsDia1 bl_clsDia1 = new BL.Estadisticas.clsDia1();
            BL.Estadisticas.clsDia2 bl_clsDia2 = new BL.Estadisticas.clsDia2();
            BL.Estadisticas.clsDia3 bl_clsDia3 = new BL.Estadisticas.clsDia3();
            BL.Estadisticas.clsDia4 bl_clsDia4 = new BL.Estadisticas.clsDia4();
            BL.Estadisticas.clsDia5 bl_clsDia5 = new BL.Estadisticas.clsDia5();
            BL.Estadisticas.clsDia6 bl_clsDia6 = new BL.Estadisticas.clsDia6();
            BL.Estadisticas.clsDia7 bl_clsDia7 = new BL.Estadisticas.clsDia7();
            BL.Estadisticas.clsDia8 bl_clsDia8 = new BL.Estadisticas.clsDia8();
            BL.Estadisticas.clsDia9 bl_clsDia9 = new BL.Estadisticas.clsDia9();
            BL.Estadisticas.clsDia10 bl_clsDia10 = new BL.Estadisticas.clsDia10();
            BL.Estadisticas.clsDia11 bl_clsDia11 = new BL.Estadisticas.clsDia11();
            BL.Estadisticas.clsDia12 bl_clsDia12 = new BL.Estadisticas.clsDia12();
            BL.Estadisticas.clsDia13 bl_clsDia13 = new BL.Estadisticas.clsDia13();
            BL.Estadisticas.clsDia14 bl_clsDia14 = new BL.Estadisticas.clsDia14();
            BL.Estadisticas.clsDia15 bl_clsDia15 = new BL.Estadisticas.clsDia15();
            BL.Estadisticas.clsDia16 bl_clsDia16 = new BL.Estadisticas.clsDia16();
            BL.Estadisticas.clsDia17 bl_clsDia17 = new BL.Estadisticas.clsDia17();
            BL.Estadisticas.clsDia18 bl_clsDia18 = new BL.Estadisticas.clsDia18();
            BL.Estadisticas.clsDia19 bl_clsDia19 = new BL.Estadisticas.clsDia19();
            BL.Estadisticas.clsDia20 bl_clsDia20 = new BL.Estadisticas.clsDia20();
            BL.Estadisticas.clsDia21 bl_clsDia21 = new BL.Estadisticas.clsDia21();
            BL.Estadisticas.clsDia22 bl_clsDia22 = new BL.Estadisticas.clsDia22();
            BL.Estadisticas.clsDia23 bl_clsDia23 = new BL.Estadisticas.clsDia23();
            BL.Estadisticas.clsDia24 bl_clsDia24 = new BL.Estadisticas.clsDia24();
            BL.Estadisticas.clsDia25 bl_clsDia25 = new BL.Estadisticas.clsDia25();
            BL.Estadisticas.clsDia26 bl_clsDia26 = new BL.Estadisticas.clsDia26();
            BL.Estadisticas.clsDia27 bl_clsDia27 = new BL.Estadisticas.clsDia27();
            BL.Estadisticas.clsDia28 bl_clsDia28 = new BL.Estadisticas.clsDia28();
            BL.Estadisticas.clsDia29 bl_clsDia29 = new BL.Estadisticas.clsDia29();
            BL.Estadisticas.clsDia30 bl_clsDia30 = new BL.Estadisticas.clsDia30();

            request.setAttribute("lstclsEmpleado", bl_clsEmpleado.getEmpleado());
            request.setAttribute("lstclsDia1", bl_clsDia1.getDia1());
            request.setAttribute("lstclsDia2", bl_clsDia2.getDia2());
            request.setAttribute("lstclsDia3", bl_clsDia3.getDia3());
            request.setAttribute("lstclsDia4", bl_clsDia4.getDia4());
            request.setAttribute("lstclsDia5", bl_clsDia5.getDia5());
            request.setAttribute("lstclsDia6", bl_clsDia6.getDia6());
            request.setAttribute("lstclsDia7", bl_clsDia7.getDia7());
            request.setAttribute("lstclsDia8", bl_clsDia8.getDia8());
            request.setAttribute("lstclsDia9", bl_clsDia9.getDia9());
            request.setAttribute("lstclsDia10", bl_clsDia10.getDia10());
            request.setAttribute("lstclsDia11", bl_clsDia11.getDia11());
            request.setAttribute("lstclsDia12", bl_clsDia12.getDia12());
            request.setAttribute("lstclsDia13", bl_clsDia13.getDia13());
            request.setAttribute("lstclsDia14", bl_clsDia14.getDia14());
            request.setAttribute("lstclsDia15", bl_clsDia15.getDia15());
            request.setAttribute("lstclsDia16", bl_clsDia16.getDia16());
            request.setAttribute("lstclsDia17", bl_clsDia17.getDia17());
            request.setAttribute("lstclsDia18", bl_clsDia18.getDia18());
            request.setAttribute("lstclsDia19", bl_clsDia19.getDia19());
            request.setAttribute("lstclsDia20", bl_clsDia20.getDia20());
            request.setAttribute("lstclsDia21", bl_clsDia21.getDia21());
            request.setAttribute("lstclsDia22", bl_clsDia22.getDia22());
            request.setAttribute("lstclsDia23", bl_clsDia23.getDia23());
            request.setAttribute("lstclsDia24", bl_clsDia24.getDia24());
            request.setAttribute("lstclsDia25", bl_clsDia25.getDia25());
            request.setAttribute("lstclsDia26", bl_clsDia26.getDia26());
            request.setAttribute("lstclsDia27", bl_clsDia27.getDia27());
            request.setAttribute("lstclsDia28", bl_clsDia28.getDia28());
            request.setAttribute("lstclsDia29", bl_clsDia29.getDia29());
            request.setAttribute("lstclsDia30", bl_clsDia30.getDia30());

            request.getRequestDispatcher("Estadisticas/agregarestadisticas.jsp").forward(request, response);
        }

    }

    public void cargarEditarEsta(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();

            List<Modelos.Estadisticas.clsEstadisticas> lstclsEstadisticas = new ArrayList<Modelos.Estadisticas.clsEstadisticas>();

            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();

            lstclsEstadisticas = bl_clsEstadisticas.getEstadisticas();

            for (Modelos.Estadisticas.clsEstadisticas elem : lstclsEstadisticas) {
                if (elem.getId_estadistica() == Integer.parseInt(request.getParameter("codigoSeleccionado"))) {
                    obclsEstadisticas = elem;
                    break;
                }
            }

            //Listas desplegables
            BL.Estadisticas.clsEmpleado bl_clsEmpleado = new BL.Estadisticas.clsEmpleado();
            BL.Estadisticas.clsDia1 bl_clsDia1 = new BL.Estadisticas.clsDia1();
            BL.Estadisticas.clsDia2 bl_clsDia2 = new BL.Estadisticas.clsDia2();
            BL.Estadisticas.clsDia3 bl_clsDia3 = new BL.Estadisticas.clsDia3();
            BL.Estadisticas.clsDia4 bl_clsDia4 = new BL.Estadisticas.clsDia4();
            BL.Estadisticas.clsDia5 bl_clsDia5 = new BL.Estadisticas.clsDia5();
            BL.Estadisticas.clsDia6 bl_clsDia6 = new BL.Estadisticas.clsDia6();
            BL.Estadisticas.clsDia7 bl_clsDia7 = new BL.Estadisticas.clsDia7();
            BL.Estadisticas.clsDia8 bl_clsDia8 = new BL.Estadisticas.clsDia8();
            BL.Estadisticas.clsDia9 bl_clsDia9 = new BL.Estadisticas.clsDia9();
            BL.Estadisticas.clsDia10 bl_clsDia10 = new BL.Estadisticas.clsDia10();
            BL.Estadisticas.clsDia11 bl_clsDia11 = new BL.Estadisticas.clsDia11();
            BL.Estadisticas.clsDia12 bl_clsDia12 = new BL.Estadisticas.clsDia12();
            BL.Estadisticas.clsDia13 bl_clsDia13 = new BL.Estadisticas.clsDia13();
            BL.Estadisticas.clsDia14 bl_clsDia14 = new BL.Estadisticas.clsDia14();
            BL.Estadisticas.clsDia15 bl_clsDia15 = new BL.Estadisticas.clsDia15();
            BL.Estadisticas.clsDia16 bl_clsDia16 = new BL.Estadisticas.clsDia16();
            BL.Estadisticas.clsDia17 bl_clsDia17 = new BL.Estadisticas.clsDia17();
            BL.Estadisticas.clsDia18 bl_clsDia18 = new BL.Estadisticas.clsDia18();
            BL.Estadisticas.clsDia19 bl_clsDia19 = new BL.Estadisticas.clsDia19();
            BL.Estadisticas.clsDia20 bl_clsDia20 = new BL.Estadisticas.clsDia20();
            BL.Estadisticas.clsDia21 bl_clsDia21 = new BL.Estadisticas.clsDia21();
            BL.Estadisticas.clsDia22 bl_clsDia22 = new BL.Estadisticas.clsDia22();
            BL.Estadisticas.clsDia23 bl_clsDia23 = new BL.Estadisticas.clsDia23();
            BL.Estadisticas.clsDia24 bl_clsDia24 = new BL.Estadisticas.clsDia24();
            BL.Estadisticas.clsDia25 bl_clsDia25 = new BL.Estadisticas.clsDia25();
            BL.Estadisticas.clsDia26 bl_clsDia26 = new BL.Estadisticas.clsDia26();
            BL.Estadisticas.clsDia27 bl_clsDia27 = new BL.Estadisticas.clsDia27();
            BL.Estadisticas.clsDia28 bl_clsDia28 = new BL.Estadisticas.clsDia28();
            BL.Estadisticas.clsDia29 bl_clsDia29 = new BL.Estadisticas.clsDia29();
            BL.Estadisticas.clsDia30 bl_clsDia30 = new BL.Estadisticas.clsDia30();

            request.setAttribute("lstclsEmpleado", bl_clsEmpleado.getEmpleado());
            request.setAttribute("lstclsDia1", bl_clsDia1.getDia1());
            request.setAttribute("lstclsDia2", bl_clsDia2.getDia2());
            request.setAttribute("lstclsDia3", bl_clsDia3.getDia3());
            request.setAttribute("lstclsDia4", bl_clsDia4.getDia4());
            request.setAttribute("lstclsDia5", bl_clsDia5.getDia5());
            request.setAttribute("lstclsDia6", bl_clsDia6.getDia6());
            request.setAttribute("lstclsDia7", bl_clsDia7.getDia7());
            request.setAttribute("lstclsDia8", bl_clsDia8.getDia8());
            request.setAttribute("lstclsDia9", bl_clsDia9.getDia9());
            request.setAttribute("lstclsDia10", bl_clsDia10.getDia10());
            request.setAttribute("lstclsDia11", bl_clsDia11.getDia11());
            request.setAttribute("lstclsDia12", bl_clsDia12.getDia12());
            request.setAttribute("lstclsDia13", bl_clsDia13.getDia13());
            request.setAttribute("lstclsDia14", bl_clsDia14.getDia14());
            request.setAttribute("lstclsDia15", bl_clsDia15.getDia15());
            request.setAttribute("lstclsDia16", bl_clsDia16.getDia16());
            request.setAttribute("lstclsDia17", bl_clsDia17.getDia17());
            request.setAttribute("lstclsDia18", bl_clsDia18.getDia18());
            request.setAttribute("lstclsDia19", bl_clsDia19.getDia19());
            request.setAttribute("lstclsDia20", bl_clsDia20.getDia20());
            request.setAttribute("lstclsDia21", bl_clsDia21.getDia21());
            request.setAttribute("lstclsDia22", bl_clsDia22.getDia22());
            request.setAttribute("lstclsDia23", bl_clsDia23.getDia23());
            request.setAttribute("lstclsDia24", bl_clsDia24.getDia24());
            request.setAttribute("lstclsDia25", bl_clsDia25.getDia25());
            request.setAttribute("lstclsDia26", bl_clsDia26.getDia26());
            request.setAttribute("lstclsDia27", bl_clsDia27.getDia27());
            request.setAttribute("lstclsDia28", bl_clsDia28.getDia28());
            request.setAttribute("lstclsDia29", bl_clsDia29.getDia29());
            request.setAttribute("lstclsDia30", bl_clsDia30.getDia30());

            request.setAttribute("obclsEstadisticas", obclsEstadisticas);
            request.setAttribute("lstclsEstadisticas", lstclsEstadisticas);
            request.getRequestDispatcher("Estadisticas/editarestadisticas.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

            ex.getMessage();

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

        }
    }

    public void cargarComentarEsta(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        try {

            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();

            List<Modelos.Estadisticas.clsEstadisticas> lstclsEstadisticas = new ArrayList<Modelos.Estadisticas.clsEstadisticas>();

            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();

            lstclsEstadisticas = bl_clsEstadisticas.getEstadisticas();

            for (Modelos.Estadisticas.clsEstadisticas elem : lstclsEstadisticas) {
                if (elem.getId_estadistica() == Integer.parseInt(request.getParameter("codigoComentar"))) {
                    obclsEstadisticas = elem;
                    break;
                }
            }

            request.setAttribute("obclsEstadisticas", obclsEstadisticas);
            request.setAttribute("lstclsEstadisticas", lstclsEstadisticas);

            request.getRequestDispatcher("Estadisticas/comentarestadisticas.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

            ex.getMessage();

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());
        }
    }

    public void cargarEliminarEsta(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();

            List<Modelos.Estadisticas.clsEstadisticas> lstclsEstadisticas = new ArrayList<Modelos.Estadisticas.clsEstadisticas>();

            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();

            lstclsEstadisticas = bl_clsEstadisticas.getEstadisticas();

            for (Modelos.Estadisticas.clsEstadisticas elem : lstclsEstadisticas) {
                if (elem.getId_estadistica() == Integer.parseInt(request.getParameter("codigoEliminar"))) {
                    obclsEstadisticas = elem;
                    break;
                }
            }

            request.setAttribute("obclsEstadisticas", obclsEstadisticas);
            request.setAttribute("lstclsEstadisticas", lstclsEstadisticas);
            request.getRequestDispatcher("Estadisticas/eliminarestadisticas.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

            ex.getMessage();

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

        }
    }

    public void btnComentarEsta(HttpServletRequest request,
            HttpServletResponse response)throws IOException, ServletException{
        
        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            
            Modelos.Estadisticas.clsComentarEstadisticas obclsComentarEstadisticas = new Modelos.Estadisticas.clsComentarEstadisticas();
            
            if(request.getParameter("IdModificar")!=null){
                obclsComentarEstadisticas.setId_estadisticas(Integer.valueOf(request.getParameter("IdModificar")));
            }
            
            if(request.getParameter("txtComentario")!=null){
                
                String comentario = request.getParameter("txtComentario");
                
                if(comentario.contains("\n")){
                    comentario = comentario.replaceAll(("\r\n|\n"),"<br/>");
                }
 
                obclsComentarEstadisticas.setComentario(comentario);
            }
            
            //Definición de parametros desde el controlador
            request.setAttribute("stMensaje", bl_clsEstadisticas.commentEstadistica(obclsComentarEstadisticas));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());
            
            //Redireccion y envio de valores
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);
            
        } catch (Exception ex) {
            
            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());
            
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);
            
        }
    }
    
    
    public void btnEditarEsta(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();

            //Definición de Modelos
            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();

            Modelos.Estadisticas.clsEmpleado obclsEmpleado = new Modelos.Estadisticas.clsEmpleado();
            Modelos.Estadisticas.clsId_dia1 obclsDia1 = new Modelos.Estadisticas.clsId_dia1();
            Modelos.Estadisticas.clsId_dia2 obclsDia2 = new Modelos.Estadisticas.clsId_dia2();
            Modelos.Estadisticas.clsId_dia3 obclsDia3 = new Modelos.Estadisticas.clsId_dia3();
            Modelos.Estadisticas.clsId_dia4 obclsDia4 = new Modelos.Estadisticas.clsId_dia4();
            Modelos.Estadisticas.clsId_dia5 obclsDia5 = new Modelos.Estadisticas.clsId_dia5();
            Modelos.Estadisticas.clsId_dia6 obclsDia6 = new Modelos.Estadisticas.clsId_dia6();
            Modelos.Estadisticas.clsId_dia7 obclsDia7 = new Modelos.Estadisticas.clsId_dia7();
            Modelos.Estadisticas.clsId_dia8 obclsDia8 = new Modelos.Estadisticas.clsId_dia8();
            Modelos.Estadisticas.clsId_dia9 obclsDia9 = new Modelos.Estadisticas.clsId_dia9();
            Modelos.Estadisticas.clsId_dia10 obclsDia10 = new Modelos.Estadisticas.clsId_dia10();
            Modelos.Estadisticas.clsId_dia11 obclsDia11 = new Modelos.Estadisticas.clsId_dia11();
            Modelos.Estadisticas.clsId_dia12 obclsDia12 = new Modelos.Estadisticas.clsId_dia12();
            Modelos.Estadisticas.clsId_dia13 obclsDia13 = new Modelos.Estadisticas.clsId_dia13();
            Modelos.Estadisticas.clsId_dia14 obclsDia14 = new Modelos.Estadisticas.clsId_dia14();
            Modelos.Estadisticas.clsId_dia15 obclsDia15 = new Modelos.Estadisticas.clsId_dia15();
            Modelos.Estadisticas.clsId_dia16 obclsDia16 = new Modelos.Estadisticas.clsId_dia16();
            Modelos.Estadisticas.clsId_dia17 obclsDia17 = new Modelos.Estadisticas.clsId_dia17();
            Modelos.Estadisticas.clsId_dia18 obclsDia18 = new Modelos.Estadisticas.clsId_dia18();
            Modelos.Estadisticas.clsId_dia19 obclsDia19 = new Modelos.Estadisticas.clsId_dia19();
            Modelos.Estadisticas.clsId_dia20 obclsDia20 = new Modelos.Estadisticas.clsId_dia20();
            Modelos.Estadisticas.clsId_dia21 obclsDia21 = new Modelos.Estadisticas.clsId_dia21();
            Modelos.Estadisticas.clsId_dia22 obclsDia22 = new Modelos.Estadisticas.clsId_dia22();
            Modelos.Estadisticas.clsId_dia23 obclsDia23 = new Modelos.Estadisticas.clsId_dia23();
            Modelos.Estadisticas.clsId_dia24 obclsDia24 = new Modelos.Estadisticas.clsId_dia24();
            Modelos.Estadisticas.clsId_dia25 obclsDia25 = new Modelos.Estadisticas.clsId_dia25();
            Modelos.Estadisticas.clsId_dia26 obclsDia26 = new Modelos.Estadisticas.clsId_dia26();
            Modelos.Estadisticas.clsId_dia27 obclsDia27 = new Modelos.Estadisticas.clsId_dia27();
            Modelos.Estadisticas.clsId_dia28 obclsDia28 = new Modelos.Estadisticas.clsId_dia28();
            Modelos.Estadisticas.clsId_dia29 obclsDia29 = new Modelos.Estadisticas.clsId_dia29();
            Modelos.Estadisticas.clsId_dia30 obclsDia30 = new Modelos.Estadisticas.clsId_dia30();

            if (request.getParameter("IdModificar") != null) {
                obclsEstadisticas.setId_estadistica(Integer.valueOf(request.getParameter("IdModificar")));
            }

            if (request.getParameter("ddlEmpleado") != null) {
                obclsEmpleado.setId_empleado(Integer.parseInt(request.getParameter("ddlEmpleado")));
                obclsEstadisticas.setObEmpleado(obclsEmpleado);
            }

            if (request.getParameter("ddlDia1") != null) {
                //Modelo Externo
                obclsDia1.setId_dia1(Integer.parseInt(request.getParameter("ddlDia1")));
                //Asignación al modelo padre
                obclsEstadisticas.setObId_dia1(obclsDia1);
            }

            if (request.getParameter("ddlDia2") != null) {
                obclsDia2.setId_dia2(Integer.parseInt(request.getParameter("ddlDia2")));
                obclsEstadisticas.setObId_dia2(obclsDia2);
            }

            if (request.getParameter("ddlDia3") != null) {
                obclsDia3.setId_dia3(Integer.parseInt(request.getParameter("ddlDia3")));
                obclsEstadisticas.setObId_dia3(obclsDia3);
            }

            if (request.getParameter("ddlDia4") != null) {
                obclsDia4.setId_dia4(Integer.parseInt(request.getParameter("ddlDia4")));
                obclsEstadisticas.setObId_dia4(obclsDia4);
            }

            if (request.getParameter("ddlDia5") != null) {
                obclsDia5.setId_dia5(Integer.parseInt(request.getParameter("ddlDia5")));
                obclsEstadisticas.setObId_dia5(obclsDia5);
            }

            if (request.getParameter("ddlDia6") != null) {
                obclsDia6.setId_dia6(Integer.parseInt(request.getParameter("ddlDia6")));
                obclsEstadisticas.setObId_dia6(obclsDia6);
            }

            if (request.getParameter("ddlDia7") != null) {
                obclsDia7.setId_dia7(Integer.parseInt(request.getParameter("ddlDia7")));
                obclsEstadisticas.setObId_dia7(obclsDia7);
            }

            if (request.getParameter("ddlDia8") != null) {
                obclsDia8.setId_dia8(Integer.parseInt(request.getParameter("ddlDia8")));
                obclsEstadisticas.setObId_dia8(obclsDia8);
            }

            if (request.getParameter("ddlDia9") != null) {
                obclsDia9.setId_dia9(Integer.parseInt(request.getParameter("ddlDia9")));
                obclsEstadisticas.setObId_dia9(obclsDia9);
            }

            if (request.getParameter("ddlDia10") != null) {
                obclsDia10.setId_dia10(Integer.parseInt(request.getParameter("ddlDia10")));
                obclsEstadisticas.setObId_dia10(obclsDia10);
            }

            if (request.getParameter("ddlDia11") != null) {
                obclsDia11.setId_dia11(Integer.parseInt(request.getParameter("ddlDia11")));
                obclsEstadisticas.setObId_dia11(obclsDia11);
            }

            if (request.getParameter("ddlDia12") != null) {
                obclsDia12.setId_dia12(Integer.parseInt(request.getParameter("ddlDia12")));
                obclsEstadisticas.setObId_dia12(obclsDia12);
            }

            if (request.getParameter("ddlDia13") != null) {
                obclsDia13.setId_dia13(Integer.parseInt(request.getParameter("ddlDia13")));
                obclsEstadisticas.setObId_dia13(obclsDia13);
            }

            if (request.getParameter("ddlDia14") != null) {
                obclsDia14.setId_dia14(Integer.parseInt(request.getParameter("ddlDia14")));
                obclsEstadisticas.setObId_dia14(obclsDia14);
            }

            if (request.getParameter("ddlDia15") != null) {
                obclsDia15.setId_dia15(Integer.parseInt(request.getParameter("ddlDia15")));
                obclsEstadisticas.setObId_dia15(obclsDia15);
            }

            if (request.getParameter("ddlDia16") != null) {
                obclsDia16.setId_dia16(Integer.parseInt(request.getParameter("ddlDia16")));
                obclsEstadisticas.setObId_dia16(obclsDia16);
            }

            if (request.getParameter("ddlDia17") != null) {
                obclsDia17.setId_dia17(Integer.parseInt(request.getParameter("ddlDia17")));
                obclsEstadisticas.setObId_dia17(obclsDia17);
            }

            if (request.getParameter("ddlDia18") != null) {
                obclsDia18.setId_dia18(Integer.parseInt(request.getParameter("ddlDia18")));
                obclsEstadisticas.setObId_dia18(obclsDia18);
            }

            if (request.getParameter("ddlDia19") != null) {
                obclsDia19.setId_dia19(Integer.parseInt(request.getParameter("ddlDia19")));
                obclsEstadisticas.setObId_dia19(obclsDia19);
            }

            if (request.getParameter("ddlDia20") != null) {
                obclsDia20.setId_dia20(Integer.parseInt(request.getParameter("ddlDia20")));
                obclsEstadisticas.setObId_dia20(obclsDia20);
            }

            if (request.getParameter("ddlDia21") != null) {
                obclsDia21.setId_dia21(Integer.parseInt(request.getParameter("ddlDia21")));
                obclsEstadisticas.setObId_dia21(obclsDia21);
            }

            if (request.getParameter("ddlDia22") != null) {
                obclsDia22.setId_dia22(Integer.parseInt(request.getParameter("ddlDia22")));
                obclsEstadisticas.setObId_dia22(obclsDia22);
            }

            if (request.getParameter("ddlDia23") != null) {
                obclsDia23.setId_dia23(Integer.parseInt(request.getParameter("ddlDia23")));
                obclsEstadisticas.setObId_dia23(obclsDia23);
            }

            if (request.getParameter("ddlDia24") != null) {
                obclsDia24.setId_dia24(Integer.parseInt(request.getParameter("ddlDia24")));
                obclsEstadisticas.setObId_dia24(obclsDia24);
            }

            if (request.getParameter("ddlDia25") != null) {
                obclsDia25.setId_dia25(Integer.parseInt(request.getParameter("ddlDia25")));
                obclsEstadisticas.setObId_dia25(obclsDia25);
            }

            if (request.getParameter("ddlDia26") != null) {
                obclsDia26.setId_dia26(Integer.parseInt(request.getParameter("ddlDia26")));
                obclsEstadisticas.setObId_dia26(obclsDia26);
            }

            if (request.getParameter("ddlDia27") != null) {
                obclsDia27.setId_dia27(Integer.parseInt(request.getParameter("ddlDia27")));
                obclsEstadisticas.setObId_dia27(obclsDia27);
            }

            if (request.getParameter("ddlDia28") != null) {
                obclsDia28.setId_dia28(Integer.parseInt(request.getParameter("ddlDia28")));
                obclsEstadisticas.setObId_dia28(obclsDia28);
            }

            if (request.getParameter("ddlDia29") != null) {
                obclsDia29.setId_dia29(Integer.parseInt(request.getParameter("ddlDia29")));
                obclsEstadisticas.setObId_dia29(obclsDia29);
            }

            if (request.getParameter("ddlDia30") != null) {
                obclsDia30.setId_dia30(Integer.parseInt(request.getParameter("ddlDia30")));
                obclsEstadisticas.setObId_dia30(obclsDia30);
            }

            //Definición de parametros desde el controlador
            request.setAttribute("stMensaje", bl_clsEstadisticas.updateEstadistica(obclsEstadisticas));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            //Redireccion y envio de valores
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

        } catch (Exception ex) {
            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            //Listas desplegables
            BL.Estadisticas.clsEmpleado bl_clsEmpleado = new BL.Estadisticas.clsEmpleado();
            BL.Estadisticas.clsDia1 bl_clsDia1 = new BL.Estadisticas.clsDia1();
            BL.Estadisticas.clsDia2 bl_clsDia2 = new BL.Estadisticas.clsDia2();
            BL.Estadisticas.clsDia3 bl_clsDia3 = new BL.Estadisticas.clsDia3();
            BL.Estadisticas.clsDia4 bl_clsDia4 = new BL.Estadisticas.clsDia4();
            BL.Estadisticas.clsDia5 bl_clsDia5 = new BL.Estadisticas.clsDia5();
            BL.Estadisticas.clsDia6 bl_clsDia6 = new BL.Estadisticas.clsDia6();
            BL.Estadisticas.clsDia7 bl_clsDia7 = new BL.Estadisticas.clsDia7();
            BL.Estadisticas.clsDia8 bl_clsDia8 = new BL.Estadisticas.clsDia8();
            BL.Estadisticas.clsDia9 bl_clsDia9 = new BL.Estadisticas.clsDia9();
            BL.Estadisticas.clsDia10 bl_clsDia10 = new BL.Estadisticas.clsDia10();
            BL.Estadisticas.clsDia11 bl_clsDia11 = new BL.Estadisticas.clsDia11();
            BL.Estadisticas.clsDia12 bl_clsDia12 = new BL.Estadisticas.clsDia12();
            BL.Estadisticas.clsDia13 bl_clsDia13 = new BL.Estadisticas.clsDia13();
            BL.Estadisticas.clsDia14 bl_clsDia14 = new BL.Estadisticas.clsDia14();
            BL.Estadisticas.clsDia15 bl_clsDia15 = new BL.Estadisticas.clsDia15();
            BL.Estadisticas.clsDia16 bl_clsDia16 = new BL.Estadisticas.clsDia16();
            BL.Estadisticas.clsDia17 bl_clsDia17 = new BL.Estadisticas.clsDia17();
            BL.Estadisticas.clsDia18 bl_clsDia18 = new BL.Estadisticas.clsDia18();
            BL.Estadisticas.clsDia19 bl_clsDia19 = new BL.Estadisticas.clsDia19();
            BL.Estadisticas.clsDia20 bl_clsDia20 = new BL.Estadisticas.clsDia20();
            BL.Estadisticas.clsDia21 bl_clsDia21 = new BL.Estadisticas.clsDia21();
            BL.Estadisticas.clsDia22 bl_clsDia22 = new BL.Estadisticas.clsDia22();
            BL.Estadisticas.clsDia23 bl_clsDia23 = new BL.Estadisticas.clsDia23();
            BL.Estadisticas.clsDia24 bl_clsDia24 = new BL.Estadisticas.clsDia24();
            BL.Estadisticas.clsDia25 bl_clsDia25 = new BL.Estadisticas.clsDia25();
            BL.Estadisticas.clsDia26 bl_clsDia26 = new BL.Estadisticas.clsDia26();
            BL.Estadisticas.clsDia27 bl_clsDia27 = new BL.Estadisticas.clsDia27();
            BL.Estadisticas.clsDia28 bl_clsDia28 = new BL.Estadisticas.clsDia28();
            BL.Estadisticas.clsDia29 bl_clsDia29 = new BL.Estadisticas.clsDia29();
            BL.Estadisticas.clsDia30 bl_clsDia30 = new BL.Estadisticas.clsDia30();

            request.setAttribute("lstclsEmpleado", bl_clsEmpleado.getEmpleado());
            request.setAttribute("lstclsDia1", bl_clsDia1.getDia1());
            request.setAttribute("lstclsDia2", bl_clsDia2.getDia2());
            request.setAttribute("lstclsDia3", bl_clsDia3.getDia3());
            request.setAttribute("lstclsDia4", bl_clsDia4.getDia4());
            request.setAttribute("lstclsDia5", bl_clsDia5.getDia5());
            request.setAttribute("lstclsDia6", bl_clsDia6.getDia6());
            request.setAttribute("lstclsDia7", bl_clsDia7.getDia7());
            request.setAttribute("lstclsDia8", bl_clsDia8.getDia8());
            request.setAttribute("lstclsDia9", bl_clsDia9.getDia9());
            request.setAttribute("lstclsDia10", bl_clsDia10.getDia10());
            request.setAttribute("lstclsDia11", bl_clsDia11.getDia11());
            request.setAttribute("lstclsDia12", bl_clsDia12.getDia12());
            request.setAttribute("lstclsDia13", bl_clsDia13.getDia13());
            request.setAttribute("lstclsDia14", bl_clsDia14.getDia14());
            request.setAttribute("lstclsDia15", bl_clsDia15.getDia15());
            request.setAttribute("lstclsDia16", bl_clsDia16.getDia16());
            request.setAttribute("lstclsDia17", bl_clsDia17.getDia17());
            request.setAttribute("lstclsDia18", bl_clsDia18.getDia18());
            request.setAttribute("lstclsDia19", bl_clsDia19.getDia19());
            request.setAttribute("lstclsDia20", bl_clsDia20.getDia20());
            request.setAttribute("lstclsDia21", bl_clsDia21.getDia21());
            request.setAttribute("lstclsDia22", bl_clsDia22.getDia22());
            request.setAttribute("lstclsDia23", bl_clsDia23.getDia23());
            request.setAttribute("lstclsDia24", bl_clsDia24.getDia24());
            request.setAttribute("lstclsDia25", bl_clsDia25.getDia25());
            request.setAttribute("lstclsDia26", bl_clsDia26.getDia26());
            request.setAttribute("lstclsDia27", bl_clsDia27.getDia27());
            request.setAttribute("lstclsDia28", bl_clsDia28.getDia28());
            request.setAttribute("lstclsDia29", bl_clsDia29.getDia29());
            request.setAttribute("lstclsDia30", bl_clsDia30.getDia30());

            request.getRequestDispatcher("Estadisticas/editarestadisticas.jsp").forward(request, response);
        }

    }

    public void btnEditarEstaDia1(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();
            Modelos.Estadisticas.clsId_dia1 obclsDia1 = new Modelos.Estadisticas.clsId_dia1();

            if (request.getParameter("IdModificar") != null) {
                obclsEstadisticas.setId_estadistica(Integer.valueOf(request.getParameter("IdModificar")));
            }
            if (request.getParameter("ddlDia1") != null) {
                //Modelo Externo
                obclsDia1.setId_dia1(Integer.parseInt(request.getParameter("ddlDia1")));
                //Asignación al modelo padre
                obclsEstadisticas.setObId_dia1(obclsDia1);
            }
            //Definición de parametros desde el controlador
            request.setAttribute("stMensaje", bl_clsEstadisticas.updateEstaDia1(obclsEstadisticas));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            //Redireccion y envio de valores
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            BL.Estadisticas.clsDia1 bl_clsDia1 = new BL.Estadisticas.clsDia1();
            request.setAttribute("lstclsDia1", bl_clsDia1.getDia1());
            request.getRequestDispatcher("Estadisticas/editarestadisticasdia1.jsp").forward(request, response);

        }
    }

    public void btnEditarEstaDia2(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();
            Modelos.Estadisticas.clsId_dia2 obclsDia2 = new Modelos.Estadisticas.clsId_dia2();

            if (request.getParameter("IdModificar") != null) {
                obclsEstadisticas.setId_estadistica(Integer.valueOf(request.getParameter("IdModificar")));
            }
            if (request.getParameter("ddlDia2") != null) {
                //Modelo Externo
                obclsDia2.setId_dia2(Integer.parseInt(request.getParameter("ddlDia2")));
                //Asignación al modelo padre
                obclsEstadisticas.setObId_dia2(obclsDia2);
            }
            //Definición de parametros desde el controlador
            request.setAttribute("stMensaje", bl_clsEstadisticas.updateEstaDia2(obclsEstadisticas));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            //Redireccion y envio de valores
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            BL.Estadisticas.clsDia2 bl_clsDia2 = new BL.Estadisticas.clsDia2();
            request.setAttribute("lstclsDia2", bl_clsDia2.getDia2());
            request.getRequestDispatcher("Estadisticas/editarestadisticasdia2.jsp").forward(request, response);

        }
    }

    public void btnEditarEstaDia3(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();
            Modelos.Estadisticas.clsId_dia3 obclsDia3 = new Modelos.Estadisticas.clsId_dia3();

            if (request.getParameter("IdModificar") != null) {
                obclsEstadisticas.setId_estadistica(Integer.valueOf(request.getParameter("IdModificar")));
            }
            if (request.getParameter("ddlDia3") != null) {
                //Modelo Externo
                obclsDia3.setId_dia3(Integer.parseInt(request.getParameter("ddlDia3")));
                //Asignación al modelo padre
                obclsEstadisticas.setObId_dia3(obclsDia3);
            }
            //Definición de parametros desde el controlador
            request.setAttribute("stMensaje", bl_clsEstadisticas.updateEstaDia3(obclsEstadisticas));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            //Redireccion y envio de valores
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            BL.Estadisticas.clsDia3 bl_clsDia3 = new BL.Estadisticas.clsDia3();
            request.setAttribute("lstclsDia3", bl_clsDia3.getDia3());
            request.getRequestDispatcher("Estadisticas/editarestadisticasdia3.jsp").forward(request, response);

        }
    }

    public void btnEditarEstaDia4(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();
            Modelos.Estadisticas.clsId_dia4 obclsDia4 = new Modelos.Estadisticas.clsId_dia4();

            if (request.getParameter("IdModificar") != null) {
                obclsEstadisticas.setId_estadistica(Integer.valueOf(request.getParameter("IdModificar")));
            }
            if (request.getParameter("ddlDia4") != null) {
                //Modelo Externo
                obclsDia4.setId_dia4(Integer.parseInt(request.getParameter("ddlDia4")));
                //Asignación al modelo padre
                obclsEstadisticas.setObId_dia4(obclsDia4);
            }
            //Definición de parametros desde el controlador
            request.setAttribute("stMensaje", bl_clsEstadisticas.updateEstaDia4(obclsEstadisticas));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            //Redireccion y envio de valores
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            BL.Estadisticas.clsDia4 bl_clsDia4 = new BL.Estadisticas.clsDia4();
            request.setAttribute("lstclsDia4", bl_clsDia4.getDia4());
            request.getRequestDispatcher("Estadisticas/editarestadisticasdia4.jsp").forward(request, response);

        }
    }

    public void btnEditarEstaDia5(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();
            Modelos.Estadisticas.clsId_dia5 obclsDia5 = new Modelos.Estadisticas.clsId_dia5();

            if (request.getParameter("IdModificar") != null) {
                obclsEstadisticas.setId_estadistica(Integer.valueOf(request.getParameter("IdModificar")));
            }
            if (request.getParameter("ddlDia5") != null) {
                //Modelo Externo
                obclsDia5.setId_dia5(Integer.parseInt(request.getParameter("ddlDia5")));
                //Asignación al modelo padre
                obclsEstadisticas.setObId_dia5(obclsDia5);
            }
            //Definición de parametros desde el controlador
            request.setAttribute("stMensaje", bl_clsEstadisticas.updateEstaDia5(obclsEstadisticas));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            //Redireccion y envio de valores
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            BL.Estadisticas.clsDia5 bl_clsDia5 = new BL.Estadisticas.clsDia5();
            request.setAttribute("lstclsDia5", bl_clsDia5.getDia5());
            request.getRequestDispatcher("Estadisticas/editarestadisticasdia5.jsp").forward(request, response);

        }
    }

    public void btnEditarEstaDia6(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();
            Modelos.Estadisticas.clsId_dia6 obclsDia6 = new Modelos.Estadisticas.clsId_dia6();

            if (request.getParameter("IdModificar") != null) {
                obclsEstadisticas.setId_estadistica(Integer.valueOf(request.getParameter("IdModificar")));
            }
            if (request.getParameter("ddlDia6") != null) {
                //Modelo Externo
                obclsDia6.setId_dia6(Integer.parseInt(request.getParameter("ddlDia6")));
                //Asignación al modelo padre
                obclsEstadisticas.setObId_dia6(obclsDia6);
            }
            //Definición de parametros desde el controlador
            request.setAttribute("stMensaje", bl_clsEstadisticas.updateEstaDia6(obclsEstadisticas));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            //Redireccion y envio de valores
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            BL.Estadisticas.clsDia6 bl_clsDia6 = new BL.Estadisticas.clsDia6();
            request.setAttribute("lstclsDia6", bl_clsDia6.getDia6());
            request.getRequestDispatcher("Estadisticas/editarestadisticasdia6.jsp").forward(request, response);

        }
    }

    public void btnEditarEstaDia7(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();
            Modelos.Estadisticas.clsId_dia7 obclsDia7 = new Modelos.Estadisticas.clsId_dia7();

            if (request.getParameter("IdModificar") != null) {
                obclsEstadisticas.setId_estadistica(Integer.valueOf(request.getParameter("IdModificar")));
            }
            if (request.getParameter("ddlDia7") != null) {
                //Modelo Externo
                obclsDia7.setId_dia7(Integer.parseInt(request.getParameter("ddlDia7")));
                //Asignación al modelo padre
                obclsEstadisticas.setObId_dia7(obclsDia7);
            }
            //Definición de parametros desde el controlador
            request.setAttribute("stMensaje", bl_clsEstadisticas.updateEstaDia7(obclsEstadisticas));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            //Redireccion y envio de valores
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            BL.Estadisticas.clsDia7 bl_clsDia7 = new BL.Estadisticas.clsDia7();
            request.setAttribute("lstclsDia7", bl_clsDia7.getDia7());
            request.getRequestDispatcher("Estadisticas/editarestadisticasdia7.jsp").forward(request, response);

        }
    }

    public void btnEditarEstaDia8(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();
            Modelos.Estadisticas.clsId_dia8 obclsDia8 = new Modelos.Estadisticas.clsId_dia8();

            if (request.getParameter("IdModificar") != null) {
                obclsEstadisticas.setId_estadistica(Integer.valueOf(request.getParameter("IdModificar")));
            }
            if (request.getParameter("ddlDia8") != null) {
                //Modelo Externo
                obclsDia8.setId_dia8(Integer.parseInt(request.getParameter("ddlDia8")));
                //Asignación al modelo padre
                obclsEstadisticas.setObId_dia8(obclsDia8);
            }
            //Definición de parametros desde el controlador
            request.setAttribute("stMensaje", bl_clsEstadisticas.updateEstaDia8(obclsEstadisticas));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            //Redireccion y envio de valores
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            BL.Estadisticas.clsDia8 bl_clsDia8 = new BL.Estadisticas.clsDia8();
            request.setAttribute("lstclsDia8", bl_clsDia8.getDia8());
            request.getRequestDispatcher("Estadisticas/editarestadisticasdia8.jsp").forward(request, response);

        }
    }

    public void btnEditarEstaDia9(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();
            Modelos.Estadisticas.clsId_dia9 obclsDia9 = new Modelos.Estadisticas.clsId_dia9();

            if (request.getParameter("IdModificar") != null) {
                obclsEstadisticas.setId_estadistica(Integer.valueOf(request.getParameter("IdModificar")));
            }
            if (request.getParameter("ddlDia9") != null) {
                //Modelo Externo
                obclsDia9.setId_dia9(Integer.parseInt(request.getParameter("ddlDia9")));
                //Asignación al modelo padre
                obclsEstadisticas.setObId_dia9(obclsDia9);
            }
            //Definición de parametros desde el controlador
            request.setAttribute("stMensaje", bl_clsEstadisticas.updateEstaDia9(obclsEstadisticas));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            //Redireccion y envio de valores
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            BL.Estadisticas.clsDia9 bl_clsDia9 = new BL.Estadisticas.clsDia9();
            request.setAttribute("lstclsDia9", bl_clsDia9.getDia9());
            request.getRequestDispatcher("Estadisticas/editarestadisticasdia9.jsp").forward(request, response);

        }
    }

    public void btnEditarEstaDia10(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();
            Modelos.Estadisticas.clsId_dia10 obclsDia10 = new Modelos.Estadisticas.clsId_dia10();

            if (request.getParameter("IdModificar") != null) {
                obclsEstadisticas.setId_estadistica(Integer.valueOf(request.getParameter("IdModificar")));
            }
            if (request.getParameter("ddlDia10") != null) {
                //Modelo Externo
                obclsDia10.setId_dia10(Integer.parseInt(request.getParameter("ddlDia10")));
                //Asignación al modelo padre
                obclsEstadisticas.setObId_dia10(obclsDia10);
            }
            //Definición de parametros desde el controlador
            request.setAttribute("stMensaje", bl_clsEstadisticas.updateEstaDia10(obclsEstadisticas));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            //Redireccion y envio de valores
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            BL.Estadisticas.clsDia10 bl_clsDia10 = new BL.Estadisticas.clsDia10();
            request.setAttribute("lstclsDia10", bl_clsDia10.getDia10());
            request.getRequestDispatcher("Estadisticas/editarestadisticasdia10.jsp").forward(request, response);

        }
    }

    public void btnEditarEstaDia11(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();
            Modelos.Estadisticas.clsId_dia11 obclsDia11 = new Modelos.Estadisticas.clsId_dia11();

            if (request.getParameter("IdModificar") != null) {
                obclsEstadisticas.setId_estadistica(Integer.valueOf(request.getParameter("IdModificar")));
            }
            if (request.getParameter("ddlDia11") != null) {
                //Modelo Externo
                obclsDia11.setId_dia11(Integer.parseInt(request.getParameter("ddlDia11")));
                //Asignación al modelo padre
                obclsEstadisticas.setObId_dia11(obclsDia11);
            }
            //Definición de parametros desde el controlador
            request.setAttribute("stMensaje", bl_clsEstadisticas.updateEstaDia11(obclsEstadisticas));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            //Redireccion y envio de valores
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            BL.Estadisticas.clsDia11 bl_clsDia11 = new BL.Estadisticas.clsDia11();
            request.setAttribute("lstclsDia11", bl_clsDia11.getDia11());
            request.getRequestDispatcher("Estadisticas/editarestadisticasdia11.jsp").forward(request, response);

        }
    }

    public void btnEditarEstaDia12(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();
            Modelos.Estadisticas.clsId_dia12 obclsDia12 = new Modelos.Estadisticas.clsId_dia12();

            if (request.getParameter("IdModificar") != null) {
                obclsEstadisticas.setId_estadistica(Integer.valueOf(request.getParameter("IdModificar")));
            }
            if (request.getParameter("ddlDia12") != null) {
                //Modelo Externo
                obclsDia12.setId_dia12(Integer.parseInt(request.getParameter("ddlDia12")));
                //Asignación al modelo padre
                obclsEstadisticas.setObId_dia12(obclsDia12);
            }
            //Definición de parametros desde el controlador
            request.setAttribute("stMensaje", bl_clsEstadisticas.updateEstaDia12(obclsEstadisticas));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            //Redireccion y envio de valores
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            BL.Estadisticas.clsDia12 bl_clsDia12 = new BL.Estadisticas.clsDia12();
            request.setAttribute("lstclsDia12", bl_clsDia12.getDia12());
            request.getRequestDispatcher("Estadisticas/editarestadisticasdia12.jsp").forward(request, response);

        }
    }

    public void btnEditarEstaDia13(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();
            Modelos.Estadisticas.clsId_dia13 obclsDia13 = new Modelos.Estadisticas.clsId_dia13();

            if (request.getParameter("IdModificar") != null) {
                obclsEstadisticas.setId_estadistica(Integer.valueOf(request.getParameter("IdModificar")));
            }
            if (request.getParameter("ddlDia13") != null) {
                //Modelo Externo
                obclsDia13.setId_dia13(Integer.parseInt(request.getParameter("ddlDia13")));
                //Asignación al modelo padre
                obclsEstadisticas.setObId_dia13(obclsDia13);
            }
            //Definición de parametros desde el controlador
            request.setAttribute("stMensaje", bl_clsEstadisticas.updateEstaDia13(obclsEstadisticas));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            //Redireccion y envio de valores
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            BL.Estadisticas.clsDia13 bl_clsDia13 = new BL.Estadisticas.clsDia13();
            request.setAttribute("lstclsDia13", bl_clsDia13.getDia13());
            request.getRequestDispatcher("Estadisticas/editarestadisticasdia13.jsp").forward(request, response);

        }
    }

    public void btnEditarEstaDia14(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();
            Modelos.Estadisticas.clsId_dia14 obclsDia14 = new Modelos.Estadisticas.clsId_dia14();

            if (request.getParameter("IdModificar") != null) {
                obclsEstadisticas.setId_estadistica(Integer.valueOf(request.getParameter("IdModificar")));
            }
            if (request.getParameter("ddlDia14") != null) {
                //Modelo Externo
                obclsDia14.setId_dia14(Integer.parseInt(request.getParameter("ddlDia14")));
                //Asignación al modelo padre
                obclsEstadisticas.setObId_dia14(obclsDia14);
            }
            //Definición de parametros desde el controlador
            request.setAttribute("stMensaje", bl_clsEstadisticas.updateEstaDia14(obclsEstadisticas));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            //Redireccion y envio de valores
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            BL.Estadisticas.clsDia14 bl_clsDia14 = new BL.Estadisticas.clsDia14();
            request.setAttribute("lstclsDia14", bl_clsDia14.getDia14());
            request.getRequestDispatcher("Estadisticas/editarestadisticasdia14.jsp").forward(request, response);

        }
    }

    public void btnEditarEstaDia15(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();
            Modelos.Estadisticas.clsId_dia15 obclsDia15 = new Modelos.Estadisticas.clsId_dia15();

            if (request.getParameter("IdModificar") != null) {
                obclsEstadisticas.setId_estadistica(Integer.valueOf(request.getParameter("IdModificar")));
            }
            if (request.getParameter("ddlDia15") != null) {
                //Modelo Externo
                obclsDia15.setId_dia15(Integer.parseInt(request.getParameter("ddlDia15")));
                //Asignación al modelo padre
                obclsEstadisticas.setObId_dia15(obclsDia15);
            }
            //Definición de parametros desde el controlador
            request.setAttribute("stMensaje", bl_clsEstadisticas.updateEstaDia15(obclsEstadisticas));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            //Redireccion y envio de valores
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            BL.Estadisticas.clsDia15 bl_clsDia15 = new BL.Estadisticas.clsDia15();
            request.setAttribute("lstclsDia15", bl_clsDia15.getDia15());
            request.getRequestDispatcher("Estadisticas/editarestadisticasdia15.jspp").forward(request, response);

        }
    }

    public void btnEditarEstaDia16(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();
            Modelos.Estadisticas.clsId_dia16 obclsDia16 = new Modelos.Estadisticas.clsId_dia16();

            if (request.getParameter("IdModificar") != null) {
                obclsEstadisticas.setId_estadistica(Integer.valueOf(request.getParameter("IdModificar")));
            }
            if (request.getParameter("ddlDia16") != null) {
                //Modelo Externo
                obclsDia16.setId_dia16(Integer.parseInt(request.getParameter("ddlDia16")));
                //Asignación al modelo padre
                obclsEstadisticas.setObId_dia16(obclsDia16);
            }
            //Definición de parametros desde el controlador
            request.setAttribute("stMensaje", bl_clsEstadisticas.updateEstaDia16(obclsEstadisticas));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            //Redireccion y envio de valores
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            BL.Estadisticas.clsDia16 bl_clsDia16 = new BL.Estadisticas.clsDia16();
            request.setAttribute("lstclsDia16", bl_clsDia16.getDia16());
            request.getRequestDispatcher("Estadisticas/editarestadisticasdia16.jsp").forward(request, response);

        }
    }

    public void btnEditarEstaDia17(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();
            Modelos.Estadisticas.clsId_dia17 obclsDia17 = new Modelos.Estadisticas.clsId_dia17();

            if (request.getParameter("IdModificar") != null) {
                obclsEstadisticas.setId_estadistica(Integer.valueOf(request.getParameter("IdModificar")));
            }
            if (request.getParameter("ddlDia17") != null) {
                //Modelo Externo
                obclsDia17.setId_dia17(Integer.parseInt(request.getParameter("ddlDia17")));
                //Asignación al modelo padre
                obclsEstadisticas.setObId_dia17(obclsDia17);
            }
            //Definición de parametros desde el controlador
            request.setAttribute("stMensaje", bl_clsEstadisticas.updateEstaDia17(obclsEstadisticas));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            //Redireccion y envio de valores
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            BL.Estadisticas.clsDia17 bl_clsDia17 = new BL.Estadisticas.clsDia17();
            request.setAttribute("lstclsDia17", bl_clsDia17.getDia17());
            request.getRequestDispatcher("Estadisticas/editarestadisticasdia17.jsp").forward(request, response);

        }
    }

    public void btnEditarEstaDia18(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();
            Modelos.Estadisticas.clsId_dia18 obclsDia18 = new Modelos.Estadisticas.clsId_dia18();

            if (request.getParameter("IdModificar") != null) {
                obclsEstadisticas.setId_estadistica(Integer.valueOf(request.getParameter("IdModificar")));
            }
            if (request.getParameter("ddlDia18") != null) {
                //Modelo Externo
                obclsDia18.setId_dia18(Integer.parseInt(request.getParameter("ddlDia18")));
                //Asignación al modelo padre
                obclsEstadisticas.setObId_dia18(obclsDia18);
            }
            //Definición de parametros desde el controlador
            request.setAttribute("stMensaje", bl_clsEstadisticas.updateEstaDia18(obclsEstadisticas));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            //Redireccion y envio de valores
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            BL.Estadisticas.clsDia18 bl_clsDia18 = new BL.Estadisticas.clsDia18();
            request.setAttribute("lstclsDia18", bl_clsDia18.getDia18());
            request.getRequestDispatcher("Estadisticas/editarestadisticasdia18.jsp").forward(request, response);

        }
    }

    public void btnEditarEstaDia19(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();
            Modelos.Estadisticas.clsId_dia19 obclsDia19 = new Modelos.Estadisticas.clsId_dia19();

            if (request.getParameter("IdModificar") != null) {
                obclsEstadisticas.setId_estadistica(Integer.valueOf(request.getParameter("IdModificar")));
            }
            if (request.getParameter("ddlDia19") != null) {
                //Modelo Externo
                obclsDia19.setId_dia19(Integer.parseInt(request.getParameter("ddlDia19")));
                //Asignación al modelo padre
                obclsEstadisticas.setObId_dia19(obclsDia19);
            }
            //Definición de parametros desde el controlador
            request.setAttribute("stMensaje", bl_clsEstadisticas.updateEstaDia19(obclsEstadisticas));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            //Redireccion y envio de valores
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            BL.Estadisticas.clsDia19 bl_clsDia19 = new BL.Estadisticas.clsDia19();
            request.setAttribute("lstclsDia19", bl_clsDia19.getDia19());
            request.getRequestDispatcher("Estadisticas/editarestadisticasdia19.jsp").forward(request, response);

        }
    }

    public void btnEditarEstaDia20(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();
            Modelos.Estadisticas.clsId_dia20 obclsDia20 = new Modelos.Estadisticas.clsId_dia20();

            if (request.getParameter("IdModificar") != null) {
                obclsEstadisticas.setId_estadistica(Integer.valueOf(request.getParameter("IdModificar")));
            }
            if (request.getParameter("ddlDia20") != null) {
                //Modelo Externo
                obclsDia20.setId_dia20(Integer.parseInt(request.getParameter("ddlDia20")));
                //Asignación al modelo padre
                obclsEstadisticas.setObId_dia20(obclsDia20);
            }
            //Definición de parametros desde el controlador
            request.setAttribute("stMensaje", bl_clsEstadisticas.updateEstaDia20(obclsEstadisticas));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            //Redireccion y envio de valores
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            BL.Estadisticas.clsDia20 bl_clsDia20 = new BL.Estadisticas.clsDia20();
            request.setAttribute("lstclsDia20", bl_clsDia20.getDia20());
            request.getRequestDispatcher("Estadisticas/editarestadisticasdia20.jsp").forward(request, response);

        }
    }

    public void btnEditarEstaDia21(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();
            Modelos.Estadisticas.clsId_dia21 obclsDia21 = new Modelos.Estadisticas.clsId_dia21();

            if (request.getParameter("IdModificar") != null) {
                obclsEstadisticas.setId_estadistica(Integer.valueOf(request.getParameter("IdModificar")));
            }
            if (request.getParameter("ddlDia21") != null) {
                //Modelo Externo
                obclsDia21.setId_dia21(Integer.parseInt(request.getParameter("ddlDia21")));
                //Asignación al modelo padre
                obclsEstadisticas.setObId_dia21(obclsDia21);
            }
            //Definición de parametros desde el controlador
            request.setAttribute("stMensaje", bl_clsEstadisticas.updateEstaDia21(obclsEstadisticas));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            //Redireccion y envio de valores
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            BL.Estadisticas.clsDia21 bl_clsDia21 = new BL.Estadisticas.clsDia21();
            request.setAttribute("lstclsDia21", bl_clsDia21.getDia21());
            request.getRequestDispatcher("Estadisticas/editarestadisticasdia21.jsp").forward(request, response);

        }
    }

    public void btnEditarEstaDia22(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();
            Modelos.Estadisticas.clsId_dia22 obclsDia22 = new Modelos.Estadisticas.clsId_dia22();

            if (request.getParameter("IdModificar") != null) {
                obclsEstadisticas.setId_estadistica(Integer.valueOf(request.getParameter("IdModificar")));
            }
            if (request.getParameter("ddlDia22") != null) {
                //Modelo Externo
                obclsDia22.setId_dia22(Integer.parseInt(request.getParameter("ddlDia22")));
                //Asignación al modelo padre
                obclsEstadisticas.setObId_dia22(obclsDia22);
            }
            //Definición de parametros desde el controlador
            request.setAttribute("stMensaje", bl_clsEstadisticas.updateEstaDia22(obclsEstadisticas));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            //Redireccion y envio de valores
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            BL.Estadisticas.clsDia22 bl_clsDia22 = new BL.Estadisticas.clsDia22();
            request.setAttribute("lstclsDia22", bl_clsDia22.getDia22());
            request.getRequestDispatcher("Estadisticas/editarestadisticasdia22.jsp").forward(request, response);

        }
    }

    public void btnEditarEstaDia23(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();
            Modelos.Estadisticas.clsId_dia23 obclsDia23 = new Modelos.Estadisticas.clsId_dia23();

            if (request.getParameter("IdModificar") != null) {
                obclsEstadisticas.setId_estadistica(Integer.valueOf(request.getParameter("IdModificar")));
            }
            if (request.getParameter("ddlDia23") != null) {
                //Modelo Externo
                obclsDia23.setId_dia23(Integer.parseInt(request.getParameter("ddlDia23")));
                //Asignación al modelo padre
                obclsEstadisticas.setObId_dia23(obclsDia23);
            }
            //Definición de parametros desde el controlador
            request.setAttribute("stMensaje", bl_clsEstadisticas.updateEstaDia23(obclsEstadisticas));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            //Redireccion y envio de valores
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            BL.Estadisticas.clsDia23 bl_clsDia23 = new BL.Estadisticas.clsDia23();
            request.setAttribute("lstclsDia23", bl_clsDia23.getDia23());
            request.getRequestDispatcher("Estadisticas/editarestadisticasdia23.jsp").forward(request, response);

        }
    }

    public void btnEditarEstaDia24(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();
            Modelos.Estadisticas.clsId_dia24 obclsDia24 = new Modelos.Estadisticas.clsId_dia24();

            if (request.getParameter("IdModificar") != null) {
                obclsEstadisticas.setId_estadistica(Integer.valueOf(request.getParameter("IdModificar")));
            }
            if (request.getParameter("ddlDia24") != null) {
                //Modelo Externo
                obclsDia24.setId_dia24(Integer.parseInt(request.getParameter("ddlDia24")));
                //Asignación al modelo padre
                obclsEstadisticas.setObId_dia24(obclsDia24);
            }
            //Definición de parametros desde el controlador
            request.setAttribute("stMensaje", bl_clsEstadisticas.updateEstaDia24(obclsEstadisticas));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            //Redireccion y envio de valores
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            BL.Estadisticas.clsDia24 bl_clsDia24 = new BL.Estadisticas.clsDia24();
            request.setAttribute("lstclsDia24", bl_clsDia24.getDia24());
            request.getRequestDispatcher("Estadisticas/editarestadisticasdia24.jsp").forward(request, response);

        }
    }

    public void btnEditarEstaDia25(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();
            Modelos.Estadisticas.clsId_dia25 obclsDia25 = new Modelos.Estadisticas.clsId_dia25();

            if (request.getParameter("IdModificar") != null) {
                obclsEstadisticas.setId_estadistica(Integer.valueOf(request.getParameter("IdModificar")));
            }
            if (request.getParameter("ddlDia25") != null) {
                //Modelo Externo
                obclsDia25.setId_dia25(Integer.parseInt(request.getParameter("ddlDia25")));
                //Asignación al modelo padre
                obclsEstadisticas.setObId_dia25(obclsDia25);
            }
            //Definición de parametros desde el controlador
            request.setAttribute("stMensaje", bl_clsEstadisticas.updateEstaDia25(obclsEstadisticas));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            //Redireccion y envio de valores
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            BL.Estadisticas.clsDia25 bl_clsDia25 = new BL.Estadisticas.clsDia25();
            request.setAttribute("lstclsDia25", bl_clsDia25.getDia25());
            request.getRequestDispatcher("Estadisticas/editarestadisticasdia25.jsp").forward(request, response);

        }
    }

    public void btnEditarEstaDia26(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();
            Modelos.Estadisticas.clsId_dia26 obclsDia26 = new Modelos.Estadisticas.clsId_dia26();

            if (request.getParameter("IdModificar") != null) {
                obclsEstadisticas.setId_estadistica(Integer.valueOf(request.getParameter("IdModificar")));
            }
            if (request.getParameter("ddlDia26") != null) {
                //Modelo Externo
                obclsDia26.setId_dia26(Integer.parseInt(request.getParameter("ddlDia26")));
                //Asignación al modelo padre
                obclsEstadisticas.setObId_dia26(obclsDia26);
            }
            //Definición de parametros desde el controlador
            request.setAttribute("stMensaje", bl_clsEstadisticas.updateEstaDia26(obclsEstadisticas));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            //Redireccion y envio de valores
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            BL.Estadisticas.clsDia26 bl_clsDia26 = new BL.Estadisticas.clsDia26();
            request.setAttribute("lstclsDia26", bl_clsDia26.getDia26());
            request.getRequestDispatcher("Estadisticas/editarestadisticasdia26.jsp").forward(request, response);

        }
    }

    public void btnEditarEstaDia27(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();
            Modelos.Estadisticas.clsId_dia27 obclsDia27 = new Modelos.Estadisticas.clsId_dia27();

            if (request.getParameter("IdModificar") != null) {
                obclsEstadisticas.setId_estadistica(Integer.valueOf(request.getParameter("IdModificar")));
            }
            if (request.getParameter("ddlDia27") != null) {
                //Modelo Externo
                obclsDia27.setId_dia27(Integer.parseInt(request.getParameter("ddlDia27")));
                //Asignación al modelo padre
                obclsEstadisticas.setObId_dia27(obclsDia27);
            }
            //Definición de parametros desde el controlador
            request.setAttribute("stMensaje", bl_clsEstadisticas.updateEstaDia27(obclsEstadisticas));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            //Redireccion y envio de valores
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            BL.Estadisticas.clsDia27 bl_clsDia27 = new BL.Estadisticas.clsDia27();
            request.setAttribute("lstclsDia27", bl_clsDia27.getDia27());
            request.getRequestDispatcher("Estadisticas/editarestadisticasdia27.jsp").forward(request, response);

        }
    }

    public void btnEditarEstaDia28(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();
            Modelos.Estadisticas.clsId_dia28 obclsDia28 = new Modelos.Estadisticas.clsId_dia28();

            if (request.getParameter("IdModificar") != null) {
                obclsEstadisticas.setId_estadistica(Integer.valueOf(request.getParameter("IdModificar")));
            }
            if (request.getParameter("ddlDia28") != null) {
                //Modelo Externo
                obclsDia28.setId_dia28(Integer.parseInt(request.getParameter("ddlDia28")));
                //Asignación al modelo padre
                obclsEstadisticas.setObId_dia28(obclsDia28);
            }
            //Definición de parametros desde el controlador
            request.setAttribute("stMensaje", bl_clsEstadisticas.updateEstaDia28(obclsEstadisticas));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            //Redireccion y envio de valores
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            BL.Estadisticas.clsDia28 bl_clsDia28 = new BL.Estadisticas.clsDia28();
            request.setAttribute("lstclsDia28", bl_clsDia28.getDia28());
            request.getRequestDispatcher("Estadisticas/editarestadisticasdia28.jsp").forward(request, response);

        }
    }

    public void btnEditarEstaDia29(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();
            Modelos.Estadisticas.clsId_dia29 obclsDia29 = new Modelos.Estadisticas.clsId_dia29();

            if (request.getParameter("IdModificar") != null) {
                obclsEstadisticas.setId_estadistica(Integer.valueOf(request.getParameter("IdModificar")));
            }
            if (request.getParameter("ddlDia29") != null) {
                //Modelo Externo
                obclsDia29.setId_dia29(Integer.parseInt(request.getParameter("ddlDia29")));
                //Asignación al modelo padre
                obclsEstadisticas.setObId_dia29(obclsDia29);
            }
            //Definición de parametros desde el controlador
            request.setAttribute("stMensaje", bl_clsEstadisticas.updateEstaDia29(obclsEstadisticas));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            //Redireccion y envio de valores
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            BL.Estadisticas.clsDia29 bl_clsDia29 = new BL.Estadisticas.clsDia29();
            request.setAttribute("lstclsDia29", bl_clsDia29.getDia29());
            request.getRequestDispatcher("Estadisticas/editarestadisticasdia29.jsp").forward(request, response);

        }
    }

    public void btnEditarEstaDia30(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();
            Modelos.Estadisticas.clsId_dia30 obclsDia30 = new Modelos.Estadisticas.clsId_dia30();

            if (request.getParameter("IdModificar") != null) {
                obclsEstadisticas.setId_estadistica(Integer.valueOf(request.getParameter("IdModificar")));
            }
            if (request.getParameter("ddlDia30") != null) {
                //Modelo Externo
                obclsDia30.setId_dia30(Integer.parseInt(request.getParameter("ddlDia30")));
                //Asignación al modelo padre
                obclsEstadisticas.setObId_dia30(obclsDia30);
            }
            //Definición de parametros desde el controlador
            request.setAttribute("stMensaje", bl_clsEstadisticas.updateEstaDia30(obclsEstadisticas));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            //Redireccion y envio de valores
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

            BL.Estadisticas.clsDia30 bl_clsDia30 = new BL.Estadisticas.clsDia30();
            request.setAttribute("lstclsDia30", bl_clsDia30.getDia30());
            request.getRequestDispatcher("Estadisticas/editarestadisticasdia30.jsp").forward(request, response);

        }
    }

    public void btnEliminarEsta(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_Estadisticas = new BL.Estadisticas.clsEstadisticas();

            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();

            if (request.getParameter("IdModificar") != null) {
                obclsEstadisticas.setId_estadistica(Integer.valueOf(request.getParameter("IdModificar")));
            }
            request.setAttribute("stMensaje", bl_Estadisticas.deleteEstadistica(obclsEstadisticas));
            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsEstadisticas", bl_Estadisticas.getEstadisticas());

            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);
        } catch (Exception ex) {

            request.setAttribute("stTipo", "error");
            request.setAttribute("stMensaje", ex.getMessage());
            request.getRequestDispatcher("Estadisticas/eliminarestadisticas.jsp").forward(request, response);
        }
    }

    public void btnBuscarEstaMensualidad(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();

            Modelos.Estadisticas.clsBuscar obclsBuscar = new Modelos.Estadisticas.clsBuscar();

            if (request.getParameter("txtBuscarEsta") != null) {

                obclsBuscar.setStBuscar(request.getParameter("txtBuscarEsta"));
            }

            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getBuscarEstadisticas(obclsBuscar));

            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("stTipo", "error");
            request.setAttribute("stMensaje", ex.getMessage());

            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);
        }
    }

    public void btnBuscarEstaQuincena1(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();

            Modelos.Estadisticas.clsBuscar obclsBuscar = new Modelos.Estadisticas.clsBuscar();

            if (request.getParameter("txtBuscarEsta") != null) {

                obclsBuscar.setStBuscar(request.getParameter("txtBuscarEsta"));
            }

            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getBuscarEstadisticas(obclsBuscar));

            request.getRequestDispatcher("Estadisticas/estadisticasquincena1.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("stTipo", "error");
            request.setAttribute("stMensaje", ex.getMessage());

            request.getRequestDispatcher("Estadisticas/estadisticasquincena1.jsp").forward(request, response);
        }
    }

    public void btnBuscarEstaQuincena2(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();

            Modelos.Estadisticas.clsBuscar obclsBuscar = new Modelos.Estadisticas.clsBuscar();

            if (request.getParameter("txtBuscarEsta") != null) {

                obclsBuscar.setStBuscar(request.getParameter("txtBuscarEsta"));
            }

            request.setAttribute("stTipo", "success");
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getBuscarEstadisticas(obclsBuscar));

            request.getRequestDispatcher("Estadisticas/estadisticasquincena2.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("stTipo", "error");
            request.setAttribute("stMensaje", ex.getMessage());

            request.getRequestDispatcher("Estadisticas/estadisticasquincena2.jsp").forward(request, response);
        }
    }

    public void cargarEditarEstaDia1(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();

            List<Modelos.Estadisticas.clsEstadisticas> lstclsEstadisticas = new ArrayList<Modelos.Estadisticas.clsEstadisticas>();

            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();

            lstclsEstadisticas = bl_clsEstadisticas.getEstadisticas();

            for (Modelos.Estadisticas.clsEstadisticas elem : lstclsEstadisticas) {
                if (elem.getId_estadistica() == Integer.parseInt(request.getParameter("codigoDia1"))) {
                    obclsEstadisticas = elem;
                    break;
                }
            }
            //Lista Dia 1 
            BL.Estadisticas.clsDia1 bl_clsDia1 = new BL.Estadisticas.clsDia1();
            request.setAttribute("lstclsDia1", bl_clsDia1.getDia1());

            request.setAttribute("obclsEstadisticas", obclsEstadisticas);
            request.setAttribute("lstclsEstadisticas", lstclsEstadisticas);
            request.getRequestDispatcher("Estadisticas/editarestadisticasdia1.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

            ex.getMessage();

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

        }
    }

    public void cargarEditarEstaDia2(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();

            List<Modelos.Estadisticas.clsEstadisticas> lstclsEstadisticas = new ArrayList<Modelos.Estadisticas.clsEstadisticas>();

            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();

            lstclsEstadisticas = bl_clsEstadisticas.getEstadisticas();

            for (Modelos.Estadisticas.clsEstadisticas elem : lstclsEstadisticas) {
                if (elem.getId_estadistica() == Integer.parseInt(request.getParameter("codigoDia2"))) {
                    obclsEstadisticas = elem;
                    break;
                }
            }
            //Lista Dia 2 
            BL.Estadisticas.clsDia2 bl_clsDia2 = new BL.Estadisticas.clsDia2();
            request.setAttribute("lstclsDia2", bl_clsDia2.getDia2());

            request.setAttribute("obclsEstadisticas", obclsEstadisticas);
            request.setAttribute("lstclsEstadisticas", lstclsEstadisticas);
            request.getRequestDispatcher("Estadisticas/editarestadisticasdia2.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

            ex.getMessage();

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

        }
    }

    public void cargarEditarEstaDia3(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();

            List<Modelos.Estadisticas.clsEstadisticas> lstclsEstadisticas = new ArrayList<Modelos.Estadisticas.clsEstadisticas>();

            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();

            lstclsEstadisticas = bl_clsEstadisticas.getEstadisticas();

            for (Modelos.Estadisticas.clsEstadisticas elem : lstclsEstadisticas) {
                if (elem.getId_estadistica() == Integer.parseInt(request.getParameter("codigoDia3"))) {
                    obclsEstadisticas = elem;
                    break;
                }
            }
            //Lista Dia 2 
            BL.Estadisticas.clsDia3 bl_clsDia3 = new BL.Estadisticas.clsDia3();
            request.setAttribute("lstclsDia3", bl_clsDia3.getDia3());

            request.setAttribute("obclsEstadisticas", obclsEstadisticas);
            request.setAttribute("lstclsEstadisticas", lstclsEstadisticas);
            request.getRequestDispatcher("Estadisticas/editarestadisticasdia3.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

            ex.getMessage();

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

        }
    }

    public void cargarEditarEstaDia4(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();

            List<Modelos.Estadisticas.clsEstadisticas> lstclsEstadisticas = new ArrayList<Modelos.Estadisticas.clsEstadisticas>();

            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();

            lstclsEstadisticas = bl_clsEstadisticas.getEstadisticas();

            for (Modelos.Estadisticas.clsEstadisticas elem : lstclsEstadisticas) {
                if (elem.getId_estadistica() == Integer.parseInt(request.getParameter("codigoDia4"))) {
                    obclsEstadisticas = elem;
                    break;
                }
            }
            //Lista Dia 2 
            BL.Estadisticas.clsDia4 bl_clsDia4 = new BL.Estadisticas.clsDia4();
            request.setAttribute("lstclsDia4", bl_clsDia4.getDia4());

            request.setAttribute("obclsEstadisticas", obclsEstadisticas);
            request.setAttribute("lstclsEstadisticas", lstclsEstadisticas);
            request.getRequestDispatcher("Estadisticas/editarestadisticasdia4.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

            ex.getMessage();

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

        }
    }

    public void cargarEditarEstaDia5(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();

            List<Modelos.Estadisticas.clsEstadisticas> lstclsEstadisticas = new ArrayList<Modelos.Estadisticas.clsEstadisticas>();

            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();

            lstclsEstadisticas = bl_clsEstadisticas.getEstadisticas();

            for (Modelos.Estadisticas.clsEstadisticas elem : lstclsEstadisticas) {
                if (elem.getId_estadistica() == Integer.parseInt(request.getParameter("codigoDia5"))) {
                    obclsEstadisticas = elem;
                    break;
                }
            }
            //Lista Dia 2 
            BL.Estadisticas.clsDia5 bl_clsDia5 = new BL.Estadisticas.clsDia5();
            request.setAttribute("lstclsDia5", bl_clsDia5.getDia5());

            request.setAttribute("obclsEstadisticas", obclsEstadisticas);
            request.setAttribute("lstclsEstadisticas", lstclsEstadisticas);
            request.getRequestDispatcher("Estadisticas/editarestadisticasdia5.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

            ex.getMessage();

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

        }
    }

    public void cargarEditarEstaDia6(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();

            List<Modelos.Estadisticas.clsEstadisticas> lstclsEstadisticas = new ArrayList<Modelos.Estadisticas.clsEstadisticas>();

            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();

            lstclsEstadisticas = bl_clsEstadisticas.getEstadisticas();

            for (Modelos.Estadisticas.clsEstadisticas elem : lstclsEstadisticas) {
                if (elem.getId_estadistica() == Integer.parseInt(request.getParameter("codigoDia6"))) {
                    obclsEstadisticas = elem;
                    break;
                }
            }
            //Lista Dia 2 
            BL.Estadisticas.clsDia6 bl_clsDia6 = new BL.Estadisticas.clsDia6();
            request.setAttribute("lstclsDia6", bl_clsDia6.getDia6());

            request.setAttribute("obclsEstadisticas", obclsEstadisticas);
            request.setAttribute("lstclsEstadisticas", lstclsEstadisticas);
            request.getRequestDispatcher("Estadisticas/editarestadisticasdia6.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

            ex.getMessage();

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

        }
    }

    public void cargarEditarEstaDia7(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();

            List<Modelos.Estadisticas.clsEstadisticas> lstclsEstadisticas = new ArrayList<Modelos.Estadisticas.clsEstadisticas>();

            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();

            lstclsEstadisticas = bl_clsEstadisticas.getEstadisticas();

            for (Modelos.Estadisticas.clsEstadisticas elem : lstclsEstadisticas) {
                if (elem.getId_estadistica() == Integer.parseInt(request.getParameter("codigoDia7"))) {
                    obclsEstadisticas = elem;
                    break;
                }
            }
            //Lista Dia 2 
            BL.Estadisticas.clsDia7 bl_clsDia7 = new BL.Estadisticas.clsDia7();
            request.setAttribute("lstclsDia7", bl_clsDia7.getDia7());

            request.setAttribute("obclsEstadisticas", obclsEstadisticas);
            request.setAttribute("lstclsEstadisticas", lstclsEstadisticas);
            request.getRequestDispatcher("Estadisticas/editarestadisticasdia7.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

            ex.getMessage();

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

        }
    }

    public void cargarEditarEstaDia8(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();

            List<Modelos.Estadisticas.clsEstadisticas> lstclsEstadisticas = new ArrayList<Modelos.Estadisticas.clsEstadisticas>();

            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();

            lstclsEstadisticas = bl_clsEstadisticas.getEstadisticas();

            for (Modelos.Estadisticas.clsEstadisticas elem : lstclsEstadisticas) {
                if (elem.getId_estadistica() == Integer.parseInt(request.getParameter("codigoDia8"))) {
                    obclsEstadisticas = elem;
                    break;
                }
            }
            //Lista Dia 2 
            BL.Estadisticas.clsDia8 bl_clsDia8 = new BL.Estadisticas.clsDia8();
            request.setAttribute("lstclsDia8", bl_clsDia8.getDia8());

            request.setAttribute("obclsEstadisticas", obclsEstadisticas);
            request.setAttribute("lstclsEstadisticas", lstclsEstadisticas);
            request.getRequestDispatcher("Estadisticas/editarestadisticasdia8.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

            ex.getMessage();

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

        }
    }

    public void cargarEditarEstaDia9(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();

            List<Modelos.Estadisticas.clsEstadisticas> lstclsEstadisticas = new ArrayList<Modelos.Estadisticas.clsEstadisticas>();

            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();

            lstclsEstadisticas = bl_clsEstadisticas.getEstadisticas();

            for (Modelos.Estadisticas.clsEstadisticas elem : lstclsEstadisticas) {
                if (elem.getId_estadistica() == Integer.parseInt(request.getParameter("codigoDia9"))) {
                    obclsEstadisticas = elem;
                    break;
                }
            }
            //Lista Dia 2 
            BL.Estadisticas.clsDia9 bl_clsDia9 = new BL.Estadisticas.clsDia9();
            request.setAttribute("lstclsDia9", bl_clsDia9.getDia9());

            request.setAttribute("obclsEstadisticas", obclsEstadisticas);
            request.setAttribute("lstclsEstadisticas", lstclsEstadisticas);
            request.getRequestDispatcher("Estadisticas/editarestadisticasdia9.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

            ex.getMessage();

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

        }
    }

    public void cargarEditarEstaDia10(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();

            List<Modelos.Estadisticas.clsEstadisticas> lstclsEstadisticas = new ArrayList<Modelos.Estadisticas.clsEstadisticas>();

            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();

            lstclsEstadisticas = bl_clsEstadisticas.getEstadisticas();

            for (Modelos.Estadisticas.clsEstadisticas elem : lstclsEstadisticas) {
                if (elem.getId_estadistica() == Integer.parseInt(request.getParameter("codigoDia10"))) {
                    obclsEstadisticas = elem;
                    break;
                }
            }
            //Lista Dia 2 
            BL.Estadisticas.clsDia10 bl_clsDia10 = new BL.Estadisticas.clsDia10();
            request.setAttribute("lstclsDia10", bl_clsDia10.getDia10());

            request.setAttribute("obclsEstadisticas", obclsEstadisticas);
            request.setAttribute("lstclsEstadisticas", lstclsEstadisticas);
            request.getRequestDispatcher("Estadisticas/editarestadisticasdia10.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

            ex.getMessage();

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

        }
    }

    public void cargarEditarEstaDia11(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();

            List<Modelos.Estadisticas.clsEstadisticas> lstclsEstadisticas = new ArrayList<Modelos.Estadisticas.clsEstadisticas>();

            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();

            lstclsEstadisticas = bl_clsEstadisticas.getEstadisticas();

            for (Modelos.Estadisticas.clsEstadisticas elem : lstclsEstadisticas) {
                if (elem.getId_estadistica() == Integer.parseInt(request.getParameter("codigoDia11"))) {
                    obclsEstadisticas = elem;
                    break;
                }
            }
            //Lista Dia 2 
            BL.Estadisticas.clsDia11 bl_clsDia11 = new BL.Estadisticas.clsDia11();
            request.setAttribute("lstclsDia11", bl_clsDia11.getDia11());

            request.setAttribute("obclsEstadisticas", obclsEstadisticas);
            request.setAttribute("lstclsEstadisticas", lstclsEstadisticas);
            request.getRequestDispatcher("Estadisticas/editarestadisticasdia11.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

            ex.getMessage();

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

        }
    }

    public void cargarEditarEstaDia12(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();

            List<Modelos.Estadisticas.clsEstadisticas> lstclsEstadisticas = new ArrayList<Modelos.Estadisticas.clsEstadisticas>();

            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();

            lstclsEstadisticas = bl_clsEstadisticas.getEstadisticas();

            for (Modelos.Estadisticas.clsEstadisticas elem : lstclsEstadisticas) {
                if (elem.getId_estadistica() == Integer.parseInt(request.getParameter("codigoDia12"))) {
                    obclsEstadisticas = elem;
                    break;
                }
            }
            //Lista Dia 1 
            BL.Estadisticas.clsDia12 bl_clsDia12 = new BL.Estadisticas.clsDia12();
            request.setAttribute("lstclsDia12", bl_clsDia12.getDia12());

            request.setAttribute("obclsEstadisticas", obclsEstadisticas);
            request.setAttribute("lstclsEstadisticas", lstclsEstadisticas);
            request.getRequestDispatcher("Estadisticas/editarestadisticasdia12.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

            ex.getMessage();

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

        }
    }

    public void cargarEditarEstaDia13(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();

            List<Modelos.Estadisticas.clsEstadisticas> lstclsEstadisticas = new ArrayList<Modelos.Estadisticas.clsEstadisticas>();

            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();

            lstclsEstadisticas = bl_clsEstadisticas.getEstadisticas();

            for (Modelos.Estadisticas.clsEstadisticas elem : lstclsEstadisticas) {
                if (elem.getId_estadistica() == Integer.parseInt(request.getParameter("codigoDia13"))) {
                    obclsEstadisticas = elem;
                    break;
                }
            }
            //Lista Dia 1 
            BL.Estadisticas.clsDia13 bl_clsDia13 = new BL.Estadisticas.clsDia13();
            request.setAttribute("lstclsDia13", bl_clsDia13.getDia13());

            request.setAttribute("obclsEstadisticas", obclsEstadisticas);
            request.setAttribute("lstclsEstadisticas", lstclsEstadisticas);
            request.getRequestDispatcher("Estadisticas/editarestadisticasdia13.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

            ex.getMessage();

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

        }
    }

    public void cargarEditarEstaDia14(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();

            List<Modelos.Estadisticas.clsEstadisticas> lstclsEstadisticas = new ArrayList<Modelos.Estadisticas.clsEstadisticas>();

            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();

            lstclsEstadisticas = bl_clsEstadisticas.getEstadisticas();

            for (Modelos.Estadisticas.clsEstadisticas elem : lstclsEstadisticas) {
                if (elem.getId_estadistica() == Integer.parseInt(request.getParameter("codigoDia14"))) {
                    obclsEstadisticas = elem;
                    break;
                }
            }
            //Lista Dia 1 
            BL.Estadisticas.clsDia14 bl_clsDia14 = new BL.Estadisticas.clsDia14();
            request.setAttribute("lstclsDia14", bl_clsDia14.getDia14());

            request.setAttribute("obclsEstadisticas", obclsEstadisticas);
            request.setAttribute("lstclsEstadisticas", lstclsEstadisticas);
            request.getRequestDispatcher("Estadisticas/editarestadisticasdia14.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

            ex.getMessage();

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

        }
    }

    public void cargarEditarEstaDia15(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();

            List<Modelos.Estadisticas.clsEstadisticas> lstclsEstadisticas = new ArrayList<Modelos.Estadisticas.clsEstadisticas>();

            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();

            lstclsEstadisticas = bl_clsEstadisticas.getEstadisticas();

            for (Modelos.Estadisticas.clsEstadisticas elem : lstclsEstadisticas) {
                if (elem.getId_estadistica() == Integer.parseInt(request.getParameter("codigoDia15"))) {
                    obclsEstadisticas = elem;
                    break;
                }
            }
            //Lista Dia 1 
            BL.Estadisticas.clsDia15 bl_clsDia15 = new BL.Estadisticas.clsDia15();
            request.setAttribute("lstclsDia15", bl_clsDia15.getDia15());

            request.setAttribute("obclsEstadisticas", obclsEstadisticas);
            request.setAttribute("lstclsEstadisticas", lstclsEstadisticas);
            request.getRequestDispatcher("Estadisticas/editarestadisticasdia15.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

            ex.getMessage();

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

        }
    }

    public void cargarEditarEstaDia16(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();

            List<Modelos.Estadisticas.clsEstadisticas> lstclsEstadisticas = new ArrayList<Modelos.Estadisticas.clsEstadisticas>();

            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();

            lstclsEstadisticas = bl_clsEstadisticas.getEstadisticas();

            for (Modelos.Estadisticas.clsEstadisticas elem : lstclsEstadisticas) {
                if (elem.getId_estadistica() == Integer.parseInt(request.getParameter("codigoDia16"))) {
                    obclsEstadisticas = elem;
                    break;
                }
            }
            //Lista Dia 1 
            BL.Estadisticas.clsDia16 bl_clsDia16 = new BL.Estadisticas.clsDia16();
            request.setAttribute("lstclsDia16", bl_clsDia16.getDia16());

            request.setAttribute("obclsEstadisticas", obclsEstadisticas);
            request.setAttribute("lstclsEstadisticas", lstclsEstadisticas);
            request.getRequestDispatcher("Estadisticas/editarestadisticasdia16.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

            ex.getMessage();

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

        }
    }

    public void cargarEditarEstaDia17(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();

            List<Modelos.Estadisticas.clsEstadisticas> lstclsEstadisticas = new ArrayList<Modelos.Estadisticas.clsEstadisticas>();

            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();

            lstclsEstadisticas = bl_clsEstadisticas.getEstadisticas();

            for (Modelos.Estadisticas.clsEstadisticas elem : lstclsEstadisticas) {
                if (elem.getId_estadistica() == Integer.parseInt(request.getParameter("codigoDia17"))) {
                    obclsEstadisticas = elem;
                    break;
                }
            }
            //Lista Dia 1 
            BL.Estadisticas.clsDia17 bl_clsDia17 = new BL.Estadisticas.clsDia17();
            request.setAttribute("lstclsDia17", bl_clsDia17.getDia17());

            request.setAttribute("obclsEstadisticas", obclsEstadisticas);
            request.setAttribute("lstclsEstadisticas", lstclsEstadisticas);
            request.getRequestDispatcher("Estadisticas/editarestadisticasdia17.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

            ex.getMessage();

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

        }
    }

    public void cargarEditarEstaDia18(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();

            List<Modelos.Estadisticas.clsEstadisticas> lstclsEstadisticas = new ArrayList<Modelos.Estadisticas.clsEstadisticas>();

            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();

            lstclsEstadisticas = bl_clsEstadisticas.getEstadisticas();

            for (Modelos.Estadisticas.clsEstadisticas elem : lstclsEstadisticas) {
                if (elem.getId_estadistica() == Integer.parseInt(request.getParameter("codigoDia18"))) {
                    obclsEstadisticas = elem;
                    break;
                }
            }
            //Lista Dia 1 
            BL.Estadisticas.clsDia18 bl_clsDia18 = new BL.Estadisticas.clsDia18();
            request.setAttribute("lstclsDia18", bl_clsDia18.getDia18());

            request.setAttribute("obclsEstadisticas", obclsEstadisticas);
            request.setAttribute("lstclsEstadisticas", lstclsEstadisticas);
            request.getRequestDispatcher("Estadisticas/editarestadisticasdia18.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

            ex.getMessage();

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

        }
    }

    public void cargarEditarEstaDia19(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();

            List<Modelos.Estadisticas.clsEstadisticas> lstclsEstadisticas = new ArrayList<Modelos.Estadisticas.clsEstadisticas>();

            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();

            lstclsEstadisticas = bl_clsEstadisticas.getEstadisticas();

            for (Modelos.Estadisticas.clsEstadisticas elem : lstclsEstadisticas) {
                if (elem.getId_estadistica() == Integer.parseInt(request.getParameter("codigoDia19"))) {
                    obclsEstadisticas = elem;
                    break;
                }
            }
            //Lista Dia 1 
            BL.Estadisticas.clsDia19 bl_clsDia19 = new BL.Estadisticas.clsDia19();
            request.setAttribute("lstclsDia19", bl_clsDia19.getDia19());

            request.setAttribute("obclsEstadisticas", obclsEstadisticas);
            request.setAttribute("lstclsEstadisticas", lstclsEstadisticas);
            request.getRequestDispatcher("Estadisticas/editarestadisticasdia19.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

            ex.getMessage();

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

        }
    }

    public void cargarEditarEstaDia20(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();

            List<Modelos.Estadisticas.clsEstadisticas> lstclsEstadisticas = new ArrayList<Modelos.Estadisticas.clsEstadisticas>();

            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();

            lstclsEstadisticas = bl_clsEstadisticas.getEstadisticas();

            for (Modelos.Estadisticas.clsEstadisticas elem : lstclsEstadisticas) {
                if (elem.getId_estadistica() == Integer.parseInt(request.getParameter("codigoDia20"))) {
                    obclsEstadisticas = elem;
                    break;
                }
            }
            //Lista Dia 1 
            BL.Estadisticas.clsDia20 bl_clsDia20 = new BL.Estadisticas.clsDia20();
            request.setAttribute("lstclsDia20", bl_clsDia20.getDia20());

            request.setAttribute("obclsEstadisticas", obclsEstadisticas);
            request.setAttribute("lstclsEstadisticas", lstclsEstadisticas);
            request.getRequestDispatcher("Estadisticas/editarestadisticasdia20.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

            ex.getMessage();

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

        }
    }

    public void cargarEditarEstaDia21(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();

            List<Modelos.Estadisticas.clsEstadisticas> lstclsEstadisticas = new ArrayList<Modelos.Estadisticas.clsEstadisticas>();

            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();

            lstclsEstadisticas = bl_clsEstadisticas.getEstadisticas();

            for (Modelos.Estadisticas.clsEstadisticas elem : lstclsEstadisticas) {
                if (elem.getId_estadistica() == Integer.parseInt(request.getParameter("codigoDia21"))) {
                    obclsEstadisticas = elem;
                    break;
                }
            }
            //Lista Dia 1 
            BL.Estadisticas.clsDia21 bl_clsDia21 = new BL.Estadisticas.clsDia21();
            request.setAttribute("lstclsDia21", bl_clsDia21.getDia21());

            request.setAttribute("obclsEstadisticas", obclsEstadisticas);
            request.setAttribute("lstclsEstadisticas", lstclsEstadisticas);
            request.getRequestDispatcher("Estadisticas/editarestadisticasdia21.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

            ex.getMessage();

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

        }
    }

    public void cargarEditarEstaDia22(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();

            List<Modelos.Estadisticas.clsEstadisticas> lstclsEstadisticas = new ArrayList<Modelos.Estadisticas.clsEstadisticas>();

            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();

            lstclsEstadisticas = bl_clsEstadisticas.getEstadisticas();

            for (Modelos.Estadisticas.clsEstadisticas elem : lstclsEstadisticas) {
                if (elem.getId_estadistica() == Integer.parseInt(request.getParameter("codigoDia22"))) {
                    obclsEstadisticas = elem;
                    break;
                }
            }
            //Lista Dia 1 
            BL.Estadisticas.clsDia22 bl_clsDia22 = new BL.Estadisticas.clsDia22();
            request.setAttribute("lstclsDia22", bl_clsDia22.getDia22());

            request.setAttribute("obclsEstadisticas", obclsEstadisticas);
            request.setAttribute("lstclsEstadisticas", lstclsEstadisticas);
            request.getRequestDispatcher("Estadisticas/editarestadisticasdia22.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

            ex.getMessage();

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

        }
    }

    public void cargarEditarEstaDia23(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();

            List<Modelos.Estadisticas.clsEstadisticas> lstclsEstadisticas = new ArrayList<Modelos.Estadisticas.clsEstadisticas>();

            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();

            lstclsEstadisticas = bl_clsEstadisticas.getEstadisticas();

            for (Modelos.Estadisticas.clsEstadisticas elem : lstclsEstadisticas) {
                if (elem.getId_estadistica() == Integer.parseInt(request.getParameter("codigoDia23"))) {
                    obclsEstadisticas = elem;
                    break;
                }
            }
            //Lista Dia 1 
            BL.Estadisticas.clsDia23 bl_clsDia23 = new BL.Estadisticas.clsDia23();
            request.setAttribute("lstclsDia23", bl_clsDia23.getDia23());

            request.setAttribute("obclsEstadisticas", obclsEstadisticas);
            request.setAttribute("lstclsEstadisticas", lstclsEstadisticas);
            request.getRequestDispatcher("Estadisticas/editarestadisticasdia23.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

            ex.getMessage();

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

        }
    }

    public void cargarEditarEstaDia24(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();

            List<Modelos.Estadisticas.clsEstadisticas> lstclsEstadisticas = new ArrayList<Modelos.Estadisticas.clsEstadisticas>();

            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();

            lstclsEstadisticas = bl_clsEstadisticas.getEstadisticas();

            for (Modelos.Estadisticas.clsEstadisticas elem : lstclsEstadisticas) {
                if (elem.getId_estadistica() == Integer.parseInt(request.getParameter("codigoDia24"))) {
                    obclsEstadisticas = elem;
                    break;
                }
            }
            //Lista Dia 1 
            BL.Estadisticas.clsDia24 bl_clsDia24 = new BL.Estadisticas.clsDia24();
            request.setAttribute("lstclsDia24", bl_clsDia24.getDia24());

            request.setAttribute("obclsEstadisticas", obclsEstadisticas);
            request.setAttribute("lstclsEstadisticas", lstclsEstadisticas);
            request.getRequestDispatcher("Estadisticas/editarestadisticasdia24.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

            ex.getMessage();

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

        }
    }

    public void cargarEditarEstaDia25(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();

            List<Modelos.Estadisticas.clsEstadisticas> lstclsEstadisticas = new ArrayList<Modelos.Estadisticas.clsEstadisticas>();

            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();

            lstclsEstadisticas = bl_clsEstadisticas.getEstadisticas();

            for (Modelos.Estadisticas.clsEstadisticas elem : lstclsEstadisticas) {
                if (elem.getId_estadistica() == Integer.parseInt(request.getParameter("codigoDia25"))) {
                    obclsEstadisticas = elem;
                    break;
                }
            }
            //Lista Dia 1 
            BL.Estadisticas.clsDia25 bl_clsDia25 = new BL.Estadisticas.clsDia25();
            request.setAttribute("lstclsDia25", bl_clsDia25.getDia25());

            request.setAttribute("obclsEstadisticas", obclsEstadisticas);
            request.setAttribute("lstclsEstadisticas", lstclsEstadisticas);
            request.getRequestDispatcher("Estadisticas/editarestadisticasdia25.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

            ex.getMessage();

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

        }
    }

    public void cargarEditarEstaDia26(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();

            List<Modelos.Estadisticas.clsEstadisticas> lstclsEstadisticas = new ArrayList<Modelos.Estadisticas.clsEstadisticas>();

            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();

            lstclsEstadisticas = bl_clsEstadisticas.getEstadisticas();

            for (Modelos.Estadisticas.clsEstadisticas elem : lstclsEstadisticas) {
                if (elem.getId_estadistica() == Integer.parseInt(request.getParameter("codigoDia26"))) {
                    obclsEstadisticas = elem;
                    break;
                }
            }
            //Lista Dia 1 
            BL.Estadisticas.clsDia26 bl_clsDia26 = new BL.Estadisticas.clsDia26();
            request.setAttribute("lstclsDia26", bl_clsDia26.getDia26());

            request.setAttribute("obclsEstadisticas", obclsEstadisticas);
            request.setAttribute("lstclsEstadisticas", lstclsEstadisticas);
            request.getRequestDispatcher("Estadisticas/editarestadisticasdia26.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

            ex.getMessage();

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

        }
    }

    public void cargarEditarEstaDia27(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();

            List<Modelos.Estadisticas.clsEstadisticas> lstclsEstadisticas = new ArrayList<Modelos.Estadisticas.clsEstadisticas>();

            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();

            lstclsEstadisticas = bl_clsEstadisticas.getEstadisticas();

            for (Modelos.Estadisticas.clsEstadisticas elem : lstclsEstadisticas) {
                if (elem.getId_estadistica() == Integer.parseInt(request.getParameter("codigoDia27"))) {
                    obclsEstadisticas = elem;
                    break;
                }
            }
            //Lista Dia 1 
            BL.Estadisticas.clsDia27 bl_clsDia27 = new BL.Estadisticas.clsDia27();
            request.setAttribute("lstclsDia27", bl_clsDia27.getDia27());

            request.setAttribute("obclsEstadisticas", obclsEstadisticas);
            request.setAttribute("lstclsEstadisticas", lstclsEstadisticas);
            request.getRequestDispatcher("Estadisticas/editarestadisticasdia27.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

            ex.getMessage();

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

        }
    }

    public void cargarEditarEstaDia28(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();

            List<Modelos.Estadisticas.clsEstadisticas> lstclsEstadisticas = new ArrayList<Modelos.Estadisticas.clsEstadisticas>();

            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();

            lstclsEstadisticas = bl_clsEstadisticas.getEstadisticas();

            for (Modelos.Estadisticas.clsEstadisticas elem : lstclsEstadisticas) {
                if (elem.getId_estadistica() == Integer.parseInt(request.getParameter("codigoDia28"))) {
                    obclsEstadisticas = elem;
                    break;
                }
            }
            //Lista Dia 1 
            BL.Estadisticas.clsDia28 bl_clsDia28 = new BL.Estadisticas.clsDia28();
            request.setAttribute("lstclsDia28", bl_clsDia28.getDia28());

            request.setAttribute("obclsEstadisticas", obclsEstadisticas);
            request.setAttribute("lstclsEstadisticas", lstclsEstadisticas);
            request.getRequestDispatcher("Estadisticas/editarestadisticasdia28.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

            ex.getMessage();

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

        }
    }

    public void cargarEditarEstaDia29(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();

            List<Modelos.Estadisticas.clsEstadisticas> lstclsEstadisticas = new ArrayList<Modelos.Estadisticas.clsEstadisticas>();

            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();

            lstclsEstadisticas = bl_clsEstadisticas.getEstadisticas();

            for (Modelos.Estadisticas.clsEstadisticas elem : lstclsEstadisticas) {
                if (elem.getId_estadistica() == Integer.parseInt(request.getParameter("codigoDia29"))) {
                    obclsEstadisticas = elem;
                    break;
                }
            }
            //Lista Dia 1 
            BL.Estadisticas.clsDia29 bl_clsDia29 = new BL.Estadisticas.clsDia29();
            request.setAttribute("lstclsDia29", bl_clsDia29.getDia29());

            request.setAttribute("obclsEstadisticas", obclsEstadisticas);
            request.setAttribute("lstclsEstadisticas", lstclsEstadisticas);
            request.getRequestDispatcher("Estadisticas/editarestadisticasdia29.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

            ex.getMessage();

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

        }
    }

    public void cargarEditarEstaDia30(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();

            List<Modelos.Estadisticas.clsEstadisticas> lstclsEstadisticas = new ArrayList<Modelos.Estadisticas.clsEstadisticas>();

            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();

            lstclsEstadisticas = bl_clsEstadisticas.getEstadisticas();

            for (Modelos.Estadisticas.clsEstadisticas elem : lstclsEstadisticas) {
                if (elem.getId_estadistica() == Integer.parseInt(request.getParameter("codigoDia30"))) {
                    obclsEstadisticas = elem;
                    break;
                }
            }
            //Lista Dia 1 
            BL.Estadisticas.clsDia30 bl_clsDia30 = new BL.Estadisticas.clsDia30();
            request.setAttribute("lstclsDia30", bl_clsDia30.getDia30());

            request.setAttribute("obclsEstadisticas", obclsEstadisticas);
            request.setAttribute("lstclsEstadisticas", lstclsEstadisticas);
            request.getRequestDispatcher("Estadisticas/editarestadisticasdia30.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");
            request.getRequestDispatcher("Estadisticas/estadisticas.jsp").forward(request, response);

            ex.getMessage();

            //Lista de Empleados
            BL.Estadisticas.clsEstadisticas bl_clsEstadisticas = new BL.Estadisticas.clsEstadisticas();
            request.setAttribute("lstclsEstadisticas", bl_clsEstadisticas.getEstadisticas());

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
