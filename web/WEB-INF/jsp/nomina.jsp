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

    char VistaUsuarios = 'N';
    char VistaPerfil = 'N';
    char VistaTipoNovedades = 'N';
    char VistaFacturacion = 'N';
    char VistaNovedadesEmpleado = 'N';
    char VistaCentroCostos = 'N';
    char VistaEmpleados = 'N';
    char VistaCargoEmpleado = 'N';
    char VistaModulos = 'N';
    char VistaModulosPerfil = 'N';
    char VistaGrupos = 'N';
    char VistaEmpleadosGrupo = 'N';
    char VistaResponsableGrupo = 'N';
    char VistaConfiguracion = 'N';
    char VistaEstadisticas = 'N';
    char VistaReportes = 'N';

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

        VistaUsuarios = elem.getVista_usuarios();
        VistaPerfil = elem.getVista_perfil();
        VistaTipoNovedades = elem.getVista_tiponovedades();
        VistaFacturacion = elem.getVista_facturacion();
        VistaNovedadesEmpleado = elem.getVista_novedadesempleado();
        VistaCentroCostos = elem.getVista_centrocostos();
        VistaEmpleados = elem.getVista_empleados();
        VistaCargoEmpleado = elem.getVista_cargoempleado();
        VistaModulos = elem.getVista_modulos();
        VistaModulosPerfil = elem.getVista_modulosperfil();
        VistaGrupos = elem.getVista_grupos();
        VistaEmpleadosGrupo = elem.getVista_empleadosgrupo();
        VistaResponsableGrupo = elem.getVista_responsablegrupo();
        VistaConfiguracion = elem.getVista_configuracion();
        VistaEstadisticas = elem.getVista_estadisticas();
    }

    if (id_usuario == null) {
        response.sendRedirect("logear?Login=true");
    } else {

    }
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Nómina</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link href="Resources/CSS/style.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="<c:url value="/Resources/CSS/style.css"/>"/>
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
        <link rel="stylesheet" href="https://cdn.datatables.net/buttons/1.6.1/css/buttons.dataTables.min.css">
        <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/buttons/1.6.1/js/dataTables.buttons.min.js"></script>
        <script src="https://cdn.datatables.net/buttons/1.6.1/js/buttons.flash.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
        <script src="https://cdn.datatables.net/buttons/1.6.1/js/buttons.html5.min.js"></script>
        <script src="https://cdn.datatables.net/buttons/1.6.1/js/buttons.print.min.js"></script>
        <script src="https://cdn.datatables.net/plug-ins/1.10.20/i18n/Spanish.json"></script>
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
        <script src="Resources/JS/functions.js"></script>
    </head>

    <body>

    <header>
        <%--Barra de Navegación de Jefe--%>   
        <jsp:include page="menunavegacion.jsp"></jsp:include>
        </header>

        <div class="logo container mt-3 mb-1 text-center">
            <img src="<c:url value="/Resources/Images/LogoServiSoft.png"/>"/>  
    </div>
    <br/>

    <%--Menú Nomina de Jefe--%>
    <div class='container mt-4 text-center'>
        <div class='row text-center'>
            <%
                if (VistaUsuarios == 'S') {
            %>
            <a href='controlusuarios?btnUsuConsultar=true' class='col aIndex colorEnlace'>
                <i class='fas fa-user-circle mb-2 mt-2 tamañoIcono'></i>
                <p><b>Usuarios</b></p>
            </a>
            <%
                }
                if (VistaPerfil == 'S') {
            %>
            <a href='controlperfil?btnPerfConsultar=true' class='col aIndex colorEnlace'>
                <i class='fas fa-address-card mb-2 mt-2 tamañoIcono'></i>
                <p><b>Perfil</b></p>
            </a>
            <%
                }
                if (VistaTipoNovedades == 'S') {
            %>
            <a href='tipodenovedades.htm' class='col bIndex colorEnlace'>
                <i class='fas fa-bullhorn mb-2 mt-2 tamañoIcono'></i>
                <p><b>Tipo De Novedades</b></p>
            </a>
            <%
                }
                if (VistaFacturacion == 'S') {
            %>
            <a href='facturacion.htm' class='col bIndex colorEnlace'>
                <i class='fab fa-buromobelexperte mb-2 mt-2 tamañoIcono'></i>
                <p><b>Facturación</b></p>
            </a>
            <%
                }
                if (VistaNovedadesEmpleado == 'S') {
            %>
            <a href='controlnovedadesempleado?btnNoveEmplConsultar=true' class='col bIndex colorEnlace'>
                <i class='fas fa-user-check mb-2 tamañoIcono'></i>
                <p><b>Novedades por Empleado</b></p>
            </a>
            <%
                }
                if (VistaCentroCostos == 'S') {
            %>
            <a href='centrodecostos.htm' class='col eIndex colorEnlace'>
                <i class='fas fa-file-invoice-dollar mb-2 mt-2 tamañoIcono'></i>
                <p><b>Centro de Costos</b></p>
            </a>
            <%
                }
            %>
        </div>
        <div class='row text-center'>
            <%
                if (VistaEmpleados == 'S') {
            %>
            <a href='empleados?btnEmplConsultar=true' class='col dIndex colorEnlace'>
                <i class='fas fa-user-clock mb-2 mt-2 tamañoIcono'></i>
                <p><b>Empleados</b></p>
            </a>
            <%
                }
                if (VistaCargoEmpleado == 'S') {
            %>
            <a href='cargoempleado.htm' class='col dIndex colorEnlace'>
                <i class='fas fa-briefcase mb-2 mt-2 tamañoIcono'></i>
                <p><b>Cargo Empleado</b></p>
            </a>
            <%
                }
                if (VistaModulos == 'S') {
            %>
            <a href='modulos.htm' class='col cIndex colorEnlace'>
                <i class='fas fa-th mb-2 mt-2 tamañoIcono'></i>
                <p><b>Módulos</b></p>
            </a>
            <%
                }
                if (VistaModulosPerfil == 'S') {
            %>
            <a href='controlmodulosperfil?btnModPerfilConsultar=true' class='col cIndex colorEnlace'>
                <i class='fas fa-th-list mb-2 tamañoIcono'></i>
                <p><b>Módulos por Perfil</b></p>
            </a>
            <%
                }
                if (VistaGrupos == 'S') {
            %>
            <a href='grupos.htm' class='col fIndex colorEnlace'>
                <i class='fas fa-users mb-2 mt-2 tamañoIcono'></i>
                <p><b>Grupos</b></p>
            </a>
            <%
                }
                if (VistaEmpleadosGrupo == 'S') {
            %>
            <a href='controlempleadosgrupo?btnEmplGruConsultar=true' class='col fIndex colorEnlace'>
                <i class='fas fa-users-cog mb-2 tamañoIcono'></i>
                <p><b>Empleados por Grupo</b></p>
            </a>
            <%
                }
            %>
        </div>
        <div class='row text-center'>
            <%
                if (VistaResponsableGrupo == 'S') {
            %>
            <a href='controlresponsablegrupo?btnReGruConsultar=true' class='col fIndex colorEnlace'>
                <i class='fas fa-user-tie mb-2 mt-2 tamañoIcono'></i>
                <p><b>Responsable por Grupo</b></p>
            </a>
            <%
                }
                if (VistaConfiguracion == 'S') {
            %>
            <a href='configuracion.htm' class='col gIndex colorEnlace'>
                <i class='fas fa-cog mb-2  tamañoIcono'></i>
                <p><b>Configuración</b></p>
            </a>
            <%
                }
                if (VistaEstadisticas == 'S') {
            %>
            <a href='estadisticas?btnConsultarEstaMensualidad=true' class='col gIndex colorEnlace'>
                <i class='fas fa-history mb-2  tamañoIcono'></i>
                <p><b>H.Reportes</b></p>
            </a>
            <a href='controlreportes?btnConsultarEstaMensualidad=true' class='col gIndex colorEnlace'>
                <i class='fas fa-chart-bar mb-2  tamañoIcono'></i>
                <p><b>Reportes</b></p>
            </a>
            <%
                }
            %>
        </div>
    </div>
</body>  
<script type="text/javascript" language="JavaScript">
    main();
</script>
</html>
