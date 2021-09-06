<%-- 
    Document   : reporteGanancia
    Created on : 5/09/2021, 17:34:47
    Author     : AndaryuS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 class="text-center">Reporte de ganancias en un intervalo de tiempo</h1>
        <div class="col-md-offset-3">
            <form  action="ServletDescarga" method="GET">
                <labe>Desde : </labe>
                <input type="date" id="fechaInicial" name="fechaInicial">
                <labe>Hasta : </labe>
                <input type="date" id="fechaFinal" name="fechaFinal">

                <button type="submit"  name="reporte" value="ganancias" class="btn btn-primary mb-3">Descargar Reporte</button>

            </form>
        </div>

    </body>
</html>
