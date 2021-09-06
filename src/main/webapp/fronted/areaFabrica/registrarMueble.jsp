<%-- 
    Document   : registrarMueble
    Created on : 30/08/2021, 13:02:42
    Author     : AndaryuS
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <title>Registrar Mueble</title>
    </head>
    <body>
        <h1>Registrar Mueble</h1>
        <div class="col-sm-12">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Nombre del mueble</th>
                        <th>Precio</th>
                        <th>Costo</th>

                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="mueble" items="${muebles}">
                        <tr>
                            <td>${mueble.getNombre_mueble()}</td>
                            <td>${mueble.isPrecio()}</td>
                            <td><a href="controladorFabrica1?menu=libro&accion=describirMueble&nombreMueble=${mueble.getNombre_mueble()}" class="btn btn-success">Ensamblar</a></td>

                        </tr>
                    </c:forEach>

                </tbody>
            </table>
        </div>
    </body>
</html>
