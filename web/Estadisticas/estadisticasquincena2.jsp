<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
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
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Estadísticas</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
        <link rel="stylesheet" href="<c:url value="/Resources/CSS/style.css"/>"/>
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
        <script src="Resources/JS/functions.js"></script>

    </head>
    <body>
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
            <%--Barra de Navegación de Jefe--%>
            <%
                if (Descripcion_perfil.equals("JEFE")) {

            %>       

            <jsp:include page="../WEB-INF/jsp/menujefe.jsp"></jsp:include>

            <%        }
            %>


            <%--Barra de Navegación de Coordinador--%>
            <%
                if (Descripcion_perfil.equals("COORDINADOR")) {
            %>

            <jsp:include page="../WEB-INF/jsp/menucordi.jsp"></jsp:include>

            <%
                }
            %> 
        </header> 
        <div class="container mt-4">
            <h1 class="text-center">Estadísticas</h1>
            <br>
            <div class="card border-info">
                <div class="card-header bg-info text-white">
                    <form action="estadisticas" method="post">
                        <div class="input-group">
                            <a href="nomina.htm" class="btn btn-secondary mr-2" data-toggle="tooltip" title="Haz clic para regresar al menú nómina"><i class="fas fa-arrow-left"></i></a>
                            <a href="estadisticas?btnConsultarEstaMensualidad=true" class="btn btn-secondary mr-2" data-toggle="tooltip" title="Haz clic para mostrar la mensualidad"><i class="fas fa-calendar-alt"></i></a>
                            <a href="estadisticas?btnConsultarEstaQuincena1=true" class="btn btn-secondary mr-2" data-toggle="tooltip" title="Haz clic para mostrar la quincena del día 1 al 15"><i class="fas fa-calendar-week"></i></a>
                            <a href="estadisticas?btnConsultarEstaQuincena2=true" class="btn btn-secondary mr-2" data-toggle="tooltip" title="Haz clic para mostrar la quincena del día 16 al 31"><i class="fas fa-calendar-minus"></i></a>
                        </div> 
                        <div class="input-group mt-2">
                            <a href="estadisticas?btnAgregarEsta=true" class="btn btn-secondary mr-2" data-toggle="tooltip" title="Haz clic para agregar un nuevo registro">Agregar Registro</a>
                            <input type="text" class="form-control rounded-left" name="txtBuscarEsta" id="txtEmplBuscar" placeholder="Buscar en Servisoft S.A."/>
                            <div class="input-group-append">
                                <button type="submit" Value="Buscar" class="btn btn-secondary rounded-right" data-toggle="tooltip" title="Haz clic para buscar" name="btnBuscarEstaQuincena2"><i class="fas fa-search"></i></button>                            
                            </div>
                        </div>              
                    </form>
                </div>
                <div class="card-body">
                    <div class=""></div>
                    <table id="table-id" cellspacing="0" border="1" class="table table-bordered table-striped table-hover text-center table-responsive">
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-3">
                                    <select class="form-control form-control-sm" name="state" id="maxRows"> 
                                        <option value="5000">Filtro de Paginación</option>
                                        <option value="5000">Todos</option>
                                        <option value="5">5</option>
                                        <option value="10">10</option>
                                        <option value="15">15</option>
                                        <option value="25">25</option>
                                        <option value="50">50</option>
                                        <option value="75">75</option>
                                        <option value="100">100</option>
                                    </select>
                                </div>
                                <div class="col-8 ml-2">
                                    <b>
                                        <i class="fas fa-clipboard-list"></i>
                                        <span>Registros Existentes: <%=lstclsEstadisticas.size()%></span>
                                    </b>
                                </div>
                            </div>
                        </div>
                        <tr>
                            <th class="align-middle"><b>Empleado</b></th>
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
                        <%
                            for (Modelos.Estadisticas.clsEstadisticas elem : lstclsEstadisticas) {
                        %>
                        <tr>
                            <td class="align-middle"><%=elem.getObEmpleado().getEmplPrimerNombre()%> <%=elem.getObEmpleado().getEmplSegundoNombre()%> <%=elem.getObEmpleado().getEmplPrimerApellido()%> <%=elem.getObEmpleado().getEmplSegundoApellido()%></td>
                            <td class="align-middle"><a href="estadisticas?codigoAnio=<%=elem.getId_estadistica()%>" class="btn btn-link openBtn" data-toggle="modal" data-target="#myModal"><%=elem.getObAnio().getNombreAnio()%></a></td>
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
                        %>
                    </table>  
                    <!--Inicio de la Paginación -->
                    <div class='pagination-container' >
                        <nav>
                            <ul class="pagination">

                                <li data-page="prev" >
                                    <button class="btn btn-secondary btn-sm mr-1"><i class="fas fa-angle-left" style="font-size: 15px;"></i>&nbsp;<span class="sr-only">(current)</span></button>
                                </li>
                                <!--	Here the JS Function Will Add the Rows -->
                                <li data-page="next" id="prev">
                                    <button class="btn btn-secondary btn-sm"><i class="fas fa-angle-right" style="font-size: 15px;"></i><span class="sr-only">(current)</span></button>
                                </li>
                            </ul>
                        </nav>
                    </div>
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
        <script type="text/javascript" language="JavaScript">
            fpaginacion();
        </script>
        <style>
            table th , table td{
                text-align: center;
            }

            table tr:nth-child(even){
                background-color: #fff;
            }

            .pagination li:hover{
                cursor: pointer;
            }


        </style>
    </body>
    <script type="text/javascript" language="JavaScript">
        main();
    </script>
</html>                           