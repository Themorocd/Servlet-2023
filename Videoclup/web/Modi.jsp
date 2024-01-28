<%-- 
    Document   : Modi
    Created on : 13 ene 2024, 16:23:12
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

        String sql = "SELECT * FROM `peliculas`";
        ArrayList<pelicula> lista = BBDD.BD.consultapelicula(sql);


    %>
    <body>
        <table border="1" align="center">
            <form action="ServleModificar" method="POST">
                <thead>
                    <tr>
                        <th>Modificar Pelicula</th>

                    </tr>
                </thead>
                <tbody>
                   
                    <tr>

                        <td>Selecciona la pelicula que desea consultar</td>

                        <td><select name="id">
                                <option>Elija opcion</option>
                                <%     
                                    for (pelicula peli : lista) {


                                %>
                                <option value="<%=peli.getId()%>"><%=peli.getPeli()%></option>
                            <%}%>
                            </select>
                        </td>
                        
                    </tr>
                    
                </tbody>
                <tr>
                    <td><input type="submit" value="Modificar pelicula"></td>
                    
                </tr>
                <tr>
                    <td><a href="Gestion.jsp">Volver a Gestion de Peliculas...</a></td>

                </tr>
            </form>
        </table>

    </body>
</html>

