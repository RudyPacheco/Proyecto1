<%-- 
    Document   : areaAdmin
    Created on : 21/08/2021, 18:05:47
    Author     : AndaryuS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">

        <title>Area Administrativa</title>
        <link rel="stylesheet" href="resources/css/areaAdmin.css">
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-primary">
            <div class="container-fluid">
                <div class="collapse navbar-collapse" id="navbarNav">
                    <div  class="mx-auto"></div>
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link text-white" aria-current="page" href="#">Inicio</a>
                        </li>
                        <li class="nav-item">
                            <a class="btn btn-outline-dark text-white" href="controladorArea?accion=reportes" target="myFrame">Reportes</a>
                        </li>
                        <li class="nav-item">
                            <a class="btn btn-outline-dark text-white" href="controladorArea?accion=creacion" target="myFrame">Creacion</a>
                        </li>
                        <li class="nav-item">
                            <a class="btn btn-outline-dark text-white" href="controladorArea?accion=controlUsuario" target="myFrame">Control de Usuarios</a>
                        </li>
                        <li class="nav-item">
                            <a class="btn btn-outline-dark text-white" href="controladorArea?accion=cargaDatos" target="myFrame">Carga de datos</a>
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
        <div class="m-4" style="height: 550px; ">
            <iframe name="myFrame" style="height: 100%; width: 100%"></iframe>
        </div>


        <!-- Optional JavaScript; choose one of the two! -->

        <!-- Option 1: Bootstrap Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>


    </body>
</html>