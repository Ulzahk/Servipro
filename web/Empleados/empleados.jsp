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
        <title>Empleados</title>
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
            <h1 class="text-center">Empleados</h1>
            <br>
            <div class="card border-info">
                <div class="card-header bg-info text-white">
                    <form action="empleados" method="post">
                        <div class="input-group">
                            <a href="nomina.htm" class="btn btn-secondary mr-1" data-toggle="tooltip" title="Haz clic para regresar al menú nómina"><i class="fas fa-arrow-left"></i></a>
                            <a href="empleados?btnEmplAgregar=true" class="btn btn-secondary mr-1" data-toggle="tooltip" title="Haz clic para agregar un nuevo registro">Agregar Registro</a>
                            <input type="text" class="form-control" name="txtEmplBuscar" id="txtEmplBuscar" placeholder="Buscar en Servisoft S.A."/>
                            <div class="input-group-append">
                                <button type="submit" Value="Buscar" class="btn btn-secondary" data-toggle="tooltip" title="Haz clic para buscar" name="btnEmplBuscar"><i class="fas fa-search"></i></button>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="card-body">
                    <table id="table-id" border="1" class="table table-bordered table-striped table-hover text-center table-responsive">
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
                                        <span>Registros Existentes: <%=lstclsEmpleado.size()%></span>
                                    </b>

                                </div>
                            </div>
                        </div>

                        <tr>
                            <td class="align-middle"><b>Tipo Documento</b></td>
                            <td class="align-middle"><b>Documento</b></td>
                            <td class="align-middle"><b>Nombre Completo</b></td>
                            <td class="align-middle"><b>Telefono</b></td>
                            <td class="align-middle"><b>Centro de Costos</b></td>
                            <td class="align-middle"><b>Cargo</b></td>
                            <td class="align-middle"><b>Acciones</b></td>
                        </tr>
                        <%
                            for (Modelos.Empleados.clsEmpleado elem : lstclsEmpleado) {
                        %>
                        <tr>
                            <td class="align-middle"><%=elem.getObclsTipoDocumento().getStDescripcion()%></td>
                            <td class="align-middle"><%=elem.getStDocumento()%></td>
                            <td class="align-middle"><%=elem.getStPrimerNombre()%> <%=elem.getStSegundoNombre()%> <%=elem.getStPrimerApellido()%> <%=elem.getStSegundoApellido()%></td>
                            <td class="align-middle"><%=elem.getStTelefono()%></td>
                            <td class="align-middle"><%=elem.getObclsCentroCosto().getStDescripcion()%></td>
                            <td class="align-middle"><%=elem.getObclsCargo().getStDescripcion()%></td>
                            <td class="align-middle">
                                <div class="btn-group">
                                    <a class="btn btn-warning btn-sm mr-1 openBtn rounded" title="Haz clic para modificar empleado" data-toggle="modal" data-target="#myModal" id="btnEmplModificar" 
                                       href="empleados?stOpcion=M&codigoSeleccionado=<%=elem.getInId()%>">
                                        <i class="fas fa-edit" style="font-size:15px;"></i>
                                    </a>
                                    <a class="btn btn-danger btn-sm openBtn rounded" title="Haz clic para eliminar" data-toggle="modal" data-target="#myModal" id="btnEmplEliminar"
                                       href="empleados?stOpcion=E&codigoSeleccionado=<%=elem.getInId()%>">
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
            <script>
                $('.openBtn').on('click', function () {
                    $('.modal-body').load(this.href, function ()
                    {
                        $('#myModal').modal({show: false});
                    });
                });

                getPagination('#table-id');
                //getPagination('.table-class');
                //getPagination('table');

                /*					PAGINATION 
                 - on change max rows select options fade out all rows gt option value mx = 5
                 - append pagination list as per numbers of rows / max rows option (20row/5= 4pages )
                 - each pagination li on click -> fade out all tr gt max rows * li num and (5*pagenum 2 = 10 rows)
                 - fade out all tr lt max rows * li num - max rows ((5*pagenum 2 = 10) - 5)
                 - fade in all tr between (maxRows*PageNum) and (maxRows*pageNum)- MaxRows 
                 */


                function getPagination(table) {
                    var lastPage = 1;

                    $('#maxRows')
                            .on('change', function (evt) {
                                //$('.paginationprev').html(''); // reset pagination

                                lastPage = 1;
                                $('.pagination')
                                        .find('li')
                                        .slice(1, -1)
                                        .remove();
                                var trnum = 0; // reset tr counter
                                var maxRows = parseInt($(this).val()); // get Max Rows from select option

                                if (maxRows == 5000) {
                                    $('.pagination').hide();
                                } else {
                                    $('.pagination').show();
                                }

                                var totalRows = $(table + ' tbody tr').length; // numbers of rows
                                $(table + ' tr:gt(0)').each(function () {
                                    // each TR in  table and not the header
                                    trnum++; // Start Counter
                                    if (trnum > maxRows) {
                                        // if tr number gt maxRows

                                        $(this).hide(); // fade it out
                                    }
                                    if (trnum <= maxRows) {
                                        $(this).show();
                                    } // else fade in Important in case if it ..
                                }); //  was fade out to fade it in
                                if (totalRows > maxRows) {
                                    // if tr total rows gt max rows option
                                    var pagenum = Math.ceil(totalRows / maxRows); // ceil total(rows/maxrows) to get ..
                                    //	numbers of pages
                                    for (var i = 1; i <= pagenum; ) {
                                        // for each page append pagination li
                                        $('.pagination #prev')
                                                .before(
                                                        '<li data-page="' +
                                                        i +
                                                        '">\
                <button class="btn btn-secondary btn-sm mr-1">' +
                                                        i++ +
                                                        '<span class="sr-only">(current)</span></button>\
                </li>'
                                                        )
                                                .show();
                                    } // end for i
                                } // end if row count > max rows
                                $('.pagination [data-page="1"]').addClass('active'); // add active class to the first li
                                $('.pagination li').on('click', function (evt) {
                                    // on click each page
                                    evt.stopImmediatePropagation();
                                    evt.preventDefault();
                                    var pageNum = $(this).attr('data-page'); // get it's number

                                    var maxRows = parseInt($('#maxRows').val()); // get Max Rows from select option

                                    if (pageNum == 'prev') {
                                        if (lastPage == 1) {
                                            return;
                                        }
                                        pageNum = --lastPage;
                                    }
                                    if (pageNum == 'next') {
                                        if (lastPage == $('.pagination li').length - 2) {
                                            return;
                                        }
                                        pageNum = ++lastPage;
                                    }

                                    lastPage = pageNum;
                                    var trIndex = 0; // reset tr counter
                                    $('.pagination li').removeClass('active'); // remove active class from all li
                                    $('.pagination [data-page="' + lastPage + '"]').addClass('active'); // add active class to the clicked
                                    //$(this).addClass('active');					// add active class to the clicked
                                    limitPagging();
                                    $(table + ' tr:gt(0)').each(function () {
                                        // each tr in table not the header
                                        trIndex++; // tr index counter
                                        // if tr index gt maxRows*pageNum or lt maxRows*pageNum-maxRows fade if out
                                        if (
                                                trIndex > maxRows * pageNum ||
                                                trIndex <= maxRows * pageNum - maxRows
                                                ) {
                                            $(this).hide();
                                        } else {
                                            $(this).show();
                                        } //else fade in
                                    }); // end of for each tr in table
                                }); // end of on click pagination list
                                limitPagging();
                            })
                            .val(5000)
                            .change();

                    // end of on select change

                    // END OF PAGINATION
                }

                function limitPagging() {
                    // alert($('.pagination li').length)

                    if ($('.pagination li').length > 7) {
                        if ($('.pagination li.active').attr('data-page') <= 3) {
                            $('.pagination li:gt(5)').hide();
                            $('.pagination li:lt(5)').show();
                            $('.pagination [data-page="next"]').show();
                        }
                        if ($('.pagination li.active').attr('data-page') > 3) {
                            $('.pagination li:gt(0)').hide();
                            $('.pagination [data-page="next"]').show();
                            for (let i = (parseInt($('.pagination li.active').attr('data-page')) - 2); i <= (parseInt($('.pagination li.active').attr('data-page')) + 2); i++) {
                                $('.pagination [data-page="' + i + '"]').show();

                            }

                        }
                    }
                }

                $(function () {
                    // Just to append id number for each row
                    $('table tr:eq(0)').prepend('<th> ID </th>');

                    var id = 0;

                    $('table tr:gt(0)').each(function () {
                        id++;
                        $(this).prepend('<td>' + id + '</td>');
                    });
                });


            </script>
    </body>
    <script type="text/javascript" language="JavaScript">
        main();
    </script>
</html>






