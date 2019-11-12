<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession objsesion = request.getSession(false);
    String id_usuario = (String)objsesion.getAttribute("id_usuario");
    if(id_usuario==null){
        response.sendRedirect("login.jsp");
    }
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta charset="UTF-8">
        <title>Index</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
        <link rel="stylesheet" href="<c:url value="/Resources/CSS/style.css"/>"/>
          <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
          <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
          <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
          <script src='https://kit.fontawesome.com/a076d05399.js'></script>
          
    </head>

    <body>
        <div class="container mt-3 mb-1 text-center">
           <img src="<c:url value="/Resources/Images/LogoServiSoft.png"/>"/>  
        </div>
        <br/>
        <div class="container mt-4 text-center">
            <!--Primera Fila-->
            <div class="row text-center">
                <a href="nomina.htm" class="col-2 cIndex colorEnlace">
                    <i class="fas fa-file-invoice-dollar mb-2 mt-2 tamañoIcono"></i>
                    <p><b>Nomina</b></p>
                </a>
                <a href="index.htm" class="col-2 cIndex colorEnlace">
                    <i class="fas fa-chart-bar mb-2 mt-2 tamañoIcono"></i>
                    <p><b>Contabilidad</b></p>
                </a>
            </div>
        </div>
    </body>   
</html>
