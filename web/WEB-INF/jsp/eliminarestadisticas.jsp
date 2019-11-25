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
        <meta charset="UTF-8">
        <title>Eliminar Novedades del Empleado</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
        <script src="https://kit.fontawesome.com/a076d05399.js"></script> 
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </head>
    <body>
        
        <%--Barra de Navegación de Jefe--%>
        <%
            if(Descripcion_perfil.equals("JEFE")){

                out.println("<nav class='navbar navbar-expand-sm bg-info navbar-dark justify-content-center'>");
                    out.println("<a class='navbar-brand' href='index.htm'>ServiSoft S.A.</a>");
                    out.println("<div>");
                        out.println("<ul class='navbar-nav'>");
                            out.println("<li class='nav-item dropdown'>");
                                out.println("<a class='nav-link dropdown-toggle' href='#' id='navbardrop' data-toggle='dropdown'>");
                                    out.println("Control Usuarios");
                                out.println("</a>");
                                    out.println("<div class='dropdown-menu'>");
                                        out.println("<a class='dropdown-item' href='usuarios.htm'>Usuarios</a>");
                                        out.println("<a class='dropdown-item' href='perfil.htm'>Perfil</a>");
                                    out.println("</div>");;
                            out.println("</li>");
                            out.println("<li class='nav-item dropdown'>");
                                out.println("<a class='nav-link dropdown-toggle' href='#' id='navbardrop' data-toggle='dropdown'>");
                                    out.println("Novedades");
                                out.println("</a>");
                                out.println("<div class='dropdown-menu'>");
                                    out.println("<a class='dropdown-item' href='tipodenovedades.htm'>Tabla De Novedades</a>");
                                    out.println("<a class='dropdown-item' href='facturacion.htm'>Facturación</a>");
                                    out.println("<a class='dropdown-item' href='novedadesempleado.htm'>Novedades por Empleado</a>");
                                out.println("</div>");
                            out.println("</li>");
                            out.println("<li class='nav-item dropdown'>");
                                out.println("<a class='nav-link dropdown-toggle' href='#' id='navbardrop' data-toggle='dropdown'>");
                                    out.println("Centro de Costos");
                                out.println("</a>");
                                out.println("<div class='dropdown-menu'>");
                                    out.println("<a class='dropdown-item' href='centrodecostos.htm'>Tabla Centro de Costos</a>");
                                out.println("</div>");
                            out.println("</li>");
                            out.println("<li class='nav-item dropdown'>");
                                out.println("<a class='nav-link dropdown-toggle' href='#' id='navbardrop' data-toggle='dropdown'>");
                                    out.println("Empleados");
                                out.println("</a>");
                                out.println("<div class='dropdown-menu'>");
                                    out.println("<a class='dropdown-item' href='empleados.htm'>Tabla Empleados</a>");
                                    out.println("<a class='dropdown-item' href='cargoempleado.htm'>Cargo Empleado</a>");
                                out.println("</div>");
                            out.println("</li>");
                            out.println("<li class='nav-item dropdown'>");
                                out.println("<a class='nav-link dropdown-toggle' href='#' id='navbardrop' data-toggle='dropdown'>");
                                    out.println("Modulos");
                                out.println("</a>");
                                out.println("<div class='dropdown-menu'>");
                                    out.println("<a class='dropdown-item' href='modulos.htm'>Tabla Modulos</a>");
                                    out.println("<a class='dropdown-item' href='modulosperfil.htm'>Modulos por Perfil</a>");
                                out.println("</div>");
                            out.println("</li>");
                            out.println("<li class='nav-item dropdown'>");
                                out.println("<a class='nav-link dropdown-toggle' href='#' id='navbardrop' data-toggle='dropdown'>");
                                    out.println("Grupos");
                                out.println("</a>");
                                out.println("<div class='dropdown-menu'>");
                                    out.println("<a class='dropdown-item' href='grupos.htm'>Tabla Grupos</a>");
                                    out.println("<a class='dropdown-item' href='empleadosgrupo.htm'>Empleados por Grupo</a>");
                                    out.println("<a class='dropdown-item' href='responsablegrupo.htm'>Responsable del Grupo</a>");
                                out.println("</div>");
                            out.println("</li>");
                            out.println("<li class='nav-item dropdown'>");
                                out.println("<a class='nav-link dropdown-toggle' href='#' id='navbardrop' data-toggle='dropdown'>");
                                    out.println("Configuracion");
                                out.println("</a>");
                                out.println("<div class='dropdown-menu'>");
                                    out.println("<a class='dropdown-item' href='configuracion.htm'>Configuracion</a>");
                                out.println("</div>");
                            out.println("</li>");
                            out.println("<li class='nav-item dropdown'>");
                                out.println("<a class='nav-link dropdown-toggle btn btn-dark' href='#' id='navbardrop' data-toggle='dropdown'>");
                                    out.println("Usuario:"); out.println(id_usuario);
                                out.println("</a>");
                                out.println("<div class='dropdown-menu text-center'>");
                                    out.println("<a class='dropdown-item' href='nomina.htm'>");
                                        out.println("Perfil:"); out.println(Descripcion_perfil);
                                    out.println("</a>");
                                    out.println("<form action='cerrar' method='post' id='formcerrar'>");
                                            out.println("<input type='submit' value='Cerrar Sesión' "
                                                        + " class='btn btn-link text-center' style='color: #000;'/>");
                                    out.println("</form>");
                                out.println("</div>");
                            out.println("</li>");
                        out.println("</ul>");
                    out.println("</div>");
                out.println("</nav>");
            }
        %>
        
        <%--Barra de Navegación de Coordinador--%>
        <%
            if(Descripcion_perfil.equals("COORDINADOR")){

                out.println("<nav class='navbar navbar-expand-sm bg-info navbar-dark justify-content-center'>");
                    out.println("<a class='navbar-brand' href='index.htm'>ServiSoft S.A.</a>");
                    out.println("<div>");
                        out.println("<ul class='navbar-nav'>");
                            out.println("<li class='nav-item dropdown'>");
                                out.println("<a class='nav-link dropdown-toggle' href='#' id='navbardrop' data-toggle='dropdown'>");
                                    out.println("Novedades");
                                out.println("</a>");
                                out.println("<div class='dropdown-menu'>");
                                    out.println("<a class='dropdown-item' href='tipodenovedades.htm'>Tabla De Novedades</a>");
                                    out.println("<a class='dropdown-item' href='facturacion.htm'>Facturación</a>");
                                    out.println("<a class='dropdown-item' href='novedadesempleado.htm'>Novedades por Empleado</a>");
                                out.println("</div>");
                            out.println("</li>");
                            out.println("<li class='nav-item dropdown'>");
                                out.println("<a class='nav-link dropdown-toggle' href='#' id='navbardrop' data-toggle='dropdown'>");
                                    out.println("Centro de Costos");
                                out.println("</a>");
                                out.println("<div class='dropdown-menu'>");
                                    out.println("<a class='dropdown-item' href='centrodecostos.htm'>Tabla Centro de Costos</a>");
                                out.println("</div>");
                            out.println("</li>");
                            out.println("<li class='nav-item dropdown'>");
                                out.println("<a class='nav-link dropdown-toggle' href='#' id='navbardrop' data-toggle='dropdown'>");
                                    out.println("Empleados");
                                out.println("</a>");
                                out.println("<div class='dropdown-menu'>");
                                    out.println("<a class='dropdown-item' href='empleados.htm'>Tabla Empleados</a>");
                                    out.println("<a class='dropdown-item' href='cargoempleado.htm'>Cargo Empleado</a>");
                                out.println("</div>");
                            out.println("</li>");
                            out.println("<li class='nav-item dropdown'>");
                                out.println("<a class='nav-link dropdown-toggle' href='#' id='navbardrop' data-toggle='dropdown'>");
                                    out.println("Grupos");
                                out.println("</a>");
                                out.println("<div class='dropdown-menu'>");
                                    out.println("<a class='dropdown-item' href='grupos.htm'>Tabla Grupos</a>");
                                    out.println("<a class='dropdown-item' href='empleadosgrupo.htm'>Empleados por Grupo</a>");
                                    out.println("<a class='dropdown-item' href='responsablegrupo.htm'>Responsable del Grupo</a>");
                                out.println("</div>");
                            out.println("</li>");
                            out.println("<li class='nav-item dropdown'>");
                                out.println("<a class='nav-link dropdown-toggle' href='#' id='navbardrop' data-toggle='dropdown'>");
                                    out.println("Configuracion");
                                out.println("</a>");
                                out.println("<div class='dropdown-menu'>");
                                    out.println("<a class='dropdown-item' href='configuracion.htm'>Configuracion</a>");
                                out.println("</div>");
                            out.println("</li>");
                            out.println("<li class='nav-item dropdown'>");
                                out.println("<a class='nav-link dropdown-toggle btn btn-dark' href='#' id='navbardrop' data-toggle='dropdown'>");
                                    out.println("Usuario:"); out.println(id_usuario);
                                out.println("</a>");
                                out.println("<div class='dropdown-menu text-center'>");
                                    out.println("<a class='dropdown-item' href='nomina.htm'>");
                                        out.println("Perfil:"); out.println(Descripcion_perfil);
                                    out.println("</a>");
                                    out.println("<form action='cerrar' method='post' id='formcerrar'>");
                                            out.println("<input type='submit' value='Cerrar Sesión' "
                                                        + " class='btn btn-link text-center' style='color: #000;'/>");
                                    out.println("</form>");
                                out.println("</div>");
                            out.println("</li>");
                        out.println("</ul>");
                    out.println("</div>");
                out.println("</nav>");
            }
        %> 
        
        <div class="container mt-4">
            <h1 class="text-center">Eliminar Estadisticas del Empleado</h1>
            <br>
            <h3 class="text-center">¿Seguro que quiere eliminar este registro?</h3>
            <br>
            <div class="card border-info">
                <div class="card-header bg-info text-white">
                    <a href="estadisticas.htm" class="btn btn-secondary"><i class="fas fa-arrow-left"></i></a>
                </div>
                <div class="card-body">
                    <table border="1" class="table table-bordered table-striped table-hover text-center">
                        <thead>
                            <tr>
                                <th class="align-middle">Empleado</th>
                                <th colspan="10" class="align-middle">Días - Novedades</th>
                                <th class="align-middle">Acciones</th>
                            </tr>
                        </thead>
                        <c:forEach var="dato" items="${datos}" >
                        <tbody>
                            
                                <tr>
                                    <td rowspan="6" class="align-middle"><c:out value="${dato.Nombre}"/></td>
                                    <td class="align-middle">1</td>
                                    <td class="align-middle">2</td>
                                    <td class="align-middle">3</td>
                                    <td class="align-middle">4</td>
                                    <td class="align-middle">5</td>
                                    <td class="align-middle">6</td>
                                    <td class="align-middle">7</td>
                                    <td class="align-middle">8</td>
                                    <td class="align-middle">9</td>
                                    <td class="align-middle">10</td>
                                    <td rowspan="6" class="align-middle">
                                        <a href="<c:url value="confirmareliminarestadisticas.htm?id_estadistica=${dato.Id_estadistica}"/>" class="btn btn-danger"><b>Confirmar Eliminación</b></a>
                                    </td>
                                </tr>    
                                <tr>
                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#myModal"><c:out value="${dato.Alias1}"/></button></td>
                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias2}"/></button></td>
                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias3}"/></button></td>
                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias4}"/></button></td>
                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias5}"/></button></td>
                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias6}"/></button></td>
                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias7}"/></button></td>
                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias8}"/></button></td>
                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias9}"/></button></td>
                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias10}"/></button></td>
                                </tr>
                                <tr>
                                    <td class="align-middle">11</td>
                                    <td class="align-middle">12</td>
                                    <td class="align-middle">13</td>
                                    <td class="align-middle">14</td>
                                    <td class="align-middle">15</td>
                                    <td class="align-middle">16</td>
                                    <td class="align-middle">17</td>
                                    <td class="align-middle">18</td>
                                    <td class="align-middle">19</td>
                                    <td class="align-middle">20</td>
                                </tr> 
                                <tr>
                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias11}"/></button></td>
                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias12}"/></button></td>
                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias13}"/></button></td>
                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias14}"/></button></td>
                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias15}"/></button></td>
                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias16}"/></button></td>
                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias17}"/></button></td>
                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias18}"/></button></td>
                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias19}"/></button></td>
                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias20}"/></button></td>
                                </tr>
                                <tr>
                                    <td class="align-middle">21</td>
                                    <td class="align-middle">22</td>
                                    <td class="align-middle">23</td>
                                    <td class="align-middle">24</td>
                                    <td class="align-middle">25</td>
                                    <td class="align-middle">26</td>
                                    <td class="align-middle">27</td>
                                    <td class="align-middle">28</td>
                                    <td class="align-middle">29</td>
                                    <td class="align-middle">30</td>
                                </tr> 
                                <tr>
                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias21}"/></button></td>
                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias22}"/></button></td>
                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias23}"/></button></td>
                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias24}"/></button></td>
                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias25}"/></button></td>
                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias26}"/></button></td>
                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias27}"/></button></td>
                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias28}"/></button></td>
                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias29}"/></button></td>
                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias30}"/></button></td>
                                 </tr>
                         </tbody>
                         </c:forEach>
                    </table>   
                </div>
            </div>
        </div>
    </body>
</html>
