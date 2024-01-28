<%-- 
    Document   : Listatitudirector
    Created on : 13 ene 2024, 20:50:35
    Author     : moro-
--%>

<%@page import="Modelo.pelicula"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.director"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        String nombre = (String) getServletContext().getAttribute("nombre");
        String sql = "SELECT peliculas.titulo AS titulo, director.nombre AS director, peliculas.fecha_estreno FROM peliculas JOIN director ON peliculas.director = director.id WHERE director ='"+nombre+"'";
        
        ArrayList<pelicula> lista = BBDD.BD.consupelicula(sql);  
        
    %>
    
    <body>
        <table border="1" align="center">
            <thead>
                <tr>
                    <th>Listado de Peliculas</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Pelicula</td>
                    <td>Director</td>
                    <td>Fecha</td>
                </tr>
                <tr>
                    <%
                    
                    for (pelicula dipe : lista) {
                            
                        
                    
                    %>
                    <td><%=dipe.getPeli()%></td>
                    <td><%=dipe.getDire()%></td>
                    <td><%=dipe.getFecha()%></td>
                   
                </tr>
                 <%}%>
            </tbody>
            <td><a href="Gestion.jsp">Volver a pagina de Gestion...</a></td>
        </table>

    </body>
</html>
