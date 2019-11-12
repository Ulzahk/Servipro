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
                        <option value="">Selecciones una opción</option>
                        <option value="JEFE DE NOMINA">Jefe de nomina</option>
                        <option value="ADMINISTRADOR DE NOMINA ">Administrador de nomina</option>
                        <option value="COORDINADOR DE NOMINA">Coordinador de nomina</option>
                    </select>
                         </span>
                   
                    <input type="text" name="id_usuario" placeholder="Usuario" id="txtusuario"/>
                    
                    <input type="password" name="contraseña" id="txtpass" placeholder="Contraseña"/>
                    <input type="button" value="Acceder"  id="btniniciar" />
                </form>
        </div>
                
    </body>
</html>
