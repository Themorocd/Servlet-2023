<%-- 
    Document   : Codigo de Colores
    Created on : 27 nov. 2023, 9:35:45
    Author     : Andres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
        <%
        String color = request.getParameter("color");
        String nombre = request.getParameter("nombre");
        
        if(nombre == null){

            
        
        %>
        <%@include file="/FormuColores.jsp" %>
        
        <%}else if(color.length()==0 || nombre.length()==0){%>
        <%@include file="/FormuColoresConAviso.jsp" %>
        
        <%}else{%>
       <body bgcolor="<%=color%>"> 
           <h2> Datos introducidos</h2>
           nombre: <font color="red"><%=nombre%></font><p>
               Color de fondo :<font color="red"><%=color%></font>
               <%}%>
    </body>
</html>
