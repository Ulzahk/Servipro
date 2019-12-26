<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
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
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Agregar Configuracion</title>
        <link rel="stylesheet" href="<c:url value="/Resources/CSS/style.css"/>"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
        <script src="https://kit.fontawesome.com/a076d05399.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </head>
    <body>
        
      <header>
        <%--Barra de Navegación de Jefe--%>
        <%
            if (Descripcion_perfil.equals("JEFE")) {

        %>       

        <jsp:include page="menujefe.jsp"></jsp:include>

        <%        }
        %>

        <%--Barra de Navegación de Coordinador--%>
        <%
            if (Descripcion_perfil.equals("COORDINADOR")) {
        %>

        <jsp:include page="menucordi.jsp"></jsp:include>

        <%
            }
        %> 
    </header>
        
         <div class="container mt-4">
            <h1 class="text-center">Agregar Configuracion</h1>
            <br>
            <div class="card border-info">
                <div class="card-header bg-info text-white">
                    <a href="configuracion.htm" class="btn btn-secondary"><i class="fas fa-arrow-left"></i></a>
                </div>
                <div class="card-body">
                <form:form method="post" commandName="configuracion">
                    <form:errors path="*" element="div" cssClass="alert alert-danger"/>
                    <p>
                        <form:label path="desconfiguracion"><b>Desconfiguracion</b></form:label>
                        <form:input path="desconfiguracion" cssClass="form-control"/>
                    </p>
                    <p>
                        <form:label path="desconfiguracion_d"><b>Desconfiguracion D.</b></form:label>
                        <form:input path="desconfiguracion_d" cssClass="form-control"/>
                    </p>
                    <p>
                        <form:label path="nombre_variable"><b>Nombre Variable</b></form:label>
                        <form:input path="nombre_variable" cssClass="form-control"/>
                    </p>
                    <p>
                        <form:label path="valor"><b>Valor</b></form:label>
                        <form:input path="valor" cssClass="form-control"/>
                    </p>
                    <p>
                        <label id="id_modulo"><b>Modulo</b></label>
                        <select id="id_modulo" name="id_modulo" class="form-control">
                            <option value="-1">SELECCIONE UN MODULO</option>
                            <%
                                try
                                {
                                    String Query="select * from nm_modulos";
                                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                                    Connection conn=DriverManager.getConnection("jdbc:sqlserver://10.0.0.98:1433;databaseName=sssacontable","contable19","contable19");
                                    Statement stm=conn.createStatement();
                                    ResultSet rs=stm.executeQuery(Query);
                                    while(rs.next()){
                                        %>
                                        <option value="<%=rs.getInt("Id_modulo")%>"><%=rs.getString("Nombre_modulo")%></option>
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
                    <hr/>
                    <input type="submit" value="Guardar" class="btn btn-info"/>
                </form:form>
                </div>
            </div>
        </div>
    </body>
      <script>
        $(document).ready(main);

        var contador = 1;

        function main() {
            $('.menu_bar').click(function () {
                if (contador == 1) {
                    $('nav').animate({
                        left: '0'
                    });
                    contador = 0;
                } else {
                    contador = 1;
                    $('nav').animate({
                        left: '-100%'
                    });
                }
            });

            // Mostramos y ocultamos submenus
            $('.submenu').click(function () {
                $(this).children('.children').slideToggle();
            });
        }
    </script>
</html>