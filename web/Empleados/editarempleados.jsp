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
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Editar Empleados</title>
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
            Modelos.Empleados.clsEmpleado obclsEmpleado = new Modelos.Empleados.clsEmpleado();

            if (request.getAttribute("obclsEmpleado") != null) {
                obclsEmpleado = (Modelos.Empleados.clsEmpleado) request.getAttribute("obclsEmpleado");
            }

            List<Modelos.Empleados.clsEmpleado> lstclsEmpleado = new ArrayList<Modelos.Empleados.clsEmpleado>();

            if (request.getAttribute("lstclsEmpleado") != null) {
                lstclsEmpleado = (List<Modelos.Empleados.clsEmpleado>) request.getAttribute("lstclsEmpleado");
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
                                        <%=obclsEmpleado.getStPrimerNombre()!= null ? obclsEmpleado.getStPrimerNombre(): ""%>
                                         <%=obclsEmpleado.getStSegundoNombre()!= null ? obclsEmpleado.getStSegundoNombre(): ""%>
                                         <%=obclsEmpleado.getStPrimerApellido()!= null ? obclsEmpleado.getStPrimerApellido(): ""%>
                                          <%=obclsEmpleado.getStSegundoApellido()!= null ? obclsEmpleado.getStSegundoApellido(): ""%>
                                    </b>
                                </h5>                                         
                            </div>
                        </div>
                    </div>
                </div>
                <div class="card-body">
                    <form action="empleados" method="POST">
                        <!--FILA-->
                        <div class="form-group">
                            <div class="row">
                                <div class="col-12">
                                    <label for="lblTipoDocumento"><b>Tipo Documento</b></label>
                                    <select class="form-control" name="ddlTipoDocumento">
                                        <%
                                            List<Modelos.Empleados.clsTipoDocumento> lstclsTipoDocumento = new ArrayList<Modelos.Empleados.clsTipoDocumento>();

                                            if (request.getAttribute("lstclsTipoDocumento") != null) {
                                                lstclsTipoDocumento = (List<Modelos.Empleados.clsTipoDocumento>) request.getAttribute("lstclsTipoDocumento");
                                            }

                                            for (Modelos.Empleados.clsTipoDocumento elem : lstclsTipoDocumento) {
                                        %>
                                        <option value="<%=elem.getInId()%>"
                                                <%=obclsEmpleado.getObclsTipoDocumento() != null ? obclsEmpleado.getObclsTipoDocumento().getInId() == elem.getInId() ? "selected" : "" : ""%>>
                                            <%=elem.getStDescripcion()%>
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                                <div class="col-12">
                                    <label for="lblDocumento"><b>Documento</b></label>
                                    <input type="txt" class="form-control" name="txtDocumento"
                                           value="<%=obclsEmpleado.getStDocumento() != null ? obclsEmpleado.getStDocumento() : ""%>"/>
                                </div>
                            </div>
                        </div>
                        <!--FILA-->
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-12">
                                    <label for="lblPrimerNombre"><b>Primer Nombre</b></label>
                                    <input type="text" class="form-control" name="txtPrimerNombre"
                                           value="<%=obclsEmpleado.getStPrimerNombre()!= null ? obclsEmpleado.getStPrimerNombre(): ""%>"/>
                                </div>
                                <div class="col-12">
                                    <label for="lblSegundoNombre"><b>Segundo Nombre</b></label>
                                    <input type="text" class="form-control" name="txtSegundoNombre"
                                           value="<%=obclsEmpleado.getStSegundoNombre()!= null ? obclsEmpleado.getStSegundoNombre(): ""%>"/>
                                </div>
                            </div>
                        </div>
                         <!--FILA-->
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-12">
                                    <label for="lblPrimerApellido"><b>Primer Apellido</b></label>
                                    <input type="text" class="form-control" name="txtPrimerApellido"
                                           value="<%=obclsEmpleado.getStPrimerApellido()!= null ? obclsEmpleado.getStPrimerApellido(): ""%>"/>
                                </div>
                                <div class="col-12">
                                    <label for="lblSegundoApellido"><b>Segundo Apellido</b></label>
                                    <input type="text" class="form-control" name="txtSegundoApellido"
                                           value="<%=obclsEmpleado.getStSegundoApellido()!= null ? obclsEmpleado.getStSegundoApellido(): ""%>"/>
                                </div>
                            </div>
                        </div>        
                        <!--FILA-->       
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-12">
                                    <label for="lblTelefono"><b>Telefono</b></label>
                                    <input type="text" class="form-control" name="txtTelefono"
                                           value="<%=obclsEmpleado.getStTelefono() != null ? obclsEmpleado.getStTelefono() : ""%>"/>
                                </div>
                                <div class="col-12">
                                    <label for="lblCentroCosto"><b>Centro Costos</b></label>
                                    <select class="form-control" name="ddlCentroCosto">
                                        <%
                                            List<Modelos.Empleados.clsCentroCosto> lstclsCentroCosto = new ArrayList<Modelos.Empleados.clsCentroCosto>();
                                            if (request.getAttribute("lstclsCentroCosto") != null) {
                                                lstclsCentroCosto = (List<Modelos.Empleados.clsCentroCosto>) request.getAttribute("lstclsCentroCosto");
                                            }
                                            for (Modelos.Empleados.clsCentroCosto elem : lstclsCentroCosto) {
                                        %>
                                        <option value="<%=elem.getInId()%>"
                                                <%=obclsEmpleado.getObclsCentroCosto() != null ? obclsEmpleado.getObclsCentroCosto().getInId() == elem.getInId() ? "selected" : "" : ""%>>
                                            <%=elem.getStDescripcion()%>
                                        </option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                                <div class="col-12">
                                    <label for="lblCargo"><b>Cargo</b></label>
                                    <select class="form-control" name="ddlCargo">
                                        <%
                                            List<Modelos.Empleados.clsCargo> lstclsCargo = new ArrayList<Modelos.Empleados.clsCargo>();

                                            if (request.getAttribute("lstclsCargo") != null) {
                                                lstclsCargo = (List<Modelos.Empleados.clsCargo>) request.getAttribute("lstclsCargo");
                                            }
                                            for (Modelos.Empleados.clsCargo elem : lstclsCargo) {
                                        %>
                                        <option value="<%=elem.getInId()%>"
                                                <%=obclsEmpleado.getObclsCargo() != null ? obclsEmpleado.getObclsCargo().getInId() == elem.getInId() ? "selected" : "" : ""%>>
                                            <%=elem.getStDescripcion()%>
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
                                    <input type="submit" value="Guardar" class="btn btn-info" name="btnEmplEditar"/>
                                    <input type="text" name="IdModificar" id="IdModificar" value="<%=obclsEmpleado.getInId()%>" hidden=""/>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
