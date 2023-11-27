<%-- 
    Document   : Resultado
    Created on : 27 nov. 2023, 13:08:41
    Author     : Andres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            ServletContext contexto = request.getServletContext();
            Double precioDouble = (Double) contexto.getAttribute("precio");
            Double entregadoDouble = (Double) contexto.getAttribute("entregado");
            Double cambioDouble = (Double) contexto.getAttribute("cambio");

            String precio = (precioDouble != null) ? precioDouble.toString() : null;
            String entregado = (entregadoDouble != null) ? entregadoDouble.toString() : null;
            String cambio = (cambioDouble != null) ? cambioDouble.toString() : null;
            double[] billetesmoneda = {500, 200, 100, 50, 20, 10, 5, 2, 1, 0.50, 0.20, 0.10, 0.05, 0.02, 0.01};
            double cambiodevuelto = Double.parseDouble(cambio);
%>
    </head>
    <body>
        <table border="5" align="center">
            <thead>
                <tr>
                    <th>Importe de venta: <%=precio%></th>
                    <th>Cantidad entregada: <%=entregado%></th>
                </tr>
            </thead>
            <tbody>
                <%
                if(entregadoDouble < precioDouble){
                
                %>
                 <tr>
                    <td>La cantidad entregada no es suficiente</th>
                    
                </tr>
                <%}else{%>
                <%
                    
                    for (int x = 0; x < billetesmoneda.length; x++) {
                        int cantidad = (int) (cambiodevuelto / billetesmoneda[x]);
                        if (cantidad > 0) {
                            if (billetesmoneda[x] > 2) {


                %>
                <tr>
                    <td><%=cantidad%> billetes de <%=billetesmoneda[x]%>€</td>
                    <%} else {%>
                    <td><%=cantidad%> monedas de <%=billetesmoneda[x]%>€</td>
                    <%}
                         cambiodevuelto = cambiodevuelto - (cantidad * billetesmoneda[x]);
                            }
                        }}%>
                </tr>
            </tbody>
        </table>

    </body>
</html>
