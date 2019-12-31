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
        if (Descripcion_perfil.equals("ADMINISTRADOR")
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
        <title>Modulos por Perfil</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
        <link rel="stylesheet" href="<c:url value="/Resources/CSS/style.css"/>"/>
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
        <script src="Resources/JS/functions.js"></script>

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

        <header>
            <%--Barra de Navegación de Jefe--%>
            <%
                if (Descripcion_perfil.equals("JEFE")) {
            %>
            <jsp:include page="../WEB-INF/jsp/menujefe.jsp"></jsp:include>
            <%
                }
            %>

            <%--Barra de Navegación de Administrador--%>
            <%
                if (Descripcion_perfil.equals("ADMINISTRADOR")) {
            %>
            <jsp:include page="../WEB-INF/jsp/menuadmin.jsp"></jsp:include>
            <%
                }
            %> 
        </header>

        <div class="container mt-4">
            <h1 class="text-center">Módulos por Perfil</h1>
            <br>
            <div class="card border-info">
                <div class="card-header bg-info text-white">
                    <form action="controlmodulosperfil" method="post">
                        <div class="input-group">
                            <a href="nomina.htm" class="btn btn-secondary mr-1"data-toggle="tooltip" title="Haz clic para regresar al menú nómina"><i class="fas fa-arrow-left"></i></a>
                            <a href="controlmodulosperfil?btnModPerfilAgregar=true" class="btn btn-secondary mr-1"data-toggle="tooltip" title="Haz clic para agregar un nuevo registro">Agregar Registro</a>
                            <input type="text" class="form-control rounded-left" name="txtModPerfilBuscar" id="txtModPerfilBuscar" placeholder="Buscar en Servisoft S.A."/>
                            <div class="input-group-append">                                
                                <button type="submit" Value="Buscar" class="btn btn-secondary rounded-right" name="btnModPerfilBuscar"data-toggle="tooltip" title="Haz clic para buscar"><i class="fas fa-search"></i></button>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="card-body">
                    <table id="table-id" border="1" class="table table-bordered table-striped table-hover text-center table-responsive-sm">
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-3">
                                    <select class="form-control form-control-sm" name="state" id="maxRows">
                                        <option value="5000">Filtro de Paginación</option>
                                        <option value="5000">Todos</option>
                                        <option value="5">5</option>
                                        <option value="10">10</option>
                                        <option value="15">15</option>
                                        <option value="25">25</option>
                                        <option value="50">50</option>
                                        <option value="75">75</option>
                                        <option value="100">100</option>
                                    </select>
                                </div>
                                <div class="col-8 ml-2">
                                    <b>
                                        <i class="fas fa-clipboard-list"></i>
                                        <span>Registros Existentes: <%=lstclsModulosPerfil.size()%></span>
                                    </b>
                                </div>
                            </div>
                        </div>

                        <tr>
                            <td class="align-middle"><b>Módulo</b></td>
                            <td class="align-middle"><b>Perfil</b></td>
                            <td class="align-middle"><b>Acciones</b></td>
                        </tr>
                        <%
                            for (Modelos.ModulosPerfil.clsModulosPerfil elem : lstclsModulosPerfil) {
                        %>
                        <tr>
                            <td class="align-middle"><%=elem.getObclsModulo().getStNombre_modulo()%></td>
                            <td class="align-middle"><%=elem.getObclsPerfil().getStDescripcion_perfil()%></td>
                            <td class="align-middle">
                                <div class="btn-group">
                                    <a class="btn btn-warning btn-sm mr-1 openBtn rounded" title="Haz clic para editar perfil" data-toggle="modal" data-target="#myModal" id="btnModPerfilEditar" 
                                       href="controlmodulosperfil?stOpcion=M&codigoSeleccionado=<%=elem.getId_modulos_perfil()%>">
                                        <i class="fas fa-edit" style="font-size:15px;"></i>
                                    </a>
                                    <a class="btn btn-danger btn-sm openBtn rounded"  title="Haz clic para eliminar" data-toggle="modal" data-target="#myModal" id="btnModPerfilEliminar"
                                       href="controlmodulosperfil?stOpcion=E&codigoSeleccionado=<%=elem.getId_modulos_perfil()%>">
                                        <i class="fas fa-trash-alt" style="font-size:15px;"></i>
                                    </a>
                                </div>                                
                            </td>
                        </tr>
                        <%
                            }
                        %>
                    </table>
                    <!--Inicio de la Paginación -->
                    <div class='pagination-container' >
                        <nav>
                            <ul class="pagination">

                                <li data-page="prev" >
                                    <button class="btn btn-secondary btn-sm mr-1"><i class="fas fa-angle-left" style="font-size: 15px;"></i>&nbsp;<span class="sr-only">(current)</span></button>
                                </li>
                                <!--	Here the JS Function Will Add the Rows -->
                                <li data-page="next" id="prev">
                                    <button class="btn btn-secondary btn-sm"><i class="fas fa-angle-right" style="font-size: 15px;"></i><span class="sr-only">(current)</span></button>
                                </li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
            <!-- Modal -->
            <div class="modal fade" id="myModal" role="dialog">
                <div class="modal-dialog modal-lg">

                    <!-- Modal content-->
                    <div class="modal-content">  
                        <div class="modal-body">

                        </div>
                    </div>
                </div>
            </div>
            <script type="text/javascript" language="JavaScript">
                fpaginacion();
            </script>
    </body>
    <script type="text/javascript" language="JavaScript">
        main();
    </script>
</html>
