<%-- 
    Document   : alta
    Created on : 11 ene 2024, 18:29:15
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
            <tr>
                <th>Alta de Alumnos</th>

            </tr>
            <table border="5" align="center">
                <form action="ServletAlta" method="POST">
                    <thead>
                        <tr>
                            <td>Nombre</td>
                            <td><input type="type" name="name"></td>
                        </tr>
                        <tr>
                            <td>Apellidos</td>
                            <td><input type="type" name="apellido"></td>
                        </tr>
                        <tr>
                            <td>DAWES</td>
                            <td><input type="type" name="dawes"></td>
                        </tr>
                        <tr>
                            <td>DAWEC</td>
                            <td><input type="type" name="dawec"></td>
                        </tr>
                        <tr>
                            <td>DIW</td>
                            <td><input type="type" name="diw"></td>
                        </tr>
                        <tr>
                            <td>DAW</td>
                            <td><input type="type" name="daw"></td>
                        </tr>
                        <tr>
                            <td>FCT</td>
                            <td><input type="type" name="fct"></td>
                        </tr>
                        <tr>
                            <td>Proyecto</td>
                            <td><input type="type" name="proyecto"></td>
                        </tr>
                         <tr align="center">
                            <td><button type="submit" >Grabar</button></td>
                        </tr>
                            
                    </thead>
                    

                       

                    

                </form>
            </table>
        </table>

    </body>
</html>
