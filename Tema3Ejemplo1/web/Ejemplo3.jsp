<%-- 
    Document   : Ejemplo3
    Created on : 27 nov. 2023, 9:26:33
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
        <%!
        double num1=2,num2=3,num3=5.6;
        String nombre = "Jose";
        

        
        %>
        
        Hola, me llamo <%=nombre%> y los numeros a promediar son: <%=num1%>,<%=num2%> y <%=num3%>
        
        <%!
            public double media(double n1,double n2,double n3){
              return (n1+n2+n3)/3;
}
        
        
        %>
        <p>
            media = <%=media(num1,num2,num3)%>
    </body>
</html>
