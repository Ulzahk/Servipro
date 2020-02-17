<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Praempleados</title>
    </head>
    <body>
        <%
            Modelos.PraEmpleados.clsPraEmpleados obclsPraEmpleados = new Modelos.PraEmpleados.clsPraEmpleados();

            if (request.getAttribute("obclsPraEmpleados") != null) {
                obclsPraEmpleados = (Modelos.PraEmpleados.clsPraEmpleados) request.getAttribute("obclsPraEmpleados");

            }

            List<Modelos.PraEmpleados.clsPraEmpleados> lstclsPraEmpleados = new ArrayList<Modelos.PraEmpleados.clsPraEmpleados>();

            if (request.getAttribute("lstclsPraEmpleados") != null) {
                lstclsPraEmpleados = (List<Modelos.PraEmpleados.clsPraEmpleados>) request.getAttribute("lstclsPraEmpleados");
            }

            if (request.getAttribute("stMensaje") != null && request.getAttribute("stTipo") != null) {

        %>
        <input type="txt" hidden="" id="txtMensaje" value="<%=request.getAttribute("stMensaje")%>"/>
        <input type="txt" hidden="" id="txtTipo" value="<%=request.getAttribute("stTipo")%>"/>
        <script>
            var mensaje = document.getElementById("txtMensaje").value;
            var tipo = document.getElementById("txtTipo").value;
            swal("Mensaje", mensaje, tipo);
        </script>
        <%
            }

            String[] number = new String[10];
            for( int i = 0; i<10; i++){
                number[i] = "number"+i;
            }
            
            String[] name = new String[10];
            for ( int i = 0; i<10; i++){
                name[i] = "name"+i;
            }
            
            String[] password = new String[10];
            for (int i = 0; i<10; i++){
                password[i] = "password"+i;
            }
            
        %>
        <h1>Prueba de guardado multiples registros</h1>
        <form action="controlpraempleados" method="post">
            <div class="input-group">
                <a href="controlpraempleados?btnAgregar=true" ><label>Agregar</label></a>
            </div>
        </form>
        <form action="controlpraempleados" method="post">
            <table>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Nombre</th>
                        <th>Contraseña</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for(int i = 0; i<4; i++){ 
                    %>
                    <tr>
                        <td>
                            <input type="number" name="<%=number[i]%>" placeholder="Numero aqui" value="0">
                        </td>
                        <td>
                            <input type="text" name="<%=name[i]%>" placeholder="Nombre aqui">
                        </td>
                        <td>
                            <input type="password" name="<%=password[i]%>" placeholder="Contraseña aqui">
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table> 
            <input type="submit" value="Guardar" name="btnGuardar">
        </form>
    </body>
</html>