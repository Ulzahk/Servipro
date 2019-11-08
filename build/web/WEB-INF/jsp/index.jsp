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
        <nav class="navbar navbar-expand-sm bg-info navbar-dark justify-content-center">
            <a class="navbar-brand" href="index.htm">ServiSoft S.A.</a>  
            <div>
                <ul class="navbar-nav">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                            Control Usuarios
                        </a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="usuarios.htm">Usuarios</a>
                            <a class="dropdown-item" href="perfil.htm">Perfil</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                            Novedades
                        </a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="novedades.htm">Tabla Novedades</a>
                            <a class="dropdown-item" href="tiponovedad.htm">Tipo de Novedades</a>
                            <a class="dropdown-item" href="novedadesempleado.htm">Novedades por Empleado</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                            Centro de Costos
                        </a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="centrodecostos.htm">Tabla Centro de Costos</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                            Empleados
                        </a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="empleados.htm">Tabla Empleados</a>
                            <a class="dropdown-item" href="cargoempleado.htm">Cargo Empleado</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                            Modulos
                        </a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="modulos.htm">Tabla Modulos</a>
                            <a class="dropdown-item" href="modulosperfil.htm">Modulos por Perfil</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                            Grupos
                        </a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="grupos.htm">Tabla Grupos</a>
                            <a class="dropdown-item" href="empleadosgrupo.htm">Empleados por Grupo</a>
                            <a class="dropdown-item" href="responsablegrupo.htm">Responsable del Grupo</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                            Configuracion
                        </a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="configuracion.htm">Configuracion</a>
                        </div> 
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle btn btn-dark" href="#" id="navbardrop" data-toggle="dropdown">
                            Usuario: <% out.println(id_usuario); %>
                        </a>
                        <div class="dropdown-menu text-center">
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
                <a href="usuarios.htm" class="col aIndex colorEnlace">
                    <i class="fas fa-user-circle mb-2 mt-2 tamañoIcono"></i>
                    <p><b>Usuarios</b></p>
                </a>
                <a href="perfil.htm" class="col aIndex colorEnlace">
                    <i class="fas fa-address-card mb-2 mt-2 tamañoIcono"></i>
                    <p><b>Perfil</b></p>
                </a>
                <a href="novedades.htm" class="col bIndex colorEnlace">
                    <i class="fas fa-bullhorn mb-2 mt-2   tamañoIcono "></i>
                    <p><b>Novedades</b></p>
                </a>
                <a href="tiponovedad.htm" class="col bIndex colorEnlace">
                    <i class="fab fa-buromobelexperte mb-2 mt-2 tamañoIcono"></i>
                    <p><b>Tipo de Novedad</b></p>
                </a>
                <a href="novedadesempleado.htm" class="col bIndex colorEnlace">
                    <i class="fas fa-user-check mb-2 tamañoIcono"></i>
                    <p><b>Novedades por Empleado</b></p>
                </a>
                <a href="centrodecostos.htm" class="col eIndex colorEnlace">
                    <i class="fas fa-file-invoice-dollar mb-2 mt-2 tamañoIcono"></i>
                    <p><b>Centro de Costos</b></p>
                </a>
            </div>
            <!--Segunda Fila-->
            <div class="row text-center">
                <a href="empleados.htm" class="col dIndex colorEnlace">
                    <i class="fas fa-user-clock mb-2 mt-2 tamañoIcono"></i>
                    <p><b>Empleados</b></p>
                </a>
                <a href="cargoempleado.htm" class="col dIndex colorEnlace">
                    <i class="fas fa-briefcase mb-2 mt-2 tamañoIcono"></i>
                    <p><b>Cargo Empleado</b></p>
                </a>
                <a href="modulos.htm" class="col cIndex colorEnlace">
                    <i class="fas fa-th mb-2 mt-2 tamañoIcono"></i>
                    <p><b>Modulos</b></p>
                </a>
                <a href="modulosperfil.htm" class="col-2 cIndex colorEnlace">
                    <i class="fas fa-th-list mb-2 tamañoIcono"></i>
                    <p><b>Modulos por Perfil</b></p>
                </a>
                <a href="grupos.htm" class="col fIndex colorEnlace">
                    <i class="fas fa-users mb-2 mt-2 tamañoIcono"></i>
                    <p><b>Grupos</b></p>
                </a>
                <a href="empleadosgrupo.htm" class="col fIndex colorEnlace">
                    <i class="fas fa-users-cog mb-2 tamañoIcono"></i>
                    <p><b>Empleados por Grupo</b></p>
                </a>
            </div>
            <!--Tercera fila-->
            <div class="row text-center">
                <a href="responsablegrupo.htm" class="col-2 fIndex colorEnlace">
                    <i class="fas fa-user-tie mb-2  tamañoIcono"></i>
                    <p><b>Responsable por Grupo</b></p>
                </a>
                <a href="configuracion.htm" class="col-2 gIndex colorEnlace">
                    <i class="fas fa-cog mb-2  tamañoIcono"></i>
                    <p><b>Configuracion</b></p>
                </a>
                <a href="estadisticas.htm" class="col-2 gIndex colorEnlace">
                    <i class="fas fa-chart-bar mb-2  tamañoIcono"></i>
                    <p><b>Estadisticas</b></p>
                </a>

                <div class="col-6">

                </div>
            </div>
        </div>
    </body>   
</html>
