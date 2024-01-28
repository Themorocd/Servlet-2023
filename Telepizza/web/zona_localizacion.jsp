<%-- 
    Document   : zona_localizacion
    Created on : 28 ene 2024, 16:30:31
    Author     : moro-
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="5" align="center">
            <form action="envio" method="POST">
            <thead>
               
            </thead>
            <tbody>
                <tr>
                    
                    <td><input type="radio" id="id1" name="name" value="domi">
                        <label for="domicilio">Entraga a domicilio</label></td>
                    <td><input type="radio" id="id2" name="name" value="tienda">
                        <label for="tienda">Regocer en Tienda</label></td>
                        
                </tr>
                <tr>
                    <td><input type="submit" value="Acceptar"></td>
                </tr>
            </tbody>
            
            </form>
        </table>

    </body>
</html>
