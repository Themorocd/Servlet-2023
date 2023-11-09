<%-- 
    Document   : TablaFormulario
    Created on : 9 nov 2023, 18:14:03
    Author     : Andres
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Servlets.Empresa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            ServletContext contexto = request.getServletContext();
            ArrayList<Empresa> emp = (ArrayList<Empresa>) contexto.getAttribute("emp");
            String tipolista = (String) contexto.getAttribute("tipolista");
        %>
    </head>
    <body>
        <table border="5" width="1" cellspacing="1" align="center">
            <thead>
                <tr>
                    <th>Empresa</th>
                    <th>CIF</th>
                    <th>Representante</th>
                    <th>NIF</th>
                    <th>Sector</th>
                    <th>Telefono</th>
                    <th>E-mail</th>
                    <th>Volumen ventas anuales</th>
                    <th>Observaciones</th>
                </tr>
            </thead>
            <tbody>
                <%
                    if (emp != null) {

                        for (Empresa empre : emp) {

                            if (tipolista.equals("Todos")) {


                %>
                <tr>
                    <td><%=empre.getNombre()%></td>
                    <td><%=empre.getCif()%></td>
                    <td><%=empre.getRepresentante()%></td>
                    <td><%=empre.getNif()%></td>
                    <td><%=empre.getSector()%></td>
                    <td><%=empre.getTelefono()%></td>
                    <td><%=empre.getEmail()%></td>
                    <td><%=empre.getVentas()%></td>
                    <td><%=empre.getTexto()%></td>
                </tr>
                <%} else if (tipolista.equals("alimenticias") && empre.getSector().equals("alimentacion")) {

                %>
                <tr>
                    <td><%=empre.getNombre()%></td>
                    <td><%=empre.getCif()%></td>
                    <td><%=empre.getRepresentante()%></td>
                    <td><%=empre.getNif()%></td>
                    <td><%=empre.getSector()%></td>
                    <td><%=empre.getTelefono()%></td>
                    <td><%=empre.getEmail()%></td>
                    <td><%=empre.getVentas()%></td>
                    <td><%=empre.getTexto()%></td>
                </tr>
                <%} else if (tipolista.equals("Textil") && empre.getSector().equals("textil")) {

                %>
                <tr>
                    <td><%=empre.getNombre()%></td>
                    <td><%=empre.getCif()%></td>
                    <td><%=empre.getRepresentante()%></td>
                    <td><%=empre.getNif()%></td>
                    <td><%=empre.getSector()%></td>
                    <td><%=empre.getTelefono()%></td>
                    <td><%=empre.getEmail()%></td>
                    <td><%=empre.getVentas()%></td>
                    <td><%=empre.getTexto()%></td>
                </tr>
                <%} else if (tipolista.equals("restauracion") && empre.getSector().equals("transporte")) {

                %>
                <tr>
                    <td><%=empre.getNombre()%></td>
                    <td><%=empre.getCif()%></td>
                    <td><%=empre.getRepresentante()%></td>
                    <td><%=empre.getNif()%></td>
                    <td><%=empre.getSector()%></td>
                    <td><%=empre.getTelefono()%></td>
                    <td><%=empre.getEmail()%></td>
                    <td><%=empre.getVentas()%></td>
                    <td><%=empre.getTexto()%></td>
                </tr>
                <%} else if (tipolista.equals("salud") && empre.getSector().equals("medicina")) {

                %>
                <tr>
                    <td><%=empre.getNombre()%></td>
                    <td><%=empre.getCif()%></td>
                    <td><%=empre.getRepresentante()%></td>
                    <td><%=empre.getNif()%></td>
                    <td><%=empre.getSector()%></td>
                    <td><%=empre.getTelefono()%></td>
                    <td><%=empre.getEmail()%></td>
                    <td><%=empre.getVentas()%></td>
                    <td><%=empre.getTexto()%></td>
                </tr>
                <%}
                        }
                    }
                %>
            </tbody>

        </table>
        <div align="center">
            <a href="Formulario.jsp"><button>Seguir añadiendo Empresas</button></a>
            <a href="alimenticias"><button>Ver Empresas alimenticias</button></a>
            <a href="Textil"><button>Ver Empresas Textil</button></a>
            <a href="restauracion"><button>Ver Empresas Transporte</button></a>
            <a href="salud"><button>Ver Empresas de salud</button></a>
            <a href="Todos"><button>Ver todas</button></a>
        </div>

    </body>
</html>
