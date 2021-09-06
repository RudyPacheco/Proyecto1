<%-- 
    Document   : detallesFactura
    Created on : 4/09/2021, 23:54:03
    Author     : AndaryuS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">

        <title>JSP Page</title>
    </head>
    <body>
        <h1 class="text-center">Factura</h1>
        <div>
            <form class="row g-3" action="controladorVenta?menu=consultas" method="POST">
                <div class="col-auto">
    
                    <label  readonly class="form-control-plaintext" >Codigo Factura</label>
                </div>
                <div class="col-auto">

                    <input type="text" class="form-control" name="codigoFactura" placeholder="Codigo">
                </div>
                <div class="col-auto">
                    <button type="submit" name="accion"  value="mostrarFactura"class="btn btn-primary mb-3">Buscar Factura</button>
                </div>
            </form>
        </div>


        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
    </body>
</html>
