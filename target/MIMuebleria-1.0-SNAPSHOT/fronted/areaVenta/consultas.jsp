<%-- 
    Document   : consultas
    Created on : 3/09/2021, 10:09:08
    Author     : AndaryuS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">

        <title>Consultas</title>
    </head>
    <body>
        <h1 class="text-center">Area de consultas</h1>
        <div class="col-xs-12">
            <div class="center-block" justify-content="center">
                <a href="controladorVenta?menu=consultas&accion=compraCliente" class="btn btn-info" >Compras de algun cliente </a>  
                <a href="" class="btn btn-info" >Devoluciones</a>    
                <a href="controladorVenta?menu=mueblesVenta&accion=listarMuebles" class="btn btn-info" >Muebles Disponibles</a>  
                <a href="controladorVenta?menu=consultas&accion=detalleFactura" class="btn btn-info" >Detalles de factura</a>  
                <a href="controladorVenta?menu=consultas&accion=ventaDia" class="btn btn-info" >Ventas del dia</a>  
            </div>

        </div>





        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
    </body>
</html>
