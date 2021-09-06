<%-- 
    Document   : ensamble
    Created on : 30/08/2021, 13:02:31
    Author     : AndaryuS
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <title>Ensamblar</title>
    </head>
    <body>
        <h1>Area de ensamble</h1>
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
                            <td><a href="controladorFabrica1?menu=ensamble&accion=ensamblarMueble&nombreMueble=${mueble.getNombre_mueble()}" class="btn btn-success" onclick="javascript:if (!confirm('¿Desea Ensabmblar?'))
                                        return false">Ensamblar</a></td>

                        </tr>
                    </c:forEach>

                </tbody>
            </table>
        </div>

        <!-- Option 2: Separate Popper and Bootstrap JS -->

        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>


    </body>
</html>
