<%-- 
    Document   : Formulario
    Created on : 7 nov. 2023, 10:13:53
    Author     : Andres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            String user = (String) getServletContext().getAttribute("user");
        %>
    </head>
    <body>
        <form method="post" action="servletformu">
            <table border="5px" align="center">
                <tr>
                    <td>Nombre de la actividad:</td>
                    <td><input type="text" name="name" required pattern="[A-Za-z ]+"></td>
                </tr>
                <tr>
                    <td>Lugar de celebración</td>
                    <td><input type="type" name="lugar" required pattern="[A-Za-z ]+"></td>
                </tr>
                <tr>
                    <td>Fecha</td>
                    <td><input type="date" name="fecha" required pattern="dd/MM/yyyy"></td>
                </tr>
                <tr>
                    <td>Hora</td>
                    <td><input type="time" name="hora" required></td>
                </tr>
                <tr>
                    <td><label>Destinado a:</label></td>
                    <td><input type="radio" id="alumnado" name="destino" value="alumnado" required>
                        <label for="alumnado">Alumnado</label>

                        <input type="radio" id="profesorado" name="destino" value="profesorado">
                        <label for="profesorado">Profesorado</label>
                    </td>
                </tr>
                <tr>

                    <td><label>Tipo de actividad</label><br><br></td>
                    <td><br>
                        <fieldset> 
                            <input type="checkbox" id="academica" name="actividad" value="academica" >
                            <label for="academica">Academica</label><br>

                            <input type="checkbox" id="deportiva" name="actividad" value="deportiva" >
                            <label for="deportiva">Deportiva</label><br>

                            <input type="checkbox" id="cultural" name="actividad" value="cultural" >
                            <label for="cultural">Cultural</label><br>

                            <input type="checkbox" id="convivencia" name="actividad" value="convivencia" >
                            <label for="convivencia">Convivencia</label><br>


                        </fieldset>
                    </td>

                </tr>

                <tr>
                    <td><label for="curso">Curso Destinado</label></td>
                    <td><select name="curso" required id="curso">
                            <option value="" disabled selected>Seleccione el curso al que va destinada la actividad</option>
                            <% if (user.equals("eso")) {

                            %>
                            <option value="1ºESO">1ºESO</option>
                            <option value="2ºESO">2ºESO</option>
                            <option value="3ºESO">3ºESO</option>
                            <option value="4ºESO">4ºESO</option>

                            <%} else {%>

                            <option value="1ºGrado">1ºGrado</option>
                            <option value="2ºGrado">2ºGrado</option>

                            <%}%>
                        </select></td>
                </tr>
                <tr>
                    <td>Profesor responsable:</td>
                    <td><input type="text" name="profe" required pattern="[A-Za-z ]+"></td>
                </tr>
                <tr>
                    <td>
                        <label>Obervaciones:</label>
                        <input type="textarea" id="area" name="texto" rows="20" cols="20">
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="Añadir actividad">
                        <input type="reset" name="Borrar actividad">
                        <button value="tabla"><a href="TablaFormulario.jsp">Listado de actividades</button>
                    </td>
                </tr>

            </table>    

        </form>
    </body>
</html>
