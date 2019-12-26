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
        <title>Agregar Modulos por Perfil</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>

    </head>
    <body>
        <%
            Modelos.ModulosPerfil.clsModulosPerfil obclsModulosPerfil = new Modelos.ModulosPerfil.clsModulosPerfil();

            if (request.getAttribute("obclsModulosPerfil") != null) {
                obclsModulosPerfil = (Modelos.ModulosPerfil.clsModulosPerfil) request.getAttribute("obclsModulosPerfil");
            }

            List<Modelos.ModulosPerfil.clsModulosPerfil> lstclsModulosPerfil = new ArrayList<Modelos.ModulosPerfil.clsModulosPerfil>();

            if (request.getAttribute("lstclsModulosPerfil") != null) {

                lstclsModulosPerfil = (List<Modelos.ModulosPerfil.clsModulosPerfil>) request.getAttribute("lstclsModulosPerfil");
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
            <h1 class="text-center">Agregar Modulos por Perfil</h1>
            <br>
            <div class="card border-info">
                <div class="card-header bg-info text-white">
                    <a href="controlmodulosperfil?btnModPerfilConsultar=true" class="btn btn-secondary"><i class="fas fa-arrow-left"></i></a>
                </div>
                <div class="card-body">
                    <form action="controlmodulosperfil" method="POST">
                        <!--FILA-->
                        <div class="form-group">
                            <div class="row">
                                <div class="col-6">
                                    <label for="lblmodulos"><b>Modulos</b></label>
                                    <select class="form-control" name="ddlModulo">
                                        <%
                                            List<Modelos.ModulosPerfil.clsModulo> lstclsModulos = new ArrayList<Modelos.ModulosPerfil.clsModulo>();

                                            if (request.getAttribute("lstclsModulos") != null) {
                                                lstclsModulos = (List<Modelos.ModulosPerfil.clsModulo>) request.getAttribute("lstclsModulos");
                                            }

                                            for (Modelos.ModulosPerfil.clsModulo elem : lstclsModulos) {
                                        %>
                                        <option value="<%=elem.getId_modulo()%>"
                                                <%=obclsModulosPerfil.getObclsModulo() != null ? obclsModulosPerfil.getObclsModulo().getId_modulo() == elem.getId_modulo() ? "selected" : "" : ""%>>
                                            <%=elem.getStNombre_modulo()%>
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                                <div class="col-6">
                                    <label for="lblPerfil"><b>Perfil</b></label>
                                    <select class="form-control" name="ddlPerfil">
                                        <%
                                            List<Modelos.ModulosPerfil.clsPerfil> lstclsPerfil = new ArrayList<Modelos.ModulosPerfil.clsPerfil>();
                                            if (request.getAttribute("lstclsPerfil") != null) {
                                                lstclsPerfil = (List<Modelos.ModulosPerfil.clsPerfil>) request.getAttribute("lstclsPerfil");
                                            }
                                            for (Modelos.ModulosPerfil.clsPerfil elem : lstclsPerfil) {
                                        %>
                                        <option value="<%=elem.getId_perfil()%>"
                                                <%=obclsModulosPerfil.getObclsPerfil() != null ? obclsModulosPerfil.getObclsPerfil().getId_perfil() == elem.getId_perfil() ? "selected" : "" : ""%>>
                                            <%=elem.getStDescripcion_perfil()%>
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-12">
                                    <input type="submit" value="Guardar" class="btn btn-info" name="btnModPerfilGuardar"/>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>  
    </body>
</html>







