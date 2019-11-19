
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
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
        <title>Configuracion</title>
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
            <h1 class="text-center">Configuración</h1>
            <br>
            <div class="card border-info">
                <div class="card-header bg-info text-white">
                    <a href="nomina.htm" class="btn btn-secondary"><i class="fas fa-arrow-left"></i></a>
                    <a href="agregarconfiguracion.htm" class="btn btn-secondary">Agregar Registro</a>
                    <form action="" method="post">
                    <div class="input-group mt-3">
                        <input type="text" class="form-control" name="Buscar" placeholder="Buscar en Servisoft S.A."/>
                        <div class="input-group-append">
                            <button type="submit" Value="Buscar" class="btn btn-secondary"><i class="fas fa-search"></i> Buscar</button> 
                        </div>
                    </div>
                    </form>
                </div>
                <div class="card-body">
                    <table border="1" class="table table-bordered table-striped table-hover text-center">
                        <thead>
                            <tr>
                                <th class="align-middle">Desconfiguracion</th>
                                <th class="align-middle">Desconfiguracion D.</th>
                                <th class="align-middle">Variable</th>
                                <th class="align-middle">Valor</th>
                                <th class="align-middle">Modulo</th>
                                <th class="align-middle">Acciones</th>
                            </tr>
                        </thead>
                        <%
                            String control=request.getParameter("Buscar");
                            try
                            {
                                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                                Connection conn=DriverManager.getConnection("jdbc:sqlserver://10.0.0.98:1433;databaseName=sssacontable","contable19","contable19");
                                String Query="SELECT * FROM nm_configuracion Join nm_modulos "
                                        + " ON nm_configuracion.Id_modulo = nm_modulos.Id_modulo where "
                                        + " Id_configuracion like '%"+request.getParameter("Buscar")+"%' or "
                                        + " Desconfiguracion like '%"+request.getParameter("Buscar")+"%' or "
                                        + " Desconfiguracion_d like '%"+request.getParameter("Buscar")+"%' or "
                                        + " Nombre_variable like '%"+request.getParameter("Buscar")+"%' or "
                                        + " Valor like '%"+request.getParameter("Buscar")+"%' or "
                                        + " Nombre_modulo like '%"+request.getParameter("Buscar")+"%'";
                                Statement stm=conn.createStatement();
                                ResultSet rs=stm.executeQuery(Query);
                                
                                if(control!=null)
                                {
                                    while(rs.next())
                                    {
                                        %>
                                        <tbody>
                                            <tr>
                                                <td class="align-middle"><%=rs.getString("Desconfiguracion")%></td>
                                                <td class="align-middle"><%=rs.getString("Desconfiguracion_d")%></td>
                                                <td class="align-middle"><%=rs.getString("Nombre_variable")%></td>
                                                <td class="align-middle"><%=rs.getString("Valor")%></td>
                                                <td class="align-middle"><%=rs.getString("Nombre_modulo")%></td>
                                                <c:forEach var="dato" items="${datos}"  begin="<%=rs.getInt("Id_configuracion")-1%>" end="<%=rs.getInt("Id_configuracion")-1%>">
                                                <td class="align-middle">
                                                    <a href="<c:url value="editarconfiguracion.htm?id_configuracion=${dato.Id_configuracion}"/>" class="btn btn-warning"><i class="fas fa-edit"></i></a>
                                                <a href="<c:url value="eliminarconfiguracion.htm?id_configuracion=${dato.Id_configuracion}"/>" class="btn btn-danger"><i class="fas fa-trash-alt"></i></a>
                                                </td>
                                                </c:forEach>
                                            </tr>
                                        </tbody>  
                                        <%
                                    }
                                }else{
                                    %>
                                    <tbody>
                                        <c:forEach var="dato" items="${datos}">
                                        <tr>
                                            <td class="align-middle"><c:out value="${dato.Desconfiguracion}"/></td>
                                            <td class="align-middle"><c:out value="${dato.Desconfiguracion_d}"/></td>
                                            <td class="align-middle"><c:out value="${dato.Nombre_variable}"/></td>
                                            <td class="align-middle"><c:out value="${dato.Valor}"/></td>
                                            <td class="align-middle"><c:out value="${dato.Modulo}"/></td>
                                            <td class="align-middle">
                                                <a href="<c:url value="editarconfiguracion.htm?id_configuracion=${dato.Id_configuracion}"/>" class="btn btn-warning"><i class="fas fa-edit"></i></a>
                                                <a href="<c:url value="eliminarconfiguracion.htm?id_configuracion=${dato.Id_configuracion}"/>" class="btn btn-danger"><i class="fas fa-trash-alt"></i></a>
                                            </td>
                                        </tr>
                                        </c:forEach>
                                    </tbody>  
                                    <%
                                }
                            }
                            catch(Exception ex)
                            {
                                ex.printStackTrace();
                                out.println("Error "+ex.getMessage());
                            }
                        
                        %>   
                    </table>   
                </div>
            </div>
        </div>
    </body>
</html>
