<%-- 
    Document   : Formulario
    Created on : 9 nov. 2023, 10:10:38
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
        <form method="POST" action="ServletFormulario">
            <br>
            <table border="5px" align ="center">

                <tr>
                    <td>Nombre de la empresa</td>
                    <td><input type="text" name="nombre" pattern="[A-Za-z ]+" required></td>
                    <td>CIF</td>
                    <td><input type="text" name="cif" required></td>
                </tr>
                <tr>
                    <td>Representante legar de la empresa</td>
                    <td><input type="text" name="representante" pattern="[A-Za-z ]+"  required></td>
                    <td>NIF</td>
                    <td><input type="text" name="nif" required></td>
                </tr>
                <tr>
                    <td>Sector:</td>
                    <td><input type="radio" id="alimentacion" name="sector" value="alimentacion">
                        <label for="alimentacion">Alimentacion </label>

                        <input type="radio" id="textil" name="sector" value="textil">
                        <label for="textil">Textil </label>

                        <input type="radio" id="transporte" name="sector" value="transporte">
                        <label for="transporte">Transporte </label>

                        <input type="radio" id="medicina" name="sector" value="medicina">
                        <label for="medicina">Medicina </label>
                    </td>
                </tr>
                <tr>
                    <td>Telefono:</td>
                    <td><input type="text" name="telefono" required></td>
                    <td>Email:</td>
                    <td><input type="text" name="email" required></td>
                </tr>
                
                <tr>
                    <td>Volumen de ventas anuales:</td>
                    <td><input type="number" name="ventas" required></td>
                    
                </tr>
                 <tr>
                    <td>
                        <label>Obervaciones:</label>
                        <input type="textarea" id="area" name="texto" rows="50" cols="50" required>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="Anadir empresa">  
                        <input type="reset" value="Borrar empresa"> 
                        <button value="tabla"><a href="Todos">Listado de Empresas</a></button>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
