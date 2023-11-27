<%-- 
    Document   : TablaFormulario
    Created on : 14 nov. 2023, 12:26:30
    Author     : Andres
--%>

                
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            
        ArrayList<datosempresa> emp = (ArrayList<datosempresa>) getServletContext().getAttribute("emp");
        %>
    </head>
    <body>
        <table border="5px" align="center">
            <tr>
                <th>NºSS</th>
                <th>Apellido1 Apellido2</th>
                <th>Nombre</th>
                <th>CIF</th>
                <th>Empresa</th>
                <th>Descripcion</th>
                
            </tr>
            <%
            
            if(emp != null){
            
                for (datosempresa elem : emp) {
                        
                    
            
            
            %>
            <tr>
                <td><%= elem.getNss() %></td>
                <td><%= elem.getApellido1()%><%=elem.getApellido2()%></td>
                <td><%= elem.getNombre()%></td>
                <td><%= elem.getCif()%></td>
                <td><%= elem.getSocial()%></td>
                <td><%= elem.getTexto()%></td>
            </tr>
            <%}}%>
            <tr>
                <td><button> <a href="Formulario.jsp">Seguir añadiendo partes de accidente</a></button></td>
            </tr>
        </table>
    </body>
</html>
