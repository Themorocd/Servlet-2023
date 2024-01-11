<%-- 
    Document   : listalibro
    Created on : 11 ene. 2024, 9:11:48
    Author     : Andres
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.titulos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>Inicio de Sesión - Gestion de Biblioteca</title>
    </head>
    <%
        
        String titulo =(String) getServletContext().getAttribute("id");
        ArrayList<titulos> listatitulo = BBDD.BD.consultatitulo(titulo);
    %>
    <body>
        <div>
        <table width="100%" height="100%" border="0" align = "center">
            <tr>
                <td bgcolor="#007bff" colspan="2" align="center" height="100">
                    <h1 style="color: #fff;">Gestion de Libreria</h1>
                </td>
            </tr>
            <tr>
                <td width="50%" bgcolor="#fff" valign="top" align="center">
                    <img src="img/inicio.png" alt="Imagen de Biblioteca" style="max-width: 100%; height: auto; margin: 20px;">
                </td>
            </tr>
            <tr>
                <td valign="top" align="center">
                    <a href="altalibro.jsp">Alta de libro</a>
                    <a href="modilibro.jsp">Modificar libro</a>
                    <a href="borrolibro.jsp">Baja de libro</a>
                    <a href="listalibro1.jsp">Listado de libros</a>
                </td>
            </tr>
            <tr align="center">
                <td>ISBN</td>
                <td>Titulo</td>
                <td>IDautor</td>               
                <td>Descripcion</td>
                <td>IDeditorial</td>

            </tr>
            <% for (titulos titu : listatitulo) {
            %>
            <tr align="center">
                <td><%=titu.getIsbn()%></td>
                <td><%=titu.getTitulo()%></td>
                <td><%=titu.getIdautor()%></td>     
                <td><%=titu.getDescripcion()%></td>
                <td><%=titu.getIdeditorial()%></td>
                <%}%>
            </tr>
        </table>
        </div>
    </body>
</html>
