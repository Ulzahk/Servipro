<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.math.BigInteger"%>
<%@page import="java.security.MessageDigest"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="Utils.Encriptar"%>
<%@page import="Utils.Encriptar.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Iniciar Sesión</title>
        <link rel="stylesheet"  type="text/css" href="<c:url value="/Resources/CSS/stylelogin.css"/>"/>
        <script src="Resources/JS/functions.js"></script>

    </head>
    <body background="Resources/Images/city.png" style="background-repeat: no-repeat; background-position: center center; background-size: cover;">
        <%
            Modelos.Usuarios.clsUsuarios obclsUsuarios = new Modelos.Usuarios.clsUsuarios();

            if (request.getAttribute("obclsUsuarios") != null) {
                obclsUsuarios = (Modelos.Usuarios.clsUsuarios) request.getAttribute("obclsUsuarios");
            }

            List<Modelos.Usuarios.clsUsuarios> lstclsUsuarios = new ArrayList<Modelos.Usuarios.clsUsuarios>();

            if (request.getAttribute("lstclsUsuarios") != null) {

                lstclsUsuarios = (List<Modelos.Usuarios.clsUsuarios>) request.getAttribute("lstclsUsuarios");
            }
        %>
        <div class="loginbox">
            <img src="<c:url value="/Resources/Images/LogoUsuario.png"/>" class="avatar"/>
            <img src="<c:url value="/Resources/Images/unnamed.png"/>" class="imgLogo"/>
            <h1>Iniciar Sesión</h1>
            <form action="logear" method="post" id="forminicio">
                <input type="text" name="id_usuario" placeholder="Usuario" id="txtusuario"/>                   
                <input type="password" name="contraseña" id="txtpass" placeholder="Contraseña"/>
                <input type="button" value="Acceder"  id="btniniciar" onclick="formValidation();"/>
                <input type="hidden" name="id" value="txtusuario"
                       <label id="lblerror" ></label>
            </form>
            <%
                Connection conn = null;
                Statement st = null;
                ResultSet rs = null;
                Encriptar enc = new Encriptar();

                if (request.getParameter("login") != null) {
                    String user = request.getParameter("txtusuario");
                    String password = request.getParameter("txtpass");
                    String hash = enc.getMD5(password);

                    HttpSession sesion = request.getSession();

                    try {
                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                        conn = DriverManager.getConnection("jdbc:sqlserver://10.0.0.98:1433;databaseName=sssacontable", "contable19", "contable19");
                        st = conn.createStatement();
                        rs = st.executeQuery("SELECT * FROM nm_usuarios where contraseña='" + password + "'; ");

                        while (rs.next()) {
                            sesion.setAttribute("logueado", "1");
                            sesion.setAttribute("user", rs.getString("user"));
                            sesion.setAttribute("id", rs.getString("id"));
                            response.sendRedirect("index.jsp");
                        }
                        out.println(" <div class=\"alert alert-danger\" role=\"alert\">Usuario no valido</div>");
                    } catch (Exception ex) {

                    }
                }
            %>
        </div>                
    </body>
</html>
