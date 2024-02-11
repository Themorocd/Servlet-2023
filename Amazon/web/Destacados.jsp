<%-- 
    Document   : Destacados
    Created on : 30 ene. 2024, 9:51:53
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
            <form action="agregarcesta" method="POST">
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
                String sql = "Select * from libros where idcategoria = '1'";
                ArrayList<Libros>Listdestacados = BBDD.BD.consultadestacados(sql);
                
                %>
                <tr>
                    <td>Libros destacados de este mes</td>
                    <%
                    
                    for (Libros elem : Listdestacados) {
                
                    %>
                    <td><img src="images/<%=elem.getPortada()%>.jpg">
                </td>
                     <%}%>
                </tr>
               
                <tr>
                    <td><select name="destacados" id="destacados">
                            <%
                            for (Libros elem : Listdestacados) {
                                    
                                
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
                    <td><select name="cantdestacados" id="cantdestacados">
                            
                            <%
                            for (int x = 1; x < 10; x++) {
                        %>
                        <option value="<%=x%>"><%=x%></option>
                        <%
                            }
                        %>
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