<%-- 
    Document   : buscartitulo
    Created on : 13 ene 2024, 20:11:33
    Author     : moro-
--%>

<%@page import="Modelo.pelicula"%>
<%@page import="Modelo.director"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
   
    <body>
        <table border="1" align="center">
            <form action="Servletbuscotitulo" method="POST">
                <thead>
                    <tr>
                        <th>Buscar Pelicula</th>

                    </tr>
                </thead>
                <tbody>
                   
                    <tr>

                        <td>Titulo</td>

                        <td><input type="text" name="nombre"></td>
                        
                    </tr>
                    
                </tbody>
                <tr>
                    <td><input type="submit" value="Buscar"></td>
                    
                </tr>
                <tr>
                    <td><a href="Gestion.jsp">Volver a Gestion de Peliculas...</a></td>

                </tr>
            </form>
        </table>

    </body>
</html>