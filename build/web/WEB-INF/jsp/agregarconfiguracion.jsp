<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="BL.clsConexion"%>
<%
    Connection conne = null;

    clsConexion obclsConexion = new clsConexion();
    conne = obclsConexion.getConexion();

    HttpSession objsesion = request.getSession(false);
    String id_usuario = (String) objsesion.getAttribute("id_usuario");

    char VistaConfiguracion = 'N';

    List<Modelos.Perfil.clsFiltroPerfil> lstclsFiltroPerfil = new ArrayList<Modelos.Perfil.clsFiltroPerfil>();
    try {
        ResultSet rs = null;
        PreparedStatement ps = conne.prepareStatement("{call spBuscarFiltroPerfil(?)}");
        ps.setString(1, id_usuario);
        rs = ps.executeQuery();

        while (rs.next()) {
            Modelos.Perfil.clsFiltroPerfil obclsFiltroPerfil = new Modelos.Perfil.clsFiltroPerfil();
            obclsFiltroPerfil.setVista_usuarios(rs.getString("Vista_usuarios").charAt(0));
            obclsFiltroPerfil.setVista_perfil(rs.getString("Vista_perfil").charAt(0));
            obclsFiltroPerfil.setVista_tiponovedades(rs.getString("Vista_tiponovedades").charAt(0));
            obclsFiltroPerfil.setVista_facturacion(rs.getString("Vista_facturacion").charAt(0));
            obclsFiltroPerfil.setVista_novedadesempleado(rs.getString("Vista_novedadesempleado").charAt(0));
            obclsFiltroPerfil.setVista_centrocostos(rs.getString("Vista_centrocostos").charAt(0));
            obclsFiltroPerfil.setVista_empleados(rs.getString("Vista_empleados").charAt(0));
            obclsFiltroPerfil.setVista_cargoempleado(rs.getString("Vista_cargoempleado").charAt(0));
            obclsFiltroPerfil.setVista_modulos(rs.getString("Vista_modulos").charAt(0));
            obclsFiltroPerfil.setVista_modulosperfil(rs.getString("Vista_modulosperfil").charAt(0));
            obclsFiltroPerfil.setVista_grupos(rs.getString("Vista_grupos").charAt(0));
            obclsFiltroPerfil.setVista_empleadosgrupo(rs.getString("Vista_empleadosgrupo").charAt(0));
            obclsFiltroPerfil.setVista_responsablegrupo(rs.getString("Vista_responsablegrupo").charAt(0));
            obclsFiltroPerfil.setVista_configuracion(rs.getString("Vista_configuracion").charAt(0));
            obclsFiltroPerfil.setVista_estadisticas(rs.getString("Vista_estadisticas").charAt(0));

            lstclsFiltroPerfil.add(obclsFiltroPerfil);
        }

    } catch (Exception ex) {

    }

    for (Modelos.Perfil.clsFiltroPerfil elem : lstclsFiltroPerfil) {

        VistaConfiguracion = elem.getVista_configuracion();

    }

    if (id_usuario == null) {
        response.sendRedirect("logear?Login=true");
    } else {
        if (VistaConfiguracion != 'S') {
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
        <title>Agregar Configuración</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link href="Resources/CSS/style.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="<c:url value="/Resources/CSS/style.css"/>"/>
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
        <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/plug-ins/1.10.20/i18n/Spanish.json"></script>
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
        <script src="Resources/JS/functions.js"></script>
    </head>
    <body>

        <header>
            <jsp:include page="menunavegacion.jsp"></jsp:include>
            </header>

            <div class="container mt-4">
                <h1 class="text-center">Agregar Configuración</h1>
                <br>
                <div class="card border-info">
                    <div class="card-header bg-info text-white">
                        <a href="configuracion.htm" class="btn btn-secondary"data-toggle="tooltip" title="Haz clic para regresar al menú configuración"><i class="fas fa-arrow-left"></i></a>
                    </div>
                    <div class="card-body">
                    <form:form method="post" commandName="configuracion">
                        <form:errors path="*" element="div" cssClass="alert alert-danger"/>
                        <p>
                            <form:label path="desconfiguracion"><b>Desconfiguración</b></form:label>
                            <form:input path="desconfiguracion" cssClass="form-control"/>
                        </p>
                        <p>
                            <form:label path="desconfiguracion_d"><b>Desconfiguración D.</b></form:label>
                            <form:input path="desconfiguracion_d" cssClass="form-control"/>
                        </p>
                        <p>
                            <form:label path="nombre_variable"><b>Nombre Variable</b></form:label>
                            <form:input path="nombre_variable" cssClass="form-control"/>
                        </p>
                        <p>
                            <form:label path="valor"><b>Valor</b></form:label>
                            <form:input path="valor" cssClass="form-control"/>
                        </p>
                        <p>
                            <label id="id_modulo"><b>Módulo</b></label>
                            <select id="id_modulo" name="id_modulo" class="form-control">
                                <option value="-1">SELECCIONE UN MÓDULO</option>
                                <%
                                    try {
                                        String Query = "select * from nm_modulos";
                                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                                        Connection conn = DriverManager.getConnection("jdbc:sqlserver://10.0.0.98:1433;databaseName=sssacontable", "contable19", "contable19");
                                        Statement stm = conn.createStatement();
                                        ResultSet rs = stm.executeQuery(Query);
                                        while (rs.next()) {
                                %>
                                <option value="<%=rs.getInt("Id_modulo")%>"><%=rs.getString("Nombre_modulo")%></option>
                                <%

                                        }
                                    } catch (Exception ex) {
                                        ex.printStackTrace();
                                        out.println("Error " + ex.getMessage());
                                    }
                                %>    
                            </select>
                        </p>
                        <hr/>
                        <input type="submit" value="Guardar" class="btn btn-info"/>
                    </form:form>
                </div>
            </div>
        </div>
    </body>
    <script type="text/javascript" language="JavaScript">
        main();
    </script>
</html>