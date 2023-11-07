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
        
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        
        if(user.equals("eso") && pass.equals("cdpjosecabreraeso")){
           contexto.setAttribute("user", user);
           
           rd= request.getRequestDispatcher("/Formulario.jsp");
           rd.forward(request, response);
        }
         if(user.equals("sanidad") && pass.equals("cdpjosecabrerasanidad")){
           contexto.setAttribute("user", user);
           
           rd= request.getRequestDispatcher("/Formulario.jsp");
           rd.forward(request, response);
        }
          if(user.equals("cocina") && pass.equals("cdpjosecabreracocina")){
           contexto.setAttribute("user", user);
            
           rd= request.getRequestDispatcher("/Formulario.jsp");
           rd.forward(request, response);
        }
           if(user.equals("informática") && pass.equals("cdpjosecabrerainformatica")){
           contexto.setAttribute("user", user);
           
           rd= request.getRequestDispatcher("/Formulario.jsp");
           rd.forward(request, response);
        }else{
               rd=request.getRequestDispatcher("/Error.html");
               rd.forward(request, response);
           }
        
    }

    
   

}
