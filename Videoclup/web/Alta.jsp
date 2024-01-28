<%-- 
    Document   : Alta
    Created on : 12 ene 2024, 17:58:24
    Author     : moro-
--%>

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

        String sql = "SELECT * FROM `director`";
        ArrayList<director> lista = BBDD.BD.consultodirector(sql);


    %>
    <body>
        <table border="1" align="center">
            <form action="Servletalta" method="POST">
                <thead>
                    <tr>
                        <th>Alta Pelicula</th>

                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Pelicula:</td>
                        <td><input type="text" name="peli"></td>
                    </tr>
                    <tr>

                        <td>Director:</td>

                        <td><select name="id">
                                <option>Elija opcion</option>
                                <%     
                                    for (director dire : lista) {


                                %>
                                <option value="<%=dire.getId()%>"><%=dire.getNombre()%></option>
                            <%}%>
                            </select>
                        </td>
                        
                    </tr>
                    <tr>
                        <td>Fecha:</td>
                        <td><input type="date" name="fecha" min="2016-01-01" max="2016-12-31" required=""></td>
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
