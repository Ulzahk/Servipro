<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%
    HttpSession objsesion = request.getSession(false);
    String id_usuario = (String)objsesion.getAttribute("id_usuario");
    String Descripcion_perfil = (String)objsesion.getAttribute("descripcion_perfil");
    if(id_usuario==null){
        response.sendRedirect("login.jsp");
    }else{
        if(Descripcion_perfil.equals("COORDINADOR")||
                Descripcion_perfil.equals("JEFE")){
            
        }else{
          response.sendRedirect("nomina.htm");  
        }
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Estadisticas</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>

    </head>
    <body>
        <%
            Modelos.Estadisticas.clsEstadisticas obclsEstadisticas = new Modelos.Estadisticas.clsEstadisticas();
            
            if(request.getAttribute("obclsEstadisticas")!=null){
                obclsEstadisticas = (Modelos.Estadisticas.clsEstadisticas)request.getAttribute("obclsEstadisticas");
            }
            
            List<Modelos.Estadisticas.clsEstadisticas> lstclsEstadisticas = new ArrayList<Modelos.Estadisticas.clsEstadisticas>();
            
            if(request.getAttribute("lstclsEstadisticas")!=null){
                
                lstclsEstadisticas = (List<Modelos.Estadisticas.clsEstadisticas>)request.getAttribute("lstclsEstadisticas");
            }
            
            if(request.getAttribute("stMensaje")!=null && request.getAttribute("stTipo")!=null){
                
            
        
        %>
        <input type="text" hidden="" id="txtMensaje" value="<%=request.getAttribute("stMensaje")%>"/>
        <input type="text" hidden="" id="txtTipo" value="<%=request.getAttribute("stTipo")%>"/>
        <script>
            var mensaje = document.getElementById("txtMensaje").value;
            var tipo = document.getElementById("txtTipo").value;

            swal.fire("Mensaje",mensaje, tipo);
        </script>
        <%
            }
        %>
        <%--Barra de Navegación de Jefe--%>
        <%
            if(Descripcion_perfil.equals("JEFE")){

                out.println("<nav class='navbar navbar-expand-sm bg-info navbar-dark justify-content-center'>");
                    out.println("<a class='navbar-brand' href='index.htm'>ServiSoft S.A.</a>");
                    out.println("<div>");
                        out.println("<ul class='navbar-nav'>");
                            out.println("<li class='nav-item dropdown'>");
                                out.println("<a class='nav-link dropdown-toggle' href='#' id='navbardrop' data-toggle='dropdown'>");
                                    out.println("Control Usuarios");
                                out.println("</a>");
                                    out.println("<div class='dropdown-menu'>");
                                        out.println("<a class='dropdown-item' href='usuarios.htm'>Usuarios</a>");
                                        out.println("<a class='dropdown-item' href='perfil.htm'>Perfil</a>");
                                    out.println("</div>");;
                            out.println("</li>");
                            out.println("<li class='nav-item dropdown'>");
                                out.println("<a class='nav-link dropdown-toggle' href='#' id='navbardrop' data-toggle='dropdown'>");
                                    out.println("Novedades");
                                out.println("</a>");
                                out.println("<div class='dropdown-menu'>");
                                    out.println("<a class='dropdown-item' href='tipodenovedades.htm'>Tabla De Novedades</a>");
                                    out.println("<a class='dropdown-item' href='facturacion.htm'>Facturación</a>");
                                    out.println("<a class='dropdown-item' href='novedadesempleado.htm'>Novedades por Empleado</a>");
                                out.println("</div>");
                            out.println("</li>");
                            out.println("<li class='nav-item dropdown'>");
                                out.println("<a class='nav-link dropdown-toggle' href='#' id='navbardrop' data-toggle='dropdown'>");
                                    out.println("Centro de Costos");
                                out.println("</a>");
                                out.println("<div class='dropdown-menu'>");
                                    out.println("<a class='dropdown-item' href='centrodecostos.htm'>Tabla Centro de Costos</a>");
                                out.println("</div>");
                            out.println("</li>");
                            out.println("<li class='nav-item dropdown'>");
                                out.println("<a class='nav-link dropdown-toggle' href='#' id='navbardrop' data-toggle='dropdown'>");
                                    out.println("Empleados");
                                out.println("</a>");
                                out.println("<div class='dropdown-menu'>");
                                    out.println("<a class='dropdown-item' href='empleados.htm'>Tabla Empleados</a>");
                                    out.println("<a class='dropdown-item' href='cargoempleado.htm'>Cargo Empleado</a>");
                                out.println("</div>");
                            out.println("</li>");
                            out.println("<li class='nav-item dropdown'>");
                                out.println("<a class='nav-link dropdown-toggle' href='#' id='navbardrop' data-toggle='dropdown'>");
                                    out.println("Modulos");
                                out.println("</a>");
                                out.println("<div class='dropdown-menu'>");
                                    out.println("<a class='dropdown-item' href='modulos.htm'>Tabla Modulos</a>");
                                    out.println("<a class='dropdown-item' href='modulosperfil.htm'>Modulos por Perfil</a>");
                                out.println("</div>");
                            out.println("</li>");
                            out.println("<li class='nav-item dropdown'>");
                                out.println("<a class='nav-link dropdown-toggle' href='#' id='navbardrop' data-toggle='dropdown'>");
                                    out.println("Grupos");
                                out.println("</a>");
                                out.println("<div class='dropdown-menu'>");
                                    out.println("<a class='dropdown-item' href='grupos.htm'>Tabla Grupos</a>");
                                    out.println("<a class='dropdown-item' href='empleadosgrupo.htm'>Empleados por Grupo</a>");
                                    out.println("<a class='dropdown-item' href='responsablegrupo.htm'>Responsable del Grupo</a>");
                                out.println("</div>");
                            out.println("</li>");
                            out.println("<li class='nav-item dropdown'>");
                                out.println("<a class='nav-link dropdown-toggle' href='#' id='navbardrop' data-toggle='dropdown'>");
                                    out.println("Configuracion");
                                out.println("</a>");
                                out.println("<div class='dropdown-menu'>");
                                    out.println("<a class='dropdown-item' href='configuracion.htm'>Configuracion</a>");
                                out.println("</div>");
                            out.println("</li>");
                            out.println("<li class='nav-item dropdown'>");
                                out.println("<a class='nav-link dropdown-toggle btn btn-dark' href='#' id='navbardrop' data-toggle='dropdown'>");
                                    out.println("Usuario:"); out.println(id_usuario);
                                out.println("</a>");
                                out.println("<div class='dropdown-menu text-center'>");
                                    out.println("<a class='dropdown-item' href='nomina.htm'>");
                                        out.println("Perfil:"); out.println(Descripcion_perfil);
                                    out.println("</a>");
                                    out.println("<form action='cerrar' method='post' id='formcerrar'>");
                                            out.println("<input type='submit' value='Cerrar Sesión' "
                                                        + " class='btn btn-link text-center' style='color: #000;'/>");
                                    out.println("</form>");
                                out.println("</div>");
                            out.println("</li>");
                        out.println("</ul>");
                    out.println("</div>");
                out.println("</nav>");
            }
        %>
        
        <%--Barra de Navegación de Coordinador--%>
        <%
            if(Descripcion_perfil.equals("COORDINADOR")){

                out.println("<nav class='navbar navbar-expand-sm bg-info navbar-dark justify-content-center'>");
                    out.println("<a class='navbar-brand' href='index.htm'>ServiSoft S.A.</a>");
                    out.println("<div>");
                        out.println("<ul class='navbar-nav'>");
                            out.println("<li class='nav-item dropdown'>");
                                out.println("<a class='nav-link dropdown-toggle' href='#' id='navbardrop' data-toggle='dropdown'>");
                                    out.println("Novedades");
                                out.println("</a>");
                                out.println("<div class='dropdown-menu'>");
                                    out.println("<a class='dropdown-item' href='tipodenovedades.htm'>Tabla De Novedades</a>");
                                    out.println("<a class='dropdown-item' href='facturacion.htm'>Facturación</a>");
                                    out.println("<a class='dropdown-item' href='novedadesempleado.htm'>Novedades por Empleado</a>");
                                out.println("</div>");
                            out.println("</li>");
                            out.println("<li class='nav-item dropdown'>");
                                out.println("<a class='nav-link dropdown-toggle' href='#' id='navbardrop' data-toggle='dropdown'>");
                                    out.println("Centro de Costos");
                                out.println("</a>");
                                out.println("<div class='dropdown-menu'>");
                                    out.println("<a class='dropdown-item' href='centrodecostos.htm'>Tabla Centro de Costos</a>");
                                out.println("</div>");
                            out.println("</li>");
                            out.println("<li class='nav-item dropdown'>");
                                out.println("<a class='nav-link dropdown-toggle' href='#' id='navbardrop' data-toggle='dropdown'>");
                                    out.println("Empleados");
                                out.println("</a>");
                                out.println("<div class='dropdown-menu'>");
                                    out.println("<a class='dropdown-item' href='empleados.htm'>Tabla Empleados</a>");
                                    out.println("<a class='dropdown-item' href='cargoempleado.htm'>Cargo Empleado</a>");
                                out.println("</div>");
                            out.println("</li>");
                            out.println("<li class='nav-item dropdown'>");
                                out.println("<a class='nav-link dropdown-toggle' href='#' id='navbardrop' data-toggle='dropdown'>");
                                    out.println("Grupos");
                                out.println("</a>");
                                out.println("<div class='dropdown-menu'>");
                                    out.println("<a class='dropdown-item' href='grupos.htm'>Tabla Grupos</a>");
                                    out.println("<a class='dropdown-item' href='empleadosgrupo.htm'>Empleados por Grupo</a>");
                                    out.println("<a class='dropdown-item' href='responsablegrupo.htm'>Responsable del Grupo</a>");
                                out.println("</div>");
                            out.println("</li>");
                            out.println("<li class='nav-item dropdown'>");
                                out.println("<a class='nav-link dropdown-toggle' href='#' id='navbardrop' data-toggle='dropdown'>");
                                    out.println("Configuracion");
                                out.println("</a>");
                                out.println("<div class='dropdown-menu'>");
                                    out.println("<a class='dropdown-item' href='configuracion.htm'>Configuracion</a>");
                                out.println("</div>");
                            out.println("</li>");
                            out.println("<li class='nav-item dropdown'>");
                                out.println("<a class='nav-link dropdown-toggle btn btn-dark' href='#' id='navbardrop' data-toggle='dropdown'>");
                                    out.println("Usuario:"); out.println(id_usuario);
                                out.println("</a>");
                                out.println("<div class='dropdown-menu text-center'>");
                                    out.println("<a class='dropdown-item' href='nomina.htm'>");
                                        out.println("Perfil:"); out.println(Descripcion_perfil);
                                    out.println("</a>");
                                    out.println("<form action='cerrar' method='post' id='formcerrar'>");
                                            out.println("<input type='submit' value='Cerrar Sesión' "
                                                        + " class='btn btn-link text-center' style='color: #000;'/>");
                                    out.println("</form>");
                                out.println("</div>");
                            out.println("</li>");
                        out.println("</ul>");
                    out.println("</div>");
                out.println("</nav>");
            }
        %> 
        <div class="container mt-4">
            <h1 class="text-center">Estadisticas</h1>
            <br>
            <div class="card border-info">
                <div class="card-header bg-info text-white">
                    <form action="estadisticas" method="post">
                    <div class="input-group mt-3">
                        <a href="nomina.htm" class="btn btn-secondary mr-2"><i class="fas fa-arrow-left"></i></a>
                        <a href="estadisticas?btnAgregarEsta=true" class="btn btn-secondary mr-2">Agregar Registro</a>
                        <a href="estadisticas?btnConsultarEsta=true" class="btn btn-secondary mr-2">Cargar Registros</a>
                        <input type="text" class="form-control" name="txtBuscarEsta" id="txtEmplBuscar" placeholder="Buscar en Servisoft S.A."/>
                        <div class="input-group-append">
                            <input type="submit" value="Buscar" class="btn btn-secondary" name="btnBuscarEsta"> 
                        </div>
                    </div>
                    </form>
                </div>
                <div class="card-body">
                    <table border="1" class="table table-bordered table-striped table-hover text-center table-responsive-lg">
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-12">
                                    <b>
                                        <i class="fas fa-clipboard-list"></i>
                                        <span>Registros: <%=lstclsEstadisticas.size()%></span>
                                    </b>
                                </div>
                            </div>
                        </div>
                        
                        <tr>
                            <td class="align-middle"><b>Empleado</b></td>
                            <td colspan="15" class="align-middle"><b>Días - Novedades</b></td>
                            <td class="align-middle"><b>Accíones</b></td>                            
                        </tr>
                        <%
                            for(Modelos.Estadisticas.clsEstadisticas elem: lstclsEstadisticas){
                        %>
                        <tr>
                            <td rowspan="4" class="align-middle"><%=elem.getObEmpleado().getNombreEmp()%></td>
                            <td class="align-middle">1</td>
                            <td class="align-middle">2</td>
                            <td class="align-middle">3</td>
                            <td class="align-middle">4</td>
                            <td class="align-middle">5</td>
                            <td class="align-middle">6</td>
                            <td class="align-middle">7</td>
                            <td class="align-middle">8</td>
                            <td class="align-middle">9</td>
                            <td class="align-middle">10</td>
                            <td class="align-middle">11</td>
                            <td class="align-middle">12</td>
                            <td class="align-middle">13</td>
                            <td class="align-middle">14</td>
                            <td class="align-middle">15</td>
                            <td rowspan="4" class="align-middle">
                                <a class="btn btn-warning btn-sm mb-2" id="btnEditarEsta" 
                                   href="estadisticas?stOpcion=M&codigoSeleccionado=<%=elem.getId_estadistica()%>">
                                    <i class="fas fa-edit" style="font-size:15px;"></i>
                                </a>
                                <a class="btn btn-danger btn-sm" id="btnEmplEliminar"
                                   href="estadisticas?stOpcion=E&codigoSeleccionado=<%=elem.getId_estadistica()%>">
                                    <i class="fas fa-trash-alt" style="font-size:15px;"></i>
                                </a>
                            </td>
                        </tr>
                        <tr>
                            <td class="align-middle"><%=elem.getObId_dia1().getAliasDia1()%></td>
                            <td class="align-middle"><%=elem.getObId_dia2().getAliasDia2()%></td>
                            <td class="align-middle"><%=elem.getObId_dia3().getAliasDia3()%></td>
                            <td class="align-middle"><%=elem.getObId_dia4().getAliasDia4()%></td>
                            <td class="align-middle"><%=elem.getObId_dia5().getAliasDia5()%></td>
                            <td class="align-middle"><%=elem.getObId_dia6().getAliasDia6()%></td>
                            <td class="align-middle"><%=elem.getObId_dia7().getAliasDia7()%></td>
                            <td class="align-middle"><%=elem.getObId_dia8().getAliasDia8()%></td>
                            <td class="align-middle"><%=elem.getObId_dia9().getAliasDia9()%></td>
                            <td class="align-middle"><%=elem.getObId_dia10().getAliasDia10()%></td>
                            <td class="align-middle"><%=elem.getObId_dia11().getAliasDia11()%></td>
                            <td class="align-middle"><%=elem.getObId_dia12().getAliasDia12()%></td>
                            <td class="align-middle"><%=elem.getObId_dia13().getAliasDia13()%></td>
                            <td class="align-middle"><%=elem.getObId_dia14().getAliasDia14()%></td>
                            <td class="align-middle"><%=elem.getObId_dia15().getAliasDia15()%></td>
                        </tr>
                        <tr>
                            <td class="align-middle">16</td>
                            <td class="align-middle">17</td>
                            <td class="align-middle">18</td>
                            <td class="align-middle">19</td>
                            <td class="align-middle">20</td>
                            <td class="align-middle">21</td>
                            <td class="align-middle">22</td>
                            <td class="align-middle">23</td>
                            <td class="align-middle">24</td>
                            <td class="align-middle">25</td>
                            <td class="align-middle">26</td>
                            <td class="align-middle">27</td>
                            <td class="align-middle">28</td>
                            <td class="align-middle">29</td>
                            <td class="align-middle">30</td>
                        </tr>
                        <tr>
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
                        </tr>
                        <%
                            } 
                        %>
                    </table>   
                </div>
            </div>
        </div>
        <script>
            $('a.btn-danger').click(function(event){
                event.preventDefault();
                
                var r=confirm("¿Esta seguro que quiere eliminar este registro?");
                if(r== true){
                    window.location = this.href;
                }else{
                    alert("El registro se mantiene intacto");
                }
            });   
        </script>
    </body>
</html>                           