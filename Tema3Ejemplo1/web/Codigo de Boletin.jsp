<%-- 
    Document   : Codigo de Boletin
    Created on : 27 nov. 2023, 9:46:16
    Author     : Andres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Boletin de noticias</h1>
        <ol>
            <li><jsp:include page="/Noticia1.html"/><hr><p>
            <li><jsp:include page="/Noticia2.html"/><hr><p>
                    
            <li><jsp:include page="/Noticia3.jsp">
                    <jsp:param name="origen" value="El Pais"/>
                </jsp:include><hr><p>
        </ol>
    </body>
</html>
