<%-- 
    Document   : pedido
    Created on : 28 ene 2024, 14:01:47
    Author     : moro-
--%>

<%@page import="mod.pizza"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
 String nombreUsuario = (String) session.getAttribute("user");
if (nombreUsuario==null) {
    
    RequestDispatcher rd;
ServletContext contex=getServletContext();
    
    rd=contex.getRequestDispatcher("/index.html");
    rd.forward(request, response);
        
    } else {

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="5" align="center">
            <form action="pedidos" method="POST">
            <thead>
                <tr>
                    <th>TELEPIZZA</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Bienvenid@ ${user}<br><br>Ha acedido a nuestra zona de pedidos a las ${hora} del ${fecha}</td>
                    
                </tr>
                <%
                    String sql="SELECT * FROM pizzas WHERE idpizza='2'";
                    //String carne = "Amantes de la CARNE";
                //String sql="SELECT pizzas.nompizzas FROM pizzas JOIN tipo_pizza ON pizzas.idpizza = tipo_pizza.id WHERE tipo_pizza.descripcion ='"+carne+"'";
                
                ArrayList<pizza>Listcarne = BBDD.BD.consultacarne(sql);
                
                
                %>
                <tr>
                    
                    <td>Amantes de la carne:</td>
                    
                    <td><select name="carne" id="carne">
                            <%
                    
                    for (pizza elem : Listcarne) {
                    
                    %>
                            <option value="<%=elem.getNombre()%>"><%=elem.getNombre()%></option>
                        <%}%>
                        </select>
                    </td>
                   
                    <td><select name="cantcarne" id="cantcarne">
                            <option value="0">0</option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                        </select>
                    </td>
                </tr>
                <%
                
                
                String sql1="SELECT * FROM pizzas WHERE idpizza='3'";
                    //String carne = "Amantes de la CARNE";
                //String sql="SELECT pizzas.nompizzas FROM pizzas JOIN tipo_pizza ON pizzas.idpizza = tipo_pizza.id WHERE tipo_pizza.descripcion ='"+carne+"'";
                
                ArrayList<pizza>Listqueso = BBDD.BD.consultaqueso(sql1);
                
                
                %>
                 <tr>
                    <td>Los mas queseros:</td>
                    <td><select name="queso" id="queso">
                            <%
                            
                            for (pizza queso : Listqueso) {
                            
                            %>
                            <option value="<%=queso.getNombre()%>"><%=queso.getNombre()%></option>
                            <%}%>
                        </select>
                        
                    </td>
                    <td><select name="cantqueso" id="cantqueso">
                            <option value="0">0</option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                        </select>
                    </td>
                </tr>
                <%
                String sql2="SELECT * FROM pizzas WHERE idpizza='4'";
                    //String carne = "Amantes de la CARNE";
                //String sql="SELECT pizzas.nompizzas FROM pizzas JOIN tipo_pizza ON pizzas.idpizza = tipo_pizza.id WHERE tipo_pizza.descripcion ='"+carne+"'";
                
                ArrayList<pizza>Listclasi = BBDD.BD.consultaclasi(sql2);
                
                
                %>
                 <tr>
                    <td>Los clasicos</td>
                    <td><select name="clasi" id="clasi">
                              <%
                            
                            for (pizza clasi : Listclasi) {
                            
                            %>
                            <option value="<%=clasi.getNombre()%>"><%=clasi.getNombre()%></option>
                            <%}%>
                        </select>
                    </td>
                    <td><select name="cantclasi" id="cantclasi">
                            <option value="0">0</option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                        </select>
                    </td>
                </tr>
                <%
                String sql3="SELECT * FROM pizzas WHERE idpizza='6'";
                    //String carne = "Amantes de la CARNE";
                //String sql="SELECT pizzas.nompizzas FROM pizzas JOIN tipo_pizza ON pizzas.idpizza = tipo_pizza.id WHERE tipo_pizza.descripcion ='"+carne+"'";
                
                ArrayList<pizza>Listainfantil = BBDD.BD.consultainfantil(sql3);
                
                
                %>
                 <tr>
                    <td>Infantil:</td>
                    <td><select name="infantil" id="infantil">
                            <%
                            
                            for (pizza infantil : Listainfantil) {
                            
                            %>
                            <option value="<%=infantil.getNombre()%>"><%=infantil.getNombre()%></option>
                            <%}%>
                        </select>
                    </td>
                    <td><select name="cantinfantil" id="cantinfantil">
                            <option value="0">0</option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                        </select>
                    </td>
                </tr>
                 <%
                String sql4="SELECT * FROM pizzas WHERE idpizza='5'";
                    //String carne = "Amantes de la CARNE";
                //String sql="SELECT pizzas.nompizzas FROM pizzas JOIN tipo_pizza ON pizzas.idpizza = tipo_pizza.id WHERE tipo_pizza.descripcion ='"+carne+"'";
                
                ArrayList<pizza>Listagluten = BBDD.BD.consultagluten(sql4);
                
                
                %>
                 <tr>
                    <td>Sin gluten:</td>
                    <td><select name="gluten" id="gluten">
                            <%
                            
                            for (pizza gluten : Listagluten) {
                            
                            %>
                            <option value="<%=gluten.getNombre()%>"><%=gluten.getNombre()%></option>
                            <%}%>
                        </select>
                    </td>
                    <td><select name="cantgluten" id="cantgluten">
                            <option value="0">0</option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><input type="submit" value="confirmar pedido"></td>
                </tr>
            </tbody>
            </form>
        </table>

    </body>
</html>
<%}%>