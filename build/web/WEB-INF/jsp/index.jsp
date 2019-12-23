<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession objsesion = request.getSession(false);
    String id_usuario = (String)objsesion.getAttribute("id_usuario");
    String Descripcion_perfil = (String)objsesion.getAttribute("descripcion_perfil");
    if(id_usuario==null){
        response.sendRedirect("login.jsp");
    }
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Index</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
        <link rel="stylesheet" href="<c:url value="/Resources/CSS/style.css"/>"/>
          <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
          <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
          <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
          <script src='https://kit.fontawesome.com/a076d05399.js'></script>
          <script src="Resources/JS/functions.js"></script>
          
    </head>

    <body>
        
        <nav class="navbar navbar-expand-sm bg-info navbar-dark justify-content-center">
            <a class="navbar-brand" href="index.htm">ServiSoft S.A.</a>  
            <div>
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="nomina.htm">Nomina</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Contabilidad</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Modulo 3</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Modulo 4</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Modulo 5</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle btn btn-dark" href="#" id="navbardrop" data-toggle="dropdown">
                            Usuario: <% out.println(id_usuario); %>
                        </a>
                        <div class="dropdown-menu text-center">
                            <a class="dropdown-item" href="nomina.htm">Perfil: <%out.println(Descripcion_perfil);%></a>
                            <form action="cerrar" method="post" id="formcerrar">
                                <input type="submit" value="Cerrar Sesión"  class="btn btn-link text-center"
                                       style="color: #000;"/>
                            </form>
                        </div> 
                    </li>
                </ul>
            </div>    
        </nav>
        
        
        
        
        
        <div class="container mt-3 mb-1 text-center">
           <img src="<c:url value="/Resources/Images/LogoServiSoft.png"/>"/>  
        </div>
        <br/>
        <div class="container mt-4 text-center">
            <!--Primera Fila-->
            <div class="row text-center">
                <a href="nomina.htm" class="col cIndex colorEnlace">
                    <i class="fas fa-file-invoice-dollar mb-2 mt-2 tamañoIcono"></i>
                    <p><b>Nomina</b></p>
                </a>
                <a href="index.htm" class="col cIndex colorEnlace" onclick="bloqueo();">
                    <i class="fas fa-chart-bar mb-2 mt-2 tamañoIcono"></i>
                    <p><b>Contabilidad</b></p>
                </a>
            </div>
        </div>
    </body>   
</html>
