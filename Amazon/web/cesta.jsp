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
 String destacados = (String) session.getAttribute("destacados");
 String cantdestacados = (String) session.getAttribute("cantdestacados");
 String valorados = (String) session.getAttribute("valorados");
 String cantvalorados = (String) session.getAttribute("cantvalorados");
 String vendidos = (String) session.getAttribute("vendidos");
 String cantvendidos = (String) session.getAttribute("cantvendidos");
 double totaldestacados=0;
 double totalinfantil=0;
 double totalvalorados = 0;
 double totalvendidos = 0;
 
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
            <form action="Enviodatos" method="POST">
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
                  String sql = "Select * from libros where Idlibro='"+destacados+"'";
                ArrayList<Libros>Listdestacados = BBDD.BD.consultadestacados(sql);
                
                for (Libros elem : Listdestacados) {
            out.println("<script>");
            out.println("console.log('Portada: " + elem.getPortada() + "')");
            out.println("console.log('Título: " + elem.getTitulo() + "')");
            out.println("console.log('Cantidad: " + cantdestacados + "')");
            out.println("console.log('Precio: " + elem.getPrecio() + "')");
            out.println("</script>");
                    }

                %>
                <tr>
                    <%
                    for (Libros elem : Listdestacados) {
                                       
                    %>
                    <td><img src="images/<%=elem.getPortada()%>.jpg"></td>
                    
                    <td><%=elem.getTitulo()%></td>
                    <%}%>
                    <td>${cantdestacados}</td>
                    <%
                     for (Libros elem : Listdestacados) {
                    
                        double precio = elem.getPrecio();
                        int cantidad = Integer.parseInt(cantdestacados);
                        totaldestacados +=(precio * cantidad);
                        }
                    %>
                    <td><%=totaldestacados%></td>
                    
                </tr>
                <%}%>
               
                 <%
                if(!infantil.contains("0") && !cantinfantil.contains("0")){
                  String sql = "Select * from libros where Idlibro='"+infantil+"'";
               ArrayList<Libros>listinfantil = BBDD.BD.consultadestacados(sql);
                for (Libros elem : listinfantil) {
            out.println("<script>");
            out.println("console.log('Portada: " + elem.getPortada() + "')");
            out.println("console.log('Título: " + elem.getTitulo() + "')");
            out.println("console.log('Cantidad: " + cantdestacados + "')");
            out.println("console.log('Precio: " + elem.getPrecio() + "')");
            out.println("</script>");
                    }

                %>
                <tr>
                    <%
                    for (Libros elem : listinfantil) {
                                       
                    %>
                    <td><img src="images/<%=elem.getPortada()%>.jpg"></td>
                    
                    <td><%=elem.getTitulo()%></td>
                    <%}%>
                    <td>${cantinfantil}</td>
                    <%
                     for (Libros elem : listinfantil) {
                    
                        double precio = elem.getPrecio();
                        int cantidad = Integer.parseInt(cantdestacados);
                        totalinfantil +=(precio * cantidad);
                        }
                    %>
                    <td><%=totalinfantil%></td>
                    
                </tr>
                <%}%>
                 <%
                if(!valorados.contains("0") && !cantvalorados.contains("0")){
                  String sql = "Select * from libros where Idlibro='"+valorados+"'";
               ArrayList<Libros>listvalorados = BBDD.BD.consultadestacados(sql); 
                 for (Libros elem : listvalorados) {
            out.println("<script>");
            out.println("console.log('Portada: " + elem.getPortada() + "')");
            out.println("console.log('Título: " + elem.getTitulo() + "')");
            out.println("console.log('Cantidad: " + cantdestacados + "')");
            out.println("console.log('Precio: " + elem.getPrecio() + "')");
            out.println("</script>");
                    }

                %>
                <tr>
                    <%
                    for (Libros elem : listvalorados) {
                                       
                    %>
                    <td><img src="images/<%=elem.getPortada()%>.jpg"></td>
                    
                    <td><%=elem.getTitulo()%></td>
                    <%}%>
                    <td>${cantvalorados}</td>
                    <%
                     for (Libros elem : listvalorados) {
                    
                        double precio = elem.getPrecio();
                        int cantidad = Integer.parseInt(cantdestacados);
                        totalvalorados +=(precio * cantidad);
                        }
                    %>
                    <td><%=totalvalorados%></td>
                    
                </tr>
                <%}%>
                 <%
                if(!vendidos.contains("0") && !cantvendidos.contains("0")){
                  String sql = "Select * from libros where Idlibro='"+vendidos+"'";
              ArrayList<Libros>Listvendidos = BBDD.BD.consultadestacados(sql);
                  for (Libros elem : Listvendidos) {
            out.println("<script>");
            out.println("console.log('Portada: " + elem.getPortada() + "')");
            out.println("console.log('Título: " + elem.getTitulo() + "')");
            out.println("console.log('Cantidad: " + cantdestacados + "')");
            out.println("console.log('Precio: " + elem.getPrecio() + "')");
            out.println("</script>");
                    }

                %>
                <tr>
                    <%
                    for (Libros elem : Listvendidos) {
                                       
                    %>
                    <td><img src="images/<%=elem.getPortada()%>.jpg"></td>
                    
                    <td><%=elem.getTitulo()%></td>
                    <%}%>
                    <td>${cantvendidos}</td>
                    <%
                     for (Libros elem : Listvendidos) {
                    
                        double precio = elem.getPrecio();
                        int cantidad = Integer.parseInt(cantdestacados);
                        totalvendidos +=(precio * cantidad);
                        }
                    %>
                    <td><%=totalvendidos%></td>
                    
                </tr>
                <%}%>
            </tbody>
            <tr>
                <td>Total:<%=totaldestacados+totalinfantil+totalvalorados+totalvendidos%></td>
            </tr>
            </form>
        </table>

    </body>
</html>
<%}%>