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
        <title>Agregar Módulos por Perfil</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
        <link rel="stylesheet" href="<c:url value="/Resources/CSS/style.css"/>"/>
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
            <h1 class="text-center">Agregar Módulos por Perfil</h1>
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
                                    <label for="lblmodulos"><b>Módulos</b></label>
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







