<%-- 
    Document   : modilibrodatos
    Created on : 11 ene. 2024, 9:04:16
    Author     : Andres
--%>

<%@page import="modelo.editorial"%>
<%@page import="modelo.autor"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.titulos"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>Inicio de Sesión - Gestion de Biblioteca</title>
    </head>
    <body>
        <%
                titulos titus= (titulos) getServletContext().getAttribute("titu");
                String sql = "SELECT * FROM titulos";
                ArrayList<titulos>listatitu = BBDD.BD.consultatitulo(sql);
                String sqlll = "SELECT * FROM autor";
                ArrayList<autor>listaautor = BBDD.BD.consultaautor(sqlll);
                String sql1 = "SELECT * FROM editorial";
                ArrayList<editorial>listaedi = BBDD.BD.consultaedi(sql1);
                %>
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
            <form action="modlibro" method="POST">
                <label for="ISBN">ISBN:</label>
                <input type="text" name="ISBN" value="<%=titus.getIsbn()%>" readonly=»readonly» /><br>
                <label for="Titulo">Titulo</label>
                <input type="text" name="Titulo" value="<%=titus.getTitulo()%>" required="" /><br>
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
                <input type="number" name="fecha" value="<%=titus.getAño()%>" required="" min="2000" max="2022"  /><br>
                <label for="Descripcion">Descripcion</label>
                <input type="text" name="Descripcion" value="<%=titus.getDescripcion()%>" required="" /><br>

                <input type="submit" value="Aceptar" name="Aceptar" />
                <input type="reset" value="Cancelar" name="Cancelar" />
            </form>
                </td>
            </tr>
        </table>
    </body>
</html>