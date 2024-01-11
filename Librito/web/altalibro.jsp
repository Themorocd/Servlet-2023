<%-- 
    Document   : altalibro
    Created on : 11 ene. 2024, 8:48:54
    Author     : Andres
--%>


<%@page import="modelo.editorial"%>
<%@page import="BBDD.BD" %>
<%@page import="modelo.autor"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>Inicio de Sesión - Gestion de Biblioteca</title>
        <%
            String sqlll = "SELECT * FROM autor";
            ArrayList<autor> listaautor = BBDD.BD.consultaautor(sqlll);
            String sql1 = "SELECT * FROM editorial";
            ArrayList<editorial> listaedi = BBDD.BD.consultaedi(sql1);
        %>
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
                <td aling="center">
                    <form action="altalibro" method="POST">

                        <label for="ISBN">ISBN:</label>
                        <input type="text" name="ISBN" value="" required="" pattern="0-13-\d{6}-\d"/><br>
                        <label for="Titulo">Titulo</label>
                        <input type="text" name="Titulo" value="" required="" /><br>
                        <label for="Autor">Autor</label>
                        <select name="sel" size="">
                            <option>Elija opcion</option>
                            <%
                                for (autor au : listaautor) {
                            %>
                            <option value="<%=au.getIdautor()%>"><%=au.getNombre()%></option>
                            <%}%>
                        </select>
                        <br>
                        <label for="Editorial">Editorial</label>
                        <select name="sel1" size="">
                            <option>Elija opcion</option>
                            <%
                                for (editorial edi : listaedi) {
                            %>
                            <option value="<%=edi.getIdeditorial()%>"><%=edi.getNombreeditorial()%></option>
                            <%}%>
                        </select>
                        <br>
                        <label for="fecha">Año de edicion</label>
                        <input type="number" name="fecha" value="fecha" required="" min="2000" max="2022"  /><br>
                        <label for="Descripcion">Descripcion</label>
                        <input type="text" name="Descripcion" value="" required="" /><br>
                        <input type="submit" value="Aceptar" name="Aceptar" />
                        <input type="reset" value="Cancelar" name="Cancelar" />

                    </form>
                </td>
            </tr>


        </table>
    </body>
</html>
