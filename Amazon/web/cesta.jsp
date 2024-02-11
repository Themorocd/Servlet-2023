<%-- 
    Document   : cesta
    Created on : 30 ene. 2024, 11:00:23
    Author     : Andres
--%>

<%@page import="modelo.Libros"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    // Obtenemos información de la sesión
    String nombreUsuario = (String) session.getAttribute("nombre");
    String apellidoUsuario = (String) session.getAttribute("apellido");

    // Obtenemos la lista de libros de la sesión
    ArrayList<Libros> listacompra;
    listacompra = (ArrayList<Libros>) session.getAttribute("listacompra");

    // Inicializamos la variable 'carro' para contar la cantidad de libros en la cesta
    int carro = 0;
    if (listacompra != null) {
        carro += listacompra.size();
    }

    // Verificamos si el usuario no ha iniciado sesión
    if (nombreUsuario == null && apellidoUsuario == null) {
        // Redirigimos al usuario a la página de inicio
        RequestDispatcher rd;
        ServletContext contex = getServletContext();
        rd = contex.getRequestDispatcher("/index.html");
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
            <form action="Enviodatos" method="POST">
                <thead>
                    <tr>
                        <th>Amazon</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Bienvenid@ ${nombre} ${apellido}<br><br>Ha accedido a nuestra zona de pedidos a las ${hora} del ${fecha}</td>
                    </tr>
                    <tr>
                        <td><a href="Destacados.jsp">Destacados</a></td>
                        <td><a href="Vendidos.jsp">Los más vendidos</a></td>
                        <td><a href="infantil.jsp">Infantil</a></td>
                        <td><a href="Valorados.jsp">Los más valorados</a></td>
                        <td><a href="cesta.jsp">Cesta</a></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>Titulo</td>
                        <td>Cantidad</td>
                        <td>Precio</td>
                    </tr>
                    <%
                        double total = 0;
                        // Iteramos sobre la lista de libros en la cesta
                        if (listacompra != null) {
                            for (Libros elem : listacompra) {
                    %>
                    <tr>
                        <td><img src="images/<%=elem.getPortada()%>.jpg"></td>
                        <td><%=elem.getTitulo()%></td>
                        <td><%=elem.getCantdestacados()%></td>
                        <%
                            double can = elem.getCantdestacados();
                            double precio = (elem.getPrecio()) * (can);
                            total += precio;
                        %>
                        <td><%=precio%>€</td>
                    </tr>
                    <%
                        }
                    %>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <th>TOTAL: <%=total%> €</th>
                    </tr>
                     <% }%>
                    <%
                        // Guardamos el total en la sesión
                        session.setAttribute("total", total);
                    %>
                    </tr>
                    <tr>
                        <td>
                            <input type="submit" value="Confirmar Pedido">
                        </td>
                    </tr>
                </tbody>
            </form>
        </table>
    </body>
</html>

<%
    }
%>
