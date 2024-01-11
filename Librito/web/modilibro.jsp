<%-- 
    Document   : modilibro
    Created on : 11 ene. 2024, 8:59:16
    Author     : Andres
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.titulos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table width="100%" height="100%" border="0">
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
                <td align="center">
                    <a href="altalibro.jsp">Alta de libro</a>
                    <a href="modilibro.jsp">Modificar libro</a>
                    <a href="borrolibro.jsp">Baja de libro</a>
                    <a href="listalibro1.jsp">Listado de libros</a>
                </td>
            </tr>
            <tr>
                <td>
                    <form action="modilibro" method="POST">
                        <%
                            String sql = "SELECT * FROM titulos";
                            ArrayList<titulos> listatitu = BBDD.BD.buscatitulo(sql);

                        %>
                        
                        <label for="Libro">Titulo del libro</label>

                        <select name="sel" size="">
                            <option>Elija opcion</option>
                            <%                     for (titulos titu : listatitu) {
                            %>
                            <option value="<%=titu.getTitulo()%>"><%=titu.getTitulo()%></option>
                            <%}%>
                        </select>
                        <br>
                        <input type="submit" value="Aceptar">
                    </form>
                </td>
            </tr>



        </table>
    </body>
</html>
