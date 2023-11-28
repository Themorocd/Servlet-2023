<%-- 
    Document   : TablaFormu
    Created on : 28 nov. 2023, 9:03:39
    Author     : Andres
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Vista.Libros"%>
<%@page import="BBDD.bbdd" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
        String dato = request.getParameter("titulo");
        ArrayList<Libros> lista = BBDD.bbdd.consultarTitulos(dato);
        
        %>
    </head>
    <body>
        
        
        <table border="5" align="center">
            <h1>Consulta de los titulos disponibles</h1>
            <thead>
                <tr>
                    <td>TITULO</td>
                    <td>ISBN</td>
                    <td>AUTOR</td>
                    <td>EDITORIAL</td>
                    <td>DESCRIPCION</td>
                    
                </tr>
            </thead>
            <tr>
                <%
                for (Libros libro : lista) {
                        
                    
                %>
                    <td><%= libro.getTitulo() %></td>
                    <td><%= libro.getIsbn()%></td>
                    <td><%= libro.getAutor()%></td>
                    <td><%= libro.getEditorial()%></td>
                    <td><%= libro.getDescripcion()%></td>
                    
                </tr>
                <%}%>
            <tbody>
            </tbody>
            <tr>
                <td> <a href="index.html">Volver a pagina de inicio</a></td>
            </tr>
        </table>
            
    </body>
</html>
