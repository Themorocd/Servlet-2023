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
public class Calculadora extends HttpServlet {

    
  

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String num1 = request.getParameter("num1");
        String cuenta = request.getParameter("cuenta");
        String num2 = request.getParameter("num2");
        double total = 0; 
        
        if(cuenta.equals("suma")){
            total = Double.parseDouble(num1)+Double.parseDouble(num2);
        }
        if(cuenta.equals("resta")){
             total = Double.parseDouble(num1)-Double.parseDouble(num2);
        }
        if(cuenta.equals("multiplicar")){
            
            total = Double.parseDouble(num1)*Double.parseDouble(num2);
            
        }
        if(cuenta.equals("dividir")){
             total = Double.parseDouble(num1)/Double.parseDouble(num2);
        }
        
        
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html>");
        out.println("<head><title>Calculadora</title></head>");
        out.println("<body>");
        out.println("<h1>Datos introducidos</h1>");
        out.println("<table border=\"5\">");
        out.println("<tr><td><b>Numero 1:</b></td><td><i>"+num1+"</i></td></tr>");
        out.println("<tr><td><b>Operacion:</b></td><td><i>"+cuenta+"</i></td></tr>");
        out.println("<tr><td><b>Numero 2:</b></td><td><i>"+num2+"</i></td></tr>");
        out.println("<tr><td><b>Total:</b></td><td><i>"+total+"</i></td></tr>");
        out.println("</table><p>");
        out.println("</body>");
        out.println("</html>");
        
        
       
    }

   
   

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
