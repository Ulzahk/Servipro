<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%
    HttpSession objsesion = request.getSession(false);
    String id_usuario = (String) objsesion.getAttribute("id_usuario");
    String Descripcion_perfil = (String) objsesion.getAttribute("descripcion_perfil");
    if (id_usuario == null) {
        response.sendRedirect("login.jsp");
    } else {
        if (Descripcion_perfil.equals("COORDINADOR")
                || Descripcion_perfil.equals("JEFE")) {

        } else {
            response.sendRedirect("nomina.htm");
        }
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Editar Estadísticas por Empleado</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link href="Resources/CSS/style.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="<c:url value="/Resources/CSS/style.css"/>"/>
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
        <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/plug-ins/1.10.20/i18n/Spanish.json"></script>
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
        <script src="Resources/JS/functions.js"></script>
    </head>
    <body>
        <%
            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();

            if (request.getAttribute("obclsEstadisticas") != null) {
                obclsEstadisticas = (Modelos.Estadisticas.clsEstadisticas) request.getAttribute("obclsEstadisticas");
            }

            List<Modelos.Estadisticas.clsEstadisticas> lstclsEstadisticas = new ArrayList<Modelos.Estadisticas.clsEstadisticas>();

            if (request.getAttribute("lstclsEstadisticas") != null) {

                lstclsEstadisticas = (List<Modelos.Estadisticas.clsEstadisticas>) request.getAttribute("lstclsEstadisticas");
            }

            if (request.getAttribute("stMensaje") != null && request.getAttribute("stTipo") != null) {


        %>
        <input type="text" hidden="" id="txtMensaje" value="<%=request.getAttribute("stMensaje")%>"/>
        <input type="text" hidden="" id="txtTipo" value="<%=request.getAttribute("stTipo")%>"/>
        <script>
            var mensaje = document.getElementById("txtMensaje").value;
            var tipo = document.getElementById("txtTipo").value;

            swal.fire("Mensaje", mensaje, tipo);
        </script>
        <%
            }
        %>
        <header>
            <%--Barra de Navegación de Jefe--%>
            <%
                if (Descripcion_perfil.equals("JEFE")) {

            %>       

            <jsp:include page="../WEB-INF/jsp/menujefe.jsp"></jsp:include>

            <%        }
            %>


            <%--Barra de Navegación de Coordinador--%>
            <%
                if (Descripcion_perfil.equals("COORDINADOR")) {
            %>

            <jsp:include page="../WEB-INF/jsp/menucordi.jsp"></jsp:include>

            <%
                }
            %> 
        </header>
        <div class="container mt-4">
            <h1 class="text-center">Editar Estadísticas por Empleado</h1>
            <br>
            <div class="card border-info">
                <div class="card-header bg-info text-white">
                    <a href="estadisticas?btnConsultarEstaMensualidad=true" class="btn btn-secondary" data-toggle="tooltip" title="Haz clic para volver a la vista estadísticas"><i class="fas fa-arrow-left"></i></a>
                </div>
                <div class="card-body">
                    <form action="estadisticas" method="POST">   
                        <div class="form-group">
                            <div class="form-group">
                                <div class="col-12 text-center">                                 
                                    <h4 class="align-middle"> 
                                        <b>
                                            <%=obclsEstadisticas.getObEmpleado().getEmplPrimerNombre() != null ? obclsEstadisticas.getObEmpleado().getEmplPrimerNombre() : ""%>
                                            <%=obclsEstadisticas.getObEmpleado().getEmplSegundoNombre() != null ? obclsEstadisticas.getObEmpleado().getEmplSegundoNombre() : ""%>
                                            <%=obclsEstadisticas.getObEmpleado().getEmplPrimerApellido() != null ? obclsEstadisticas.getObEmpleado().getEmplPrimerApellido() : ""%>
                                            <%=obclsEstadisticas.getObEmpleado().getEmplSegundoApellido() != null ? obclsEstadisticas.getObEmpleado().getEmplSegundoApellido() : ""%>
                                        </b>
                                    </h4>                                         
                                </div>
                            </div>
                        </div>
                        <hr/>
                        <!--FILA -->
                        <div class="form-group">
                            <div class="form-row">        
                                <div class="col-6">
                                    <label for="lblAnio"><b>A&ntilde;o</b></label>
                                    <select class="form-control border border-dark" name="ddlAnio">
                                        <%
                                            List<Modelos.Estadisticas.clsAnio> lstclsAnio = new ArrayList<Modelos.Estadisticas.clsAnio>();

                                            if (request.getAttribute("lstclsAnio") != null) {
                                                lstclsAnio = (List<Modelos.Estadisticas.clsAnio>) request.getAttribute("lstclsAnio");
                                            }

                                            for (Modelos.Estadisticas.clsAnio elem : lstclsAnio) {
                                        %>
                                        <option value="<%=elem.getId_anio()%>"
                                                <%=obclsEstadisticas.getObAnio() != null ? obclsEstadisticas.getObAnio().getId_anio() == elem.getId_anio() ? "selected" : "" : ""%>>
                                            <%=elem.getNombreAnio()%>
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select>                                    
                                </div>
                                <div class="col-6">
                                    <label for="lblMes"><b>Mes</b></label>
                                    <select class="form-control border border-dark" name="ddlMes">
                                        <%
                                            List<Modelos.Estadisticas.clsMes> lstclsMes = new ArrayList<Modelos.Estadisticas.clsMes>();

                                            if (request.getAttribute("lstclsMes") != null) {
                                                lstclsMes = (List<Modelos.Estadisticas.clsMes>) request.getAttribute("lstclsMes");
                                            }

                                            for (Modelos.Estadisticas.clsMes elem : lstclsMes) {
                                        %>
                                        <option value="<%=elem.getId_mes()%>"
                                                <%=obclsEstadisticas.getObMes() != null ? obclsEstadisticas.getObMes().getId_mes() == elem.getId_mes() ? "selected" : "" : ""%>>
                                            <%=elem.getMesNombre()%>
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <!-- FILA 1--> 
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-4">
                                    <label for="lblDia1"><b>Día 1</b></label>
                                    <select class="form-control" name="ddlDia1">
                                        <%
                                            List<Modelos.Estadisticas.clsId_dia1> lstclsDia1 = new ArrayList<Modelos.Estadisticas.clsId_dia1>();

                                            if (request.getAttribute("lstclsDia1") != null) {
                                                lstclsDia1 = (List<Modelos.Estadisticas.clsId_dia1>) request.getAttribute("lstclsDia1");
                                            }

                                            for (Modelos.Estadisticas.clsId_dia1 elem : lstclsDia1) {
                                        %>
                                        <option value="<%=elem.getId_dia1()%>"
                                                <%=obclsEstadisticas.getObId_dia1() != null ? obclsEstadisticas.getObId_dia1().getId_dia1() == elem.getId_dia1() ? "selected" : "" : ""%>>
                                            <%=elem.getDescripcionDia1()%>(<%=elem.getAliasDia1()%>)
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                                <div class="col-4">
                                    <label for="lblDia2"><b>Día 2</b></label>
                                    <select class="form-control" name="ddlDia2">
                                        <%
                                            List<Modelos.Estadisticas.clsId_dia2> lstclsDia2 = new ArrayList<Modelos.Estadisticas.clsId_dia2>();

                                            if (request.getAttribute("lstclsDia2") != null) {
                                                lstclsDia2 = (List<Modelos.Estadisticas.clsId_dia2>) request.getAttribute("lstclsDia2");
                                            }

                                            for (Modelos.Estadisticas.clsId_dia2 elem : lstclsDia2) {
                                        %>
                                        <option value="<%=elem.getId_dia2()%>"
                                                <%=obclsEstadisticas.getObId_dia2() != null ? obclsEstadisticas.getObId_dia2().getId_dia2() == elem.getId_dia2() ? "selected" : "" : ""%>>
                                            <%=elem.getDescripcionDia2()%>(<%=elem.getAliasDia2()%>)
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                                <div class="col-4">
                                    <label for="lblDia3"><b>Día 3</b></label>
                                    <select class="form-control" name="ddlDia3">
                                        <%
                                            List<Modelos.Estadisticas.clsId_dia3> lstclsDia3 = new ArrayList<Modelos.Estadisticas.clsId_dia3>();

                                            if (request.getAttribute("lstclsDia3") != null) {
                                                lstclsDia3 = (List<Modelos.Estadisticas.clsId_dia3>) request.getAttribute("lstclsDia3");
                                            }

                                            for (Modelos.Estadisticas.clsId_dia3 elem : lstclsDia3) {
                                        %>
                                        <option value="<%=elem.getId_dia3()%>"
                                                <%=obclsEstadisticas.getObId_dia3() != null ? obclsEstadisticas.getObId_dia3().getId_dia3() == elem.getId_dia3() ? "selected" : "" : ""%>>
                                            <%=elem.getDescripcionDia3()%>(<%=elem.getAliasDia3()%>)
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select>                                    
                                </div>
                            </div>
                        </div>
                        <!--FILA 2-->
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-4">
                                    <label for="lblDia4"><b>Día 4</b></label>
                                    <select class="form-control" name="ddlDia4">
                                        <%
                                            List<Modelos.Estadisticas.clsId_dia4> lstclsDia4 = new ArrayList<Modelos.Estadisticas.clsId_dia4>();

                                            if (request.getAttribute("lstclsDia4") != null) {
                                                lstclsDia4 = (List<Modelos.Estadisticas.clsId_dia4>) request.getAttribute("lstclsDia4");
                                            }

                                            for (Modelos.Estadisticas.clsId_dia4 elem : lstclsDia4) {
                                        %>
                                        <option value="<%=elem.getId_dia4()%>"
                                                <%=obclsEstadisticas.getObId_dia4() != null ? obclsEstadisticas.getObId_dia4().getId_dia4() == elem.getId_dia4() ? "selected" : "" : ""%>>
                                            <%=elem.getDescripcionDia4()%>(<%=elem.getAliasDia4()%>)
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                                <div class="col-4">
                                    <label for="lblDia5"><b>Día 5</b></label>
                                    <select class="form-control" name="ddlDia5">
                                        <%
                                            List<Modelos.Estadisticas.clsId_dia5> lstclsDia5 = new ArrayList<Modelos.Estadisticas.clsId_dia5>();

                                            if (request.getAttribute("lstclsDia5") != null) {
                                                lstclsDia5 = (List<Modelos.Estadisticas.clsId_dia5>) request.getAttribute("lstclsDia5");
                                            }

                                            for (Modelos.Estadisticas.clsId_dia5 elem : lstclsDia5) {
                                        %>
                                        <option value="<%=elem.getId_dia5()%>"
                                                <%=obclsEstadisticas.getObId_dia5() != null ? obclsEstadisticas.getObId_dia5().getId_dia5() == elem.getId_dia5() ? "selected" : "" : ""%>>
                                            <%=elem.getDescripcionDia5()%>(<%=elem.getAliasDia5()%>)
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                                <div class="col-4">
                                    <label for="lblDia6"><b>Día 6</b></label>
                                    <select class="form-control" name="ddlDia6">
                                        <%
                                            List<Modelos.Estadisticas.clsId_dia6> lstclsDia6 = new ArrayList<Modelos.Estadisticas.clsId_dia6>();

                                            if (request.getAttribute("lstclsDia6") != null) {
                                                lstclsDia6 = (List<Modelos.Estadisticas.clsId_dia6>) request.getAttribute("lstclsDia6");
                                            }

                                            for (Modelos.Estadisticas.clsId_dia6 elem : lstclsDia6) {
                                        %>
                                        <option value="<%=elem.getId_dia6()%>"
                                                <%=obclsEstadisticas.getObId_dia6() != null ? obclsEstadisticas.getObId_dia6().getId_dia6() == elem.getId_dia6() ? "selected" : "" : ""%>>
                                            <%=elem.getDescripcionDia6()%>(<%=elem.getAliasDia6()%>)
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select>                                    
                                </div>
                            </div>
                        </div>
                        <!--FILA 21-->
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-4">
                                    <label for="lblDia7"><b>Día 7</b></label>
                                    <select class="form-control" name="ddlDia7">
                                        <%
                                            List<Modelos.Estadisticas.clsId_dia7> lstclsDia7 = new ArrayList<Modelos.Estadisticas.clsId_dia7>();

                                            if (request.getAttribute("lstclsDia7") != null) {
                                                lstclsDia7 = (List<Modelos.Estadisticas.clsId_dia7>) request.getAttribute("lstclsDia7");
                                            }

                                            for (Modelos.Estadisticas.clsId_dia7 elem : lstclsDia7) {
                                        %>
                                        <option value="<%=elem.getId_dia7()%>"
                                                <%=obclsEstadisticas.getObId_dia7() != null ? obclsEstadisticas.getObId_dia7().getId_dia7() == elem.getId_dia7() ? "selected" : "" : ""%>>
                                            <%=elem.getDescripcionDia7()%>(<%=elem.getAliasDia7()%>)
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                                <div class="col-4">
                                    <label for="lblDia8"><b>Día 8</b></label>
                                    <select class="form-control" name="ddlDia8">
                                        <%
                                            List<Modelos.Estadisticas.clsId_dia8> lstclsDia8 = new ArrayList<Modelos.Estadisticas.clsId_dia8>();

                                            if (request.getAttribute("lstclsDia8") != null) {
                                                lstclsDia8 = (List<Modelos.Estadisticas.clsId_dia8>) request.getAttribute("lstclsDia8");
                                            }

                                            for (Modelos.Estadisticas.clsId_dia8 elem : lstclsDia8) {
                                        %>
                                        <option value="<%=elem.getId_dia8()%>"
                                                <%=obclsEstadisticas.getObId_dia8() != null ? obclsEstadisticas.getObId_dia8().getId_dia8() == elem.getId_dia8() ? "selected" : "" : ""%>>
                                            <%=elem.getDescripcionDia8()%>(<%=elem.getAliasDia8()%>)
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                                <div class="col-4">
                                    <label for="lblDia9"><b>Día 9</b></label>
                                    <select class="form-control" name="ddlDia9">
                                        <%
                                            List<Modelos.Estadisticas.clsId_dia9> lstclsDia9 = new ArrayList<Modelos.Estadisticas.clsId_dia9>();

                                            if (request.getAttribute("lstclsDia9") != null) {
                                                lstclsDia9 = (List<Modelos.Estadisticas.clsId_dia9>) request.getAttribute("lstclsDia9");
                                            }

                                            for (Modelos.Estadisticas.clsId_dia9 elem : lstclsDia9) {
                                        %>
                                        <option value="<%=elem.getId_dia9()%>"
                                                <%=obclsEstadisticas.getObId_dia9() != null ? obclsEstadisticas.getObId_dia9().getId_dia9() == elem.getId_dia9() ? "selected" : "" : ""%>>
                                            <%=elem.getDescripcionDia9()%>(<%=elem.getAliasDia9()%>)
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select>                                    
                                </div>
                            </div>
                        </div>
                        <!--FILA 4-->
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-4">
                                    <label for="lblDia10"><b>Día 10</b></label>
                                    <select class="form-control" name="ddlDia10">
                                        <%
                                            List<Modelos.Estadisticas.clsId_dia10> lstclsDia10 = new ArrayList<Modelos.Estadisticas.clsId_dia10>();

                                            if (request.getAttribute("lstclsDia10") != null) {
                                                lstclsDia10 = (List<Modelos.Estadisticas.clsId_dia10>) request.getAttribute("lstclsDia10");
                                            }

                                            for (Modelos.Estadisticas.clsId_dia10 elem : lstclsDia10) {
                                        %>
                                        <option value="<%=elem.getId_dia10()%>"
                                                <%=obclsEstadisticas.getObId_dia10() != null ? obclsEstadisticas.getObId_dia10().getId_dia10() == elem.getId_dia10() ? "selected" : "" : ""%>>
                                            <%=elem.getDescripcionDia10()%>(<%=elem.getAliasDia10()%>)
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                                <div class="col-4">
                                    <label for="lblDia11"><b>Día 11</b></label>
                                    <select class="form-control" name="ddlDia11">
                                        <%
                                            List<Modelos.Estadisticas.clsId_dia11> lstclsDia11 = new ArrayList<Modelos.Estadisticas.clsId_dia11>();

                                            if (request.getAttribute("lstclsDia11") != null) {
                                                lstclsDia11 = (List<Modelos.Estadisticas.clsId_dia11>) request.getAttribute("lstclsDia11");
                                            }

                                            for (Modelos.Estadisticas.clsId_dia11 elem : lstclsDia11) {
                                        %>
                                        <option value="<%=elem.getId_dia11()%>"
                                                <%=obclsEstadisticas.getObId_dia11() != null ? obclsEstadisticas.getObId_dia11().getId_dia11() == elem.getId_dia11() ? "selected" : "" : ""%>>
                                            <%=elem.getDescripcionDia11()%>(<%=elem.getAliasDia11()%>)
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                                <div class="col-4">
                                    <label for="lblDia12"><b>Día 12</b></label>
                                    <select class="form-control" name="ddlDia12">
                                        <%
                                            List<Modelos.Estadisticas.clsId_dia12> lstclsDia12 = new ArrayList<Modelos.Estadisticas.clsId_dia12>();

                                            if (request.getAttribute("lstclsDia12") != null) {
                                                lstclsDia12 = (List<Modelos.Estadisticas.clsId_dia12>) request.getAttribute("lstclsDia12");
                                            }

                                            for (Modelos.Estadisticas.clsId_dia12 elem : lstclsDia12) {
                                        %>
                                        <option value="<%=elem.getId_dia12()%>"
                                                <%=obclsEstadisticas.getObId_dia12() != null ? obclsEstadisticas.getObId_dia12().getId_dia12() == elem.getId_dia12() ? "selected" : "" : ""%>>
                                            <%=elem.getDescripcionDia12()%>(<%=elem.getAliasDia12()%>)
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select>                                    
                                </div>
                            </div>
                        </div>
                        <!--FILA 5-->
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-4">
                                    <label for="lblDia13"><b>Día 13</b></label>
                                    <select class="form-control" name="ddlDia13">
                                        <%
                                            List<Modelos.Estadisticas.clsId_dia13> lstclsDia13 = new ArrayList<Modelos.Estadisticas.clsId_dia13>();

                                            if (request.getAttribute("lstclsDia13") != null) {
                                                lstclsDia13 = (List<Modelos.Estadisticas.clsId_dia13>) request.getAttribute("lstclsDia13");
                                            }

                                            for (Modelos.Estadisticas.clsId_dia13 elem : lstclsDia13) {
                                        %>
                                        <option value="<%=elem.getId_dia13()%>"
                                                <%=obclsEstadisticas.getObId_dia13() != null ? obclsEstadisticas.getObId_dia13().getId_dia13() == elem.getId_dia13() ? "selected" : "" : ""%>>
                                            <%=elem.getDescripcionDia13()%>(<%=elem.getAliasDia13()%>)
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                                <div class="col-4">
                                    <label for="lblDia14"><b>Día 14</b></label>
                                    <select class="form-control" name="ddlDia14">
                                        <%
                                            List<Modelos.Estadisticas.clsId_dia14> lstclsDia14 = new ArrayList<Modelos.Estadisticas.clsId_dia14>();

                                            if (request.getAttribute("lstclsDia14") != null) {
                                                lstclsDia14 = (List<Modelos.Estadisticas.clsId_dia14>) request.getAttribute("lstclsDia14");
                                            }

                                            for (Modelos.Estadisticas.clsId_dia14 elem : lstclsDia14) {
                                        %>
                                        <option value="<%=elem.getId_dia14()%>"
                                                <%=obclsEstadisticas.getObId_dia14() != null ? obclsEstadisticas.getObId_dia14().getId_dia14() == elem.getId_dia14() ? "selected" : "" : ""%>>
                                            <%=elem.getDescripcionDia14()%>(<%=elem.getAliasDia14()%>)
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                                <div class="col-4">
                                    <label for="lblDia15"><b>Día 15</b></label>
                                    <select class="form-control" name="ddlDia15">
                                        <%
                                            List<Modelos.Estadisticas.clsId_dia15> lstclsDia15 = new ArrayList<Modelos.Estadisticas.clsId_dia15>();

                                            if (request.getAttribute("lstclsDia15") != null) {
                                                lstclsDia15 = (List<Modelos.Estadisticas.clsId_dia15>) request.getAttribute("lstclsDia15");
                                            }

                                            for (Modelos.Estadisticas.clsId_dia15 elem : lstclsDia15) {
                                        %>
                                        <option value="<%=elem.getId_dia15()%>"
                                                <%=obclsEstadisticas.getObId_dia15() != null ? obclsEstadisticas.getObId_dia15().getId_dia15() == elem.getId_dia15() ? "selected" : "" : ""%>>
                                            <%=elem.getDescripcionDia15()%>(<%=elem.getAliasDia15()%>)
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select>                                    
                                </div>
                            </div>
                        </div>
                        <!--FILA 6-->
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-4">
                                    <label for="lblDia16"><b>Día 16</b></label>
                                    <select class="form-control" name="ddlDia16">
                                        <%
                                            List<Modelos.Estadisticas.clsId_dia16> lstclsDia16 = new ArrayList<Modelos.Estadisticas.clsId_dia16>();

                                            if (request.getAttribute("lstclsDia16") != null) {
                                                lstclsDia16 = (List<Modelos.Estadisticas.clsId_dia16>) request.getAttribute("lstclsDia16");
                                            }

                                            for (Modelos.Estadisticas.clsId_dia16 elem : lstclsDia16) {
                                        %>
                                        <option value="<%=elem.getId_dia16()%>"
                                                <%=obclsEstadisticas.getObId_dia16() != null ? obclsEstadisticas.getObId_dia16().getId_dia16() == elem.getId_dia16() ? "selected" : "" : ""%>>
                                            <%=elem.getDescripcionDia16()%>(<%=elem.getAliasDia16()%>)
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                                <div class="col-4">
                                    <label for="lblDia17"><b>Día 17</b></label>
                                    <select class="form-control" name="ddlDia17">
                                        <%
                                            List<Modelos.Estadisticas.clsId_dia17> lstclsDia17 = new ArrayList<Modelos.Estadisticas.clsId_dia17>();

                                            if (request.getAttribute("lstclsDia17") != null) {
                                                lstclsDia17 = (List<Modelos.Estadisticas.clsId_dia17>) request.getAttribute("lstclsDia17");
                                            }

                                            for (Modelos.Estadisticas.clsId_dia17 elem : lstclsDia17) {
                                        %>
                                        <option value="<%=elem.getId_dia17()%>"
                                                <%=obclsEstadisticas.getObId_dia17() != null ? obclsEstadisticas.getObId_dia17().getId_dia17() == elem.getId_dia17() ? "selected" : "" : ""%>>
                                            <%=elem.getDescripcionDia17()%>(<%=elem.getAliasDia17()%>)
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                                <div class="col-4">
                                    <label for="lblDia18"><b>Día 18</b></label>
                                    <select class="form-control" name="ddlDia18">
                                        <%
                                            List<Modelos.Estadisticas.clsId_dia18> lstclsDia18 = new ArrayList<Modelos.Estadisticas.clsId_dia18>();

                                            if (request.getAttribute("lstclsDia18") != null) {
                                                lstclsDia18 = (List<Modelos.Estadisticas.clsId_dia18>) request.getAttribute("lstclsDia18");
                                            }

                                            for (Modelos.Estadisticas.clsId_dia18 elem : lstclsDia18) {
                                        %>
                                        <option value="<%=elem.getId_dia18()%>"
                                                <%=obclsEstadisticas.getObId_dia18() != null ? obclsEstadisticas.getObId_dia18().getId_dia18() == elem.getId_dia18() ? "selected" : "" : ""%>>
                                            <%=elem.getDescripcionDia18()%>(<%=elem.getAliasDia18()%>)
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select>                                    
                                </div>
                            </div>
                        </div>
                        <!--FILA 7-->
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-4">
                                    <label for="lblDia19"><b>Día 19</b></label>
                                    <select class="form-control" name="ddlDia19">
                                        <%
                                            List<Modelos.Estadisticas.clsId_dia19> lstclsDia19 = new ArrayList<Modelos.Estadisticas.clsId_dia19>();

                                            if (request.getAttribute("lstclsDia19") != null) {
                                                lstclsDia19 = (List<Modelos.Estadisticas.clsId_dia19>) request.getAttribute("lstclsDia19");
                                            }

                                            for (Modelos.Estadisticas.clsId_dia19 elem : lstclsDia19) {
                                        %>
                                        <option value="<%=elem.getId_dia19()%>"
                                                <%=obclsEstadisticas.getObId_dia19() != null ? obclsEstadisticas.getObId_dia19().getId_dia19() == elem.getId_dia19() ? "selected" : "" : ""%>>
                                            <%=elem.getDescripcionDia19()%>(<%=elem.getAliasDia19()%>)
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                                <div class="col-4">
                                    <label for="lblDia20"><b>Día 20</b></label>
                                    <select class="form-control" name="ddlDia20">
                                        <%
                                            List<Modelos.Estadisticas.clsId_dia20> lstclsDia20 = new ArrayList<Modelos.Estadisticas.clsId_dia20>();

                                            if (request.getAttribute("lstclsDia20") != null) {
                                                lstclsDia20 = (List<Modelos.Estadisticas.clsId_dia20>) request.getAttribute("lstclsDia20");
                                            }

                                            for (Modelos.Estadisticas.clsId_dia20 elem : lstclsDia20) {
                                        %>
                                        <option value="<%=elem.getId_dia20()%>"
                                                <%=obclsEstadisticas.getObId_dia20() != null ? obclsEstadisticas.getObId_dia20().getId_dia20() == elem.getId_dia20() ? "selected" : "" : ""%>>
                                            <%=elem.getDescripcionDia20()%>(<%=elem.getAliasDia20()%>)
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                                <div class="col-4">
                                    <label for="lblDia21"><b>Día 21</b></label>
                                    <select class="form-control" name="ddlDia21">
                                        <%
                                            List<Modelos.Estadisticas.clsId_dia21> lstclsDia21 = new ArrayList<Modelos.Estadisticas.clsId_dia21>();

                                            if (request.getAttribute("lstclsDia21") != null) {
                                                lstclsDia21 = (List<Modelos.Estadisticas.clsId_dia21>) request.getAttribute("lstclsDia21");
                                            }

                                            for (Modelos.Estadisticas.clsId_dia21 elem : lstclsDia21) {
                                        %>
                                        <option value="<%=elem.getId_dia21()%>"
                                                <%=obclsEstadisticas.getObId_dia21() != null ? obclsEstadisticas.getObId_dia21().getId_dia21() == elem.getId_dia21() ? "selected" : "" : ""%>>
                                            <%=elem.getDescripcionDia21()%>(<%=elem.getAliasDia21()%>)
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select>                                    
                                </div>
                            </div>
                        </div>
                        <!--FILA 8-->
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-4">
                                    <label for="lblDia22"><b>Día 22</b></label>
                                    <select class="form-control" name="ddlDia22">
                                        <%
                                            List<Modelos.Estadisticas.clsId_dia22> lstclsDia22 = new ArrayList<Modelos.Estadisticas.clsId_dia22>();

                                            if (request.getAttribute("lstclsDia22") != null) {
                                                lstclsDia22 = (List<Modelos.Estadisticas.clsId_dia22>) request.getAttribute("lstclsDia22");
                                            }

                                            for (Modelos.Estadisticas.clsId_dia22 elem : lstclsDia22) {
                                        %>
                                        <option value="<%=elem.getId_dia22()%>"
                                                <%=obclsEstadisticas.getObId_dia22() != null ? obclsEstadisticas.getObId_dia22().getId_dia22() == elem.getId_dia22() ? "selected" : "" : ""%>>
                                            <%=elem.getDescripcionDia22()%>(<%=elem.getAliasDia22()%>)
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                                <div class="col-4">
                                    <label for="lblDia23"><b>Día 23</b></label>
                                    <select class="form-control" name="ddlDia23">
                                        <%
                                            List<Modelos.Estadisticas.clsId_dia23> lstclsDia23 = new ArrayList<Modelos.Estadisticas.clsId_dia23>();

                                            if (request.getAttribute("lstclsDia23") != null) {
                                                lstclsDia23 = (List<Modelos.Estadisticas.clsId_dia23>) request.getAttribute("lstclsDia23");
                                            }

                                            for (Modelos.Estadisticas.clsId_dia23 elem : lstclsDia23) {
                                        %>
                                        <option value="<%=elem.getId_dia23()%>"
                                                <%=obclsEstadisticas.getObId_dia23() != null ? obclsEstadisticas.getObId_dia23().getId_dia23() == elem.getId_dia23() ? "selected" : "" : ""%>>
                                            <%=elem.getDescripcionDia23()%>(<%=elem.getAliasDia23()%>)
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                                <div class="col-4">
                                    <label for="lblDia24"><b>Día 24</b></label>
                                    <select class="form-control" name="ddlDia24">
                                        <%
                                            List<Modelos.Estadisticas.clsId_dia24> lstclsDia24 = new ArrayList<Modelos.Estadisticas.clsId_dia24>();

                                            if (request.getAttribute("lstclsDia24") != null) {
                                                lstclsDia24 = (List<Modelos.Estadisticas.clsId_dia24>) request.getAttribute("lstclsDia24");
                                            }

                                            for (Modelos.Estadisticas.clsId_dia24 elem : lstclsDia24) {
                                        %>
                                        <option value="<%=elem.getId_dia24()%>"
                                                <%=obclsEstadisticas.getObId_dia24() != null ? obclsEstadisticas.getObId_dia24().getId_dia24() == elem.getId_dia24() ? "selected" : "" : ""%>>
                                            <%=elem.getDescripcionDia24()%>(<%=elem.getAliasDia24()%>)
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select>                                    
                                </div>
                            </div>
                        </div>
                        <!--FILA 9-->
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-4">
                                    <label for="lblDia25"><b>Día 25</b></label>
                                    <select class="form-control" name="ddlDia25">
                                        <%
                                            List<Modelos.Estadisticas.clsId_dia25> lstclsDia25 = new ArrayList<Modelos.Estadisticas.clsId_dia25>();

                                            if (request.getAttribute("lstclsDia25") != null) {
                                                lstclsDia25 = (List<Modelos.Estadisticas.clsId_dia25>) request.getAttribute("lstclsDia25");
                                            }

                                            for (Modelos.Estadisticas.clsId_dia25 elem : lstclsDia25) {
                                        %>
                                        <option value="<%=elem.getId_dia25()%>"
                                                <%=obclsEstadisticas.getObId_dia25() != null ? obclsEstadisticas.getObId_dia25().getId_dia25() == elem.getId_dia25() ? "selected" : "" : ""%>>
                                            <%=elem.getDescripcionDia25()%>(<%=elem.getAliasDia25()%>)
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                                <div class="col-4">
                                    <label for="lblDia26"><b>Día 26</b></label>
                                    <select class="form-control" name="ddlDia26">
                                        <%
                                            List<Modelos.Estadisticas.clsId_dia26> lstclsDia26 = new ArrayList<Modelos.Estadisticas.clsId_dia26>();

                                            if (request.getAttribute("lstclsDia26") != null) {
                                                lstclsDia26 = (List<Modelos.Estadisticas.clsId_dia26>) request.getAttribute("lstclsDia26");
                                            }

                                            for (Modelos.Estadisticas.clsId_dia26 elem : lstclsDia26) {
                                        %>
                                        <option value="<%=elem.getId_dia26()%>"
                                                <%=obclsEstadisticas.getObId_dia26() != null ? obclsEstadisticas.getObId_dia26().getId_dia26() == elem.getId_dia26() ? "selected" : "" : ""%>>
                                            <%=elem.getDescripcionDia26()%>(<%=elem.getAliasDia26()%>)
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                                <div class="col-4">
                                    <label for="lblDia27"><b>Día 27</b></label>
                                    <select class="form-control" name="ddlDia27">
                                        <%
                                            List<Modelos.Estadisticas.clsId_dia27> lstclsDia27 = new ArrayList<Modelos.Estadisticas.clsId_dia27>();

                                            if (request.getAttribute("lstclsDia27") != null) {
                                                lstclsDia27 = (List<Modelos.Estadisticas.clsId_dia27>) request.getAttribute("lstclsDia27");
                                            }

                                            for (Modelos.Estadisticas.clsId_dia27 elem : lstclsDia27) {
                                        %>
                                        <option value="<%=elem.getId_dia27()%>"
                                                <%=obclsEstadisticas.getObId_dia27() != null ? obclsEstadisticas.getObId_dia27().getId_dia27() == elem.getId_dia27() ? "selected" : "" : ""%>>
                                            <%=elem.getDescripcionDia27()%>(<%=elem.getAliasDia27()%>)
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select>                                    
                                </div>
                            </div>
                        </div>
                        <!--FILA 10-->
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-4">
                                    <label for="lblDia28"><b>Día 28</b></label>
                                    <select class="form-control" name="ddlDia28">
                                        <%
                                            List<Modelos.Estadisticas.clsId_dia28> lstclsDia28 = new ArrayList<Modelos.Estadisticas.clsId_dia28>();

                                            if (request.getAttribute("lstclsDia28") != null) {
                                                lstclsDia28 = (List<Modelos.Estadisticas.clsId_dia28>) request.getAttribute("lstclsDia28");
                                            }

                                            for (Modelos.Estadisticas.clsId_dia28 elem : lstclsDia28) {
                                        %>
                                        <option value="<%=elem.getId_dia28()%>"
                                                <%=obclsEstadisticas.getObId_dia28() != null ? obclsEstadisticas.getObId_dia28().getId_dia28() == elem.getId_dia28() ? "selected" : "" : ""%>>
                                            <%=elem.getDescripcionDia28()%>(<%=elem.getAliasDia28()%>)
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                                <div class="col-4">
                                    <label for="lblDia29"><b>Día 29</b></label>
                                    <select class="form-control" name="ddlDia29">
                                        <%
                                            List<Modelos.Estadisticas.clsId_dia29> lstclsDia29 = new ArrayList<Modelos.Estadisticas.clsId_dia29>();

                                            if (request.getAttribute("lstclsDia29") != null) {
                                                lstclsDia29 = (List<Modelos.Estadisticas.clsId_dia29>) request.getAttribute("lstclsDia29");
                                            }

                                            for (Modelos.Estadisticas.clsId_dia29 elem : lstclsDia29) {
                                        %>
                                        <option value="<%=elem.getId_dia29()%>"
                                                <%=obclsEstadisticas.getObId_dia29() != null ? obclsEstadisticas.getObId_dia29().getId_dia29() == elem.getId_dia29() ? "selected" : "" : ""%>>
                                            <%=elem.getDescripcionDia29()%>(<%=elem.getAliasDia29()%>)
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                                <div class="col-4">
                                    <label for="lblDia30"><b>Día 30</b></label>
                                    <select class="form-control" name="ddlDia30">
                                        <%
                                            List<Modelos.Estadisticas.clsId_dia30> lstclsDia30 = new ArrayList<Modelos.Estadisticas.clsId_dia30>();

                                            if (request.getAttribute("lstclsDia30") != null) {
                                                lstclsDia30 = (List<Modelos.Estadisticas.clsId_dia30>) request.getAttribute("lstclsDia30");
                                            }

                                            for (Modelos.Estadisticas.clsId_dia30 elem : lstclsDia30) {
                                        %>
                                        <option value="<%=elem.getId_dia30()%>"
                                                <%=obclsEstadisticas.getObId_dia30() != null ? obclsEstadisticas.getObId_dia30().getId_dia30() == elem.getId_dia30() ? "selected" : "" : ""%>>
                                            <%=elem.getDescripcionDia30()%>(<%=elem.getAliasDia30()%>)
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select>                                    
                                </div>
                            </div>
                        </div>
                        <!--FILA 11-->
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-4">
                                    <label for="lblDia31"><b>Día 31</b></label>
                                    <select class="form-control" name="ddlDia31">
                                        <%
                                            List<Modelos.Estadisticas.clsId_dia31> lstclsDia31 = new ArrayList<Modelos.Estadisticas.clsId_dia31>();

                                            if (request.getAttribute("lstclsDia31") != null) {
                                                lstclsDia31 = (List<Modelos.Estadisticas.clsId_dia31>) request.getAttribute("lstclsDia31");
                                            }

                                            for (Modelos.Estadisticas.clsId_dia31 elem : lstclsDia31) {
                                        %>
                                        <option value="<%=elem.getId_dia31()%>"
                                                <%=obclsEstadisticas.getObId_dia31() != null ? obclsEstadisticas.getObId_dia31().getId_dia31() == elem.getId_dia31() ? "selected" : "" : ""%>>
                                            <%=elem.getDescripcionDia31()%>(<%=elem.getAliasDia31()%>)
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select>                                    
                                </div>
                            </div>
                        </div>
                        <!--FILA 12-->   
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-12">
                                    <input type="submit" value="Guardar" class="btn btn-info" name="btnEditarEsta"/>
                                    <input type="text" name="IdModificar" id="IdModificar" value="<%=obclsEstadisticas.getId_estadistica()%>" hidden=""/>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
    <script>
        $(document).ready(main);

        var contador = 1;

        function main() {
            $('.menu_bar').click(function () {
                if (contador == 1) {
                    $('nav').animate({
                        left: '0'
                    });
                    contador = 0;
                } else {
                    contador = 1;
                    $('nav').animate({
                        left: '-100%'
                    });
                }
            });

            // Mostramos y ocultamos submenus
            $('.submenu').click(function () {
                $(this).children('.children').slideToggle();
            });
        }
    </script>
</html>
