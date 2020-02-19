<%-- 
    Document   : importexcel
    Created on : 19/02/2020, 08:21:25 AM
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
                            <h5 class="align-middle mt-1"><b>Importar datos</b></h5>                                         
                        </div>
                    </div>
                </div>
                <form action="FileUploadHandler" enctype="multipart/form-data" method="post">
                    <div class="form-group">
                        <div class="row">
                            <div class="col-2"></div>
                            <div class="col-8 text-center">
                                <label class="mt-2" for="file2"><b>Selecciona el archivo</b></label>
                                <input type="file" name="file2" class="form-control-file border">
                                <label class="mt-2"><b>Nombre del archivo</b></label>
                                <input type="text" name="file_name" class="form-control">
                                <input type="submit" value="Subir" name="subirExcel" class="btn background-button mt-2">
                            </div>                                             
                            <%
                                String file_name = (String) request.getParameter("filename");
                                if (file_name != null) {
                                    out.println(file_name + " Se subio el archivo correctamente");
                                }
                            %>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <script>
// Add the following code if you want the name of the file appear on select
            $(".custom-file-input").on("change", function () {
                var fileName = $(this).val().split("\\").pop();
                $(this).siblings(".custom-file-label").addClass("selected").html(fileName);
            });
        </script>
    </body>
</html>
