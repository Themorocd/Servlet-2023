<%-- 
    Document   : Jazz
    Created on : 13 feb 2024, 22:59:11
    Author     : moro-
--%>

<%@page import="modelo.Disco"%>
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
                    <td><a href="POP.jsp">POP-ROCK</a></td>
                    <td><a href="Cesta.jsp">Cesta</a></td>
                    
                </tr>
                <%
                
                String sql ="Select * from disco where idcategoria='3'";
                ArrayList<Disco> listajazz = BBDD.BD.consultacategoria(sql);
                
                %>
                <tr>
                    <td>Discos Clasicos</td>
                    <%
                    for (Disco elem : listajazz) {
                   
                    %>
                    <td><img src="images/<%=elem.getPortada()%>" width="200" height="200"/></td>
                    <%}%>
                </tr>
                <tr>
                    <td><select name="iddisco">
                            <%
                            for (Disco elem : listajazz) {
                           
                            %>
                            <option value="<%=elem.getIddisco()%>"><%=elem.getIddisco()%></option>
                            <%}%>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Cantidad</td>
                </tr>
                <tr>
                    <td><select name="cantidad">
                            <%
                            for (int x = 1; x < 10; x++) {
                                    
                                
                            
                            %>
                            <option value="<%=x%>"><%=x%></option>
                            <%}%>
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