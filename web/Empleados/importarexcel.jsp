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
                <div class="card-body">
                    <form action="empleados" method="POST">

                        <div class="container p-y-1">
                            <div class="row m-b-1">
                                <div class="col-sm-6 offset-sm-3">
                                    <div class="form-group inputDnD">
                                        <label class="sr-only" for="btnImportarDatos">File Upload</label>
                                        <input type="file" class="form-control-file text-primary font-weight-bold" id="btnImportarDatos" accept="xlsx/*" onchange="readUrl(this)" name="abrir" data-title="Drag and drop a file">
                                    </div>
                                </div>
                            </div>
                        </div>

                        <%
                            String rutaArchivo = null ;
                            System.out.println(rutaArchivo);
                        %>

                        <!--FILA-->   
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-12">
                                    <input type="submit" value="Guardar" class="btn btn-info" name="btnImpoGuardar"/>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
        <script>
        function readUrl(input) {

            if (input.files && input.files[0]) {
                let reader = new FileReader();
                reader.onload = (e) => {
                    let imgData = e.target.result;
                    let imgName = input.files[0].name;
                    rutaArchivo = input.setAttribute("data-title", imgName);
                    console.log(e.target.result);
                }
                reader.readAsDataURL(input.files[0]);
            }

        }
    </script>
</html>
