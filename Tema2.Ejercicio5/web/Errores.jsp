<%-- 
    Document   : Errores
    Created on : 10 nov. 2023, 9:28:37
    Author     : Andres
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            ServletContext contexto = request.getServletContext();
            //String tipoerror = (String) contexto.getAttribute("tipoerror");
            List<String> errores = (List<String>) contexto.getAttribute("tipoerror");
            if(errores != null){
        %>
    </head>
    <body>

        <ul aling="center">
            <%                for (String error : errores) {


            %>
            <li><%=error%></li>
                <%}}%>
        </ul>


        <a href="Formulario.jsp"><button>Volver</button></a>
    </body>
</html>
