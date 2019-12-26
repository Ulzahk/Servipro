<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession objsesion = request.getSession(false);
    String id_usuario = (String)objsesion.getAttribute("id_usuario");
    String Descripcion_perfil = (String)objsesion.getAttribute("descripcion_perfil");
    if(id_usuario==null){
        response.sendRedirect("login.jsp");
    }else{
        if(Descripcion_perfil.equals("ADMINISTRADOR")||
                Descripcion_perfil.equals("JEFE")){
            
        }else{
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
        <title>Eliminar Perfil</title>
        <link rel="stylesheet" href="<c:url value="/Resources/CSS/style.css"/>"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        <script src="<c:url value="/Resources/JS/functions.js"/>"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </head>
    <body>
        
       <header>
        <%--Barra de Navegación de Jefe--%>
        <%
            if (Descripcion_perfil.equals("JEFE")) {

        %>       

        <jsp:include page="menujefe.jsp"></jsp:include>

        <%        }
        %>

        <%--Barra de Navegación de Administrador--%>
        <%
            if (Descripcion_perfil.equals("ADMINISTRADOR")) {
        %>

        <jsp:include page="menuadmin.jsp"></jsp:include>

        <%
            }
        %> 

        <%--Barra de Navegación de Coordinador--%>
        <%
            if (Descripcion_perfil.equals("COORDINADOR")) {
        %>

        <jsp:include page="menucordi.jsp"></jsp:include>

        <%
            }
        %> 
    </header>
        
        
        <div class="container mt-4">
            <h1 class="text-center">Eliminar Perfil</h1>
            <br>
            <h3 class="text-center">¿Está seguro de que quiere eliminar este registro?</h3>
            <br>
            <div class="card border-info">
                <div class="card-header bg-info text-white">
                    <a href="perfil.htm" class="btn btn-secondary" data-toggle="tooltip" title="Haz clic para regresar al menú perfil"><i class="fas fa-arrow-left"></i></a>
                </div>
                <div class="card-body">
                    <table border="1" class="table table-bordered table-striped table-hover text-center">
                        <thead>
                            <tr>
                                <th class="align-middle">Perfil</th>
                                <th class="align-middle">Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="dato" items="${datos}">
                            <tr>
                                <td class="align-middle"><c:out value="${dato.Descripcion_perfil}"/></td>
                                <td class="align-middle">
                                    <a href="<c:url value="confirmareliminarperfil.htm?id_perfil=${dato.Id_perfil}"/>"class="btn btn-danger"><b>Confirmar Eliminación</b></a>
                                </td>
                            </tr>
                            </c:forEach>
                        </tbody>    
                    </table>   
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
