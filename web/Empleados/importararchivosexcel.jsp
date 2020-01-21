<%-- 
    Document   : newjsp
    Created on : 20/01/2020, 02:23:59 PM
    Author     : PRACTICANTE
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../Resources/CSS/style.css" rel="stylesheet" type="text/css"/>
        <title>Importar Excel</title>
    </head>
    <body>
        <div class="container">
            <div class="card border-dark">
                <div class="card-header background-card text-white border-dark">
                    <div class="form-group">
                        <div class="col-12 text-center">                                                                      
                            <h5 class="align-middle mt-1">Importar datos</h5>                                         
                        </div>
                    </div>
                </div>
                <div class="card-body">
                    <form>
                        <div class="form-group">
                            <label for="exampleFormControlFile1">Example file input</label>
                            <input type="file" class="form-control-file" id="exampleFormControlFile1">
                            <a href="empleados?btnImpoGuardar=true">Guardar</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
