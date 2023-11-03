/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andres
 */
public class servletabla extends HttpServlet {

   
  

    
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out= response.getWriter();
            
            try {
            String num = (String) getServletContext().getAttribute("numero_valido");
            int numero = Integer.parseInt(num);
            String col = (String) getServletContext().getAttribute("color_valido");
            
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Aplicacion J2EE de Andres Jose Marin Pascualvaca</title>");
            out.println("</head>");
            out.println("<body text="+col+">");
            out.println("<h1>Tabla de multiplicar del "+numero+"</h1>");
            out.println("<table border=\"1\">");
                for (int x = 1; x < 10; x++) {
                    out.println("<tr><td><b>"+numero+"</b></td><td><i>"+"x "+x+" = "+"</i></td><td><i>"+numero*x+"</i></td>");
                }
            out.println("</table><p>");
            out.println("</body>");
            out.println("</html>");
            
            
            
        } catch (Exception e) {
        }
    }

  

}
