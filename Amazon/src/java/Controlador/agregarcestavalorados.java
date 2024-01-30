/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Andres
 */
public class agregarcestavalorados extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        
        String valorados = request.getParameter("valorados");
        String cantvalorados = request.getParameter("cantvalorados");
        
        if(valorados!=null && cantvalorados!=null){
            sesion.setAttribute("valorados", valorados);
            sesion.setAttribute("cantvalorados", cantvalorados);
            getServletContext().getRequestDispatcher("/confirmarañadidos.jsp").forward(request, response);
    
        }
        
        
        
        
        
        
        
        
        
        
    }

}
