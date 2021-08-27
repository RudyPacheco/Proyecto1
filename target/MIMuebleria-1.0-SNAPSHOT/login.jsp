<%-- 
    Document   : login
    Created on : 18/08/2021, 23:58:14
    Author     : AndaryuS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

        <title>Inicio de Sesion</title>
        <link rel="stylesheet" href="resources/css/style.css">
    </head>
    <body>

        <section class="Form my-4 mx-5">
            <div class="container">
                <div class="row no-gutters">
                    <div class="col-lg-5">
                        <img src="resources/logo.jpg" class="img-fluid" alt="">
                    </div>
                    <div class="col-lg-7 px-5 pt-5">
                        <h1 class="font-weight-bold py-3">Mi muebleria</h1>
                        <h4>Ingrese su usuario</h4>
                    <form class="form-sing" action="" method="POST">
                        <div class="form-row py-3">
                            <div class="col-lg-7">
                                <input type="text" class="inp px-3" name="user" placeholder="Usuario" class="form-contro my-3 p-4">
                            </div>
                        </div>
                        <div class="form-row py-3">
                            <div class="col-lg-7">
                                <input type="password" class="inp px-3" name="password" placeholder="******" class="form-control my-3 p-4">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="col-lg-7">
                                <button type="button" name="accion" value="Ingresar"  class="btn1">login</button>
                            </div>
                        </div>
                    </form>
                        </div>
                </div>
            </div>
        </section>



        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

    </body>
</html>
