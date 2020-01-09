<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="BL.clsConexion"%>
<%
    Connection conn = null;

    clsConexion obclsConexion = new clsConexion();
    conn = obclsConexion.getConexion();

    HttpSession objsesion = request.getSession(false);
    String id_usuario = (String) objsesion.getAttribute("id_usuario");

    char VistaModulosPerfil = 'N';

    List<Modelos.Perfil.clsFiltroPerfil> lstclsFiltroPerfil = new ArrayList<Modelos.Perfil.clsFiltroPerfil>();
    try {
        ResultSet rs = null;
        PreparedStatement ps = conn.prepareStatement("{call spBuscarFiltroPerfil(?)}");
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

        VistaModulosPerfil = elem.getVista_modulosperfil();
    }

    if (id_usuario == null) {
        response.sendRedirect("login.jsp");
    } else {
        if (VistaModulosPerfil != 'S') {
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
        <title>Agregar Módulos por Perfil</title>
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
        <%
            Modelos.ModulosPerfil.clsModulosPerfil obclsModulosPerfil = new Modelos.ModulosPerfil.clsModulosPerfil();

            if (request.getAttribute("obclsModulosPerfil") != null) {
                obclsModulosPerfil = (Modelos.ModulosPerfil.clsModulosPerfil) request.getAttribute("obclsModulosPerfil");
            }

            List<Modelos.ModulosPerfil.clsModulosPerfil> lstclsModulosPerfil = new ArrayList<Modelos.ModulosPerfil.clsModulosPerfil>();

            if (request.getAttribute("lstclsModulosPerfil") != null) {

                lstclsModulosPerfil = (List<Modelos.ModulosPerfil.clsModulosPerfil>) request.getAttribute("lstclsModulosPerfil");
            }

            if (request.getAttribute("stMensaje") != null && request.getAttribute("stTipo") != null) {


        %>
        <input type="text" hidden="" id="txtMensaje" value="<%=request.getAttribute("stMensaje")%>"/>
        <input type="text" hidden="" id="txtTipo" value="<%=request.getAttribute("stTipo")%>"/>
        <script>
            var mensaje = document.getElementById("txtMensaje").value;
            var tipo = document.getElementById("txtTipo").value;

            swal.fire("Mensaje", mensaje, tipo);
        </script>
        <%
            }
        %>
        <header>
            <jsp:include page="../WEB-INF/jsp/menunavegacion.jsp"></jsp:include>
            </header>
            <div class="container mt-4">
                <h1 class="text-center">Agregar Módulos por Perfil</h1>
                <br>
                <div class="card border-info">
                    <div class="card-header bg-info text-white">
                        <a href="controlmodulosperfil?btnModPerfilConsultar=true" class="btn btn-secondary"data-toggle="tooltip" title="Haz clic para regresar al menú módulos por perfil"><i class="fas fa-arrow-left"></i></a>
                    </div>
                    <div class="card-body">
                        <form action="controlmodulosperfil" method="POST">
                            <!--FILA-->
                            <div class="form-group">
                                <div class="row">
                                    <div class="col-6">
                                        <label for="lblmodulos"><b>Módulos</b></label>
                                        <select class="form-control" name="ddlModulo">
                                        <%
                                            List<Modelos.ModulosPerfil.clsModulo> lstclsModulos = new ArrayList<Modelos.ModulosPerfil.clsModulo>();

                                            if (request.getAttribute("lstclsModulos") != null) {
                                                lstclsModulos = (List<Modelos.ModulosPerfil.clsModulo>) request.getAttribute("lstclsModulos");
                                            }

                                            for (Modelos.ModulosPerfil.clsModulo elem : lstclsModulos) {
                                        %>
                                        <option value="<%=elem.getId_modulo()%>"
                                                <%=obclsModulosPerfil.getObclsModulo() != null ? obclsModulosPerfil.getObclsModulo().getId_modulo() == elem.getId_modulo() ? "selected" : "" : ""%>>
                                            <%=elem.getStNombre_modulo()%>
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                                <div class="col-6">
                                    <label for="lblPerfil"><b>Perfil</b></label>
                                    <select class="form-control" name="ddlPerfil">
                                        <%
                                            List<Modelos.ModulosPerfil.clsPerfil> lstclsPerfil = new ArrayList<Modelos.ModulosPerfil.clsPerfil>();
                                            if (request.getAttribute("lstclsPerfil") != null) {
                                                lstclsPerfil = (List<Modelos.ModulosPerfil.clsPerfil>) request.getAttribute("lstclsPerfil");
                                            }
                                            for (Modelos.ModulosPerfil.clsPerfil elem : lstclsPerfil) {
                                        %>
                                        <option value="<%=elem.getId_perfil()%>"
                                                <%=obclsModulosPerfil.getObclsPerfil() != null ? obclsModulosPerfil.getObclsPerfil().getId_perfil() == elem.getId_perfil() ? "selected" : "" : ""%>>
                                            <%=elem.getStDescripcion_perfil()%>
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-12">
                                    <input type="submit" value="Guardar" class="btn btn-info" name="btnModPerfilGuardar"/>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>  
    </body>
    <script type="text/javascript" language="JavaScript">
        main();
    </script>
</html>







