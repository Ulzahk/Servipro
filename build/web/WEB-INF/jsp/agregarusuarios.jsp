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
        if(Descripcion_perfil.equals("ADMINISTRADOR DE NOMINA")||
                Descripcion_perfil.equals("JEFE DE NOMINA")){
            
        }else{
          response.sendRedirect("nomina.htm");  
        }
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Agregar Usuarios</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
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
                            <a class="dropdown-item" href="grupos.htm">Tabla Grupo</a>
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
        
        
        <div class="container mt-4">
            <h1 class="text-center">Agregar Usuarios</h1>
            <br>
            <div class="card border-info">
                <div class="card-header bg-info text-white">
                    <a href="usuarios.htm" class="btn btn-secondary"><i class="fas fa-arrow-left"></i></a>
                </div>
                <div class="card-body">
                <form:form method="post" commandName="usuarios">
                    <form:errors path="*" element="div" cssClass="alert alert-danger"/>
                    <p>
                        <form:label path="id_usuario"><b>I.D. Usuario</b></form:label>
                        <form:input path="id_usuario" cssClass="form-control"/>
                    </p>
                    <p>
                        <form:label path="id_empleado"><b>I.D. Empleado</b></form:label>
                        <form:input path="id_empleado" cssClass="form-control"/>
                    </p>
                    <p>
                        <form:label path="contraseña"><b>Contraseña</b></form:label>
                        <form:input path="contraseña" cssClass="form-control"/>
                    </p>
                    <p>
                        <form:label path="id_perfil"><b>I.D. Perfil</b></form:label>
                        <form:input path="id_perfil" cssClass="form-control"/>
                    </p>
                    <hr/>
                    <input type="submit" value="Guardar" class="btn btn-info"/>
                </form:form>
                </div>
            </div>
        </div>
    </body>
</html>
