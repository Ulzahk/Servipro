<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Esta es una prueba</title>
        <link rel="stylesheet"  type="text/css" href="<c:url value="/Resources/CSS/stylelogin.css"/>"/>
        <script src="Resources/JS/functions.js"></script>
        
    </head>
    <body>
        <div class="loginbox">
            
        </div>
        <div class="loginbox">
           <img src="<c:url value="/Resources/Images/LogoUsuario.png"/>" class="avatar"/>
           <img src="<c:url value="/Resources/Images/LogoServiSoft2.PNG"/>" class="imgLogo"/>
                <h1>Iniciar Sesión</h1>
                <p>Hola123</p>
                <form action="logear" method="post" id="forminicio">
                    <p>Perfil</p>
                    <select name="descripcion_perfil" id="txtperfil">
                        <option value="">POR FAVOR SELECCIONE UNA OPCIÓN</option>
                        <option value="COORDINADOR">COORDINADOR</option>
                        <option value="EDITOR">EDITOR</option>
                        <option value="USUARIO">USUARIO</option>
                    </select>
                    <p>Usuario :(</p>
                    <input type="text" name="id_usuario" placeholder="Ingrese Usuario" id="txtusuario"/>
                    <p>Contraseña</p>
                    <input type="password" name="contraseña" id="txtpass" placeholder="Ingrese Contraseña"/>
                    <input type="button" value="Acceder"  id="btniniciar" />
                </form>
        </div>
                <img src="Resources/Images/FondoNatural.jpg" height="800px" width="100%" class="imgFondo"/>
    </body>
</html>
