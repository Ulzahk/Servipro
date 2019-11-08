<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<%
    HttpSession objsesion = request.getSession(false);
    String id_usuario = (String)objsesion.getAttribute("id_usuario");

    
    if(id_usuario==null){
        response.sendRedirect("login.jsp");
    }
%>--%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset= "UTF-8" />
        <title>Estadisticas</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script src="<c:url value="/Resources/JS/functions.js"/>"></script>
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
                            <%--Usuario: <% out.println(id_usuario); %>--%>
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
                        
        <div class="container mt-4">
            <h1 class="text-center">Estadisticas</h1>
            <br>
            <div class="card border-info">
                <div class="card-header bg-info text-white">
                    <form class="form-inline" action="" method="post">
                        <div class="form-group">
                            <select class="form-control" id="sel1">
                                <option>Quincenal</option>
                                <option>Mensual</option> 
                            </select>
                        </div>
                    <button class="btn btn-success" type="submit">Buscar</button>
                    </form>
                </div>
                <div class="card-body">
                    <table border="1" class="table table-bordered table-striped table-hover text-center">
                        <thead>
                            <tr>
                                <th class="align-middle"></th>
                                <th colspan="15" class="align-middle">Quincena</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                               <th class="align-middle">Empleado</th>
                               <th class="align-middle">1</th>
                               <th class="align-middle">2</th>
                               <th class="align-middle">3</th>
                               <th class="align-middle">4</th>
                               <th class="align-middle">5</th>
                               <th class="align-middle">6</th>
                               <th class="align-middle">7</th>
                               <th class="align-middle">8</th>
                               <th class="align-middle">9</th>
                               <th class="align-middle">10</th>
                               <th class="align-middle">11</th>
                               <th class="align-middle">12</th>
                               <th class="align-middle">13</th>
                               <th class="align-middle">14</th>
                               <th class="align-middle">15</th>
                            </tr> 
                            <c:forEach var="dato" items="${datos}">
                            <tr>
                                <td class="align-middle"><c:out value="${dato.Nombre}"/></td>
                                <td class="align-middle">L.A.</td>
                                <td class="align-middle">L.A.</td>
                                <td class="align-middle">L.A.</td>
                                <td class="align-middle">L.A.</td>
                                <td class="align-middle">L.A.</td>
                                <td class="align-middle">L.A.</td>
                                <td class="align-middle">L.A.</td>
                                <td class="align-middle">L.A.</td>
                                <td class="align-middle">L.A.</td>
                                <td class="align-middle">L.A.</td>
                                <td class="align-middle">L.A.</td>
                                <td class="align-middle">L.A.</td>
                                <td class="align-middle">L.A.</td>
                                <td class="align-middle">L.A.</td>
                                <td class="align-middle">L.A.</td>
                            </tr>
                            </c:forEach>
                        </tbody>    
                    </table>   
                </div>
            </div>
        </div>
    </body>
</html>
