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
    String Descripcion_perfil = (String) objsesion.getAttribute("descripcion_perfil");

    char VistaEmpleadosGrupo = 'N';

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

        VistaEmpleadosGrupo = elem.getVista_empleadosgrupo();

    }

    if (id_usuario == null) {
        response.sendRedirect("logear?Login=true");
    } else {
        if (VistaEmpleadosGrupo != 'S') {
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
        <title>Empleados por Grupo</title>
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
        <%
            Modelos.EmpleadosGrupo.clsEmpleadosGrupo obclsEmpleadosGrupo = new Modelos.EmpleadosGrupo.clsEmpleadosGrupo();

            if (request.getAttribute("obclsEmpleadosGrupo") != null) {
                obclsEmpleadosGrupo = (Modelos.EmpleadosGrupo.clsEmpleadosGrupo) request.getAttribute("obclsEmpleadosGrupo");
            }

            List<Modelos.EmpleadosGrupo.clsEmpleadosGrupo> lstclsEmpleadosGrupo = new ArrayList<Modelos.EmpleadosGrupo.clsEmpleadosGrupo>();

            if (request.getAttribute("lstclsEmpleadosGrupo") != null) {

                lstclsEmpleadosGrupo = (List<Modelos.EmpleadosGrupo.clsEmpleadosGrupo>) request.getAttribute("lstclsEmpleadosGrupo");
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
                <h1 class="text-center">Empleados por Grupo</h1>
                <br>
                <div class="card border-info">
                    <div class="card-header bg-info text-white">
                        <form action="controlempleadosgrupo" method="post">
                            <div class="input-group">
                                <a href="nomina.htm" class="btn btn-secondary mr-1"data-toggle="tooltip" title="Haz clic para regresar al menú nómina"><i class="fas fa-arrow-left"></i></a>
                                <a href="controlempleadosgrupo?btnEmplGruAgregar=true" class="btn btn-secondary mr-2" data-toggle="tooltip" title="Haz clic para agregar un nuevo registro" title="Haz clic para agregar un registro" ><i class="fas fa-plus-circle"> <label class="coloriphonex tipoLetraLabel">Agregar</label></i></a>
                            </div>
                        </form>
                    </div>
                    <div class="card-body">
                        <table class="table table-fluid table table-bordered table-striped table-hover text-center table-responsive-sm" id="myTable">
                            <thead>
                                <tr>
                                    <th class="align-middle">Grupo</th>
                                    <th class="align-middle">Empleado</th>
                                    <th class="align-middle">Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                            <%
                                int GrupoEmpl = 0;

                                List<Modelos.Estadisticas.clsEstadisticas> lstclsEstadisticasGrupo = new ArrayList<Modelos.Estadisticas.clsEstadisticas>();
                                try {
                                    ResultSet rs = null;
                                    PreparedStatement ps = conn.prepareStatement("{call spBuscarGrupoUsuario(?)}");
                                    ps.setString(1, id_usuario);
                                    rs = ps.executeQuery();

                                    while (rs.next()) {
                                        Modelos.Estadisticas.clsEstadisticas obEstadisticas = new Modelos.Estadisticas.clsEstadisticas();

                                        Modelos.Estadisticas.clsGrupoEmpl obGrupoEmpl = new Modelos.Estadisticas.clsGrupoEmpl();
                                        obGrupoEmpl.setId_grupo(rs.getInt("Id_grupo"));
                                        obEstadisticas.setObGrupoEmpl(obGrupoEmpl);

                                        lstclsEstadisticasGrupo.add(obEstadisticas);
                                    }

                                } catch (Exception ex) {

                                }

                                for (Modelos.Estadisticas.clsEstadisticas elem : lstclsEstadisticasGrupo) {

                                    GrupoEmpl = elem.getObGrupoEmpl().getId_grupo();

                                }
                                if (Descripcion_perfil.equals("JEFE")) {
                                    for (Modelos.EmpleadosGrupo.clsEmpleadosGrupo elem : lstclsEmpleadosGrupo) {
                            %>
                            <tr>
                                <td class="align-middle"><%=elem.getObclsGrupo().getNombre_grupo()%></td>
                                <td class="align-middle">
                                    <%=elem.getObclsEmpleado().getEmplPrimerNombre()%>
                                    <%=elem.getObclsEmpleado().getEmplSegundoNombre()%>
                                    <%=elem.getObclsEmpleado().getEmplPrimerApellido()%>
                                    <%=elem.getObclsEmpleado().getEmplSegundoApellido()%>
                                </td>
                                <td class="align-middle">
                                    <div class="btn-group">
                                        <a class="btn btn-warning btn-sm mr-1 openBtn rounded" title="Haz clic para editar perfil" data-toggle="modal" data-target="#myModal" id="btnModPerfilEditar" 
                                           href="controlempleadosgrupo?stOpcion=M&codigoSeleccionado=<%=elem.getId_empleados_grupo()%>">
                                            <i class="fas fa-edit" style="font-size:15px;"></i>
                                        </a>
                                        <a class="btn btn-danger btn-sm openBtn rounded" title="Haz clic para eliminar" data-toggle="modal" data-target="#myModal" id="btnModPerfilEliminar"
                                           href="controlempleadosgrupo?stOpcion=E&codigoSeleccionado=<%=elem.getId_empleados_grupo()%>">
                                            <i class="fas fa-trash-alt" style="font-size:15px;"></i>
                                        </a>
                                    </div>                                
                                </td>
                            </tr>
                            <%
                                }
                            } else {
                                for (Modelos.EmpleadosGrupo.clsEmpleadosGrupo elem : lstclsEmpleadosGrupo) {
                                    if (GrupoEmpl == (elem.getObclsGrupo().getId_grupo())
                                            || (elem.getObclsGrupo().getId_grupo()) == 1) {
                            %>
                            <tr>
                                <td class="align-middle"><%=elem.getObclsGrupo().getNombre_grupo()%></td>
                                <td class="align-middle">
                                    <%=elem.getObclsEmpleado().getEmplPrimerNombre()%>
                                    <%=elem.getObclsEmpleado().getEmplSegundoNombre()%>
                                    <%=elem.getObclsEmpleado().getEmplPrimerApellido()%>
                                    <%=elem.getObclsEmpleado().getEmplSegundoApellido()%>
                                </td>
                                <td class="align-middle">
                                    <div class="btn-group">
                                        <a class="btn btn-warning btn-sm mr-1 openBtn rounded" title="Haz clic para editar perfil" data-toggle="modal" data-target="#myModal" id="btnModPerfilEditar" 
                                           href="controlempleadosgrupo?stOpcion=M&codigoSeleccionado=<%=elem.getId_empleados_grupo()%>">
                                            <i class="fas fa-edit" style="font-size:15px;"></i>
                                        </a>
                                        <a class="btn btn-danger btn-sm openBtn rounded" title="Haz clic para eliminar" data-toggle="modal" data-target="#myModal" id="btnModPerfilEliminar"
                                           href="controlempleadosgrupo?stOpcion=E&codigoSeleccionado=<%=elem.getId_empleados_grupo()%>">
                                            <i class="fas fa-trash-alt" style="font-size:15px;"></i>
                                        </a>
                                    </div>                                
                                </td>
                            </tr>
                            <%
                                        }
                                    }
                                }
                            %>
                        </tbody>
                        <tfoot>
                            <tr>
                                <th class="align-middle">Grupo</th>
                                <th class="align-middle">Empleado</th>
                                <th class="align-middle">Acciones</th>
                            </tr>
                        </tfoot>
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
