<%-- 
    Document   : Errores
    Created on : 13 nov. 2023, 10:56:53
    Author     : Andres
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            ArrayList<String> error = (ArrayList<String>) getServletContext().getAttribute("tipoerror");
        %>
    </head>
    <body>
        <%
        if(error != null){
        
           for(String err : error){
           
            
        %>
        <div align="center">
            <ul>
            <li><%=err%></li>
            
        </ul>
            <%}}%>
        </div>
        
            <div align="center">
                <a href="Formulario.jsp"><button>Volver</button></a>
            </div>
            
    </body>
</html>
