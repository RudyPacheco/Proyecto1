<%-- 
    Document   : mueblesEnsamblados
    Created on : 30/08/2021, 13:03:08
    Author     : AndaryuS
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.pieza"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <title>Muebles Ensamblados</title>
    </head>
    <body>
        <h1>Muebles Ensamblados</h1>
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

                            <td><a href="controladorFabrica1?menu=mueblesEnsamblados&accion=describirMueble&idMueble=${muebleR.getId_mueble()}" class="btn btn-success">Descripcion</a></td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>
        </div>
        <div>
            <%ArrayList<pieza> piezas = (ArrayList<pieza>) request.getAttribute("descripcion");
                if (piezas == null) {

                } else {
                    double costo=0;
                    out.println("El mueble uso las siguientes piezas ");
                    out.println("<br>");
                    for (int i = 0; i < piezas.size(); i++) {
                        
                        pieza temp = piezas.get(i);
                        costo=costo+temp.getCosto();
                        out.println("La pieza " + temp.getNombre_pieza() + " que costo Q" + temp.getCosto());
                        out.println("<br>");
                    }
                    out.println("Teniendo un costo total Q"+costo);
                }

            %>
            <h4></h4>
        </div>


    </body>
</html>
