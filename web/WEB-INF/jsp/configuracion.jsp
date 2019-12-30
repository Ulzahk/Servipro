
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%
    HttpSession objsesion = request.getSession(false);
    String id_usuario = (String) objsesion.getAttribute("id_usuario");
    String Descripcion_perfil = (String) objsesion.getAttribute("descripcion_perfil");
    if (id_usuario == null) {
        response.sendRedirect("login.jsp");
    } else {
        if (Descripcion_perfil.equals("COORDINADOR")
                || Descripcion_perfil.equals("JEFE")) {

        } else {
            response.sendRedirect("nomina.htm");
        }
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Configuración</title>
        <link rel="stylesheet" href="<c:url value="/Resources/CSS/style.css"/>"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script src="Resources/JS/functions.js"></script>
    </head>
    <body>

        <header>
            <%--Barra de Navegación de Jefe--%>
            <%
                if (Descripcion_perfil.equals("JEFE")) {

            %>       

            <jsp:include page="menujefe.jsp"></jsp:include>

            <%        }
            %>


            <%--Barra de Navegación de Coordinador--%>
            <%
                if (Descripcion_perfil.equals("COORDINADOR")) {
            %>

            <jsp:include page="menucordi.jsp"></jsp:include>

            <%
                }
            %> 
        </header>

        <div class="container mt-4">
            <h1 class="text-center">Configuración</h1>
            <br>
            <div class="card border-info">
                <div class="card-header bg-info text-white">
                    <form action="" method="post">
                        <div class="input-group">
                            <a href="nomina.htm" class="btn btn-secondary mr-1"data-toggle="tooltip" title="Haz clic para regresar al menú nómina"><i class="fas fa-arrow-left"></i></a>
                            <a href="agregarconfiguracion.htm" class="btn btn-secondary mr-1"data-toggle="tooltip" title="Haz clic para agregar un nuevo registro">Agregar Registro</a>
                            <input type="text" class="form-control" name="Buscar" placeholder="Buscar en Servisoft S.A."/>
                            <div class="input-group-append">
                                <button type="submit" Value="Buscar" class="btn btn-secondary"data-toggle="tooltip" title="Haz clic para buscar"><i class="fas fa-search"></i></button> 
                            </div>
                        </div>
                    </form>
                </div>
                <div class="card-body">
                    <table border="1" class="table table-bordered table-striped table-hover text-center table-responsive-lg">
                        <thead>
                            <tr>
                                <th class="align-middle">Desconfiguración</th>
                                <th class="align-middle">Desconfiguración D.</th>
                                <th class="align-middle">Variable</th>
                                <th class="align-middle">Valor</th>
                                <th class="align-middle">Módulo</th>
                                <th class="align-middle">Acciones</th>
                            </tr>
                        </thead>
                        <%
                            String control = request.getParameter("Buscar");
                            try {
                                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                                Connection conn = DriverManager.getConnection("jdbc:sqlserver://10.0.0.98:1433;databaseName=sssacontable", "contable19", "contable19");
                                String Query = "SELECT * FROM nm_configuracion Join nm_modulos "
                                        + " ON nm_configuracion.Id_modulo = nm_modulos.Id_modulo where "
                                        + " Id_configuracion like '%" + request.getParameter("Buscar") + "%' or "
                                        + " Desconfiguracion like '%" + request.getParameter("Buscar") + "%' or "
                                        + " Desconfiguracion_d like '%" + request.getParameter("Buscar") + "%' or "
                                        + " Nombre_variable like '%" + request.getParameter("Buscar") + "%' or "
                                        + " Valor like '%" + request.getParameter("Buscar") + "%' or "
                                        + " Nombre_modulo like '%" + request.getParameter("Buscar") + "%'";
                                Statement stm = conn.createStatement();
                                ResultSet rs = stm.executeQuery(Query);

                                if (control != null) {
                                    while (rs.next()) {
                        %>
                        <tbody>
                            <tr>
                                <td class="align-middle"><%=rs.getString("Desconfiguracion")%></td>
                                <td class="align-middle"><%=rs.getString("Desconfiguracion_d")%></td>
                                <td class="align-middle"><%=rs.getString("Nombre_variable")%></td>
                                <td class="align-middle"><%=rs.getString("Valor")%></td>
                                <td class="align-middle"><%=rs.getString("Nombre_modulo")%></td>
                                <c:forEach var="dato" items="${datos}"  begin="<%=rs.getInt("Id_configuracion") - 1%>" end="<%=rs.getInt("Id_configuracion") - 1%>">
                                    <td class="align-middle">
                                        <a href="<c:url value="editarconfiguracion.htm?id_configuracion=${dato.Id_configuracion}"/>" class="btn btn-warning"><i class="fas fa-edit"></i></a>
                                        <a href="<c:url value="eliminarconfiguracion.htm?id_configuracion=${dato.Id_configuracion}"/>" class="btn btn-danger"><i class="fas fa-trash-alt"></i></a>
                                    </td>
                                </c:forEach>
                            </tr>
                        </tbody>  
                        <%
                            }
                        } else {
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
                                        <div class="btn-group">
                                            <a href="<c:url value="editarconfiguracion.htm?id_configuracion=${dato.Id_configuracion}"/>" class="btn btn-warning rounded mr-1 ml-4 openBtn" data-toggle="modal" data-target="#myModal"data-toggle="tooltip" title="Haz clic para editar configuración"><i class="fas fa-edit"></i></a>
                                            <a href="<c:url value="eliminarconfiguracion.htm?id_configuracion=${dato.Id_configuracion}"/>" class="btn btn-danger rounded mr-4 openBtn" data-toggle="modal" data-target="#myModal"data-toggle="tooltip" title="Haz clic para eliminar"><i class="fas fa-trash-alt"></i></a>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>  
                        <%
                                }
                            } catch (Exception ex) {
                                ex.printStackTrace();
                                out.println("Error " + ex.getMessage());
                            }

                        %>   
                    </table>   
                </div>
            </div>
        </div>
        <!-- Modal -->
        <div class="modal fade" id="myModal" role="dialog">
            <div class="modal-dialog modal-lg">

                <!-- Modal content-->
                <div class="modal-content">  
                    <div class="modal-body">

                    </div>
                </div>
            </div>
        </div>
    </body>
    <script type="text/javascript" language="JavaScript">
        main();
    </script>
</html>
