/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andres
 */
public class servlet1 extends HttpServlet {

   
   


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext contexto = getServletContext();
        RequestDispatcher rd;
        
        try {
            String numero = request.getParameter("num");
            String color = request.getParameter("color");
            
            int num = Integer.parseInt(numero);
            
            if(num>=1 && num<=9 && esValidoColor(color)){
                contexto.setAttribute("numero_valido", numero);
                contexto.setAttribute("color_valido", color);
                rd=contexto.getRequestDispatcher("/servletabla");
                rd.forward(request, response);
            }else{
                if(!esValidoColor(color)){
                    rd=contexto.getRequestDispatcher("/Errorcolor.html");
                    rd.forward(request, response);
                }else{
                    rd=contexto.getRequestDispatcher("/ErrorNumero.html");
                    rd.forward(request, response);
                }
            }
        } catch (NumberFormatException e) {
            rd=contexto.getRequestDispatcher("/ErrorNumero.html");
            rd.forward(request, response);
        }
    }

    public boolean esValidoColor(String color) {
        String[] colores = {"red","yellow","green","blue","pink","black","orange"};
        boolean encontrado = false;
        for (int x = 0; x < colores.length && !encontrado; x++) {
            if(colores[x].equalsIgnoreCase(color)){
                encontrado = true;
                
            }
            
        }
        return encontrado;
        
    }

    
  

}
