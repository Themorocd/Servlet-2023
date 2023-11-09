<%-- 
    Document   : TablaFormulario
    Created on : 7 nov 2023, 17:55:40
    Author     : Andres
--%>


<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.List"%>
<%@page import="Servlets.Actividades"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            ServletContext contexto = request.getServletContext();
            ArrayList<Actividades> actividade = (ArrayList<Actividades>) contexto.getAttribute("act");
            String tipolista = (String) contexto.getAttribute("tipolista");
            
        %>
    </head>
    <body>
        <table border="5" align="center">
            <thead>
                <tr>
                    <th>Fecha</th>
                    <th>Hora</th>
                    <th>Nombre de la actividad</th>
                    <th>Lugar de celebración</th>
                    <th>Personal de destino</th>
                    <th>Curso</th>
                    <th>Tipo de actividad</th>
                    <th>Dpto que lo organiza</th>
                    <th>Responsable</th>
                    <th>Observaciones</th>
                </tr>
            </thead>
            <tbody>
                <%
                    if (actividade != null) {
                        for (Actividades acti : actividade) {
                            Date date = inputFormat.parse(acti.getFecha()); // Convertir la fecha al formato de entrada
                            String formattedDate = outputFormat.format(date);

                            if (tipolista.equals("Todos")) {

                %>
                
                <tr>
                    <td><%= formattedDate %></td>
                    <td><%= acti.getHora()%></td>
                    <td><%= acti.getName()%></td>
                    <td><%= acti.getLugar()%></td>
                    <td><%= acti.getDestino()%></td>
                    <td><%= acti.getCurso()%></td>
                    <td><% for (String activ : acti.getActividad()) {%> <%= activ%> <%}%> </td>
                    <td><%= acti.getUsuario()%></td>
                    <td><%= acti.getProfe()%></td>
                    <td><%= acti.getTexto()%></td>
                </tr>

                <%} else if (tipolista.equals("profesorado") && acti.getDestino().equals("profesorado")) {%>
                <tr>
                    <td><%= formattedDate %></td>
                    <td><%= acti.getHora()%></td>
                    <td><%= acti.getName()%></td>
                    <td><%= acti.getLugar()%></td>
                    <td><%= acti.getDestino()%></td>
                    <td><%= acti.getCurso()%></td>
                    <td><% for (String activ : acti.getActividad()) {%> <%= activ%> <%}%> </td>
                    <td><%= acti.getUsuario()%></td>
                    <td><%= acti.getProfe()%></td>
                    <td><%= acti.getTexto()%></td>
                </tr>
                <%} else if (tipolista.equals("alumnado") && acti.getDestino().equals("alumnado")) {%>
                <tr>
                    <td><%= formattedDate %></td>
                    <td><%= acti.getHora()%></td>
                    <td><%= acti.getName()%></td>
                    <td><%= acti.getLugar()%></td>
                    <td><%= acti.getDestino()%></td>
                    <td><%= acti.getCurso()%></td>
                    <td><% for (String activ : acti.getActividad()) {%> <%= activ%> <%}%> </td>
                    <td><%= acti.getUsuario()%></td>
                    <td><%= acti.getProfe()%></td>
                    <td><%= acti.getTexto()%></td>
                </tr>

                <%}
                        }
                    }

                %>



            </tbody>

        </table>
        <div align="center">
            <a href="Formulario.jsp"><button>Seguir añadiendo actividades</button></a>
            <a href="alumnado"><button>Ver Actividades alumnados</button></a>
            <a href="profesorado"><button>Ver Actividades profesorado</button></a>
            <a href="Todos"><button>Ver Actividades de todos</button></a>
        </div>

    </body>
</html>
