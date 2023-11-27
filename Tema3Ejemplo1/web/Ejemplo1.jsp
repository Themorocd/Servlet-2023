<%-- 
    Document   : Ejemplo1
    Created on : 27 nov. 2023, 8:57:10
    Author     : Andres
--%>

<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo pag 10 tema 4</title>
    </head>
    <body>
        <%
        
            Date hoy  = new Date();
            DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM, Locale.getDefault());
        
        %>
        Fecha en castellano y con formato medio: <%=df.format(hoy)%><p>
        <hr>
        
        <%
        String alumno = request.getParameter("nombre");
        if(alumno == null){
        alumno = "mundo";
            
        
        %>
        Hola <font color="red"><b><%=alumno%></b></font>, como te va la vida<p>
        <hr>
            <%}%>
         <%
         out.println(getServletInfo());
         
         %>
    </body>
</html>
