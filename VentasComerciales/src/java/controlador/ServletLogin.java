/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

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
public class ServletLogin extends HttpServlet {

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ServletContext contexto = getServletContext();
        RequestDispatcher rd;
        
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        
        boolean compruebodatos = BBDD.BD.compruebouser(user,pass);

        if(!user.isEmpty() && !pass.isEmpty()){
              if(compruebodatos){
                  request.getRequestDispatcher("Gestion.jsp").forward(request, response);
              }else{
                  request.getRequestDispatcher("Error.jsp").forward(request, response);
                  
              }      
        }else{
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
        
    }

    
}
