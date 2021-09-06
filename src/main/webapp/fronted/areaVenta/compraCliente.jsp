<%-- 
    Document   : compraCliente
    Created on : 4/09/2021, 22:13:07
    Author     : AndaryuS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">

        <title>JSP Page</title>
    </head>
    <body>
        <h1>Compras del cliente</h1>

        <form class="row g-3" action="controladorVenta?menu=consultas" method="POST">
            <div class="col-auto">
                <label  readonly class="form-control-plaintext" id="staticEmail2" value="Nit">NIT</label>
            </div>
            <div class="col-auto">
                <input type="text" name="nitCliente" class="form-control" id="inputPassword2" placeholder="Nit">
                <labe>Desde : </labe>
                <input type="date" id="fechaInicial" name="fechaInicial">
                <labe>Hasta : </labe>
                <input type="date" id="fechaFinal" name="fechaFinal">

            </div>

            <div class="col-auto">
                <button type="submit"  name="accion" value="buscarCompra" class="btn btn-primary mb-3">Buscar compras</button>
            </div>
        </form>
        <br>
        <h1 class="text-center">Facturas del cliente </h1>
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
                    <c:forEach var="factura" items="${facturas}">
                        <tr>

                            <td>${factura.getId()}</td>
                            <td>${factura.getNit()}</td>
                            <td>${factura.getNombreUsuario()}</td>
                            <td>${factura.getTotal()}</td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>
            <h1 class="text-center">Muebles comprados </h1>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>
                            <h4>Codigo mueble</h4>
                        </th>
                        <th>
                            <h4>Nombre del Mueble</h4>
                        </th>
                        <th>
                            <h4>Precio</h4>
                        </th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="detalle" items="${detalle}">
                        <tr>
                            <td>${detalle.getIdMueble()}</td>
                            <td>${detalle.getNombreMueble()}</td>
                            <td>${detalle.getPrecio()}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>

    </body>
</html>
