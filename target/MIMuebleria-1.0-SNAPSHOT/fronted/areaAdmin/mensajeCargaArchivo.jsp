<%-- 
    Document   : mensajeCargaArchivo
    Created on : 25/08/2021, 22:48:23
    Author     : AndaryuS
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mensajes</title>
    </head>
    <body>
        <h1>Resultado Carga de Archivo</h1>
        <div>
            <table width="500px">
                <%
                    //String msg = (String) request.getAttribute("mensaje");
                    // out.println("<td>"+msg+"</td>");
                    ArrayList<String> mensajes = new ArrayList<>();
                    mensajes = (ArrayList<String>) request.getAttribute("Lista");
                    if (mensajes != null) {
                        for (String mensaje : mensajes) {
                            out.println(mensaje+"<br/>");
                        }
                    }else{
                        out.println("No se encontraron Errores");
                    }

                %>
            </table>
        </div>
    </body>
</html>
