<%-- 
    Document   : Formulario
    Created on : 14 nov. 2023, 8:35:42
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
        <form method="Post" action="SerfleFormulario">
            <table border="5px" align="center">
                
                <tr>
                    <th>Datos del trabajador</th>
                </tr>
                <tr>
                    <td><label>Apellido1</label></td>
                    <td><input type="text" name="apellido1" required></td>
                    <td><label>Apellido2</label></td>
                    <td><input type="text" name="apellido2" required></td>
                    <td><label>Nombre</label></td>
                    <td><input type="text" name="nombre" required></td>
                </tr>
                <tr>
                    <td><label>NºSS</label></td>
                    <td><input type="text" name="nss" required></td>
                    <td><label>Fecha Ingreso en la Empresa</label></td>
                    <td><input type="date" name="fecha1" required></td>
                    <td><label>Fecha de Nacimiento</label></td>
                    <td><input type="date" name="fecha2" required></td>
                </tr>
                
                <tr>
                    <th>Datos de la empresa</th>
                </tr>
                <tr>
                    <td><label>CIF</label></td>
                    <td><input type="text" name="cif" required></td>

                </tr>
                <tr>
                    <td><label>Nombre o Razón social</label></td>
                    <td><input type="text" name="social" required></td>

                </tr>
                <tr>
                    <td><label>CCC</label></td>
                    <td><input type="text" name="ccc" required></td>

                </tr>
                <tr>
                    <td><label>Descripcion del accidente</label></td>
                    <td><input type="<textarea id="texto" name="texto" rows="5" cols="10" required></textarea></td>

                </tr>
                <tr>

                    <td><input type="submit" name="Acceder"></td>
                    <td><input type="reset" name="Borrar"></td>
                    <td><button value="tabla"><a href="TablaFormulario.jsp">Listado de partes</a></button></td>
                </tr>
            </table>
        </form>
    </body>
</html>
