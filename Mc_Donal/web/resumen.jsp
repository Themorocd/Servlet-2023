<%-- 
    Document   : resumen
    Created on : 25 ene. 2024, 9:42:13
    Author     : Andres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String nombreUsuario = (String) session.getAttribute("nombre");
            String menus = (String) application.getAttribute("menus");
            String sandwiches = (String) application.getAttribute("sandwiches");
            String complementos = (String) application.getAttribute("complementos");
            String ensaladas = (String) application.getAttribute("ensaladas");
            String bebidas = (String) application.getAttribute("bebidas");

            if (nombreUsuario == null) {

                RequestDispatcher rd;
                ServletContext contex = getServletContext();

                rd = contex.getRequestDispatcher("/index.html");
                rd.forward(request, response);

            } else {

        %>
    <body>
        <form action="salir" method="POST">
        <table border="5" align="center">
            <thead>
                <tr>
                    <th>Gracias,${nombre}, tu pedido ha sido tramitado a las ${fecha} ${hora} y consta de los siguientes productos: </th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <%
                if(!menus.equals("0")){
                
                
                %>
                <tr>
                    <td>Menu: <%=menus%></td>

                </tr>
                <%}%>
                <%
                if(!sandwiches.equals("0")){
                %>
                <tr>
                    <td>sandwiches: <%=sandwiches%></td>

                </tr>
                <%}%>
                 <%
                if(!complementos.equals("0")) {
                %>
                <tr>
                    <td>complementos: <%=complementos%></td>

                </tr>
                <%}%>
                <%
                if(!ensaladas.equals("0")){
                %>
                <tr>
                    <td>ensaladas: <%=ensaladas%></td>

                </tr>
                <%}%>
                <%
                if(!bebidas.equals("0")){
                %>
                <tr>
                    <td>bebidas: <%=bebidas%></td>

                </tr>
                <%}%>
                
                <tr>
                    <td>aproximadamente en 30min tendra su pedido</td>
                </tr>
                <tr>
                    <td> <input type="submit" value="salir"></td>
                </tr>
            </tbody>
        </table>
</form>
    </body>
</html>
<%}%>
