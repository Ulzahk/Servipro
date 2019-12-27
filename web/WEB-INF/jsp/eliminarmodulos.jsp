<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar Módulo</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <div class="card border-info">
                <div class="card-header bg-info text-white">
                    <div class="form-group">
                        <div class="form-group">
                            <div class="col-12 text-center">                                    
                                <h5 class="align-middle mt-1"> 
                                    <b>

                                    </b>
                                </h5>                                         
                            </div>
                        </div>
                    </div>
                </div>
                <div class="card-body">
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
                            <div class="col-2">
                            </div>
                            <c:forEach var="dato" items="${datos}">                                    
                                <div class="col-8 text-center">
                                    <a href="modulos.htm" class="btn btn-info" data-toggle="tooltip" title="Haz clic para regresar al menú perfil" class="btn btn-info font-weight-bold"><span>No, cancelar</span></a>
                                    <span>&nbsp;</span>
                                    <a href="<c:url value="confirmareliminarmodulos.htm?id_modulo=${dato.Id_modulo}"/>" class="btn btn-danger"><b>Confirmar Eliminación</b></a>                                </c:forEach>
                                <div class="col-2">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>