/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.titulos;

/**
 *
 * @author Andres
 */
public class ServletBuscar extends HttpServlet {

    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext contex = getServletContext();
        RequestDispatcher rd;
        
        String id = request.getParameter("titulo").trim();
        
        
        
        
        contex.setAttribute("id", id);
        rd=request.getRequestDispatcher("listalibro.jsp");
        rd.forward(request, response);
    }

    

}
