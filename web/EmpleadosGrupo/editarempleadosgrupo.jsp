<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
        <title>Editar Empleado por Grupo</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
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
                        <div class="col-12 text-center">                                    
                            <h5 class="align-middle mt-1"> 
                                <b><%=obclsEmpleadosGrupo.getObclsGrupo().getNombre_grupo() != null ? obclsEmpleadosGrupo.getObclsGrupo().getNombre_grupo() : ""%></b>
                            </h5>                                         
                        </div>
                    </div>
                </div>
                <div class="card-body">
                    <form action="controlempleadosgrupo" method="POST">
                        <!--FILA-->
                        <div class="form-group">
                            <div class="row">
                                <div class="col-6">
                                    <label for="lblGrupo"><b>Grupo</b></label>
                                    <select class="form-control" name="ddlGrupo">
                                        <%
                                            List<Modelos.EmpleadosGrupo.clsGrupo> lstclsGrupo = new ArrayList<Modelos.EmpleadosGrupo.clsGrupo>();

                                            if (request.getAttribute("lstclsGrupo") != null) {
                                                lstclsGrupo = (List<Modelos.EmpleadosGrupo.clsGrupo>) request.getAttribute("lstclsGrupo");
                                            }

                                            for (Modelos.EmpleadosGrupo.clsGrupo elem : lstclsGrupo) {
                                        %>
                                        <option value="<%=elem.getId_grupo()%>"
                                                <%=obclsEmpleadosGrupo.getObclsGrupo() != null ? obclsEmpleadosGrupo.getObclsGrupo().getId_grupo() == elem.getId_grupo() ? "selected" : "" : ""%>>
                                            <%=elem.getNombre_grupo()%>
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                                <div class="col-6">
                                    <label for="lblEmpleado"><b>Empleado</b></label>
                                    <select class="form-control" name="ddlEmpleado">
                                        <%
                                            List<Modelos.EmpleadosGrupo.clsEmpleado> lstclsEmpleado = new ArrayList<Modelos.EmpleadosGrupo.clsEmpleado>();

                                            if (request.getAttribute("lstclsEmpleado") != null) {
                                                lstclsEmpleado = (List<Modelos.EmpleadosGrupo.clsEmpleado>) request.getAttribute("lstclsEmpleado");
                                            }

                                            for (Modelos.EmpleadosGrupo.clsEmpleado elem : lstclsEmpleado) {
                                        %>
                                        <option value="<%=elem.getEmplId()%>"
                                                <%=obclsEmpleadosGrupo.getObclsEmpleado() != null ? obclsEmpleadosGrupo.getObclsEmpleado().getEmplId() == elem.getEmplId() ? "selected" : "" : ""%>>
                                            <%=elem.getEmplPrimerNombre()%>
                                            <%=elem.getEmplSegundoNombre()%>
                                            <%=elem.getEmplPrimerApellido()%>
                                            <%=elem.getEmplSegundoApellido()%>
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
                                    <input type="submit" value="Guardar" class="btn btn-info" data-toggle="tooltip" title="Haz clic para guardar" name="btnEmplGruEditar"/>
                                    <input type="text" name="IdModificar" id="IdModificar" value="<%=obclsEmpleadosGrupo.getId_empleados_grupo()%>" hidden=""/>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
