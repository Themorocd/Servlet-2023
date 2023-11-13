<%-- 
    Document   : TablaFormulario
    Created on : 13 nov. 2023, 10:19:23
    Author     : Andres
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Servlets.Partes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            ArrayList<Partes> partes = (ArrayList<Partes>) getServletContext().getAttribute("parte");
            
        %>
    </head>
    <body>
        <table border="5" width="1" cellspacing="1" align="center">
            <thead>
                <tr>
                    <th>NºSS</th>
                    <th>Apellido1 Apellido2</th>
                    <th>Nombre</th>
                    <th>CIF</th>
                    <th>Empresa</th>
                    <th>Descripcion</th>
                </tr>
            </thead>
            <tbody>
                <%
                    if (partes != null) {

                        for (Partes part : partes) {


                %>
                <tr>
                    <td><%= part.getNss()%></td>
                    <td><%= part.getApellido1()%> <%= part.getApellido2()%></td>
                    <td><%= part.getNombre()%></td>
                    <td><%= part.getCif()%></td>
                    <td><%= part.getRazon()%></td>
                    <td><%= part.getTexto()%></td>
                </tr>
                <%}
                    }%>
            </tbody>


        </table>
        <div align="center">
            <a href="Formulario.jsp"><button>Seguir añadiendo Empresas</button></a>
        </div>
    </body>
</html>
