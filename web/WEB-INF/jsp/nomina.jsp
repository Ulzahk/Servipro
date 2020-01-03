<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession objsesion = request.getSession(false);
    String id_usuario = (String) objsesion.getAttribute("id_usuario");
    String Descripcion_perfil = (String) objsesion.getAttribute("descripcion_perfil");
    if (id_usuario == null) {
        response.sendRedirect("login.jsp");
    } else {
        if (Descripcion_perfil.equals("COORDINADOR")
                || Descripcion_perfil.equals("ADMINISTRADOR")
                || Descripcion_perfil.equals("JEFE")) {

        } else {
            response.sendRedirect("index.htm");
        }
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
        <%
            if (Descripcion_perfil.equals("JEFE")) {

        %>       

        <jsp:include page="menujefe.jsp"></jsp:include>

        <%        }
        %>

        <%--Barra de Navegación de Administrador--%>
        <%
            if (Descripcion_perfil.equals("ADMINISTRADOR")) {
        %>

        <jsp:include page="menuadmin.jsp"></jsp:include>

        <%
            }
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

    <div class="logo container mt-3 mb-1 text-center">
        <img src="<c:url value="/Resources/Images/LogoServiSoft.png"/>"/>  
    </div>
    <br/>

    <%--Menú Nomina de Jefe--%>
    <%
        if (Descripcion_perfil.equals("JEFE")) {

    %>
    <div class='container mt-4 text-center'>
        <div class='row text-center'>
            <a href='controlusuarios?btnUsuConsultar=true' class='col aIndex colorEnlace'>
                <i class='fas fa-user-circle mb-2 mt-2 tamañoIcono'></i>
                <p><b>Usuarios</b></p>
            </a>
            <a href='perfil.htm' class='col aIndex colorEnlace'>
                <i class='fas fa-address-card mb-2 mt-2 tamañoIcono'></i>
                <p><b>Perfil</b></p>
            </a>
            <a href='tipodenovedades.htm' class='col bIndex colorEnlace'>
                <i class='fas fa-bullhorn mb-2 mt-2 tamañoIcono'></i>
                <p><b>Tipo De Novedades</b></p>
            </a>
            <a href='facturacion.htm' class='col bIndex colorEnlace'>
                <i class='fab fa-buromobelexperte mb-2 mt-2 tamañoIcono'></i>
                <p><b>Facturación</b></p>
            </a>
            <a href='controlnovedadesempleado?btnNoveEmplConsultar=true' class='col bIndex colorEnlace'>
                <i class='fas fa-user-check mb-2 tamañoIcono'></i>
                <p><b>Novedades por Empleado</b></p>
            </a>
            <a href='centrodecostos.htm' class='col eIndex colorEnlace'>
                <i class='fas fa-file-invoice-dollar mb-2 mt-2 tamañoIcono'></i>
                <p><b>Centro de Costos</b></p>
            </a>
        </div>
        <div class='row text-center'>
            <a href='empleados?btnEmplConsultar=true' class='col dIndex colorEnlace'>
                <i class='fas fa-user-clock mb-2 mt-2 tamañoIcono'></i>
                <p><b>Empleados</b></p>
            </a>
            <a href='cargoempleado.htm' class='col dIndex colorEnlace'>
                <i class='fas fa-briefcase mb-2 mt-2 tamañoIcono'></i>
                <p><b>Cargo Empleado</b></p>
            </a>
            <a href='modulos.htm' class='col cIndex colorEnlace'>
                <i class='fas fa-th mb-2 mt-2 tamañoIcono'></i>
                <p><b>Módulos</b></p>
            </a>
            <a href='controlmodulosperfil?btnModPerfilConsultar=true' class='col cIndex colorEnlace'>
                <i class='fas fa-th-list mb-2 tamañoIcono'></i>
                <p><b>Módulos por Perfil</b></p>
            </a>
            <a href='grupos.htm' class='col fIndex colorEnlace'>
                <i class='fas fa-users mb-2 mt-2 tamañoIcono'></i>
                <p><b>Grupos</b></p>
            </a>
            <a href='controlempleadosgrupo?btnEmplGruConsultar=true' class='col fIndex colorEnlace'>
                <i class='fas fa-users-cog mb-2 tamañoIcono'></i>
                <p><b>Empleados por Grupo</b></p>
            </a>
        </div>
        <div class='row text-center'>
            <a href='controlresponsablegrupo?btnReGruConsultar=true' class='col fIndex colorEnlace'>
                <i class='fas fa-user-tie mb-2 mt-2 tamañoIcono'></i>
                <p><b>Responsable por Grupo</b></p>
            </a>
            <a href='configuracion.htm' class='col gIndex colorEnlace'>
                <i class='fas fa-cog mb-2  tamañoIcono'></i>
                <p><b>Configuración</b></p>
            </a>
            <a href='estadisticas?btnConsultarEstaMensualidad=true' class='col gIndex colorEnlace'>
                <i class='fas fa-chart-bar mb-2  tamañoIcono'></i>
                <p><b>Estadísticas</b></p>
            </a>
        </div>
    </div>
    <%        }
    %>

    <%--Menú Nomina de Administrador--%>
    <%
        if (Descripcion_perfil.equals("ADMINISTRADOR")) {
    %>
    <div class='container mt-4 text-center'>
        <div class='row text-center'>
            <a href='controlusuarios?btnUsuConsultar=true' class='col aIndex colorEnlace'>
                <i class='fas fa-user-circle mb-2 mt-2 tamañoIcono'></i>
                <p><b>Usuarios</b></p>
            </a>
            <a href='perfil.htm' class='col aIndex colorEnlace'>
                <i class='fas fa-address-card mb-2 mt-2 tamañoIcono'></i>
                <p><b>Perfil</b></p>
            </a>
        </div>
        <div class='row text-center'>
            <a href='modulos.htm' class='col cIndex colorEnlace'>
                <i class='fas fa-th mb-2 mt-2 tamañoIcono'></i>
                <p><b>Módulos</b></p>
            </a>
            <a href='controlmodulosperfil?btnModPerfilConsultar=true' class='col cIndex colorEnlace'>
                <i class='fas fa-th-list mb-2 mt-2 tamañoIcono'></i>
                <p><b>Módulos por Perfil</b></p>
            </a>
        </div>
        <%
            }
        %>

        <%--Menú Nomina de Coordinador--%>
        <%
            if (Descripcion_perfil.equals("COORDINADOR")) {
        %>
        <div class='container mt-4 text-center'>
            <div class='row text-center'>
                <a href='tipodenovedades.htm' class='col bIndex colorEnlace'>
                    <i class='fas fa-bullhorn mb-2 mt-2 tamañoIcono'></i>
                    <p><b>Tipo De Novedades</b></p>
                </a>
                <a href='facturacion.htm' class='col bIndex colorEnlace'>
                    <i class='fab fa-buromobelexperte mb-2 mt-2 tamañoIcono'></i>
                    <p><b>Facturación</b></p>
                </a>
                <a href='controlnovedadesempleado?btnNoveEmplConsultar=true' class='col bIndex colorEnlace'>
                    <i class='fas fa-user-check mb-2 tamañoIcono'></i>
                    <p><b>Novedades por Empleado</b></p>
                </a>
                <a href='centrodecostos.htm' class='col eIndex colorEnlace'>
                    <i class='fas fa-file-invoice-dollar mb-2 mt-2 tamañoIcono'></i>
                    <p><b>Centro de Costos</b></p>
                </a>
                <a href='empleados?btnEmplConsultar=true' class='col dIndex colorEnlace'>
                    <i class='fas fa-user-clock mb-2 mt-2 tamañoIcono'></i>
                    <p><b>Empleados</b></p>
                </a>
                <a href='cargoempleado.htm' class='col dIndex colorEnlace'>
                    <i class='fas fa-briefcase mb-2 mt-2 tamañoIcono'></i>
                    <p><b>Cargo Empleado</b></p>
                </a>
            </div>
            <div class='row text-center'>
                <a href='grupos.htm' class='col-2 fIndex colorEnlace'>
                    <i class='fas fa-users mb-2 mt-2 tamañoIcono'></i>
                    <p><b>Grupos</b></p>
                </a>
                <a href='controlempleadosgrupo?btnEmplGruConsultar=true' class='col-2 fIndex colorEnlace'>
                    <i class='fas fa-users-cog mb-2 tamañoIcono'></i>
                    <p><b>Empleados por Grupo</b></p>
                </a>
                <a href='controlresponsablegrupo?btnReGruConsultar=true' class='col-2 fIndex colorEnlace'>
                    <i class='fas fa-user-tie mb-2 mt-2 tamañoIcono'></i>
                    <p><b>Responsable por Grupo</b></p>
                </a>
                <a href='configuracion.htm' class='col-2 gIndex colorEnlace'>
                    <i class='fas fa-cog mb-2  tamañoIcono'></i>
                    <p><b>Configuracion</b></p>
                </a>
                <a href='estadisticas?btnConsultarEstaMensualidad=true' class='col-2 gIndex colorEnlace'>
                    <i class='fas fa-chart-bar mb-2  tamañoIcono'></i>
                    <p><b>Estadísticas</b></p>
                </a>
            </div>
        </div>
        <%
            }
        %>

    </body>   
    <script type="text/javascript" language="JavaScript">
        main();
    </script>
</html>
