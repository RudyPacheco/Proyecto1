<%-- 
    Document   : venta
    Created on : 3/09/2021, 10:09:13
    Author     : AndaryuS
--%>
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
        <h1 class="text-center" >Caja</h1>
        <div class="d-flex">
            <div class="col-sm-5">
                <div class="card">
                    <form action="controladorVenta?menu=venta" method="POST">
                        <div class="card-body">
                            <div class="form-group">
                                <label>Datos del cliente</label>
                                <br>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="nitCliente" value="${cliente.getNit()}" class="form-control" placeholder="NIT">
                                    <input type="submit" name="accion" value="buscarCliente" class="btn btn-outline-info" >
                                </div>
                                <div class="col-sm-6">
                                    <input type="text" name="nombreCliente" value="${cliente.getNombreCliente()}" class="form-control" placeholder="Nombre">
                                </div>

                            </div>    
                            <div>
                                <input type="text" name="direccion" value="${cliente.getDireccion()}" class="form-control" placeholder="Direccion">
                            </div>
                            <div>
                                <input type="text" name="departamento" value="${cliente.getDepartamento()}" class="form-control" placeholder="Departamento">
                            </div>
                            <div>
                                <input type="text" name="municipio" value="${cliente.getMunicipio()}" class="form-control" placeholder="Municipio">
                            </div>
                            <div>
                                <input type="submit" name="accion" value="Registrar" class="btn btn-outline-info" >
                            </div>
                            <div class="form-group">
                                <br>
                                <label>Datos Producto</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="codigoProducto" value="${mueble.getId_mueble()}" class="form-control" placeholder="Codigo">
                                    <input type="submit" name="accion" value="buscarMueble" class="btn btn-outline-info">
                                </div>
                                <div class="col-sm-6">
                                    <input type="text" name="nombreProducto" value="${mueble.getNombreMueble()}" class="form-control" placeholder="Nombre del Producto">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-6 d-flex">
                                    <input type="number" name="precio" value="${mueble.getPrecio()}" class="form-control" placeholder="Precio">
                                </div>
                            </div>
                            <div class="form-group">
                                <button type="submit" name="accion" value="Agregar" class="btn btn-outline-info">Agregar</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-sm-7">
                <div class="card">
                    <div class="card-body"> 
                        <div class="d-flex col-sm-5 ml-auto" >
                            <label>Numero de Serie</label>
                            <input type="text" name="noSerie" value="${numSerie}" class="form-control">
                        </div>
                        <br>
                        <!<!-- comment aqui va el form -->
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Codigo Producto</th>
                                    <th>Nombre del mueble</th>
                                    <th>Precio</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="list" items="${lista}">
                                    <tr>
                                        <td>${list.getId_mueble()}</td>
                                        <td>${list.getNombreMueble()}</td>
                                        <td>${list.getPrecio()}</td>
                                        <td>
                                            <a href="#" class="btn btn-danger" >Eliminar</a>
                                        </td>
                                    </tr>     
                                </c:forEach>

                            </tbody>
                        </table>
                    </div>
                    <div class="card-footer d-flex">
                        <div class="col-sm-6">

                            <a href="controladorVenta?menu=venta&accion=generarVenta" class="btn btn-success">Generar Venta</a>
                            <a href="controladorVenta?menu=venta&accion=limpiar" class="btn btn-danger" >Cancelar</a>
                        </div>
                        <div class="col-sm-3 ml-auto">
                            <input type="text" name="totaltxt" value="${totalPagar}" class="form-control">
                        </div>
                    </div>        
                </div>
            </div>
        </div>
    </body>
</html>
