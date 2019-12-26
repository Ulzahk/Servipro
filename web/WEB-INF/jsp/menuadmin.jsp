<%-- 
    Document   : menuadmin
    Created on : 23/12/2019, 3:10:19 p. m.
    Author     : PRACTICANTE
--%>

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

<div class="menu_bar">
    <a href="#" class="bt-menu">Menú</a>
</div>

<nav class="Menu">

    <ul>
        <li>
            <a class='navbar-brand' href='index.htm'>ServiSoft S.A.</a>
        </li>
        <li class="submenu">
            <a href="controlusuarios?btnUsuConsultar=true">Control de usuarios</a>

        </li>
        <li class="submenu">
            <a href="perfil.htm">Tabla de perfil</a>

        </li>
        <li class="submenu">
            <a href="#">Modulos <i class="fas fa-caret-down"></i></a>
            <ul class="children">
                <li><a href="modulos.htm">Tabla modulos<span class="icon-dot"></span></a></li>
                <li><a href="controlmodulosperfil?btnModPerfilConsultar=true">Modulos perfil<span class="icon-dot"></span></a></li>
            </ul>
        </li>

        <li class='nav-item dropdown'>
            <a class='nav-link dropdown-toggle btn btn-dark' href='#' id='navbardrop' data-toggle='dropdown'>
                Usuario: <%out.println(id_usuario);%>
            </a>
            <div style='color: black;' class='dropdown-menu text-center'>
                <a style='color: black;' class='dropdown-item' href='nomina.htm'>
                    Perfil: <%out.println(Descripcion_perfil);%>
                </a>
                <form action='cerrar' method='post' id='formcerrar'>
                    <input type='submit' value='Cerrar Sesión' class='btn btn-link text-center' style='color: black;'/>
                </form>
            </div>
        </li>
    </ul>
</nav>