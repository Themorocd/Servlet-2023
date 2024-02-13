<%-- 
    Document   : Cesta
    Created on : 13 feb 2024, 23:02:23
    Author     : moro-
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Disco"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%

    String nombreUsuario = (String) session.getAttribute("nombre");
    String apellidoUsuario = (String) session.getAttribute("apellido");
    
    ArrayList<Disco> listacompra = (ArrayList<Disco>) session.getAttribute("listacompra");
    
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
            <form action="actualizar" method="POST">
            <thead>
                <tr>
                    <th>Casa Disco</th>
                    
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Bienvenid@ ${nombre}${apellido}<br><br> Ha accedido a nuestra zona de pedidos a las ${hora} del ${fecha}</td>
                   
                </tr>
                <tr>
                    <td><a href="Clasicos.jsp">Clasicos</a></td>
                    <td><a href="HipHop.jsp">HipHop</a></td>
                    <td><a href="Jazz.jsp">Jazz</a></td>
                    <td><a href="POP.jsp">POP</a></td>
                    <td><a href="Cesta.jsp">Cesta</a></td>
                    
                </tr>
                <tr>
                    <td></td>
                    <td>Titulo</td>
                    <td>Cantidad</td>
                    <td>Precio</td>
                </tr>
                <%
                    
                double total = 0;
                if(listacompra != null){
                for (Disco elem : listacompra) {

                %>
                <tr>
                    <td><img src="images/<%=elem.getPortada()%>.jpg" width="200" height="200"/></td>
                    <td><%=elem.getTitulo()%></td>
                    <td><select name="id_<%=elem.getIddisco()%>">
                            <option hidden value="<%=elem.getCantdestacados()%>"><%=elem.getCantdestacados()%></option>
                            <%
                            for (int x = 0; x < 10; x++) {
                         
                            %>
                            <option value="<%=x%>"><%=x%></option>
                            <%}%>
                        </select>
                    </td>
                    <%
                    double can = elem.getCantdestacados();
                    double precio = (elem.getPrecio()) *(can);
                    total +=precio;
                    
                    %>
                    <td><%=precio%>€</td>
                </tr>
                <%}%>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>Total: <%=total%>€</td>
                </tr>
                <%}%>
                <%
                session.setAttribute("total", total);
                %>
                <tr>
                    <td><input type="submit" value="Actualizar pedido"></td>
                </tr>
                </form>
                <form action="enviodatos" method="POST">
                    <tr>
                        <td><input type="submit" value="Tramitar Pedido"></td>
                    </tr>
                </form>
            </tbody>
        </table>

    </body>
</html>
<%}%>