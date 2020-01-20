<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

    char VistaConfiguracion = 'N';

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
    <body class="background-body">
        <%
            Modelos.Configuracion.clsConfiguracion obclsConfiguracion = new Modelos.Configuracion.clsConfiguracion();

            if (request.getAttribute("obclsConfiguracion") != null) {
                obclsConfiguracion = (Modelos.Configuracion.clsConfiguracion) request.getAttribute("obclsConfiguracion");
            }

            List<Modelos.Configuracion.clsConfiguracion> lstclsConfiguracion = new ArrayList<Modelos.Configuracion.clsConfiguracion>();

            if (request.getAttribute("lstclsConfiguracion") != null) {

                lstclsConfiguracion = (List<Modelos.Configuracion.clsConfiguracion>) request.getAttribute("lstclsConfiguracion");
            }

            if (request.getAttribute("stMensaje") != null && request.getAttribute("stTipo") != null) {


        %>
        <input type="txt" hidden="" id="txtMensaje" value="<%=request.getAttribute("stMensaje")%>"/>
        <input type="txt" hidden="" id="txtTipo" value="<%=request.getAttribute("stTipo")%>"/>
        <script>
            var mensaje = document.getElementById("txtMensaje").value;
            var tipo = document.getElementById("txtTipo").value;
            swal("Mensaje", mensaje, tipo);
        </script>
        <%
            }
        %>
        <header>
            <jsp:include page="../WEB-INF/jsp/menunavegacion.jsp"></jsp:include>
            </header>
            <div class="container mt-4">
                <h1 class="text-center">Agregar Configuración</h1>
                <br>
                <div class="card border-dark">
                    <div class="card-header border-dark background-card text-white">
                        <a href="controlconfiguracion?btnConfConsultar=true" class="btn btn-secondary"data-toggle="tooltip" title="Haz clic para regresar al menú empleados"><i class="fas fa-arrow-left"></i></a>
                    </div>
                    <div class="card-body">
                        <form action="controlconfiguracion" method="POST">
                            <!--FILA-->
                            <div class="form-group">
                                <div class="row">
                                    <div class="col-6">
                                        <label for="lblNombreConfiguracion"><b>Nombre Configuración</b></label>
                                        <input type="text" class="form-control" name="txtNombreConfiguracion"
                                               value="<%=obclsConfiguracion.getNombre_configuracion() != null ? obclsConfiguracion.getNombre_configuracion() : ""%>"/>
                                </div>
                                <div class="col-6">
                                    <label for="lblDescripcionConfiguracion"><b>Descripción Configuración</b></label>
                                    <input type="text" class="form-control" name="txtDescripcionConfiguracion"
                                           value="<%=obclsConfiguracion.getDescripcion_configuracion() != null ? obclsConfiguracion.getDescripcion_configuracion() : ""%>"/>
                                </div>
                            </div>
                        </div>
                        <!--FILA-->
                        <div class="form-group">
                            <div class="row">
                                <div class="col-6">
                                    <label for="lblNombreVariable"><b>Variable</b></label>
                                    <input type="text" class="form-control" name="txtNombreVariable"
                                           value="<%=obclsConfiguracion.getNombre_variable() != null ? obclsConfiguracion.getNombre_variable() : ""%>"/>
                                </div>
                                <div class="col-6">
                                    <label for="lblValor"><b>Valor</b></label>
                                    <input type="number" class="form-control" name="txtValor"
                                           value="<%=obclsConfiguracion.getValor() != 0 ? obclsConfiguracion.getValor() : ""%>"/>
                                </div> 
                            </div>
                        </div>
                        <!--FILA-->
                        <div class="form-group">
                            <div class="row">
                                <div class="col-12">
                                    <label for="lblModulo"><b>Módulo</b></label>
                                    <select class="form-control" name="ddlModulo">
                                        <%
                                            List<Modelos.Configuracion.clsModulo> lstclsModulo = new ArrayList<Modelos.Configuracion.clsModulo>();

                                            if (request.getAttribute("lstclsModulo") != null) {
                                                lstclsModulo = (List<Modelos.Configuracion.clsModulo>) request.getAttribute("lstclsModulo");
                                            }

                                            for (Modelos.Configuracion.clsModulo elem : lstclsModulo) {
                                        %>
                                        <option value="<%=elem.getId_modulo()%>"
                                                <%=obclsConfiguracion.getObclsModulo() != null ? obclsConfiguracion.getObclsModulo().getId_modulo() == elem.getId_modulo() ? "selected" : "" : ""%>>
                                            <%=elem.getNombre_modulo()%>
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                            </div>
                        </div>         
                        <!--FILA-->   
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-12">
                                    <input type="submit" value="Guardar" class="btn background-button" data-toggle="tooltip" title="Haz clic para guardar" name="btnConfigGuardar"/>
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
