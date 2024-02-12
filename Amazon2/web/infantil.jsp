<%-- 
    Document   : infantil
    Created on : 11 feb 2024, 18:45:01
    Author     : moro-
--%>

<%@page import="Modelo.Libros"%>
<%@page import="java.util.ArrayList"%>
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
                String sql = "Select * from libros where idcategoria = '3'";
                ArrayList<Libros>Listinfantil = BBDD.BD.consultadestacados(sql);
                
                %>
                <tr>
                    <td>Libros destacados de este mes</td>
                    <%
                    
                    for (Libros elem : Listinfantil) {
                
                    %>
                    <td><img src="images/<%=elem.getPortada()%>.jpg">
                </td>
                     <%}%>
                </tr>
               
                <tr>
                    <td><select name="idlibro" id="idlibro">
                            <%
                            for (Libros elem : Listinfantil) {
                                    
                                
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
                    <td><select name="cantidad" id="cantidad">
                            
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