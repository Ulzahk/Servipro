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
        <title>Empleados</title>
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
            <h1 class="text-center">Empleados</h1>
            <br>
            <div class="card border-info">
                <div class="card-header bg-info text-white">
                    <form action="empleados" method="post">
                        <div class="input-group mt-3">
                            <a href="nomina.htm" class="btn btn-secondary mr-2"><i class="fas fa-arrow-left"></i></a>
                            <a href="empleados?btnEmplAgregar=true" class="btn btn-secondary mr-2">Agregar Registro</a>
                            <a href="empleados?btnEmplConsultar=true" class="btn btn-secondary mr-2">Cargar Registros</a>
                            <input type="text" class="form-control" name="txtEmplBuscar" id="txtEmplBuscar" placeholder="Buscar en Servisoft S.A."/>
                            <div class="input-group-append">
                                <input type="submit" value="Buscar" class="btn btn-secondary" name="btnEmplBuscar"> 
                            </div>
                        </div>
                    </form>
                </div>
                <div class="card-body">
                    <table border="1" class="table table-bordered table-striped table-hover text-center table-responsive-lg">
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-12">
                                    <b>
                                        <i class="fas fa-clipboard-list"></i>
                                        <span>Registros: <%=lstclsEmpleado.size()%></span>
                                    </b>
                                </div>
                            </div>
                        </div>

                        <tr>
                            <td class="align-middle"><b>Tipo Documento</b></td>
                            <td class="align-middle"><b>Documento</b></td>
                            <td class="align-middle"><b>Nombre</b></td>
                            <td class="align-middle"><b>Telefono</b></td>
                            <td class="align-middle"><b>Centro de Costos</b></td>
                            <td class="align-middle"><b>Cargo</b></td>
                            <td class="align-middle"><b>Acciones</b></td>
                        </tr>
                        <%
                            for (Modelos.Empleados.clsEmpleado elem : lstclsEmpleado) {
                        %>
                        <tr>
                            <td class="align-middle"><%=elem.getObclsTipoDocumento().getStDescripcion()%></td>
                            <td class="align-middle"><%=elem.getStDocumento()%></td>
                            <td class="align-middle"><%=elem.getStNombre()%></td>
                            <td class="align-middle"><%=elem.getStTelefono()%></td>
                            <td class="align-middle"><%=elem.getObclsCentroCosto().getStDescripcion()%></td>
                            <td class="align-middle"><%=elem.getObclsCargo().getStDescripcion()%></td>
                            <td class="align-middle">
                                <a class="btn btn-warning btn-sm mb-2 openBtn" data-toggle="modal" data-target="#myModal" id="btnEmplModificar" 
                                   href="empleados?stOpcion=M&codigoSeleccionado=<%=elem.getInId()%>">
                                    <i class="fas fa-edit" style="font-size:15px;"></i>
                                </a>
                                <a class="btn btn-danger btn-sm" id="btnEmplEliminar"
                                   href="empleados?stOpcion=E&codigoSeleccionado=<%=elem.getInId()%>">
                                    <i class="fas fa-trash-alt" style="font-size:15px;"></i>
                                </a>
                            </td>
                        </tr>
                        <%
                            }
                        %>
                    </table>   
                </div>
            </div>

            <!-- Modal -->
            <div class="modal fade" id="myModal" role="dialog">
                <div class="modal-dialog modal-lg ">

                    <!-- Modal content-->
                    <div class="modal-content">  
                        <div class="modal-body">

                        </div>
                    </div>
                </div>
            </div>

            <script>
                //Confirmación Eliminar
                $('a.btn-danger').click(function (event) {
                    event.preventDefault();

                    var r = confirm("¿Esta seguro que quiere eliminar este registro?");
                    if (r == true) {
                        window.location = this.href;
                    } else {
                        alert("El registro se mantiene intacto");
                    }
                });
          
                //Funcionamiento Modal
                $('.openBtn').on('click', function () {
                    $('.modal-body').load(this.href, function ()
                    {
                        $('#myModal').modal({show: false});
                    });
                });
            </script>
    </body>
</html>






