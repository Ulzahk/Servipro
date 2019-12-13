<%@page import="java.math.BigInteger"%>
<%@page import="java.security.MessageDigest"%>
<%@page import="Utils.Encriptar"%>
<%@page import="java.sql.*"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession objsesion = request.getSession(false);
    String id_usuario = (String)objsesion.getAttribute("id_usuario");
    String Descripcion_perfil = (String)objsesion.getAttribute("descripcion_perfil");
    if(id_usuario==null){
        response.sendRedirect("login.jsp");
    }else{
        if(Descripcion_perfil.equals("ADMINISTRADOR")||
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
        <title>Editar Usuario</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </head>
    <body>
        
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
        
        <%--Barra de Navegación de Administrador--%>
        <%
            if(Descripcion_perfil.equals("ADMINISTRADOR")){

                out.println("<nav class='navbar navbar-expand-sm bg-info navbar-dark justify-content-center'>");
                    out.println("<a class='navbar-brand' href='index.htm'>ServiSoft S.A.</a>");
                    out.println("<div>");
                        out.println("<ul class='navbar-nav'>");
                            out.println("<li class='nav-item dropdown'>");
                                out.println("<a class='nav-link dropdown-toggle' href='#' id='navbardrop' data-toggle='dropdown'>");
                                    out.println("Usuarios");
                                out.println("</a>");
                                    out.println("<div class='dropdown-menu'>");
                                        out.println("<a class='dropdown-item' href='usuarios.htm'>Tabla de Usuarios</a>");
                                    out.println("</div>");;
                            out.println("</li>");
                            out.println("<li class='nav-item dropdown'>");
                                out.println("<a class='nav-link dropdown-toggle' href='#' id='navbardrop' data-toggle='dropdown'>");
                                    out.println("Perfil");
                                out.println("</a>");
                                    out.println("<div class='dropdown-menu'>");
                                        out.println("<a class='dropdown-item' href='perfil.htm'>Tabla de Perfil</a>");
                                    out.println("</div>");;
                            out.println("</li>");
                            out.println("<li class='nav-item dropdown'>");
                                out.println("<a class='nav-link dropdown-toggle' href='#' id='navbardrop' data-toggle='dropdown'>");
                                    out.println("Modulos");
                                out.println("</a>");
                                out.println("<div class='dropdown-menu'>");
                                    out.println("<a class='dropdown-item' href='modulos.htm'>Tabla Modulos</a>");
                                out.println("</div>");
                            out.println("</li>");
                            out.println("<li class='nav-item dropdown'>");
                                out.println("<a class='nav-link dropdown-toggle' href='#' id='navbardrop' data-toggle='dropdown'>");
                                    out.println("Modulos por Perfil");
                                out.println("</a>");
                                out.println("<div class='dropdown-menu'>");
                                    out.println("<a class='dropdown-item' href='modulosperfil.htm'>Tabla Modulos por Perfil</a>");
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
        
                <%
            HttpSession sesion = request.getSession();
            if(sesion.getAttribute("id_usuario")== null  || sesion.getAttribute("id_usuario").equals("0")){
                response.sendRedirect("login.jsp");
            }
            Connection conn=null;
            
        %>
        
        <div class="container mt-4">
            <h1 class="text-center">Editar Usuario</h1>
            <br>
            <div class="card border-info">
                <div class="card-header bg-info text-white">
                    <a href="usuarios.htm" class="btn btn-secondary"><i class="fas fa-arrow-left"></i></a>
                </div>
                <div class="card-body">
                    <form:form method="post" commandName="usuarios">
                        <form:errors path="*" element="div" cssClass="alert alert-danger"/>
                        <p>
                        <label for="id_empleado"><b>Empleado</b></label>
                        <select id="id_empleado" name="id_empleado" class="form-control">
                            <option value="-1">SELECCIONE NUEVAMENTE AL EMPLEADO</option>
                            <%
                                try
                                {
                                   String Query="select * from nm_empleadosjsp";
                                   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                                   conn=DriverManager.getConnection("jdbc:sqlserver://10.0.0.98:1433;databaseName=sssacontable","contable19","contable19");
                                   Statement stm=conn.createStatement();
                                   ResultSet rs=stm.executeQuery(Query);
                                   while(rs.next())
                                   {
                                       %>
                                       <option value="<%=rs.getInt("emplId")%>"><%=rs.getString("emplNombre")%></option>
                                       <%
                                   }
                                }
                                catch(Exception ex)
                                {
                                    ex.printStackTrace();
                                    out.println("Error "+ex.getMessage());
                                }
                            %>
                        </select> 
                        </p>
                        <p>
                        <label for="id_perfil" id="id_perfil"><b>Perfil</b></label>
                            <select id="id_perfil" name="id_perfil" class="form-control">
                                <option value="-1">SELECCIONE UN PERFIL</option>
                                <%
                                    try
                                    {
                                     String Query="select * from nm_perfil";
                                     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                                        conn=DriverManager.getConnection("jdbc:sqlserver://10.0.0.98:1433;databaseName=sssacontable","contable19","contable19");
                                        Statement stm=conn.createStatement();
                                        ResultSet rs=stm.executeQuery(Query);
                                        while(rs.next()){
                                            %>
                                            <option value="<%=rs.getInt("Id_perfil")%>"><%=rs.getString("Descripcion_perfil")%></option>
                                            <%
                                            
                                     }
                                    }    
                                    catch( Exception ex)
                                    {  
                                        ex.printStackTrace();
                                        out.println("Error "+ex.getMessage());
                                    }      
                                %>    
                            </select>                            
                        </p> 
                        <p>
                            <form:label path="contraseña"><b>Contraseña</b></form:label>
                            <form:input path="contraseña" id="contraseña" cssClass="form-control"/>
                        </p>
                        <p>
                            <form:label path="" ><b>Confirmar Contraseña</b></form:label>
                            <form:input path="" id="ccontraseña"  Class="form-control"/>
                        </p>
                    <hr/>
                        <input type="submit" id="Guardar" value="Guardar" name="btnGuardar" class="btn btn-info"/>
                    </form:form>
                </div>
            </div>
        </div>
    </body>
<%
    if(request.getParameter("btnGuardar")!= null){
        String contraseña = request.getParameter("txtContraseña");
        String ccontraseña = request.getParameter("txtConfirmarContraseña");
        int id_empleado = Integer.parseInt(request.getParameter("id_empleado"));
        int id_perfil = Integer.parseInt(request.getParameter("id_perfil"));
            if(contraseña.equals(ccontraseña)){
                try{
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    conn=DriverManager.getConnection("jdbc:sqlserver://10.0.0.98:1433;databaseName=sssacontable","contable19","contable19");
                    PreparedStatement ps = conn.prepareStatement("UPDATE nm_usuarios SET (Id_usuario="+id_usuario+",Contraseña="+contraseña+",Id_empleado="+id_empleado+",Id_perfil="+id_perfil+")WHERE Id_usuario="+id_usuario+";"); 
                    ps.setString(0, id_usuario);
                    ps.setString(1, contraseña);
                    ps.setInt(2, id_empleado);
                    ps.setInt(3, id_perfil);
                    ps.execute();
                    response.sendRedirect("index.htm");
                }catch(Exception ex){
                    out.println(ex);
                }           
            }
            else{
                out.println("La contraseña no Coincide");
            }
    }
    
    %>
</html>
<%!
    public String getMD5(String input){
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte [] encBytes = md.digest(input.getBytes());
            BigInteger numero = new  BigInteger(1, encBytes);
            String encString = numero.toString(16);
            while (encString.length()<32){
                encString = "0" + encString;
            }
            return encString;
        }catch (Exception ex){
            throw new RuntimeException (ex); 
        }
    }
%>
