<%-- 
    Document   : creacion
    Created on : 21/08/2021, 22:04:23
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
        <h1>Creacion Muebles  y Piezas</h1>
        <div class="d-flex">
            <div class="col-sm-4">
                <div class="card">
                    <form action="controladorArea?menu=creacion" method="POST">
                        <div class="card-body">
                            <div class="form-group">
                                <label>Datos mueble</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-12 ">
                                    <input type="text" name="nombreMueble" class="form-control" placeholder="Nombre del mueble"> 
                                    <br>
                                     <input type="number" step="any" name="precioMueble" class="form-control" placeholder="Precio del mueble"> 
                                    <input type="submit"  name="accion" value="validarNombre" class="btn btn-outline-info">
                                </div>
                                <br>
                            </div>
                            <div class="form-group">
                                <label>Datos piezas</label>
                            </div>
                            <div class="form-group ">
                                <div class="form-group">
                                    <input type="text" name="nombrePieza" class="form-control" placeholder="Nombre de la pieza"> 
                                    
                                    <br>

                                </div>
                                <div class="form-group">
                                    <input type="number" name="cantidadPieza" value="1" class="form-control" placeholder="Cantidad de piezas"> 
                                    <br>
                                </div>
                                <div class="col-sm-4 d-flex">
                                    <button type="sumit" name="accion" value="Agregar" class="btn btn-outline-info">Agregar</button>
                                </div>
                            </div>


                        </div>
                    </form>

                </div>

            </div>
            <div class="col-sm-7">
                <div class="card">
                    <div class="card-body">
                        <label class="text-center">Datos de Mueble Actual</label>
                        <br>
                        <label class="text-center" >Nombre :</label>
                        <input type="text" name="nombrexd" value="${mueble.getNombre_mueble()}" class="form-control" placeholder="Nombre del mueble Creado">
                           <input type="text" name="precioxd" value="${mueble.isPrecio()}" class="form-control" placeholder="Precio del mueble Creado">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Nombre de la pieza</th>
                                    <th>Cantidad</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="list" items="${lista}">
                                <tr>
                                    <td>${list.getNombrePieza()}</td>
                                    <td>${list.getCantidad()}</td>
                                    <td>
                                        <a href="#" class="btn btn-danger" >Eliminar</a>
                                    </td>
                                </tr>     
                                </c:forEach>
                               
                            </tbody>
                        </table>
                    </div>
                    <div class="card-footer">
                        <div>
                            <a href="controladorArea?menu=creacion&accion=CrearMueble" class="btn btn-success" onclick="javascript:if (!confirm('¿Desea Crear El Mueble?'))
                                        return false">Crear Mueble</a>
                         
                            
                           <a href="controladorArea?menu=creacion&accion=limpiar" class="btn btn-danger" >Cancelar</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
