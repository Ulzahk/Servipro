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
        <title>Editar Empleado Practica</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    </head>
    <body>
        <%
            Modelos.Empleados.clsEmpleado obclsEmpleado = new Modelos.Empleados.clsEmpleado();

            if (request.getAttribute("obclsEmpleado") != null) {
                obclsEmpleado = (Modelos.Empleados.clsEmpleado) request.getAttribute("obclsEmpleado");
            }

            List<Modelos.Empleados.clsEmpleado> lstclsEmpleado = new ArrayList<Modelos.Empleados.clsEmpleado>();

            if (request.getAttribute("lstclsEmpleado") != null) {
                lstclsEmpleado = (List<Modelos.Empleados.clsEmpleado>) request.getAttribute("lstclsEmpleado");
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

        <%--Barra de Navegación de Jefe--%>
        <%
            if (Descripcion_perfil.equals("JEFE")) {

                out.println("<nav class='navbar navbar-expand-sm bg-info navbar-dark justify-content-center'>");
                out.println("<a class='navbar-brand' href='index.htm'>ServiSoft S.A.</a>");
                out.println("<div>");
                out.println("<ul class='navbar-nav'>");
                out.println("<li class='nav-item dropdown'>");
                out.println("<a class='nav-link dropdown-toggle' href='#' id='navbardrop' data-toggle='dropdown'>");
                out.println("Control Usuarios");
                out.println("</a>");
                out.println("<div class='dropdown-menu'>");
                out.println("<a class='dropdown-item' href='usuarios.htm'>Usuarios</a>");
                out.println("<a class='dropdown-item' href='perfil.htm'>Perfil</a>");
                out.println("</div>");;
                out.println("</li>");
                out.println("<li class='nav-item dropdown'>");
                out.println("<a class='nav-link dropdown-toggle' href='#' id='navbardrop' data-toggle='dropdown'>");
                out.println("Novedades");
                out.println("</a>");
                out.println("<div class='dropdown-menu'>");
                out.println("<a class='dropdown-item' href='tipodenovedades.htm'>Tabla De Novedades</a>");
                out.println("<a class='dropdown-item' href='facturacion.htm'>Facturación</a>");
                out.println("<a class='dropdown-item' href='novedadesempleado.htm'>Novedades por Empleado</a>");
                out.println("</div>");
                out.println("</li>");
                out.println("<li class='nav-item dropdown'>");
                out.println("<a class='nav-link dropdown-toggle' href='#' id='navbardrop' data-toggle='dropdown'>");
                out.println("Centro de Costos");
                out.println("</a>");
                out.println("<div class='dropdown-menu'>");
                out.println("<a class='dropdown-item' href='centrodecostos.htm'>Tabla Centro de Costos</a>");
                out.println("</div>");
                out.println("</li>");
                out.println("<li class='nav-item dropdown'>");
                out.println("<a class='nav-link dropdown-toggle' href='#' id='navbardrop' data-toggle='dropdown'>");
                out.println("Empleados");
                out.println("</a>");
                out.println("<div class='dropdown-menu'>");
                out.println("<a class='dropdown-item' href='empleados.htm'>Tabla Empleados</a>");
                out.println("<a class='dropdown-item' href='cargoempleado.htm'>Cargo Empleado</a>");
                out.println("</div>");
                out.println("</li>");
                out.println("<li class='nav-item dropdown'>");
                out.println("<a class='nav-link dropdown-toggle' href='#' id='navbardrop' data-toggle='dropdown'>");
                out.println("Modulos");
                out.println("</a>");
                out.println("<div class='dropdown-menu'>");
                out.println("<a class='dropdown-item' href='modulos.htm'>Tabla Modulos</a>");
                out.println("<a class='dropdown-item' href='modulosperfil.htm'>Modulos por Perfil</a>");
                out.println("</div>");
                out.println("</li>");
                out.println("<li class='nav-item dropdown'>");
                out.println("<a class='nav-link dropdown-toggle' href='#' id='navbardrop' data-toggle='dropdown'>");
                out.println("Grupos");
                out.println("</a>");
                out.println("<div class='dropdown-menu'>");
                out.println("<a class='dropdown-item' href='grupos.htm'>Tabla Grupos</a>");
                out.println("<a class='dropdown-item' href='empleadosgrupo.htm'>Empleados por Grupo</a>");
                out.println("<a class='dropdown-item' href='responsablegrupo.htm'>Responsable del Grupo</a>");
                out.println("</div>");
                out.println("</li>");
                out.println("<li class='nav-item dropdown'>");
                out.println("<a class='nav-link dropdown-toggle' href='#' id='navbardrop' data-toggle='dropdown'>");
                out.println("Configuracion");
                out.println("</a>");
                out.println("<div class='dropdown-menu'>");
                out.println("<a class='dropdown-item' href='configuracion.htm'>Configuracion</a>");
                out.println("</div>");
                out.println("</li>");
                out.println("<li class='nav-item dropdown'>");
                out.println("<a class='nav-link dropdown-toggle btn btn-dark' href='#' id='navbardrop' data-toggle='dropdown'>");
                out.println("Usuario:");
                out.println(id_usuario);
                out.println("</a>");
                out.println("<div class='dropdown-menu text-center'>");
                out.println("<a class='dropdown-item' href='nomina.htm'>");
                out.println("Perfil:");
                out.println(Descripcion_perfil);
                out.println("</a>");
                out.println("<form action='cerrar' method='post' id='formcerrar'>");
                out.println("<input type='submit' value='Cerrar Sesión' "
                        + " class='btn btn-link text-center' style='color: #000;'/>");
                out.println("</form>");
                out.println("</div>");
                out.println("</li>");
                out.println("</ul>");
                out.println("</div>");
                out.println("</nav>");
            }
        %>

        <%--Barra de Navegación de Coordinador--%>
        <%
            if (Descripcion_perfil.equals("COORDINADOR")) {

                out.println("<nav class='navbar navbar-expand-sm bg-info navbar-dark justify-content-center'>");
                out.println("<a class='navbar-brand' href='index.htm'>ServiSoft S.A.</a>");
                out.println("<div>");
                out.println("<ul class='navbar-nav'>");
                out.println("<li class='nav-item dropdown'>");
                out.println("<a class='nav-link dropdown-toggle' href='#' id='navbardrop' data-toggle='dropdown'>");
                out.println("Novedades");
                out.println("</a>");
                out.println("<div class='dropdown-menu'>");
                out.println("<a class='dropdown-item' href='tipodenovedades.htm'>Tabla De Novedades</a>");
                out.println("<a class='dropdown-item' href='facturacion.htm'>Facturación</a>");
                out.println("<a class='dropdown-item' href='novedadesempleado.htm'>Novedades por Empleado</a>");
                out.println("</div>");
                out.println("</li>");
                out.println("<li class='nav-item dropdown'>");
                out.println("<a class='nav-link dropdown-toggle' href='#' id='navbardrop' data-toggle='dropdown'>");
                out.println("Centro de Costos");
                out.println("</a>");
                out.println("<div class='dropdown-menu'>");
                out.println("<a class='dropdown-item' href='centrodecostos.htm'>Tabla Centro de Costos</a>");
                out.println("</div>");
                out.println("</li>");
                out.println("<li class='nav-item dropdown'>");
                out.println("<a class='nav-link dropdown-toggle' href='#' id='navbardrop' data-toggle='dropdown'>");
                out.println("Empleados");
                out.println("</a>");
                out.println("<div class='dropdown-menu'>");
                out.println("<a class='dropdown-item' href='empleados.htm'>Tabla Empleados</a>");
                out.println("<a class='dropdown-item' href='cargoempleado.htm'>Cargo Empleado</a>");
                out.println("</div>");
                out.println("</li>");
                out.println("<li class='nav-item dropdown'>");
                out.println("<a class='nav-link dropdown-toggle' href='#' id='navbardrop' data-toggle='dropdown'>");
                out.println("Grupos");
                out.println("</a>");
                out.println("<div class='dropdown-menu'>");
                out.println("<a class='dropdown-item' href='grupos.htm'>Tabla Grupos</a>");
                out.println("<a class='dropdown-item' href='empleadosgrupo.htm'>Empleados por Grupo</a>");
                out.println("<a class='dropdown-item' href='responsablegrupo.htm'>Responsable del Grupo</a>");
                out.println("</div>");
                out.println("</li>");
                out.println("<li class='nav-item dropdown'>");
                out.println("<a class='nav-link dropdown-toggle' href='#' id='navbardrop' data-toggle='dropdown'>");
                out.println("Configuracion");
                out.println("</a>");
                out.println("<div class='dropdown-menu'>");
                out.println("<a class='dropdown-item' href='configuracion.htm'>Configuracion</a>");
                out.println("</div>");
                out.println("</li>");
                out.println("<li class='nav-item dropdown'>");
                out.println("<a class='nav-link dropdown-toggle btn btn-dark' href='#' id='navbardrop' data-toggle='dropdown'>");
                out.println("Usuario:");
                out.println(id_usuario);
                out.println("</a>");
                out.println("<div class='dropdown-menu text-center'>");
                out.println("<a class='dropdown-item' href='nomina.htm'>");
                out.println("Perfil:");
                out.println(Descripcion_perfil);
                out.println("</a>");
                out.println("<form action='cerrar' method='post' id='formcerrar'>");
                out.println("<input type='submit' value='Cerrar Sesión' "
                        + " class='btn btn-link text-center' style='color: #000;'/>");
                out.println("</form>");
                out.println("</div>");
                out.println("</li>");
                out.println("</ul>");
                out.println("</div>");
                out.println("</nav>");
            }
        %> 

        <div class="container mt-4">
            <h1 class="text-center">Editar Empleado Practica</h1>
            <br>
            <div class="card border-info">
                <div class="card-header bg-info text-white">
                    <a href="empleados?btnEmplConsultar=true" class="btn btn-secondary"><i class="fas fa-arrow-left"></i></a>
                </div>
                <div class="card-body">
                    <form action="empleados" method="POST">
                        <!--FILA-->
                        <div class="form-group">
                            <div class="row">
                                <div class="col-4">
                                    <label for="lblTipoDocumento">Tipo Documento</label>
                                    <select class="form-control" name="ddlTipoDocumento">
                                        <%
                                            List<Modelos.Empleados.clsTipoDocumento> lstclsTipoDocumento = new ArrayList<Modelos.Empleados.clsTipoDocumento>();

                                            if (request.getAttribute("lstclsTipoDocumento") != null) {
                                                lstclsTipoDocumento = (List<Modelos.Empleados.clsTipoDocumento>) request.getAttribute("lstclsTipoDocumento");
                                            }

                                            for (Modelos.Empleados.clsTipoDocumento elem : lstclsTipoDocumento) {
                                        %>
                                        <option value="<%=elem.getInId()%>"
                                                <%=obclsEmpleado.getObclsTipoDocumento() != null ? obclsEmpleado.getObclsTipoDocumento().getInId() == elem.getInId() ? "selected" : "" : ""%>>
                                            <%=elem.getStDescripcion()%>
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                                <div class="col-8">
                                    <label for="lblDocumento">Documento</label>
                                    <input type="txt" class="form-control" name="txtDocumento"
                                           value="<%=obclsEmpleado.getStDocumento() != null ? obclsEmpleado.getStDocumento() : ""%>"/>
                                </div>
                            </div>
                        </div>
                        <!--FILA-->
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-6">
                                    <label for="lblNombre">Nombre</label>
                                    <input type="text" class="form-control" name="txtNombre"
                                           value="<%=obclsEmpleado.getStNombre() != null ? obclsEmpleado.getStNombre() : ""%>"/>
                                </div>
                                <div class="col-6">
                                    <label for="lblTelefono">Telefono</label>
                                    <input type="text" class="form-control" name="txtTelefono"
                                           value="<%=obclsEmpleado.getStTelefono() != null ? obclsEmpleado.getStTelefono() : ""%>"/>
                                </div>
                            </div>
                        </div>
                        <!--FILA-->       
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-6">
                                    <label for="lblCentroCosto">Centro Costos</label>
                                    <select class="form-control" name="ddlCentroCosto">
                                        <%
                                            List<Modelos.Empleados.clsCentroCosto> lstclsCentroCosto = new ArrayList<Modelos.Empleados.clsCentroCosto>();
                                            if(request.getAttribute("lstclsCentroCosto")!=null){
                                                lstclsCentroCosto = (List<Modelos.Empleados.clsCentroCosto>)request.getAttribute("lstclsCentroCosto");
                                            }
                                            for(Modelos.Empleados.clsCentroCosto elem: lstclsCentroCosto){
                                        %>
                                        <option value="<%=elem.getInId()%>"
                                                <%=obclsEmpleado.getObclsCentroCosto() !=null ? obclsEmpleado.getObclsCentroCosto().getInId() == elem.getInId() ? "selected": "": ""%>>
                                            <%=elem.getStDescripcion()%>
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                                <div class="col-6">
                                    <label for="lblCargo">Cargo</label>
                                    <select class="form-control" name="ddlCargo">
                                        <%
                                            List<Modelos.Empleados.clsCargo> lstclsCargo = new ArrayList<Modelos.Empleados.clsCargo>();
                                            
                                            if(request.getAttribute("lstclsCargo")!=null){
                                                lstclsCargo = (List<Modelos.Empleados.clsCargo>)request.getAttribute("lstclsCargo");
                                            }
                                            for(Modelos.Empleados.clsCargo elem: lstclsCargo){    
                                        %>
                                        <option value="<%=elem.getInId()%>"
                                                <%=obclsEmpleado.getObclsCargo() !=null ? obclsEmpleado.getObclsCargo().getInId() == elem.getInId() ? "selected": "": ""%>>
                                            <%=elem.getStDescripcion()%>
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
                                    <input type="submit" value="Guardar" class="btn btn-info" name="btnEmplModificar"/>
                                    <input type="text" name="IdModificar" id="IdModificar" value="<%=obclsEmpleado.getInId()%>" hidden=""/>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
