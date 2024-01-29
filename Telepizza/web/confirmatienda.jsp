<%-- 
    Document   : confirmatienda
    Created on : 29 ene. 2024, 9:30:25
    Author     : Andres
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="mod.pizza"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
 String nombreUsuario = (String) session.getAttribute("user");
       String carne = (String) session.getAttribute("carne");
       String cantcarne = (String) session.getAttribute("cantcarne");
       String queso = (String) session.getAttribute("queso");
       String cantqueso = (String) session.getAttribute("cantqueso");
       String clasi = (String) session.getAttribute("clasi");
       String cantclasi = (String) session.getAttribute("cantclasi");
       String infantil = (String) session.getAttribute("infantil");
       String cantinfantil = (String) session.getAttribute("cantinfantil");
       String gluten = (String) session.getAttribute("gluten");
       String cantgluten = (String) session.getAttribute("cantgluten");
       double totalcarne=0;
       double totalqueso=0;
       double totalclasi=0;
       double totalinfantil=0;
       double totalgluten=0;
if (nombreUsuario==null) {
    
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
                    <th>Gracias</th>
                    
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>${user}, tu pedido ha sido tramitado a las ${hora} del ${fecha} y consta de los siguientes productos:</td>
                    
                </tr>
                <tr>
                    <td>Cantidad</td>
                    <td>Descripcion</td>
                    <td>Precio unidad</td>
                </tr>
                <%
                if(!carne.contains("0") && !cantcarne.contains("0")){
                
                String sql="SELECT * FROM pizzas WHERE nompizzas='"+carne+"'";
                ArrayList<pizza>Listcarne = BBDD.BD.consultacarne(sql);
                
                %>
                <tr>
                    <td>${cantcarne}</td>
                    <td>${carne}</td>
                    <%
                    for (pizza elem : Listcarne) {   
                    double precio = elem.getPrecio();
                    int cantidad = Integer.parseInt(cantcarne);
                    totalcarne += (precio * cantidad);
                       
                    %>
                    <td><%=elem.getPrecio()%></td>
                    <%}%>
                </tr>
                <%}%>
                <%
                 if(!queso.contains("0") && !cantqueso.contains("0")){
                String sql1="SELECT * FROM pizzas WHERE nompizzas='"+queso+"'";
                ArrayList<pizza>Listqueso = BBDD.BD.consultacarne(sql1);
                %>
                 <tr>
                    <td>${cantqueso}</td>
                    <td>${queso}</td>
                 <%
                    for (pizza elem : Listqueso) {
                    double precio = elem.getPrecio();
                    int cantidad = Integer.parseInt(cantqueso);
                    totalqueso += (precio * cantidad);
                    %>
                    <td><%=elem.getPrecio()%></td>
                    <%}%>
                </tr>
                <%}%>
                 <%
                 if(!clasi.contains("0") && !cantclasi.contains("0")){
                String sql2="SELECT * FROM pizzas WHERE nompizzas='"+clasi+"'";
                ArrayList<pizza>Listclasi = BBDD.BD.consultacarne(sql2);
                %>
                 <tr>
                    <td>${cantclasi}</td>
                    <td>${clasi}</td>
                    <%
                    for (pizza elem : Listclasi) {   
                    double precio = elem.getPrecio();
                    int cantidad = Integer.parseInt(cantclasi);
                    totalclasi += (precio * cantidad);
                    %>
                    <td><%=elem.getPrecio()%></td>
                    <%}%>
                </tr>
                <%}%>
                <%
                 if(!infantil.contains("0") && !cantinfantil.contains("0")){
                String sql3="SELECT * FROM pizzas WHERE nompizzas='"+infantil+"'";
                ArrayList<pizza>Listainfantil = BBDD.BD.consultacarne(sql3);
                %>
                 <tr>
                    <td>${cantinfantil}</td>
                    <td>${infantil}</td>
                    <%
                    for (pizza elem : Listainfantil) {      
                    double precio = elem.getPrecio();
                    int cantidad = Integer.parseInt(cantinfantil);
                    totalinfantil += (precio * cantidad);
                    %>
                    <td><%=elem.getPrecio()%></td>
                    <%}%>
                </tr>
                <%}%>
                 <%
                 if(!gluten.contains("0") && !cantgluten.contains("0")){
                String sql4="SELECT * FROM pizzas WHERE nompizzas='"+gluten+"'";
                ArrayList<pizza>Listagluten = BBDD.BD.consultacarne(sql4);
                %>
                 <tr>
                    <td>${cantgluten}</td>
                    <td>${gluten}</td>
                     <%
                    for (pizza elem : Listagluten) {   
                    double precio = elem.getPrecio();
                    int cantidad = Integer.parseInt(cantgluten);
                    totalgluten += (precio * cantidad);
                    %>
                    <td><%=elem.getPrecio()%></td>
                    <%}%>
                </tr>
                <%}%>
                
            </tbody>
            <tr>
                <td>Total Pedido:<%=totalcarne+totalclasi+totalgluten+totalinfantil+totalqueso  %></td>
            </tr>
            <tr>
                <td>aproximadamente en 30min podra recoger su pedido en el local</td>
            </tr>
        </table>

    </body>
</html>
<%}%>