<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Agregar Nueva Novedad por Empleado</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
        <link rel="stylesheet" href="<c:url value="/Resources/CSS/style.css"/>"/>
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    </head>
    <body>
        <%
            Modelos.NovedadesEmpleado.clsNovedadesEmpleado obclsNovedadesEmpleado = new Modelos.NovedadesEmpleado.clsNovedadesEmpleado();

            if (request.getAttribute("obclsNovedadesEmpleado") != null) {
                obclsNovedadesEmpleado = (Modelos.NovedadesEmpleado.clsNovedadesEmpleado) request.getAttribute("obclsNovedadesEmpleado");
            }

            List<Modelos.NovedadesEmpleado.clsNovedadesEmpleado> lstclsNovedadesEmpleado = new ArrayList<Modelos.NovedadesEmpleado.clsNovedadesEmpleado>();

            if (request.getAttribute("lstclsNovedadesEmpleado") != null) {
                lstclsNovedadesEmpleado = (List<Modelos.NovedadesEmpleado.clsNovedadesEmpleado>) request.getAttribute("lstclsNovedadesEmpleado");
            }

            if (request.getAttribute("stMensaje") != null && request.getAttribute("stTipo") != null) {

        %>
        <input type="txt" hidden="" id="txtMensaje" value="<%=request.getAttribute("stMensaje")%>"/>
        <input type="txt" hidden="" id="txtTipo" value="<%=request.getAttribute("stTipo")%>"/>
        <script>
            var mensaje = document.getElementById("txtMensaje").value;
            var tipo = document.getElementById("txtTipo").value;
            swal("Mensaje", mensaje, tipo);
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
        <div class="container mt-4">
            <h1 class="text-center">Agregar Nueva Novedad por Empleado</h1>
            <br>
            <div class="card border-info">
                <div class="card-header bg-info text-white">
                    <a href="controlnovedadesempleado?btnNoveEmplConsultar=true" class="btn btn-secondary"data-toggle="tooltip" title="Haz clic para regresar al menú novedades por empleados"><i class="fas fa-arrow-left"></i></a>
                </div>
                <div class="card-body">
                    <form action="controlnovedadesempleado" method="POST">
                        <!--FILA-->
                        <div class="form-group">
                            <div class="row">
                                <div class="col-6">
                                    <label for="lblEmpleado"><b>Empleado</b></label>
                                    <select class="form-control" name="ddlEmpleado">
                                        <%
                                            List<Modelos.NovedadesEmpleado.clsEmpleado> lstclsEmpleado = new ArrayList<Modelos.NovedadesEmpleado.clsEmpleado>();

                                            if (request.getAttribute("lstclsEmpleado") != null) {
                                                lstclsEmpleado = (List<Modelos.NovedadesEmpleado.clsEmpleado>) request.getAttribute("lstclsEmpleado");
                                            }

                                            for (Modelos.NovedadesEmpleado.clsEmpleado elem : lstclsEmpleado) {
                                        %>
                                        <option value="<%=elem.getId_empleado()%>"
                                                <%=obclsNovedadesEmpleado.getObclsEmpleado() != null ? obclsNovedadesEmpleado.getObclsEmpleado().getId_empleado() == elem.getId_empleado() ? "selected" : "" : ""%>>
                                            <%=elem.getEmplPrimerNombre()%>
                                            <%=elem.getEmplSegundoNombre()%>
                                            <%=elem.getEmplPrimerApellido()%>
                                            <%=elem.getEmplSegundoApellido()%>
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                                <div class="col-6">
                                    <label for="lblTipoNovedad"><b>Tipo de Novedad</b></label>
                                    <select class="form-control" name="ddlTipoNovedad">
                                        <%
                                            List<Modelos.NovedadesEmpleado.clsTipoNovedad> lstclsTipoNovedad = new ArrayList<Modelos.NovedadesEmpleado.clsTipoNovedad>();

                                            if (request.getAttribute("lstclsTipoNovedad") != null) {
                                                lstclsTipoNovedad = (List<Modelos.NovedadesEmpleado.clsTipoNovedad>) request.getAttribute("lstclsTipoNovedad");
                                            }

                                            for (Modelos.NovedadesEmpleado.clsTipoNovedad elem : lstclsTipoNovedad) {
                                        %>
                                        <option value="<%=elem.getId_novedad()%>"
                                                <%=obclsNovedadesEmpleado.getObclsTipoNovedad() != null ? obclsNovedadesEmpleado.getObclsTipoNovedad().getId_novedad() == elem.getId_novedad() ? "selected" : "" : ""%>>
                                            <%=elem.getDescripcion_novedad()%> (<%=elem.getAlias_novedad()%>)
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <!--FILA-->
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-12">
                                    <label for="lblDetalle"><b>Detalle</b></label>
                                    <input type="text" class="form-control" row="3" name="txtDetalle"
                                           value="<%=obclsNovedadesEmpleado.getDetalle() != null ? obclsNovedadesEmpleado.getDetalle() : ""%>"/>
                                </div>
                            </div>
                        </div>
                        <!--FILA-->       
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-6">
                                    <label for="lblFecha"><b>Fecha</b></label>
                                    <input type="text" class="form-control" row="3" name="txtFecha"
                                           value="<%=obclsNovedadesEmpleado.getFecha() != null ? obclsNovedadesEmpleado.getFecha() : ""%>"/>
                                </div>
                                <div class="col-6">
                                    <label for="lblDia"><b>Día</b></label>
                                    <input type="text" class="form-control" name="txtDia"
                                           value="<%=obclsNovedadesEmpleado.getDia() != 0 ? obclsNovedadesEmpleado.getDia() : ""%>"/>
                                </div>
                            </div>
                        </div>
                        <!--FILA-->   
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-12">
                                    <input type="submit" value="Guardar" class="btn btn-info" data-toggle="tooltip" title="Haz clic para guardar" name="btnNoveEmplGuardar"/>
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
