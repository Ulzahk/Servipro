<%@page import="java.math.BigInteger"%>
<%@page import="java.security.MessageDigest"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="Utils.Encriptar"%>
<%@page import="Utils.Encriptar.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Iniciar Sesión</title>
        <link rel="stylesheet"  type="text/css" href="<c:url value="/Resources/CSS/stylelogin.css"/>"/>
        <script src="Resources/JS/functions.js"></script>

    </head>
    <body background="Resources/Images/city.png" style="background-repeat: no-repeat; background-position: center center; background-size: cover;">
        <div class="loginbox">
            <img src="<c:url value="/Resources/Images/LogoUsuario.png"/>" class="avatar"/>
            <img src="<c:url value="/Resources/Images/unnamed.png"/>" class="imgLogo"/>
            <h1>Iniciar Sesión</h1>
            <form action="logear" method="post" id="forminicio">
                <p>Perfiles:</p>
                <span class="custom-dropdown">
                    <select name="descripcion_perfil" id="txtperfil">
                        <option value="">Seleccione una opción</option>
                        <option value="JEFE">Jefe</option>
                        <option value="ADMINISTRADOR">Administrador</option>
                        <option value="COORDINADOR">Coordinador</option>
                    </select>
                </span>
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
                    String perfil = request.getParameter("txtperfil");
                    String user = request.getParameter("txtusuario");
                    String password = request.getParameter("txtpass");
                    String hash = enc.getMD5(password);

                    HttpSession sesion = request.getSession();

                    try {
                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                        conn = DriverManager.getConnection("jdbc:sqlserver://10.0.0.98:1433;databaseName=sssacontable", "contable19", "contable19");
                        st = conn.createStatement();
                        rs = st.executeQuery("SELECT * FROM nm_usuarios where Id_perfil='" + perfil + "'and contraseña='" + password + "'; ");

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
