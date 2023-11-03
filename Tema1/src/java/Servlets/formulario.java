/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andres
 */
public class formulario extends HttpServlet {

   
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
         String nom=request.getParameter("nom");
        String tef=request.getParameter("tel");
        String ciudad=request.getParameter("ciudad");
        
        
        response.setContentType("text/html");
        
        
        PrintWriter out=response.getWriter();
        
        out.println("<html>");
        out.println("<head><tittle></tittle></head>");
        out.println("<body>");
        out.println("<h1>DATOS</h1>");
        out.println("<table border=\"5\">");
        out.println("<tr><td><b>NOMBRE: </b></td><td><i>"+nom+"</i></td></tr>");
        out.println("<tr><td><b>TELEFONO: </b></td><td><i>"+tef+"</i></td></tr>");
        out.println("<tr><td><b>LUGAR NACIMIENTO: </b></td><td><i>"+ciudad+"</i></td></tr>");
        out.println("</table>");
        
        out.println("<br>");
        
         out.println("<h1>INFORMACION SOBRE LA PETICION</h1>");
         out.println("<b>Protocolo de la peticion: </b>"+request.getProtocol()+"<br>");
         out.println("<b>Nombre del cliente: </b>"+request.getRemoteHost()+"<br>");
         out.println("<b>Direccion ip del cliente: </b>"+request.getRemoteAddr()+"<br>");
         out.println("<b>Clave del usuario que realiza la peticion: </b>"+request.getRemoteUser()+"<br>");
         out.println("<b>Tipo de peticion: </b>"+request.getMethod()+"<br>");
         out.println("<b>Tipo MIME usado por el cliente: </b>"+request.getContentType()+"<br>");
         out.println("<b>Cadena de parametros de la peticion: </b>"+request.getQueryString()+"<br>");
         out.println("<b>URI de la peticion: </b>"+request.getRequestURI()+"<br>");
         out.println("<b>URL de la peticion: </b>"+request.getRequestURL()+"<br>");
         out.println("<b>Ruta URI del servlet: </b>"+request.getServletPath()+"<br>");
         out.println("<b>Nombre del servidor web que recibe la peticion: </b>"+request.getServerName()+"<br>");
         out.println("<b>Numero del puerto por el que el servidor acepta la conexion del cliente: </b>"+request.getServerPort()+"<br>");
         
        out.println("<br>");
        
       out.println("<table border=\"4\">");
       
        /*out.println("<tr><td><b>Host:</b></td><td><i>"+request.getHeader("host")+"</i></td></tr>");
        out.println("<tr><td><b>User-agent:</b></td><td><i>"+request.getHeader("user-agent")+"</i></td></tr>");
        out.println("<tr><td><b>Accept:</b></td><td><i>"+request.getHeader("accept")+"</i></td></tr>");
        out.println("<tr><td><b>Accept-language:</b></td><td><i>"+request.getHeader("accept-language")+"</i></td></tr>");
        out.println("<tr><td><b>Accept-charset:</b></td><td><i>"+request.getHeader("accept-charset")+"</i></td></tr>");
        out.println("<tr><td><b>Keep-alive:</b></td><td><i>"+request.getHeader("keep-alive")+"</i></td></tr>");
        out.println("<tr><td><b>Connection:</b></td><td><i>"+request.getHeader("connection")+"</i></td></tr>");
        out.println("<tr><td><b>Referer:</b></td><td><i>"+request.getHeader("referer")+"</i></td></tr>");
        out.println("<tr><td><b>Content-type:</b></td><td><i>"+request.getHeader("content-type")+"</i></td></tr>");
        out.println("<tr><td><b>Content-lenght:</b></td><td><i>"+request.getHeader("content-length")+"</i></td></tr>");
        */
        Enumeration e = request.getHeaderNames();//Esta línea obtiene todos los nombres de los encabezados de la solicitud HTTP y los almacena en un objeto Enumeration. Cada elemento de este Enumeration es el nombre de un encabezado.
        while(e.hasMoreElements()){//Este bucle while se ejecuta mientras hay más elementos en el Enumeration.
            
            String headerName = (String) e.nextElement();//Esta línea obtiene el siguiente nombre de encabezado de la solicitud y lo almacena en la variable headerName.
            String headerValue = request.getHeader(headerName);//Aquí se obtiene el valor del encabezado correspondiente al nombre del encabezado que acabamos de obtener. La función getHeader(String name) de HttpServletRequest se utiliza para obtener el valor de un encabezado específico.
            out.println("<tr><td><b>"+headerName+"</b></td><td><i>"+headerValue+"</i></td></tr>");/*Esta línea imprime el nombre y el valor del encabezado en una fila de una tabla HTML. El nombre se imprime en negrita (<b>) dentro de una celda de la tabla (<td>), 
            mientras que el valor se imprime en cursiva (<i>) dentro de otra celda de la tabla. La etiqueta <tr> representa una fila en la tabla.*/
            
        }
        
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
        
       
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
