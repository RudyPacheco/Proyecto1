
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- 
    Document   : controlUsuario
    Created on : 21/08/2021, 22:04:42
    Author     : AndaryuS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">

        <title>Usuarios</title>
    </head>
    <body>
        <h1>Control de Usuarios</h1>

        <div class="d-flex">
            <div class="card col-sm-5" >
                <div class="card-body">

                    <form action="controladorArea?menu=controlUsuario" method="POST">
                        <div class="form-group">
                            <label>Usuaio</label>
                            <input type="text" name="usertxt" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Contraseña</label>
                            <input type="password" name="passwordtxt" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Codigo Area</label>
                            <input type="number" name="areatxt" class="form-control">
                        </div>
                        <input type="submit" name="accion" value="Registrar" class="btn btn-info" >    
                    </form>

                </div>
            </div>
            <div class="col-sm-7">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Usuario</th>
                            <th>Area</th>
                            <th>Bloqueado</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="usuario" items="${usuarios}">
                            <tr>
                                <td>${usuario.getUsuario()}</td>
                                <td>${usuario.getCategoria()}</td>
                                <td>${usuario.isBloqueado()}</td>
                                <td>
                                    <a>Editar</a>
                                    <a class="btn btn-danger" href="controladorArea?menu=controlUsuario&accion=bloquear&id=${usuario.getUsuario()}" onclick="javascript:if (!confirm('¿Desea Bloquear/Desbloquear?'))
                                        return false">Bloquear/Desbloquear</a>
                                </td>

                            </tr>    
                        </c:forEach>

                    </tbody>
                </table>
            </div>

        </div>
        <!-- Optional JavaScript; choose one of the two! -->

        <!-- Option 1: Bootstrap Bundle with Popper 
        -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>


    </body>
</html>



