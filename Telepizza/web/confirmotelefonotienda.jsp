<%-- 
    Document   : confirmotelefonotienda
    Created on : 29 ene. 2024, 9:28:45
    Author     : Andres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
String nombreUsuario = (String) session.getAttribute("user");
if (nombreUsuario==null) {
    
    RequestDispatcher rd;
ServletContext contex=getServletContext();
    
    rd=contex.getRequestDispatcher("/index.html");
    rd.forward(request, response);
        
    } else {

%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="5" align="center">
            <form action="confirmotelreco" method="POST">
               <tr>
                    <th>TELEPIZZA</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>${user}<br><br>debe de indicar su telefono para confirmar el pedido</td>
                    
                </tr>
                <tr>
                    <td><input type="tel" name="tele"></td>
                    
                </tr>
                <tr>
                    <td><input type="submit" value="tramitar pedido"></td>
                </tr>
            </tbody>
           
            <thead>
                 </form>
        </table>

    </body>
</html>
<%}%>