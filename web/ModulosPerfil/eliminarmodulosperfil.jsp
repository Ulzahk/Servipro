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
        <title>Eliminar Empleado</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
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

        <div class="container">
            <div class="card border-info">
                <div class="card-header bg-info text-white">
                    <div class="form-group">
                        <div class="form-group">
                            <div class="col-12 text-center">                                    
                                <h5 class="align-middle mt-1"> 
                                    <b><%=obclsModulosPerfil.getObclsModulo().getStNombre_modulo()!= null ? obclsModulosPerfil.getObclsModulo().getStNombre_modulo(): ""%></b>
                                </h5>                                         
                            </div>
                        </div>
                    </div>
                </div>
                <div class="card-body">
                    <form action="controlmodulosperfil" method="POST">
                        <!--FILA-->
                        <div class="form-group">
                            <div class="row">
                                <div class="col-2">
                                </div>
                                <div class="col-8 text-center">
                                    <i class="fas fa-exclamation-triangle mb-2" style="font-size:70px;color:#FFCC00;"></i>
                                    <h4 class="font-weight-bold">¿Estás seguro de que quieres eliminar esto?</h4>
                                    <h6>No podrás deshacer esta acción</h6>
                                </div>
                                <div class="col-2">
                                </div>
                            </div>
                        </div>
                        <!--FILA-->   
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-12 text-center btn-group">
                                    <a href="controlmodulosperfil?btnModPerfilConsultar=true" class="btn btn-info font-weight-bold rounded"><span>No, cancelar</span></a>
                                    <span>&nbsp;</span>
                                    <input type="submit" value="Si, eliminar" class="btn btn-danger font-weight-bold rounded ml-1" name="btnModPerfilEliminar"/>
                                    <input type="text" name="IdModificar" id="IdModificar" value="<%=obclsModulosPerfil.getId_modulos_perfil()%>" hidden=""/>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
