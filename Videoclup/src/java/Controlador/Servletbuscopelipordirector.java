/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

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
 * @author moro-
 */
public class Servletbuscopelipordirector extends HttpServlet {

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        ServletContext contexto = getServletContext();
        RequestDispatcher rd;
        
        String nombre = request.getParameter("id");
        
          
        contexto.setAttribute("nombre", nombre);
        request.getRequestDispatcher("Listatitudirector.jsp").forward(request, response);
        
        
    }

    

}
