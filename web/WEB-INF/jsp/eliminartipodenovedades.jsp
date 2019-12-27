<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <title>Eliminar Tipo De Novedades</title>
        <link rel="stylesheet" href="<c:url value="/Resources/CSS/style.css"/>"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </head>
    <body>
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
                                <a href="tipodenovedades.htm" class="btn btn-info" data-toggle="tooltip" title="Haz clic para regresar al menú perfil" class="btn btn-info font-weight-bold"><span>No, cancelar</span></a>
                                <span>&nbsp;</span>
                                <a href="<c:url value="confirmareliminartipodenovedades.htm?id_novedad=${dato.Id_novedad}"/>"class="btn btn-danger"><b>Confirmar Eliminación</b></a>                                        
                            </c:forEach>
                            <div class="col-2">
                            </div>
                        </div>
                    </div>
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