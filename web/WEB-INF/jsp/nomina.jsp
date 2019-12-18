<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession objsesion = request.getSession(false);
    String id_usuario = (String) objsesion.getAttribute("id_usuario");
    String Descripcion_perfil = (String) objsesion.getAttribute("descripcion_perfil");
    if (id_usuario == null) {
        response.sendRedirect("login.jsp");
    } else {
        if (Descripcion_perfil.equals("COORDINADOR")
                || Descripcion_perfil.equals("ADMINISTRADOR")
                || Descripcion_perfil.equals("JEFE")) {

        } else {
            response.sendRedirect("index.htm");
        }
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

        <%--Barra de Navegación de Jefe--%>
        <%
            if (Descripcion_perfil.equals("JEFE")) {

        %>       
    <nav class='navbar navbar-expand-sm bg-info navbar-dark justify-content-center'>
        <a class='navbar-brand' href='index.htm'>ServiSoft S.A.</a>
        <div>
            <ul class='navbar-nav'>
                <li class='nav-item dropdown'>
                    <a class='nav-link dropdown-toggle' href='#' id='navbardrop' data-toggle='dropdown'>
                        Control Usuarios
                    </a>
                    <div class='dropdown-menu'>
                        <a class='dropdown-item' href='usuarios.htm'>Usuarios</a>
                        <a class='dropdown-item' href='perfil.htm'>Perfil</a>
                    </div>
                </li>
                <li class='nav-item dropdown'>
                    <a class='nav-link dropdown-toggle' href='#' id='navbardrop' data-toggle='dropdown'>
                        Novedades
                    </a>
                    <div class='dropdown-menu'>
                        <a class='dropdown-item' href='tipodenovedades.htm'>Tabla De Novedades</a>
                        <a class='dropdown-item' href='facturacion.htm'>Facturación</a>
                        <a class='dropdown-item' href='novedadesempleado.htm'>Novedades por Empleado</a>
                    </div>
                </li>
                <li class='nav-item dropdown'>
                    <a class='nav-link dropdown-toggle' href='#' id='navbardrop' data-toggle='dropdown'>
                        Centro de Costos
                    </a>
                    <div class='dropdown-menu'>
                        <a class='dropdown-item' href='centrodecostos.htm'>Tabla Centro de Costos</a>
                    </div>
                </li>
                <li class='nav-item dropdown'>
                    <a class='nav-link dropdown-toggle' href='#' id='navbardrop' data-toggle='dropdown'>
                        Empleados
                    </a>
                    <div class='dropdown-menu'>
                        <a class='dropdown-item' href='empleados.htm'>Tabla Empleados</a>
                        <a class='dropdown-item' href='cargoempleado.htm'>Cargo Empleado</a>
                    </div>
                </li>
                <li class='nav-item dropdown'>
                    <a class='nav-link dropdown-toggle' href='#' id='navbardrop' data-toggle='dropdown'>
                        Modulos
                    </a>
                    <div class='dropdown-menu'>
                        <a class='dropdown-item' href='modulos.htm'>Tabla Modulos</a>
                        <a class='dropdown-item' href='modulosperfil.htm'>Modulos por Perfil</a>
                    </div>
                </li>
                <li class='nav-item dropdown'>
                    <a class='nav-link dropdown-toggle' href='#' id='navbardrop' data-toggle='dropdown'>
                        Grupos
                    </a>
                    <div class='dropdown-menu'>;
                        <a class='dropdown-item' href='grupos.htm'>Tabla Grupos</a>
                        <a class='dropdown-item' href='empleadosgrupo.htm'>Empleados por Grupo</a>
                        <a class='dropdown-item' href='responsablegrupo.htm'>Responsable del Grupo</a>
                    </div>
                </li>
                <li class='nav-item dropdown'>
                    <a class='nav-link dropdown-toggle' href='#' id='navbardrop' data-toggle='dropdown'>
                        Configuracion
                    </a>
                    <div class='dropdown-menu'>
                        <a class='dropdown-item' href='configuracion.htm'>Configuracion</a>
                    </div>
                </li>
                <li class='nav-item dropdown'>
                    <a class='nav-link dropdown-toggle btn btn-dark' href='#' id='navbardrop' data-toggle='dropdown'>
                        Usuario: <%out.println(id_usuario);%>
                    </a>
                    <div class='dropdown-menu text-center'>
                        <a class='dropdown-item' href='nomina.htm'>
                            Perfil: <%out.println(Descripcion_perfil);%>
                        </a>
                        <form action='cerrar' method='post' id='formcerrar'>
                            <input type='submit' value='Cerrar Sesión'class='btn btn-link text-center' style='color: #000;'/>
                        </form>
                    </div>
                </li>
            </ul>
        </div>
    </nav>
    <%
        }
    %>

    <%--Barra de Navegación de Administrador--%>
    <%
        if (Descripcion_perfil.equals("ADMINISTRADOR")) {
    %>

    <nav class='navbar navbar-expand-sm bg-info navbar-dark justify-content-center'>
        <a class='navbar-brand' href='index.htm'>ServiSoft S.A.</a>
        <div>
            <ul class='navbar-nav'>
                <li class='nav-item dropdown'>
                    <a class='nav-link dropdown-toggle' href='#' id='navbardrop' data-toggle='dropdown'>
                        Usuarios
                    </a>
                    <div class='dropdown-menu'>
                        <a class='dropdown-item' href='usuarios.htm'>Tabla de Usuarios</a>
                    </div>
                </li>
                <li class='nav-item dropdown'>
                    <a class='nav-link dropdown-toggle' href='#' id='navbardrop' data-toggle='dropdown'>
                        Perfil
                    </a>
                    <div class='dropdown-menu'>
                        <a class='dropdown-item' href='perfil.htm'>Tabla de Perfil</a>
                    </div>
                </li>
                <li class='nav-item dropdown'>
                    <a class='nav-link dropdown-toggle' href='#' id='navbardrop' data-toggle='dropdown'>
                        Modulos
                    </a>
                    <div class='dropdown-menu'>
                        <a class='dropdown-item' href='modulos.htm'>Tabla Modulos</a>
                    </div>
                </li>
                <li class='nav-item dropdown'>
                    <a class='nav-link dropdown-toggle' href='#' id='navbardrop' data-toggle='dropdown'>
                        Modulos por Perfil
                    </a>
                    <div class='dropdown-menu'>
                        <a class='dropdown-item' href='modulosperfil.htm'>Tabla Modulos por Perfil</a>
                    </div>
                </li>
                <li class='nav-item dropdown'>
                    <a class='nav-link dropdown-toggle btn btn-dark' href='#' id='navbardrop' data-toggle='dropdown'>
                        Usuario: <%out.println(id_usuario);%>
                    </a>
                    <div class='dropdown-menu text-center'>
                        <a class='dropdown-item' href='nomina.htm'>
                            Perfil: <%out.println(Descripcion_perfil);%>
                        </a>
                        <form action='cerrar' method='post' id='formcerrar'>
                            <input type='submit' value='Cerrar Sesión' class='btn btn-link text-center' style='color: #000;'/>
                        </form>
                    </div>
                </li>
            </ul>
        </div>
    </nav>
    <%
        }
    %> 

    <%--Barra de Navegación de Coordinador--%>
    <%
        if (Descripcion_perfil.equals("COORDINADOR")) {
    %>
    <nav class='navbar navbar-expand-sm bg-info navbar-dark justify-content-center'>
        <a class='navbar-brand' href='index.htm'>ServiSoft S.A.</a>
        <div>
            <ul class='navbar-nav'>
                <li class='nav-item dropdown'>
                    <a class='nav-link dropdown-toggle' href='#' id='navbardrop' data-toggle='dropdown'>
                        Novedades
                    </a>
                    <div class='dropdown-menu'>
                        <a class='dropdown-item' href='tipodenovedades.htm'>Tabla De Novedades</a>
                        <a class='dropdown-item' href='facturacion.htm'>Facturación</a>
                        <a class='dropdown-item' href='novedadesempleado.htm'>Novedades por Empleado</a>
                    </div>
                </li>
                <li class='nav-item dropdown'>
                    <a class='nav-link dropdown-toggle' href='#' id='navbardrop' data-toggle='dropdown'>
                        Centro de Costos
                    </a>
                    <div class='dropdown-menu'>
                        <a class='dropdown-item' href='centrodecostos.htm'>Tabla Centro de Costos</a>
                    </div>
                </li>
                <li class='nav-item dropdown'>
                    <a class='nav-link dropdown-toggle' href='#' id='navbardrop' data-toggle='dropdown'>
                        Empleados
                    </a>
                    <div class='dropdown-menu'>
                        <a class='dropdown-item' href='empleados.htm'>Tabla Empleados</a>
                        <a class='dropdown-item' href='cargoempleado.htm'>Cargo Empleado</a>
                    </div>
                </li>
                <li class='nav-item dropdown'>
                    <a class='nav-link dropdown-toggle' href='#' id='navbardrop' data-toggle='dropdown'>
                        Grupos
                    </a>
                    <div class='dropdown-menu'>
                        <a class='dropdown-item' href='grupos.htm'>Tabla Grupos</a>
                        <a class='dropdown-item' href='empleadosgrupo.htm'>Empleados por Grupo</a>
                        <a class='dropdown-item' href='responsablegrupo.htm'>Responsable del Grupo</a>
                    </div>
                </li>
                <li class='nav-item dropdown'>
                    <a class='nav-link dropdown-toggle' href='#' id='navbardrop' data-toggle='dropdown'>
                        Configuracion
                    </a>
                    <div class='dropdown-menu'>
                        <a class='dropdown-item' href='configuracion.htm'>Configuracion</a>
                    </div>
                </li>
                <li class='nav-item dropdown'>
                    <a class='nav-link dropdown-toggle btn btn-dark' href='#' id='navbardrop' data-toggle='dropdown'>
                        Usuario: <%out.println(id_usuario);%>
                    </a>
                    <div class='dropdown-menu text-center'>
                        <a class='dropdown-item' href='nomina.htm'>
                            Perfil: <%out.println(Descripcion_perfil);%>
                        </a>
                        <form action='cerrar' method='post' id='formcerrar'>
                            <input type='submit' value='Cerrar Sesión'class='btn btn-link text-center' style='color: #000;'/>
                        </form>
                    </div>
                </li>
            </ul>
        </div>
    </nav>
    <%
        }
    %> 

    <div class="container mt-3 mb-1 text-center">
        <img src="<c:url value="/Resources/Images/LogoServiSoft.png"/>"/>  
    </div>
    <br/>

    <%--Menú Nomina de Jefe--%>
    <%
        if (Descripcion_perfil.equals("JEFE")) {

    %>
    <div class='container mt-4 text-center'>
        <div class='row text-center'>
            <a href='usuarios.htm' class='col aIndex colorEnlace'>
                <i class='fas fa-user-circle mb-2 mt-2 tamañoIcono'></i>
                <p><b>Usuarios</b></p>
            </a>
            <a href='perfil.htm' class='col aIndex colorEnlace'>
                <i class='fas fa-address-card mb-2 mt-2 tamañoIcono'></i>
                <p><b>Perfil</b></p>
            </a>
            <a href='tipodenovedades.htm' class='col bIndex colorEnlace'>
                <i class='fas fa-bullhorn mb-2 mt-2 tamañoIcono'></i>
                <p><b>Tipo De Novedades</b></p>
            </a>
            <a href='facturacion.htm' class='col bIndex colorEnlace'>
                <i class='fab fa-buromobelexperte mb-2 mt-2 tamañoIcono'></i>
                <p><b>Facturación</b></p>
            </a>
            <a href='controlnovedadesempleado?btnNoveEmplConsultar=true' class='col bIndex colorEnlace'>
                <i class='fas fa-user-check mb-2 tamañoIcono'></i>
                <p><b>Novedades por Empleado</b></p>
            </a>
            <a href='centrodecostos.htm' class='col eIndex colorEnlace'>
                <i class='fas fa-file-invoice-dollar mb-2 mt-2 tamañoIcono'></i>
                <p><b>Centro de Costos</b></p>
            </a>
        </div>
        <div class='row text-center'>
            <a href='empleados?btnEmplConsultar=true' class='col dIndex colorEnlace'>
                <i class='fas fa-user-clock mb-2 mt-2 tamañoIcono'></i>
                <p><b>Empleados</b></p>
            </a>
            <a href='cargoempleado.htm' class='col dIndex colorEnlace'>
                <i class='fas fa-briefcase mb-2 mt-2 tamañoIcono'></i>
                <p><b>Cargo Empleado</b></p>
            </a>
            <a href='modulos.htm' class='col cIndex colorEnlace'>
                <i class='fas fa-th mb-2 mt-2 tamañoIcono'></i>
                <p><b>Modulos</b></p>
            </a>
            <a href='modulosperfil.htm' class='col cIndex colorEnlace'>
                <i class='fas fa-th-list mb-2 tamañoIcono'></i>
                <p><b>Modulos por Perfil</b></p>
            </a>
            <a href='grupos.htm' class='col fIndex colorEnlace'>
                <i class='fas fa-users mb-2 mt-2 tamañoIcono'></i>
                <p><b>Grupos</b></p>
            </a>
            <a href='empleadosgrupo.htm' class='col fIndex colorEnlace'>
                <i class='fas fa-users-cog mb-2 tamañoIcono'></i>
                <p><b>Empleados por Grupo</b></p>
            </a>
        </div>
        <div class='row text-center'>
            <a href='responsablegrupo.htm' class='col fIndex colorEnlace'>
                <i class='fas fa-user-tie mb-2 mt-2 tamañoIcono'></i>
                <p><b>Responsable por Grupo</b></p>
            </a>
            <a href='configuracion.htm' class='col gIndex colorEnlace'>
                <i class='fas fa-cog mb-2  tamañoIcono'></i>
                <p><b>Configuracion</b></p>
            </a>
            <a href='estadisticas?btnConsultarEstaMensualidad=true' class='col gIndex colorEnlace'>
                <i class='fas fa-chart-bar mb-2  tamañoIcono'></i>
                <p><b>Estadisticas</b></p>
            </a>
        </div>
    </div>
    <%        }
    %>

    <%--Menú Nomina de Administrador--%>
    <%
        if (Descripcion_perfil.equals("ADMINISTRADOR")) {
    %>
    <div class='container mt-4 text-center'>
        <div class='row text-center'>
            <a href='usuarios.htm' class='col aIndex colorEnlace'>
                <i class='fas fa-user-circle mb-2 mt-2 tamañoIcono'></i>
                <p><b>Usuarios</b></p>
            </a>
            <a href='perfil.htm' class='col aIndex colorEnlace'>
                <i class='fas fa-address-card mb-2 mt-2 tamañoIcono'></i>
                <p><b>Perfil</b></p>
            </a>
        </div>
        <div class='row text-center'>
            <a href='modulos.htm' class='col cIndex colorEnlace'>
                <i class='fas fa-th mb-2 mt-2 tamañoIcono'></i>
                <p><b>Modulos</b></p>
            </a>
            <a href='modulosperfil.htm' class='col cIndex colorEnlace'>
                <i class='fas fa-th-list mb-2 mt-2 tamañoIcono'></i>
                <p><b>Modulos por Perfil</b></p>
            </a>
        </div>
    <%
        }
    %>

        <%--Menú Nomina de Coordinador--%>
        <%
            if (Descripcion_perfil.equals("COORDINADOR")) {
        %>
        <div class='container mt-4 text-center'>
            <div class='row text-center'>
                <a href='tipodenovedades.htm' class='col bIndex colorEnlace'>
                    <i class='fas fa-bullhorn mb-2 mt-2 tamañoIcono'></i>
                    <p><b>Tipo De Novedades</b></p>
                </a>
                <a href='facturacion.htm' class='col bIndex colorEnlace'>
                    <i class='fab fa-buromobelexperte mb-2 mt-2 tamañoIcono'></i>
                    <p><b>Facturación</b></p>
                </a>
                <a href='controlnovedadesempleado?btnNoveEmplConsultar=true' class='col bIndex colorEnlace'>
                    <i class='fas fa-user-check mb-2 tamañoIcono'></i>
                    <p><b>Novedades por Empleado</b></p>
                </a>
                <a href='centrodecostos.htm' class='col eIndex colorEnlace'>
                    <i class='fas fa-file-invoice-dollar mb-2 mt-2 tamañoIcono'></i>
                    <p><b>Centro de Costos</b></p>
                </a>
                <a href='empleados?btnEmplConsultar=true' class='col dIndex colorEnlace'>
                    <i class='fas fa-user-clock mb-2 mt-2 tamañoIcono'></i>
                    <p><b>Empleados</b></p>
                </a>
                <a href='cargoempleado.htm' class='col dIndex colorEnlace'>
                    <i class='fas fa-briefcase mb-2 mt-2 tamañoIcono'></i>
                    <p><b>Cargo Empleado</b></p>
                </a>
            </div>
            <div class='row text-center'>
                <a href='grupos.htm' class='col-2 fIndex colorEnlace'>
                    <i class='fas fa-users mb-2 mt-2 tamañoIcono'></i>
                    <p><b>Grupos</b></p>
                </a>
                <a href='empleadosgrupo.htm' class='col-2 fIndex colorEnlace'>
                    <i class='fas fa-users-cog mb-2 tamañoIcono'></i>
                    <p><b>Empleados por Grupo</b></p>
                </a>
                <a href='responsablegrupo.htm' class='col-2 fIndex colorEnlace'>
                    <i class='fas fa-user-tie mb-2 mt-2 tamañoIcono'></i>
                    <p><b>Responsable por Grupo</b></p>
                </a>
                <a href='configuracion.htm' class='col-2 gIndex colorEnlace'>
                    <i class='fas fa-cog mb-2  tamañoIcono'></i>
                    <p><b>Configuracion</b></p>
                </a>
                <a href='estadisticas?btnConsultarEstaMensualidad=true' class='col-2 gIndex colorEnlace'>
                    <i class='fas fa-chart-bar mb-2  tamañoIcono'></i>
                    <p><b>Estadisticas</b></p>
                </a>
            </div>
        </div>
        <%
            }
        %>

    </body>   
</html>
