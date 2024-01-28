<%-- 
    Document   : zona_localizacion
    Created on : 25 ene. 2024, 9:28:39
    Author     : Andres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
 String nombreUsuario = (String) session.getAttribute("nombre");
 

if (nombreUsuario==null) {
    
    RequestDispatcher rd;
ServletContext contex=getServletContext();
    
    rd=contex.getRequestDispatcher("/index.html");
    rd.forward(request, response);
        
    } else {

%>
    <body>
        <form action="resumen.jsp" method="POST">
        <table border="5" align="center">
            <thead>
                <tr>
                    <th>${nombre}, por favor indica su telefono para confirmar la direccion del envio</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><input type="text" name="tefl"></td>
                    <td></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Confirmar pedido"></td>
                    <td></td>
                </tr>
            </tbody>
        </table>
</form>
    </body>
</html>
<%}%>