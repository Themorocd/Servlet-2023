<%-- 
    Document   : Listadoventas1
    Created on : 30 nov 2023, 17:43:40
    Author     : Andres
--%>


<%@page import="vista.Ventas"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
</head>

<body>
    <%

        String producto = request.getParameter("pro");
        ArrayList<Ventas> venta = BBDD.BD.consultaventas(producto);


    %>

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
                    
                        <tr align="center">
                            <td colspan="2"><h3>Listado de ventas</h3></td>
                        </tr>

                        <tr>
                            <th>Fecha</th>
                            <th>Comercial</th>
                            <th>Cantidad</th>
                            <th>Precio</th>
                            <th>Total</th>
                            <th>Descuento</th>
                            <th>Total Descuento</th>
                            
                        </tr>
                         <%
                        for (Ventas elem : venta) {
                                
                            
                        
                        %>
                        <tr>
                           
                            <td><%= elem.getFecha() %></td>
                            <td><%= elem.getComercial()%></td>
                            <td><%= elem.getCantidad()%></td>
                            <td><%= elem.getPrecio()%></td>
                            <td><%= elem.getTotal()%></td>
                            <td><%= elem.getDescuento()%></td>
                            <td><%= elem.getTotaldescuento()%></td>
                        </tr>
                        <%}%>



                        <tr>
                            <td colspan="2" align="center">
                                <input name="aceptar" type="submit" value="aceptar" />
                                <input name="cancelar" type="reset" value="cancelar" />
                            </td>
                        </tr>
                    
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
