<%-- 
    Document   : listalibro1
    Created on : 11 ene. 2024, 9:40:04
    Author     : Andres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>Inicio de Sesión - Gestion de Biblioteca</title>
    </head>
    <body>
        <table width="100%" height="100%" border="0">
            <tr>
                <td bgcolor="#007bff" colspan="2" align="center" height="100">
                    <h1 style="color: #fff;">Gestion de Libreria</h1>
                </td>
            </tr>
            <tr>
                <td width="50%" bgcolor="#fff" valign="top" align="center">
                    <img src="img/inicio.png" alt="Imagen de Biblioteca" style="max-width: 100%; height: auto; margin: 20px;">
                </td>
            </tr>
            <tr>
                <td align="center">
                    <a href="altalibro.jsp">Alta de libro</a>
                    <a href="modilibro.jsp">Modificar libro</a>
                    <a href="borrolibro.jsp">Baja de libro</a>
                    <a href="listalibro1.jsp">Listado de libros</a>
                </td>
            </tr>
            <tr align = "center">
                <td>
                    <form action="ServletBuscar" method="post">
                        <label>Titulo del libro:</label>
                        <input type="text" name="titulo">
                        <button type="submit" >Buscar</button>
                    </form>
                </td>
            </tr>

        </table>
    </body>
</html>
