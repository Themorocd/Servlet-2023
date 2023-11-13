<%-- 
    Document   : Formulario
    Created on : 13 nov. 2023, 9:11:50
    Author     : Andres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="Post" action="ServletFormulario">
            <table border="5px" align="center">
                <tr>
                    <th>Datos del Trabajador</th>
                </tr>
                <tr>
                    <td><label for="apellido1">Apellido 1</label></td>
                    <td><input type="text" name="apellido1" pattern="[A-Za-z ]+" required></td><br>
                    <td><label for="apellido2">Apellido 2</label></td>
                    <td><input type="text" name="apellido2" pattern="[A-Za-z ]+" required></td>
                    <td><label for="nombre">Nombre</label></td>
                    <td><input type="text" name="nombre" pattern="[[A-Za-z ]+" required></td>
                </tr>
                <tr>
                    <td><label for="nss">NºSS</label></td>
                    <td><input type="text" name="nss" required></td><br>
                    <td><label for="fechaingreso">Fecha ingreso en la empresa</label></td>
                    <td><input type="date" name="fecha1" required></td>
                    <td><label for="fechanacimiento">Fecha de Nacimiento</label></td>
                    <td><input type="date" name="fecha2" required></td>
                </tr>
                <tr>
                    <th>Datos de la Empresa</th>
                </tr>
                <tr>
                    <td><label for="cif">CIF</label></td>
                    <td><input type="text" name="cif" required></td><br>
                </tr>
                <tr>
                    <td><label for="razonsocial">Nombre o Razón social</label></td>
                    <td><input type="text" name="razon" required></td><br>
                </tr>
                <tr>
                    <td><label for="ccc">CCC</label></td>
                    <td><input type="text" name="ccc" required></td><br>
                </tr>
                <tr>
                    <td><label for="texto">Descripcion del Accidente</label></td>
                    <td><input type="text" name="texto" required></td><br>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="Aceder">
                        <input type="reset" value="Borrar">
                        <button value="tabla"><a href="TablaFormulario.jsp">Listado de partes</a></button>
                        
                    </td>

                </tr>
            </table>
        </form>
    </body>
</html>
