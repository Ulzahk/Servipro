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
        <title>Editar Día 20</title>
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
        <div>    
            <div class="card border-info ">
                <div class="card-header bg-info text-white">                    
                    <div class="form-group">
                        <div class="form-group">
                            <div class="col-12 text-center">                                    
                                <h5 class="align-middle mt-1"> 
                                    <b>
                                        <%=obclsEstadisticas.getObEmpleado().getEmplPrimerNombre() != null ? obclsEstadisticas.getObEmpleado().getEmplPrimerNombre() : ""%>
                                        <%=obclsEstadisticas.getObEmpleado().getEmplSegundoNombre() != null ? obclsEstadisticas.getObEmpleado().getEmplSegundoNombre() : ""%>
                                        <%=obclsEstadisticas.getObEmpleado().getEmplPrimerApellido() != null ? obclsEstadisticas.getObEmpleado().getEmplPrimerApellido() : ""%>
                                        <%=obclsEstadisticas.getObEmpleado().getEmplSegundoApellido() != null ? obclsEstadisticas.getObEmpleado().getEmplSegundoApellido() : ""%>
                                    </b>
                                </h5>                                         
                            </div>
                        </div>
                    </div>
                </div>
                <div class="card-body">
                    <form action="estadisticas" method="POST">                           
                        <!--FILA 1-->
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-12">
                                    <label for="lblDia20"><b>Día 20</b></label>
                                    <select class="form-control" name="ddlDia20">
                                        <%
                                            List<Modelos.Estadisticas.clsId_dia20> lstclsDia20 = new ArrayList<Modelos.Estadisticas.clsId_dia20>();

                                            if (request.getAttribute("lstclsDia20") != null) {
                                                lstclsDia20 = (List<Modelos.Estadisticas.clsId_dia20>) request.getAttribute("lstclsDia20");
                                            }

                                            for (Modelos.Estadisticas.clsId_dia20 elem : lstclsDia20) {
                                        %>
                                        <option value="<%=elem.getId_dia20()%>"
                                                <%=obclsEstadisticas.getObId_dia1() != null ? obclsEstadisticas.getObId_dia20().getId_dia20() == elem.getId_dia20() ? "selected" : "" : ""%>>
                                            <%=elem.getDescripcionDia20()%>(<%=elem.getAliasDia20()%>)
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                            </div>  
                        </div>                        
                        <!--FILA 11-->   
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-12">
                                    <input type="submit" value="Guardar" class="btn btn-info" name="btnEditarEstaDia20"/>
                                    <input type="text" name="IdModificar" id="IdModificar" value="<%=obclsEstadisticas.getId_estadistica()%>" hidden=""/>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
