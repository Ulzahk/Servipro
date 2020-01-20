<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    
    for(Modelos.Perfil.clsFiltroPerfil elem: lstclsFiltroPerfil){
        
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




<div class="menu_bar">
    <a href="#" class="bt-menu">Menú</a>
</div>

<nav class="Menu">

    <ul>
        <li>
            <a class='navbar-brand' href='index.htm'>ServiSoft S.A.</a>
        </li>
        <%
            if(VistaUsuarios == 'S' || VistaPerfil == 'S'){
        %>
        <li class="submenu">
            <a href="#">Usuarios <i class="fas fa-caret-down"></i></a>
            <ul class="children">
                <%
                    if(VistaUsuarios == 'S'){ 
                %>
                <li><a href="controlusuarios?btnUsuConsultar=true">Control usuarios<span class="icon-dot"></span></a></li>
                <%
                    }
                    if(VistaPerfil == 'S'){ 
                %>
                <li><a href="controlperfil?btnPerfConsultar=true">Perfiles<span class="icon-dot"></span></a></li>
                <%
                    }
                %>
            </ul>
        </li>
        <%
            }  
            if(VistaTipoNovedades == 'S' || VistaFacturacion == 'S' || VistaNovedadesEmpleado == 'S'
                    || VistaEstadisticas == 'S' ){
        %>
        
        <li class="submenu">
            <a href="#">Novedades <i class="fas fa-caret-down"></i></a>
            <ul class="children">
                <%
                    if(VistaTipoNovedades == 'S'){
                %>
                <li><a href="tipodenovedades.htm">Tipo de novedades<span class="icon-dot"></span></a></li>
                <%
                    }
                    if(VistaFacturacion == 'S'){
                %>
                <li><a href="facturacion.htm">Facturación<span class="icon-dot"></span></a></li>
                <%
                    }
                    if(VistaNovedadesEmpleado == 'S'){
                        
                %>
                <li><a href="controlnovedadesempleado?btnNoveEmplConsultar=true">Novedades por empleado<span class="icon-dot"></span></a></li>
                <%
                    }
                    if(VistaEstadisticas == 'S'){
                %>
                <li><a href="estadisticas?btnConsultarEstaMensualidad=true">H.Reportes<span class="icon-dot"></span></a></li>
                <li><a href="controlreportes?btnConsultarEstaMensualidad=true">Reportes<span class="icon-dot"></span></a></li>
                <%
                    }
                %>
            </ul>
        </li>
        <%
            }
        %>
        <%
            if(VistaCentroCostos == 'S'){
        %>
        <li class="submenu">
            <a href="#">Centro de costos <i class="fas fa-caret-down"></i></a>
            <ul class="children">
                <li><a href="centrodecostos.htm">Tabla centro de costos<span class="icon-dot"></span></a></li>
            </ul>
        </li>
        <%
            }
            if(VistaEmpleados == 'S' || VistaCargoEmpleado == 'S' ){
        %>
        <li class="submenu">
            <a href="#">Empleados <i class="fas fa-caret-down"></i></a>
            <ul class="children">
                <%
                    if(VistaEmpleados == 'S'){
                %>
                <li><a href="empleados?btnEmplConsultar=true">Tabla empleados </a></li>
                <%
                    }
                    if(VistaCargoEmpleado == 'S'){
                %>
                <li><a href="cargoempleado.htm">Cargo empleados<span class="icon-dot"></span></a></li>
                <%
                    }
                %>
            </ul>
        </li>
        <%
            }
            if(VistaModulos == 'S' || VistaModulosPerfil == 'S'){
        %>  
        <li class="submenu">
            <a href="#">Modulos <i class="fas fa-caret-down"></i></a>
            <ul class="children">
                <%
                    if(VistaModulos == 'S'){
                %>
                <li><a href="modulos.htm">Tabla módulos<span class="icon-dot"></span></a></li>
                <%
                    }
                    if(VistaModulosPerfil == 'S'){
                %>
                <li><a href="controlmodulosperfil?btnModPerfilConsultar=true">Módulos perfil<span class="icon-dot"></span></a></li>
                <%
                    }    
                %>
            </ul>
        </li>
        <%
            }
            if(VistaGrupos =='S' || VistaEmpleadosGrupo == 'S' || VistaResponsableGrupo == 'S'){
        %>
        <li class="submenu">
            <a href="#">Grupos <i class="fas fa-caret-down"></i></a>
            <ul class="children">
                <%
                    if(VistaGrupos =='S'){
                %>
                <li><a href="grupos.htm">Tabla grupos<span class="icon-dot"></span></a></li>
                <%
                    }
                    if(VistaEmpleadosGrupo == 'S'){
                %>
                <li><a href="controlempleadosgrupo?btnEmplGruConsultar=true">Empleados por grupos<span class="icon-dot"></span></a></li>
                <%
                    }
                    if(VistaResponsableGrupo == 'S'){
                %>
                <li><a href="controlresponsablegrupo?btnReGruConsultar=true">Responsable del grupo<span class="icon-dot"></span></a></li>
                <%
                    }
                %>
            </ul>
        </li>
        <%
            }
            if(VistaConfiguracion == 'S'){
        %>
        <li class="submenu">
            <a href="controlconfiguracion?btnConfConsultar=true">Configuración<span class="icon-dot"></span></a>
        </li>
        <%
            }
        %>
        <li class='nav-item dropdown'>
            <a class='nav-link dropdown-toggle btn btn-dark' href='#' id='navbardrop' data-toggle='dropdown'>
                Usuario: <%out.println(id_usuario);%>
            </a>
            <div style='color: black;' class='dropdown-menu text-center'>
                <form action='cerrar' method='post' id='formcerrar'>
                    <input type='submit' value='Cerrar Sesión' class='btn btn-link text-center' style='color: black;'/>
                </form>
            </div>
        </li>
    </ul>
</nav>

