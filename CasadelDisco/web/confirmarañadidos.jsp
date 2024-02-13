<%-- 
    Document   : confirmarañadidos
    Created on : 13 feb 2024, 17:39:52
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
                    <th>Casa Disco</th>
                    
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Bienvenid@ ${nombre} ${apellido} <br><br> Ha accedido a nuestra zona de pedidos a las ${hora} del ${fecha}</td>
                    
                </tr>
                <tr>
                    <td><a href="Clasica.jsp">Clasica</a></td>
                    <td><a href="Hip-Hop.jsp">Hip-Hop</a></td>
                    <td><a href="Jazz.jsp">Jazz</a></td>
                    <td><a href="POP-ROCK.jsp">POP-ROCK</a></td>
                    <td><a href="Cesta.jsp">Cesta</a></td>
                </tr>
                <tr>
                    <td>Pedido añadido a la cesta</td>
                </tr>
            </tbody>
        </table>

    </body>
</html>
<%}%>
