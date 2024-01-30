<%-- 
    Document   : cesta
    Created on : 30 ene. 2024, 11:00:23
    Author     : Andres
--%>

<%@page import="modelo.Libros"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
 String nombreUsuario = (String) session.getAttribute("nombre");
 String apellidoUsuario = (String) session.getAttribute("apellido");
 String infantil = (String) session.getAttribute("infantil");
 String cantinfantil = (String) session.getAttribute("cantinfantil");
 String destacados = (String) session.getAttribute("infantil");
 String cantdestacados = (String) session.getAttribute("cantdestacados");
 String valorados = (String) session.getAttribute("valorados");
 String cantvalorados = (String) session.getAttribute("cantvalorados");
 String vendidos = (String) session.getAttribute("vendidos");
 String cantvendidos = (String) session.getAttribute("cantvendidos");
 ArrayList<Libros> Listvendidos = (ArrayList<Libros>) session.getAttribute("Listvendidos");
 ArrayList<Libros> listinfantil = (ArrayList<Libros>) session.getAttribute("listinfantil");
 ArrayList<Libros> listvalorados = (ArrayList<Libros>) session.getAttribute("listvalorados");
 ArrayList<Libros> Listdestacados = (ArrayList<Libros>) session.getAttribute("Listdestacados");
//Recogiendo asi los array puedo meterle un bucle y sacar todos sus datos sin necesida de volver a meterle la sql
if (nombreUsuario==null && apellidoUsuario == null) {
    
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
                <tr>
                    <td></td>
                    <td>Titulo</td>
                    <td>Cantidad</td>
                    <td>Precio</td>
                </tr>
                <%
                if(!destacados.contains("0") && !cantdestacados.contains("0")){
              
                %>
                <tr>
                    <%
                    for (Libros elem : Listdestacados) {
                                       
                    %>
                    <td><img src="images/<%=elem.getPortada()%>.jpg"></td>
                    <%}%>
                    <td>${d}</td>
                </tr>
                
            </tbody>
        </table>

        
    </body>
</html>
<%}%>