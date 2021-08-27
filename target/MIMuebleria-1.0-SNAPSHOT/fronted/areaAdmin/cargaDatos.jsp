<%-- 
    Document   : cargaDatos
    Created on : 21/08/2021, 21:45:20
    Author     : AndaryuS
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Carga de datos</h1>
        <div class="container p-5">
            <div class=""row flex-column justify-content-center">
                <h1 class="bg-danger col-sm-8 m-auto text-center p-2">Subir Archivo</h1>
                <form class="col-sm-8 m-auto p-2" action="controladorArchivo1" method="POST" enctype="multipart/form-data">
                    <div class="form-group">
                        <input class="form-contro" name="file" type="file" placeholder="Ingrese el archivo">
                    </div>
                    <div class="form-group">
                        <button class="btn btn-succes" name="action" value="add">SUBIR</button>
                    </div>
                </form>
            </div>
        </div>   
    </body>
</html>
