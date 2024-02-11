<%-- 
    Document   : pedido
    Created on : 11 feb 2024, 18:31:48
    Author     : moro-
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%

    String nombreUsuario = (String) session.getAttribute("nombre");
    String apellidoUsuario = (String) session.getAttribute("apellido");
    
    if(nombreUsuario == null && apellidoUsuario == null){
    RequestDispatcher rd;
    ServletContext contexto = getServletContext();
    rd = contexto.getRequestDispatcher("/index.html");
    rd.forward(request, response);

    }else{

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="5" align="center">
            <thead>
                <tr>
                    <th>Amazon</th>
                    
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Bienvenid@ ${nombre} ${apellido}<br><br>Ha acedido a nuestra zona de pedidos a las ${hora} del ${fecha}</td>
                </tr>
               
                <tr>
                    <td><a href="Destacados.jsp">Destacados</a></td>
                    <td><a href="Vendidos.jsp">Los mas vendidos</a></td>
                    <td><a href="infantil.jsp">Infantil</a></td>
                    <td><a href="Valorados.jsp">Los mas valorados</a></td>
                    <td><a href="cesta.jsp">Cesta</a></td>
                </tr>
            </tbody>
        </table>

        
    </body>
</html>
<%}%>