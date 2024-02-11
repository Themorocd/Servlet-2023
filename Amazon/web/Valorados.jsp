<%-- 
    Document   : Valorados
    Created on : 30 ene. 2024, 10:55:12
    Author     : Andres
--%>

<%@page import="modelo.Libros"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
 String nombreUsuario = (String) session.getAttribute("nombre");
 String apellidoUsuario = (String) session.getAttribute("apellido");
  ArrayList<Libros> listacompra;
 listacompra = (ArrayList<Libros>) session.getAttribute("listacompra");
  int carro = 0;
  if (listacompra != null) {
       carro += listacompra.size();
}
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
            <form action="agregarcestavalorados" method="POST">
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
                <%
                String sql = "Select * from libros where idcategoria = '4'";
                ArrayList<Libros>listvalorados = BBDD.BD.consultadestacados(sql); 
                session.setAttribute("listvalorados", listvalorados);
                %>
                <tr>
                    <td>Libros destacados de este mes</td>
                    <%
                    
                    for (Libros elem : listvalorados) {
                
                    %>
                    <td><img src="images/<%=elem.getPortada()%>.jpg">
                </td>
                     <%}%>
                </tr>
               
                <tr>
                    <td><select name="valorados" id="valorados">
                            <%
                            for (Libros elem : listvalorados) {
                                    
                                
                            %>
                            <option value="<%=elem.getIdlibro()%>"><%=elem.getTitulo()%></option>
                            <%}%>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Cantidad</td>
                </tr>
                <tr>
                    <td><select name="cantvalorados" id="cantvalorados">
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><input type="submit" value="Añadir a la cesta"></td>
                </tr>
            </tbody>
            </form>
        </table>

        
    </body>
</html>
<%}%>