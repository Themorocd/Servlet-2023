<%-- 
    Document   : modificarpelicula
    Created on : 13 ene 2024, 16:35:12
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
    <%

        
        pelicula peli = (pelicula) getServletContext().getAttribute("peli");

    %>
    <body>
        <table border="1" align="center">
            <form action="Servlemodifinal" method="POST">
                <thead>
                    <tr>
                        <th>Modificar Pelicula</th>

                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Pelicula:</td>
                        <td><input type="text" name="pel" value="<%=peli.getPeli()%>" required=""></td>
                    </tr>
                    <tr>

                        <td>Director:</td>

                        <td><select name="id" readonly="readonly">


                                <option value="<%=peli.getDire()%>"><%=peli.getDire()%></option>

                            </select>
                        </td>

                    </tr>
                    <tr>
                        <td>Fecha:</td>
                        <td><input type="date" name="fecha" value="<%=peli.getFecha()%>"  min="2016-01-01" max="2016-12-31" required="" ></td>
                    </tr>
                </tbody>
                <tr>
                    <td><input type="submit" value="Acceptar"></td>
                    <td><input type="reset" value="Cancelar"></td>
                </tr>
                <tr>
                    <td><a href="Gestion.jsp">Volver a Gestion de Peliculas...</a></td>

                </tr>
            </form>
        </table>

    </body>
</html>
