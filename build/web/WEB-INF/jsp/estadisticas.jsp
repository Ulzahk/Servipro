<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%
    HttpSession objsesion = request.getSession(false);
    String id_usuario = (String)objsesion.getAttribute("id_usuario");

    
    if(id_usuario==null){
        response.sendRedirect("login.jsp");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset= "UTF-8" />
        <title>Estadisticas</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script src="<c:url value="/Resources/JS/functions.js"/>"></script>
    </head>
    <body>
        <nav class="navbar navbar-expand-sm bg-info navbar-dark justify-content-center">
            <a class="navbar-brand" href="index.htm">ServiSoft S.A.</a>  
            <div>
                <ul class="navbar-nav">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                            Control Usuarios
                        </a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="usuarios.htm">Usuarios</a>
                            <a class="dropdown-item" href="perfil.htm">Perfil</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                            Novedades
                        </a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="tipodenovedades.htm">Tabla De Novedades</a>
                            <a class="dropdown-item" href="facturacion.htm">Facturación</a>
                            <a class="dropdown-item" href="novedadesempleado.htm">Novedades por Empleado</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                            Centro de Costos
                        </a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="centrodecostos.htm">Tabla Centro de Costos</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                            Empleados
                        </a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="empleados.htm">Tabla Empleados</a>
                            <a class="dropdown-item" href="cargoempleado.htm">Cargo Empleado</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                            Modulos
                        </a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="modulos.htm">Tabla Modulos</a>
                            <a class="dropdown-item" href="modulosperfil.htm">Modulos por Perfil</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                            Grupos
                        </a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="grupos.htm">Tabla Grupos</a>
                            <a class="dropdown-item" href="empleadosgrupo.htm">Empleados por Grupo</a>
                            <a class="dropdown-item" href="responsablegrupo.htm">Responsable del Grupo</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                            Configuracion
                        </a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="configuracion.htm">Configuracion</a>
                        </div> 
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle btn btn-dark" href="#" id="navbardrop" data-toggle="dropdown">
                            Usuario: <% out.println(id_usuario); %>
                        </a>
                        <div class="dropdown-menu text-center">
                            <form action="cerrar" method="post" id="formcerrar">
                                <input type="submit" value="Cerrar Sesión"  class="btn btn-link text-center"
                                       style="color: #000;"/>
                            </form>
                        </div> 
                    </li>
                </ul>
            </div>    
        </nav>
                        
        <div class="container mt-4">
            <h1 class="text-center">Estadisticas</h1>
            <br>
            <div class="card border-info">
                <div class="card-header bg-info text-white">
                    <form class="form-inline" action="" method="post">
                        <a href="nomina.htm" class="btn btn-secondary mr-2"><i class="fas fa-arrow-left"></i></a>
                        <select  class="form-control" id="Filtrar" name="Filtrar">
                                <option>Mensualidad</option> 
                                <option>Quincena 1</option>
                                <option>Quincena 2</option>
                        </select>
                        <div class="input-group"> 
                            <input type="text" class="form-control" name="Buscar" placeholder="Buscar..."/>
                            <button type="submit" class="btn btn-secondary" value="Filtrar"><i class="fas fa-filter"></i> Filtrar</button>
                        </div>
                    </form>
                </div>
                <div class="card-body">
                    <table border="1" class="table table-bordered table-striped table-hover text-center">
                        <thead>
                            <tr>
                                <th class="align-middle">Empleado</th>
                                <th colspan="10" class="align-middle">Días - Novedades</th>
                            </tr>
                        </thead>
                        <%
                            String controlFiltrar=request.getParameter("Filtrar");
                            String controlBuscar=request.getParameter("Buscar");
                            try
                            {
                                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                                Connection conn=DriverManager.getConnection("jdbc:sqlserver://10.0.0.98:1433;databaseName=sssacontable","contable19","contable19");
                                String Query="select Nombre, dia1.Alias Alias1, dia2.Alias Alias2, dia3.Alias Alias3, dia4.Alias Alias4, dia5.Alias Alias5, "
                                        + " dia6.Alias Alias6, dia7.Alias Alias7, dia8.Alias Alias8, dia9.Alias Alias9, dia10.Alias Alias10, "
                                        + " dia11.Alias Alias11, dia12.Alias Alias12, dia13.Alias Alias13, dia14.Alias Alias14, dia15.Alias Alias15, "
                                        + " dia16.Alias Alias16, dia17.Alias Alias17, dia18.Alias Alias18, dia19.Alias Alias19, dia20.Alias Alias20, "
                                        + " dia21.Alias Alias21, dia22.Alias Alias22, dia23.Alias Alias23, dia24.Alias Alias24, dia25.Alias Alias25, "
                                        + " dia26.Alias Alias26, dia27.Alias Alias27, dia28.Alias Alias28, dia29.Alias Alias29, dia30.Alias Alias30  "
                                        + " from nm_estadistica join nm_empleados "
                                        + " on nm_estadistica.id_empleado=nm_empleados.id_empleado join nm_tipo_novedad dia1"
                                        + " on nm_estadistica.id_dia1 = dia1.id_novedad join nm_tipo_novedad dia2 "
                                        + " on nm_estadistica.id_dia2 = dia2.id_novedad join nm_tipo_novedad dia3 "
                                        + " on nm_estadistica.id_dia3 = dia3.id_novedad join nm_tipo_novedad dia4 "
                                        + " on nm_estadistica.id_dia4 = dia4.id_novedad join nm_tipo_novedad dia5 "
                                        + " on nm_estadistica.id_dia5 = dia5.id_novedad join nm_tipo_novedad dia6 "
                                        + " on nm_estadistica.id_dia6 = dia6.id_novedad join nm_tipo_novedad dia7 "
                                        + " on nm_estadistica.id_dia7 = dia7.id_novedad join nm_tipo_novedad dia8 "
                                        + " on nm_estadistica.id_dia8 = dia8.id_novedad join nm_tipo_novedad dia9 "
                                        + " on nm_estadistica.id_dia9 = dia9.id_novedad join nm_tipo_novedad dia10 "
                                        + " on nm_estadistica.id_dia10 = dia10.id_novedad join nm_tipo_novedad dia11 "
                                        + " on nm_estadistica.id_dia11 = dia11.id_novedad join nm_tipo_novedad dia12 "
                                        + " on nm_estadistica.id_dia12 = dia12.id_novedad join nm_tipo_novedad dia13 "
                                        + " on nm_estadistica.id_dia13 = dia13.id_novedad join nm_tipo_novedad dia14 "
                                        + " on nm_estadistica.id_dia14 = dia14.id_novedad join nm_tipo_novedad dia15 "
                                        + " on nm_estadistica.id_dia15 = dia15.id_novedad join nm_tipo_novedad dia16 "
                                        + " on nm_estadistica.id_dia16 = dia16.id_novedad join nm_tipo_novedad dia17 "
                                        + " on nm_estadistica.id_dia17 = dia17.id_novedad join nm_tipo_novedad dia18 "
                                        + " on nm_estadistica.id_dia18 = dia18.id_novedad join nm_tipo_novedad dia19 "
                                        + " on nm_estadistica.id_dia19 = dia19.id_novedad join nm_tipo_novedad dia20 "
                                        + " on nm_estadistica.id_dia20 = dia20.id_novedad join nm_tipo_novedad dia21 "
                                        + " on nm_estadistica.id_dia21 = dia21.id_novedad join nm_tipo_novedad dia22 "
                                        + " on nm_estadistica.id_dia22 = dia22.id_novedad join nm_tipo_novedad dia23 "
                                        + " on nm_estadistica.id_dia23 = dia23.id_novedad join nm_tipo_novedad dia24 "
                                        + " on nm_estadistica.id_dia24 = dia24.id_novedad join nm_tipo_novedad dia25 "
                                        + " on nm_estadistica.id_dia25 = dia25.id_novedad join nm_tipo_novedad dia26 "
                                        + " on nm_estadistica.id_dia26 = dia26.id_novedad join nm_tipo_novedad dia27 "
                                        + " on nm_estadistica.id_dia27 = dia27.id_novedad join nm_tipo_novedad dia28 "
                                        + " on nm_estadistica.id_dia28 = dia28.id_novedad join nm_tipo_novedad dia29 "
                                        + " on nm_estadistica.id_dia29 = dia29.id_novedad join nm_tipo_novedad dia30 "
                                        + " on nm_estadistica.id_dia30 = dia30.id_novedad where  "
                                        + " Id_estadistica like '%"+request.getParameter("Buscar")+"%' or "
                                        + " Nombre like '%"+request.getParameter("Buscar")+"%'";
                                Statement stm=conn.createStatement();
                                ResultSet rs=stm.executeQuery(Query);
                                if(controlFiltrar!=null)
                                {
                                    
                                }else
                                {
                                    if(controlBuscar!=null)
                                    {   
                                        while(rs.next())
                                        {
                                            %>
                                            <tbody>
                                                <tr>
                                                   <td rowspan="6" class="align-middle"><%=rs.getString("Nombre")%></td>
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
                                                </tr>   
                                                <tr>
                                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias1")%></button></td>
                                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias2")%></button></td>
                                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias3")%></button></td>
                                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias4")%></button></td>
                                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias5")%></button></td>
                                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias6")%></button></td>
                                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias7")%></button></td>
                                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias8")%></button></td>
                                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias9")%></button></td>
                                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias10")%></button></td>
                                                </tr>
                                                <tr>
                                                   <td class="align-middle">11</td>
                                                   <td class="align-middle">12</td>
                                                   <td class="align-middle">13</td>
                                                   <td class="align-middle">14</td>
                                                   <td class="align-middle">15</td>
                                                   <td class="align-middle">16</td>
                                                   <td class="align-middle">17</td>
                                                   <td class="align-middle">18</td>
                                                   <td class="align-middle">19</td>
                                                   <td class="align-middle">20</td>
                                                </tr> 
                                                <tr>
                                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias11")%></button></td>
                                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias12")%></button></td>
                                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias13")%></button></td>
                                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias14")%></button></td>
                                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias15")%></button></td>
                                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias16")%></button></td>
                                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias17")%></button></td>
                                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias18")%></button></td>
                                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias19")%></button></td>
                                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias20")%></button></td>
                                                </tr>
                                                <tr>
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
                                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias21")%></button></td>
                                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias22")%></button></td>
                                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias23")%></button></td>
                                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias24")%></button></td>
                                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias25")%></button></td>
                                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias26")%></button></td>
                                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias27")%></button></td>
                                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias28")%></button></td>
                                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias29")%></button></td>
                                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias30")%></button></td>
                                                </tr>
                                            </tbody> 
                                            <%

                                        }     
                                    }
                                    else
                                    {
                                        
                                        %>
                                            <tbody>
                                                <c:forEach var="dato" items="${datos}">
                                                    <tr>
                                                       <td rowspan="6" class="align-middle"><c:out value="${dato.Nombre}"/></td>
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
                                                    </tr>    
                                                    <tr>
                                                        <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias1}"/></button></td>
                                                        <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias2}"/></button></td>
                                                        <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias3}"/></button></td>
                                                        <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias4}"/></button></td>
                                                        <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias5}"/></button></td>
                                                        <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias6}"/></button></td>
                                                        <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias7}"/></button></td>
                                                        <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias8}"/></button></td>
                                                        <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias9}"/></button></td>
                                                        <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias10}"/></button></td>
                                                    </tr>
                                                    <tr>
                                                       <td class="align-middle">11</td>
                                                       <td class="align-middle">12</td>
                                                       <td class="align-middle">13</td>
                                                       <td class="align-middle">14</td>
                                                       <td class="align-middle">15</td>
                                                       <td class="align-middle">16</td>
                                                       <td class="align-middle">17</td>
                                                       <td class="align-middle">18</td>
                                                       <td class="align-middle">19</td>
                                                       <td class="align-middle">20</td>
                                                    </tr> 
                                                    <tr>
                                                        <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias11}"/></button></td>
                                                        <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias12}"/></button></td>
                                                        <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias13}"/></button></td>
                                                        <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias14}"/></button></td>
                                                        <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias15}"/></button></td>
                                                        <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias16}"/></button></td>
                                                        <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias17}"/></button></td>
                                                        <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias18}"/></button></td>
                                                        <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias19}"/></button></td>
                                                        <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias20}"/></button></td>
                                                    </tr>
                                                    <tr>
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
                                                        <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias21}"/></button></td>
                                                        <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias22}"/></button></td>
                                                        <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias23}"/></button></td>
                                                        <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias24}"/></button></td>
                                                        <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias25}"/></button></td>
                                                        <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias26}"/></button></td>
                                                        <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias27}"/></button></td>
                                                        <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias28}"/></button></td>
                                                        <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias29}"/></button></td>
                                                        <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias30}"/></button></td>
                                                    </tr>
                                                    </c:forEach>
                                                </tbody> 
                                               
                                        <%
                                    }
                                }
                                
                                
                                
                                if(controlFiltrar.equals("Mensualidad"))
                                {
                                   if(controlBuscar!=null)
                                    {   
                                        while(rs.next())
                                        {
                                            %>
                                            <tbody>
                                                <tr>
                                                   <td rowspan="6" class="align-middle"><%=rs.getString("Nombre")%></td>
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
                                                </tr>   
                                                <tr>
                                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias1")%></button></td>
                                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias2")%></button></td>
                                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias3")%></button></td>
                                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias4")%></button></td>
                                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias5")%></button></td>
                                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias6")%></button></td>
                                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias7")%></button></td>
                                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias8")%></button></td>
                                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias9")%></button></td>
                                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias10")%></button></td>
                                                </tr>
                                                <tr>
                                                   <td class="align-middle">11</td>
                                                   <td class="align-middle">12</td>
                                                   <td class="align-middle">13</td>
                                                   <td class="align-middle">14</td>
                                                   <td class="align-middle">15</td>
                                                   <td class="align-middle">16</td>
                                                   <td class="align-middle">17</td>
                                                   <td class="align-middle">18</td>
                                                   <td class="align-middle">19</td>
                                                   <td class="align-middle">20</td>
                                                </tr> 
                                                <tr>
                                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias11")%></button></td>
                                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias12")%></button></td>
                                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias13")%></button></td>
                                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias14")%></button></td>
                                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias15")%></button></td>
                                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias16")%></button></td>
                                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias17")%></button></td>
                                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias18")%></button></td>
                                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias19")%></button></td>
                                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias20")%></button></td>
                                                </tr>
                                                <tr>
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
                                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias21")%></button></td>
                                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias22")%></button></td>
                                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias23")%></button></td>
                                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias24")%></button></td>
                                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias25")%></button></td>
                                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias26")%></button></td>
                                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias27")%></button></td>
                                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias28")%></button></td>
                                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias29")%></button></td>
                                                    <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias30")%></button></td>
                                                </tr>
                                            </tbody> 
                                            <%

                                        }     
                                    }
                                    else
                                    {
                                        
                                        %>
                                            <tbody>
                                                <c:forEach var="dato" items="${datos}">
                                                    <tr>
                                                       <td rowspan="6" class="align-middle"><c:out value="${dato.Nombre}"/></td>
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
                                                    </tr>    
                                                    <tr>
                                                        <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias1}"/></button></td>
                                                        <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias2}"/></button></td>
                                                        <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias3}"/></button></td>
                                                        <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias4}"/></button></td>
                                                        <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias5}"/></button></td>
                                                        <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias6}"/></button></td>
                                                        <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias7}"/></button></td>
                                                        <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias8}"/></button></td>
                                                        <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias9}"/></button></td>
                                                        <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias10}"/></button></td>
                                                    </tr>
                                                    <tr>
                                                       <td class="align-middle">11</td>
                                                       <td class="align-middle">12</td>
                                                       <td class="align-middle">13</td>
                                                       <td class="align-middle">14</td>
                                                       <td class="align-middle">15</td>
                                                       <td class="align-middle">16</td>
                                                       <td class="align-middle">17</td>
                                                       <td class="align-middle">18</td>
                                                       <td class="align-middle">19</td>
                                                       <td class="align-middle">20</td>
                                                    </tr> 
                                                    <tr>
                                                        <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias11}"/></button></td>
                                                        <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias12}"/></button></td>
                                                        <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias13}"/></button></td>
                                                        <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias14}"/></button></td>
                                                        <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias15}"/></button></td>
                                                        <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias16}"/></button></td>
                                                        <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias17}"/></button></td>
                                                        <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias18}"/></button></td>
                                                        <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias19}"/></button></td>
                                                        <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias20}"/></button></td>
                                                    </tr>
                                                    <tr>
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
                                                        <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias21}"/></button></td>
                                                        <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias22}"/></button></td>
                                                        <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias23}"/></button></td>
                                                        <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias24}"/></button></td>
                                                        <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias25}"/></button></td>
                                                        <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias26}"/></button></td>
                                                        <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias27}"/></button></td>
                                                        <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias28}"/></button></td>
                                                        <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias29}"/></button></td>
                                                        <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias30}"/></button></td>
                                                    </tr>
                                                    </c:forEach>
                                                </tbody> 
                                               
                                        <%
                                    }
                                }
                                else  
                                {
                                    if(controlFiltrar.equals("Quincena 1"))
                                    {
                                         if(controlBuscar!=null)
                                        {   
                                            while(rs.next())
                                            {
                                                %>
                                                    <tbody>
                                                        <tr>
                                                           <td rowspan="6" class="align-middle"><%=rs.getString("Nombre")%></td>
                                                           <td class="align-middle">1</td>
                                                           <td class="align-middle">2</td>
                                                           <td class="align-middle">3</td>
                                                           <td class="align-middle">4</td>
                                                           <td class="align-middle">5</td>
                                                        </tr>   
                                                        <tr>
                                                            <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias1")%></button></td>
                                                            <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias2")%></button></td>
                                                            <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias3")%></button></td>
                                                            <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias4")%></button></td>
                                                            <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias5")%></button></td>
                                                        </tr>
                                                        <tr>
                                                           <td class="align-middle">6</td>
                                                           <td class="align-middle">7</td>
                                                           <td class="align-middle">8</td>
                                                           <td class="align-middle">9</td>
                                                           <td class="align-middle">10</td>
                                                        </tr> 
                                                        <tr>
                                                            <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias6")%></button></td>
                                                            <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias7")%></button></td>
                                                            <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias8")%></button></td>
                                                            <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias9")%></button></td>
                                                            <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias10")%></button></td>
                                                        </tr>
                                                        <tr>
                                                           <td class="align-middle">11</td>
                                                           <td class="align-middle">12</td>
                                                           <td class="align-middle">13</td>
                                                           <td class="align-middle">14</td>
                                                           <td class="align-middle">15</td>
                                                        </tr> 
                                                        <tr>
                                                            <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias11")%></button></td>
                                                            <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias12")%></button></td>
                                                            <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias13")%></button></td>
                                                            <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias14")%></button></td>
                                                            <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias15")%></button></td>
                                                        </tr>
                                                    </tbody> 
                                                <%
                                            }     
                                    }
                                    else
                                    {
                                        
                                            %>
                                                <tbody>
                                                    <c:forEach var="dato" items="${datos}">
                                                        <tr>
                                                           <td rowspan="6" class="align-middle"><c:out value="${dato.Nombre}"/></td>
                                                           <td class="align-middle">1</td>
                                                           <td class="align-middle">2</td>
                                                           <td class="align-middle">3</td>
                                                           <td class="align-middle">4</td>
                                                           <td class="align-middle">5</td>
                                                        </tr>    
                                                        <tr>
                                                            <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias1}"/></button></td>
                                                            <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias2}"/></button></td>
                                                            <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias3}"/></button></td>
                                                            <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias4}"/></button></td>
                                                            <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias5}"/></button></td>
                                                        </tr>
                                                        <tr>
                                                           <td class="align-middle">6</td>
                                                           <td class="align-middle">7</td>
                                                           <td class="align-middle">8</td>
                                                           <td class="align-middle">9</td>
                                                           <td class="align-middle">10</td>
                                                        </tr> 
                                                        <tr>
                                                            <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias6}"/></button></td>
                                                            <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias7}"/></button></td>
                                                            <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias8}"/></button></td>
                                                            <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias9}"/></button></td>
                                                            <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias10}"/></button></td>
                                                        </tr>
                                                        <tr>
                                                           <td class="align-middle">11</td>
                                                           <td class="align-middle">12</td>
                                                           <td class="align-middle">13</td>
                                                           <td class="align-middle">14</td>
                                                           <td class="align-middle">15</td>
                                                        </tr> 
                                                        <tr>
                                                            <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias11}"/></button></td>
                                                            <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias12}"/></button></td>
                                                            <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias13}"/></button></td>
                                                            <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias14}"/></button></td>
                                                            <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias15}"/></button></td>
                                                        </tr>
                                                        </c:forEach>
                                                    </tbody> 
                                            <%
                                        }
                                    }
                                    else
                                    {
                                        if(controlFiltrar.equals("Quincena 2"))
                                        {
                                            if(controlBuscar!=null)
                                            {   
                                                while(rs.next())
                                                {
                                                    %>
                                                    <tbody>
                                                        <tr>
                                                           <td rowspan="6" class="align-middle"><%=rs.getString("Nombre")%></td>
                                                           <td class="align-middle">16</td>
                                                           <td class="align-middle">17</td>
                                                           <td class="align-middle">18</td>
                                                           <td class="align-middle">19</td>
                                                           <td class="align-middle">20</td>
                                                        </tr>   
                                                        <tr>
                                                            <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias16")%></button></td>
                                                            <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias17")%></button></td>
                                                            <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias18")%></button></td>
                                                            <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias19")%></button></td>
                                                            <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias20")%></button></td>
                                                        </tr>
                                                        <tr>
                                                           <td class="align-middle">21</td>
                                                           <td class="align-middle">22</td>
                                                           <td class="align-middle">23</td>
                                                           <td class="align-middle">24</td>
                                                           <td class="align-middle">25</td>
                                                        </tr> 
                                                        <tr>
                                                            <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias21")%></button></td>
                                                            <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias22")%></button></td>
                                                            <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias23")%></button></td>
                                                            <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias24")%></button></td>
                                                            <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias25")%></button></td>
                                                        </tr>
                                                        <tr>
                                                           <td class="align-middle">26</td>
                                                           <td class="align-middle">27</td>
                                                           <td class="align-middle">28</td>
                                                           <td class="align-middle">29</td>
                                                           <td class="align-middle">30</td>
                                                        </tr> 
                                                        <tr>
                                                            <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias26")%></button></td>
                                                            <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias27")%></button></td>
                                                            <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias28")%></button></td>
                                                            <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias29")%></button></td>
                                                            <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><%=rs.getString("Alias30")%></button></td>
                                                        </tr>
                                                    </tbody> 
                                                    <%
                                                }     
                                            }
                                            else
                                            {
                                        
                                                    %>
                                                    <tbody>
                                                        <c:forEach var="dato" items="${datos}">
                                                            <tr>
                                                               <td rowspan="6" class="align-middle"><c:out value="${dato.Nombre}"/></td>
                                                               <td class="align-middle">16</td>
                                                               <td class="align-middle">17</td>
                                                               <td class="align-middle">18</td>
                                                               <td class="align-middle">19</td>
                                                               <td class="align-middle">20</td>
                                                            </tr>    
                                                            <tr>
                                                                <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias16}"/></button></td>
                                                                <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias17}"/></button></td>
                                                                <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias18}"/></button></td>
                                                                <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias19}"/></button></td>
                                                                <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias20}"/></button></td>
                                                            </tr>
                                                            <tr>
                                                               <td class="align-middle">21</td>
                                                               <td class="align-middle">22</td>
                                                               <td class="align-middle">23</td>
                                                               <td class="align-middle">24</td>
                                                               <td class="align-middle">25</td>

                                                            </tr> 
                                                            <tr>
                                                                <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias21}"/></button></td>
                                                                <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias22}"/></button></td>
                                                                <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias23}"/></button></td>
                                                                <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias24}"/></button></td>
                                                                <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias25}"/></button></td>
                                                            </tr>
                                                            <tr>
                                                               <td class="align-middle">26</td>
                                                               <td class="align-middle">27</td>
                                                               <td class="align-middle">28</td>
                                                               <td class="align-middle">29</td>
                                                               <td class="align-middle">30</td>
                                                            </tr> 
                                                            <tr>
                                                                <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias26}"/></button></td>
                                                                <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias27}"/></button></td>
                                                                <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias28}"/></button></td>
                                                                <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias29}"/></button></td>
                                                                <td class="align-middle"><button class="btn btn-link" data-toggle="modal" data-target="#exampleModalCenter"><c:out value="${dato.Alias30}"/></button></td>
                                                            </tr>
                                                            </c:forEach>
                                                        </tbody> 

                                                        <%
                                            }
                                        } 
                                    }
                                }
                            }
                            catch(Exception ex)
                            {
                                
                            }
                        %>

                            <!-- Modal -->
                            <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                              <div class="modal-dialog modal-dialog-centered" role="document">
                                <div class="modal-content">
                                  <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLongTitle">Cambiar Novedad</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                      <span aria-hidden="true">&times;</span>
                                    </button>
                                  </div>
                                    <div class="modal-body">
                                        <form:form method="post" commandName="estadisticas">
                                            <p>
                                                <label>Id_empleado</label>
                                                <input type="text" name="Id_empleado" placeholder="Id_empleado" id="Id_empleado" class="form-control"/>
                                            </p>
                                            <p>
                                                <label>Id_dia1</label>
                                                <input type="text" name="Id_dia1" placeholder="Id_dia1" id="Id_dia1" class="form-control"/>
                                            </p>
                                            <p>
                                                <label>Id_dia2</label>
                                                <input type="text" name="Id_dia2" placeholder="Id_dia2" id="Id_dia2" class="form-control"/>
                                            </p>
                                       </form:form>
                                    </div>
                                    <div class="modal-footer">
                                        <form:form method="post" commandName="estadisticas">
                                            <input type="submit" value="Guardar" class="btn btn-info form-control"/>
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                                        </form:form>
                                    </div>
                                </div>
                              </div>
                            </div>  
                    </table>   
                </div>
            </div>
        </div>
    </body>
</html>