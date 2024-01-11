<%-- 
    Document   : modificar
    Created on : 11 ene 2024, 19:12:34
    Author     : moro-
--%>

<%@page import="modelo.alumnos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% alumnos alu= (alumnos) getServletContext().getAttribute("alu");
        
        
        
        
        %>

        <table border="5" align="center">
            <tr>
                <th>Consulta de Alumnos</th>

            </tr>
            <table border="5" align="center">
                <form action="ServletModificar" method="POST">
                    <thead>
                        <tr>
                            <td>Nombre</td>
                            <td><input type="type" name="name" value="<%= alu.getNombre() %>" required></td>
                        </tr>
                        <tr>
                            <td>Apellidos</td>
                            <td><input type="type" name="apellido" value="<%= alu.getApellidos()%>" required></td>
                        </tr>
                        <tr>
                            <td>DAWES</td>
                            <td><input type="type" name="dawes" value="<%= alu.getDawes()%>" required></td>
                        </tr>
                        <tr>
                            <td>DAWEC</td>
                            <td><input type="type" name="dawec" value="<%= alu.getDawec()%>" required></td>
                        </tr>
                        <tr>
                            <td>DIW</td>
                            <td><input type="type" name="diw" value="<%= alu.getDiw()%>" required></td>
                        </tr>
                        <tr>
                            <td>DAW</td>
                            <td><input type="type" name="daw" value="<%= alu.getDaw()%>" required></td>
                        </tr>
                        <tr>
                            <td>FCT</td>
                            <td><input type="type" name="fct" value="<%= alu.getFct()%>" required></td>
                        </tr>
                        <tr>
                            <td>Proyecto</td>
                            <td><input type="type" name="proyecto" value="<%= alu.getProyecto()%>" required></td>
                        </tr>
                         <tr align="center">
                            <td><button type="submit" >Actualizar</button></td>
                        </tr>
                            
                    </thead>
                    

                       

                    

                </form>
            </table>
        </table>

    </body>
</html>

