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
    
    char VistaEstadisticas = 'N';
    String Descripcion_perfil = null;

    List<Modelos.Perfil.clsFiltroPerfilNombre> lstclsFiltroPerfilNombre = new ArrayList<Modelos.Perfil.clsFiltroPerfilNombre>();
    try {
        ResultSet rs = null;
        PreparedStatement ps = conn.prepareStatement("{call spBuscarFiltroPerfil(?)}");
        ps.setString(1, id_usuario);
        rs = ps.executeQuery();

        while (rs.next()) {
            Modelos.Perfil.clsFiltroPerfilNombre obclsFiltroPerfilNombre = new Modelos.Perfil.clsFiltroPerfilNombre();
            obclsFiltroPerfilNombre.setDescripcion_perfil(rs.getString("Descripcion_perfil"));
            obclsFiltroPerfilNombre.setVista_usuarios(rs.getString("Vista_usuarios").charAt(0));
            obclsFiltroPerfilNombre.setVista_perfil(rs.getString("Vista_perfil").charAt(0));
            obclsFiltroPerfilNombre.setVista_tiponovedades(rs.getString("Vista_tiponovedades").charAt(0));
            obclsFiltroPerfilNombre.setVista_facturacion(rs.getString("Vista_facturacion").charAt(0));
            obclsFiltroPerfilNombre.setVista_novedadesempleado(rs.getString("Vista_novedadesempleado").charAt(0));
            obclsFiltroPerfilNombre.setVista_centrocostos(rs.getString("Vista_centrocostos").charAt(0));
            obclsFiltroPerfilNombre.setVista_empleados(rs.getString("Vista_empleados").charAt(0));
            obclsFiltroPerfilNombre.setVista_cargoempleado(rs.getString("Vista_cargoempleado").charAt(0));
            obclsFiltroPerfilNombre.setVista_modulos(rs.getString("Vista_modulos").charAt(0));
            obclsFiltroPerfilNombre.setVista_modulosperfil(rs.getString("Vista_modulosperfil").charAt(0));
            obclsFiltroPerfilNombre.setVista_grupos(rs.getString("Vista_grupos").charAt(0));
            obclsFiltroPerfilNombre.setVista_empleadosgrupo(rs.getString("Vista_empleadosgrupo").charAt(0));
            obclsFiltroPerfilNombre.setVista_responsablegrupo(rs.getString("Vista_responsablegrupo").charAt(0));
            obclsFiltroPerfilNombre.setVista_configuracion(rs.getString("Vista_configuracion").charAt(0));
            obclsFiltroPerfilNombre.setVista_estadisticas(rs.getString("Vista_estadisticas").charAt(0));

            lstclsFiltroPerfilNombre.add(obclsFiltroPerfilNombre);
        }

    } catch (Exception ex) {

    }

    for (Modelos.Perfil.clsFiltroPerfilNombre elem : lstclsFiltroPerfilNombre) {

        Descripcion_perfil = elem.getDescripcion_perfil();
        VistaEstadisticas = elem.getVista_estadisticas();
        
    }

    if (id_usuario == null) {
        response.sendRedirect("logear?Login=true");
    } else {
        if (VistaEstadisticas != 'S') {
            response.sendRedirect("nomina.htm");
        }
    }
