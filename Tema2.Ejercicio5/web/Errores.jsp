<%-- 
    Document   : Errores
    Created on : 10 nov. 2023, 9:28:37
    Author     : Andres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            ServletContext contexto = request.getServletContext();
            String tipoerror = (String) contexto.getAttribute("tipoerror");

        %>
    </head>
    <body>
        <%            if (tipoerror.equals("errorcif")) {

        %>
        <h1>Error en el cif, intentelo de nuevo</h1>
        <%} else if (tipoerror.equals("errornif")) {

        %>

        <h1>Error en el nif, intentelo de nuevo</h1>
        <%} else if (tipoerror.equals("errortef")) {

        %>
        <h1>Error en el telefono, intentelo de nuevo</h1>
        <%}%>
        <a href="Formulario.jsp"><button>Volver</button></a>
    </body>
</html>
