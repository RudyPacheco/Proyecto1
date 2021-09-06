<%-- 
    Document   : mueblesVenta
    Created on : 3/09/2021, 22:39:14
    Author     : AndaryuS
--%>

<%@page import="modelo.pieza"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">

        <title>JSP Page</title>
    </head>
    <body>
        <h1 class="text-center">Muebles Disponibles</h1>
        <div class="col-sm-12">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre del mueble</th>
                        <th>Precio</th>
                        <th>Costo</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="muebleR" items="${mueblesE}">
                        <tr>

                            <td>${muebleR.getId_mueble()}</td>
                            <td>${muebleR.getNombreMueble()}</td>
                            <td>${muebleR.getPrecio()}</td>
                            <td>${muebleR.getCosto()}</td>

                            <td><a href="controladorVenta?menu=mueblesVenta&accion=describirMueble&idMueble=${muebleR.getId_mueble()}" class="btn btn-success">Descripcion</a></td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>
        </div>
        <div>
            <div class="text-center">
                 <%ArrayList<pieza> piezas = (ArrayList<pieza>) request.getAttribute("descripcion");
                if (piezas == null) {

                } else {
                    out.println("<h1>Descripcion de las piezas usadas</h1>");
                    double costo = 0;
                    out.println("El mueble uso las siguientes piezas ");
                    out.println("<br>");
                    for (int i = 0; i < piezas.size(); i++) {

                        pieza temp = piezas.get(i);
                        costo = costo + temp.getCosto();
                        out.println("La pieza " + temp.getNombre_pieza() + " que costo Q" + temp.getCosto());
                        out.println("<br>");
                    }
                    out.println("Teniendo un costo total Q" + costo);
                }

            %>
            </div>
           
            <h4></h4>
        </div>



    </body>
</html>
