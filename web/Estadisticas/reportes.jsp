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
        <title>Reportes</title>
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
                <h1 class="text-center">Reportes</h1>
                <br>
                <div class="card border-dark">
                    <div class="card-header background-card border-dark text-white">
                        <form action="estadisticas" method="post">
                            <div class="input-group">
                                <a href="nomina.htm" class="btn btn-secondary mr-2" data-toggle="tooltip" title="Haz clic para regresar al menú nómina"><i class="fas fa-arrow-left"></i></a>
                                <a href="estadisticas?btnConsultarEstaQuincena1=true" class="btn btn-secondary mr-2" data-toggle="tooltip" title="Haz clic para mostrar la quincena del día 1 al 15"><i class="fas fa-calendar-week"></i></a>
                                <a href="estadisticas?btnConsultarEstaQuincena2=true" class="btn btn-secondary mr-2" data-toggle="tooltip" title="Haz clic para mostrar la quincena del día 16 al 31"><i class="fas fa-calendar-minus"></i></a>
                                <a href="estadisticas?btnAgregarEsta=true" class="btn btn-secondary mr-2" data-toggle="tooltip" title="Haz clic para agregar un nuevo registro" title="Haz clic para agregar un registro" ><i class="fas fa-plus-circle"> <label class="coloriphonex tipoLetraLabel">Agregar</label></i></a>
                            </div>                        
                        </form>
                    </div>
                    <div class="card-body">
                        <form action="estadisticas" method="POST">
                            <table class="table table-fluid table table-bordered table-striped table-hover text-center table-responsive" id="myTable">
                                <thead>
                                    <tr>
                                        <th class="align-middle">Empleado</th>
                                        <th class="align-middle">A&ntilde;o</th>
                                        <th class="align-middle">Mes</th>
                                        <%
                                            List<Modelos.Configuracion.clsConfiguracion> lstclsConfiguracion = new ArrayList<Modelos.Configuracion.clsConfiguracion>();
                                            try {
                                                ResultSet rs = null;
                                                PreparedStatement ps = conn.prepareStatement("{call spConsultarConfiguracion}");
                                                rs = ps.executeQuery();

                                                while (rs.next()) {
                                                    Modelos.Configuracion.clsConfiguracion obclsConfiguracion = new Modelos.Configuracion.clsConfiguracion();
                                                    obclsConfiguracion.setId_configuracion(rs.getInt("Id_configuracion"));
                                                    obclsConfiguracion.setNombre_configuracion(rs.getString("Desconfiguracion"));
                                                    obclsConfiguracion.setDescripcion_configuracion(rs.getString("Desconfiguracion_d"));
                                                    obclsConfiguracion.setNombre_variable(rs.getString("Nombre_variable"));
                                                    obclsConfiguracion.setValor(rs.getInt("Valor"));

                                                    Modelos.Configuracion.clsModulo obclsModulo = new Modelos.Configuracion.clsModulo();
                                                    obclsModulo.setId_modulo(rs.getInt("Id_modulo"));
                                                    obclsModulo.setNombre_modulo(rs.getString("Nombre_modulo"));
                                                    obclsConfiguracion.setObclsModulo(obclsModulo);

                                                    lstclsConfiguracion.add(obclsConfiguracion);
                                                }
                                            } catch (Exception ex) {

                                            }
                                            int quincena1 = 0;
                                            int quincena2 = 0;

                                            for (Modelos.Configuracion.clsConfiguracion elem : lstclsConfiguracion) {

                                                if (elem.getId_configuracion() == 1) {
                                                    quincena1 = elem.getValor();
                                                } else if (elem.getId_configuracion() == 2) {
                                                    quincena2 = elem.getValor();
                                                }
                                            }
                                            int conUno = 1;
                                            int numUno = 1;

                                            Calendar fecha = Calendar.getInstance();

                                            int año = fecha.get(Calendar.YEAR);
                                            int mes = (fecha.get(Calendar.MONTH) + 1);
                                            int dias = 0;
                                            String nombreMes = "";

                                            switch (mes) {
                                                case 1:
                                                    nombreMes = "ENERO";
                                                    dias = 31;
                                                    break;
                                                case 2:
                                                    nombreMes = "FEBRERO";
                                                    if ((año % 4 == 0 && año % 100 != 0) || (año % 400 == 0)) {
                                                        dias = 29;
                                                        break;
                                                    } else {
                                                        dias = 28;
                                                        break;
                                                    }

                                                case 3:
                                                    nombreMes = "MARZO";
                                                    dias = 31;
                                                    break;
                                                case 4:
                                                    nombreMes = "ABRIL";
                                                    dias = 30;
                                                    break;
                                                case 5:
                                                    nombreMes = "MAYO";
                                                    dias = 31;
                                                    break;
                                                case 6:
                                                    nombreMes = "JUNIO";
                                                    dias = 30;
                                                    break;
                                                case 7:
                                                    nombreMes = "JULIO";
                                                    dias = 31;
                                                    break;
                                                case 8:
                                                    nombreMes = "AGOSTO";
                                                    dias = 31;
                                                    break;
                                                case 9:
                                                    nombreMes = "SEPTIEMBRE";
                                                    dias = 30;
                                                    break;
                                                case 10:
                                                    nombreMes = "OCTUBRE";
                                                    dias = 31;
                                                    break;
                                                case 11:
                                                    nombreMes = "NOVIEMBRE";
                                                    dias = 30;
                                                    break;
                                                case 12:
                                                    nombreMes = "DICIEMBRE";
                                                    dias = 31;
                                                    break;
                                                default:
                                                    out.print("No existe ese mes");
                                            }

                                            int intervaloEntreQuincenas = quincena1 - quincena2;

                                            if (intervaloEntreQuincenas < 0) {
                                                intervaloEntreQuincenas = intervaloEntreQuincenas * -1;
                                            }
                                            //Condiciones para meses con días diferentes a 30
                                            if (intervaloEntreQuincenas == 15) {
                                                if (dias < 30) {
                                                    intervaloEntreQuincenas = intervaloEntreQuincenas - 1;
                                                } else if (dias < 29) {
                                                    intervaloEntreQuincenas = (intervaloEntreQuincenas - 2);
                                                } else if (dias > 30) {
                                                    intervaloEntreQuincenas = (intervaloEntreQuincenas + 1);
                                                }
                                            }

                                            for (int f = (quincena2 + 1); conUno <= intervaloEntreQuincenas; conUno++) {

                                                if (f <= dias) {
                                        %>
                                    <th class="align-middle"><%=f%></th>
                                        <%
                                            f++;
                                        } else {
                                        %>
                                    <th class="align-middle"><%=numUno%></th>                                
                                        <%
                                                    numUno++;
                                                }
                                            }
                                        %>
                                    <th class="align-middle">Comentar</th>
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

                                    List<Modelos.Empleados.clsEmpleado> lstclsEmpleado = new ArrayList<Modelos.Empleados.clsEmpleado>();

                                    try {
                                        ResultSet rs = null;
                                        PreparedStatement ps = conn.prepareStatement("{call spConsultarEmpleado}");

                                        rs = ps.executeQuery();

                                        while (rs.next()) {
                                            Modelos.Empleados.clsEmpleado obclsEmpleado = new Modelos.Empleados.clsEmpleado();
                                            obclsEmpleado.setInId(rs.getInt("emplId"));

                                            Modelos.Empleados.clsTipoDocumento obclsTipoDocumento = new Modelos.Empleados.clsTipoDocumento();
                                            obclsTipoDocumento.setInId(rs.getInt("tidoId"));
                                            obclsTipoDocumento.setStDescripcion(rs.getString("tidoDescripcion"));
                                            obclsEmpleado.setObclsTipoDocumento(obclsTipoDocumento);

                                            obclsEmpleado.setStDocumento(rs.getString("emplDocumento"));
                                            obclsEmpleado.setStPrimerNombre(rs.getString("emplPrimerNombre"));
                                            obclsEmpleado.setStSegundoNombre(rs.getString("emplSegundoNombre"));
                                            obclsEmpleado.setStPrimerApellido(rs.getString("emplPrimerApellido"));
                                            obclsEmpleado.setStSegundoApellido(rs.getString("emplSegundoApellido"));
                                            obclsEmpleado.setStTelefono(rs.getString("emplTelefono"));

                                            Modelos.Empleados.clsCentroCosto obclsCentroCosto = new Modelos.Empleados.clsCentroCosto();
                                            obclsCentroCosto.setInId(rs.getInt("cecoId"));
                                            obclsCentroCosto.setStDescripcion(rs.getString("Nombre_ccostos"));
                                            obclsEmpleado.setObclsCentroCosto(obclsCentroCosto);

                                            Modelos.Empleados.clsCargo obclsCargo = new Modelos.Empleados.clsCargo();
                                            obclsCargo.setInId(rs.getInt("cargId"));
                                            obclsCargo.setStDescripcion(rs.getString("Descripcion_cargo"));
                                            obclsEmpleado.setObclsCargo(obclsCargo);

                                            Modelos.Empleados.clsGrupoEmpl obclsGrupoEmpl = new Modelos.Empleados.clsGrupoEmpl();
                                            obclsGrupoEmpl.setId_grupo(rs.getInt("Id_grupo"));
                                            obclsEmpleado.setObclsGrupoEmpl(obclsGrupoEmpl);

                                            lstclsEmpleado.add(obclsEmpleado);
                                        }

                                    } catch (Exception ex) {
                                    }

                                    for (Modelos.Estadisticas.clsEstadisticas elem : lstclsEstadisticasGrupo) {

                                        GrupoEmpl = elem.getObGrupoEmpl().getId_grupo();

                                    }

                                    if (Descripcion_perfil.equals("JEFE")) {
                                        for (Modelos.Empleados.clsEmpleado elemA : lstclsEmpleado) {

                                %>
                                <!--Input Oculto Tamaño de la Lista-->
                            <input type="text" hidden="" name="extensionLista" value="<%=lstclsEmpleado.size()%>"/>

                            <input type="text" hidden="" name="idEmpleadoN" id="idEmpleadoN" value="<%=elemA.getInId()%>"/>

                            <!-- Modal 1 -->
                            <div class="modal fade" id="myModal1-<%=elemA.getInId()%>" role="dialog">
                                <div class="modal-dialog">
                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header background-card">
                                            <button type="button" class="close" data-dismiss="modal">X</button>
                                        </div>
                                        <div class="modal-body">
                                            <!--FILA 1-->
                                            <div class="form-group">
                                                <label for="lblDia1"><b>Día 1</b></label>
                                                <select class="form-control" id="ddlDia1-<%=elemA.getInId()%>"  name="ddlDia1-<%=elemA.getInId()%>">
                                                    <%                                                        List<Modelos.Estadisticas.clsId_dia1> lstclsDia1 = new ArrayList<Modelos.Estadisticas.clsId_dia1>();

                                                        if (request.getAttribute("lstclsDia1") != null) {
                                                            lstclsDia1 = (List<Modelos.Estadisticas.clsId_dia1>) request.getAttribute("lstclsDia1");
                                                        }

                                                        for (Modelos.Estadisticas.clsId_dia1 elem : lstclsDia1) {
                                                    %>
                                                    <option id="aliasInicialDia1-<%=elemA.getInId()%>" value="<%=elem.getId_dia1()%>"
                                                            <%=obclsEstadisticas.getObId_dia1() != null ? obclsEstadisticas.getObId_dia1().getId_dia1() == elem.getId_dia1() ? "selected" : "" : ""%>>
                                                        <%=elem.getDescripcionDia1()%>(<%=elem.getAliasDia1()%>)
                                                    </option>
                                                    <%
                                                        }
                                                    %>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" id="buttonCloseID1" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- Modal 2 -->
                            <div class="modal fade" id="myModal2-<%=elemA.getInId()%>" role="dialog">
                                <div class="modal-dialog">
                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header background-card">
                                            <button type="button" class="close" data-dismiss="modal">X</button>
                                        </div>
                                        <div class="modal-body">
                                            <!--FILA 1-->
                                            <div class="form-group">
                                                <label for="lblDia2"><b>Día 2</b></label>
                                                <select class="form-control" id="ddlDia2-<%=elemA.getInId()%>" name="ddlDia2-<%=elemA.getInId()%>">
                                                    <%
                                                        List<Modelos.Estadisticas.clsId_dia2> lstclsDia2 = new ArrayList<Modelos.Estadisticas.clsId_dia2>();

                                                        if (request.getAttribute("lstclsDia2") != null) {
                                                            lstclsDia2 = (List<Modelos.Estadisticas.clsId_dia2>) request.getAttribute("lstclsDia2");
                                                        }

                                                        for (Modelos.Estadisticas.clsId_dia2 elem : lstclsDia2) {
                                                    %>
                                                    <option id="aliasInicialDia2-<%=elemA.getInId()%>" value="<%=elem.getId_dia2()%>"
                                                            <%=obclsEstadisticas.getObId_dia2() != null ? obclsEstadisticas.getObId_dia2().getId_dia2() == elem.getId_dia2() ? "selected" : "" : ""%>>
                                                        <%=elem.getDescripcionDia2()%>(<%=elem.getAliasDia2()%>)
                                                    </option>
                                                    <%
                                                        }
                                                    %>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" id="buttonCloseID2" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- Modal 3 -->
                            <div class="modal fade" id="myModal3-<%=elemA.getInId()%>" role="dialog">
                                <div class="modal-dialog">
                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header background-card">
                                            <button type="button" class="close" data-dismiss="modal">X</button>
                                        </div>
                                        <div class="modal-body">
                                            <!--FILA 1-->
                                            <div class="form-group">
                                                <label for="lblDia3"><b>Día 3</b></label>
                                                <select class="form-control" id="ddlDia3-<%=elemA.getInId()%>" name="ddlDia3-<%=elemA.getInId()%>">
                                                    <%
                                                        List<Modelos.Estadisticas.clsId_dia3> lstclsDia3 = new ArrayList<Modelos.Estadisticas.clsId_dia3>();

                                                        if (request.getAttribute("lstclsDia3") != null) {
                                                            lstclsDia3 = (List<Modelos.Estadisticas.clsId_dia3>) request.getAttribute("lstclsDia3");
                                                        }

                                                        for (Modelos.Estadisticas.clsId_dia3 elem : lstclsDia3) {
                                                    %>
                                                    <option id="aliasInicialDia3-<%=elemA.getInId()%>" value="<%=elem.getId_dia3()%>"
                                                            <%=obclsEstadisticas.getObId_dia3() != null ? obclsEstadisticas.getObId_dia3().getId_dia3() == elem.getId_dia3() ? "selected" : "" : ""%>>
                                                        <%=elem.getDescripcionDia3()%>(<%=elem.getAliasDia3()%>)
                                                    </option>
                                                    <%
                                                        }
                                                    %>
                                                </select>  
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" id="buttonCloseID3" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- Modal 4 -->
                            <div class="modal fade" id="myModal4-<%=elemA.getInId()%>" role="dialog">
                                <div class="modal-dialog">
                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header background-card">
                                            <button type="button" class="close" data-dismiss="modal">X</button>
                                        </div>
                                        <div class="modal-body">
                                            <!--FILA 1-->
                                            <div class="form-group">
                                                <label for="lblDia4"><b>Día 4</b></label>
                                                <select class="form-control" id="ddlDia4-<%=elemA.getInId()%>" name="ddlDia4-<%=elemA.getInId()%>">
                                                    <%
                                                        List<Modelos.Estadisticas.clsId_dia4> lstclsDia4 = new ArrayList<Modelos.Estadisticas.clsId_dia4>();

                                                        if (request.getAttribute("lstclsDia4") != null) {
                                                            lstclsDia4 = (List<Modelos.Estadisticas.clsId_dia4>) request.getAttribute("lstclsDia4");
                                                        }

                                                        for (Modelos.Estadisticas.clsId_dia4 elem : lstclsDia4) {
                                                    %>
                                                    <option id="aliasInicialDia4-<%=elemA.getInId()%>"  value="<%=elem.getId_dia4()%>"
                                                            <%=obclsEstadisticas.getObId_dia4() != null ? obclsEstadisticas.getObId_dia4().getId_dia4() == elem.getId_dia4() ? "selected" : "" : ""%>>
                                                        <%=elem.getDescripcionDia4()%>(<%=elem.getAliasDia4()%>)
                                                    </option>
                                                    <%
                                                        }
                                                    %>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" id="buttonCloseID4" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- Modal 5 -->
                            <div class="modal fade" id="myModal5-<%=elemA.getInId()%>" role="dialog">
                                <div class="modal-dialog">
                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header background-card">
                                            <button type="button" class="close" data-dismiss="modal">X</button>
                                        </div>
                                        <div class="modal-body">
                                            <!--FILA 1-->
                                            <div class="form-group">
                                                <label for="lblDia5"><b>Día 5</b></label>
                                                <select class="form-control" id="ddlDia5-<%=elemA.getInId()%>" name="ddlDia5-<%=elemA.getInId()%>">
                                                    <%
                                                        List<Modelos.Estadisticas.clsId_dia5> lstclsDia5 = new ArrayList<Modelos.Estadisticas.clsId_dia5>();

                                                        if (request.getAttribute("lstclsDia5") != null) {
                                                            lstclsDia5 = (List<Modelos.Estadisticas.clsId_dia5>) request.getAttribute("lstclsDia5");
                                                        }

                                                        for (Modelos.Estadisticas.clsId_dia5 elem : lstclsDia5) {
                                                    %>
                                                    <option id="aliasInicialDia5-<%=elemA.getInId()%>" value="<%=elem.getId_dia5()%>"
                                                            <%=obclsEstadisticas.getObId_dia5() != null ? obclsEstadisticas.getObId_dia5().getId_dia5() == elem.getId_dia5() ? "selected" : "" : ""%>>
                                                        <%=elem.getDescripcionDia5()%>(<%=elem.getAliasDia5()%>)
                                                    </option>
                                                    <%
                                                        }
                                                    %>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" id="buttonCloseID5" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- Modal 6 -->
                            <div class="modal fade" id="myModal6-<%=elemA.getInId()%>" role="dialog">
                                <div class="modal-dialog">
                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header background-card">
                                            <button type="button" class="close" data-dismiss="modal">X</button>
                                        </div>
                                        <div class="modal-body">
                                            <!--FILA 1-->
                                            <div class="form-group">
                                                <label for="lblDia6"><b>Día 6</b></label>
                                                <select class="form-control" id="ddlDia6-<%=elemA.getInId()%>" name="ddlDia6-<%=elemA.getInId()%>">
                                                    <%
                                                        List<Modelos.Estadisticas.clsId_dia6> lstclsDia6 = new ArrayList<Modelos.Estadisticas.clsId_dia6>();

                                                        if (request.getAttribute("lstclsDia6") != null) {
                                                            lstclsDia6 = (List<Modelos.Estadisticas.clsId_dia6>) request.getAttribute("lstclsDia6");
                                                        }

                                                        for (Modelos.Estadisticas.clsId_dia6 elem : lstclsDia6) {
                                                    %>
                                                    <option id="aliasInicialDia6-<%=elemA.getInId()%>" value="<%=elem.getId_dia6()%>"
                                                            <%=obclsEstadisticas.getObId_dia6() != null ? obclsEstadisticas.getObId_dia6().getId_dia6() == elem.getId_dia6() ? "selected" : "" : ""%>>
                                                        <%=elem.getDescripcionDia6()%>(<%=elem.getAliasDia6()%>)
                                                    </option>
                                                    <%
                                                        }
                                                    %>
                                                </select> 
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" id="buttonCloseID6" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- Modal 7 -->
                            <div class="modal fade" id="myModal7-<%=elemA.getInId()%>" role="dialog">
                                <div class="modal-dialog">
                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header background-card">
                                            <button type="button" class="close" data-dismiss="modal">X</button>
                                        </div>
                                        <div class="modal-body">
                                            <!--FILA 1-->
                                            <div class="form-group">
                                                <label for="lblDia7"><b>Día 7</b></label>
                                                <select class="form-control" id="ddlDia7-<%=elemA.getInId()%>" name="ddlDia7-<%=elemA.getInId()%>">
                                                    <%
                                                        List<Modelos.Estadisticas.clsId_dia7> lstclsDia7 = new ArrayList<Modelos.Estadisticas.clsId_dia7>();

                                                        if (request.getAttribute("lstclsDia7") != null) {
                                                            lstclsDia7 = (List<Modelos.Estadisticas.clsId_dia7>) request.getAttribute("lstclsDia7");
                                                        }

                                                        for (Modelos.Estadisticas.clsId_dia7 elem : lstclsDia7) {
                                                    %>
                                                    <option id="aliasInicialDia7-<%=elemA.getInId()%>" value="<%=elem.getId_dia7()%>"
                                                            <%=obclsEstadisticas.getObId_dia7() != null ? obclsEstadisticas.getObId_dia7().getId_dia7() == elem.getId_dia7() ? "selected" : "" : ""%>>
                                                        <%=elem.getDescripcionDia7()%>(<%=elem.getAliasDia7()%>)
                                                    </option>
                                                    <%
                                                        }
                                                    %>
                                                </select> 
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" id="buttonCloseID7" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- Modal 8 -->
                            <div class="modal fade" id="myModal8-<%=elemA.getInId()%>" role="dialog">
                                <div class="modal-dialog">
                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header background-card">
                                            <button type="button" class="close" data-dismiss="modal">X</button>
                                        </div>
                                        <div class="modal-body">
                                            <!--FILA 1-->
                                            <div class="form-group">
                                                <label for="lblDia8"><b>Día 8</b></label>
                                                <select class="form-control" id="ddlDia8-<%=elemA.getInId()%>" name="ddlDia8-<%=elemA.getInId()%>">
                                                    <%
                                                        List<Modelos.Estadisticas.clsId_dia8> lstclsDia8 = new ArrayList<Modelos.Estadisticas.clsId_dia8>();

                                                        if (request.getAttribute("lstclsDia8") != null) {
                                                            lstclsDia8 = (List<Modelos.Estadisticas.clsId_dia8>) request.getAttribute("lstclsDia8");
                                                        }

                                                        for (Modelos.Estadisticas.clsId_dia8 elem : lstclsDia8) {
                                                    %>
                                                    <option id="aliasInicialDia8-<%=elemA.getInId()%>" value="<%=elem.getId_dia8()%>"
                                                            <%=obclsEstadisticas.getObId_dia8() != null ? obclsEstadisticas.getObId_dia8().getId_dia8() == elem.getId_dia8() ? "selected" : "" : ""%>>
                                                        <%=elem.getDescripcionDia8()%>(<%=elem.getAliasDia8()%>)
                                                    </option>
                                                    <%
                                                        }
                                                    %>
                                                </select> 
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" id="buttonCloseID8" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- Modal 9 -->
                            <div class="modal fade" id="myModal9-<%=elemA.getInId()%>" role="dialog">
                                <div class="modal-dialog">
                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header background-card">
                                            <button type="button" class="close" data-dismiss="modal">X</button>
                                        </div>
                                        <div class="modal-body">
                                            <!--FILA 1-->
                                            <div class="form-group">
                                                <label for="lblDia9"><b>Día 9</b></label>
                                                <select class="form-control" id="ddlDia9-<%=elemA.getInId()%>" name="ddlDia9-<%=elemA.getInId()%>">
                                                    <%
                                                        List<Modelos.Estadisticas.clsId_dia9> lstclsDia9 = new ArrayList<Modelos.Estadisticas.clsId_dia9>();

                                                        if (request.getAttribute("lstclsDia9") != null) {
                                                            lstclsDia9 = (List<Modelos.Estadisticas.clsId_dia9>) request.getAttribute("lstclsDia9");
                                                        }

                                                        for (Modelos.Estadisticas.clsId_dia9 elem : lstclsDia9) {
                                                    %>
                                                    <option id="aliasInicialDia9-<%=elemA.getInId()%>" value="<%=elem.getId_dia9()%>"
                                                            <%=obclsEstadisticas.getObId_dia9() != null ? obclsEstadisticas.getObId_dia9().getId_dia9() == elem.getId_dia9() ? "selected" : "" : ""%>>
                                                        <%=elem.getDescripcionDia9()%>(<%=elem.getAliasDia9()%>)
                                                    </option>
                                                    <%
                                                        }
                                                    %>
                                                </select>  
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" id="buttonCloseID9" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- Modal 10 -->
                            <div class="modal fade" id="myModal10-<%=elemA.getInId()%>" role="dialog">
                                <div class="modal-dialog">
                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header background-card">
                                            <button type="button" class="close" data-dismiss="modal">X</button>
                                        </div>
                                        <div class="modal-body">
                                            <!--FILA 1-->
                                            <div class="form-group">
                                                <label for="lblDia10"><b>Día 10</b></label>
                                                <select class="form-control" id="ddlDia10-<%=elemA.getInId()%>" name="ddlDia10-<%=elemA.getInId()%>">
                                                    <%
                                                        List<Modelos.Estadisticas.clsId_dia10> lstclsDia10 = new ArrayList<Modelos.Estadisticas.clsId_dia10>();

                                                        if (request.getAttribute("lstclsDia10") != null) {
                                                            lstclsDia10 = (List<Modelos.Estadisticas.clsId_dia10>) request.getAttribute("lstclsDia10");
                                                        }

                                                        for (Modelos.Estadisticas.clsId_dia10 elem : lstclsDia10) {
                                                    %>
                                                    <option id="aliasInicialDia10-<%=elemA.getInId()%>" value="<%=elem.getId_dia10()%>"
                                                            <%=obclsEstadisticas.getObId_dia10() != null ? obclsEstadisticas.getObId_dia10().getId_dia10() == elem.getId_dia10() ? "selected" : "" : ""%>>
                                                        <%=elem.getDescripcionDia10()%>(<%=elem.getAliasDia10()%>)
                                                    </option>
                                                    <%
                                                        }
                                                    %>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" id="buttonCloseID10" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- Modal 11 -->
                            <div class="modal fade" id="myModal11-<%=elemA.getInId()%>" role="dialog">
                                <div class="modal-dialog">
                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header background-card">
                                            <button type="button" class="close" data-dismiss="modal">X</button>
                                        </div>
                                        <div class="modal-body">
                                            <!--FILA 1-->
                                            <div class="form-group">
                                                <label for="lblDia11"><b>Día 11</b></label>
                                                <select class="form-control" id="ddlDia11-<%=elemA.getInId()%>" name="ddlDia11-<%=elemA.getInId()%>">
                                                    <%
                                                        List<Modelos.Estadisticas.clsId_dia11> lstclsDia11 = new ArrayList<Modelos.Estadisticas.clsId_dia11>();

                                                        if (request.getAttribute("lstclsDia11") != null) {
                                                            lstclsDia11 = (List<Modelos.Estadisticas.clsId_dia11>) request.getAttribute("lstclsDia11");
                                                        }

                                                        for (Modelos.Estadisticas.clsId_dia11 elem : lstclsDia11) {
                                                    %>
                                                    <option id="aliasInicialDia11-<%=elemA.getInId()%>" value="<%=elem.getId_dia11()%>"
                                                            <%=obclsEstadisticas.getObId_dia11() != null ? obclsEstadisticas.getObId_dia11().getId_dia11() == elem.getId_dia11() ? "selected" : "" : ""%>>
                                                        <%=elem.getDescripcionDia11()%>(<%=elem.getAliasDia11()%>)
                                                    </option>
                                                    <%
                                                        }
                                                    %>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" id="buttonCloseID11" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- Modal 12 -->
                            <div class="modal fade" id="myModal12-<%=elemA.getInId()%>" role="dialog">
                                <div class="modal-dialog">
                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header background-card">
                                            <button type="button" class="close" data-dismiss="modal">X</button>
                                        </div>
                                        <div class="modal-body">
                                            <!--FILA 1-->
                                            <div class="form-group">
                                                <label for="lblDia12"><b>Día 12</b></label>
                                                <select class="form-control" id="ddlDia12-<%=elemA.getInId()%>" name="ddlDia12-<%=elemA.getInId()%>">
                                                    <%
                                                        List<Modelos.Estadisticas.clsId_dia12> lstclsDia12 = new ArrayList<Modelos.Estadisticas.clsId_dia12>();

                                                        if (request.getAttribute("lstclsDia12") != null) {
                                                            lstclsDia12 = (List<Modelos.Estadisticas.clsId_dia12>) request.getAttribute("lstclsDia12");
                                                        }

                                                        for (Modelos.Estadisticas.clsId_dia12 elem : lstclsDia12) {
                                                    %>
                                                    <option id="aliasInicialDia12-<%=elemA.getInId()%>" value="<%=elem.getId_dia12()%>"
                                                            <%=obclsEstadisticas.getObId_dia12() != null ? obclsEstadisticas.getObId_dia12().getId_dia12() == elem.getId_dia12() ? "selected" : "" : ""%>>
                                                        <%=elem.getDescripcionDia12()%>(<%=elem.getAliasDia12()%>)
                                                    </option>
                                                    <%
                                                        }
                                                    %>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" id="buttonCloseID12" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- Modal 13 -->
                            <div class="modal fade" id="myModal13-<%=elemA.getInId()%>" role="dialog">
                                <div class="modal-dialog">
                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header background-card">
                                            <button type="button" class="close" data-dismiss="modal">X</button>
                                        </div>
                                        <div class="modal-body">
                                            <!--FILA 1-->
                                            <div class="form-group">
                                                <label for="lblDia13"><b>Día 13</b></label>
                                                <select class="form-control" id="ddlDia13-<%=elemA.getInId()%>" name="ddlDia13-<%=elemA.getInId()%>">
                                                    <%
                                                        List<Modelos.Estadisticas.clsId_dia13> lstclsDia13 = new ArrayList<Modelos.Estadisticas.clsId_dia13>();

                                                        if (request.getAttribute("lstclsDia13") != null) {
                                                            lstclsDia13 = (List<Modelos.Estadisticas.clsId_dia13>) request.getAttribute("lstclsDia13");
                                                        }

                                                        for (Modelos.Estadisticas.clsId_dia13 elem : lstclsDia13) {
                                                    %>
                                                    <option id="aliasInicialDia13-<%=elemA.getInId()%>" value="<%=elem.getId_dia13()%>"
                                                            <%=obclsEstadisticas.getObId_dia13() != null ? obclsEstadisticas.getObId_dia13().getId_dia13() == elem.getId_dia13() ? "selected" : "" : ""%>>
                                                        <%=elem.getDescripcionDia13()%>(<%=elem.getAliasDia13()%>)
                                                    </option>
                                                    <%
                                                        }
                                                    %>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" id="buttonCloseID13" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- Modal 14 -->
                            <div class="modal fade" id="myModal14-<%=elemA.getInId()%>" role="dialog">
                                <div class="modal-dialog">
                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header background-card">
                                            <button type="button" class="close" data-dismiss="modal">X</button>
                                        </div>
                                        <div class="modal-body">
                                            <!--FILA 1-->
                                            <div class="form-group">
                                                <label for="lblDia14"><b>Día 14</b></label>
                                                <select class="form-control" id="ddlDia14-<%=elemA.getInId()%>" name="ddlDia14-<%=elemA.getInId()%>">
                                                    <%
                                                        List<Modelos.Estadisticas.clsId_dia14> lstclsDia14 = new ArrayList<Modelos.Estadisticas.clsId_dia14>();

                                                        if (request.getAttribute("lstclsDia14") != null) {
                                                            lstclsDia14 = (List<Modelos.Estadisticas.clsId_dia14>) request.getAttribute("lstclsDia14");
                                                        }

                                                        for (Modelos.Estadisticas.clsId_dia14 elem : lstclsDia14) {
                                                    %>
                                                    <option id="aliasInicialDia14-<%=elemA.getInId()%>" value="<%=elem.getId_dia14()%>"
                                                            <%=obclsEstadisticas.getObId_dia14() != null ? obclsEstadisticas.getObId_dia14().getId_dia14() == elem.getId_dia14() ? "selected" : "" : ""%>>
                                                        <%=elem.getDescripcionDia14()%>(<%=elem.getAliasDia14()%>)
                                                    </option>
                                                    <%
                                                        }
                                                    %>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" id="buttonCloseID14" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- Modal 15 -->
                            <div class="modal fade" id="myModal15-<%=elemA.getInId()%>" role="dialog">
                                <div class="modal-dialog">
                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header background-card">
                                            <button type="button" class="close" data-dismiss="modal">X</button>
                                        </div>
                                        <div class="modal-body">
                                            <!--FILA 1-->
                                            <div class="form-group">
                                                <label for="lblDia15"><b>Día 15</b></label>
                                                <select class="form-control" id="ddlDia15-<%=elemA.getInId()%>" name="ddlDia15-<%=elemA.getInId()%>">
                                                    <%
                                                        List<Modelos.Estadisticas.clsId_dia15> lstclsDia15 = new ArrayList<Modelos.Estadisticas.clsId_dia15>();

                                                        if (request.getAttribute("lstclsDia15") != null) {
                                                            lstclsDia15 = (List<Modelos.Estadisticas.clsId_dia15>) request.getAttribute("lstclsDia15");
                                                        }

                                                        for (Modelos.Estadisticas.clsId_dia15 elem : lstclsDia15) {
                                                    %>
                                                    <option id="aliasInicialDia15-<%=elemA.getInId()%>" value="<%=elem.getId_dia15()%>"
                                                            <%=obclsEstadisticas.getObId_dia15() != null ? obclsEstadisticas.getObId_dia15().getId_dia15() == elem.getId_dia15() ? "selected" : "" : ""%>>
                                                        <%=elem.getDescripcionDia15()%>(<%=elem.getAliasDia15()%>)
                                                    </option>
                                                    <%
                                                        }
                                                    %>
                                                </select> 
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" id="buttonCloseID15" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- Modal 16 -->
                            <div class="modal fade" id="myModal16-<%=elemA.getInId()%>" role="dialog">
                                <div class="modal-dialog">
                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header background-card">
                                            <button type="button" class="close" data-dismiss="modal">X</button>
                                        </div>
                                        <div class="modal-body">
                                            <!--FILA 1-->
                                            <div class="form-group">
                                                <label for="lblDia16"><b>Día 16</b></label>
                                                <select class="form-control" id="ddlDia16-<%=elemA.getInId()%>" name="ddlDia16-<%=elemA.getInId()%>">
                                                    <%
                                                        List<Modelos.Estadisticas.clsId_dia16> lstclsDia16 = new ArrayList<Modelos.Estadisticas.clsId_dia16>();

                                                        if (request.getAttribute("lstclsDia16") != null) {
                                                            lstclsDia16 = (List<Modelos.Estadisticas.clsId_dia16>) request.getAttribute("lstclsDia16");
                                                        }

                                                        for (Modelos.Estadisticas.clsId_dia16 elem : lstclsDia16) {
                                                    %>
                                                    <option id="aliasInicialDia16-<%=elemA.getInId()%>" value="<%=elem.getId_dia16()%>"
                                                            <%=obclsEstadisticas.getObId_dia16() != null ? obclsEstadisticas.getObId_dia16().getId_dia16() == elem.getId_dia16() ? "selected" : "" : ""%>>
                                                        <%=elem.getDescripcionDia16()%>(<%=elem.getAliasDia16()%>)
                                                    </option>
                                                    <%
                                                        }
                                                    %>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" id="buttonCloseID16" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- Modal 17 -->
                            <div class="modal fade" id="myModal17-<%=elemA.getInId()%>" role="dialog">
                                <div class="modal-dialog">
                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header background-card">
                                            <button type="button" class="close" data-dismiss="modal">X</button>
                                        </div>
                                        <div class="modal-body">
                                            <!--FILA 1-->
                                            <div class="form-group">
                                                <label for="lblDia17"><b>Día 17</b></label>
                                                <select class="form-control" id="ddlDia17-<%=elemA.getInId()%>" name="ddlDia17-<%=elemA.getInId()%>">
                                                    <%
                                                        List<Modelos.Estadisticas.clsId_dia17> lstclsDia17 = new ArrayList<Modelos.Estadisticas.clsId_dia17>();

                                                        if (request.getAttribute("lstclsDia17") != null) {
                                                            lstclsDia17 = (List<Modelos.Estadisticas.clsId_dia17>) request.getAttribute("lstclsDia17");
                                                        }

                                                        for (Modelos.Estadisticas.clsId_dia17 elem : lstclsDia17) {
                                                    %>
                                                    <option id="aliasInicialDia17-<%=elemA.getInId()%>" value="<%=elem.getId_dia17()%>"
                                                            <%=obclsEstadisticas.getObId_dia17() != null ? obclsEstadisticas.getObId_dia17().getId_dia17() == elem.getId_dia17() ? "selected" : "" : ""%>>
                                                        <%=elem.getDescripcionDia17()%>(<%=elem.getAliasDia17()%>)
                                                    </option>
                                                    <%
                                                        }
                                                    %>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" id="buttonCloseID17" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- Modal 18 -->
                            <div class="modal fade" id="myModal18-<%=elemA.getInId()%>" role="dialog">
                                <div class="modal-dialog">
                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header background-card">
                                            <button type="button" class="close" data-dismiss="modal">X</button>
                                        </div>
                                        <div class="modal-body">
                                            <!--FILA 1-->
                                            <div class="form-group">
                                                <label for="lblDia18"><b>Día 18</b></label>
                                                <select class="form-control" id="ddlDia18-<%=elemA.getInId()%>" name="ddlDia18-<%=elemA.getInId()%>">
                                                    <%
                                                        List<Modelos.Estadisticas.clsId_dia18> lstclsDia18 = new ArrayList<Modelos.Estadisticas.clsId_dia18>();

                                                        if (request.getAttribute("lstclsDia18") != null) {
                                                            lstclsDia18 = (List<Modelos.Estadisticas.clsId_dia18>) request.getAttribute("lstclsDia18");
                                                        }

                                                        for (Modelos.Estadisticas.clsId_dia18 elem : lstclsDia18) {
                                                    %>
                                                    <option id="aliasInicialDia18-<%=elemA.getInId()%>" value="<%=elem.getId_dia18()%>"
                                                            <%=obclsEstadisticas.getObId_dia18() != null ? obclsEstadisticas.getObId_dia18().getId_dia18() == elem.getId_dia18() ? "selected" : "" : ""%>>
                                                        <%=elem.getDescripcionDia18()%>(<%=elem.getAliasDia18()%>)
                                                    </option>
                                                    <%
                                                        }
                                                    %>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" id="buttonCloseID18" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- Modal 19 -->
                            <div class="modal fade" id="myModal19-<%=elemA.getInId()%>" role="dialog">
                                <div class="modal-dialog">
                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header background-card">
                                            <button type="button" class="close" data-dismiss="modal">X</button>
                                        </div>
                                        <div class="modal-body">
                                            <!--FILA 1-->
                                            <div class="form-group">
                                                <label for="lblDia19"><b>Día 19</b></label>
                                                <select class="form-control" id="ddlDia19-<%=elemA.getInId()%>" name="ddlDia19-<%=elemA.getInId()%>">
                                                    <%
                                                        List<Modelos.Estadisticas.clsId_dia19> lstclsDia19 = new ArrayList<Modelos.Estadisticas.clsId_dia19>();

                                                        if (request.getAttribute("lstclsDia19") != null) {
                                                            lstclsDia19 = (List<Modelos.Estadisticas.clsId_dia19>) request.getAttribute("lstclsDia19");
                                                        }

                                                        for (Modelos.Estadisticas.clsId_dia19 elem : lstclsDia19) {
                                                    %>
                                                    <option id="aliasInicialDia19-<%=elemA.getInId()%>" value="<%=elem.getId_dia19()%>"
                                                            <%=obclsEstadisticas.getObId_dia19() != null ? obclsEstadisticas.getObId_dia19().getId_dia19() == elem.getId_dia19() ? "selected" : "" : ""%>>
                                                        <%=elem.getDescripcionDia19()%>(<%=elem.getAliasDia19()%>)
                                                    </option>
                                                    <%
                                                        }
                                                    %>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" id="buttonCloseID19" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- Modal 20 -->
                            <div class="modal fade" id="myModal20-<%=elemA.getInId()%>" role="dialog">
                                <div class="modal-dialog">
                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header background-card">
                                            <button type="button" class="close" data-dismiss="modal">X</button>
                                        </div>
                                        <div class="modal-body">
                                            <!--FILA 1-->
                                            <div class="form-group">
                                                <label for="lblDia20"><b>Día 20</b></label>
                                                <select class="form-control" id="ddlDia20-<%=elemA.getInId()%>" name="ddlDia20-<%=elemA.getInId()%>">
                                                    <%
                                                        List<Modelos.Estadisticas.clsId_dia20> lstclsDia20 = new ArrayList<Modelos.Estadisticas.clsId_dia20>();

                                                        if (request.getAttribute("lstclsDia20") != null) {
                                                            lstclsDia20 = (List<Modelos.Estadisticas.clsId_dia20>) request.getAttribute("lstclsDia20");
                                                        }

                                                        for (Modelos.Estadisticas.clsId_dia20 elem : lstclsDia20) {
                                                    %>
                                                    <option id="aliasInicialDia20-<%=elemA.getInId()%>" value="<%=elem.getId_dia20()%>"
                                                            <%=obclsEstadisticas.getObId_dia20() != null ? obclsEstadisticas.getObId_dia20().getId_dia20() == elem.getId_dia20() ? "selected" : "" : ""%>>
                                                        <%=elem.getDescripcionDia20()%>(<%=elem.getAliasDia20()%>)
                                                    </option>
                                                    <%
                                                        }
                                                    %>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" id="buttonCloseID20" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- Modal 21 -->
                            <div class="modal fade" id="myModal21-<%=elemA.getInId()%>" role="dialog">
                                <div class="modal-dialog">
                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header background-card">
                                            <button type="button" class="close" data-dismiss="modal">X</button>
                                        </div>
                                        <div class="modal-body">
                                            <!--FILA 1-->
                                            <div class="form-group">
                                                <label for="lblDia21"><b>Día 21</b></label>
                                                <select class="form-control" id="ddlDia21-<%=elemA.getInId()%>" name="ddlDia21-<%=elemA.getInId()%>">
                                                    <%
                                                        List<Modelos.Estadisticas.clsId_dia21> lstclsDia21 = new ArrayList<Modelos.Estadisticas.clsId_dia21>();

                                                        if (request.getAttribute("lstclsDia21") != null) {
                                                            lstclsDia21 = (List<Modelos.Estadisticas.clsId_dia21>) request.getAttribute("lstclsDia21");
                                                        }

                                                        for (Modelos.Estadisticas.clsId_dia21 elem : lstclsDia21) {
                                                    %>
                                                    <option id="aliasInicialDia21-<%=elemA.getInId()%>" value="<%=elem.getId_dia21()%>"
                                                            <%=obclsEstadisticas.getObId_dia21() != null ? obclsEstadisticas.getObId_dia21().getId_dia21() == elem.getId_dia21() ? "selected" : "" : ""%>>
                                                        <%=elem.getDescripcionDia21()%>(<%=elem.getAliasDia21()%>)
                                                    </option>
                                                    <%
                                                        }
                                                    %>
                                                </select> 
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" id="buttonCloseID21" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- Modal 22 -->
                            <div class="modal fade" id="myModal22-<%=elemA.getInId()%>" role="dialog">
                                <div class="modal-dialog">
                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header background-card">
                                            <button type="button" class="close" data-dismiss="modal">X</button>
                                        </div>
                                        <div class="modal-body">
                                            <!--FILA 1-->
                                            <div class="form-group">
                                                <label for="lblDia22"><b>Día 22</b></label>
                                                <select class="form-control" id="ddlDia22-<%=elemA.getInId()%>" name="ddlDia22-<%=elemA.getInId()%>">
                                                    <%
                                                        List<Modelos.Estadisticas.clsId_dia22> lstclsDia22 = new ArrayList<Modelos.Estadisticas.clsId_dia22>();

                                                        if (request.getAttribute("lstclsDia22") != null) {
                                                            lstclsDia22 = (List<Modelos.Estadisticas.clsId_dia22>) request.getAttribute("lstclsDia22");
                                                        }

                                                        for (Modelos.Estadisticas.clsId_dia22 elem : lstclsDia22) {
                                                    %>
                                                    <option id="aliasInicialDia22-<%=elemA.getInId()%>" value="<%=elem.getId_dia22()%>"
                                                            <%=obclsEstadisticas.getObId_dia22() != null ? obclsEstadisticas.getObId_dia22().getId_dia22() == elem.getId_dia22() ? "selected" : "" : ""%>>
                                                        <%=elem.getDescripcionDia22()%>(<%=elem.getAliasDia22()%>)
                                                    </option>
                                                    <%
                                                        }
                                                    %>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" id="buttonCloseID22" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- Modal 23 -->
                            <div class="modal fade" id="myModal23-<%=elemA.getInId()%>" role="dialog">
                                <div class="modal-dialog">
                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header background-card">
                                            <button type="button" class="close" data-dismiss="modal">X</button>
                                        </div>
                                        <div class="modal-body">
                                            <!--FILA 1-->
                                            <div class="form-group">
                                                <label for="lblDia23"><b>Día 23</b></label>
                                                <select class="form-control" id="ddlDia23-<%=elemA.getInId()%>" name="ddlDia23-<%=elemA.getInId()%>">
                                                    <%
                                                        List<Modelos.Estadisticas.clsId_dia23> lstclsDia23 = new ArrayList<Modelos.Estadisticas.clsId_dia23>();

                                                        if (request.getAttribute("lstclsDia23") != null) {
                                                            lstclsDia23 = (List<Modelos.Estadisticas.clsId_dia23>) request.getAttribute("lstclsDia23");
                                                        }

                                                        for (Modelos.Estadisticas.clsId_dia23 elem : lstclsDia23) {
                                                    %>
                                                    <option id="aliasInicialDia23-<%=elemA.getInId()%>" value="<%=elem.getId_dia23()%>"
                                                            <%=obclsEstadisticas.getObId_dia23() != null ? obclsEstadisticas.getObId_dia23().getId_dia23() == elem.getId_dia23() ? "selected" : "" : ""%>>
                                                        <%=elem.getDescripcionDia23()%>(<%=elem.getAliasDia23()%>)
                                                    </option>
                                                    <%
                                                        }
                                                    %>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" id="buttonCloseID23" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- Modal 24 -->
                            <div class="modal fade" id="myModal24-<%=elemA.getInId()%>" role="dialog">
                                <div class="modal-dialog">
                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header background-card">
                                            <button type="button" class="close" data-dismiss="modal">X</button>
                                        </div>
                                        <div class="modal-body">
                                            <!--FILA 1-->
                                            <div class="form-group">
                                                <label for="lblDia24"><b>Día 24</b></label>
                                                <select class="form-control" id="ddlDia24-<%=elemA.getInId()%>" name="ddlDia24-<%=elemA.getInId()%>">
                                                    <%
                                                        List<Modelos.Estadisticas.clsId_dia24> lstclsDia24 = new ArrayList<Modelos.Estadisticas.clsId_dia24>();

                                                        if (request.getAttribute("lstclsDia24") != null) {
                                                            lstclsDia24 = (List<Modelos.Estadisticas.clsId_dia24>) request.getAttribute("lstclsDia24");
                                                        }

                                                        for (Modelos.Estadisticas.clsId_dia24 elem : lstclsDia24) {
                                                    %>
                                                    <option id="aliasInicialDia24-<%=elemA.getInId()%>" value="<%=elem.getId_dia24()%>"
                                                            <%=obclsEstadisticas.getObId_dia24() != null ? obclsEstadisticas.getObId_dia24().getId_dia24() == elem.getId_dia24() ? "selected" : "" : ""%>>
                                                        <%=elem.getDescripcionDia24()%>(<%=elem.getAliasDia24()%>)
                                                    </option>
                                                    <%
                                                        }
                                                    %>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" id="buttonCloseID24" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- Modal 25 -->
                            <div class="modal fade" id="myModal25-<%=elemA.getInId()%>" role="dialog">
                                <div class="modal-dialog">
                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header background-card">
                                            <button type="button" class="close" data-dismiss="modal">X</button>
                                        </div>
                                        <div class="modal-body">
                                            <!--FILA 1-->
                                            <div class="form-group">
                                                <label for="lblDia25"><b>Día 25</b></label>
                                                <select class="form-control" id="ddlDia25-<%=elemA.getInId()%>" name="ddlDia25-<%=elemA.getInId()%>">
                                                    <%
                                                        List<Modelos.Estadisticas.clsId_dia25> lstclsDia25 = new ArrayList<Modelos.Estadisticas.clsId_dia25>();

                                                        if (request.getAttribute("lstclsDia25") != null) {
                                                            lstclsDia25 = (List<Modelos.Estadisticas.clsId_dia25>) request.getAttribute("lstclsDia25");
                                                        }

                                                        for (Modelos.Estadisticas.clsId_dia25 elem : lstclsDia25) {
                                                    %>
                                                    <option id="aliasInicialDia25-<%=elemA.getInId()%>" value="<%=elem.getId_dia25()%>"
                                                            <%=obclsEstadisticas.getObId_dia25() != null ? obclsEstadisticas.getObId_dia25().getId_dia25() == elem.getId_dia25() ? "selected" : "" : ""%>>
                                                        <%=elem.getDescripcionDia25()%>(<%=elem.getAliasDia25()%>)
                                                    </option>
                                                    <%
                                                        }
                                                    %>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" id="buttonCloseID25" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- Modal 26-->
                            <div class="modal fade" id="myModal26-<%=elemA.getInId()%>" role="dialog">
                                <div class="modal-dialog">
                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header background-card">
                                            <button type="button" class="close" data-dismiss="modal">X</button>
                                        </div>
                                        <div class="modal-body">
                                            <!--FILA 1-->
                                            <div class="form-group">
                                                <label for="lblDia26"><b>Día 26</b></label>
                                                <select class="form-control" id="ddlDia26-<%=elemA.getInId()%>" name="ddlDia26-<%=elemA.getInId()%>">
                                                    <%
                                                        List<Modelos.Estadisticas.clsId_dia26> lstclsDia26 = new ArrayList<Modelos.Estadisticas.clsId_dia26>();

                                                        if (request.getAttribute("lstclsDia26") != null) {
                                                            lstclsDia26 = (List<Modelos.Estadisticas.clsId_dia26>) request.getAttribute("lstclsDia26");
                                                        }

                                                        for (Modelos.Estadisticas.clsId_dia26 elem : lstclsDia26) {
                                                    %>
                                                    <option id="aliasInicialDia26-<%=elemA.getInId()%>" value="<%=elem.getId_dia26()%>"
                                                            <%=obclsEstadisticas.getObId_dia26() != null ? obclsEstadisticas.getObId_dia26().getId_dia26() == elem.getId_dia26() ? "selected" : "" : ""%>>
                                                        <%=elem.getDescripcionDia26()%> (<%=elem.getAliasDia26()%>)
                                                    </option>
                                                    <%
                                                        }
                                                    %>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" id="buttonCloseID26" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- Modal 27 -->
                            <div class="modal fade" id="myModal27-<%=elemA.getInId()%>" role="dialog">
                                <div class="modal-dialog">
                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header background-card">
                                            <button type="button" class="close" data-dismiss="modal">X</button>
                                        </div>
                                        <div class="modal-body">
                                            <!--FILA 1-->
                                            <div class="form-group">
                                                <label for="lblDia27"><b>Día 27</b></label>
                                                <select class="form-control" id="ddlDia27-<%=elemA.getInId()%>" name="ddlDia27-<%=elemA.getInId()%>">
                                                    <%
                                                        List<Modelos.Estadisticas.clsId_dia27> lstclsDia27 = new ArrayList<Modelos.Estadisticas.clsId_dia27>();

                                                        if (request.getAttribute("lstclsDia27") != null) {
                                                            lstclsDia27 = (List<Modelos.Estadisticas.clsId_dia27>) request.getAttribute("lstclsDia27");
                                                        }

                                                        for (Modelos.Estadisticas.clsId_dia27 elem : lstclsDia27) {
                                                    %>
                                                    <option id="aliasInicialDia27-<%=elemA.getInId()%>" value="<%=elem.getId_dia27()%>"
                                                            <%=obclsEstadisticas.getObId_dia27() != null ? obclsEstadisticas.getObId_dia27().getId_dia27() == elem.getId_dia27() ? "selected" : "" : ""%>>
                                                        <%=elem.getDescripcionDia27()%>(<%=elem.getAliasDia27()%>)
                                                    </option>
                                                    <%
                                                        }
                                                    %>
                                                </select> 
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" id="buttonCloseID27" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- Modal 28 -->
                            <div class="modal fade" id="myModal28-<%=elemA.getInId()%>" role="dialog">
                                <div class="modal-dialog">
                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header background-card">
                                            <button type="button" class="close" data-dismiss="modal">X</button>
                                        </div>
                                        <div class="modal-body">
                                            <!--FILA 1-->
                                            <div class="form-group">
                                                <label for="lblDia28"><b>Día 28</b></label>
                                                <select class="form-control" id="ddlDia28-<%=elemA.getInId()%>" name="ddlDia28-<%=elemA.getInId()%>">
                                                    <%
                                                        List<Modelos.Estadisticas.clsId_dia28> lstclsDia28 = new ArrayList<Modelos.Estadisticas.clsId_dia28>();

                                                        if (request.getAttribute("lstclsDia28") != null) {
                                                            lstclsDia28 = (List<Modelos.Estadisticas.clsId_dia28>) request.getAttribute("lstclsDia28");
                                                        }

                                                        for (Modelos.Estadisticas.clsId_dia28 elem : lstclsDia28) {
                                                    %>
                                                    <option id="aliasInicialDia28-<%=elemA.getInId()%>" value="<%=elem.getId_dia28()%>"
                                                            <%=obclsEstadisticas.getObId_dia28() != null ? obclsEstadisticas.getObId_dia28().getId_dia28() == elem.getId_dia28() ? "selected" : "" : ""%>>
                                                        <%=elem.getDescripcionDia28()%>(<%=elem.getAliasDia28()%>)
                                                    </option>
                                                    <%
                                                        }
                                                    %>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" id="buttonCloseID28" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- Modal 29 -->
                            <div class="modal fade" id="myModal29-<%=elemA.getInId()%>" role="dialog">
                                <div class="modal-dialog">
                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header background-card">
                                            <button type="button" class="close" data-dismiss="modal">X</button>
                                        </div>
                                        <div class="modal-body">
                                            <!--FILA 1-->
                                            <div class="form-group">
                                                <label for="lblDia29"><b>Día 29</b></label>
                                                <select class="form-control" id="ddlDia29-<%=elemA.getInId()%>" name="ddlDia29-<%=elemA.getInId()%>">
                                                    <%
                                                        List<Modelos.Estadisticas.clsId_dia29> lstclsDia29 = new ArrayList<Modelos.Estadisticas.clsId_dia29>();

                                                        if (request.getAttribute("lstclsDia29") != null) {
                                                            lstclsDia29 = (List<Modelos.Estadisticas.clsId_dia29>) request.getAttribute("lstclsDia29");
                                                        }

                                                        for (Modelos.Estadisticas.clsId_dia29 elem : lstclsDia29) {
                                                    %>
                                                    <option id="aliasInicialDia29-<%=elemA.getInId()%>" value="<%=elem.getId_dia29()%>"
                                                            <%=obclsEstadisticas.getObId_dia29() != null ? obclsEstadisticas.getObId_dia29().getId_dia29() == elem.getId_dia29() ? "selected" : "" : ""%>>
                                                        <%=elem.getDescripcionDia29()%>(<%=elem.getAliasDia29()%>)
                                                    </option>
                                                    <%
                                                        }
                                                    %>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" id="buttonCloseID29" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- Modal 30 -->
                            <div class="modal fade" id="myModal30-<%=elemA.getInId()%>" role="dialog">
                                <div class="modal-dialog">
                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header background-card">
                                            <button type="button" class="close" data-dismiss="modal">X</button>
                                        </div>
                                        <div class="modal-body">
                                            <!--FILA 1-->
                                            <div class="form-group">
                                                <label for="lblDia30"><b>Día 30</b></label>
                                                <select class="form-control" id="ddlDia30-<%=elemA.getInId()%>" name="ddlDia30-<%=elemA.getInId()%>">
                                                    <%
                                                        List<Modelos.Estadisticas.clsId_dia30> lstclsDia30 = new ArrayList<Modelos.Estadisticas.clsId_dia30>();

                                                        if (request.getAttribute("lstclsDia30") != null) {
                                                            lstclsDia30 = (List<Modelos.Estadisticas.clsId_dia30>) request.getAttribute("lstclsDia30");
                                                        }

                                                        for (Modelos.Estadisticas.clsId_dia30 elem : lstclsDia30) {
                                                    %>
                                                    <option id="aliasInicialDia30-<%=elemA.getInId()%>" value="<%=elem.getId_dia30()%>"
                                                            <%=obclsEstadisticas.getObId_dia30() != null ? obclsEstadisticas.getObId_dia30().getId_dia30() == elem.getId_dia30() ? "selected" : "" : ""%>>
                                                        <%=elem.getDescripcionDia30()%>(<%=elem.getAliasDia30()%>)
                                                    </option>
                                                    <%
                                                        }
                                                    %>
                                                </select> 
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" id="buttonCloseID30" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- Modal 31 -->
                            <div class="modal fade" id="myModal31-<%=elemA.getInId()%>" role="dialog">
                                <div class="modal-dialog">
                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header background-card">
                                            <button type="button" class="close" data-dismiss="modal">X</button>
                                        </div>
                                        <div class="modal-body">
                                            <!--FILA 1-->
                                            <div class="form-group">
                                                <label for="lblDia31"><b>Día 31</b></label>
                                                <select class="form-control" id="ddlDia31-<%=elemA.getInId()%>" name="ddlDia31-<%=elemA.getInId()%>">
                                                    <%
                                                        List<Modelos.Estadisticas.clsId_dia31> lstclsDia31 = new ArrayList<Modelos.Estadisticas.clsId_dia31>();

                                                        if (request.getAttribute("lstclsDia31") != null) {
                                                            lstclsDia31 = (List<Modelos.Estadisticas.clsId_dia31>) request.getAttribute("lstclsDia31");
                                                        }

                                                        for (Modelos.Estadisticas.clsId_dia31 elem : lstclsDia31) {
                                                    %>
                                                    <option id="aliasInicialDia31-<%=elemA.getInId()%>" value="<%=elem.getId_dia31()%>"
                                                            <%=obclsEstadisticas.getObId_dia31() != null ? obclsEstadisticas.getObId_dia31().getId_dia31() == elem.getId_dia31() ? "selected" : "" : ""%>>
                                                        <%=elem.getDescripcionDia31()%>(<%=elem.getAliasDia31()%>)
                                                    </option>
                                                    <%
                                                        }
                                                    %>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" id="buttonCloseID31" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
                                        </div>
                                    </div>
                                </div>
                            </div>                                               
                            <!--Modal Comentario-->
                            <div class="modal fade" id="myModalComentario-<%=elemA.getInId()%>" role="dialog">
                                <div class="modal-dialog">
                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header background-card">
                                            <button type="button" class="close" data-dismiss="modal">X</button>
                                        </div>
                                        <div class="modal-body">
                                            <!--FILA 1-->
                                            <div class="form-group">
                                                <label for="lnlComentario:"><b>Nuevo Comentario</b></label>   
                                                <textarea class="form-control" row="3" name="txtComentario-<%=elemA.getInId()%>"></textarea>
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" id="buttonCloseIDComentario" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <tr>
                                <td class="align-middle">
                                    <input name="ddlEmpleado-<%=elemA.getInId()%>" value="<%=elemA.getInId()%>" hidden /><%=elemA.getStPrimerNombre() + " " + elemA.getStSegundoNombre() + " " + elemA.getStPrimerApellido() + " " + elemA.getStSegundoApellido()%>
                                </td>
                                <td class="align-middle">
                                    <input name="ddlAnio" value="<%=año%>" hidden/><%=año%>
                                </td>
                                <td class="align-middle">
                                    <input name="ddlMes" value="<%=mes%>" hidden /><%=nombreMes%></label>
                                </td>
                                <%
                                    //Vector Novedades Empleados
                                    String[] vector = new String[31];
                                    //Vector Enlaces a Modales
                                    String[] vEnModal = new String[31];
                                    //Vector Clase openBtn
                                    String[] vopenBtn = new String[31];
                                    //Vector Enfoque Modal
                                    String[] vModal = new String[31];
                                    //Vector IdAliasDia
                                    String[] vAliasDia = new String[31];

                                    int j = 1;
                                    for (int i = 0; i < 31; i++) {
                                        vector[i] = Integer.toString(j);
                                        vEnModal[i] = "estadisticas?codigoDia" + j + "=";
                                        vopenBtn[i] = "openBtn" + j;
                                        vModal[i] = "#myModal" + j + "-";
                                        vAliasDia[i] = "aliasDia" + j + "-";
                                        j++;
                                    }

                                    int conDos = 1;

                                    int numDos = 0;

                                    for (int f = quincena2; conDos <= intervaloEntreQuincenas; conDos++) {

                                        if (f < dias) {
                                %>
                                <td class="align-middle"><a id="<%=vAliasDia[f]%><%=elemA.getInId()%>" href="<%=vEnModal[f]%><%=elemA.getInId()%>" class="btn btn-link <%=vopenBtn[f]%>" data-toggle="modal" data-target="<%=vModal[f]%><%=elemA.getInId()%>"><%=vector[f]%></a></td>
                                    <%
                                        f++;
                                    } else {
                                    %>        
                                <td class="align-middle"><a id="<%=vAliasDia[numDos]%><%=elemA.getInId()%>" href="<%=vEnModal[numDos]%><%=elemA.getInId()%>" class="btn btn-link <%=vopenBtn[numDos]%>" data-toggle="modal" data-target="<%=vModal[numDos]%><%=elemA.getInId()%>"><%=vector[numDos]%></a></td>
                                    <%numDos++;
                                            }
                                        }
                                    %>
                                <td class="align-middle">
                                    <a class="btn btn-primary rounded mr-1 openBtn1" data-toggle="modal" data-target="#myModalComentario-<%=elemA.getInId()%>" id="btnEmplComentar"
                                       title="Haz clic para comentar" href="estadisticas?codigoComentar=<%=elemA.getInId()%>">
                                        <i class="far fa-comment" style="font-size:15px;"></i>
                                    </a>
                                </td>
                            </tr>
                            <%
                                }
                            } else {
                                for (Modelos.Empleados.clsEmpleado elemA : lstclsEmpleado) {
                                    if (GrupoEmpl == (elemA.getObclsGrupoEmpl().getId_grupo())) {

                            %>
                            <!--Input Oculto Tamaño de la Lista-->
                            <input type="text" hidden="" name="extensionLista" value="<%=lstclsEmpleado.size()%>"/>

                            <tr>
                                <td class="align-middle">
                                    <input name="ddlEmpleado-<%=elemA.getInId()%>" value="<%=elemA.getInId()%>" hidden /><%=elemA.getStPrimerNombre() + " " + elemA.getStSegundoNombre() + " " + elemA.getStPrimerApellido() + " " + elemA.getStSegundoApellido()%>
                                </td>
                                <td class="align-middle">
                                    <input name="ddlAnio" value="<%=año%>" hidden/><%=año%>
                                </td>
                                <td class="align-middle">
                                    <input name="ddlMes" value="<%=mes%>" hidden /><%=nombreMes%></label>
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
                                    <th class="align-middle">A&ntilde;o</th>
                                    <th class="align-middle">Mes</th>
                                        <%
                                            int conTres = 1;

                                            int numTres = 1;

                                            for (int f = (quincena2 + 1); conTres <= intervaloEntreQuincenas; conTres++) {
                                                if (f <= dias) {
                                        %>
                                    <th class="align-middle"><%=f%></th>
                                        <%
                                            f++;
                                        } else {
                                        %>
                                    <th class="align-middle"><%=numTres%></th>
                                        <%
                                                    numTres++;
                                                }
                                            }
                                        %>
                                    <th class="align-middle">Comentar</th>
                                </tr>
                            </tfoot>
                        </table>
                        <!--FILA SUBMIT-->   
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-12">
                                    <input type="submit" value="Guardar" class="btn background-button" name="btnGuardarEsta"/>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div> 
    </body>
    <script type="text/javascript" language="JavaScript">

        main();

        var aliasInicialDia26 = [];
        var aliasDia26 = [];
        var ddlDia26 = [];


        var i;
        for (i = 1; i < 48; i++) {
            aliasInicialDia26[i] = "aliasInicialDia26-" + i;
            aliasDia26[i] = "aliasDia26-" + i;
            ddlDia26[i] = '#ddlDia26-' + i;
        }


        var j;
        for (j = 1; j < 90; j++) {

            var novedadInicial = document.getElementById(aliasInicialDia26[j]).textContent;
            document.getElementById(aliasDia26[j]).innerHTML = novedadInicial;

            $(ddlDia26[j]).change(function ()
            {
                var selected26 = $(this).find('option:selected').text();
                document.getElementById("aliasDia26-1").innerHTML = "<span style=\"font-weight: 750;\">" + selected26 + "</span>";

            });
        }

    </script>
    <script>
        function dia27() {
            var aliasInicialDia27 = [];
            var aliasDia27 = [];
            var ddlDia27 = [];
            var i;
            for (i = 1; i < 48; i++) {
                aliasInicialDia27[i] = "aliasInicialDia27-" + i;
                aliasDia27[i] = "aliasDia27-" + i;
                ddlDia27[i] = '#ddlDia27-' + i;
            }
            ;
            var j;
            for (j = 1; j < 90; j++) {
                var novedadInicial = document.getElementById(aliasInicialDia27[j]).textContent;
                document.getElementById(aliasDia27[j]).innerHTML = novedadInicial;
                $(ddlDia27[j]).change(function j()
                {
                    var selected27 = $(this).find('option:selected').text();
                    document.getElementById("aliasDia27-1").innerHTML = "<span style=\"color: black; font-weight: 750;\">" + selected27 + "</span>";
                });
            }
        }
        dia27();
    </script>
    <script>
        function dia28() {
            var aliasInicialDia28 = [];
            var aliasDia28 = [];
            var ddlDia28 = [];
            var i;
            for (i = 1; i < 48; i++) {
                aliasInicialDia28[i] = "aliasInicialDia28-" + i;
                aliasDia28[i] = "aliasDia28-" + i;
                ddlDia28[i] = '#ddlDia28-' + i;
            }
            ;
            var j;
            for (j = 1; j < 90; j++) {
                var novedadInicial = document.getElementById(aliasInicialDia28[j]).textContent;
                document.getElementById(aliasDia28[j]).innerHTML = novedadInicial;
                $(ddlDia28[j]).change(function j()
                {
                    var selected28 = $(this).find('option:selected').text();
                    document.getElementById("aliasDia28-1").innerHTML = "<span style=\"color: red;\">" + selected28 + "</span>";
                });
            }
        }
        dia28();
    </script>
    <script>
        function dia29() {
            var aliasInicialDia29 = [];
            var aliasDia29 = [];
            var ddlDia29 = [];
            var i;
            for (i = 1; i < 48; i++) {
                aliasInicialDia29[i] = "aliasInicialDia29-" + i;
                aliasDia29[i] = "aliasDia29-" + i;
                ddlDia29[i] = '#ddlDia29-' + i;
            }
            ;
            var j;
            for (j = 1; j < 90; j++) {
                var novedadInicial = document.getElementById(aliasInicialDia29[j]).textContent;
                document.getElementById(aliasDia29[j]).innerHTML = novedadInicial;
                $(ddlDia29[j]).change(function j()
                {
                    var selected29 = $(this).find('option:selected').text();
                    document.getElementById("aliasDia29-1").innerHTML = "<span style=\"color: red; font-weight: 750;\">" + selected29 + "</span>";
                });
            }
        }
        dia29();
    </script>
</html>                           