%>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Historial de Reportes</title>
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
    <body class="background-body">
        <%
            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();

            if (request.getAttribute("obclsEstadisticas") != null) {
                obclsEstadisticas = (Modelos.Estadisticas.clsEstadisticas) request.getAttribute("obclsEstadisticas");
            }

            List<Modelos.Estadisticas.clsEstadisticas> lstclsEstadisticas = new ArrayList<Modelos.Estadisticas.clsEstadisticas>();

            if (request.getAttribute("lstclsEstadisticas") != null) {

                lstclsEstadisticas = (List<Modelos.Estadisticas.clsEstadisticas>) request.getAttribute("lstclsEstadisticas");
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
                <h1 class="text-center">Historial de Reportes</h1>
                <br>
                <div class="card border-dark">
                    <div class="card-header background-card border-dark text-white">
                        <form action="estadisticas" method="post">
                            <div class="input-group">
                                <a href="nomina.htm" class="btn btn-secondary mr-2" data-toggle="tooltip" title="Haz clic para regresar al menú nómina"><i class="fas fa-arrow-left"></i></a>
                                <a href="estadisticas?btnConsultarEstaMensualidad=true" class="btn btn-secondary mr-2" data-toggle="tooltip" title="Haz clic para mostrar la mensualidad"><i class="fas fa-calendar-alt"></i></a>
                                <a href="estadisticas?btnConsultarEstaQuincena1=true" class="btn btn-secondary mr-2" data-toggle="tooltip" title="Haz clic para mostrar la quincena del día 1 al 15"><i class="fas fa-calendar-week"></i></a>
                                <a href="estadisticas?btnAgregarEsta=true" class="btn btn-secondary mr-2" data-toggle="tooltip" title="Haz clic para agregar un nuevo registro" title="Haz clic para agregar un registro" ><i class="fas fa-plus-circle"> <label class="coloriphonex tipoLetraLabel">Agregar</label></i></a>
                            </div>           
                        </form>
                    </div>
                    <div class="card-body">
                        <table class="table table-fluid table table-bordered table-striped table-hover text-center table-responsive" id="myTable">
                            <thead>     
                                <tr>
                                    <th class="align-middle">Empleado</th>
                                    <th>A&ntilde;o</th>
                                    <th>Mes</th>
                                    <th>16</th>
                                    <th>17</th>
                                    <th>18</th>
                                    <th>19</th>
                                    <th>20</th>
                                    <th>21</th>
                                    <th>22</th>
                                    <th>23</th>
                                    <th>24</th>
                                    <th>25</th>
                                    <th>26</th>
                                    <th>27</th>
                                    <th>28</th>
                                    <th>29</th>
                                    <th>30</th>
                                    <th>31</th>
                                    <th rowspan="1" class="align-middle"><b>Acciones</b></th> 
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
                                    for (Modelos.Estadisticas.clsEstadisticas elem : lstclsEstadisticas) {
                            %>
                            <tr>
                                <td class="align-middle"><%=elem.getObEmpleado().getEmplPrimerNombre()%> <%=elem.getObEmpleado().getEmplSegundoNombre()%> <%=elem.getObEmpleado().getEmplPrimerApellido()%> <%=elem.getObEmpleado().getEmplSegundoApellido()%></td>
                                <td class="align-middle"><%=elem.getAnio()%></td>
                                <td class="align-middle"><%=elem.getObMes().getMesNombre()%></td>
                                <td class="align-middle"><%=elem.getObId_dia16().getAliasDia16()%></td>
                                <td class="align-middle"><%=elem.getObId_dia17().getAliasDia17()%></td>
                                <td class="align-middle"><%=elem.getObId_dia18().getAliasDia18()%></td>
                                <td class="align-middle"><%=elem.getObId_dia19().getAliasDia19()%></td>
                                <td class="align-middle"><%=elem.getObId_dia20().getAliasDia20()%></td>
                                <td class="align-middle"><%=elem.getObId_dia21().getAliasDia21()%></td>
                                <td class="align-middle"><%=elem.getObId_dia22().getAliasDia22()%></td>
                                <td class="align-middle"><%=elem.getObId_dia23().getAliasDia23()%></td>
                                <td class="align-middle"><%=elem.getObId_dia24().getAliasDia24()%></td>
                                <td class="align-middle"><%=elem.getObId_dia25().getAliasDia25()%></td>
                                <td class="align-middle"><%=elem.getObId_dia26().getAliasDia26()%></td>
                                <td class="align-middle"><%=elem.getObId_dia27().getAliasDia27()%></td>
                                <td class="align-middle"><%=elem.getObId_dia28().getAliasDia28()%></td>
                                <td class="align-middle"><%=elem.getObId_dia29().getAliasDia29()%></td>
                                <td class="align-middle"><%=elem.getObId_dia30().getAliasDia30()%></td>
                                <td class="align-middle"><%=elem.getObId_dia31().getAliasDia31()%></td>
                                <td class="align-middle">
                                    <div class="btn-group">
                                        <a class="btn btn-warning rounded mr-1" id="btnEditarEsta" data-toggle="tooltip" title="Haz clic para editar el registro" 
                                           href="estadisticas?codigoSeleccionado=<%=elem.getId_estadistica()%>">
                                            <i class="fas fa-edit" style="font-size:15px;"></i>
                                        </a>


                                        <a class="btn btn-primary rounded mr-1 openBtn" data-toggle="modal" data-target="#myModal" id="btnEmplComentar"
                                           title="Haz clic para comentar" href="estadisticas?codigoComentar=<%=elem.getId_estadistica()%>">
                                            <i class="far fa-comment" style="font-size:15px;"></i>
                                        </a>


                                        <a class="btn btn-danger rounded openBtn" data-toggle="modal" data-target="#myModal" id="btnEmplEliminar"
                                           title="Haz clic paa eliminar" href="estadisticas?codigoEliminar=<%=elem.getId_estadistica()%>">
                                            <i class="fas fa-trash-alt" style="font-size:15px;"></i>
                                        </a>
                                    </div> 
                                </td>
                            </tr>
                            <%
                                }
                            } else {
                                for (Modelos.Estadisticas.clsEstadisticas elem : lstclsEstadisticas) {
                                    if (GrupoEmpl == (elem.getObGrupoEmpl().getId_grupo())) {
                            %>
                            <tr>
                                <td class="align-middle"><%=elem.getObEmpleado().getEmplPrimerNombre()%> <%=elem.getObEmpleado().getEmplSegundoNombre()%> <%=elem.getObEmpleado().getEmplPrimerApellido()%> <%=elem.getObEmpleado().getEmplSegundoApellido()%></td>
                                <td class="align-middle"><a href="estadisticas?codigoAnio=<%=elem.getId_estadistica()%>" class="btn btn-link openBtn" data-toggle="modal" data-target="#myModal"><%=elem.getAnio()%></a></td>
                                <td class="align-middle"><a href="estadisticas?codigoMes=<%=elem.getId_estadistica()%>" class="btn btn-link openBtn" data-toggle="modal" data-target="#myModal"><%=elem.getObMes().getMesNombre()%></a></td>
                                <td class="align-middle"><a href="estadisticas?codigoDia16=<%=elem.getId_estadistica()%>" class="btn btn-link openBtn" data-toggle="modal" data-target="#myModal"><%=elem.getObId_dia16().getAliasDia16()%></a></td>
                                <td class="align-middle"><a href="estadisticas?codigoDia17=<%=elem.getId_estadistica()%>" class="btn btn-link openBtn" data-toggle="modal" data-target="#myModal"><%=elem.getObId_dia17().getAliasDia17()%></a></td>
                                <td class="align-middle"><a href="estadisticas?codigoDia18=<%=elem.getId_estadistica()%>" class="btn btn-link openBtn" data-toggle="modal" data-target="#myModal"><%=elem.getObId_dia18().getAliasDia18()%></a></td>
                                <td class="align-middle"><a href="estadisticas?codigoDia19=<%=elem.getId_estadistica()%>" class="btn btn-link openBtn" data-toggle="modal" data-target="#myModal"><%=elem.getObId_dia19().getAliasDia19()%></a></td>
                                <td class="align-middle"><a href="estadisticas?codigoDia20=<%=elem.getId_estadistica()%>" class="btn btn-link openBtn" data-toggle="modal" data-target="#myModal"><%=elem.getObId_dia20().getAliasDia20()%></a></td>
                                <td class="align-middle"><a href="estadisticas?codigoDia21=<%=elem.getId_estadistica()%>" class="btn btn-link openBtn" data-toggle="modal" data-target="#myModal"><%=elem.getObId_dia21().getAliasDia21()%></a></td>
                                <td class="align-middle"><a href="estadisticas?codigoDia22=<%=elem.getId_estadistica()%>" class="btn btn-link openBtn" data-toggle="modal" data-target="#myModal"><%=elem.getObId_dia22().getAliasDia22()%></a></td>
                                <td class="align-middle"><a href="estadisticas?codigoDia23=<%=elem.getId_estadistica()%>" class="btn btn-link openBtn" data-toggle="modal" data-target="#myModal"><%=elem.getObId_dia23().getAliasDia23()%></a></td>
                                <td class="align-middle"><a href="estadisticas?codigoDia24=<%=elem.getId_estadistica()%>" class="btn btn-link openBtn" data-toggle="modal" data-target="#myModal"><%=elem.getObId_dia24().getAliasDia24()%></a></td>
                                <td class="align-middle"><a href="estadisticas?codigoDia25=<%=elem.getId_estadistica()%>" class="btn btn-link openBtn" data-toggle="modal" data-target="#myModal"><%=elem.getObId_dia25().getAliasDia25()%></a></td>
                                <td class="align-middle"><a href="estadisticas?codigoDia26=<%=elem.getId_estadistica()%>" class="btn btn-link openBtn" data-toggle="modal" data-target="#myModal"><%=elem.getObId_dia26().getAliasDia26()%></a></td>
                                <td class="align-middle"><a href="estadisticas?codigoDia27=<%=elem.getId_estadistica()%>" class="btn btn-link openBtn" data-toggle="modal" data-target="#myModal"><%=elem.getObId_dia27().getAliasDia27()%></a></td>
                                <td class="align-middle"><a href="estadisticas?codigoDia28=<%=elem.getId_estadistica()%>" class="btn btn-link openBtn" data-toggle="modal" data-target="#myModal"><%=elem.getObId_dia28().getAliasDia28()%></a></td>
                                <td class="align-middle"><a href="estadisticas?codigoDia29=<%=elem.getId_estadistica()%>" class="btn btn-link openBtn" data-toggle="modal" data-target="#myModal"><%=elem.getObId_dia29().getAliasDia29()%></a></td>
                                <td class="align-middle"><a href="estadisticas?codigoDia30=<%=elem.getId_estadistica()%>" class="btn btn-link openBtn" data-toggle="modal" data-target="#myModal"><%=elem.getObId_dia30().getAliasDia30()%></a></td>
                                <td class="align-middle"><a href="estadisticas?codigoDia31=<%=elem.getId_estadistica()%>" class="btn btn-link openBtn" data-toggle="modal" data-target="#myModal"><%=elem.getObId_dia31().getAliasDia31()%></a></td>
                                <td class="align-middle">
                                    <div class="btn-group">
                                        <a class="btn btn-warning rounded mr-1" id="btnEditarEsta" data-toggle="tooltip" title="Haz clic para editar el registro" 
                                           href="estadisticas?codigoSeleccionado=<%=elem.getId_estadistica()%>">
                                            <i class="fas fa-edit" style="font-size:15px;"></i>
                                        </a>


                                        <a class="btn btn-primary rounded mr-1 openBtn" data-toggle="modal" data-target="#myModal" id="btnEmplComentar"
                                           title="Haz clic para comentar" href="estadisticas?codigoComentar=<%=elem.getId_estadistica()%>">
                                            <i class="far fa-comment" style="font-size:15px;"></i>
                                        </a>


                                        <a class="btn btn-danger rounded openBtn" data-toggle="modal" data-target="#myModal" id="btnEmplEliminar"
                                           title="Haz clic paa eliminar" href="estadisticas?codigoEliminar=<%=elem.getId_estadistica()%>">
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
                                <th class="align-middle">Empleado</th>
                                <th>A&ntilde;o</th>
                                <th>Mes</th>
                                <th>16</th>
                                <th>17</th>
                                <th>18</th>
                                <th>19</th>
                                <th>20</th>
                                <th>21</th>
                                <th>22</th>
                                <th>23</th>
                                <th>24</th>
                                <th>25</th>
                                <th>26</th>
                                <th>27</th>
                                <th>28</th>
                                <th>29</th>
                                <th>30</th>
                                <th>31</th>
                                <th rowspan="1" class="align-middle">Acciones</th> 
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