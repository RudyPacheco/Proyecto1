<%-- 
    Document   : factura
    Created on : 4/09/2021, 17:13:52
    Author     : AndaryuS
--%>

<%@page import="modelo.factura"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">

        <title>Factura</title>
    </head>
    <body>
        <h1 class="text-center">Factura</h1>
        <h1 class="text-center">Mi mubleria</h1>
        <div class="row">
            <div class="col-xs-5">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4>De: <a >${factura.getNombreUsuario()}</a></h4>
                        <h4>Fecha : <a>${factura.getFecha()}</a></h4>
                    </div>
                </div>
            </div>
            <div class="col-xs-5 col-xs-offset-2 text-right">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4>Para : <a>${cliente.getNombreCliente()}</a></h4>
                        <h4>NIt : <a>${cliente.getNit()} </a></h4>
                        <h4>Direccion :<a>${cliente.getDireccion()}</a></h4>                      
                    </div>
                </div>
            </div>
        </div>
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
        <div class="col-sm-3 ml-auto">
            <h4>Total a pagar</h4>
            <h4>${factura.getTotal()}</h4>
        </div>
        <div class="card-footer ">
            <div class="col-sm-6">
                <a onclick="print()" class="btn btn-success">Imprimir Factura</a>
            </div>

        </div>        

 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>

    </body>
</html>


