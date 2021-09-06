<%-- 
    Document   : reportes
    Created on : 21/08/2021, 21:45:12
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
        <h1 class="text-center">Reporte de ventas por un intervalo de tiempo</h1>
    <div class="col-md-offset-3">
        <form  action="ServletDescarga" method="GET">
            <labe>Desde : </labe>
            <input type="date" id="fechaInicial" name="fechaInicial">
            <labe>Hasta : </labe>
            <input type="date" id="fechaFinal" name="fechaFinal">

            <button type="submit"  name="reporte" value="ventas" class="btn btn-primary mb-3">Descargar Reporte</button>

        </form>
    </div>




    <a class="btn btn-outline-primary" href="${pageContext.request.contextPath}ServletDescarga?reporte=ventas&fechaInicial=${fechaInicial}&fechaFinal=${fechaFinal}">EXPORTAR REPORTE</a>
</body>
</html>
