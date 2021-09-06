<%-- 
    Document   : areaVenta
    Created on : 21/08/2021, 17:59:34
    Author     : AndaryuS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <title>Area de ventas</title>
        <link rel="stylesheet" href="resources/css/areaAdmin.css">
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-primary">
            <div class="container-fluid">
                <div class="collapse navbar-collapse" id="navbarNav">
                    <div  class="mx-auto"></div>
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link text-white" aria-current="page" href="controladorVenta?menu=inicio" target="myFrame">Inicio</a>
                        </li
                        <li class="nav-item">
                            <a class="btn btn-outline-dark text-white" href="controladorVenta?menu=devolucion" target="myFrame">Devoluciones</a>
                        </li>
                        <li class="nav-item">
                            <a class="btn btn-outline-dark text-white" href="controladorVenta?menu=consultas&accion=default" target="myFrame">Consultas</a>
                        </li>
                        <li class="nav-item">
                            <a class="btn btn-outline-dark text-white" href="controladorVenta?menu=venta&accion=default&nombreUser=${usuario.getUsuario()}" target="myFrame">Venta</a>
                        </li>
                    </ul>
                    <div class="dropdown">
                        <button class="btn btn-outline-dark text-white dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                            ${usuario.getUsuario()}
                        </button>
                        <ul class="dropdown-menu text-center" aria-labelledby="dropdownMenuButton1">
                            <li><a class="dropdown-item" href="#">
                                    <img src="resources/img/iconoADMIN.png" alt="50" width="50"/>
                                </a></li>
                            <div class="dropdown-di-divider"></div>
                            <form action="validar" method="POST">
                                <li><button name="accion" value="salir" class="dropdown-item" href="#">Salir</button></li>
                            </form>
                        </ul>
                    </div>
                </div>
            </div>
        </nav>
        <div class="m-4" style="height: 530px; ">
            <iframe name="myFrame" style="height: 100%; width: 100%; border: none "></iframe>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>



    </body>
</html>
