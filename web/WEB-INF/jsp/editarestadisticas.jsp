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
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Editar Estadisticas</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
        <script src="https://kit.fontawesome.com/a076d05399.js"></script> 
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </head>
    <body>
        
        
        <div class="container mt-4">
            
            <div class="card border-info">
                    <div class="card-header bg-info text-white">
                        
                    </div>
                    <div class="card-body">
                        <form:form method="post" commandName="estadisticas" cssClass="row">
                            <form:errors path="*" element="div" cssClass="alert alert-danger"/>
                            <div class="col-12">
                                <p>
                                    <label for="id_empleado"><b>Empleado</b></label>
                                    <select id="id_empleado" name="id_empleado" class="form-control">
                                        <option value="-1">SELECCIONE NUEVAMENTE AL EMPLEADO</option>
                                        <%
                                            try
                                            {
                                                String Query="select * from nm_empleados";
                                                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                                                Connection conn=DriverManager.getConnection("jdbc:sqlserver://10.0.0.98:1433;databaseName=sssacontable","contable19","contable19");
                                                Statement stm=conn.createStatement();
                                                ResultSet rs=stm.executeQuery(Query);
                                                while(rs.next())
                                                {
                                                    %>
                                                    <option value="<%=rs.getInt("Id_empleado")%>" ><%=rs.getString("Nombre")%></option>
                                                    <%
      
                                                }
                                            }
                                            catch(Exception ex){
                                               ex.printStackTrace();
                                               out.println("Error "+ex.getMessage());
                                            }
                                        %>
                                    </select>
                                </p>
                                </div>
                                <div class="col-4">
                                <p>
                                    <label for="id_dia1"><b>Dia 1</b></label>
                                    <select id="id_dia1" name="id_dia1" class="form-control">
                                        <option value="-1">SELECCIONE NUEVAMENTE EL DIA 1</option>
                                        <%
                                            try
                                            {
                                                String Query="select * from nm_tipo_novedad";
                                                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                                                Connection conn=DriverManager.getConnection("jdbc:sqlserver://10.0.0.98:1433;databaseName=sssacontable","contable19","contable19");
                                                Statement stm=conn.createStatement();
                                                ResultSet rs=stm.executeQuery(Query);
                                                while(rs.next())
                                                {
                                                    %>
                                                    <option value="<%=rs.getInt("Id_novedad")%>"><%=rs.getString("Descripcion")%> (<%=rs.getString("Alias")%>)</option>
                                                    <%
                                                }
                                            }
                                            catch(Exception ex){
                                               ex.printStackTrace();
                                               out.println("Error "+ex.getMessage());
                                            }
                                        %>
                                    </select>
                                </p>
                                <p>
                                    <label for="id_dia2"><b>Dia 2</b></label>
                                    <select id="id_dia2" name="id_dia2" class="form-control">
                                        <option value="-1">SELECCIONE NUEVAMENTE EL DIA 2</option>
                                        <%
                                            try
                                            {
                                                String Query="select * from nm_tipo_novedad";
                                                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                                                Connection conn=DriverManager.getConnection("jdbc:sqlserver://10.0.0.98:1433;databaseName=sssacontable","contable19","contable19");
                                                Statement stm=conn.createStatement();
                                                ResultSet rs=stm.executeQuery(Query);
                                                while(rs.next())
                                                {
                                                    %>
                                                    <option value="<%=rs.getInt("Id_novedad")%>"><%=rs.getString("Descripcion")%> (<%=rs.getString("Alias")%>)</option>
                                                    <%
                                                }
                                            }
                                            catch(Exception ex){
                                               ex.printStackTrace();
                                               out.println("Error "+ex.getMessage());
                                            }
                                        %>
                                    </select>
                                </p>
                                <p>
                                    <label for="id_dia3"><b>Dia 3</b></label>
                                    <select id="id_dia3" name="id_dia3" class="form-control">
                                        <option value="-1">SELECCIONE NUEVAMENTE EL DIA 3</option>
                                        <%
                                            try
                                            {
                                                String Query="select * from nm_tipo_novedad";
                                                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                                                Connection conn=DriverManager.getConnection("jdbc:sqlserver://10.0.0.98:1433;databaseName=sssacontable","contable19","contable19");
                                                Statement stm=conn.createStatement();
                                                ResultSet rs=stm.executeQuery(Query);
                                                while(rs.next())
                                                {
                                                    %>
                                                    <option value="<%=rs.getInt("Id_novedad")%>"><%=rs.getString("Descripcion")%> (<%=rs.getString("Alias")%>)</option>
                                                    <%
                                                }
                                            }
                                            catch(Exception ex){
                                               ex.printStackTrace();
                                               out.println("Error "+ex.getMessage());
                                            }
                                        %>
                                    </select>
                                </p>
                                <p>
                                    <label for="id_dia4"><b>Dia 4</b></label>
                                    <select id="id_dia4" name="id_dia4" class="form-control">
                                        <option value="-1">SELECCIONE NUEVAMENTE EL DIA 4</option>
                                        <%
                                            try
                                            {
                                                String Query="select * from nm_tipo_novedad";
                                                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                                                Connection conn=DriverManager.getConnection("jdbc:sqlserver://10.0.0.98:1433;databaseName=sssacontable","contable19","contable19");
                                                Statement stm=conn.createStatement();
                                                ResultSet rs=stm.executeQuery(Query);
                                                while(rs.next())
                                                {
                                                    %>
                                                    <option value="<%=rs.getInt("Id_novedad")%>"><%=rs.getString("Descripcion")%> (<%=rs.getString("Alias")%>)</option>
                                                    <%
                                                }
                                            }
                                            catch(Exception ex){
                                               ex.printStackTrace();
                                               out.println("Error "+ex.getMessage());
                                            }
                                        %>
                                    </select>
                                </p>
                                <p>
                                    <label for="id_dia5"><b>Dia 5</b></label>
                                    <select id="id_dia5" name="id_dia5" class="form-control">
                                        <option value="-1">SELECCIONE NUEVAMENTE EL DIA 5</option>
                                        <%
                                            try
                                            {
                                                String Query="select * from nm_tipo_novedad";
                                                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                                                Connection conn=DriverManager.getConnection("jdbc:sqlserver://10.0.0.98:1433;databaseName=sssacontable","contable19","contable19");
                                                Statement stm=conn.createStatement();
                                                ResultSet rs=stm.executeQuery(Query);
                                                while(rs.next())
                                                {
                                                    %>
                                                    <option value="<%=rs.getInt("Id_novedad")%>"><%=rs.getString("Descripcion")%> (<%=rs.getString("Alias")%>)</option>
                                                    <%
                                                }
                                            }
                                            catch(Exception ex){
                                               ex.printStackTrace();
                                               out.println("Error "+ex.getMessage());
                                            }
                                        %>
                                    </select>
                                </p>
                                <p>
                                    <label for="id_dia6"><b>Dia 6</b></label>
                                    <select id="id_dia6" name="id_dia6" class="form-control">
                                        <option value="-1">SELECCIONE NUEVAMENTE EL DIA 6</option>
                                        <%
                                            try
                                            {
                                                String Query="select * from nm_tipo_novedad";
                                                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                                                Connection conn=DriverManager.getConnection("jdbc:sqlserver://10.0.0.98:1433;databaseName=sssacontable","contable19","contable19");
                                                Statement stm=conn.createStatement();
                                                ResultSet rs=stm.executeQuery(Query);
                                                while(rs.next())
                                                {
                                                    %>
                                                    <option value="<%=rs.getInt("Id_novedad")%>"><%=rs.getString("Descripcion")%> (<%=rs.getString("Alias")%>)</option>
                                                    <%
                                                }
                                            }
                                            catch(Exception ex){
                                               ex.printStackTrace();
                                               out.println("Error "+ex.getMessage());
                                            }
                                        %>
                                    </select>
                                </p>
                                <p>
                                    <label for="id_dia7"><b>Dia 7</b></label>
                                    <select id="id_dia7" name="id_dia7" class="form-control">
                                        <option value="-1">SELECCIONE NUEVAMENTE EL DIA 7</option>
                                        <%
                                            try
                                            {
                                                String Query="select * from nm_tipo_novedad";
                                                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                                                Connection conn=DriverManager.getConnection("jdbc:sqlserver://10.0.0.98:1433;databaseName=sssacontable","contable19","contable19");
                                                Statement stm=conn.createStatement();
                                                ResultSet rs=stm.executeQuery(Query);
                                                while(rs.next())
                                                {
                                                    %>
                                                    <option value="<%=rs.getInt("Id_novedad")%>"><%=rs.getString("Descripcion")%> (<%=rs.getString("Alias")%>)</option>
                                                    <%
                                                }
                                            }
                                            catch(Exception ex){
                                               ex.printStackTrace();
                                               out.println("Error "+ex.getMessage());
                                            }
                                        %>
                                    </select>
                                </p>
                                <p>
                                    <label for="id_dia1"><b>Dia 8</b></label>
                                    <select id="id_dia8" name="id_dia8" class="form-control">
                                        <option value="-1">SELECCIONE NUEVAMENTE EL DIA 8</option>
                                        <%
                                            try
                                            {
                                                String Query="select * from nm_tipo_novedad";
                                                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                                                Connection conn=DriverManager.getConnection("jdbc:sqlserver://10.0.0.98:1433;databaseName=sssacontable","contable19","contable19");
                                                Statement stm=conn.createStatement();
                                                ResultSet rs=stm.executeQuery(Query);
                                                while(rs.next())
                                                {
                                                    %>
                                                    <option value="<%=rs.getInt("Id_novedad")%>"><%=rs.getString("Descripcion")%> (<%=rs.getString("Alias")%>)</option>
                                                    <%
                                                }
                                            }
                                            catch(Exception ex){
                                               ex.printStackTrace();
                                               out.println("Error "+ex.getMessage());
                                            }
                                        %>
                                    </select>
                                </p>
                                <p>
                                    <label for="id_dia9"><b>Dia 9</b></label>
                                    <select id="id_dia9" name="id_dia9" class="form-control">
                                        <option value="-1">SELECCIONE NUEVAMENTE EL DIA 9</option>
                                        <%
                                            try
                                            {
                                                String Query="select * from nm_tipo_novedad";
                                                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                                                Connection conn=DriverManager.getConnection("jdbc:sqlserver://10.0.0.98:1433;databaseName=sssacontable","contable19","contable19");
                                                Statement stm=conn.createStatement();
                                                ResultSet rs=stm.executeQuery(Query);
                                                while(rs.next())
                                                {
                                                    %>
                                                    <option value="<%=rs.getInt("Id_novedad")%>"><%=rs.getString("Descripcion")%> (<%=rs.getString("Alias")%>)</option>
                                                    <%
                                                }
                                            }
                                            catch(Exception ex){
                                               ex.printStackTrace();
                                               out.println("Error "+ex.getMessage());
                                            }
                                        %>
                                    </select>
                                </p>
                                <p>
                                    <label for="id_dia10"><b>Dia 10</b></label>
                                    <select id="id_dia10" name="id_dia10" class="form-control">
                                        <option value="-1">SELECCIONE NUEVAMENTE EL DIA 10</option>
                                        <%
                                            try
                                            {
                                                String Query="select * from nm_tipo_novedad";
                                                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                                                Connection conn=DriverManager.getConnection("jdbc:sqlserver://10.0.0.98:1433;databaseName=sssacontable","contable19","contable19");
                                                Statement stm=conn.createStatement();
                                                ResultSet rs=stm.executeQuery(Query);
                                                while(rs.next())
                                                {
                                                    %>
                                                    <option value="<%=rs.getInt("Id_novedad")%>"><%=rs.getString("Descripcion")%> (<%=rs.getString("Alias")%>)</option>
                                                    <%
                                                }
                                            }
                                            catch(Exception ex){
                                               ex.printStackTrace();
                                               out.println("Error "+ex.getMessage());
                                            }
                                        %>
                                    </select>
                                </p>
                                </div>
                                <div class="col-4 border border-top-0 border-right-0 border-bottom-0">
                                <p>
                                    <label for="id_dia11"><b>Dia 11</b></label>
                                    <select id="id_dia11" name="id_dia11" class="form-control">
                                        <option value="-1">SELECCIONE NUEVAMENTE EL DIA 11</option>
                                        <%
                                            try
                                            {
                                                String Query="select * from nm_tipo_novedad";
                                                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                                                Connection conn=DriverManager.getConnection("jdbc:sqlserver://10.0.0.98:1433;databaseName=sssacontable","contable19","contable19");
                                                Statement stm=conn.createStatement();
                                                ResultSet rs=stm.executeQuery(Query);
                                                while(rs.next())
                                                {
                                                    %>
                                                    <option value="<%=rs.getInt("Id_novedad")%>"><%=rs.getString("Descripcion")%> (<%=rs.getString("Alias")%>)</option>
                                                    <%
                                                }
                                            }
                                            catch(Exception ex){
                                               ex.printStackTrace();
                                               out.println("Error "+ex.getMessage());
                                            }
                                        %>
                                    </select>
                                </p>
                                <p>
                                    <label for="id_dia12"><b>Dia 12</b></label>
                                    <select id="id_dia12" name="id_dia12" class="form-control">
                                        <option value="-1">SELECCIONE NUEVAMENTE EL DIA 12</option>
                                        <%
                                            try
                                            {
                                                String Query="select * from nm_tipo_novedad";
                                                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                                                Connection conn=DriverManager.getConnection("jdbc:sqlserver://10.0.0.98:1433;databaseName=sssacontable","contable19","contable19");
                                                Statement stm=conn.createStatement();
                                                ResultSet rs=stm.executeQuery(Query);
                                                while(rs.next())
                                                {
                                                    %>
                                                    <option value="<%=rs.getInt("Id_novedad")%>"><%=rs.getString("Descripcion")%> (<%=rs.getString("Alias")%>)</option>
                                                    <%
                                                }
                                            }
                                            catch(Exception ex){
                                               ex.printStackTrace();
                                               out.println("Error "+ex.getMessage());
                                            }
                                        %>
                                    </select>
                                </p>
                                <p>
                                    <label for="id_dia13"><b>Dia 13</b></label>
                                    <select id="id_dia13" name="id_dia13" class="form-control">
                                        <option value="-1">SELECCIONE NUEVAMENTE EL DIA 13</option>
                                        <%
                                            try
                                            {
                                                String Query="select * from nm_tipo_novedad";
                                                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                                                Connection conn=DriverManager.getConnection("jdbc:sqlserver://10.0.0.98:1433;databaseName=sssacontable","contable19","contable19");
                                                Statement stm=conn.createStatement();
                                                ResultSet rs=stm.executeQuery(Query);
                                                while(rs.next())
                                                {
                                                    %>
                                                    <option value="<%=rs.getInt("Id_novedad")%>"><%=rs.getString("Descripcion")%> (<%=rs.getString("Alias")%>)</option>
                                                    <%
                                                }
                                            }
                                            catch(Exception ex){
                                               ex.printStackTrace();
                                               out.println("Error "+ex.getMessage());
                                            }
                                        %>
                                    </select>
                                </p>
                                <p>
                                    <label for="id_dia14"><b>Dia 14</b></label>
                                    <select id="id_dia14" name="id_dia14" class="form-control">
                                        <option value="-1">SELECCIONE NUEVAMENTE EL DIA 14</option>
                                        <%
                                            try
                                            {
                                                String Query="select * from nm_tipo_novedad";
                                                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                                                Connection conn=DriverManager.getConnection("jdbc:sqlserver://10.0.0.98:1433;databaseName=sssacontable","contable19","contable19");
                                                Statement stm=conn.createStatement();
                                                ResultSet rs=stm.executeQuery(Query);
                                                while(rs.next())
                                                {
                                                    %>
                                                    <option value="<%=rs.getInt("Id_novedad")%>"><%=rs.getString("Descripcion")%> (<%=rs.getString("Alias")%>)</option>
                                                    <%
                                                }
                                            }
                                            catch(Exception ex){
                                               ex.printStackTrace();
                                               out.println("Error "+ex.getMessage());
                                            }
                                        %>
                                    </select>
                                </p>
                                <p>
                                    <label for="id_dia15"><b>Dia 15</b></label>
                                    <select id="id_dia15" name="id_dia15" class="form-control">
                                        <option value="-1">SELECCIONE NUEVAMENTE EL DIA 15</option>
                                        <%
                                            try
                                            {
                                                String Query="select * from nm_tipo_novedad";
                                                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                                                Connection conn=DriverManager.getConnection("jdbc:sqlserver://10.0.0.98:1433;databaseName=sssacontable","contable19","contable19");
                                                Statement stm=conn.createStatement();
                                                ResultSet rs=stm.executeQuery(Query);
                                                while(rs.next())
                                                {
                                                    %>
                                                    <option value="<%=rs.getInt("Id_novedad")%>"><%=rs.getString("Descripcion")%> (<%=rs.getString("Alias")%>)</option>
                                                    <%
                                                }
                                            }
                                            catch(Exception ex){
                                               ex.printStackTrace();
                                               out.println("Error "+ex.getMessage());
                                            }
                                        %>
                                    </select>
                                </p>
                                <p>
                                    <label for="id_dia16"><b>Dia 16</b></label>
                                    <select id="id_dia16" name="id_dia16" class="form-control">
                                        <option value="-1">SELECCIONE NUEVAMENTE EL DIA 16</option>
                                        <%
                                            try
                                            {
                                                String Query="select * from nm_tipo_novedad";
                                                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                                                Connection conn=DriverManager.getConnection("jdbc:sqlserver://10.0.0.98:1433;databaseName=sssacontable","contable19","contable19");
                                                Statement stm=conn.createStatement();
                                                ResultSet rs=stm.executeQuery(Query);
                                                while(rs.next())
                                                {
                                                    %>
                                                    <option value="<%=rs.getInt("Id_novedad")%>"><%=rs.getString("Descripcion")%> (<%=rs.getString("Alias")%>)</option>
                                                    <%
                                                }
                                            }
                                            catch(Exception ex){
                                               ex.printStackTrace();
                                               out.println("Error "+ex.getMessage());
                                            }
                                        %>
                                    </select>
                                </p>
                                <p>
                                    <label for="id_dia17"><b>Dia 17</b></label>
                                    <select id="id_dia17" name="id_dia17" class="form-control">
                                        <option value="-1">SELECCIONE NUEVAMENTE EL DIA 17</option>
                                        <%
                                            try
                                            {
                                                String Query="select * from nm_tipo_novedad";
                                                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                                                Connection conn=DriverManager.getConnection("jdbc:sqlserver://10.0.0.98:1433;databaseName=sssacontable","contable19","contable19");
                                                Statement stm=conn.createStatement();
                                                ResultSet rs=stm.executeQuery(Query);
                                                while(rs.next())
                                                {
                                                    %>
                                                    <option value="<%=rs.getInt("Id_novedad")%>"><%=rs.getString("Descripcion")%> (<%=rs.getString("Alias")%>)</option>
                                                    <%
                                                }
                                            }
                                            catch(Exception ex){
                                               ex.printStackTrace();
                                               out.println("Error "+ex.getMessage());
                                            }
                                        %>
                                    </select>
                                </p>
                                <p>
                                    <label for="id_dia18"><b>Dia 18</b></label>
                                    <select id="id_dia18" name="id_dia18" class="form-control">
                                        <option value="-1">SELECCIONE NUEVAMENTE EL DIA 18</option>
                                        <%
                                            try
                                            {
                                                String Query="select * from nm_tipo_novedad";
                                                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                                                Connection conn=DriverManager.getConnection("jdbc:sqlserver://10.0.0.98:1433;databaseName=sssacontable","contable19","contable19");
                                                Statement stm=conn.createStatement();
                                                ResultSet rs=stm.executeQuery(Query);
                                                while(rs.next())
                                                {
                                                    %>
                                                    <option value="<%=rs.getInt("Id_novedad")%>"><%=rs.getString("Descripcion")%> (<%=rs.getString("Alias")%>)</option>
                                                    <%
                                                }
                                            }
                                            catch(Exception ex){
                                               ex.printStackTrace();
                                               out.println("Error "+ex.getMessage());
                                            }
                                        %>
                                    </select>
                                </p>
                                <p>
                                    <label for="id_dia19"><b>Dia 19</b></label>
                                    <select id="id_dia19" name="id_dia19" class="form-control">
                                        <option value="-1">SELECCIONE NUEVAMENTE EL DIA 19</option>
                                        <%
                                            try
                                            {
                                                String Query="select * from nm_tipo_novedad";
                                                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                                                Connection conn=DriverManager.getConnection("jdbc:sqlserver://10.0.0.98:1433;databaseName=sssacontable","contable19","contable19");
                                                Statement stm=conn.createStatement();
                                                ResultSet rs=stm.executeQuery(Query);
                                                while(rs.next())
                                                {
                                                    %>
                                                    <option value="<%=rs.getInt("Id_novedad")%>"><%=rs.getString("Descripcion")%> (<%=rs.getString("Alias")%>)</option>
                                                    <%
                                                }
                                            }
                                            catch(Exception ex){
                                               ex.printStackTrace();
                                               out.println("Error "+ex.getMessage());
                                            }
                                        %>
                                    </select>
                                </p>
                                <p>
                                    <label for="id_dia20"><b>Dia 20</b></label>
                                    <select id="id_dia20" name="id_dia20" class="form-control">
                                        <option value="-1">SELECCIONE NUEVAMENTE EL DIA 20</option>
                                        <%
                                            try
                                            {
                                                String Query="select * from nm_tipo_novedad";
                                                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                                                Connection conn=DriverManager.getConnection("jdbc:sqlserver://10.0.0.98:1433;databaseName=sssacontable","contable19","contable19");
                                                Statement stm=conn.createStatement();
                                                ResultSet rs=stm.executeQuery(Query);
                                                while(rs.next())
                                                {
                                                    %>
                                                    <option value="<%=rs.getInt("Id_novedad")%>"><%=rs.getString("Descripcion")%> (<%=rs.getString("Alias")%>)</option>
                                                    <%
                                                }
                                            }
                                            catch(Exception ex){
                                               ex.printStackTrace();
                                               out.println("Error "+ex.getMessage());
                                            }
                                        %>
                                    </select>
                                </p>
                                </div>
                                <div class="col-4 border border-top-0 border-right-0 border-bottom-0">
                                <p>
                                    <label for="id_dia21"><b>Dia 21</b></label>
                                    <select id="id_dia21" name="id_dia21" class="form-control">
                                        <option value="-1">SELECCIONE NUEVAMENTE EL DIA 21</option>
                                        <%
                                            try
                                            {
                                                String Query="select * from nm_tipo_novedad";
                                                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                                                Connection conn=DriverManager.getConnection("jdbc:sqlserver://10.0.0.98:1433;databaseName=sssacontable","contable19","contable19");
                                                Statement stm=conn.createStatement();
                                                ResultSet rs=stm.executeQuery(Query);
                                                while(rs.next())
                                                {
                                                    %>
                                                    <option value="<%=rs.getInt("Id_novedad")%>"><%=rs.getString("Descripcion")%> (<%=rs.getString("Alias")%>)</option>
                                                    <%
                                                }
                                            }
                                            catch(Exception ex){
                                               ex.printStackTrace();
                                               out.println("Error "+ex.getMessage());
                                            }
                                        %>
                                    </select>
                                </p>
                                <p>
                                    <label for="id_dia22"><b>Dia 22</b></label>
                                    <select id="id_dia22" name="id_dia22" class="form-control">
                                        <option value="-1">SELECCIONE NUEVAMENTE EL DIA 22</option>
                                        <%
                                            try
                                            {
                                                String Query="select * from nm_tipo_novedad";
                                                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                                                Connection conn=DriverManager.getConnection("jdbc:sqlserver://10.0.0.98:1433;databaseName=sssacontable","contable19","contable19");
                                                Statement stm=conn.createStatement();
                                                ResultSet rs=stm.executeQuery(Query);
                                                while(rs.next())
                                                {
                                                    %>
                                                    <option value="<%=rs.getInt("Id_novedad")%>"><%=rs.getString("Descripcion")%> (<%=rs.getString("Alias")%>)</option>
                                                    <%
                                                }
                                            }
                                            catch(Exception ex){
                                               ex.printStackTrace();
                                               out.println("Error "+ex.getMessage());
                                            }
                                        %>
                                    </select>
                                </p>
                                <p>
                                    <label for="id_dia23"><b>Dia 23</b></label>
                                    <select id="id_dia23" name="id_dia23" class="form-control">
                                        <option value="-1">SELECCIONE NUEVAMENTE EL DIA 23</option>
                                        <%
                                            try
                                            {
                                                String Query="select * from nm_tipo_novedad";
                                                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                                                Connection conn=DriverManager.getConnection("jdbc:sqlserver://10.0.0.98:1433;databaseName=sssacontable","contable19","contable19");
                                                Statement stm=conn.createStatement();
                                                ResultSet rs=stm.executeQuery(Query);
                                                while(rs.next())
                                                {
                                                    %>
                                                    <option value="<%=rs.getInt("Id_novedad")%>"><%=rs.getString("Descripcion")%> (<%=rs.getString("Alias")%>)</option>
                                                    <%
                                                }
                                            }
                                            catch(Exception ex){
                                               ex.printStackTrace();
                                               out.println("Error "+ex.getMessage());
                                            }
                                        %>
                                    </select>
                                </p>
                                <p>
                                    <label for="id_dia24"><b>Dia 24</b></label>
                                    <select id="id_dia24" name="id_dia24" class="form-control">
                                        <option value="-1">SELECCIONE NUEVAMENTE EL DIA 24</option>
                                        <%
                                            try
                                            {
                                                String Query="select * from nm_tipo_novedad";
                                                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                                                Connection conn=DriverManager.getConnection("jdbc:sqlserver://10.0.0.98:1433;databaseName=sssacontable","contable19","contable19");
                                                Statement stm=conn.createStatement();
                                                ResultSet rs=stm.executeQuery(Query);
                                                while(rs.next())
                                                {
                                                    %>
                                                    <option value="<%=rs.getInt("Id_novedad")%>"><%=rs.getString("Descripcion")%> (<%=rs.getString("Alias")%>)</option>
                                                    <%
                                                }
                                            }
                                            catch(Exception ex){
                                               ex.printStackTrace();
                                               out.println("Error "+ex.getMessage());
                                            }
                                        %>
                                    </select>
                                </p>
                                <p>
                                    <label for="id_dia25"><b>Dia 25</b></label>
                                    <select id="id_dia25" name="id_dia25" class="form-control">
                                        <option value="-1">SELECCIONE NUEVAMENTE EL DIA 25</option>
                                        <%
                                            try
                                            {
                                                String Query="select * from nm_tipo_novedad";
                                                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                                                Connection conn=DriverManager.getConnection("jdbc:sqlserver://10.0.0.98:1433;databaseName=sssacontable","contable19","contable19");
                                                Statement stm=conn.createStatement();
                                                ResultSet rs=stm.executeQuery(Query);
                                                while(rs.next())
                                                {
                                                    %>
                                                    <option value="<%=rs.getInt("Id_novedad")%>"><%=rs.getString("Descripcion")%> (<%=rs.getString("Alias")%>)</option>
                                                    <%
                                                }
                                            }
                                            catch(Exception ex){
                                               ex.printStackTrace();
                                               out.println("Error "+ex.getMessage());
                                            }
                                        %>
                                    </select>
                                </p>
                                <p>
                                    <label for="id_dia26"><b>Dia 26</b></label>
                                    <select id="id_dia26" name="id_dia26" class="form-control">
                                        <option value="-1">SELECCIONE NUEVAMENTE EL DIA 26</option>
                                        <%
                                            try
                                            {
                                                String Query="select * from nm_tipo_novedad";
                                                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                                                Connection conn=DriverManager.getConnection("jdbc:sqlserver://10.0.0.98:1433;databaseName=sssacontable","contable19","contable19");
                                                Statement stm=conn.createStatement();
                                                ResultSet rs=stm.executeQuery(Query);
                                                while(rs.next())
                                                {
                                                    %>
                                                    <option value="<%=rs.getInt("Id_novedad")%>"><%=rs.getString("Descripcion")%> (<%=rs.getString("Alias")%>)</option>
                                                    <%
                                                }
                                            }
                                            catch(Exception ex){
                                               ex.printStackTrace();
                                               out.println("Error "+ex.getMessage());
                                            }
                                        %>
                                    </select>
                                </p>
                                <p>
                                    <label for="id_dia27"><b>Dia 27</b></label>
                                    <select id="id_dia27" name="id_dia27" class="form-control">
                                        <option value="-1">SELECCIONE NUEVAMENTE EL DIA 27</option>
                                        <%
                                            try
                                            {
                                                String Query="select * from nm_tipo_novedad";
                                                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                                                Connection conn=DriverManager.getConnection("jdbc:sqlserver://10.0.0.98:1433;databaseName=sssacontable","contable19","contable19");
                                                Statement stm=conn.createStatement();
                                                ResultSet rs=stm.executeQuery(Query);
                                                while(rs.next())
                                                {
                                                    %>
                                                    <option value="<%=rs.getInt("Id_novedad")%>"><%=rs.getString("Descripcion")%> (<%=rs.getString("Alias")%>)</option>
                                                    <%
                                                }
                                            }
                                            catch(Exception ex){
                                               ex.printStackTrace();
                                               out.println("Error "+ex.getMessage());
                                            }
                                        %>
                                    </select>
                                </p>
                                <p>
                                    <label for="id_dia28"><b>Dia 28</b></label>
                                    <select id="id_dia28" name="id_dia28" class="form-control">
                                        <option value="-1">SELECCIONE NUEVAMENTE EL DIA 28</option>
                                        <%
                                            try
                                            {
                                                String Query="select * from nm_tipo_novedad";
                                                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                                                Connection conn=DriverManager.getConnection("jdbc:sqlserver://10.0.0.98:1433;databaseName=sssacontable","contable19","contable19");
                                                Statement stm=conn.createStatement();
                                                ResultSet rs=stm.executeQuery(Query);
                                                while(rs.next())
                                                {
                                                    %>
                                                    <option value="<%=rs.getInt("Id_novedad")%>"><%=rs.getString("Descripcion")%> (<%=rs.getString("Alias")%>)</option>
                                                    <%
                                                }
                                            }
                                            catch(Exception ex){
                                               ex.printStackTrace();
                                               out.println("Error "+ex.getMessage());
                                            }
                                        %>
                                    </select>
                                </p>
                                <p>
                                    <label for="id_dia29"><b>Dia 29</b></label>
                                    <select id="id_dia29" name="id_dia29" class="form-control">
                                        <option value="-1">SELECCIONE NUEVAMENTE EL DIA 29</option>
                                        <%
                                            try
                                            {
                                                String Query="select * from nm_tipo_novedad";
                                                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                                                Connection conn=DriverManager.getConnection("jdbc:sqlserver://10.0.0.98:1433;databaseName=sssacontable","contable19","contable19");
                                                Statement stm=conn.createStatement();
                                                ResultSet rs=stm.executeQuery(Query);
                                                while(rs.next())
                                                {
                                                    %>
                                                    <option value="<%=rs.getInt("Id_novedad")%>"><%=rs.getString("Descripcion")%> (<%=rs.getString("Alias")%>)</option>
                                                    <%
                                                }
                                            }
                                            catch(Exception ex){
                                               ex.printStackTrace();
                                               out.println("Error "+ex.getMessage());
                                            }
                                        %>
                                    </select>
                                </p>
                                <p>
                                    <label for="id_dia30"><b>Dia 30</b></label>
                                    <select id="id_dia30" name="id_dia30" class="form-control">
                                        <option value="-1">SELECCIONE NUEVAMENTE EL DIA 30</option>
                                        <%
                                            try
                                            {
                                                String Query="select * from nm_tipo_novedad";
                                                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                                                Connection conn=DriverManager.getConnection("jdbc:sqlserver://10.0.0.98:1433;databaseName=sssacontable","contable19","contable19");
                                                Statement stm=conn.createStatement();
                                                ResultSet rs=stm.executeQuery(Query);
                                                while(rs.next())
                                                {
                                                    %>
                                                    <option value="<%=rs.getInt("Id_novedad")%>"><%=rs.getString("Descripcion")%> (<%=rs.getString("Alias")%>)</option>
                                                    <%
                                                }
                                            }
                                            catch(Exception ex){
                                               ex.printStackTrace();
                                               out.println("Error "+ex.getMessage());
                                            }
                                        %>
                                    </select>
                                </p>
                            </div>
                            <div class="col-12">
                                <hr/>
                                <input type="submit" value="Guardar" class="btn btn-info"/>
                            </div>
                        </form:form>
                    </div>
           </div>
        </div>
    </body>
</html>
