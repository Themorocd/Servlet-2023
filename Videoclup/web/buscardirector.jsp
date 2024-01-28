<%-- 
    Document   : buscardirector
    Created on : 13 ene 2024, 20:46:18
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

       String sql = "SELECT * FROM `director`";
        ArrayList<director> lista = BBDD.BD.consultodirector(sql);


    %>
    <body>
        <table border="1" align="center">
            <form action="Servletbuscopelipordirector" method="POST">
                <thead>
                    <tr>
                        <th>Buscar Pelicula</th>

                    </tr>
                </thead>
                <tbody>
                   
                    <tr>

                        <td>Director</td>

                        <td><select name="id">
                                <option>Elija opcion</option>
                                <%     
                                    for (director peli : lista) {


                                %>
                                <option value="<%=peli.getId()%>"><%=peli.getNombre()%></option>
                            <%}%>
                            </select>
                        </td>
                        
                    </tr>
                    
                </tbody>
                <tr>
                    <td><input type="submit" value="Buscar"></td>
                    
                </tr>
                <tr>
                    <td><a href="Gestion.jsp">Volver a Gestion de Peliculas...</a></td>

                </tr>
            </form>
        </table>

    </body>
</html>