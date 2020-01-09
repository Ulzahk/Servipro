<%@page import="BL.clsConexion"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
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
        response.sendRedirect("login.jsp");
    } else {
        if (VistaUsuarios != 'S') {
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
        <title>Eliminar Usuario</title>
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
            Modelos.Usuarios.clsUsuarios obclsUsuarios = new Modelos.Usuarios.clsUsuarios();

            if (request.getAttribute("obclsUsuarios") != null) {
                obclsUsuarios = (Modelos.Usuarios.clsUsuarios) request.getAttribute("obclsUsuarios");
            }

            List<Modelos.Usuarios.clsUsuarios> lstclsUsuarios = new ArrayList<Modelos.Usuarios.clsUsuarios>();

            if (request.getAttribute("lstclsUsuarios") != null) {

                lstclsUsuarios = (List<Modelos.Usuarios.clsUsuarios>) request.getAttribute("lstclsUsuarios");
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

        <div class="container">
            <div class="card border-info">
                <div class="card-header bg-info text-white">
                    <div class="form-group">
                        <div class="form-group">
                            <div class="col-12 text-center">                                    
                                <h5 class="align-middle mt-1"> 
                                    <b>
                                        <%=obclsUsuarios.getObclsEmpleado().getStPrimerNombre() != null ? obclsUsuarios.getObclsEmpleado().getStPrimerNombre() : ""%>
                                        <%=obclsUsuarios.getObclsEmpleado().getStSegundoNombre() != null ? obclsUsuarios.getObclsEmpleado().getStSegundoNombre() : ""%>
                                        <%=obclsUsuarios.getObclsEmpleado().getStPrimerApellido() != null ? obclsUsuarios.getObclsEmpleado().getStPrimerApellido() : ""%>
                                        <%=obclsUsuarios.getObclsEmpleado().getStSegundoApellido() != null ? obclsUsuarios.getObclsEmpleado().getStSegundoApellido() : ""%>
                                    </b>
                                </h5>                                         
                            </div>
                        </div>
                    </div>
                </div>
                <div class="card-body">
                    <form action="controlusuarios" method="POST">
                        <!--FILA-->
                        <div class="form-group">
                            <div class="row">
                                <div class="col-2">
                                </div>
                                <div class="col-8 text-center">
                                    <i class="fas fa-exclamation-triangle mb-2" style="font-size:70px;color:#FFCC00;"></i>
                                    <h4 class="font-weight-bold">¿Estás seguro de que quieres eliminar esto?</h4>
                                    <h6>No podrás deshacer esta acción</h6>
                                </div>
                                <div class="col-2">
                                </div>
                            </div>
                        </div>
                        <!--FILA-->   
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-12 text-center btn-group">
                                    <a href="controlusuarios?btnUsuConsultar=true" class="btn btn-info font-weight-bold rounded"><span>No, cancelar</span></a>
                                    <span>&nbsp;</span>
                                    <input type="submit" value="Si, eliminar" class="btn btn-danger font-weight-bold rounded ml-1" name="btnUsuEliminar"/>
                                    <input type="text" name="IdModificar" id="IdModificar" value="<%=obclsUsuarios.getNro_usuario()%>" hidden=""/>                               
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
