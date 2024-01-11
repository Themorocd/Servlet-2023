<%-- 
    Document   : Gestion
    Created on : 11 ene 2024, 17:47:52
    Author     : moro-
--%>

<%@page import="modelo.alumnos"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        
        String sql = "SELECT * FROM alumnos";
        ArrayList<alumnos> lista = BBDD.BD.consultalistaalumnos(sql);
        
        
        
        %>
        
        <table border="5" align="center">
            <tr>
                <th>Listado de Alumnos de 2º de CFDAW</th>
                
            </tr>
        <table border="5" align="center">
            <form action="ServletBorrar" method="POST">
            <thead>
                <tr>
                    <th></th>
                    <th>Nombre</th>
                    <th>Apellidos</th>
                    <th>DAWES</th>
                    <th>DAWEC</th>
                    <th>DIW</th>
                    <th>DAW</th>
                    <th>FCT</th>
                    <th>Proyecto</th>
                    <th>Editar</th>
                    
                </tr>
            </thead>
            <%
            
            for (alumnos elem : lista) {
                    
                
            
            
            %>
            <tbody>
                <tr>
                    <td><input type="checkbox" name="sel" value="<%=elem.getNombre()%>"></td>
                    <td><%=elem.getNombre()%></td>
                    <td><%=elem.getApellidos()%></td>
                    <td><%=elem.getDawes()%></td>
                    <td><%=elem.getDawec()%></td>
                    <td><%=elem.getDiw()%></td>
                    <td><%=elem.getDaw()%></td>
                    <td><%=elem.getFct()%></td>
                    <td><%=elem.getProyecto()%></td>
                    <td><a href="modificar?nombre=<%=elem.getNombre()%> &apellidos=<%=elem.getApellidos()%>">Editar</a></td>
                <%}%>
                </tr>
                <tr align="center">
                    <td><button type="submit" >Borrar</button></td>
                </tr>

            </tbody>
            <tr>
                <td><a href="alta.jsp">Registrar nuevo usuario</a></td>
            </tr>
            </form>
        </table>
            </table>

    </body>
</html>
