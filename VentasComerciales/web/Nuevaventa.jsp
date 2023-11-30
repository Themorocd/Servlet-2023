<%@page import="java.util.ArrayList"%>
<%@page import="vista.Productos"%>
<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Documento sin título</title>
        <%
        String sql1 = "Select * from productos";
        ArrayList<Productos>productos = BBDD.BD.consultaProductos(sql1);
       
        %>
    </head>

    <body>

        <table width="100%" border="0">
            <tr>
                <td colspan="7" bgcolor="#333333">&nbsp;</td>
            </tr>
            <tr align="center">
                <td colspan="7" bgcolor="#CCCCCC"><h1>APLICACIÓN DE GESTIÓN COMERCIAL</h1></td>
            </tr>

            <tr align="center">
                <td>
                    <a href="pagina_ventas.jsp"><img src="img/ventas.jpg" width="180" height="123" /></a>
                    <br />
                    <a href="Listadoventas.jsp"><img src="img/listado-ventas.jpg" width="180" height="50" /></a>
                    <br />
                    <a href="Nuevaventa.jsp"><img src="img/nueva-venta.jpg" width="180" height="50" /></a>
                </td>
                <td><a href="pagina_productos.jsp"><img src="img/productos.jpg" width="180" height="123" /></a></td>
                <td><a href="pagina_comerciales.jsp"><img src="img/comerciales.jpg" alt="" width="180" height="123" /></a></td>
            </tr>
            <tr>
                <td colspan="7" bgcolor="#CCCCCC">&nbsp;</td>
            </tr>
            <tr>
                <td colspan="7">

                    <table width="50%" border="0" align="center">
                        <form action="Servletlistadoventas" method="post">
                            <tr align="center">
                                <td colspan="2"><h3>Listado de ventas</h3></td>
                            </tr>
                            <tr>
                                
                                <td align="center">
                                    <label>Comercial</label>
                                    <select id="comercial">
                                        <option value="comer">Selecciona comercial</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                
                                <td align="center">
                                    <label>Producto:</label>
                                    <select id="producto">
                                        <option value="producto">Selecciona un producto</option>
                                        <%
                                
                                for (Productos elem : productos) {
     
                                %>
                                        <option value="producto"><%=elem.getNombre()%></option>
                                         <%}%>
                                    </select>
                                </td>
                                   
                            </tr>
                            <tr>
                                <td align="center">
                                    <label>Cantidad</label>
                                    <input type="text" name="cantidad">
                                </td>
                            </tr>
                            <tr>
                                <td align="center">
                                    <label>fecha</label>
                                    <input type="date" name="fecha">
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2" align="center">
                                    <input name="aceptar" type="submit" value="aceptar" />
                                    <input name="cancelar" type="reset" value="cancelar" />
                                </td>
                            </tr>
                        </form>
                    </table>
                </td>
            </tr>

            <tr>
                <td colspan="7">&nbsp;</td>
            </tr>
            <tr>
                <td colspan="7" bgcolor="#CCCCCC">&nbsp;</td>
            </tr>
        </table>

    </body>
</html>

