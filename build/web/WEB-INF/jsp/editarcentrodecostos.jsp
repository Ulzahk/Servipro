<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession objsesion = request.getSession(false);
    String id_usuario = (String)objsesion.getAttribute("id_usuario");
    String Descripcion_perfil = (String)objsesion.getAttribute("descripcion_perfil");
    if(id_usuario==null){
        response.sendRedirect("login.jsp");
    }else{
        if(Descripcion_perfil.equals("COORDINADOR")||
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
        <title>Editar Centro de Costos</title>
        <link rel="stylesheet" href="<c:url value="/Resources/CSS/style.css"/>"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <div class="card border-info">
                <div class="card-header bg-info text-white" >
                </div>
                <div class="card-body">
                    <form:form method="post" commandName="centrodecostos">
                        <form:errors path="*" element="div" cssClass="alert alert-danger"/>
                    <p>
                        <form:label path="nombre_ccostos"><b>Nombre C.Costos</b></form:label>
                        <form:input path="nombre_ccostos" cssClass="form-control"/>
                    </p>
                        <hr/>
                        <input type="submit" value="Guardar" class="btn btn-info"/>
                    </form:form>
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