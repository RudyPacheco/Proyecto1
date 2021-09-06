<%-- 
    Document   : ventasDia
    Created on : 4/09/2021, 21:22:07
    Author     : AndaryuS
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <title>Ventas</title>
    </head>
    <body>
        <h1 class="text-center">Ventas del dia </h1>
                <div class="col-sm-12">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Codigo Factura</th>
                        <th>Nit cliente</th>
                        <th>Empleado</th>
                        <th>Total</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="ventas" items="${ventas}">
                        <tr>

                            <td>${ventas.getId()}</td>
                            <td>${ventas.getNit()}</td>
                            <td>${ventas.getNombreUsuario()}</td>
                            <td>${ventas.getTotal()}</td>

                            <td><a href="controladorVenta?menu=mueblesVenta&accion=describirMueble&idMueble=${muebleR.getId_mueble()}" class="btn btn-success">Descripcion</a></td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>
        </div>
        
        
        
        
          <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
    </body>
</html>
