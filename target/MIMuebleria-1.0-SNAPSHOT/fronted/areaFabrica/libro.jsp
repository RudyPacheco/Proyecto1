<%-- 
    Document   : libro
    Created on : 30/08/2021, 13:00:54
    Author     : AndaryuS
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <title>Libro</title>
    </head>
    <body>
        <h1>Libro</h1>
        <div class="col-sm-12">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Nombre del mueble</th>
                        <th>Precio</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="mueble" items="${muebles}">
                        <tr>
                            <td>${mueble.getNombre_mueble()}</td>
                            <td>${mueble.isPrecio()}</td>
                            <td><a href="controladorFabrica1?menu=libro&accion=describirMueble&nombreMueble=${mueble.getNombre_mueble()}" class="btn btn-success">Ver info</a></td>

                        </tr>
                    </c:forEach>

                </tbody>
            </table>
        </div>
        <div class="col-sm-12">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Descripcion</th>
                <p>El mueble ${mueble.getNombre_mueble()} necesita las siguientes piezas</p>
                </tr>
                </thead>
                <tbody>

                    <c:forEach var="piezasN" items="${piezasN}">

                        <tr>
                            <td>${piezasN.getNombrePieza()}</td>
                            <td>${piezasN.getCantidad()}</td>
                            <td></td>

                        </tr>
                    </c:forEach>

                </tbody>
            </table>
                
        </div>
    </body>
</html>
