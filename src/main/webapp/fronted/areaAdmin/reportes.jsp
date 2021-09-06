<%-- 
    Document   : reportes
    Created on : 5/09/2021, 16:58:36
    Author     : AndaryuS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <title>Reportes</title>
    </head>
    <body>
        <h1>Area de reportes</h1>
        <div class="col-xs-12">
            <div class="center-block" justify-content="center">
                <a href="controladorReportes?menu=ventas" class="btn btn-primary" >Ventas </a>  
                <a href="" class="btn btn-primary" >Devoluciones</a>    
                <a href="controladorReportes?menu=ganancias" class="btn btn-primary" >Ganancias</a>  
                <a href="controladorReportes?menu=userMasV" class="btn btn-primary" >Usuario con mas ventas</a>  
                <a href="controladorReportes?menu=userMasG" class="btn btn-primary" >Usuario con mas ganancias</a>  
                <a href="controladorReportes?menu=muebleMas" class="btn btn-primary" >Mueble mas vendido</a>  
                <a href="controladorReportes?menu=muebleMenos" class="btn btn-primary" >Mueble menos vendido</a>                  
            </div>

        </div>


    </body>
</html>
