<%-- 
    Document   : piezas
    Created on : 30/08/2021, 13:02:13
    Author     : AndaryuS
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <title>Piezas</title>

    </head>
    <body>
        <!-- Button trigger modal -->
        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#agregarPieza">
            Agregar Pieza
        </button>


        <div class="card-body">

            <form action="controladorFabrica1?menu=piezas" method="POST">
                <div class="form-group">
                    <label>Nombre Pieza</label>
                    <input type="text" value="${pieza.getNombre_pieza()}" name="nombrePieza" class="form-control">
                </div>
                <div class="form-group">
                    <label>Precio</label>
                    <input type="number" step="any" value="${pieza.getCosto()}" name="precio" class="form-control">
                </div>
                 
                <input type="submit" name="accion" value="actualizar" class="btn btn-info" >    
            </form>

        </div>



        <div class="col-sm-12">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Nombre de la pieza</th>
                        <th>Cantidad de piezas</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="pieza" items="${piezas}">
                        <tr>
                            <td>${pieza.getNombrePieza()}</td>
                            <td>${pieza.getCantidad()}</td>
                            <td><a href="controladorFabrica1?menu=piezas&accion=seleccionar&nombrePieza=${pieza.getNombrePieza()}" class="btn btn-success">Ver info</a></td>

                        </tr>
                    </c:forEach>

                </tbody>
            </table>
        </div>
        <div>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Nombre de la pieza</th>
                        <th>Precio</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="piezaD" items="${piezasDisponibles}">
                        <tr>
                            <td>${piezaD.getNombre_pieza()}</td>
                            <td>${piezaD.getCosto()}</td>
                            <td><a href="controladorFabrica1?menu=piezas&accion=editar&idPieza=${piezaD.getId()}" class="btn btn-success">Editar</a></td>
                            <td><a href="controladorFabrica1?menu=piezas&accion=eliminar&idPieza=${piezaD.getId()}" class="btn btn-danger">Eliminar</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>


        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
        <jsp:include page="/fronted/areaFabrica/agreagarPieza.jsp"/>
    </body>
</html>



